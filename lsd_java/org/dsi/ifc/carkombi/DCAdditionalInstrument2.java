/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

public class DCAdditionalInstrument2 {
    public boolean instrumentOnOff;
    public boolean digitalClock;
    public boolean analogClock;
    public boolean compass;
    public boolean navigation;

    public DCAdditionalInstrument2() {
        this.instrumentOnOff = false;
        this.digitalClock = false;
        this.analogClock = false;
        this.compass = false;
        this.navigation = false;
    }

    public DCAdditionalInstrument2(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.instrumentOnOff = bl;
        this.digitalClock = bl2;
        this.analogClock = bl3;
        this.compass = bl4;
        this.navigation = false;
    }

    public DCAdditionalInstrument2(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        this.instrumentOnOff = bl;
        this.digitalClock = bl2;
        this.analogClock = bl3;
        this.compass = bl4;
        this.navigation = bl5;
    }

    public boolean isInstrumentOnOff() {
        return this.instrumentOnOff;
    }

    public boolean isDigitalClock() {
        return this.digitalClock;
    }

    public boolean isAnalogClock() {
        return this.analogClock;
    }

    public boolean isCompass() {
        return this.compass;
    }

    public boolean isNavigation() {
        return this.navigation;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("DCAdditionalInstrument2");
        stringBuffer.append('(');
        stringBuffer.append("instrumentOnOff");
        stringBuffer.append('=');
        stringBuffer.append(this.instrumentOnOff);
        stringBuffer.append(',');
        stringBuffer.append("digitalClock");
        stringBuffer.append('=');
        stringBuffer.append(this.digitalClock);
        stringBuffer.append(',');
        stringBuffer.append("analogClock");
        stringBuffer.append('=');
        stringBuffer.append(this.analogClock);
        stringBuffer.append(',');
        stringBuffer.append("compass");
        stringBuffer.append('=');
        stringBuffer.append(this.compass);
        stringBuffer.append(',');
        stringBuffer.append("navigation");
        stringBuffer.append('=');
        stringBuffer.append(this.navigation);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

