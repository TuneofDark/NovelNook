package class4.spm.novelnook.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Borrow {

    String userid;
    String bookid;
    Date borrowtime;
    Date deadline;
    String status;


}

