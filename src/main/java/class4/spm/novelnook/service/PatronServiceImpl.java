package class4.spm.novelnook.service;

import class4.spm.novelnook.mapper.PatronMapper;
import class4.spm.novelnook.pojo.Patron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatronServiceImpl implements PatronService{

    @Autowired
    PatronMapper patronMapper;

    // 获取所有员工信息  具体实现
    public List<Patron> getAllPatrons() {
        return patronMapper.getAllPatrons();
    }

}
