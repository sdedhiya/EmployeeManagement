package com.EmployeeManagement.controller;

import com.EmployeeManagement.model.Employee;
import com.EmployeeManagement.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Tag(name = "Employee Controller")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Employee> list = employeeService.getAllEmployees();
        model.addAttribute("employees", list);
        return "list";
    }

    @GetMapping("/add")
    @Operation(summary = "Show form to add employee")
    public String addEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add";
    }

    @PostMapping("/save")
    @Operation(summary = "Save employee")
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    @Operation(summary = "Edit employee by ID")
    public String editEmployee(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.getById(id));
        return "add";
    }

    @GetMapping("/delete/{id}")
    @Operation(summary = "Delete employee by ID")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    @Operation(summary = "View employee details")
    public String viewEmployee(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.getById(id));
        return "view";
    }
}