package listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

/**
 * className: SessionBindingListener
 * Package : com.gzzz.servlet
 * Description:
 *      TODO:
 *         不配置@WebListener注解生效，而是使用传入session对象生效
 * @Author gzzz
 * @Create 2023/11/21 1:52
 * @Version 1.0
 */

public class SessionBindingListener implements HttpSessionBindingListener {
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        // 当前监听器实例放入某个session中作为数据绑定
        System.out.println("session valueBound!");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        // 当前监听器实例从某个session中移除——解除绑定
        System.out.println("session valueUnbound!");
    }
}
