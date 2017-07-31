package com.imonkeyz.demo.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Jesse on 2017/6/13.
 */
@XmlRootElement
public class Customer {

    private Customer customer;

    private String name;

    private int id;

    public Customer() {
    }

    public Customer(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }
    @XmlElement
    public void setCustomer(Customer customer) {
        this.customer = customer;
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
        return "Customer{" +
                "customer=" + customer +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
