package com.school.motor.system.profile.generate;

import com.school.motor.system.annotation.Table;
import com.school.motor.system.entities.BaseEntity;
import com.school.motor.system.entities.quote.Skeleton;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;
import static com.school.motor.system.utils.StringUtil.*;

/**
 * 生成基类
 */
public abstract class Base {
    protected final SqlSessionFactory factory;
    protected String path; //路径
    protected String[] tables = new String[0];
    protected Set<String> imports; //包路径
    protected List<Skeleton> fields;
    protected BufferedWriter writer;
    protected List<Skeleton> methods;
    protected Map<String,Object> annotations; //类注解

    protected Base(SqlSessionFactory factory) {
        this.factory = factory;
        fields = new ArrayList<>();
        methods = new ArrayList<>();
        imports = new HashSet<>();
        annotations = new HashMap<>();
    }

    public void initialization(String path, String... tables) {
        this.path = path;
        this.tables = tables;
    }

    public void generate() throws SQLException, ClassNotFoundException, IOException {

        SqlSession session = factory.openSession();
        Connection connection = session.getConnection();
        Statement statement = connection.createStatement();

        DatabaseMetaData database = connection.getMetaData();

        for (String table : tables) {

            ResultSet columns = database.getTables(null, null,table, new String[] { "TABLE" });

            if (columns.next()) {
                String remark = columns.getString("REMARKS");
                Class<Table> c = Table.class;
                annotations.put(c.getSimpleName(),remark);
                imports.add(c.getPackageName() + "." + c.getSimpleName());
            }
            ResultSet set = statement.executeQuery("SELECT * FROM " + table);
            ResultSetMetaData data = set.getMetaData();

            int count = data.getColumnCount();

            for (int i = 1; i <= count; i++) { //获取列数据
                String name = toJava(data.getColumnName(i), "_");
                String type = data.getColumnClassName(i);
                Class<?> c = Class.forName(type);
                String uri = c.getPackageName();
                if (!uri.contains("java.lang") && !"createTime".equals(name)) { //如果是默认路径则不需要导包
                    imports.add(uri + "." + c.getSimpleName());
                }
                List<Field> collect = Arrays.stream(BaseEntity.class.getDeclaredFields())
                        .filter(field -> field.getName().equals(name))
                        .toList();
                if (collect.isEmpty()) {
                    fields.add(new Skeleton(name, "private", c));
                    Skeleton get = new Skeleton();
                    get.setReturnType(c);
                    get.setModifier("public");
                    get.setName("get" + titleCase(name));
                    Skeleton s = new Skeleton();
                    s.setModifier("public");
                    s.setName("set" + titleCase(name));
                    Map<String,Class<?>> map = new HashMap<>();
                    map.put(name,c);
                    s.setParameters(map);
                    methods.add(get);
                    methods.add(s);
                }
            }
            create(table);
            flush();
        }
    }
    public void flush() {
        this.methods.clear();
        this.fields.clear();
        this.imports.clear();
        this.annotations.clear();
    }
    protected abstract void create(String table) throws IOException;
}
