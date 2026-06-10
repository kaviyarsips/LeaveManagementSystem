package com.organization.leavemanagement.util;

import com.organization.leavemanagement.exception.InvalidLeaveRequestException;

public class ValidationUtil {

    public static void validateReason(String reason)
            throws InvalidLeaveRequestException {

        if (reason == null || reason.trim().isEmpty()) {
            throw new InvalidLeaveRequestException(
                    "Reason cannot be null or blank");
        }
    }

    public static void validateLeaveDays(int days)
            throws InvalidLeaveRequestException {

        if (days <= 0) {
            throw new InvalidLeaveRequestException(
                    "Leave days must be greater than 0");
        }
    }
}