package com.gzzz.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * className: UserServlet
 * Package : com.gzzz.servlet
 * Description:
 *  TODO:
 *    Servlet开发流程
 *      1 创建javaWEB项目,同时将tomcat添加为当前项目的依赖
 *      2 重写protected修饰的service方法service(HttpServletRequest req，HttpServLetResponse resp)
 *      3 service方法中。定义业务处理代码
 *      4 在web.xml中配置Servlet对应的请求映射路径
 *
 *  TODO:
 *      1 servlet-api.jar的导入问题
 *            我们只在编码的时候需要servlet-api，运行的时候，在tomcat服务器的环境下，由tomcat提供（tomcat目录下的lib目录里包含了）
 *            因此，在开发JavaWEB项目时，在打包和构建的时候，无需携带servlet-api的jar包，也就不需要在web-inf下导入servlet-api.jar包
 *            而是在模块依赖中导入library，选择application server libraries中的tomcat(需要先在设置下build，execution，deploymnt中设置application server)，scope是provided表名打包时携带
 *      2 Content-Type 响应头类型
 *            MIME类型响应头     媒体类型、文件类型、相应的数据类型
 *            MIME类型用于告诉客户端响应的数据是什么类型的，客户端以此类型决定用什么方式解析响应体
 *
 * @Author gzzz
 * @Create 2023/11/10 0:54
 * @Version 1.0
 */
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 从request 对象中获取请求中的任何信息(username参数)
        String username = req.getParameter("username");

        //2 处理业务逻辑
        String info = "<h1>YES</h1>";
        if ("gzzz".equals(username)) {
            info = "<h1>NO</h1>";
        }

        //3 向response对象中输出响应信息
        // 应该设置Content-Type响应头，不然默认当作HTML解析
        //方式一
        resp.setHeader("Content-Type", "text/html;charset=utf-8");

        //方式二
//      resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write(info);
    }
}
