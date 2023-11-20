package listener;

import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionActivationListener;
import jakarta.servlet.http.HttpSessionEvent;

/**
 * className: MyActivationListener
 * Package : listener
 * Description:
 *      TODO:
 *          不配置@WebListener注解生效，而是使用传入session对象生效
 * @Author gzzz
 * @Create 2023/11/21 2:02
 * @Version 1.0
 */
public class MyActivationListener implements HttpSessionActivationListener {
    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        // session对象即将钝化之前执行
        HttpSession session = se.getSession();
        System.out.println("session with JSESSIONID "+ session.getId()+" will passivate");
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        // session对象即将活化完成后执行
        HttpSession session = se.getSession();
        System.out.println("session with JSESSIONID "+ session.getId()+" did activate");
    }
}
