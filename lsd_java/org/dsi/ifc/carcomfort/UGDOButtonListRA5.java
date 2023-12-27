/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

public class UGDOButtonListRA5 {
    public int pos;
    public int learnedState;

    public UGDOButtonListRA5() {
        this.pos = 0;
        this.learnedState = 0;
    }

    public UGDOButtonListRA5(int n, int n2) {
        this.pos = n;
        this.learnedState = n2;
    }

    public int getPos() {
        return this.pos;
    }

    public int getLearnedState() {
        return this.learnedState;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("UGDOButtonListRA5");
        stringBuffer.append('(');
        stringBuffer.append("pos");
        stringBuffer.append('=');
        stringBuffer.append(this.pos);
        stringBuffer.append(',');
        stringBuffer.append("learnedState");
        stringBuffer.append('=');
        stringBuffer.append(this.learnedState);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

