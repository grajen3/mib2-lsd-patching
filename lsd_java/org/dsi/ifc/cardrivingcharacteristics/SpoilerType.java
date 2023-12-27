/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardrivingcharacteristics;

public class SpoilerType {
    public boolean basis;
    public boolean flaps;
    public boolean angle;

    public SpoilerType() {
        this.basis = false;
        this.flaps = false;
        this.angle = false;
    }

    public SpoilerType(boolean bl, boolean bl2, boolean bl3) {
        this.basis = bl;
        this.flaps = bl2;
        this.angle = bl3;
    }

    public boolean isBasis() {
        return this.basis;
    }

    public boolean isFlaps() {
        return this.flaps;
    }

    public boolean isAngle() {
        return this.angle;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("SpoilerType");
        stringBuffer.append('(');
        stringBuffer.append("basis");
        stringBuffer.append('=');
        stringBuffer.append(this.basis);
        stringBuffer.append(',');
        stringBuffer.append("flaps");
        stringBuffer.append('=');
        stringBuffer.append(this.flaps);
        stringBuffer.append(',');
        stringBuffer.append("angle");
        stringBuffer.append('=');
        stringBuffer.append(this.angle);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

