/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

import org.dsi.ifc.carcomfort.UGDOSpecialFeatures;

public class UGDOButtonListRA3 {
    public int pos;
    public UGDOSpecialFeatures specialFeatures;

    public UGDOButtonListRA3() {
        this.pos = 0;
        this.specialFeatures = null;
    }

    public UGDOButtonListRA3(int n, UGDOSpecialFeatures uGDOSpecialFeatures) {
        this.pos = n;
        this.specialFeatures = uGDOSpecialFeatures;
    }

    public int getPos() {
        return this.pos;
    }

    public UGDOSpecialFeatures getSpecialFeatures() {
        return this.specialFeatures;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1100);
        stringBuffer.append("UGDOButtonListRA3");
        stringBuffer.append('(');
        stringBuffer.append("pos");
        stringBuffer.append('=');
        stringBuffer.append(this.pos);
        stringBuffer.append(',');
        stringBuffer.append("specialFeatures");
        stringBuffer.append('=');
        stringBuffer.append(this.specialFeatures);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

