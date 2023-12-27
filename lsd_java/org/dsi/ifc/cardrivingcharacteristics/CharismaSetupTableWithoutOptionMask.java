/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardrivingcharacteristics;

public class CharismaSetupTableWithoutOptionMask {
    public int listPosition;
    public int functionID;
    public int setupValue;

    public CharismaSetupTableWithoutOptionMask() {
        this.listPosition = 0;
        this.functionID = 0;
        this.setupValue = 0;
    }

    public CharismaSetupTableWithoutOptionMask(int n, int n2, int n3) {
        this.listPosition = n;
        this.functionID = n2;
        this.setupValue = n3;
    }

    public int getListPosition() {
        return this.listPosition;
    }

    public int getFunctionID() {
        return this.functionID;
    }

    public int getSetupValue() {
        return this.setupValue;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("CharismaSetupTableWithoutOptionMask");
        stringBuffer.append('(');
        stringBuffer.append("listPosition");
        stringBuffer.append('=');
        stringBuffer.append(this.listPosition);
        stringBuffer.append(',');
        stringBuffer.append("functionID");
        stringBuffer.append('=');
        stringBuffer.append(this.functionID);
        stringBuffer.append(',');
        stringBuffer.append("setupValue");
        stringBuffer.append('=');
        stringBuffer.append(this.setupValue);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

