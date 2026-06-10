package com.organization.leavemanagement.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.organization.leavemanagement.model.LeaveRequest;
import com.organization.leavemanagement.util.DBConnectionUtil;
public class LeaveRepository {
    public void saveLeaveRequest(
            LeaveRequest request)
            throws Exception {
        Connection con =
                DBConnectionUtil.getConnection();
        String query =
                "INSERT INTO leave_requests(employee_id, leave_type, number_of_days, reason, request_date) VALUES(?,?,?,?,?)";
        PreparedStatement ps =
                con.prepareStatement(query);
        ps.setString(
                1,
                request.getEmployeeId());
        ps.setString(
                2,
                request.getLeaveType().name());
        ps.setInt(
                3,
                request.getNumberOfDays());
        ps.setString(
                4,
                request.getReason());
        ps.setDate(
                5,
                java.sql.Date.valueOf(
                        request.getRequestDate()));
        ps.executeUpdate();

        con.close();
    }
}