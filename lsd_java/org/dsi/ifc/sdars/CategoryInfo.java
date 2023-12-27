/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.sdars;

public class CategoryInfo {
    public short categoryNumber;
    public String shortLabel;
    public String fullLabel;

    public CategoryInfo() {
        this.categoryNumber = 0;
        this.shortLabel = null;
        this.fullLabel = null;
    }

    public CategoryInfo(short s, String string, String string2) {
        this.categoryNumber = s;
        this.shortLabel = string;
        this.fullLabel = string2;
    }

    public short getCategoryNumber() {
        return this.categoryNumber;
    }

    public String getShortLabel() {
        return this.shortLabel;
    }

    public String getFullLabel() {
        return this.fullLabel;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("CategoryInfo");
        stringBuffer.append('(');
        stringBuffer.append("categoryNumber");
        stringBuffer.append('=');
        stringBuffer.append(this.categoryNumber);
        stringBuffer.append(',');
        stringBuffer.append("shortLabel");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.shortLabel);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("fullLabel");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.fullLabel);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

