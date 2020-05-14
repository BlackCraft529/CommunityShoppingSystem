package cn.jsnu.css.listener;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

/**
 * @author 魏荣轩-18090248
 * @date 2020/5/14 23:42
 */
public class ContextFinalizer implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) { }

    /**
     * 线程销毁
     * @param servletContextEvent servlet事件
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        Driver d = null;
        while (drivers.hasMoreElements()) {
            try {
                d = drivers.nextElement();
                DriverManager.deregisterDriver(d);
                System.out.println(String.format("ContextFinalizer:驱动 %s 已销毁", d));
            } catch (SQLException ex) {
                System.out.println(String.format("ContextFinalizer:正在销毁: %s 时发生错误!", d) + ":" + ex);
                }
            }
        AbandonedConnectionCleanupThread.checkedShutdown();
    }
}
