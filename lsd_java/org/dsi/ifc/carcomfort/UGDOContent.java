/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

public class UGDOContent {
    public int hardkey;
    public int softkey;
    public int content;

    public UGDOContent() {
        this.hardkey = 0;
        this.softkey = 0;
        this.content = 0;
    }

    public UGDOContent(int n, int n2, int n3) {
        this.hardkey = n;
        this.softkey = n2;
        this.content = n3;
    }

    public int getHardkey() {
        return this.hardkey;
    }

    public int getSoftkey() {
        return this.softkey;
    }

    public int getContent() {
        return this.content;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("UGDOContent");
        stringBuffer.append('(');
        stringBuffer.append("hardkey");
        stringBuffer.append('=');
        stringBuffer.append(this.hardkey);
        stringBuffer.append(',');
        stringBuffer.append("softkey");
        stringBuffer.append('=');
        stringBuffer.append(this.softkey);
        stringBuffer.append(',');
        stringBuffer.append("content");
        stringBuffer.append('=');
        stringBuffer.append(this.content);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

