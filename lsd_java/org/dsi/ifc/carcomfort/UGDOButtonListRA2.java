/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

import org.dsi.ifc.carcomfort.UGDOSpecialFeatures;

public class UGDOButtonListRA2 {
    public int pos;
    public int learnedState;
    public UGDOSpecialFeatures specialFeatures;

    public UGDOButtonListRA2() {
        this.pos = 0;
        this.learnedState = 0;
        this.specialFeatures = null;
    }

    public UGDOButtonListRA2(int n, int n2, UGDOSpecialFeatures uGDOSpecialFeatures) {
        this.pos = n;
        this.learnedState = n2;
        this.specialFeatures = uGDOSpecialFeatures;
    }

    public int getPos() {
        return this.pos;
    }

    public int getLearnedState() {
        return this.learnedState;
    }

    public UGDOSpecialFeatures getSpecialFeatures() {
        return this.specialFeatures;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1150);
        stringBuffer.append("UGDOButtonListRA2");
        stringBuffer.append('(');
        stringBuffer.append("pos");
        stringBuffer.append('=');
        stringBuffer.append(this.pos);
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

