package com.example;
import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class dbGennerator {
    public static void main(String args[]) throws Exception{

        Schema schema = new Schema(1,"com.example");
        createTable(schema, "History");

        new DaoGenerator().generateAll(schema, "../testGreenDao2/app/src/main/java-gen");
    }

    private static void createTable(Schema schema, String tableName){
        //实体关联数据库的表,表名是tableName;
        Entity history = schema.addEntity(tableName);
        //设置字段
        history.addIdProperty();
        history.addStringProperty("message_id").notNull().unique();
        history.addStringProperty("message");

    }

}
