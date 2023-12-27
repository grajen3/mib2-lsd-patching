/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.map;

public class LayerProperty {
    public String iconFilename;
    public String text;
    public int uId;
    public int parent;
    public int layerType;

    public LayerProperty() {
        this.iconFilename = null;
        this.text = null;
        this.uId = 0;
        this.parent = 0;
    }

    public LayerProperty(String string, String string2, int n, int n2, int n3) {
        this.iconFilename = string;
        this.text = string2;
        this.uId = n;
        this.parent = n2;
        this.layerType = n3;
    }

    public String getIconFilename() {
        return this.iconFilename;
    }

    public String getText() {
        return this.text;
    }

    public int getUId() {
        return this.uId;
    }

    public int getParent() {
        return this.parent;
    }

    public int getLayerType() {
        return this.layerType;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("LayerProperty");
        stringBuffer.append('(');
        stringBuffer.append("iconFilename");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.iconFilename);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("text");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.text);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("uId");
        stringBuffer.append('=');
        stringBuffer.append(this.uId);
        stringBuffer.append(',');
        stringBuffer.append("parent");
        stringBuffer.append('=');
        stringBuffer.append(this.parent);
        stringBuffer.append(',');
        stringBuffer.append("layerType");
        stringBuffer.append('=');
        stringBuffer.append(this.layerType);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

