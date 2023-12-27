/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cartimeunitslanguage;

public class ClockSources {
    public boolean quartz;
    public boolean dcf77;
    public boolean gps;

    public ClockSources() {
        this.quartz = false;
        this.dcf77 = false;
        this.gps = false;
    }

    public ClockSources(boolean bl, boolean bl2, boolean bl3) {
        this.quartz = bl;
        this.dcf77 = bl2;
        this.gps = bl3;
    }

    public boolean isQuartz() {
        return this.quartz;
    }

    public boolean isDcf77() {
        return this.dcf77;
    }

    public boolean isGps() {
        return this.gps;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("ClockSources");
        stringBuffer.append('(');
        stringBuffer.append("quartz");
        stringBuffer.append('=');
        stringBuffer.append(this.quartz);
        stringBuffer.append(',');
        stringBuffer.append("dcf77");
        stringBuffer.append('=');
        stringBuffer.append(this.dcf77);
        stringBuffer.append(',');
        stringBuffer.append("gps");
        stringBuffer.append('=');
        stringBuffer.append(this.gps);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

