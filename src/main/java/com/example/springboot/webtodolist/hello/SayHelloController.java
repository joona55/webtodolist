package com.example.springboot.webtodolist.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SayHelloController {

    @RequestMapping("say-Hello")
    @ResponseBody
    public String sayHello() {
        return "Hello!";
    }

    @RequestMapping("say-Hello-html")
    @ResponseBody
    public String sayHelloHtml() {

        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title> 첫 HTML 페이지 </title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("첫 홈페이지의 바디 부분입니다. 1111");
        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();
    }
}
