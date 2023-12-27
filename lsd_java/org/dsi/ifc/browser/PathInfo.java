/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.browser;

public class PathInfo {
    public int format;
    public String path;

    public PathInfo() {
    }

    public PathInfo(int n, String string) {
        this.format = n;
        this.path = string;
    }

    public int getFormat() {
        return this.format;
    }

    public void setFormat(int n) {
        this.format = n;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String string) {
        this.path = string;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("PathInfo");
        stringBuffer.append('(');
        stringBuffer.append("format");
        stringBuffer.append('=');
        stringBuffer.append(this.format);
        stringBuffer.append(',');
        stringBuffer.append("path");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.path);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

