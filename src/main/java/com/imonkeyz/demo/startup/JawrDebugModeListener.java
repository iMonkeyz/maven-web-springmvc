package com.imonkeyz.demo.startup;

import net.jawr.web.config.jmx.JmxUtils;

import javax.management.*;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Jesse.Zhou on 2017/1/12 0012.
 */
public class JawrDebugModeListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        try {

            final ObjectName mb = JmxUtils.getAppJawrConfigMBeanObjectName(servletContextEvent.getServletContext(), "default");
            final Object debugModeOn = JmxUtils.getMBeanServer().getAttribute(mb, "DebugModeOn");
            System.out.println("JawrDebugModeListener debugModeOn = " + debugModeOn);

        } catch (MBeanException e) {
            e.printStackTrace();
        } catch (AttributeNotFoundException e) {
            e.printStackTrace();
        } catch (InstanceNotFoundException e) {
            //e.printStackTrace();
        } catch (ReflectionException e) {
            e.printStackTrace();
        }


        /*final ObjectName mb = JmxUtils.getAppJawrConfigMBeanObjectName(request.getSession().getServletContext(), "default");
        Object debugModeOn = JmxUtils.getMBeanServer().getAttribute(mb, "DebugModeOn");

        if ( debugModeOn != null && Boolean.valueOf(debugModeOn.toString()) != enableJAWR ) {
            JmxUtils.getMBeanServer().setAttribute(mb, new Attribute("DebugModeOn", String.valueOf(enableJAWR)));
            JmxUtils.getMBeanServer().invoke(mb, "refreshConfig", null, null);
            LOG.info("Detected JAWR Debug Mode status has changed , refresh memory finished !");
        }*/
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
