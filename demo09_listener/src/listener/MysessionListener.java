package listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.*;

/**
 * className: MysessionListener
 * Package : com.gzzz.servlet
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/21 0:37
 * @Version 1.0
 */
@WebListener
public class MysessionListener implements HttpSessionListener, HttpSessionAttributeListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // 任何一个session域对象的创建都会触发该方法的执行
        HttpSession session = se.getSession();
        System.out.println(session.hashCode()+"session域初始化了");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // 任何一个session域对象的销毁都会触发该方法的执行
        HttpSession session = se.getSession();
        System.out.println(session.hashCode()+"session域销毁了");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        // 任何一个session域对象增加了数据都会触发该方法的执行
        String key = se.getName();
        Object value = se.getValue();
        HttpSession session = se.getSession();
        System.out.println(session.hashCode()+"session域增加了"+key+":"+value);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        // 任何一个session域对象删除了数据都会触发该方法的执行
        String key = se.getName();
        Object value = se.getValue();
        HttpSession session = se.getSession();
        System.out.println(session.hashCode()+"session域移除了"+key+":"+value);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        // 任何一个session域对象修改了数据都会触发该方法的执行
        String key = se.getName();
        // 获取的是旧值
        Object value = se.getValue();
        HttpSession session = se.getSession();
        Object newValue = session.getAttribute(key);
        System.out.println(session.hashCode()+"session域修改了"+key+":"+value+"为："+key+":"+newValue);
    }

}
