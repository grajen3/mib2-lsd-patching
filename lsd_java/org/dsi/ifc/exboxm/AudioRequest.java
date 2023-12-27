/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.exboxm;

public class AudioRequest {
    public int auxAudioSource;
    public int vdaAudioSource;

    public AudioRequest() {
        this.auxAudioSource = 0;
        this.vdaAudioSource = 0;
    }

    public AudioRequest(int n, int n2) {
        this.auxAudioSource = n;
        this.vdaAudioSource = n2;
    }

    public int getAuxAudioSource() {
        return this.auxAudioSource;
    }

    public int getVdaAudioSource() {
        return this.vdaAudioSource;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("AudioRequest");
        stringBuffer.append('(');
        stringBuffer.append("auxAudioSource");
        stringBuffer.append('=');
        stringBuffer.append(this.auxAudioSource);
        stringBuffer.append(',');
        stringBuffer.append("vdaAudioSource");
        stringBuffer.append('=');
        stringBuffer.append(this.vdaAudioSource);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

