package com.school.motor.system.profile.sql;

import com.school.motor.system.entities.BaseEntity;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static com.school.motor.system.utils.StringUtil.titleCase;
import static com.school.motor.system.utils.StringUtil.toDatabase;
/**
 * author T
 * CompletableFuture.runAsync
 * @param <T>
 */
public class Provider<T extends BaseEntity> {
    public String select(String table,Map<String,Object> map,String ...columns) {
        String string = new SQL() { //动态sql
            {
                if (columns.length == 0) {
                    SELECT("*");
                } else {
                    SELECT(columns);
                }
                FROM(toDatabase(table));
                if (map != null) { //遍历参数，布局条件
                    WHERES(map.keySet().stream().map(item -> {
                        Object o = map.get(item);
                        String database = toDatabase(item);
                        if (o instanceof List<?> array) { //数组
                            if (array.size() == 2) {
                                return String.format("%s BETWEEN '%s' AND '%s'", database, array.get(0), array.get(1));
                            } else {
                                String args = array.stream().map(Object::toString).collect(Collectors.joining(","));
                                return database + "(" + args + ")";
                            }
                        } else if (o.toString().matches("\\d+")) {
                            return database + "=" + o;
                        } else {
                            return database + " LIKE '%"+o+"%'";
                        }
                    }).toArray(String[]::new));
                }
            }
        }.toString();
        System.err.println(string);
        return string;
    }

    public String insert(T t) {
        String string = new SQL() {
            {
                Class<? extends BaseEntity> c = t.getClass();
                List<String> fields = Arrays.stream(c.getDeclaredFields()).filter(field -> {
                    try {
                        if(!"serialVersionUID".equals(field.getName())) { //去除标识ID
                            Method method = c.getMethod("get" + titleCase(field.getName()));
                            return method.invoke(t) != null;
                        }
                        return false;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }).map(Field::getName).toList(); //去除空值
                String[] columns = Arrays.stream(get(c)).filter(fields::contains).toArray(String[]::new);
                INSERT(toDatabase(c.getSimpleName()), columns);
                VALUE(Arrays.stream(columns).map(item -> "#{" + item + "}").toArray(String[]::new));
            }
        }.toString();
        System.err.println(string);
        return string;
    }
    public String delete(String table,String column) {
        String string = new SQL() {
            {
                DELETE(toDatabase(table), column);
            }
        }.toString();
        System.err.println(string);
        return string;
    }

    public String update(T t) {
        String string = new SQL() {
            {
                Class<? extends BaseEntity> c = t.getClass();
                UPDATE(toDatabase(c.getSimpleName()), get(c));
            }
        }.toString();
        System.err.println(string);
        return string;
    }
    private String[] get(Class<?> c) {
        return Arrays.stream(c.getDeclaredFields())
                .map(Field::getName)
                .filter(name -> !"serialVersionUID".equals(name))
                .toArray(String[]::new);
    }
}
