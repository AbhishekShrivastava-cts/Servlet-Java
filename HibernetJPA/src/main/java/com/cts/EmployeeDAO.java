package com.cts;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cts.Employee;

public class EmployeeDAO {
public static void main(String[] args) {
	 EntityManagerFactory factory = Persistence.createEntityManagerFactory("UsersDB");
     EntityManager entityManager = factory.createEntityManager();
      
     entityManager.getTransaction().begin();
      
     Employee newUser3 = new Employee();
    
    newUser3.setName("Alok");
     newUser3.setDepartment("java tester");
     newUser3.setEmail("alok.raj@cognizant.com");
     entityManager.persist(newUser3);
     
     
    
    System.out.println(newUser3.getEmp_Id());
    System.out.println(newUser3.getName());
    System.out.println(newUser3.getEmail());
    System.out.println(newUser3.getDepartment());
    
     
     entityManager.getTransaction().commit();
      
     entityManager.close();
     factory.close();
}
}
