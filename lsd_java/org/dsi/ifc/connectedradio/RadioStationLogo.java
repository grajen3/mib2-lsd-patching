/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.connectedradio;

import org.dsi.ifc.global.ResourceLocator;

public class RadioStationLogo {
    public int width;
    public int height;
    public ResourceLocator pathToFile;

    public RadioStationLogo() {
        this.width = 0;
        this.height = 0;
        this.pathToFile = null;
    }

    public RadioStationLogo(int n, int n2, ResourceLocator resourceLocator) {
        this.width = n;
        this.height = n2;
        this.pathToFile = resourceLocator;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public ResourceLocator getPathToFile() {
        return this.pathToFile;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1150);
        stringBuffer.append("RadioStationLogo");
        stringBuffer.append('(');
        stringBuffer.append("width");
        stringBuffer.append('=');
        stringBuffer.append(this.width);
        stringBuffer.append(',');
        stringBuffer.append("height");
        stringBuffer.append('=');
        stringBuffer.append(this.height);
        stringBuffer.append(',');
        stringBuffer.append("pathToFile");
        stringBuffer.append('=');
        stringBuffer.append(this.pathToFile);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

