/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardrivingcharacteristics;

import org.dsi.ifc.cardrivingcharacteristics.SpoilerPositionSetup;
import org.dsi.ifc.cardrivingcharacteristics.SpoilerPositions;
import org.dsi.ifc.cardrivingcharacteristics.SpoilerType;

public class SpoilerConfiguration {
    public SpoilerType type;
    public SpoilerPositions positionsAvailable;
    public SpoilerPositionSetup positionSetup;

    public SpoilerConfiguration() {
        this.type = null;
        this.positionsAvailable = null;
        this.positionSetup = null;
    }

    public SpoilerConfiguration(SpoilerType spoilerType, SpoilerPositions spoilerPositions, SpoilerPositionSetup spoilerPositionSetup) {
        this.type = spoilerType;
        this.positionsAvailable = spoilerPositions;
        this.positionSetup = spoilerPositionSetup;
    }

    public SpoilerType getType() {
        return this.type;
    }

    public SpoilerPositions getPositionsAvailable() {
        return this.positionsAvailable;
    }

    public SpoilerPositionSetup getPositionSetup() {
        return this.positionSetup;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(3150);
        stringBuffer.append("SpoilerConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("type");
        stringBuffer.append('=');
        stringBuffer.append(this.type);
        stringBuffer.append(',');
        stringBuffer.append("positionsAvailable");
        stringBuffer.append('=');
        stringBuffer.append(this.positionsAvailable);
        stringBuffer.append(',');
        stringBuffer.append("positionSetup");
        stringBuffer.append('=');
        stringBuffer.append(this.positionSetup);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

