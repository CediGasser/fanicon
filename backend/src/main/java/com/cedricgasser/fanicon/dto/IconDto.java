package com.cedricgasser.fanicon.dto;

import com.cedricgasser.fanicon.model.Theme;

import java.io.Serializable;

public class IconDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String name;
    private final String svg;
    private final long themeId;
    private final String style;
    private final Boolean isCopyrighted;
    private final String copyrightSource;
    private final int position;

    public IconDto(String name, String svg, long themeId, String style, Boolean isCopyrighted, String copyrightSource, int position){
        this.name = name;
        this.svg = svg;
        this.themeId = themeId;
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

    public long getThemeId() {
        return themeId;
    }
}
