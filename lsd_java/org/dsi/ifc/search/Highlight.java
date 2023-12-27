/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.search;

public class Highlight {
    public int highlightStart;
    public int highlightEnd;
    public int type;

    public Highlight() {
        this.highlightStart = 0;
        this.highlightEnd = 0;
    }

    public Highlight(int n, int n2) {
        this.highlightStart = n;
        this.highlightEnd = n2;
    }

    public Highlight(int n, int n2, int n3) {
        this.highlightStart = n;
        this.highlightEnd = n2;
        this.type = n3;
    }

    public int getHighlightStart() {
        return this.highlightStart;
    }

    public int getHighlightEnd() {
        return this.highlightEnd;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("Highlight");
        stringBuffer.append('(');
        stringBuffer.append("highlightStart");
        stringBuffer.append('=');
        stringBuffer.append(this.highlightStart);
        stringBuffer.append(',');
        stringBuffer.append("highlightEnd");
        stringBuffer.append('=');
        stringBuffer.append(this.highlightEnd);
        stringBuffer.append(',');
        stringBuffer.append("type");
        stringBuffer.append('=');
        stringBuffer.append(this.type);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

