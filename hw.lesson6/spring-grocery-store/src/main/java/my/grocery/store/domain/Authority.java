package my.grocery.store.domain;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class Authority {

    public enum Role {
        ADMIN, USER
    }

    @Id
    @Column(name = "authority")
    private String authority;

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    public Authority() {
    }

    public String getAuthority() {
        return authority;
    }

    public User getUser() {
        return user;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
