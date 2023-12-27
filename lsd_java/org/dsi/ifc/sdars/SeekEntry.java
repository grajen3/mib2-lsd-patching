/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.sdars;

public class SeekEntry {
    public int seekID;
    public int contentLink;
    public int typeOfContent;
    public String title1;
    public String title2;
    public boolean seekActive;

    public SeekEntry() {
        this.seekID = 0;
        this.contentLink = 0;
        this.typeOfContent = 0;
        this.title1 = "";
        this.title2 = "";
        this.seekActive = false;
    }

    public SeekEntry(int n, int n2, int n3, String string, String string2, boolean bl) {
        this.seekID = n;
        this.contentLink = n2;
        this.typeOfContent = n3;
        this.title1 = string;
        this.title2 = string2;
        this.seekActive = bl;
    }

    public int getSeekID() {
        return this.seekID;
    }

    public int getContentLink() {
        return this.contentLink;
    }

    public int getTypeOfContent() {
        return this.typeOfContent;
    }

    public String getTitle1() {
        return this.title1;
    }

    public String getTitle2() {
        return this.title2;
    }

    public boolean isSeekActive() {
        return this.seekActive;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("SeekEntry");
        stringBuffer.append('(');
        stringBuffer.append("seekID");
        stringBuffer.append('=');
        stringBuffer.append(this.seekID);
        stringBuffer.append(',');
        stringBuffer.append("contentLink");
        stringBuffer.append('=');
        stringBuffer.append(this.contentLink);
        stringBuffer.append(',');
        stringBuffer.append("typeOfContent");
        stringBuffer.append('=');
        stringBuffer.append(this.typeOfContent);
        stringBuffer.append(',');
        stringBuffer.append("title1");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.title1);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("title2");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.title2);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("seekActive");
        stringBuffer.append('=');
        stringBuffer.append(this.seekActive);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

