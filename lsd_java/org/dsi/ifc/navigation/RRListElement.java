/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

public class RRListElement {
    public long id;
    public long flag;
    public String title;

    public RRListElement() {
        this.id = 0L;
        this.flag = 0L;
        this.title = null;
    }

    public RRListElement(long l, long l2, String string) {
        this.id = l;
        this.flag = l2;
        this.title = string;
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

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("RRListElement");
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
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

