/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephoneng;

public class ActivationStateStruct {
    public int telActivationState;
    public int telPhoneModuleState;
    public int telMode;
    public short telFeat;
    public String telHFPVersion;

    public ActivationStateStruct() {
        this.telActivationState = 0;
        this.telPhoneModuleState = 0;
        this.telMode = 0;
        this.telFeat = 0;
        this.telHFPVersion = null;
    }

    public ActivationStateStruct(int n, int n2, int n3, short s, String string) {
        this.telActivationState = n;
        this.telPhoneModuleState = n2;
        this.telMode = n3;
        this.telFeat = s;
        this.telHFPVersion = string;
    }

    public int getTelActivationState() {
        return this.telActivationState;
    }

    public int getTelMode() {
        return this.telMode;
    }

    public short getTelFeat() {
        return this.telFeat;
    }

    public String getTelHFPVersion() {
        return this.telHFPVersion;
    }

    public int getTelPhoneModuleState() {
        return this.telPhoneModuleState;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("ActivationStateStruct");
        stringBuffer.append('(');
        stringBuffer.append("telActivationState");
        stringBuffer.append('=');
        stringBuffer.append(this.telActivationState);
        stringBuffer.append(',');
        stringBuffer.append("telPhoneModuleState");
        stringBuffer.append('=');
        stringBuffer.append(this.telPhoneModuleState);
        stringBuffer.append(',');
        stringBuffer.append("telMode");
        stringBuffer.append('=');
        stringBuffer.append(this.telMode);
        stringBuffer.append(',');
        stringBuffer.append("telFeat");
        stringBuffer.append('=');
        stringBuffer.append(this.telFeat);
        stringBuffer.append(',');
        stringBuffer.append("telHFPVersion");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.telHFPVersion);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

