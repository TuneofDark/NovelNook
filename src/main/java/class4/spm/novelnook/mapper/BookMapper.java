package class4.spm.novelnook.mapper;

import class4.spm.novelnook.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface BookMapper {
     @Select("select * from book where bookid = #{bookId}")
     List<Book> getBookInfo(String bookId);
     List<Book> searchForBook(String title, String author,String catagory);
}
