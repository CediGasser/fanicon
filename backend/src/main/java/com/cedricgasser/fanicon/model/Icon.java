package com.cedricgasser.fanicon.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@NamedQuery(name = "Icon.searchByNameOrThemeName", query = "SELECT i FROM Icon i INNER JOIN Theme t ON i.theme = t.id WHERE LOWER(i.name) LIKE '%' || LOWER(:q) || '%' OR LOWER(t.name) LIKE '%' || LOWER(:q) || '%'")
public class Icon {
    @Id
    @SequenceGenerator(name = "icon_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "icon_sequence")
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String svg;

    @Column(nullable = false)
    private String name;

    @ManyToOne(optional = false)
    private Theme theme;

    private String style;
    private Boolean isCopyrighted;
    private String copyrightSource;

    @OneToMany(mappedBy = "icon")
    private List<IconInDesign> iconInDesign;

    public Long getId() {
        return id;
    }

    public String getSvg() {
        return svg;
    }

    public void setSvg(String svg) {
        this.svg = svg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Boolean getCopyrighted() {
        return isCopyrighted;
    }

    public void setCopyrighted(Boolean copyrighted) {
        isCopyrighted = copyrighted;
    }

    public String getCopyrightSource() {
        return copyrightSource;
    }

    public void setCopyrightSource(String copyrightSource) {
        this.copyrightSource = copyrightSource;
    }
}