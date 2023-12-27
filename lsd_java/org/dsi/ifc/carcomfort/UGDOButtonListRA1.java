/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

import org.dsi.ifc.carcomfort.UGDOSpecialFeatures;

public class UGDOButtonListRA1 {
    public int pos;
    public float positionLatitude;
    public float positionLongitude;
    public int learnedState;
    public UGDOSpecialFeatures specialFeatures;

    public UGDOButtonListRA1() {
        this.pos = 0;
        this.positionLatitude = 0.0f;
        this.positionLongitude = 0.0f;
        this.learnedState = 0;
        this.specialFeatures = null;
    }

    public UGDOButtonListRA1(int n, float f2, float f3, int n2, UGDOSpecialFeatures uGDOSpecialFeatures) {
        this.pos = n;
        this.positionLatitude = f2;
        this.positionLongitude = f3;
        this.learnedState = n2;
        this.specialFeatures = uGDOSpecialFeatures;
    }

    public int getPos() {
        return this.pos;
    }

    public float getPositionLatitude() {
        return this.positionLatitude;
    }

    public float getPositionLongitude() {
        return this.positionLongitude;
    }

    public int getLearnedState() {
        return this.learnedState;
    }

    public UGDOSpecialFeatures getSpecialFeatures() {
        return this.specialFeatures;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1250);
        stringBuffer.append("UGDOButtonListRA1");
        stringBuffer.append('(');
        stringBuffer.append("pos");
        stringBuffer.append('=');
        stringBuffer.append(this.pos);
        stringBuffer.append(',');
        stringBuffer.append("positionLatitude");
        stringBuffer.append('=');
        stringBuffer.append(this.positionLatitude);
        stringBuffer.append(',');
        stringBuffer.append("positionLongitude");
        stringBuffer.append('=');
        stringBuffer.append(this.positionLongitude);
        stringBuffer.append(',');
        stringBuffer.append("learnedState");
        stringBuffer.append('=');
        stringBuffer.append(this.learnedState);
        stringBuffer.append(',');
        stringBuffer.append("specialFeatures");
        stringBuffer.append('=');
        stringBuffer.append(this.specialFeatures);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

