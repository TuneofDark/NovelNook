package class4.spm.novelnook.controller;

import class4.spm.novelnook.mapper.BookMapper;
import class4.spm.novelnook.pojo.Book;
import class4.spm.novelnook.pojo.Staff;
import class4.spm.novelnook.service.BookService;
import class4.spm.novelnook.service.BookServiceImpl;
import class4.spm.novelnook.service.PatronServiceImpl;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookServiceImpl bookServiceImpl;
    @Autowired
    BookMapper bookMapper;
    @GetMapping("/book/{bookId}")
    public List<Book> getBookInfo(@PathVariable("bookId") String bookId){

        List<Book> list = bookServiceImpl.getBookInfo(bookId);
        System.out.println(list);
//        if (list.isEmpty()){
//            list.add(new Staff("sjh","123","Darth","Vader","123456","1@empire.com"));
//        }
        return list;
    }
    @GetMapping("/book/{title}/{author}/{catagory}")
    public List<Book> searchForBook(@PathVariable("title") String title,@PathVariable("author") String author
    ,@PathVariable("catagory") String catagory){
        if (title.isEmpty())
            title = null;
        else  title = "%"+title+"%";
        if (author.isEmpty())
            author = null;
        if (catagory.isEmpty())
            catagory = null;


        List<Book> list = bookServiceImpl.searchForBook(title,author,catagory);
        System.out.println("==============================");
        System.out.println(list);
        System.out.println("==============================");
        return list;
    }
}
