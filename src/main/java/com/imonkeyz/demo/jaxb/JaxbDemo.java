package com.imonkeyz.demo.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jesse on 2017/6/13.
 */
public class JaxbDemo {
    public static void main(String[] args) throws Exception {

        Customer customer1 = new Customer("lv1", 1001);
        Customer customer2 = new Customer("lv2", 1002);
        Customer customer3 = new Customer("lv3", 1003);
        customer1.setCustomer(customer2);
        customer2.setCustomer(customer3);

        JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
        Marshaller marshaller = jaxbContext.createMarshaller();

        //output pretty printed
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(customer1,System.out);
        testEmployees();
    }

    private static void testEmployees() throws JAXBException {
        List<Employee> employees = new ArrayList<Employee>();
        Employee A = new Employee("AAA", 1001);
        Employee B = new Employee("BBB", 1002);
        Employee C = new Employee("CCC", 1003);
        employees.add(B);
        employees.add(C);
        A.setEmployees(employees);

        JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        //output pretty printed
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(A,System.out);
    }
}
