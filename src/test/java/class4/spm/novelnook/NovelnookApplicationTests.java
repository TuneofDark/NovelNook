package class4.spm.novelnook;

import class4.spm.novelnook.controller.BookController;
import class4.spm.novelnook.controller.PatronController;
import class4.spm.novelnook.mapper.BookMapper;
import class4.spm.novelnook.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class NovelnookApplicationTests {
	@Autowired
	BookController bookController;
	@Autowired
	PatronController patronController;
	@Test
	void contextLoads() {
	}

	@Test
	void bookTest(){


		bookController.getBookInfo("B001");

		bookController.searchForBook("The","","");
	}

	@Test
	void patronTest(){
		patronController.reserveBook("003","B002",new Date(System.currentTimeMillis()));
	}
}

