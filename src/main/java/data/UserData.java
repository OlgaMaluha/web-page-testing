package data;

public class UserData {
    private String email;
    private String password;

    public UserData() { }

    public UserData(String m, String p) {
        email = m;
        password = p;
    }

    public UserData(String m) {
        this.email = m;
        this.password = "changeMe";
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }


    public void setEmail(String m) {
        email = m;
    }

    public void setPassword(String p) {
        password = p;
    }

}
