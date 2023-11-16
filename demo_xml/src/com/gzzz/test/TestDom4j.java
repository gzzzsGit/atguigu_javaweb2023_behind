package com.gzzz.test;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * className: TestDom4j
 * Package : com.gzzz.test
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/8 19:35
 * @Version 1.0
 */
public class TestDom4j {
    @Test
    public void testRead() throws DocumentException {
        //读取jdbc.xml配置文件，获得document对象
        SAXReader saxReader = new SAXReader();

        //通过类加载器获得类加载器获得指向字节码根路径下(编译后out目录下的模块名)的指定文件的输入流
        InputStream resourceAsStream = TestDom4j.class.getClassLoader().getResourceAsStream("jdbc.xml");

        //通过输入流获得配置文件，解析成一个dom对象
        Document dom = saxReader.read(resourceAsStream);

        //从document对象中获取配置文件中的信息
        /*
        * Node 节点
        *       Element     元素节点
        *       Attribute   属性节点
        *       Text        文本节点
        * */
        Element root = dom.getRootElement();
        System.out.println(root.getName());//jdbc

        //获取元素下的子元素
        List<Element> elements = root.elements();
        for (Element element : elements) {
            System.out.println('\t'+element.getName());//dev  test  formal
            //从元素获取属性
            Attribute id = element.attribute("id");
            System.out.println("\t\t"+id.getName()+":"+id.getValue());//id:1  id:2   id:3
            //继续获取子元素
            List<Element> eles = element.elements();
            for (Element ele : eles) {
                System.out.println("\t\t\t"+ele.getName());//username  password  driver  url
                //从元素获取文本节点
                String text = ele.getText();
                System.out.println("\t\t\t\t"+text);// root  root ...
            }
        }


    }
}
