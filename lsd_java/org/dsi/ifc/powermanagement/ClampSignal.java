/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.powermanagement;

public class ClampSignal {
    public boolean clampS;
    public boolean clamp15;
    public boolean clampX;
    public boolean clamp50;

    public ClampSignal() {
        this.clampS = false;
        this.clamp15 = false;
        this.clampX = false;
        this.clamp50 = false;
    }

    public ClampSignal(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.clampS = bl;
        this.clamp15 = bl2;
        this.clampX = bl3;
        this.clamp50 = bl4;
    }

    public boolean isClampS() {
        return this.clampS;
    }

    public boolean isClamp15() {
        return this.clamp15;
    }

    public boolean isClampX() {
        return this.clampX;
    }

    public boolean isClamp50() {
        return this.clamp50;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("ClampSignal");
        stringBuffer.append('(');
        stringBuffer.append("clampS");
        stringBuffer.append('=');
        stringBuffer.append(this.clampS);
        stringBuffer.append(',');
        stringBuffer.append("clamp15");
        stringBuffer.append('=');
        stringBuffer.append(this.clamp15);
        stringBuffer.append(',');
        stringBuffer.append("clampX");
        stringBuffer.append('=');
        stringBuffer.append(this.clampX);
        stringBuffer.append(',');
        stringBuffer.append("clamp50");
        stringBuffer.append('=');
        stringBuffer.append(this.clamp50);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

