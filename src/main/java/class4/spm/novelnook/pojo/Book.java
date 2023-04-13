package class4.spm.novelnook.pojo;

public class Book {
    String bookId;
    String bookName;
    String press;
    String author;
    String publishTime;
    String catagory;
    Integer remain;
    String introduction;

    public Book(String bookId, String bookName, String press, String author, String publishTime, String catagory, Integer remain, String introduction) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.press = press;
        this.author = author;
        this.publishTime = publishTime;
        this.catagory = catagory;
        this.remain = remain;
        this.introduction = introduction;
    }

    public Book() {
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public Integer getRemain() {
        return remain;
    }

    public void setRemain(Integer remain) {
        this.remain = remain;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", press='" + press + '\'' +
                ", author='" + author + '\'' +
                ", publishTime='" + publishTime + '\'' +
                ", catagory='" + catagory + '\'' +
                ", remain=" + remain +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
