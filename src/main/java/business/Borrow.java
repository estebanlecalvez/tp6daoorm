package business;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="borrow")
public class Borrow {
    @Id
    @GeneratedValue
    public      Integer id;

    public      String borrowerName;
    public      Date borrowStart;
    public      Date borrowEnd;
    public      String borrowed;

    public Borrow(Integer id, String borrowerName, Date borrowStart, Date borrowEnd, String borrowed) {
        this.id = id;
        this.borrowerName = borrowerName;
        this.borrowStart = borrowStart;
        this.borrowEnd = borrowEnd;
        this.borrowed = borrowed;
    }

}
