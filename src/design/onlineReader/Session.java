package design.onlineReader;

public class Session {
    private Book currentBook;
    private User activeUser;
    private Integer pageNumber;
    private String sessionStatus;

    public Session(User activeUser, Book curentBook) {
        this.activeUser = activeUser;
        this.currentBook = curentBook;
        this.pageNumber = 1;
        this.sessionStatus = "active";
    }

    public boolean isSessionActive() {
        return this.sessionStatus.equalsIgnoreCase("active");
    }

    public boolean isBookCompeleted() {
        return this.pageNumber > currentBook.getTotalPages();
    }

    //TODO turn Page fwd
    //TODO turn page bwk

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getSessionStatus() {
        return sessionStatus;
    }

    public void setSessionStatus(String sessionStatus) {
        this.sessionStatus = sessionStatus;
    }
}
