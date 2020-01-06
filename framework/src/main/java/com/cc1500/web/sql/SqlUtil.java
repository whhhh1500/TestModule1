package com.cc1500.web.sql;


import com.cc1500.web.core.text.Convert;
import com.cc1500.web.utils.StringUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * sql操作工具类
 * 
 * @author xingcloud
 */
public class SqlUtil
{
    /**
     * 仅支持字母、数字、下划线、空格、逗号（支持多个字段排序）
     */
    public static String SQL_PATTERN = "[a-zA-Z0-9_\\ \\,]+";

    /**
     * 检查字符，防止注入绕过
     */
    public static String escapeOrderBySql(String value)
    {
        if (StringUtils.isNotEmpty(value) && !isValidOrderBySql(value))
        {
            return StringUtils.EMPTY;
        }
        return value;
    }

    /**
     * 验证 order by 语法是否符合规范
     */
    public static boolean isValidOrderBySql(String value)
    {
        return value.matches(SQL_PATTERN);
    }


    public static void runInsert(String tableName)throws ClassNotFoundException, SQLException {
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // 加载JDBC驱动
        String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=e7_8120"; // 连接服务器和数据库sample
        String userName = "sa"; // 默认用户名
        String userPwd = "root123456"; // 密码
        Connection dbConn;
        Class.forName(driverName);
        dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
        String deleteSql="delete from OPENQUERY(MYDB, 'SELECT * FROM "+tableName+"') select * from "+tableName;
        String insertSql="insert into OPENQUERY(MYDB, 'SELECT * FROM "+tableName+"') select * from "+tableName;
        Statement s = dbConn.createStatement();
        s.execute(deleteSql);
        s.execute(insertSql);
        s.close();
        dbConn.close();
    }

    public static void runInsertTables(String tables)throws ClassNotFoundException, SQLException {
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // 加载JDBC驱动
        String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=e7_8120"; // 连接服务器和数据库sample
        String userName = "sa"; // 默认用户名
        String userPwd = "root123456"; // 密码
        String[] tableNames = Convert.toStrArray(tables);
        for (String tableName:tableNames) {
            Connection dbConn;
            Class.forName(driverName);
            dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
            String deleteSql="delete from OPENQUERY(MYDB, 'SELECT * FROM "+tableName+"') select * from "+tableName;
            String insertSql="insert into OPENQUERY(MYDB, 'SELECT * FROM "+tableName+"') select * from "+tableName;
            Statement s = dbConn.createStatement();
            s.execute(deleteSql);
            s.execute(insertSql);
            s.close();
            dbConn.close();
        }
    }
}
