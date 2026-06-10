package com.organization.leavemanagement.main;

import java.sql.Connection;

import com.organization.leavemanagement.util.DBConnectionUtil;

public class TestConnection {

    public static void main(String[] args) {

        try {

            Connection con =
                    DBConnectionUtil.getConnection();

            System.out.println(
                    "Database Connected Successfully");

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}