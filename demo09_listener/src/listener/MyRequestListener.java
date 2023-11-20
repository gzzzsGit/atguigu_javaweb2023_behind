package listener;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;

/**
 * className: MyRequestListener
 * Package : com.gzzz.servlet
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/21 0:58
 * @Version 1.0
 */
@WebListener
public class MyRequestListener implements ServletRequestListener, ServletRequestAttributeListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        // 任何一个请求域对象的销毁都会触发该方法的执行
        ServletRequest servletRequest = sre.getServletRequest();
        System.out.println(servletRequest.hashCode()+"请求域初始化了");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        // 任何一个请求域对象的初始化都会触发该方法的执行
        ServletRequest servletRequest = sre.getServletRequest();
        System.out.println(servletRequest.hashCode()+"请求域删除了");
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        // 任何一个请求域中增加了数据都会触发该方法的执行
        String key = srae.getName();
        Object value = srae.getValue();
        ServletRequest servletRequest = srae.getServletRequest();
        System.out.println(servletRequest.hashCode()+"请求域增加了"+key+":"+value);
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        // 任何一个请求域中移除了数据都会触发该方法的执行
        String key = srae.getName();
        Object value = srae.getValue();
        ServletRequest servletRequest = srae.getServletRequest();
        System.out.println(servletRequest.hashCode()+"请求域移除了"+key+":"+value);
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        // 任何一个请求域中修改了数据都会触发该方法的执行
        String key = srae.getName();
        Object value = srae.getValue();
        ServletRequest servletRequest = srae.getServletRequest();
        Object newValue = servletRequest.getAttribute(key);
        System.out.println(servletRequest.hashCode()+"请求域修改了"+key+":"+value+"为："+key+":"+newValue);
    }


}
