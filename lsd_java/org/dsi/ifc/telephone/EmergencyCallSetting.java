/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephone;

public class EmergencyCallSetting {
    public boolean value;
    public boolean changeable;

    public EmergencyCallSetting() {
        this.value = false;
        this.changeable = false;
    }

    public EmergencyCallSetting(boolean bl, boolean bl2) {
        this.value = bl;
        this.changeable = bl2;
    }

    public boolean isValue() {
        return this.value;
    }

    public boolean isChangeable() {
        return this.changeable;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("EmergencyCallSetting");
        stringBuffer.append('(');
        stringBuffer.append("value");
        stringBuffer.append('=');
        stringBuffer.append(this.value);
        stringBuffer.append(',');
        stringBuffer.append("changeable");
        stringBuffer.append('=');
        stringBuffer.append(this.changeable);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

