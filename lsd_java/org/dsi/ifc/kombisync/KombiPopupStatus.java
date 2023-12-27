/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombisync;

public class KombiPopupStatus {
    public int tid;
    public int mmiPopupID;
    public int mmiPopupState;
    public int zpmPrioritySlotID;
    public int mmiPopupPriority;
    public int screenFormat;
    public int focus;

    public KombiPopupStatus() {
        this.tid = 0;
        this.mmiPopupID = 0;
        this.mmiPopupState = 0;
        this.zpmPrioritySlotID = 0;
        this.mmiPopupPriority = 0;
        this.screenFormat = 0;
        this.focus = 0;
    }

    public KombiPopupStatus(int n, int n2, int n3, int n4, int n5, int n6) {
        this.tid = n;
        this.mmiPopupID = n2;
        this.mmiPopupState = n3;
        this.zpmPrioritySlotID = n4;
        this.mmiPopupPriority = n5;
        this.screenFormat = n6;
        this.focus = 0;
    }

    public KombiPopupStatus(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        this.tid = n;
        this.mmiPopupID = n2;
        this.mmiPopupState = n3;
        this.zpmPrioritySlotID = n4;
        this.mmiPopupPriority = n5;
        this.screenFormat = n6;
        this.focus = n7;
    }

    public int getTid() {
        return this.tid;
    }

    public int getMmiPopupID() {
        return this.mmiPopupID;
    }

    public int getMmiPopupState() {
        return this.mmiPopupState;
    }

    public int getZpmPrioritySlotID() {
        return this.zpmPrioritySlotID;
    }

    public int getMmiPopupPriority() {
        return this.mmiPopupPriority;
    }

    public int getScreenFormat() {
        return this.screenFormat;
    }

    public int getFocus() {
        return this.focus;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(400);
        stringBuffer.append("KombiPopupStatus");
        stringBuffer.append('(');
        stringBuffer.append("tid");
        stringBuffer.append('=');
        stringBuffer.append(this.tid);
        stringBuffer.append(',');
        stringBuffer.append("mmiPopupID");
        stringBuffer.append('=');
        stringBuffer.append(this.mmiPopupID);
        stringBuffer.append(',');
        stringBuffer.append("mmiPopupState");
        stringBuffer.append('=');
        stringBuffer.append(this.mmiPopupState);
        stringBuffer.append(',');
        stringBuffer.append("zpmPrioritySlotID");
        stringBuffer.append('=');
        stringBuffer.append(this.zpmPrioritySlotID);
        stringBuffer.append(',');
        stringBuffer.append("mmiPopupPriority");
        stringBuffer.append('=');
        stringBuffer.append(this.mmiPopupPriority);
        stringBuffer.append(',');
        stringBuffer.append("screenFormat");
        stringBuffer.append('=');
        stringBuffer.append(this.screenFormat);
        stringBuffer.append(',');
        stringBuffer.append("focus");
        stringBuffer.append('=');
        stringBuffer.append(this.focus);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

