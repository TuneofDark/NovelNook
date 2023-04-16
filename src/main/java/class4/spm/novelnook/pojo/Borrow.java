package class4.spm.novelnook.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Borrow {
    String userid;
    String bookid;
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date   borrowtime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date   deadline;
    String status;

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }


    public void setBorrowtime(Date borrowtime) {
        this.borrowtime = borrowtime;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
