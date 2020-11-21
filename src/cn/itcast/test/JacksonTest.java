package cn.itcast.test;

import cn.itcast.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class JacksonTest {

//    java对象转为json
    @Test
    public void test() throws IOException {
//        1.创建Person对象
        Person p=new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");

//        2.创建Jackson核心对象
        ObjectMapper mapper = new ObjectMapper();
//        3.转换
      /*  1. 转换方法：
			* writeValue(参数1，obj):
                    参数1：
                    File：将obj对象转换为JSON字符串，并保存到指定的文件中
                    Writer：将obj对象转换为JSON字符串，并将json数据填充到字符输出流中
                    OutputStream：将obj对象转换为JSON字符串，并将json数据填充到字节输出流中
             * writeValueAsString(obj):将对象转为json字符串*/
        String json = mapper.writeValueAsString(p);
        //{"name":"张三","age":23,"gender":"男"}
//        System.out.println(json);

//        writeValue 将数据写到 g://a.txt文件中
//        mapper.writeValue(new File("g://a.txt"),p);

//        writeValue 将数据关联到Write中
//        mapper.writeValue(new FileWriter("g://b.txt"),p);
        System.out.println(json);
    }
    @Test
    public void test2() throws JsonProcessingException {
        Person p=new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");
        p.setBirthday(new Date());
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(p);
        System.out.println(json);
    }
    @Test
    public void test3() throws JsonProcessingException {
        Person p=new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");
        p.setBirthday(new Date());

        Person p1=new Person();
        p1.setName("李四");
        p1.setAge(24);
        p1.setGender("女");
        p1.setBirthday(new Date());

        Person p2=new Person();
        p2.setName("王五");
        p2.setAge(25);
        p2.setGender("男");
        p2.setBirthday(new Date());
        ObjectMapper mapper = new ObjectMapper();
//        list集合转换为 json
//         创建list集合
        List<Person> list = new ArrayList<Person>();
//        把对象添加到 list集合中
        list.add(p);
        list.add(p1);
        list.add(p2);
        String json = mapper.writeValueAsString(list);
        System.out.println(json);
//        [{"name":"张三","age":23,"gender":"男","birthday":"2020-11-21"},
//        {"name":"李四","age":24,"gender":"女","birthday":"2020-11-21"},
//        {"name":"王五","age":25,"gender":"男","birthday":"2020-11-21"}]
    }

    @Test
    public void test4() throws JsonProcessingException {
//       1.创建map集合
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","张三");
        map.put("age",25);
        map.put("gender","男");
//        2.转换
//        2.1创建json核心对象
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);
        System.out.println(json);
        //{"gender":"男","name":"张三","age":25}   与对象格式一致
    }
//    json字符串转化为java对象
  /*  JSON转为Java对象
		1. 导入jackson的相关jar包
		2. 创建Jackson核心对象 ObjectMapper
		3. 调用ObjectMapper的相关方法进行转换
			1. readValue(json字符串数据,Class)*/
    @Test
    public void test5() throws IOException {
//        1.初始化json字符串
        String json = "{\"gender\":\"男\",\"name\":\"张三\",\"age\":25}";
//        2.创建ObjectMapper对象
        ObjectMapper mapper = new ObjectMapper();
//        5.转化为json对象  Person对象
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person);


    }
}
