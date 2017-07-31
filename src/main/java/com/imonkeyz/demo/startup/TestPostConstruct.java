package com.imonkeyz.demo.startup;

import net.jawr.web.config.jmx.JmxUtils;
import net.jawr.web.util.ServletContextUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

/**
 * Created by Jesse.Zhou on 2017/1/11 0011.
 */
@Service
public class TestPostConstruct {
    private String name;

    public TestPostConstruct() {}

    public TestPostConstruct(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PostConstruct
    public void sayHi() {
        System.out.println(name);
        System.out.println("hi...................");
        try {
            WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
            ServletContext servletContext = webApplicationContext.getServletContext();
            System.out.println(servletContext);
        } catch (Exception e) {
            System.out.println("报错了...");
        }

    }
}
