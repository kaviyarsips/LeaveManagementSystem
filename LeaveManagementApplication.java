package com.organization.leavemanagement.main;

import java.time.LocalDate;
import java.util.Scanner;

import com.organization.leavemanagement.model.LeaveRequest;
import com.organization.leavemanagement.model.LeaveType;
import com.organization.leavemanagement.service.LeaveService;

public class LeaveManagementApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LeaveService leaveService = new LeaveService();

        while (true) {

            try {

                System.out.print("employeeId: ");
                String employeeId = sc.nextLine();

                System.out.print("leaveType (CASUAL/SICK/EARNED): ");
                LeaveType leaveType =
                        LeaveType.valueOf(
                                sc.nextLine().toUpperCase());

                System.out.print("numberOfDays: ");
                int numberOfDays =
                        Integer.parseInt(sc.nextLine());

                System.out.print("reason: ");
                String reason = sc.nextLine();

                LeaveRequest request =
                        new LeaveRequest(
                                employeeId,
                                leaveType,
                                numberOfDays,
                                reason,
                                LocalDate.now());

                leaveService.applyLeave(request);

                System.out.println(
                        "Leave applied for "
                                + employeeId
                                + " ("
                                + numberOfDays
                                + " days)");

            } catch (Exception e) {

                System.out.println(
                        "Failed to apply leave: "
                                + e.getMessage());
            }

            System.out.print(
                    "\nApply another leave? (Y/N): ");

            String choice = sc.nextLine();

            if (choice.equalsIgnoreCase("N")) {
                break;
            }
        }

        sc.close();
    }
}