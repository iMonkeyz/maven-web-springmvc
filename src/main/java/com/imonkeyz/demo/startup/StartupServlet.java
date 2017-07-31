package com.imonkeyz.demo.startup;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by Jesse.Zhou on 2017/1/11 0011.
 */
public class StartupServlet extends GenericServlet {

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet init.................");
    }
}
