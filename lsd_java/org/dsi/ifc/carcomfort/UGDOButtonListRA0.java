/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

import org.dsi.ifc.carcomfort.UGDOSpecialFeatures;

public class UGDOButtonListRA0 {
    public int pos;
    public String name;
    public float positionLatitude;
    public float positionLongitude;
    public int learnedState;
    public int hardkey;
    public int softkey;
    public UGDOSpecialFeatures specialFeatures;

    public UGDOButtonListRA0() {
        this.pos = 0;
        this.name = null;
        this.positionLatitude = 0.0f;
        this.positionLongitude = 0.0f;
        this.learnedState = 0;
        this.hardkey = 0;
        this.softkey = 0;
        this.specialFeatures = null;
    }

    public UGDOButtonListRA0(int n, String string, float f2, float f3, int n2, int n3, int n4, UGDOSpecialFeatures uGDOSpecialFeatures) {
        this.pos = n;
        this.name = string;
        this.positionLatitude = f2;
        this.positionLongitude = f3;
        this.learnedState = n2;
        this.hardkey = n3;
        this.softkey = n4;
        this.specialFeatures = uGDOSpecialFeatures;
    }

    public int getPos() {
        return this.pos;
    }

    public String getName() {
        return this.name;
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

    public int getHardkey() {
        return this.hardkey;
    }

    public int getSoftkey() {
        return this.softkey;
    }

    public UGDOSpecialFeatures getSpecialFeatures() {
        return this.specialFeatures;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1450);
        stringBuffer.append("UGDOButtonListRA0");
        stringBuffer.append('(');
        stringBuffer.append("pos");
        stringBuffer.append('=');
        stringBuffer.append(this.pos);
        stringBuffer.append(',');
        stringBuffer.append("name");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.name);
        stringBuffer.append('\"');
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
        stringBuffer.append("hardkey");
        stringBuffer.append('=');
        stringBuffer.append(this.hardkey);
        stringBuffer.append(',');
        stringBuffer.append("softkey");
        stringBuffer.append('=');
        stringBuffer.append(this.softkey);
        stringBuffer.append(',');
        stringBuffer.append("specialFeatures");
        stringBuffer.append('=');
        stringBuffer.append(this.specialFeatures);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

