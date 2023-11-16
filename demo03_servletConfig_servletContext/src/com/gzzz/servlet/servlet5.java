package com.gzzz.servlet;

import com.sun.source.tree.WhileLoopTree;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * className: servlet5
 * Package : com.gzzz.servlet
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/16 10:40
 * @Version 1.0
 */
@WebServlet("/servlet5")
public class servlet5 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取键值对形式的参数
        //根据参数名获取单个参数
        String username = req.getParameter("username");
        System.out.println(username);
        String userPwd = req.getParameter("userPwd");
        System.out.println(userPwd);

        //根据参数名获取多个参数
        String[] hobbies = req.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobbies));

        //获取所有参数
        Enumeration<String> pnames= req.getParameterNames();
        while(pnames.hasMoreElements()){
            String pname = pnames.nextElement();
            String[] parameterValues = req.getParameterValues(pname);
            if (parameterValues.length > 1) {
                System.out.println(pname+":"+Arrays.toString(parameterValues));
            }
            else
                System.out.println(pname+":"+parameterValues[0]);
        }

        //返回所有参数的map集合
        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        for (Map.Entry<String, String[]> entry : entries){
            if (entry.getValue().length>1)
                System.out.println(entry.getKey()+":"+Arrays.toString(entry.getValue()));
            else
                System.out.println(entry.getKey()+":"+entry.getValue()[0]);
        }
        /**
         * 以上API专门用于获取key=vaLue形式的参数,无论这些参数是在urL后还是在请求体中
         * 如何获得请求体中的非键值对数掘
         * //获取一个从请求体中读取字符的字符输入流
         * BufferedReader reader = req.getReader();//JSON串
         * //获得一个从请求中读取二进制数据字节的输入流
         * ServletInputStream inputStream = req.getInputStream();//文件
         */

        System.out.println(req.getServletPath());//servlet5
    }
}
