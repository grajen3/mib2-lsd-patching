/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.swdlprogress;

public class GeneralProgress {
    public short currentStage;
    public short maxStage;
    public short finishedDevicesWithoutError;
    public short updatingDevices;
    public short unavailableDevices;
    public short finishedDevicesWithError;
    public short activeDevices;

    public GeneralProgress() {
        this.currentStage = 0;
        this.maxStage = 0;
        this.finishedDevicesWithoutError = 0;
        this.updatingDevices = 0;
        this.unavailableDevices = 0;
        this.finishedDevicesWithError = 0;
        this.activeDevices = 0;
    }

    public GeneralProgress(short s, short s2, short s3, short s4, short s5, short s6, short s7) {
        this.currentStage = s;
        this.maxStage = s2;
        this.finishedDevicesWithoutError = s3;
        this.updatingDevices = s4;
        this.unavailableDevices = s5;
        this.finishedDevicesWithError = s6;
        this.activeDevices = s7;
    }

    public short getCurrentStage() {
        return this.currentStage;
    }

    public short getMaxStage() {
        return this.maxStage;
    }

    public short getFinishedDevicesWithoutError() {
        return this.finishedDevicesWithoutError;
    }

    public short getUpdatingDevices() {
        return this.updatingDevices;
    }

    public short getUnavailableDevices() {
        return this.unavailableDevices;
    }

    public short getFinishedDevicesWithError() {
        return this.finishedDevicesWithError;
    }

    public short getActiveDevices() {
        return this.activeDevices;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(400);
        stringBuffer.append("GeneralProgress");
        stringBuffer.append('(');
        stringBuffer.append("currentStage");
        stringBuffer.append('=');
        stringBuffer.append(this.currentStage);
        stringBuffer.append(',');
        stringBuffer.append("maxStage");
        stringBuffer.append('=');
        stringBuffer.append(this.maxStage);
        stringBuffer.append(',');
        stringBuffer.append("finishedDevicesWithoutError");
        stringBuffer.append('=');
        stringBuffer.append(this.finishedDevicesWithoutError);
        stringBuffer.append(',');
        stringBuffer.append("updatingDevices");
        stringBuffer.append('=');
        stringBuffer.append(this.updatingDevices);
        stringBuffer.append(',');
        stringBuffer.append("unavailableDevices");
        stringBuffer.append('=');
        stringBuffer.append(this.unavailableDevices);
        stringBuffer.append(',');
        stringBuffer.append("finishedDevicesWithError");
        stringBuffer.append('=');
        stringBuffer.append(this.finishedDevicesWithError);
        stringBuffer.append(',');
        stringBuffer.append("activeDevices");
        stringBuffer.append('=');
        stringBuffer.append(this.activeDevices);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

