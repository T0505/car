package com.school.motor.system.utils;

import com.school.motor.system.annotation.Table;
import com.school.motor.system.entities.BaseEntity;
import net.sourceforge.pinyin4j.PinyinHelper;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * author T
 */
public class StringUtil {
    //转数据库字段
    public static String toDatabase(String property) {
        String replace = property.trim().replaceAll("[A-Z]", "_$0").toLowerCase();
        if(Character.isUpperCase(property.charAt(0))) {
            return replace.substring(1);
        }
        return replace;
    }
    //转java驼峰
    public static String toJava(String column,String symbol) {
        String[] words = column.split(symbol);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if(i != 0) {
                builder.append(words[i].substring(0, 1).toUpperCase()).append(words[i].substring(1));
            } else {
                builder.append(words[i]);
            }
        }
        return builder.toString();
    }
    //合并字符串
    public static String merge(Object ...os) {
        StringBuilder builder = new StringBuilder();
        Arrays.stream(os).forEach(builder::append);
        return builder.toString();
    }
    //首字母大写
    public static String titleCase(String value) {
        return String.valueOf(value.charAt(0)).toUpperCase() + value.substring(1);
    }
    //获取拼音字符
    private static String getLetterToUpper(String name,String principle) {
        String[] title = new String[principle.length()];
        String join = principle +name;
        if (join.matches("[\\u4e00-\\u9fa5]+")) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < join.length(); i++) {
                String string = PinyinHelper.toHanyuPinyinStringArray(join.charAt(i))[0];
                sb.append(string, 0, string.length() - 1);
                if(i < principle.length()) {
                    title[i] = String.valueOf(string.charAt(0));
                }
            }
            return String.join("", title) + sb.toString().toUpperCase();
        }
        return join;
    }

    /**
     * 获取编号
     * @param name 标识名称
     * @param c 实体类对应数据库表
     * @return 生成编号
     * @param <T> 实现类
     */
    public static <T extends BaseEntity> String get(String name, Class<T> c) {

        Table table = c.getAnnotation(Table.class);
        if(table != null) {
            Random random = new Random();
            long time = new Date().getTime();
            String repeat = "_".repeat(random.nextInt(5)),value = table.value(); //生成下划线
            char[] array = (getLetterToUpper(name,value).toUpperCase() + time + repeat).toCharArray();
            for (int i = value.length(); i < array.length; i++) {
                int index = random.nextInt(array.length - value.length()) + value.length();
                if (index != 0) {
                    char temp = array[i];
                    array[i] = array[index];
                    array[index] = temp;
                }
            }
            String string = String.copyValueOf(array);
            return string.charAt(string.length() - 1) == '_' ? string.substring(0, string.length() - 1) : string;
        }
        throw new RuntimeException(c.getSimpleName() + "表标识不能为空");
    }
    //验证码
    public static String getCode(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append((int)(Math.random() * 10));
        }
        return builder.toString();
    }
}
