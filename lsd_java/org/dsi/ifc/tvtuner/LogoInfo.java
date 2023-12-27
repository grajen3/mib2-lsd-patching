/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tvtuner;

import org.dsi.ifc.global.ResourceLocator;

public class LogoInfo {
    public long namePID;
    public ResourceLocator channelLogo;

    public LogoInfo() {
        this.namePID = 0L;
        this.channelLogo = null;
    }

    public LogoInfo(long l, ResourceLocator resourceLocator) {
        this.namePID = l;
        this.channelLogo = resourceLocator;
    }

    public long getNamePID() {
        return this.namePID;
    }

    public ResourceLocator getChannelLogo() {
        return this.channelLogo;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1100);
        stringBuffer.append("LogoInfo");
        stringBuffer.append('(');
        stringBuffer.append("namePID");
        stringBuffer.append('=');
        stringBuffer.append(this.namePID);
        stringBuffer.append(',');
        stringBuffer.append("channelLogo");
        stringBuffer.append('=');
        stringBuffer.append(this.channelLogo);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

