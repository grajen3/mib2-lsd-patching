/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carseat;

public class SwitcherDataBackForward {
    public boolean sitzlaenge;
    public boolean lehnenneigung;
    public boolean lordosenweite;
    public boolean sitztiefe;
    public boolean lehnenkopf;
    public boolean lehnenwangen;
    public boolean kopfstuetzenlaenge;
    public boolean rseAufnahmetiefe;

    public SwitcherDataBackForward() {
        this.sitzlaenge = false;
        this.lehnenneigung = false;
        this.lordosenweite = false;
        this.sitztiefe = false;
        this.lehnenkopf = false;
        this.lehnenwangen = false;
        this.kopfstuetzenlaenge = false;
        this.rseAufnahmetiefe = false;
    }

    public SwitcherDataBackForward(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7) {
        this.sitzlaenge = bl;
        this.lehnenneigung = bl2;
        this.lordosenweite = bl3;
        this.sitztiefe = bl4;
        this.lehnenkopf = bl5;
        this.lehnenwangen = bl6;
        this.kopfstuetzenlaenge = bl7;
        this.rseAufnahmetiefe = false;
    }

    public SwitcherDataBackForward(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8) {
        this.sitzlaenge = bl;
        this.lehnenneigung = bl2;
        this.lordosenweite = bl3;
        this.sitztiefe = bl4;
        this.lehnenkopf = bl5;
        this.lehnenwangen = bl6;
        this.kopfstuetzenlaenge = bl7;
        this.rseAufnahmetiefe = bl8;
    }

    public boolean isSitzlaenge() {
        return this.sitzlaenge;
    }

    public boolean isLehnenneigung() {
        return this.lehnenneigung;
    }

    public boolean isLordosenweite() {
        return this.lordosenweite;
    }

    public boolean isSitztiefe() {
        return this.sitztiefe;
    }

    public boolean isLehnenkopf() {
        return this.lehnenkopf;
    }

    public boolean isLehnenwangen() {
        return this.lehnenwangen;
    }

    public boolean isKopfstuetzenlaenge() {
        return this.kopfstuetzenlaenge;
    }

    public boolean isRseAufnahmetiefe() {
        return this.rseAufnahmetiefe;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(400);
        stringBuffer.append("SwitcherDataBackForward");
        stringBuffer.append('(');
        stringBuffer.append("sitzlaenge");
        stringBuffer.append('=');
        stringBuffer.append(this.sitzlaenge);
        stringBuffer.append(',');
        stringBuffer.append("lehnenneigung");
        stringBuffer.append('=');
        stringBuffer.append(this.lehnenneigung);
        stringBuffer.append(',');
        stringBuffer.append("lordosenweite");
        stringBuffer.append('=');
        stringBuffer.append(this.lordosenweite);
        stringBuffer.append(',');
        stringBuffer.append("sitztiefe");
        stringBuffer.append('=');
        stringBuffer.append(this.sitztiefe);
        stringBuffer.append(',');
        stringBuffer.append("lehnenkopf");
        stringBuffer.append('=');
        stringBuffer.append(this.lehnenkopf);
        stringBuffer.append(',');
        stringBuffer.append("lehnenwangen");
        stringBuffer.append('=');
        stringBuffer.append(this.lehnenwangen);
        stringBuffer.append(',');
        stringBuffer.append("kopfstuetzenlaenge");
        stringBuffer.append('=');
        stringBuffer.append(this.kopfstuetzenlaenge);
        stringBuffer.append(',');
        stringBuffer.append("rseAufnahmetiefe");
        stringBuffer.append('=');
        stringBuffer.append(this.rseAufnahmetiefe);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

