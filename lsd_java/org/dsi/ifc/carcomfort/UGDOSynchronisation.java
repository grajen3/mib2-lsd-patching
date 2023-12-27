/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

public class UGDOSynchronisation {
    public int state;
    public int softkey;
    public int doorMovement;

    public UGDOSynchronisation() {
        this.state = 0;
        this.softkey = 0;
        this.doorMovement = 0;
    }

    public UGDOSynchronisation(int n, int n2, int n3) {
        this.state = n;
        this.softkey = n2;
        this.doorMovement = n3;
    }

    public int getState() {
        return this.state;
    }

    public int getSoftkey() {
        return this.softkey;
    }

    public int getDoorMovement() {
        return this.doorMovement;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("UGDOSynchronisation");
        stringBuffer.append('(');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.state);
        stringBuffer.append(',');
        stringBuffer.append("softkey");
        stringBuffer.append('=');
        stringBuffer.append(this.softkey);
        stringBuffer.append(',');
        stringBuffer.append("doorMovement");
        stringBuffer.append('=');
        stringBuffer.append(this.doorMovement);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

