/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombisync;

public class MenuState {
    public int fas;
    public int loading;
    public int favorite;
    public int carViewer;
    public int service;
    public int auxHeater;
    public int airCondition;
    public int vehicleSettings;
    public int office;
    public int race;
    public int systemsettings;
    public int tone;
    public int connect;
    public int profile;
    public int driveSelect;
    public int bordbook;
    public int connectivityManager;
    public int etc;
    public int reserve2;
    public int reserve3;
    public int bCall;
    public int cCall;
    public int vics;
    public int tpeg;

    public MenuState() {
        this.fas = 0;
        this.loading = 0;
        this.favorite = 0;
        this.carViewer = 0;
        this.service = 0;
        this.auxHeater = 0;
        this.airCondition = 0;
        this.vehicleSettings = 0;
        this.office = 0;
        this.race = 0;
        this.driveSelect = 0;
        this.systemsettings = 0;
        this.tone = 0;
        this.connect = 0;
        this.profile = 0;
        this.bordbook = 0;
        this.connectivityManager = 0;
        this.etc = 0;
        this.reserve2 = 0;
        this.reserve3 = 0;
        this.bCall = 0;
        this.cCall = 0;
        this.vics = 0;
        this.tpeg = 0;
    }

    public MenuState(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, int n12, int n13, int n14, int n15) {
        this.fas = n;
        this.loading = n2;
        this.favorite = n3;
        this.carViewer = n4;
        this.service = n5;
        this.auxHeater = n6;
        this.airCondition = n7;
        this.vehicleSettings = n8;
        this.office = n9;
        this.race = n10;
        this.systemsettings = n11;
        this.tone = n12;
        this.connect = n13;
        this.profile = n14;
        this.driveSelect = n15;
        this.bordbook = 0;
        this.connectivityManager = 0;
        this.etc = 0;
        this.reserve2 = 0;
        this.reserve3 = 0;
        this.bCall = 0;
        this.cCall = 0;
        this.vics = 0;
        this.tpeg = 0;
    }

    public MenuState(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, int n12, int n13, int n14, int n15, int n16, int n17, int n18, int n19, int n20, int n21, int n22, int n23, int n24) {
        this.fas = n;
        this.loading = n2;
        this.favorite = n3;
        this.carViewer = n4;
        this.service = n5;
        this.auxHeater = n6;
        this.airCondition = n7;
        this.vehicleSettings = n8;
        this.office = n9;
        this.race = n10;
        this.systemsettings = n11;
        this.tone = n12;
        this.connect = n13;
        this.profile = n14;
        this.driveSelect = n15;
        this.bordbook = n16;
        this.connectivityManager = n17;
        this.etc = n18;
        this.reserve2 = n19;
        this.reserve3 = n20;
        this.bCall = n21;
        this.cCall = n22;
        this.vics = n23;
        this.tpeg = n24;
    }

    public int getFas() {
        return this.fas;
    }

    public int getLoading() {
        return this.loading;
    }

    public int getFavorite() {
        return this.favorite;
    }

    public int getCarViewer() {
        return this.carViewer;
    }

    public int getService() {
        return this.service;
    }

    public int getAuxHeater() {
        return this.auxHeater;
    }

    public int getAirCondition() {
        return this.airCondition;
    }

    public int getVehicleSettings() {
        return this.vehicleSettings;
    }

    public int getOffice() {
        return this.office;
    }

    public int getRace() {
        return this.race;
    }

    public int getSystemsettings() {
        return this.systemsettings;
    }

    public int getTone() {
        return this.tone;
    }

    public int getConnect() {
        return this.connect;
    }

    public int getProfile() {
        return this.profile;
    }

    public int getDriveSelect() {
        return this.driveSelect;
    }

    public int getBordbook() {
        return this.bordbook;
    }

    public int getConnectivityManager() {
        return this.connectivityManager;
    }

    public int getEtc() {
        return this.etc;
    }

    public int getReserve2() {
        return this.reserve2;
    }

    public int getReserve3() {
        return this.reserve3;
    }

    public int getBCall() {
        return this.bCall;
    }

    public int getCCall() {
        return this.cCall;
    }

    public int getVics() {
        return this.vics;
    }

    public int getTpeg() {
        return this.tpeg;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1150);
        stringBuffer.append("MenuState");
        stringBuffer.append('(');
        stringBuffer.append("fas");
        stringBuffer.append('=');
        stringBuffer.append(this.fas);
        stringBuffer.append(',');
        stringBuffer.append("loading");
        stringBuffer.append('=');
        stringBuffer.append(this.loading);
        stringBuffer.append(',');
        stringBuffer.append("favorite");
        stringBuffer.append('=');
        stringBuffer.append(this.favorite);
        stringBuffer.append(',');
        stringBuffer.append("carViewer");
        stringBuffer.append('=');
        stringBuffer.append(this.carViewer);
        stringBuffer.append(',');
        stringBuffer.append("service");
        stringBuffer.append('=');
        stringBuffer.append(this.service);
        stringBuffer.append(',');
        stringBuffer.append("auxHeater");
        stringBuffer.append('=');
        stringBuffer.append(this.auxHeater);
        stringBuffer.append(',');
        stringBuffer.append("airCondition");
        stringBuffer.append('=');
        stringBuffer.append(this.airCondition);
        stringBuffer.append(',');
        stringBuffer.append("vehicleSettings");
        stringBuffer.append('=');
        stringBuffer.append(this.vehicleSettings);
        stringBuffer.append(',');
        stringBuffer.append("office");
        stringBuffer.append('=');
        stringBuffer.append(this.office);
        stringBuffer.append(',');
        stringBuffer.append("race");
        stringBuffer.append('=');
        stringBuffer.append(this.race);
        stringBuffer.append(',');
        stringBuffer.append("systemsettings");
        stringBuffer.append('=');
        stringBuffer.append(this.systemsettings);
        stringBuffer.append(',');
        stringBuffer.append("tone");
        stringBuffer.append('=');
        stringBuffer.append(this.tone);
        stringBuffer.append(',');
        stringBuffer.append("connect");
        stringBuffer.append('=');
        stringBuffer.append(this.connect);
        stringBuffer.append(',');
        stringBuffer.append("profile");
        stringBuffer.append('=');
        stringBuffer.append(this.profile);
        stringBuffer.append(',');
        stringBuffer.append("driveSelect");
        stringBuffer.append('=');
        stringBuffer.append(this.driveSelect);
        stringBuffer.append(',');
        stringBuffer.append("bordbook");
        stringBuffer.append('=');
        stringBuffer.append(this.bordbook);
        stringBuffer.append(',');
        stringBuffer.append("connectivityManager");
        stringBuffer.append('=');
        stringBuffer.append(this.connectivityManager);
        stringBuffer.append(',');
        stringBuffer.append("etc");
        stringBuffer.append('=');
        stringBuffer.append(this.etc);
        stringBuffer.append(',');
        stringBuffer.append("reserve2");
        stringBuffer.append('=');
        stringBuffer.append(this.reserve2);
        stringBuffer.append(',');
        stringBuffer.append("reserve3");
        stringBuffer.append('=');
        stringBuffer.append(this.reserve3);
        stringBuffer.append(',');
        stringBuffer.append("bCall");
        stringBuffer.append('=');
        stringBuffer.append(this.bCall);
        stringBuffer.append(',');
        stringBuffer.append("cCall");
        stringBuffer.append('=');
        stringBuffer.append(this.cCall);
        stringBuffer.append(',');
        stringBuffer.append("vics");
        stringBuffer.append('=');
        stringBuffer.append(this.vics);
        stringBuffer.append(',');
        stringBuffer.append("tpeg");
        stringBuffer.append('=');
        stringBuffer.append(this.tpeg);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

