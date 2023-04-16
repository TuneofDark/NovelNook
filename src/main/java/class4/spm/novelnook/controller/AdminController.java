package class4.spm.novelnook.controller;

import class4.spm.novelnook.mapper.AdminMapper;
import class4.spm.novelnook.pojo.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminMapper adminMapper;

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }


    @GetMapping("/staff")
    public List<Staff> getStaff(){//展示列表界面
        List<Staff> list = adminMapper.ShowStaff();
        return list;

    }
    @GetMapping("/staff/{username}")
    public List<Staff> getStaffByUsername(@PathVariable("username") String username){//列表界面查找
        System.out.println(username);
        List<Staff> list=adminMapper.getStaffByUserName(username);
//        if (list.isEmpty()){
//            list.add(new Staff("sjh","123","Darth","Vader","123456","1@empire.com"));
//        }
        return list;
    }

    @DeleteMapping("/staff/{username}")
    public List<Staff> deleteStaffByUsername(@PathVariable("username") String username){//列表界面删除
        System.out.println(username);
        List<Staff> list=adminMapper.deleteStaffByUserName(username);
//        if (list.isEmpty()){
//            list.add(new Staff("sjh","123","Darth","Vader","123456","1@empire.com"));
//        }
        return list;
    }
    
    /**
     * update function
     * @param staff param got from json data in RequestBody
     * @return
     */
    @PutMapping("/staff")
    public int update(@RequestBody Staff staff) {
        return adminMapper.updateByUsername(staff);
    }

}
