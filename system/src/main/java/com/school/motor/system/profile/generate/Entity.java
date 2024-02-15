package com.school.motor.system.profile.generate;

import com.school.motor.system.entities.quote.Skeleton;
import org.apache.ibatis.session.SqlSessionFactory;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serial;
import java.util.Date;
import java.util.Map;
import static com.school.motor.system.utils.StringUtil.*;

public final class Entity extends Base{

    private int indent;
    public Entity(SqlSessionFactory factory) {
        super(factory);
    }
    public void create(String table) throws IOException {
        indent = 0;
        table = toJava(titleCase(table),"_");
        StringBuilder builder = new StringBuilder("package ");
        try {
            writer = new BufferedWriter(new FileWriter(path + "/" + table + ".java"));
            String uri = path.substring(path.indexOf("com")).replace("/",".");
            builder.append(uri).append(";\n\n");
            imports.add(Serial.class.getPackageName() +"."+ Serial.class.getSimpleName());
            imports.forEach(item -> builder.append(row("import",item)));
            annotations.forEach((key,value) -> builder.append("@").append(titleCase(key)).append("(\"").append(value).append("\")\n"));
            builder.append("public class ").append(table).append(" extends BaseEntity{\n");
            builder.append("\t@Serial\n");
            builder.append("\tprivate final static long serialVersionUID=").append(new Date().getTime()).append("L;\n");
            indent++;
            for (Skeleton field : fields) {
                String type = field.getType().getSimpleName();
                String name = field.getName();
                builder.append(row(field.getModifier(),type,name));
            }
            add(builder);
            builder.append("\t@Override\n").append("\tpublic String toString() {\n");
            String[] args = fields.stream().map(field -> field.getName() + "=\"+" + field.getName() + "+\"").toArray(String[]::new);
            builder
                    .append("\t\treturn ")
                    .append("\"")
                    .append(table)
                    .append("{")
                    .append(String.join(",", args))
                    .append("}\";\n")
                    .append("\t}\n")
                    .append("}");
            writer.write(builder.toString());
        } finally {
            writer.close();
        }
    }
    public String row(String ...values) {
        StringBuilder builder = new StringBuilder("\t".repeat(indent));
        for (int i = 0; i < values.length; i++) {
            builder.append(values[i]);
            if(i != values.length - 1) {
                builder.append(" ");
            }
        }
        builder.append(";\n");
        return builder.toString();
    }
    public void add(StringBuilder builder) {
        for (Skeleton method : methods) {
            builder
                    .append("\t".repeat(indent))
                    .append(method.getModifier())
                    .append(" ")
                    .append(method.getReturnType().getSimpleName())
                    .append(" ")
                    .append(method.getName())
                    .append("(");
            Map<String, Class<?>> parameters = method.getParameters();
            parameters.forEach((key,value) -> builder.append(value.getSimpleName()).append(" ").append(key).append(","));
            if(!parameters.isEmpty()) {
                builder.deleteCharAt(builder.length() - 1);
            }
            builder.append("){\n");
            indent++;
            String name = method.getName().substring(3);
            String field = String.valueOf(name.charAt(0)).toLowerCase() + name.substring(1);
            builder.append("\t".repeat(indent));
            if(method.getReturnType() != void.class) {
                builder
                        .append("return this.")
                        .append(field)
                        .append(";\n");
            } else {
                builder.append("this.").append(field).append("=").append(field).append(";\n");
            }
            indent--;
            builder.append("\t".repeat(indent)).append("}\n");
        }
    }
}
