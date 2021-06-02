package com.cedricgasser.fanicon.dto;

import com.cedricgasser.fanicon.model.Theme;
import java.io.Serializable;

public class IconInDesignDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Long iconId;
    private final String name;
    private final String svg;
    private final Theme theme;
    private final String style;
    private final Boolean isCopyrighted;
    private final String copyrightSource;
    private final int position;

    public IconInDesignDto(Long iconId, String name, String svg, Theme theme, String style, Boolean isCopyrighted, String copyrightSource, int position){
        this.iconId = iconId;
        this.name = name;
        this.svg = svg;
        this.theme = theme;
        this.style = style;
        this.isCopyrighted = isCopyrighted;
        this.copyrightSource = copyrightSource;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getSvg() {
        return svg;
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

    public int getPosition() {
        return position;
    }

    public Long getIconId() {
        return iconId;
    }
}
