package com.gzzz.schedule.service.impl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * className: BaseController
 * Package : com.gzzz.schedule.service.impl
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/18 0:05
 * @Version 1.0
 */
public class BaseController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 判断此次请求时 增删改查？
        String requestURI = req.getRequestURI();// 拿到的是项目上下文路径+/schedule/add(remove)
        String[] split = requestURI.split("/");
        String methodName = split[split.length - 1];
        // 基础写法，一个个判断，但是后端是无法预测/*后面到底是什么的
//        if (methodName.equals("add")) {
//            // 做增加处理
//            req, resp);
//        } else if (methodName.equals("remove")) {
//            // 做删除处理
//            remove(req,resp);
//        } else if (methodName.equals("update")) {
//            // 做修改处理
//            update(req,resp);
//        } else if (methodName.equals("find")) {
//            // 做查询处理
//            find(req,resp);
//        }

        // 高级方式，通过反射
        Class clazz = this.getClass();
        try {
            Method method = clazz.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.setAccessible(true);
            //第一个参数是类的一个实例
            method.invoke(clazz.getDeclaredConstructor().newInstance(),req,resp);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
