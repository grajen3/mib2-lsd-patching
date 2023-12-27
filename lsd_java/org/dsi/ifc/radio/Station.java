/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

import org.dsi.ifc.global.ResourceLocator;

public class Station {
    public String name;
    public long frequency;
    public int pi;
    public int receptionQuality;
    public int ptyCode;
    public int waveband;
    public boolean rds;
    public boolean tp;
    public boolean ta;
    public boolean tmc;
    public boolean scrollingPS;
    public boolean radioText;
    public String realPS;
    public boolean hd;
    public String shortNameHD;
    public String longNameHD;
    public boolean fullDigital;
    public int serviceId;
    public int subscription;
    public boolean eon;
    public boolean coChannel;
    public ResourceLocator stationArt;

    public Station() {
        this.name = "";
        this.frequency = 0L;
        this.pi = 0;
        this.receptionQuality = 0;
        this.ptyCode = 0;
        this.waveband = 0;
        this.rds = false;
        this.tp = false;
        this.ta = false;
        this.tmc = false;
        this.scrollingPS = false;
        this.radioText = false;
        this.realPS = "";
        this.hd = false;
        this.shortNameHD = "";
        this.longNameHD = "";
        this.fullDigital = false;
        this.serviceId = 0;
        this.subscription = 0;
        this.eon = false;
        this.coChannel = false;
        this.stationArt = null;
    }

    public Station(String string, long l, int n, int n2, int n3, int n4, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, String string2, boolean bl7, String string3, String string4, boolean bl8, int n5, int n6, boolean bl9, boolean bl10, ResourceLocator resourceLocator) {
        this.name = string;
        this.frequency = l;
        this.pi = n;
        this.receptionQuality = n2;
        this.ptyCode = n3;
        this.waveband = n4;
        this.rds = bl;
        this.tp = bl2;
        this.ta = bl3;
        this.tmc = bl4;
        this.scrollingPS = bl5;
        this.radioText = bl6;
        this.realPS = string2;
        this.hd = bl7;
        this.shortNameHD = string3;
        this.longNameHD = string4;
        this.fullDigital = bl8;
        this.serviceId = n5;
        this.subscription = n6;
        this.eon = bl9;
        this.coChannel = bl10;
        this.stationArt = resourceLocator;
    }

    public boolean isRadioText() {
        return this.radioText;
    }

    public String getRealPS() {
        return this.realPS;
    }

    public String getShortNameHD() {
        return this.shortNameHD;
    }

    public String getLongNameHD() {
        return this.longNameHD;
    }

    public int getServiceId() {
        return this.serviceId;
    }

    public String getName() {
        return this.name;
    }

    public long getFrequency() {
        return this.frequency;
    }

    public int getPi() {
        return this.pi;
    }

    public int getReceptionQuality() {
        return this.receptionQuality;
    }

    public int getPtyCode() {
        return this.ptyCode;
    }

    public int getWaveband() {
        return this.waveband;
    }

    public boolean isRds() {
        return this.rds;
    }

    public boolean isTp() {
        return this.tp;
    }

    public boolean isTa() {
        return this.ta;
    }

    public boolean isTmc() {
        return this.tmc;
    }

    public boolean isScrollingPS() {
        return this.scrollingPS;
    }

    public boolean isHd() {
        return this.hd;
    }

    public boolean isFullDigital() {
        return this.fullDigital;
    }

    public int getSubscription() {
        return this.subscription;
    }

    public boolean isEon() {
        return this.eon;
    }

    public boolean isCoChannel() {
        return this.coChannel;
    }

    public ResourceLocator getStationArt() {
        return this.stationArt;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2050);
        stringBuffer.append("Station");
        stringBuffer.append('(');
        stringBuffer.append("name");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.name);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("frequency");
        stringBuffer.append('=');
        stringBuffer.append(this.frequency);
        stringBuffer.append(',');
        stringBuffer.append("pi");
        stringBuffer.append('=');
        stringBuffer.append(this.pi);
        stringBuffer.append(',');
        stringBuffer.append("receptionQuality");
        stringBuffer.append('=');
        stringBuffer.append(this.receptionQuality);
        stringBuffer.append(',');
        stringBuffer.append("ptyCode");
        stringBuffer.append('=');
        stringBuffer.append(this.ptyCode);
        stringBuffer.append(',');
        stringBuffer.append("waveband");
        stringBuffer.append('=');
        stringBuffer.append(this.waveband);
        stringBuffer.append(',');
        stringBuffer.append("rds");
        stringBuffer.append('=');
        stringBuffer.append(this.rds);
        stringBuffer.append(',');
        stringBuffer.append("tp");
        stringBuffer.append('=');
        stringBuffer.append(this.tp);
        stringBuffer.append(',');
        stringBuffer.append("ta");
        stringBuffer.append('=');
        stringBuffer.append(this.ta);
        stringBuffer.append(',');
        stringBuffer.append("tmc");
        stringBuffer.append('=');
        stringBuffer.append(this.tmc);
        stringBuffer.append(',');
        stringBuffer.append("scrollingPS");
        stringBuffer.append('=');
        stringBuffer.append(this.scrollingPS);
        stringBuffer.append(',');
        stringBuffer.append("radioText");
        stringBuffer.append('=');
        stringBuffer.append(this.radioText);
        stringBuffer.append(',');
        stringBuffer.append("realPS");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.realPS);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("hd");
        stringBuffer.append('=');
        stringBuffer.append(this.hd);
        stringBuffer.append(',');
        stringBuffer.append("shortNameHD");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.shortNameHD);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("longNameHD");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.longNameHD);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("fullDigital");
        stringBuffer.append('=');
        stringBuffer.append(this.fullDigital);
        stringBuffer.append(',');
        stringBuffer.append("serviceId");
        stringBuffer.append('=');
        stringBuffer.append(this.serviceId);
        stringBuffer.append(',');
        stringBuffer.append("subscription");
        stringBuffer.append('=');
        stringBuffer.append(this.subscription);
        stringBuffer.append(',');
        stringBuffer.append("eon");
        stringBuffer.append('=');
        stringBuffer.append(this.eon);
        stringBuffer.append(',');
        stringBuffer.append("coChannel");
        stringBuffer.append('=');
        stringBuffer.append(this.coChannel);
        stringBuffer.append(',');
        stringBuffer.append("stationArt");
        stringBuffer.append('=');
        stringBuffer.append(this.stationArt);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

