package com.wipro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.entity.HEmployee;
import com.wipro.service.HEmployeeService;

@Controller
public class HEmployeeController {

    @Autowired
    private HEmployeeService hEmployeeService;

    HEmployee employee;

    @RequestMapping(value = "/myregisterpage", method = RequestMethod.GET)
    public ModelAndView register() {
        return new ModelAndView("register");
    }

    @RequestMapping(value = "/loginpage", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/addEmp", method = RequestMethod.POST)
    public ModelAndView signup(
        @RequestParam("txtename") String name,
        @RequestParam("txtemail") String email,
        @RequestParam("txtpassword") String pass) {

        System.out.println(name + " -- " + email + " -- " + pass);
        employee = new HEmployee();
        employee.setName(name);
        employee.setEmail(email);
        employee.setPassword(pass);
        hEmployeeService.createEmployee(employee);

        return new ModelAndView("login");
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ModelAndView signin(@RequestParam("txtemail") String email,
                               @RequestParam("txtpassword") String pass) {
        HEmployee emp = hEmployeeService.getAnEmployee(email);
        if (emp == null) {
            ModelAndView mv = new ModelAndView("login");
            mv.addObject("NOTIFICATION", "Employee doesn't exist");
            return mv;
        } else {
            List<HEmployee> emplist = hEmployeeService.getAllEmployees();
            ModelAndView mv = new ModelAndView("home");
            mv.addObject("allemp", emplist);
            return mv;
        }
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editEmp() {
        return new ModelAndView("edit");
    }

    @RequestMapping(value = "/updateEmp", method = RequestMethod.POST)
    public ModelAndView updateEmp(@ModelAttribute(name = "hEmployee") HEmployee employee, Model model) {
        if (employee.getEid() == 0) {
            System.out.println("Employee ID is missing");
            ModelAndView mv = new ModelAndView("edit");
            mv.addObject("NOTIFICATION", "Employee ID doesn't exist. Cannot update.");
            return mv;
        } else {
            List<HEmployee> li = hEmployeeService.updateEmployee(employee);
            ModelAndView mv = new ModelAndView("home");
            mv.addObject("allemp", li);
            return mv;
        }
    }

    @RequestMapping(value = "/deleteEmp", method = RequestMethod.GET)
    public ModelAndView deleteEmployee(@RequestParam("eid") int eid) {
        hEmployeeService.deleteEmployee(eid);
        List<HEmployee> li = hEmployeeService.getAllEmployees();
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("allemp", li);
        return mv;
    }
}
