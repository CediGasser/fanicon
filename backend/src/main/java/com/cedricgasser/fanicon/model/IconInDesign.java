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
    private Design design;

    @ManyToOne
    private Icon icon;

    @Column(nullable = false)
    private int position;

    protected IconInDesign(){}

    public IconInDesign(final Design design, final Icon icon, final int position){
        this.design = design;
        this.icon = icon;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Design getDesign() {
        return design;
    }

    public void setDesign(Design design) {
        this.design = design;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
