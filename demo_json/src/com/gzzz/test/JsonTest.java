package com.gzzz.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gzzz.pojo.Dog;
import com.gzzz.pojo.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className: JsonTest
 * Package : com.gzzz.test
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/5 1:05
 * @Version 1.0
 */
public class JsonTest {
    @Test
    public void test1() throws JsonProcessingException {
        //实例化Person对象
        Dog dog = new Dog("王美丽");
        Person person = new Person("果炸裂", 22, dog);

        //jackson包是springMVC默认的json序列化工具，可以直接使用
        ObjectMapper objectMapper = new ObjectMapper();

        //对象转换为json字符串
        String json = objectMapper.writeValueAsString(person);//{"name":"果炸裂","age":22,"dog":{"name":"王美丽"}}
        System.out.println(json);
    }

    @Test
    public void test2() throws JsonProcessingException {
        String json = "{\"name\":\"果炸裂\",\"age\":22,\"dog\":{\"name\":\"王美丽\"}}";

        //json字符串转为Person对象
        Person person = new ObjectMapper().readValue(json, Person.class);
        System.out.println(person);
    }

    /* Map ——>json */
    @Test
    public void test3() throws JsonProcessingException {
        Map data = new HashMap();
        data.put("name","a");
        data.put("age",22);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(data);//{"name":"a","age":22}
        System.out.println(json);
    }

    /*  */
    @Test
    public void test4() throws JsonProcessingException {
        ArrayList list1 = new ArrayList();
        list1.add("a");
        list1.add("b");
        list1.add("c");

        String[] data = new String[]{"a","b","c"};

        Dog dog = new Dog("王美丽");
        Person person = new Person("果炸裂", 22, dog);
        List list2 = new ArrayList();
        list2.add(person);

        ObjectMapper objectMapper = new ObjectMapper();
        String str1 = objectMapper.writeValueAsString(list1);//["a","b","c"]
        String str2 = objectMapper.writeValueAsString(data);//["a","b","c"]
        String str3 = objectMapper.writeValueAsString(list2);//[{"name":"果炸裂","age":22,"dog":{"name":"王美丽"}}]
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
    }
}
