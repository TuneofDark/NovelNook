package class4.spm.novelnook.service;

import class4.spm.novelnook.mapper.BookMapper;
import class4.spm.novelnook.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookMapper bookMapper;

    @Override
    public List<Book> getBookInfo(String bookId) {
       return bookMapper.getBookInfo(bookId);
    }

    @Override
    public List<Book> searchForBook(String title, String author, String catagory) {
        return bookMapper.searchForBook(title, author, catagory);
    }
}
