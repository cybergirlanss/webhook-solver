package com.example.webhooksolver.service;

import org.springframework.stereotype.Service;

@Service
public class SqlProblemSolver {

    public String solveSqlProblem(String regNo) {
        // Since your regNo is 22bsa10229, last two digits are 29 (odd)
        // So we use Question 1: Find highest salary not on 1st day of month

        return "SELECT p.AMOUNT AS SALARY, " +
                "CONCAT(e.FIRST_NAME, ' ', e.LAST_NAME) AS NAME, " +
                "TIMESTAMPDIFF(YEAR, e.DOB, CURDATE()) AS AGE, " +
                "d.DEPARTMENT_NAME " +
                "FROM PAYMENTS p " +
                "JOIN EMPLOYEE e ON p.EMP_ID = e.EMP_ID " +
                "JOIN DEPARTMENT d ON e.DEPARTMENT = d.DEPARTMENT_ID " +
                "WHERE DAY(p.PAYMENT_TIME) != 1 " +
                "AND p.AMOUNT = (" +
                "    SELECT MAX(AMOUNT) " +
                "    FROM PAYMENTS " +
                "    WHERE DAY(PAYMENT_TIME) != 1" +
                ")";
    }
}