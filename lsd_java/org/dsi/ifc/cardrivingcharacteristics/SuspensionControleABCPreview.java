/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardrivingcharacteristics;

public class SuspensionControleABCPreview {
    public boolean state;
    public int obstacleLevel;

    public SuspensionControleABCPreview() {
        this.state = false;
        this.obstacleLevel = 254;
    }

    public SuspensionControleABCPreview(boolean bl, int n) {
        this.state = bl;
        this.obstacleLevel = n;
    }

    public boolean isState() {
        return this.state;
    }

    public int getObstacleLevel() {
        return this.obstacleLevel;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("SuspensionControleABCPreview");
        stringBuffer.append('(');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.state);
        stringBuffer.append(',');
        stringBuffer.append("obstacleLevel");
        stringBuffer.append('=');
        stringBuffer.append(this.obstacleLevel);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

