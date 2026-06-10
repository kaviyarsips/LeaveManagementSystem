package com.organization.leavemanagement.model;
public class Employee {
    private String employeeId;
    private String name;
    private int leaveBalance;
    private int totalLeaveUsed;
    public Employee(String employeeId,
                    String name,
                    int leaveBalance,
                    int totalLeaveUsed) {

        this.employeeId = employeeId;
        this.name = name;
        this.leaveBalance = leaveBalance;
        this.totalLeaveUsed = totalLeaveUsed;
    }
    public String getEmployeeId() {
        return employeeId;
    }
    public String getName() {
        return name;
    }
    public int getLeaveBalance() {
        return leaveBalance;
    }

    public int getTotalLeaveUsed() {
        return totalLeaveUsed;
    }

    public void setLeaveBalance(int leaveBalance) {
        this.leaveBalance = leaveBalance;
    }

    public void setTotalLeaveUsed(int totalLeaveUsed) {
        this.totalLeaveUsed = totalLeaveUsed;
    }
}