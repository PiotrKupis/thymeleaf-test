package com.example.thymeleaftest.controller;

import com.example.thymeleaftest.model.Employee;
import com.example.thymeleaftest.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("employeeList", employeeService.getAllEmployee());
        return "index";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }
}
