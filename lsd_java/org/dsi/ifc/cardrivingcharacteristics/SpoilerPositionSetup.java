/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardrivingcharacteristics;

public class SpoilerPositionSetup {
    public int position0;
    public int position1;
    public int position2;
    public int position3;
    public int position4;
    public int position5;

    public SpoilerPositionSetup() {
        this.position0 = 0;
        this.position1 = 0;
        this.position2 = 0;
        this.position3 = 0;
        this.position4 = 0;
        this.position5 = 0;
    }

    public SpoilerPositionSetup(int n, int n2, int n3, int n4, int n5, int n6) {
        this.position0 = n;
        this.position1 = n2;
        this.position2 = n3;
        this.position3 = n4;
        this.position4 = n5;
        this.position5 = n6;
    }

    public int getPosition0() {
        return this.position0;
    }

    public int getPosition1() {
        return this.position1;
    }

    public int getPosition2() {
        return this.position2;
    }

    public int getPosition3() {
        return this.position3;
    }

    public int getPosition4() {
        return this.position4;
    }

    public int getPosition5() {
        return this.position5;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("SpoilerPositionSetup");
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

