package com.cedricgasser.fanicon.model;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name = "Icon.searchByNameOrThemeName", query = "SELECT i FROM Icon i INNER JOIN Theme t ON i.theme = t.id WHERE i.name LIKE '%' || :name || '%' OR t.name LIKE '%' || :theme_name || '%'")
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

    public String getName() {
        return name;
    }

    public Theme getTheme() {
        return theme;
    }

    public String getStyle() {
        return style;
    }

    public Boolean getCopyrighted() {
        return isCopyrighted;
    }

    public String getCopyrightSource() {
        return copyrightSource;
    }
}