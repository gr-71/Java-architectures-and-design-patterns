package my.grocery.store.domain;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    @OneToMany(mappedBy = "user")
    private List<Authority> authorities;

    public User() {
    }

// Паттерн builder -------------
    public static class UserBuilder{
        private User user;

        public UserBuilder (String username, String password){
            user = new User();
            user.setUsername(username);
            user.setPassword(password);
        }

        public UserBuilder withName (String username){
            user.username = username;
            return this;
        }

    public UserBuilder withPassword (String password){
        user.password = password;
        return this;
    }

        public User build(){
            return user;
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

//    public User(String username, String password) {
//        this.username = username;
//        this.password = password;
//    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
