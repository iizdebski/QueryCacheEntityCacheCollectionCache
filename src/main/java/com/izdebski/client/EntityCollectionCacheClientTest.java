package com.izdebski.client;

import java.util.List;

import com.izdebski.entities.Department;
import com.izdebski.entities.Employee;
import com.izdebski.util.HibernateUtil;
import org.hibernate.Session;

public class EntityCollectionCacheClientTest {

    public static void main(String[] args) throws Exception {
        Session session = null;
        try {
            // Get Department from DATABASE
            System.out.println("Get Department from DATABASE::::::::::::::");
            Long deptId = 1L;
            session = HibernateUtil.getSessionFactory().openSession();
            Department department = session.get(Department.class, deptId);
            System.out.println("Department Name:" + department.getDeptName());
            List<Employee> employees = department.getEmployees();
            for (Employee employee : employees) {
                System.out.println("Employee Name : " + employee.getEmployeeName());
                System.out.println("Employee UserName : " + employee.getUsername());
                System.out.println("Employee Passsword : " + employee.getPassword());
                System.out.println("Employee AccessLevel : " + employee.getAccessLevel());

                System.out.println("--------------------------------------------------------------");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }

        try {

            // Get Department from Cache
            System.out.println("Get Department from Cache::::::::::::::");
            Long deptId = 1L;
            session = HibernateUtil.getSessionFactory().openSession();
            Department department = session.get(Department.class, deptId);
            System.out.println("Department Name:" + department.getDeptName());
            List<Employee> employees = department.getEmployees();
            for (Employee employee : employees) {
                System.out.println("Employee Name : " + employee.getEmployeeName());
                System.out.println("Employee UserName : " + employee.getUsername());
                System.out.println("Employee Passsword : " + employee.getPassword());
                System.out.println("Employee AccessLevel : " + employee.getAccessLevel());

                System.out.println("--------------------------------------------------------------");
            }

        } catch (Exception e) {
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}