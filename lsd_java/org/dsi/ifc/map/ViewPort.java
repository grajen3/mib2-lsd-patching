/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.map;

import org.dsi.ifc.global.NavLocationWgs84;

public class ViewPort {
    public NavLocationWgs84 position;
    public short rotation;
    public int zoomIdx;

    public ViewPort() {
        this.position = null;
        this.rotation = 0;
        this.zoomIdx = 0;
    }

    public ViewPort(NavLocationWgs84 navLocationWgs84, short s, int n) {
        this.position = navLocationWgs84;
        this.rotation = s;
        this.zoomIdx = n;
    }

    public NavLocationWgs84 getPosition() {
        return this.position;
    }

    public short getRotation() {
        return this.rotation;
    }

    public int getZoomIdx() {
        return this.zoomIdx;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1150);
        stringBuffer.append("ViewPort");
        stringBuffer.append('(');
        stringBuffer.append("position");
        stringBuffer.append('=');
        stringBuffer.append(this.position);
        stringBuffer.append(',');
        stringBuffer.append("rotation");
        stringBuffer.append('=');
        stringBuffer.append(this.rotation);
        stringBuffer.append(',');
        stringBuffer.append("zoomIdx");
        stringBuffer.append('=');
        stringBuffer.append(this.zoomIdx);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

