package class4.spm.novelnook.mapper;


import class4.spm.novelnook.pojo.Book;
import class4.spm.novelnook.pojo.Borrow;
import class4.spm.novelnook.pojo.Patron;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PatronMapper {


    //获取所有borrow信息
    @Select("select * from borrow where userid = #{userid}")
    List<Borrow> getBorrowList(String userid);

    @Select("select * from book where bookid = #{bookid}")
    List<Book> getBookMsg(String bookid);
    List<Book> searchForBook(String title, String author,String catagory);

    @Select("select remain from book where bookid = #{bookid}")
    int checkBookRemain(String bookid);

    @Update("update book set remain = remain - 1 where bookid = #{bookid}")
    int updateBook(String bookid);

    @Select("select status from borrow where userid = #{userid} and bookid = #{bookid}")
    String checkBorrow(String userid, String bookid);

    @Delete("delete from borrow where userid = #{userid} and bookid = #{bookid}")
    int deleteBorrow(String userid, String bookid);

    @Insert("insert into borrow(userid, bookid, borrowtime, deadline, status)"+
            "values(#{userid}, #{bookid}, #{borrowtime}, #{deadline}, #{status})")
    int addBorrow(Borrow borrow);

}
