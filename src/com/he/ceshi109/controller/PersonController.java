package com.he.ceshi109.controller;

import com.google.code.kaptcha.Constants;
import com.he.ceshi109.entity.Person;
import com.he.ceshi109.entity.User;
import com.he.ceshi109.service.PersonService;
import com.he.ceshi109.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PersonController {

    @Resource
    private PersonService personService;

    @Resource
    private UserService userService;

    @RequestMapping("/toLogin.do")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/login.do")
    public String login(String name, String psd, String code, HttpServletRequest req) {
        String cod = (String) req.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (code != null && !code.isEmpty()) {
            if (cod.equals(code)) {
                if (name != null && psd != null && !name.isEmpty()) {
                    User user = userService.selectByName(name);
                    if (name.equals(user.getName()) && psd.equals(user.getPassword())) {
                        req.getSession().setAttribute("name", name);
                        return "forward:/toIndex.do";
                    }
                    return "redirect:/toLogin.do";
                }
                return "redirect:/toLogin.do";
            }
            return "redirect:/toLogin.do";
        }
        return "redirect:/toLogin.do";
    }

    @RequestMapping("/toIndex.do")
    public String toIndex() {
        return "index";
    }

    @RequestMapping("/toInsert.do")
    public String toInsert() {
        return "insert";
    }

    @RequestMapping("/insert.do")
    public String insert(String name, String sex, int age) {
        Person person = new Person(name, sex, age);
        personService.insert(person);
        return "forward:/toInsert.do";
    }

    @RequestMapping("/page.do")
    public ModelAndView page(HttpServletRequest req, Integer numpage, Integer size) {
        ModelAndView modelAndView = new ModelAndView();
        if ( numpage == null || numpage <= 1 ) {
            numpage = 1;
        }
        if (size == null) {
            size = 5;
        }
        System.out.println(numpage);
        List<Person> list = personService.selectByPage(numpage, size);
        req.getSession().setAttribute("list", list);
        int count = personService.selectCount();
        int zy = count % size == 0 ? count / size : count / size + 1;
        req.getSession().setAttribute("zy", zy);
        req.getSession().setAttribute("numpage", numpage);
        modelAndView.setViewName("menu");
        return modelAndView;
    }

    @RequestMapping("/toUpdate.do")
    public String toUpdate(int id,HttpServletRequest req){
        Person person = personService.selectById(id);
        req.getSession().setAttribute("person",person);
        return "update";
    }

    @RequestMapping("/update.do")
    public String update(Person person){
        personService.update(person);
        return "forward:/page.do";
    }

    @RequestMapping("/delete.do")
    public String delete(int id) {
        personService.delete(id);
        return "forward:/page.do";
    }

    @RequestMapping("/selectlike.do")
    public ModelAndView selectLike(String keywords,HttpServletRequest req){
        ModelAndView modelAndView = new ModelAndView();
        List<Person> list = personService.selectByName(keywords);
        req.getSession().setAttribute("list",list);
        modelAndView.setViewName("menu");
        return modelAndView;
    }

    @RequestMapping("/toLogout.do")
    public String toLogout(HttpServletRequest req){
        req.getSession().removeAttribute("name");
        return"redirect:/toLogin.do";
    }

    @RequestMapping("/toReg.do")
    public String toReg(){
        return "reg";
    }

    @RequestMapping("/reg.do")
    public String reg(String name, String password) {
        User user = new User(name,password);
        userService.reg(user);
        return "forward:/toLogin.do";
    }
}
