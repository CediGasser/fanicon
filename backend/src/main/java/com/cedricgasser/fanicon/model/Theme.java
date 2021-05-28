package com.cedricgasser.fanicon.model;

import com.cedricgasser.fanicon.model.Icon;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name = "Theme.searchByName", query = "SELECT t FROM Theme t WHERE t.name LIKE '%' || :name || '%'")
public class Theme {
    @Id
    @SequenceGenerator(name = "theme_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "theme_sequence")
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "theme")
    private List<Icon> icon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
