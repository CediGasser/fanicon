package com.cedricgasser.fanicon.model;
import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Design {
    @Id
    @SequenceGenerator(name = "design_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "design_sequence")
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String bgColor;

    private String iconSize;
    private String iconMargin;
    private String iconColor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_name")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "design")
    private List<IconInDesign> iconInDesign;

    protected Design(){}

    public Design(final String name, final String bgColor, final String iconSize, final String iconMargin, final String iconColor, final User user){
        this.name = name;
        this.bgColor = bgColor;
        this.iconSize = iconSize;
        this.iconMargin = iconMargin;
        this.iconColor = iconColor;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public String getIconSize() {
        return iconSize;
    }

    public void setIconSize(String iconSize) {
        this.iconSize = iconSize;
    }

    public String getIconMargin() {
        return iconMargin;
    }

    public void setIconMargin(String iconMargin) {
        this.iconMargin = iconMargin;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getIconColor() {
        return iconColor;
    }

    public void setIconColor(String iconColor) {
        this.iconColor = iconColor;
    }
}
