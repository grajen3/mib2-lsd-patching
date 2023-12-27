/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.audio;

public class AmplifierCapabilities {
    public int amplifier;
    public boolean balance;
    public boolean fader;
    public boolean subwoofer;
    public int equalizer;

    public AmplifierCapabilities() {
        this.amplifier = 0;
        this.balance = false;
        this.fader = false;
        this.subwoofer = false;
        this.equalizer = 0;
    }

    public AmplifierCapabilities(int n, boolean bl, boolean bl2, boolean bl3, int n2) {
        this.amplifier = n;
        this.balance = bl;
        this.fader = bl2;
        this.subwoofer = bl3;
        this.equalizer = n2;
    }

    public int getAmplifier() {
        return this.amplifier;
    }

    public boolean isBalance() {
        return this.balance;
    }

    public boolean isFader() {
        return this.fader;
    }

    public boolean isSubwoofer() {
        return this.subwoofer;
    }

    public int getEqualizer() {
        return this.equalizer;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("AmplifierCapabilities");
        stringBuffer.append('(');
        stringBuffer.append("amplifier");
        stringBuffer.append('=');
        stringBuffer.append(this.amplifier);
        stringBuffer.append(',');
        stringBuffer.append("balance");
        stringBuffer.append('=');
        stringBuffer.append(this.balance);
        stringBuffer.append(',');
        stringBuffer.append("fader");
        stringBuffer.append('=');
        stringBuffer.append(this.fader);
        stringBuffer.append(',');
        stringBuffer.append("subwoofer");
        stringBuffer.append('=');
        stringBuffer.append(this.subwoofer);
        stringBuffer.append(',');
        stringBuffer.append("equalizer");
        stringBuffer.append('=');
        stringBuffer.append(this.equalizer);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

