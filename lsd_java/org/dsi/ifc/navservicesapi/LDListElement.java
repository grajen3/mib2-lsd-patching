/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navservicesapi;

public class LDListElement {
    public long id;
    public String title;

    public LDListElement() {
        this.id = 0L;
        this.title = null;
    }

    public LDListElement(long l, String string) {
        this.id = l;
        this.title = string;
    }

    public long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("LDListElement");
        stringBuffer.append('(');
        stringBuffer.append("id");
        stringBuffer.append('=');
        stringBuffer.append(this.id);
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

