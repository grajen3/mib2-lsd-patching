/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carlight;

import org.dsi.ifc.carlight.IntLightRGBValues;

public class IntLightRGBColorListRA0 {
    public int pos;
    public IntLightRGBValues values;

    public IntLightRGBColorListRA0() {
        this.pos = 0;
        this.values = null;
    }

    public IntLightRGBColorListRA0(int n, IntLightRGBValues intLightRGBValues) {
        this.pos = n;
        this.values = intLightRGBValues;
    }

    public int getPos() {
        return this.pos;
    }

    public IntLightRGBValues getValues() {
        return this.values;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1100);
        stringBuffer.append("IntLightRGBColorListRA0");
        stringBuffer.append('(');
        stringBuffer.append("pos");
        stringBuffer.append('=');
        stringBuffer.append(this.pos);
        stringBuffer.append(',');
        stringBuffer.append("values");
        stringBuffer.append('=');
        stringBuffer.append(this.values);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

