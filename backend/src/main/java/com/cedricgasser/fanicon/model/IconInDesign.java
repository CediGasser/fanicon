package com.cedricgasser.fanicon.model;

import javax.persistence.*;

@Entity
@Table
public class IconInDesign {
    @Id
    @SequenceGenerator(name = "icon_in_design_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "icon_in_design_sequence")
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @ManyToOne
    public Design design;

    @ManyToOne
    public Icon icon;

    @Column(nullable = false)
    public int position;
}
