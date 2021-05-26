package com.cedricgasser.fanicon.model;

import javax.persistence.*;
import java.util.List;

@Entity
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
}