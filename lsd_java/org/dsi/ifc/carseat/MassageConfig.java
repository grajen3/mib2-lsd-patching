/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carseat;

import org.dsi.ifc.carseat.MassageProgs;

public class MassageConfig {
    public MassageProgs programs;
    public short intensityRange;
    public short speedRange;

    public MassageConfig() {
        this.programs = null;
        this.intensityRange = 0;
        this.speedRange = 0;
    }

    public MassageConfig(MassageProgs massageProgs, short s, short s2) {
        this.programs = massageProgs;
        this.intensityRange = s;
        this.speedRange = s2;
    }

    public MassageProgs getPrograms() {
        return this.programs;
    }

    public short getIntensityRange() {
        return this.intensityRange;
    }

    public short getSpeedRange() {
        return this.speedRange;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1150);
        stringBuffer.append("MassageConfig");
        stringBuffer.append('(');
        stringBuffer.append("programs");
        stringBuffer.append('=');
        stringBuffer.append(this.programs);
        stringBuffer.append(',');
        stringBuffer.append("intensityRange");
        stringBuffer.append('=');
        stringBuffer.append(this.intensityRange);
        stringBuffer.append(',');
        stringBuffer.append("speedRange");
        stringBuffer.append('=');
        stringBuffer.append(this.speedRange);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

