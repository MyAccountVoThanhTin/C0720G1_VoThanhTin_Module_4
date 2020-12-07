package com.example.controller;

import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("user")
public class StudentController {

    // Step 1: Sau khi khởi chạy project. Hãy vào URL: localhost:8080/detail?id=99 (học viên không tồn tại ở DB)
    // Step 2: Sau đó hãy xem file log ở đường dẫn: com/example/log/error.txt
    // Step 3: Lặp lại Step 1 và 2, thì nội dung log sẽ được thêm vào cuối file error.txt.

    @Autowired
    private StudentService studentService;

    @GetMapping({"", "/list"})
    public String goStudentList(Model model) {
        return "list_student";
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String goDetailStudent(@RequestParam Integer id, Model model) throws Exception {
        model.addAttribute("studentDetail", studentService.findById(id));
        return "detail_student";
    }

}
