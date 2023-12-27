/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

public class BCAverageRecoveredEnergy {
    public int state;
    public int value;

    public BCAverageRecoveredEnergy() {
        this.state = 0;
        this.value = 0;
    }

    public BCAverageRecoveredEnergy(int n, int n2) {
        this.state = n;
        this.value = n2;
    }

    public int getState() {
        return this.state;
    }

    public int getValue() {
        return this.value;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("BCAverageRecoveredEnergy");
        stringBuffer.append('(');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.state);
        stringBuffer.append(',');
        stringBuffer.append("value");
        stringBuffer.append('=');
        stringBuffer.append(this.value);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

