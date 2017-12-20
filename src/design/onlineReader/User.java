package design.onlineReader;

//TODO hashcode equal + To String
public class User {
    private String name;
    private Integer id;
    private String fullName;
    private Boolean isMember;

    public User() {
    }

    public User(String name, Integer id) {
        this.name = name;
        this.id = id;
        this.fullName = name;
        this.isMember = false;
    }

    public User(String name, Integer id, String fullName, boolean isMember) {
        this.name = name;
        this.id = id;
        this.fullName = fullName;
        this.isMember = isMember;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Boolean getMember() {
        return isMember;
    }

    public void setMember(Boolean member) {
        isMember = member;
    }
}
