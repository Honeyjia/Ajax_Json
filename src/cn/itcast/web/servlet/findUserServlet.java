package cn.itcast.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/findUserServlet")
public class findUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");//设置中文乱码问题
//        1.获取username
        String username = request.getParameter("username");
//        2.判断
        // 期望服务器响应的数据格式：{"userExist":true,"msg":"此用户名太受欢迎，请更换一个!"}
        // {"userExist":false,"msg":"此用户名可用!"}
//        2.1首先创建一个map集合
        HashMap<String, Object> map = new HashMap<>();
        if("tom".equals(username)){
            //如果用户名存在
            map.put("userExist",true);
            map.put("msg","此用户名太受欢迎，请更换一个!");

        }else {
            //如果用户名不存在
            map.put("userExist",false);
            map.put("msg","此用户名可用!");
        }
//        3.创建json核心对象
//        3.1 map转化json  并且传递给客户端
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),map);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
