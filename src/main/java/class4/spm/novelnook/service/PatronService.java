package class4.spm.novelnook.service;

import class4.spm.novelnook.pojo.Patron;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatronService {

    // 获取所有员工信息
    List<Patron> getAllPatrons();

}
