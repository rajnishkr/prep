package design.onlineReader;

public class Book {
    private Integer id;
    private String name;
    private Integer totalPages;
    private Double mrp;
    private String author;
    private String gener;

    public Book(int id, String name, int totalPages, double mrp, String author, String gener) {
        this.id = id;
        this.name = name;
        this.totalPages = totalPages;
        this.mrp = mrp;
        this.author = author;
        this.gener = gener;
    }

    public Book(int id, String name, int totalPages) {
        this.id = id;
        this.name = name;
        this.totalPages = totalPages;
        this.mrp = null;
        this.gener = null;
        this.author = null;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public double getMrp() {
        return mrp;
    }

    public void setMrp(double mrp) {
        this.mrp = mrp;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGener() {
        return gener;
    }

    public void setGener(String gener) {
        this.gener = gener;
    }
}
