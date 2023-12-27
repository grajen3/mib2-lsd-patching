/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.picturestore;

public class PictureAttribute {
    public String key;
    public String value;

    public PictureAttribute() {
        this.key = null;
        this.value = null;
    }

    public PictureAttribute(String string, String string2) {
        this.key = string;
        this.value = string2;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String string) {
        this.key = string;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String string) {
        this.value = string;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("PictureAttribute");
        stringBuffer.append('(');
        stringBuffer.append("key");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.key);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("value");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.value);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

