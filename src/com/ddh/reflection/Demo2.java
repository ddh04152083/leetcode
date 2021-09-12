package com.ddh.reflection;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

public class Demo2 {

    public static void main(String[] args) throws NoSuchFieldException {
        Class c1 = Student.class;
        Table table = (Table) c1.getAnnotation(Table.class);
        System.out.println(table.value());
        Field f = c1.getDeclaredField("name");
        Fields field = f.getAnnotation(Fields.class);
        System.out.println(field.columnName());
        System.out.println(field.length());
        System.out.println(field.type());

     }
     private void d(){
         try {
             this.wait();
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
}


@Table("t_student")
class Student {

    @Fields(columnName = "id", type = "bigint", length = 11)
    private int id;
    @Fields(columnName = "name", type = "varchar", length = 100)
    private String name;
    @Fields(columnName = "age", type = "varchar", length = 3)
    private String age;

}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Table {
    String value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Fields {

    String columnName();

    int length();

    String type();
}