/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

public class LDListElement {
    public long id;
    public long flag;
    public String title;
    public String codedTitle;

    public LDListElement() {
        this.id = 0L;
        this.flag = 0L;
        this.title = null;
        this.codedTitle = null;
    }

    public LDListElement(long l, long l2, String string, String string2) {
        this.id = l;
        this.flag = l2;
        this.title = string;
        this.codedTitle = string2;
    }

    public long getId() {
        return this.id;
    }

    public long getFlag() {
        return this.flag;
    }

    public String getTitle() {
        return this.title;
    }

    public String getCodedTitle() {
        return this.codedTitle;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("LDListElement");
        stringBuffer.append('(');
        stringBuffer.append("id");
        stringBuffer.append('=');
        stringBuffer.append(this.id);
        stringBuffer.append(',');
        stringBuffer.append("flag");
        stringBuffer.append('=');
        stringBuffer.append(this.flag);
        stringBuffer.append(',');
        stringBuffer.append("title");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.title);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("codedTitle");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.codedTitle);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

