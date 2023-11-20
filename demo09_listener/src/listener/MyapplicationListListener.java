package listener;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;

import java.security.Key;

/**
 * className: MyapplicationListListener
 * Package : com.gzzz.servlet
 * Description:
 *      TODO：
 *          Listener的配置
 *                1 配置web.xml的listener标签
 *                2 使用@WebListener注解
 *
 *          ServletContextListener:
 *                contextInitialized 监听应用域的初始化
 *                contextDestroyed  监听应用域的销毁
 * @Author gzzz
 * @Create 2023/11/20 22:53
 * @Version 1.0
 */
@WebListener
public class MyapplicationListListener implements ServletContextListener, ServletContextAttributeListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // tomcat部署完成就会执行应用域初始化
        ServletContext application = sce.getServletContext();
        System.out.println(application.hashCode()+"应用域初始化了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext application = sce.getServletContext();
        System.out.println(application.hashCode()+"应用域销毁了");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        ServletContext application = scae.getServletContext();
        String key = scae.getName();
        // 这里是因为我们知道传的参数是String类型
        String value = (String) scae.getValue();
        System.out.println(application.hashCode()+"应用域增加了"+key+":"+value);
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        ServletContext application = scae.getServletContext();
        String key = scae.getName();
        // 这里是因为我们知道传的参数是String类型
        String value = (String) scae.getValue();
        System.out.println(application.hashCode()+"应用域移除了"+key+":"+value);
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        ServletContext application = scae.getServletContext();
        String key = scae.getName();
        // 这里获取的是旧值
        String oldValue = (String) scae.getValue();
        // 通过application.getAttribute（key）来获得新值
        String newValue = (String) application.getAttribute(key);
        System.out.println(application.hashCode()+"应用域修改了"+key+":"+oldValue+"为："+key+":"+newValue);
    }
}
