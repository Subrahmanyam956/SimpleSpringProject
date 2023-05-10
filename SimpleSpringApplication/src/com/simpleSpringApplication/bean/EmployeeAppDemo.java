package com.simpleSpringApplication.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeAppDemo {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Employee employee = (Employee)context.getBean("employeeBean");
		System.out.println(" Employee Name : "+ employee.getName());
		((ConfigurableApplicationContext)context).close();
	}

}
