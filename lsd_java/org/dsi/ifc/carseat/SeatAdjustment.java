/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carseat;

public class SeatAdjustment {
    public int position;
    public boolean sitzhoehe;
    public boolean sitzlaenge;
    public boolean lehnenneigung;
    public boolean sitzflaechenneigung;
    public boolean kopfstuetze;

    public SeatAdjustment() {
        this.position = 0;
        this.sitzhoehe = false;
        this.sitzlaenge = false;
        this.lehnenneigung = false;
        this.sitzflaechenneigung = false;
        this.kopfstuetze = false;
    }

    public SeatAdjustment(int n, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        this.position = n;
        this.sitzhoehe = bl;
        this.sitzlaenge = bl2;
        this.lehnenneigung = bl3;
        this.sitzflaechenneigung = bl4;
        this.kopfstuetze = bl5;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean isSitzhoehe() {
        return this.sitzhoehe;
    }

    public boolean isSitzlaenge() {
        return this.sitzlaenge;
    }

    public boolean isLehnenneigung() {
        return this.lehnenneigung;
    }

    public boolean isSitzflaechenneigung() {
        return this.sitzflaechenneigung;
    }

    public boolean isKopfstuetze() {
        return this.kopfstuetze;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("SeatAdjustment");
        stringBuffer.append('(');
        stringBuffer.append("position");
        stringBuffer.append('=');
        stringBuffer.append(this.position);
        stringBuffer.append(',');
        stringBuffer.append("sitzhoehe");
        stringBuffer.append('=');
        stringBuffer.append(this.sitzhoehe);
        stringBuffer.append(',');
        stringBuffer.append("sitzlaenge");
        stringBuffer.append('=');
        stringBuffer.append(this.sitzlaenge);
        stringBuffer.append(',');
        stringBuffer.append("lehnenneigung");
        stringBuffer.append('=');
        stringBuffer.append(this.lehnenneigung);
        stringBuffer.append(',');
        stringBuffer.append("sitzflaechenneigung");
        stringBuffer.append('=');
        stringBuffer.append(this.sitzflaechenneigung);
        stringBuffer.append(',');
        stringBuffer.append("kopfstuetze");
        stringBuffer.append('=');
        stringBuffer.append(this.kopfstuetze);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

