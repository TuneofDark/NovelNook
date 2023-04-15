package class4.spm.novelnook.service;

import class4.spm.novelnook.pojo.Book;
import class4.spm.novelnook.pojo.Borrow;
import class4.spm.novelnook.pojo.Patron;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatronService {

    List<Book> searchForBook(String title, String author,String catagory);

    List<Borrow> getBorrowList(String userid);

    List<Book> getBookMsg(String bookid);

    int updateBook(String bookid);

    String updateBorrow(String userid,String bookid);
}
