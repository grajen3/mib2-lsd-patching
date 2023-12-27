/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

public class EntryMeter {
    public int profile;
    public int localEntries;
    public int meEntries;
    public int simEntries;
    public int oppEntries;

    public EntryMeter() {
        this.profile = 0;
        this.localEntries = 0;
        this.meEntries = 0;
        this.simEntries = 0;
        this.oppEntries = 0;
    }

    public EntryMeter(int n, int n2, int n3, int n4, int n5) {
        this.profile = n;
        this.localEntries = n2;
        this.meEntries = n3;
        this.simEntries = n4;
        this.oppEntries = n5;
    }

    public int getProfile() {
        return this.profile;
    }

    public int getLocalEntries() {
        return this.localEntries;
    }

    public int getMeEntries() {
        return this.meEntries;
    }

    public int getSimEntries() {
        return this.simEntries;
    }

    public int getOppEntries() {
        return this.oppEntries;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("EntryMeter");
        stringBuffer.append('(');
        stringBuffer.append("profile");
        stringBuffer.append('=');
        stringBuffer.append(this.profile);
        stringBuffer.append(',');
        stringBuffer.append("localEntries");
        stringBuffer.append('=');
        stringBuffer.append(this.localEntries);
        stringBuffer.append(',');
        stringBuffer.append("meEntries");
        stringBuffer.append('=');
        stringBuffer.append(this.meEntries);
        stringBuffer.append(',');
        stringBuffer.append("simEntries");
        stringBuffer.append('=');
        stringBuffer.append(this.simEntries);
        stringBuffer.append(',');
        stringBuffer.append("oppEntries");
        stringBuffer.append('=');
        stringBuffer.append(this.oppEntries);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

