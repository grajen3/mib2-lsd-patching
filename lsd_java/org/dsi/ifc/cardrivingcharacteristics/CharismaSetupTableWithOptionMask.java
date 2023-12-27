/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardrivingcharacteristics;

public class CharismaSetupTableWithOptionMask {
    public int listPosition;
    public int functionID;
    public int mask;
    public int setupValue;

    public CharismaSetupTableWithOptionMask() {
        this.listPosition = 0;
        this.functionID = 0;
        this.mask = 0;
        this.setupValue = 0;
    }

    public CharismaSetupTableWithOptionMask(int n, int n2, int n3, int n4) {
        this.listPosition = n;
        this.functionID = n2;
        this.mask = n3;
        this.setupValue = n4;
    }

    public int getListPosition() {
        return this.listPosition;
    }

    public int getFunctionID() {
        return this.functionID;
    }

    public int getMask() {
        return this.mask;
    }

    public int getSetupValue() {
        return this.setupValue;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("CharismaSetupTableWithOptionMask");
        stringBuffer.append('(');
        stringBuffer.append("listPosition");
        stringBuffer.append('=');
        stringBuffer.append(this.listPosition);
        stringBuffer.append(',');
        stringBuffer.append("functionID");
        stringBuffer.append('=');
        stringBuffer.append(this.functionID);
        stringBuffer.append(',');
        stringBuffer.append("mask");
        stringBuffer.append('=');
        stringBuffer.append(this.mask);
        stringBuffer.append(',');
        stringBuffer.append("setupValue");
        stringBuffer.append('=');
        stringBuffer.append(this.setupValue);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

