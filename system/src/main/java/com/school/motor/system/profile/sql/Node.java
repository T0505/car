package com.school.motor.system.profile.sql;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Node {
    private final int size = 2;
    private String[] columns = new String[size];
    private int index = 0;
    private final String label;
    Node(String label) {
        this.label = label;
    }
    boolean add(String[] fields) {
        try {
            for (String field : fields) {
                columns[index++] = field;
                if (columns.length == index) { //扩充 1.5倍
                    columns = Arrays.copyOf(columns, columns.length * 3 / 2);
                }
            }
            return true;
        } catch(Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    @Override
    public String toString() {
        String notion = switch(label) {
            case "WHERE" -> " AND ";
            default ->  ", ";
        };
        String[] array = Arrays.stream(columns).filter(Objects::nonNull).toArray(String[]::new);
        String args = String.join(notion, array);
        StringBuilder builder = new StringBuilder();
        if(!"()".equals(label)) {
            builder.append(label).append(" ").append(args);
            if(!args.isEmpty()) {
                builder.append(" ");
            }
        } else {
            builder.append("(").append(args).append(") ");
        }
        return builder.toString();
    }
}
