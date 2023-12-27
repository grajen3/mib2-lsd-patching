/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

public class BCTankLevel {
    public int state;
    public int tankLevelValue;

    public BCTankLevel() {
        this.state = 0;
        this.tankLevelValue = 0;
    }

    public BCTankLevel(int n, int n2) {
        this.state = n;
        this.tankLevelValue = n2;
    }

    public int getState() {
        return this.state;
    }

    public int getTankLevelValue() {
        return this.tankLevelValue;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("BCTankLevel");
        stringBuffer.append('(');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.state);
        stringBuffer.append(',');
        stringBuffer.append("tankLevelValue");
        stringBuffer.append('=');
        stringBuffer.append(this.tankLevelValue);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

