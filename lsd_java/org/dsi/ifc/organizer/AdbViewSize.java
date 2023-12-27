/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

public class AdbViewSize {
    public int all;
    public int phone;
    public int navi;
    public int topDestinations;
    public int speedDials;
    public int voiceTags;
    public int usbStick;
    public int sd1;
    public int sd2;
    public int publicProfileEntries;
    public int publicTopDestinations;
    public int onlineDestination;

    public AdbViewSize() {
        this.all = 0;
        this.phone = 0;
        this.navi = 0;
        this.topDestinations = 0;
        this.speedDials = 0;
        this.voiceTags = 0;
        this.usbStick = 0;
        this.sd1 = 0;
        this.sd2 = 0;
        this.publicProfileEntries = 0;
        this.publicTopDestinations = 0;
        this.onlineDestination = 0;
    }

    public AdbViewSize(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, int n12) {
        this.all = n;
        this.phone = n2;
        this.navi = n3;
        this.topDestinations = n4;
        this.speedDials = n5;
        this.voiceTags = n6;
        this.usbStick = n7;
        this.sd1 = n8;
        this.sd2 = n9;
        this.publicProfileEntries = n10;
        this.publicTopDestinations = n11;
        this.onlineDestination = n12;
    }

    public int getAll() {
        return this.all;
    }

    public int getPhone() {
        return this.phone;
    }

    public int getNavi() {
        return this.navi;
    }

    public int getTopDestinations() {
        return this.topDestinations;
    }

    public int getSpeedDials() {
        return this.speedDials;
    }

    public int getVoiceTags() {
        return this.voiceTags;
    }

    public int getUsbStick() {
        return this.usbStick;
    }

    public int getSd1() {
        return this.sd1;
    }

    public int getSd2() {
        return this.sd2;
    }

    public int getPublicProfileEntries() {
        return this.publicProfileEntries;
    }

    public int getPublicTopDestinations() {
        return this.publicTopDestinations;
    }

    public int getOnlineDestination() {
        return this.onlineDestination;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(650);
        stringBuffer.append("AdbViewSize");
        stringBuffer.append('(');
        stringBuffer.append("all");
        stringBuffer.append('=');
        stringBuffer.append(this.all);
        stringBuffer.append(',');
        stringBuffer.append("phone");
        stringBuffer.append('=');
        stringBuffer.append(this.phone);
        stringBuffer.append(',');
        stringBuffer.append("navi");
        stringBuffer.append('=');
        stringBuffer.append(this.navi);
        stringBuffer.append(',');
        stringBuffer.append("topDestinations");
        stringBuffer.append('=');
        stringBuffer.append(this.topDestinations);
        stringBuffer.append(',');
        stringBuffer.append("speedDials");
        stringBuffer.append('=');
        stringBuffer.append(this.speedDials);
        stringBuffer.append(',');
        stringBuffer.append("voiceTags");
        stringBuffer.append('=');
        stringBuffer.append(this.voiceTags);
        stringBuffer.append(',');
        stringBuffer.append("usbStick");
        stringBuffer.append('=');
        stringBuffer.append(this.usbStick);
        stringBuffer.append(',');
        stringBuffer.append("sd1");
        stringBuffer.append('=');
        stringBuffer.append(this.sd1);
        stringBuffer.append(',');
        stringBuffer.append("sd2");
        stringBuffer.append('=');
        stringBuffer.append(this.sd2);
        stringBuffer.append(',');
        stringBuffer.append("publicProfileEntries");
        stringBuffer.append('=');
        stringBuffer.append(this.publicProfileEntries);
        stringBuffer.append(',');
        stringBuffer.append("publicTopDestinations");
        stringBuffer.append('=');
        stringBuffer.append(this.publicTopDestinations);
        stringBuffer.append(',');
        stringBuffer.append("onlineDestination");
        stringBuffer.append('=');
        stringBuffer.append(this.onlineDestination);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

