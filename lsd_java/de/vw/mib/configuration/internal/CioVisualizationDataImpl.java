/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.configuration.internal;

import de.vw.mib.app.framework.assembly.CioVisualizationData;

public class CioVisualizationDataImpl
implements CioVisualizationData {
    private String name;
    private String text;
    private String textColor;
    private String textGlowColor;
    private String icon;
    private String iconColor;
    private String iconGlowColor;
    private String contextColor;

    public CioVisualizationDataImpl(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8) {
        this.name = string;
        this.text = string2;
        this.textColor = string3;
        this.textGlowColor = string4;
        this.icon = string5;
        this.iconColor = string6;
        this.iconGlowColor = string7;
        this.contextColor = string8;
    }

    @Override
    public String getContextColor() {
        return this.contextColor;
    }

    @Override
    public String getIcon() {
        return this.icon;
    }

    @Override
    public String getIconColor() {
        return this.iconColor;
    }

    @Override
    public String getIconGlowColor() {
        return this.iconGlowColor;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getText() {
        return this.text;
    }

    @Override
    public String getTextColor() {
        return this.textColor;
    }

    @Override
    public String getTextGlowColor() {
        return this.textGlowColor;
    }
}

