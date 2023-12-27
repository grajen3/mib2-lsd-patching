/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.mirrorlink;

import org.dsi.ifc.mirrorlink.DisplayCapabilities;
import org.dsi.ifc.mirrorlink.IconCapabilities;

public class ClientCapabilities {
    public DisplayCapabilities displayCapabilities;
    public IconCapabilities iconCapabilities;
    public int numberOfSimultaneousEvents;

    public ClientCapabilities() {
        this.displayCapabilities = null;
        this.iconCapabilities = null;
        this.numberOfSimultaneousEvents = 0;
    }

    public ClientCapabilities(DisplayCapabilities displayCapabilities, IconCapabilities iconCapabilities, int n) {
        this.displayCapabilities = displayCapabilities;
        this.iconCapabilities = iconCapabilities;
        this.numberOfSimultaneousEvents = n;
    }

    public DisplayCapabilities getDisplayCapabilities() {
        return this.displayCapabilities;
    }

    public IconCapabilities getIconCapabilities() {
        return this.iconCapabilities;
    }

    public int getNumberOfSimultaneousEvents() {
        return this.numberOfSimultaneousEvents;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2200);
        stringBuffer.append("ClientCapabilities");
        stringBuffer.append('(');
        stringBuffer.append("displayCapabilities");
        stringBuffer.append('=');
        stringBuffer.append(this.displayCapabilities);
        stringBuffer.append(',');
        stringBuffer.append("iconCapabilities");
        stringBuffer.append('=');
        stringBuffer.append(this.iconCapabilities);
        stringBuffer.append(',');
        stringBuffer.append("numberOfSimultaneousEvents");
        stringBuffer.append('=');
        stringBuffer.append(this.numberOfSimultaneousEvents);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

