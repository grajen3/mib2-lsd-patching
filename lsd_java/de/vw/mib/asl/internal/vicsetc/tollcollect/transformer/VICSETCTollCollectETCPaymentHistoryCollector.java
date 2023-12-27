/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc.tollcollect.transformer;

public class VICSETCTollCollectETCPaymentHistoryCollector {
    private int minute = 0;
    private int hour = 0;
    private int day = 1;
    private int month = 1;
    private int year = 1970;
    private int gateCost = 0;
    private String entranceIC = "";
    private String exitIC = "";
    private String informationGateCost = "";

    public int getDay() {
        return this.day;
    }

    public void setDay(int n) {
        this.day = n;
    }

    public int getGateCost() {
        return this.gateCost;
    }

    public void setGateCost(int n) {
        this.gateCost = n;
    }

    public int getHour() {
        return this.hour;
    }

    public void setHour(int n) {
        this.hour = n;
    }

    public int getMinute() {
        return this.minute;
    }

    public void setMinute(int n) {
        this.minute = n;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int n) {
        this.month = n;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int n) {
        this.year = n;
    }

    public String getEntranceIC() {
        return this.entranceIC;
    }

    public void setEntranceIC(String string) {
        this.entranceIC = string;
    }

    public String getExitIC() {
        return this.exitIC;
    }

    public void setExitIC(String string) {
        this.exitIC = string;
    }

    public String getInformationGateCost() {
        return this.informationGateCost;
    }

    public void setInformationGateCost(String string) {
        this.informationGateCost = string;
    }
}

