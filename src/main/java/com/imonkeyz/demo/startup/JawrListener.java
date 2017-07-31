package com.imonkeyz.demo.startup;

import net.jawr.web.config.jmx.JmxUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.ServletContextAware;

import javax.management.*;
import javax.management.modelmbean.RequiredModelMBean;
import javax.servlet.ServletContext;
import java.lang.management.ManagementFactory;

/**
 * Created by Jesse.Zhou on 2017/1/11 0011.
 */
public class JawrListener implements ServletContextAware {

    public void setServletContext(ServletContext servletContext) {

        final ObjectName mb = JmxUtils.getAppJawrConfigMBeanObjectName(servletContext, "default");
        try {
            final Object debugModeOn = JmxUtils.getMBeanServer().getAttribute(mb, "DebugModeOn");
            System.out.println("JawrListener debugModeOn = " + debugModeOn);
            servletContext.setAttribute("testobj","11111111");
        } catch (MBeanException e) {
            e.printStackTrace();
        } catch (AttributeNotFoundException e) {
            e.printStackTrace();
        } catch (InstanceNotFoundException e) {
            //e.printStackTrace();
        } catch (ReflectionException e) {
            e.printStackTrace();
        }

    }
}
