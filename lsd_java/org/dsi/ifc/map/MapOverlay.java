/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.map;

import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.map.Rect;

public class MapOverlay {
    public String path;
    public NavRectangle rectangle;
    public String description;
    public Rect textFieldBoundingBox;

    public MapOverlay() {
        this.path = null;
        this.rectangle = null;
        this.description = null;
        this.textFieldBoundingBox = null;
    }

    public MapOverlay(String string, NavRectangle navRectangle, String string2, Rect rect) {
        this.path = string;
        this.rectangle = navRectangle;
        this.description = string2;
        this.textFieldBoundingBox = rect;
    }

    public String getPath() {
        return this.path;
    }

    public NavRectangle getRectangle() {
        return this.rectangle;
    }

    public String getDescription() {
        return this.description;
    }

    public Rect getTextFieldBoundingBox() {
        return this.textFieldBoundingBox;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2250);
        stringBuffer.append("MapOverlay");
        stringBuffer.append('(');
        stringBuffer.append("path");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.path);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("rectangle");
        stringBuffer.append('=');
        stringBuffer.append(this.rectangle);
        stringBuffer.append(',');
        stringBuffer.append("description");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.description);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("textFieldBoundingBox");
        stringBuffer.append('=');
        stringBuffer.append(this.textFieldBoundingBox);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

