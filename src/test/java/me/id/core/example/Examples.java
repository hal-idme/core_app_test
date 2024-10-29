package me.id.core.example;

import me.id.core.schema.Tables;
import org.jooq.DSLContext;
import org.jooq.Table;
import org.jooq.impl.DSL;
import org.junit.Test;

import java.sql.DriverManager;

public class Examples {

    private static String URL = "jdbc:postgresql://localhost:5432/idme_core";
    private static String USER = System.getProperty("user.name");

    @Test
    public void simpleExample() throws Exception {
        var conn = DriverManager.getConnection(URL, USER, "");
        var context = DSL.using(conn);

        var admins = context.selectFrom(Tables.COMMON_PASSWORDS).where(Tables.COMMON_PASSWORDS.ID.eq(33)).fetch();
        System.out.println(admins);
    }
}
