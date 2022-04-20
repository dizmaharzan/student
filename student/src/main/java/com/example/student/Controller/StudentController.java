package com.example.student.Controller;

import com.example.student.model.Student;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/list")
    public String getAllStudent(Model model)
    {
        List<Student> list=studentService.getAllStudent();
        model.addAttribute("students",list);
        return "student-list";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel)
    {
        Student theStudent=new Student();
        theModel.addAttribute("student",theStudent);
        return "student-form";
    }
    @GetMapping("/showFormForUpdate")
    public String update(@RequestParam("id") int id, Model model)
    {
        Student theStudent =studentService.getStudent(id);
        return "student-form";
    }
    @GetMapping("/showFormForDetails")
    public String details(@RequestParam("id") int id, Model model)
    {
        Student student =studentService.getStudent(id);
        model.addAttribute("student", student);
        return "details-form";
    }
    @PostMapping("/back")
    public String back()
    {
        return "redirect:/students/list";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("student")Student student)
    {
        Student s=studentService.createStudent(student);
        System.out.println(s);
        return "redirect:/students/list";
    }

    @GetMapping("/delete")
    public String deleteById(@RequestParam("id") int id)
    {
        studentService.deleteStudent(id);
        return "redirect:/students/list";
    }

}
