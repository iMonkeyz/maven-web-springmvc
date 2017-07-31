package com.imonkeyz.demo.controller;

import net.jawr.web.config.jmx.JawrApplicationConfigManager;
import net.jawr.web.config.jmx.JmxUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.management.*;
import javax.management.remote.JMXConnectorFactory;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.lang.management.ManagementFactory;

/**
 * Created by Jesse.Zhou on 2017/1/9 0009.
 */
@Controller
@RequestMapping(value = "/jawr")
public class JawrController {

    @RequestMapping(value = "/test")
    public String test(HttpServletRequest request) throws Exception {

        request.getSession().getServletContext().getAttribute("testobj");

        final ServletContext servletContext = request.getSession().getServletContext();
        final ObjectName aDefault = JmxUtils.getAppJawrConfigMBeanObjectName(servletContext, "default");
        System.out.println(aDefault);
        final boolean registered = ManagementFactory.getPlatformMBeanServer().isRegistered(aDefault);
        System.out.println("aDefault="+aDefault+", registered="+registered);

        final ObjectInstance instance = ManagementFactory.getPlatformMBeanServer().getObjectInstance(aDefault);

       /* MBeanServer mbs = ManagementFactory.getPlatformMBeanServer(); // 获取MBeanServer
        33         ObjectName name = new ObjectName("fjs:type=hello"); // 构造一个名字
        34         Hello hello = new Hello(); // 创建需要注册的对象
        35         mbs.registerMBean(hello, name); // 注册这个对象
        36
        37         mbs.setAttribute(name, new Attribute("Name", "bianjie"));　　//属性首字母必须大写
        38         mbs.invoke(name, "print", null, null);　　//第三个参数为Object[],为传入的参数值，第四个参数为String[],指明参数类型
        39         Thread.sleep(Long.MAX_VALUE);*/
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        final Object debugModeOn = mBeanServer.getAttribute(aDefault, "DebugModeOn");
        System.out.println("debugModeOn="+ debugModeOn);

        final MBeanInfo mBeanInfo = mBeanServer.getMBeanInfo(aDefault);
        final MBeanAttributeInfo[] attributes = mBeanInfo.getAttributes();
        for (MBeanAttributeInfo attribute : attributes) {
            System.out.println("attribute=" + attribute);
        }

        mBeanServer.setAttribute(aDefault, new Attribute("DebugModeOn","true"));
        mBeanServer.invoke(aDefault,"refreshConfig",null,null);
        return "jawr";
    }

    @RequestMapping(value = "/debug/on")
    public String debugModeOn(HttpServletRequest request) throws Exception {
        final ServletContext servletContext = request.getSession().getServletContext();

        setDebugMode(servletContext, true);

        return "redirect:/jawr.jsp";
    }

    @RequestMapping(value = "/debug/off")
    public String debugModeOff(HttpServletRequest request) throws Exception {
        final ServletContext servletContext = request.getSession().getServletContext();

        setDebugMode(servletContext, false);

        return "redirect:/jawr.jsp";
    }

    private void setDebugMode(ServletContext servletContext, boolean flag) throws InstanceNotFoundException, AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException {
        final ObjectName mb = JmxUtils.getAppJawrConfigMBeanObjectName(servletContext, "default");
        JmxUtils.getMBeanServer().setAttribute(mb, new Attribute("DebugModeOn", String.valueOf(flag)));
        JmxUtils.getMBeanServer().invoke(mb, "refreshConfig", null, null);
    }
}
