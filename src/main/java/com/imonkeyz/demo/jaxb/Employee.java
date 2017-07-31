package com.imonkeyz.demo.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Jesse on 2017/6/13.
 */
@XmlRootElement
public class Employee {
    private List<Employee> employees;
    private String name;
    private int id;

    public Employee() {
    }

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    @XmlElement
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getName() {
        return name;
    }
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employees=" + employees +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
