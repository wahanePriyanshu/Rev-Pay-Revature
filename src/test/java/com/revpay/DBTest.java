package com.revpay;

import java.sql.Connection;
import com.revpay.util.DBUtil;

public class DBTest {

    public static void main(String[] args) {
        try (Connection con = DBUtil.getConnection()) {
            System.out.println("Database connected successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
