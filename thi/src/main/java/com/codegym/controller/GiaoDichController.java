package com.codegym.controller;

import com.codegym.entity.GiaoDich;
import com.codegym.service.GiaoDichService;
import com.codegym.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
public class GiaoDichController {

    @Autowired
    private GiaoDichService giaoDichService;
    @Autowired
    private KhachHangService khachHangService;

    @RequestMapping({"","/list"})
    public ModelAndView danhSach(@PageableDefault(size = 2)Pageable pageable){
        ModelAndView modelAndView =  new ModelAndView("index");
        modelAndView.addObject("danhSachGD",giaoDichService.findAll(pageable));
        modelAndView.addObject("danhSachKH",khachHangService.findAll(pageable));
        return modelAndView;
    }

    @RequestMapping("/edit/{id}")
    public String chitiet(Model model, @PathVariable Integer id){
        GiaoDich giaoDich = giaoDichService.findById(id);
        model.addAttribute("giaodich",giaoDich);
        model.addAttribute("khachhang",khachHangService.findById(giaoDich.getKhachHang().getId()));
        return "chitiet";
    }

    @RequestMapping("/quaylai")
    public String quayLai(){
        return "redirect:/list";
    }

    @RequestMapping("/xoa")
    public String xoa(@RequestParam Integer idXoa){
        GiaoDich giaoDich = giaoDichService.findById(idXoa);
        giaoDichService.delete(giaoDich);
        return "redirect:/list";
    }

    @RequestMapping("/themmoi")
    public ModelAndView them(Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("themmoi");
        modelAndView.addObject("giaodich",new GiaoDich());
        modelAndView.addObject("danhsachkh",khachHangService.findAll(pageable));
        return modelAndView;
    }

    @RequestMapping(value = "/themmoi",method = RequestMethod.POST)
    public String themmoi(@ModelAttribute GiaoDich giaoDich,@RequestParam Integer idKH ,Model model){
        LocalDate ngay = LocalDate.parse(giaoDich.getNgayGD());
        if(LocalDate.now().compareTo(ngay) > 0){
            model.addAttribute("message","Ngay Nho Hon Hien tai");
            model.addAttribute("giaodich",giaoDich);
           return "themmoi";
        }
        giaoDich.setKhachHang(khachHangService.findById(idKH));
        giaoDichService.save(giaoDich);
        return "redirect:/list";
    }

    @RequestMapping(value = "//timkiem")
    public ModelAndView timkiem(@RequestParam String timkiem,@PageableDefault(size = 2) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("danhSachGD",giaoDichService.findByName(timkiem,pageable));
        modelAndView.addObject("danhSachKH",khachHangService.findAll(pageable));
        return modelAndView;
    }
}
