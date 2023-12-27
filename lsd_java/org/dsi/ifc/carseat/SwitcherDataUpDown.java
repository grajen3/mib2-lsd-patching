/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carseat;

public class SwitcherDataUpDown {
    public boolean sitzhoehe;
    public boolean kopfstuetzenhoehe;
    public boolean lordosenhoehe;
    public boolean gurthoehe;
    public boolean sitzflaechenwangen;
    public boolean sitzneigung;
    public boolean fussstuetzenhoehe;
    public boolean rseAufnahmehoehe;
    public boolean fussmattenhoehe;
    public boolean rseDisplay;

    public SwitcherDataUpDown() {
        this.sitzhoehe = false;
        this.kopfstuetzenhoehe = false;
        this.lordosenhoehe = false;
        this.gurthoehe = false;
        this.sitzflaechenwangen = false;
        this.sitzneigung = false;
        this.fussstuetzenhoehe = false;
        this.rseAufnahmehoehe = false;
        this.fussmattenhoehe = false;
        this.rseDisplay = false;
    }

    public SwitcherDataUpDown(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        this.sitzhoehe = bl;
        this.kopfstuetzenhoehe = bl2;
        this.lordosenhoehe = bl3;
        this.gurthoehe = bl4;
        this.sitzflaechenwangen = bl5;
        this.sitzneigung = bl6;
        this.fussstuetzenhoehe = false;
        this.rseAufnahmehoehe = false;
        this.fussmattenhoehe = false;
        this.rseDisplay = false;
    }

    public SwitcherDataUpDown(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10) {
        this.sitzhoehe = bl;
        this.kopfstuetzenhoehe = bl2;
        this.lordosenhoehe = bl3;
        this.gurthoehe = bl4;
        this.sitzflaechenwangen = bl5;
        this.sitzneigung = bl6;
        this.fussstuetzenhoehe = bl7;
        this.rseAufnahmehoehe = bl8;
        this.fussmattenhoehe = bl9;
        this.rseDisplay = bl10;
    }

    public boolean isSitzhoehe() {
        return this.sitzhoehe;
    }

    public boolean isKopfstuetzenhoehe() {
        return this.kopfstuetzenhoehe;
    }

    public boolean isLordosenhoehe() {
        return this.lordosenhoehe;
    }

    public boolean isGurthoehe() {
        return this.gurthoehe;
    }

    public boolean isSitzflaechenwangen() {
        return this.sitzflaechenwangen;
    }

    public boolean isSitzneigung() {
        return this.sitzneigung;
    }

    public boolean isFussstuetzenhoehe() {
        return this.fussstuetzenhoehe;
    }

    public boolean isRseAufnahmehoehe() {
        return this.rseAufnahmehoehe;
    }

    public boolean isFussmattenhoehe() {
        return this.fussmattenhoehe;
    }

    public boolean isRseDisplay() {
        return this.rseDisplay;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(500);
        stringBuffer.append("SwitcherDataUpDown");
        stringBuffer.append('(');
        stringBuffer.append("sitzhoehe");
        stringBuffer.append('=');
        stringBuffer.append(this.sitzhoehe);
        stringBuffer.append(',');
        stringBuffer.append("kopfstuetzenhoehe");
        stringBuffer.append('=');
        stringBuffer.append(this.kopfstuetzenhoehe);
        stringBuffer.append(',');
        stringBuffer.append("lordosenhoehe");
        stringBuffer.append('=');
        stringBuffer.append(this.lordosenhoehe);
        stringBuffer.append(',');
        stringBuffer.append("gurthoehe");
        stringBuffer.append('=');
        stringBuffer.append(this.gurthoehe);
        stringBuffer.append(',');
        stringBuffer.append("sitzflaechenwangen");
        stringBuffer.append('=');
        stringBuffer.append(this.sitzflaechenwangen);
        stringBuffer.append(',');
        stringBuffer.append("sitzneigung");
        stringBuffer.append('=');
        stringBuffer.append(this.sitzneigung);
        stringBuffer.append(',');
        stringBuffer.append("fussstuetzenhoehe");
        stringBuffer.append('=');
        stringBuffer.append(this.fussstuetzenhoehe);
        stringBuffer.append(',');
        stringBuffer.append("rseAufnahmehoehe");
        stringBuffer.append('=');
        stringBuffer.append(this.rseAufnahmehoehe);
        stringBuffer.append(',');
        stringBuffer.append("fussmattenhoehe");
        stringBuffer.append('=');
        stringBuffer.append(this.fussmattenhoehe);
        stringBuffer.append(',');
        stringBuffer.append("rseDisplay");
        stringBuffer.append('=');
        stringBuffer.append(this.rseDisplay);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

