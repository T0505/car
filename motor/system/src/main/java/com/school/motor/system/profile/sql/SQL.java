package com.school.motor.system.profile.sql;

import com.school.motor.system.utils.StringUtil;

import java.util.*;
import static com.school.motor.system.utils.StringUtil.toDatabase;

/**
 * author T
 * 动态sql概述:
 *  本类用来动态生成sql,默认值为1个每次扩大1.5倍
 *  map:指令存储器
 *  size:默认大小
 */
public class SQL {
    //有序数组,存储指令
    private final Map<Integer,Node> instruct = new TreeMap<>();
    protected void SELECT(String ...columns) {
        add(1,"SELECT",columns);
    }
    protected void FROM(String ...tables) {
        add(2,"FROM",tables);
    }
    protected void WHERE(String ...joins) {
        String[] array = Arrays.stream(joins).map(item -> toDatabase(item) + "=#{" + item + "}").toArray(String[]::new);
        add(3,"WHERE", array);
    }
    protected void WHERES(String ...joins) {
        add(3,"WHERE", joins);
    }
    protected void INSERT(String table,String ...columns) {
        add(1,"INSERT INTO",table);
        add(2,"()", Arrays.stream(columns).map(StringUtil::toDatabase).toArray(String[]::new));
    }
    protected void VALUE(String ...columns) {
        add(3,"VALUE",null);
        add(4,"()",columns);
    }
    protected void UPDATE(String table,String ...columns) {
        add(1,"UPDATE",table);
        add(2,"SET", Arrays.stream(columns).map(item -> toDatabase(item) + "=#{"+item+"}").toArray(String[]::new));
        WHERE("id");
    }
    protected void DELETE(String table,String column) {
        add(1,"DELETE FROM",table);
        WHERE(column);
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        instruct.values().forEach(builder::append);
        return builder.toString().trim();
    }
    private void add(int order,String label,String ...columns) {
        Node node = instruct.get(order);
        if(node == null) {
            node = new Node(label);
        }
        boolean add = node.add(columns);
        instruct.putIfAbsent(order,node);
    }
}
