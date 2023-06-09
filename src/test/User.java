package test;

public class User {
    private String id;
    private String birthday;
    private String phone;

    public User(String id, String birthday, String phone) {
        this.id = id;
        this.birthday = birthday;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
