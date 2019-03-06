package com.example.ssm.controller;

import com.example.ssm.domain.User;
import com.example.ssm.service.UserService;
import com.example.ssm.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    public UserService userService;

    @RequestMapping("/")
    public String log(){
        return "home";
    }


    @RequestMapping(value = "/signIn",method = {RequestMethod.POST})
    public String signIn(User user){

        LocalDate localDate=LocalDate.now();
        user.setSignInDate(localDate);
        int i=userService.getUser(user);
        System.out.println(i);
        return "signIn";
    }

    @ResponseBody
    @RequestMapping("/login")
    public String login(User user, Model model, HttpServletRequest req) {
        HttpSession session = req.getSession();
        if(user != null) { User loginUser = userService.userlogin(user);
        if(loginUser != null) {
            System.out.println("登录成功");
            session.setAttribute("user", loginUser);
            return "index";
        } else {
            System.out.println("登录失败");
            return "fail";
            }
        }
        return "fail";
    }
    @ResponseBody
    @RequestMapping("/show")
    public List<User> pageShow(Model model, HttpServletRequest req){

        String pageNow=req.getParameter("pageNO"); //获取当前页
        int totalCount=userService.findUserCount();
        Page page=null;
        List<User> list=new ArrayList<User>();
        int pageNo=Integer.parseInt(pageNow);
        int start=(pageNo-1)*3+1;
        if (pageNow!=null) {
            page=new Page(pageNo, totalCount);
            list=userService.showPage(start,page.getPageSize());
        }else {
            page=new Page(1, totalCount);
            list=userService.showPage(start,page.getPageSize());
        }
        model.addAttribute("user", list);
        model.addAttribute("page", page);
        return list;

    }

    @ResponseBody
    @RequestMapping("/delete")
    public String deleteUser(User user){
        int deleteUser= userService.deleteUser(user);
        if(deleteUser!=0) {
            return "删除成功";
        }else{
            return "没有该用户";
        }
    }

}
