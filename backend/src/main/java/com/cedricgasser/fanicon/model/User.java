package com.cedricgasser.fanicon.model;

import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "fanicon_user")
@NamedQuery(name = "User.checkPassword", query = "SELECT u FROM User u WHERE u.name = :name and password = public.crypt(text(:password), text(password))")
public class User {
    @Id
    @Column(name = "name", nullable = false, updatable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    @ColumnTransformer(write = "crypt(?, gen_salt('bf', 8))")
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserGroup userGroup;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Design> designs;

    public UserGroup getUserGroup() { return this.userGroup; }
    public void setUserGroup(UserGroup userGroup) { this.userGroup = userGroup; }

    public User(final String name, final String password, final String email, final UserGroup userGroup) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.userGroup = userGroup;
    }

    protected User(){}

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public void setPassword(String password){ this.password = password; }
}
