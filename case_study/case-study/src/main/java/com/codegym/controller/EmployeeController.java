package com.codegym.controller;

import com.codegym.entity.Employee;
import com.codegym.entity.Position;
import com.codegym.service.DivisionService;
import com.codegym.service.EducationDegreeService;
import com.codegym.service.EmployeeService;
import com.codegym.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private DivisionService divisionService;
    @Autowired
    private EducationDegreeService educationService;

    @RequestMapping(value = "/employee/list",method = RequestMethod.GET)
    public ModelAndView listEmployee(@PageableDefault(size = 2) Pageable pageable,@RequestParam Optional<String> keyword){
        String keywordAfterCheck = "";
        ModelAndView modelAndView = new ModelAndView("listemployee");
        if(!keyword.isPresent()) {
            modelAndView.addObject("listEmployee",employeeService.findAll(pageable));
        }else {
            keywordAfterCheck = keyword.get();
            modelAndView.addObject("listEmployee",employeeService.findName(keywordAfterCheck,pageable));
        }

//        ,"listEmployee",employeeService.findAll(pageable)
        modelAndView.addObject("keywordAfterCheck",keywordAfterCheck);
        modelAndView.addObject("listPosition",positionService.findAll());
        modelAndView.addObject("listEducation",educationService.findAll());
        modelAndView.addObject("listDivision",divisionService.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/employee/create",method = RequestMethod.GET)
    public ModelAndView createEmployee(){
        ModelAndView modelAndView = new ModelAndView("createEmployee","employee",new Employee());
        modelAndView.addObject("listPosition",positionService.findAll());
        modelAndView.addObject("listDivision",divisionService.findAll());
        modelAndView.addObject("listEducationDegree",educationService.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/employee/save",method = RequestMethod.POST)
    public String saveEmployee(Model model, @Valid @ModelAttribute Employee employee, BindingResult bindingResult, @RequestParam Integer idPosition, @RequestParam Integer idEducation, @RequestParam Integer idDivition){
        new Employee().validate(employee,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("listPosition",positionService.findAll());
            model.addAttribute("listDivision",divisionService.findAll());
            model.addAttribute("listEducationDegree",educationService.findAll());
            return "createEmployee";
        }
        employee.setPosition(positionService.findById(idPosition));
        employee.setEducationDegree(educationService.findById(idEducation));
        employee.setDivision(divisionService.findById(idDivition));
        employee.setUser(null);
        employeeService.save(employee);
        return "redirect:/employee/list";
    }

    @RequestMapping(value = "/employee/save/edit",method = RequestMethod.POST)
    public String saveEditEmployee(Model model, @Valid @ModelAttribute Employee employee, BindingResult bindingResult, @RequestParam Integer idPosition, @RequestParam Integer idEducation, @RequestParam Integer idDivition){
        new Employee().validate(employee,bindingResult);
        employee.setPosition(positionService.findById(idPosition));
        employee.setEducationDegree(educationService.findById(idEducation));
        employee.setDivision(divisionService.findById(idDivition));
        employee.setUser(null);
        if(bindingResult.hasErrors()){
            model.addAttribute("employee",employee);
            model.addAttribute("listPosition",positionService.findAll());
            model.addAttribute("listDivision",divisionService.findAll());
            model.addAttribute("listEducation",educationService.findAll());
            return "editemployee";
        }
        employeeService.save(employee);
        return "redirect:/employee/list";
    }

    @RequestMapping(value = "/employee/edit/{id}")
    public ModelAndView goEdit(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("editemployee","employee",employeeService.findById(id));
        modelAndView.addObject("listPosition",positionService.findAll());
        modelAndView.addObject("listEducation",educationService.findAll());
        modelAndView.addObject("listDivision",divisionService.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/employee/delete",method = RequestMethod.POST)
    public String delete(@RequestParam String idDelete){
        employeeService.delete(employeeService.findById(Integer.parseInt(idDelete)));
        return "redirect:/employee/list";
    }

    @RequestMapping(value = "/employee/find", method = RequestMethod.POST)
    public ModelAndView find(@PageableDefault(size = 2) Pageable pageable,@RequestParam String keyword){
        ModelAndView modelAndView = new ModelAndView("listemployee","listEmployee",employeeService.findName(keyword,pageable));
//        String keywordAfterCheck = "";
////        if(keyword.isPresent()){
////            modelAndView.addObject("listEmployee",employeeService.findAll(pageable));
////        }else {
////            keywordAfterCheck = keyword.get();
////            modelAndView.addObject("listEmployee",employeeService.findName(keywordAfterCheck,pageable));
////        }
//        modelAndView.addObject("keyword",keywordAfterCheck);
        modelAndView.addObject("listPosition",positionService.findAll());
        modelAndView.addObject("listEducation",educationService.findAll());
        modelAndView.addObject("listDivision",divisionService.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/employee/findselect",method = RequestMethod.POST)
    public ModelAndView findSelect(@PageableDefault(size = 2) Pageable pageable,@RequestParam String select,@RequestParam(name = "findSelect") String value){
        ModelAndView modelAndView = new ModelAndView("listemployee");
        switch (select){
            case "name":
                modelAndView.addObject("listEmployee",employeeService.findSelect("employee.employee_name",value));
                break;
            case "email":
                break;
            case "address":
                break;
            case "position":
                break;
            case "education":
                break;
            case "division":
                break;
            default:
        }
        modelAndView.addObject("listPosition",positionService.findAll());
        modelAndView.addObject("listEducation",educationService.findAll());
        modelAndView.addObject("listDivision",divisionService.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/employee/birthday",method = RequestMethod.GET)
    public ModelAndView searchBirthday(@PageableDefault(size = 2) Pageable pageable,@RequestParam String startday,@RequestParam String endday){
        LocalDate start = LocalDate.parse(startday);
        LocalDate end = LocalDate.parse(endday);
        ModelAndView modelAndView = new ModelAndView("listemployee");
        if(end.compareTo(start) <= 0){
            modelAndView.addObject("listEmployee",employeeService.findAll(pageable));
            modelAndView.addObject("message","Erros ! Fail !");
        }else {
            modelAndView.addObject("listEmployee",employeeService.findBirthday(startday, endday, pageable));
        }
        modelAndView.addObject("listPosition",positionService.findAll());
        modelAndView.addObject("listEducation",educationService.findAll());
        modelAndView.addObject("listDivision",divisionService.findAll());
        return modelAndView;
    }
}
