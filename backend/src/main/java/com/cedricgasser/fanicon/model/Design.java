package com.cedricgasser.fanicon.model;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import javax.persistence.*;
import java.util.List;

@Entity
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

    @ManyToOne(optional = false)
    private User user;

    @OneToMany(mappedBy = "design")
    private List<IconInDesign> iconInDesign;
}
