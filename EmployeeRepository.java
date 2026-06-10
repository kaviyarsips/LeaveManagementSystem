package com.organization.leavemanagement.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.organization.leavemanagement.model.Employee;
import com.organization.leavemanagement.util.DBConnectionUtil;

public class EmployeeRepository {

    public Employee getEmployeeById(String employeeId)
            throws Exception {

        Connection con =
                DBConnectionUtil.getConnection();

        String query =
                "SELECT * FROM employee WHERE employee_id = ?";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setString(1, employeeId);

        ResultSet rs =
                ps.executeQuery();

        Employee employee = null;

        if (rs.next()) {

            employee = new Employee(
                    rs.getString("employee_id"),
                    rs.getString("name"),
                    rs.getInt("leave_balance"),
                    rs.getInt("total_leave_used"));
        }

        con.close();

        return employee;
    }

    public void updateLeaveBalance(
            String employeeId,
            int newBalance)
            throws Exception {

        Connection con =
                DBConnectionUtil.getConnection();

        String query =
                "UPDATE employee SET leave_balance = ? WHERE employee_id = ?";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setInt(1, newBalance);
        ps.setString(2, employeeId);

        ps.executeUpdate();

        con.close();
    }

    public void updateTotalLeaveUsed(
            String employeeId,
            int totalLeaveUsed)
            throws Exception {

        Connection con =
                DBConnectionUtil.getConnection();

        String query =
                "UPDATE employee SET total_leave_used = ? WHERE employee_id = ?";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setInt(1, totalLeaveUsed);
        ps.setString(2, employeeId);

        ps.executeUpdate();

        con.close();
    }
}