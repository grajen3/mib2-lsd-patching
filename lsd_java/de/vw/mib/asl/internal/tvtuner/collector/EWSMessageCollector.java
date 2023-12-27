/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.collector;

public class EWSMessageCollector {
    private String stationName;
    private int warningTimeMinutes;
    private int warningTimeHours;
    private int warningType;
    private int affectedArea;
    private int warningPrio;
    private int warningSrcClass;

    public EWSMessageCollector() {
        this.stationName = "";
        this.warningTimeMinutes = 0;
        this.warningTimeHours = 0;
        this.warningType = 0;
        this.affectedArea = 0;
        this.warningPrio = 0;
        this.warningSrcClass = 0;
    }

    public EWSMessageCollector(String string, int n, int n2, int n3, int n4, int n5, int n6) {
        this.stationName = string;
        this.warningTimeMinutes = n;
        this.warningTimeHours = n2;
        this.warningType = n3;
        this.affectedArea = n4;
        this.warningPrio = n5;
        this.warningSrcClass = n6;
    }

    public String getStationName() {
        return this.stationName;
    }

    public void setStationName(String string) {
        this.stationName = string;
    }

    public int getWarningTimeMinutes() {
        return this.warningTimeMinutes;
    }

    public void setWarningTimeMinutes(int n) {
        this.warningTimeMinutes = n;
    }

    public int getWarningTimeHours() {
        return this.warningTimeHours;
    }

    public void setWarningTimeHours(int n) {
        this.warningTimeHours = n;
    }

    public int getWarningType() {
        return this.warningType;
    }

    public void setWarningType(int n) {
        this.warningType = n;
    }

    public int getAffectedArea() {
        return this.affectedArea;
    }

    public void setAffectedArea(int n) {
        this.affectedArea = n;
    }

    public int getWarningPrio() {
        return this.warningPrio;
    }

    public void setWarningPrio(int n) {
        this.warningPrio = n;
    }

    public int getWarningSrcClass() {
        return this.warningSrcClass;
    }

    public void setWarningSrcClass(int n) {
        this.warningSrcClass = n;
    }
}

