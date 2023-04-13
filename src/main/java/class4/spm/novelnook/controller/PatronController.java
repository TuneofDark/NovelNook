package class4.spm.novelnook.controller;


import class4.spm.novelnook.pojo.Patron;
import class4.spm.novelnook.service.PatronServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/patron")
public class PatronController {

    @Autowired
    PatronServiceImpl patronServiceImpl;

    //需要模板引擎，或者自定义？？？
//    @RequestMapping("all")
//    public String showAllPatronPage() {
//        return "showAll";
//    }

    // 获取所有员工信息
    @GetMapping("/api/getAll")
    @ResponseBody
    public List<Patron> getAllPatrons(){
        return patronServiceImpl.getAllPatrons();
    }



}
