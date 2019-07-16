package com.example.test.demo.controller;


import com.example.test.demo.model.entity.Student;
import com.example.test.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String Toindex(){
        //到登陆页
        return "index";
    }
    @RequestMapping(value = "index",method = RequestMethod.POST)
    public String Doindex(LoginForm form, ModelMap modelMap){
       try{
           Student student = studentService.St(form.getUsername(),form.getPassword());
    }catch (RuntimeException e){
           e.printStackTrace();
           if (e.getMessage().equals("USER_NOT_FOUND")) {
               modelMap.put("msg", "用户不存在或者密码不匹配");
               return "index";
           }

       } catch (Exception e) {
           e.printStackTrace();
           modelMap.put("msg", "系统异常..");

           return "index";
       }
        return "succeed";
       }
    }


