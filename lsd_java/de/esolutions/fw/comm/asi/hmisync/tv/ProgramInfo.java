/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.tv;

public class ProgramInfo {
    public String name;
    public int startHour;
    public int startMinute;
    public int startSecond;
    public int endHour;
    public int endMinute;
    public int endSecond;

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public int getStartHour() {
        return this.startHour;
    }

    public void setStartHour(int n) {
        this.startHour = n;
    }

    public int getStartMinute() {
        return this.startMinute;
    }

    public void setStartMinute(int n) {
        this.startMinute = n;
    }

    public int getStartSecond() {
        return this.startSecond;
    }

    public void setStartSecond(int n) {
        this.startSecond = n;
    }

    public int getEndHour() {
        return this.endHour;
    }

    public void setEndHour(int n) {
        this.endHour = n;
    }

    public int getEndMinute() {
        return this.endMinute;
    }

    public void setEndMinute(int n) {
        this.endMinute = n;
    }

    public int getEndSecond() {
        return this.endSecond;
    }

    public void setEndSecond(int n) {
        this.endSecond = n;
    }

    public ProgramInfo() {
    }

    public ProgramInfo(String string, int n, int n2, int n3, int n4, int n5, int n6) {
        this.name = string;
        this.startHour = n;
        this.startMinute = n2;
        this.startSecond = n3;
        this.endHour = n4;
        this.endMinute = n5;
        this.endSecond = n6;
    }

    public String toString() {
        return new StringBuffer("ProgramInfo{").append("name=").append(this.name).append(", startHour=").append(this.startHour).append(", startMinute=").append(this.startMinute).append(", startSecond=").append(this.startSecond).append(", endHour=").append(this.endHour).append(", endMinute=").append(this.endMinute).append(", endSecond=").append(this.endSecond).append("}").toString();
    }
}

