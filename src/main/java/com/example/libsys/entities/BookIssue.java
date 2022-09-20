package entities;

import java.util.Date;

public class BookIssue {
    private long ID;
    private long userID;
    private long bookID;
    private Date dateOfIssue;
    private Date dateOfReturn;
    //private double fineAmount;

    public BookIssue(long ID, long userID, long bookID, Date dateOfIssue, Date dateOfReturn) {
        this.ID = ID;
        this.userID = userID;
        this.bookID = bookID;
        this.dateOfIssue = dateOfIssue;
        this.dateOfReturn = dateOfReturn;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public long getBookID() {
        return bookID;
    }

    public void setBookID(long bookID) {
        this.bookID = bookID;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public Date getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(Date dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }
}
