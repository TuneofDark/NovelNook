package class4.spm.novelnook.service;

import class4.spm.novelnook.pojo.Book;

import java.util.List;

public interface BookService {
    List<Book> getBookInfo(String bookId);
    List<Book> searchForBook(String title, String author,String catagory);
}
