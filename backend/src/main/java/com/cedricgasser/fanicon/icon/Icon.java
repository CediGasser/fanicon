package com.cedricgasser.fanicon.icon;
import com.cedricgasser.fanicon.theme.Theme;

import javax.persistence.*;

@Entity
public class Icon {
    @Id
    @SequenceGenerator(name = "icon_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "icon_sequence")
    private Long id;
    private String svg;
    private String name;

    @ManyToOne(optional = false)
    private Theme theme;
    private String style;
    private Boolean isCopyrighted;
    private String copyrightSource;
}