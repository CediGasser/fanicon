package com.cedricgasser.fanicon.dto;

import java.io.Serializable;
import java.util.List;

public class DesignDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Long id;
    private final String name;
    private final String bgColor;

    private final String iconSize;
    private final String iconMargin;
    private final String userName;

    private final List<IconInDesignDto> icons;

    public DesignDto(Long id, String name, String bgColor, String iconSize, String iconMargin, String UserName, List<IconInDesignDto> icons){

        this.id = id;
        this.name = name;
        this.bgColor = bgColor;
        this.iconSize = iconSize;
        this.iconMargin = iconMargin;
        this.userName = UserName;
        this.icons = icons;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBgColor() {
        return bgColor;
    }

    public String getIconSize() {
        return iconSize;
    }

    public String getIconMargin() {
        return iconMargin;
    }

    public String getUserName() {
        return userName;
    }

    public List<IconInDesignDto> getIcons() {
        return icons;
    }
}
