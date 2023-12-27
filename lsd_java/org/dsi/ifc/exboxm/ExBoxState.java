/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.exboxm;

public class ExBoxState {
    public boolean exBoxNavigationActive;
    public boolean exBoxPhoneCallActive;
    public boolean exBoxSpeechActive;

    public ExBoxState() {
        this.exBoxNavigationActive = false;
        this.exBoxPhoneCallActive = false;
        this.exBoxSpeechActive = false;
    }

    public ExBoxState(boolean bl, boolean bl2, boolean bl3) {
        this.exBoxNavigationActive = bl;
        this.exBoxPhoneCallActive = bl2;
        this.exBoxSpeechActive = bl3;
    }

    public boolean isExBoxNavigationActive() {
        return this.exBoxNavigationActive;
    }

    public boolean isExBoxPhoneCallActive() {
        return this.exBoxPhoneCallActive;
    }

    public boolean isExBoxSpeechActive() {
        return this.exBoxSpeechActive;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("ExBoxState");
        stringBuffer.append('(');
        stringBuffer.append("exBoxNavigationActive");
        stringBuffer.append('=');
        stringBuffer.append(this.exBoxNavigationActive);
        stringBuffer.append(',');
        stringBuffer.append("exBoxPhoneCallActive");
        stringBuffer.append('=');
        stringBuffer.append(this.exBoxPhoneCallActive);
        stringBuffer.append(',');
        stringBuffer.append("exBoxSpeechActive");
        stringBuffer.append('=');
        stringBuffer.append(this.exBoxSpeechActive);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

