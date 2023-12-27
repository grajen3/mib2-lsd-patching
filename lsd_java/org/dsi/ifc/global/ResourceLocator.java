/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.global;

public class ResourceLocator {
    public int id;
    public String url;

    public ResourceLocator() {
        this.id = -1;
        this.url = null;
    }

    public ResourceLocator(int n) {
        this.id = n;
        this.url = null;
    }

    public ResourceLocator(String string) {
        if (string == null) {
            throw new IllegalArgumentException();
        }
        this.url = string;
        this.id = -1;
    }

    public ResourceLocator(int n, String string) {
        this.id = n;
        this.url = string;
    }

    public final boolean isIntResource() {
        return this.url == null || this.url.length() == 0;
    }

    public int getId() {
        return this.id;
    }

    public String getUrl() {
        return this.url;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("ResourceLocator(");
        stringBuffer.append("Type is");
        if (this.isIntResource()) {
            stringBuffer.append("Integer");
            stringBuffer.append("; Value=");
            stringBuffer.append(this.id);
        } else {
            stringBuffer.append("URL");
            stringBuffer.append("; Value=");
            stringBuffer.append(this.url);
        }
        stringBuffer.append(")");
        return stringBuffer.toString();
    }
}

