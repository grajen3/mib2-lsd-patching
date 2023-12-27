/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.properties.values;

import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.iconhandling.TextRenderingInfo;

public final class LabeledIconValue {
    private ResourceLocator resourceLocator;
    private String text;
    private TextRenderingInfo textRenderingInfo;

    public LabeledIconValue() {
    }

    public LabeledIconValue(String string, ResourceLocator resourceLocator, TextRenderingInfo textRenderingInfo) {
        this.text = string;
        this.resourceLocator = resourceLocator;
        this.textRenderingInfo = textRenderingInfo;
    }

    public ResourceLocator getResourceLocator() {
        return this.resourceLocator;
    }

    public String getText() {
        return this.text;
    }

    public TextRenderingInfo getTextRenderingInfo() {
        return this.textRenderingInfo;
    }

    public void setResourceLocator(ResourceLocator resourceLocator) {
        this.resourceLocator = resourceLocator;
    }

    public void setText(String string) {
        this.text = string;
    }

    public void setTextRenderingInfo(TextRenderingInfo textRenderingInfo) {
        this.textRenderingInfo = textRenderingInfo;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("LabeledIconValue(");
        stringBuffer.append("text='").append(this.text).append("',");
        stringBuffer.append("resouceLocator=").append(this.resourceLocator).append(",");
        stringBuffer.append("textRenderingInfo=").append(this.textRenderingInfo).append(")");
        return stringBuffer.toString();
    }
}

