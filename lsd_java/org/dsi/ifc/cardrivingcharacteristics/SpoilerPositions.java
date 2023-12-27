/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardrivingcharacteristics;

public class SpoilerPositions {
    public boolean position0;
    public boolean position1;
    public boolean position2;
    public boolean position3;
    public boolean position4;
    public boolean position5;

    public SpoilerPositions() {
        this.position0 = false;
        this.position1 = false;
        this.position2 = false;
        this.position3 = false;
        this.position4 = false;
        this.position5 = false;
    }

    public SpoilerPositions(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        this.position0 = bl;
        this.position1 = bl2;
        this.position2 = bl3;
        this.position3 = bl4;
        this.position4 = bl5;
        this.position5 = bl6;
    }

    public boolean isPosition0() {
        return this.position0;
    }

    public boolean isPosition1() {
        return this.position1;
    }

    public boolean isPosition2() {
        return this.position2;
    }

    public boolean isPosition3() {
        return this.position3;
    }

    public boolean isPosition4() {
        return this.position4;
    }

    public boolean isPosition5() {
        return this.position5;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("SpoilerPositions");
        stringBuffer.append('(');
        stringBuffer.append("position0");
        stringBuffer.append('=');
        stringBuffer.append(this.position0);
        stringBuffer.append(',');
        stringBuffer.append("position1");
        stringBuffer.append('=');
        stringBuffer.append(this.position1);
        stringBuffer.append(',');
        stringBuffer.append("position2");
        stringBuffer.append('=');
        stringBuffer.append(this.position2);
        stringBuffer.append(',');
        stringBuffer.append("position3");
        stringBuffer.append('=');
        stringBuffer.append(this.position3);
        stringBuffer.append(',');
        stringBuffer.append("position4");
        stringBuffer.append('=');
        stringBuffer.append(this.position4);
        stringBuffer.append(',');
        stringBuffer.append("position5");
        stringBuffer.append('=');
        stringBuffer.append(this.position5);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

