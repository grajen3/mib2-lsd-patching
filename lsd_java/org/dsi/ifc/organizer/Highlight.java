/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

public class Highlight {
    public int gendescription;
    public int highlightStart;
    public int highlightEnd;

    public Highlight() {
        this.gendescription = 1;
        this.highlightStart = 0;
        this.highlightStart = 1;
    }

    public Highlight(int n, int n2, int n3) {
        this.gendescription = n;
        this.highlightStart = n2;
        this.highlightEnd = n3;
    }

    public int getGendescription() {
        return this.gendescription;
    }

    public int getHighlightStart() {
        return this.highlightStart;
    }

    public int getHighlightEnd() {
        return this.highlightEnd;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("Highlight");
        stringBuffer.append('(');
        stringBuffer.append("gendescription");
        stringBuffer.append('=');
        stringBuffer.append(this.gendescription);
        stringBuffer.append(',');
        stringBuffer.append("highlightStart");
        stringBuffer.append('=');
        stringBuffer.append(this.highlightStart);
        stringBuffer.append(',');
        stringBuffer.append("highlightEnd");
        stringBuffer.append('=');
        stringBuffer.append(this.highlightEnd);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

