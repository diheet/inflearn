package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {


        @GetMapping("hello")
        public String hello(Model model) {
            model.addAttribute("data","hello");
            return "hello";
        }

        @GetMapping("hello-mvc")
        public String helloMvc(@RequestParam("name") String name, Model model) {
            model.addAttribute("name", name);
            return "hello-template";
        } //url?name=spring

        @GetMapping("hello-string")
        @ResponseBody   //body부분에 직접 값을 넣어 줄것이다
        public String helloString(@RequestParam("name") String name) {

            return "hello " + name; //html 형식이 아닌 문자로!! 바로 출력
        }

        @GetMapping("hello-api")
        @ResponseBody
        public Hello helloApi(@RequestParam("name") String name) {
            Hello hello = new Hello();
            hello.setName(name);
            return hello;
        }
        static class Hello {
            private String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }  //json 방식 {key : value} 값으로 이루어짐 (커멘트 엔터)
}


