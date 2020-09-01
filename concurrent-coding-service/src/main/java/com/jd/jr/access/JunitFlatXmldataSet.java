package com.jd.jr.access;/**
 * @author
 * @since 2020-06-19 17:51
 */

import java.sql.Connection;
import org.dbunit.database.*;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.ext.hsqldb.HsqldbDataTypeFactory;

/**
 * @ClassName JunitFlatXmldataSet.java
 * @author guojl
 * @version 1.0.0
 * @Description
 * @createTime 2020年06月19日 17:51:00
 */
public class JunitFlatXmldataSet {

    public static void printOutTableContents(Connection sqlConnection, String... tableNames) throws Exception {
        for (String tableName : tableNames) {
            System.out.println("The contents of table: " + tableName);
            IDatabaseConnection connection = new DatabaseConnection(sqlConnection);
            DatabaseConfig config = connection.getConfig();
            config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new HsqldbDataTypeFactory());
            QueryDataSet outputSet = new QueryDataSet(connection);
            outputSet.addTable(tableName);
            FlatXmlDataSet.write(outputSet, System.out);
        }
    }
}
