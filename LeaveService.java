package com.organization.leavemanagement.service;

import com.organization.leavemanagement.exception.EmployeeNotFoundException;
import com.organization.leavemanagement.exception.InsufficientLeaveBalanceException;
import com.organization.leavemanagement.exception.InvalidLeaveRequestException;
import com.organization.leavemanagement.model.Employee;
import com.organization.leavemanagement.model.LeaveRequest;
import com.organization.leavemanagement.model.LeaveType;
import com.organization.leavemanagement.repository.EmployeeRepository;
import com.organization.leavemanagement.repository.LeaveRepository;
import com.organization.leavemanagement.util.ValidationUtil;

public class LeaveService {

    private EmployeeRepository employeeRepository =
            new EmployeeRepository();

    private LeaveRepository leaveRepository =
            new LeaveRepository();

    public void applyLeave(
            LeaveRequest request)
            throws Exception {

        ValidationUtil.validateReason(
                request.getReason());

        ValidationUtil.validateLeaveDays(
                request.getNumberOfDays());

        Employee employee =
                employeeRepository.getEmployeeById(
                        request.getEmployeeId());

        if (employee == null) {

            throw new EmployeeNotFoundException(
                    "Employee not found");
        }

        if (request.getNumberOfDays()
                > employee.getLeaveBalance()) {

            throw new InsufficientLeaveBalanceException(
                    "Insufficient leave balance");
        }

        if (request.getLeaveType()
                == LeaveType.SICK
                && request.getNumberOfDays() > 5) {

            throw new InvalidLeaveRequestException(
                    "Maximum 5 consecutive sick leave days allowed");
        }

        if (employee.getTotalLeaveUsed()
                + request.getNumberOfDays()
                > 20) {

            throw new InvalidLeaveRequestException(
                    "Annual leave limit exceeded");
        }

        employee.setLeaveBalance(
                employee.getLeaveBalance()
                        - request.getNumberOfDays());

        employee.setTotalLeaveUsed(
                employee.getTotalLeaveUsed()
                        + request.getNumberOfDays());

        employeeRepository.updateLeaveBalance(
                employee.getEmployeeId(),
                employee.getLeaveBalance());

        employeeRepository.updateTotalLeaveUsed(
                employee.getEmployeeId(),
                employee.getTotalLeaveUsed());

        leaveRepository.saveLeaveRequest(
                request);
    }
}