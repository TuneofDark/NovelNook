package class4.spm.novelnook.service;

import class4.spm.novelnook.mapper.PatronMapper;
import class4.spm.novelnook.pojo.Book;
import class4.spm.novelnook.pojo.Borrow;
import class4.spm.novelnook.pojo.Patron;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class PatronServiceImpl implements PatronService{

    @Autowired
    PatronMapper patronMapper;


    public List<Book> searchForBook(String title, String author, String catagory) {
        return patronMapper.searchForBook(title, author, catagory);
    }

    public List<Borrow> getBorrowList(String userid) {
        return patronMapper.getBorrowList(userid);
    }

    public List<Book> getBookMsg(String bookid) {
        return patronMapper.getBookMsg(bookid);
    }

    public int updateBook(String bookid) {
        if(patronMapper.checkBookRemain(bookid) == 0)   return 0;
        patronMapper.updateBook(bookid);
        return 1;
    }

    public String updateBorrow(String userid,String bookid) {
        String borrowstatus = patronMapper.checkBorrow(userid, bookid);

        if(borrowstatus != null && borrowstatus.equals("borrowing"))
            return "Failed: You have already borrowed the material!";
        if(updateBook(bookid) == 0)
            return "Failed: No materials remain!";

        if(borrowstatus != null && borrowstatus.equals("returned"))
            patronMapper.deleteBorrow(userid, bookid);
        Date borrowtime = new Date();
        Borrow borrow = new Borrow();
        borrow.setUserid(userid);
        borrow.setBookid(bookid);
        borrow.setBorrowtime(borrowtime);
        borrow.setDeadline(getDeadline(borrowtime));
        borrow.setStatus("borrowing");
        patronMapper.addBorrow(borrow);
        return "success!";
    }


     Date getDeadline(Date sourceDate) {
        Calendar c = Calendar.getInstance();
        c.setTime(sourceDate);
        c.add(Calendar.MONTH, 1);

        return c.getTime();
    }

}
