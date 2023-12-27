/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombisync;

public class MMIPopupRequest {
    public int tid;
    public int mmiPopupID;
    public int mmiPriority;
    public int zpmPrioritySlotID;
    public boolean show;
    public int screenFormat;
    public int focus;

    public MMIPopupRequest() {
        this.tid = 0;
        this.mmiPopupID = 0;
        this.mmiPriority = 0;
        this.zpmPrioritySlotID = 0;
        this.show = false;
        this.screenFormat = 0;
        this.focus = 0;
    }

    public MMIPopupRequest(int n, int n2, int n3, int n4, boolean bl, int n5) {
        this.tid = n;
        this.mmiPopupID = n2;
        this.mmiPriority = n3;
        this.zpmPrioritySlotID = n4;
        this.show = bl;
        this.screenFormat = n5;
        this.focus = 0;
    }

    public MMIPopupRequest(int n, int n2, int n3, int n4, boolean bl, int n5, int n6) {
        this.tid = n;
        this.mmiPopupID = n2;
        this.mmiPriority = n3;
        this.zpmPrioritySlotID = n4;
        this.show = bl;
        this.screenFormat = n5;
        this.focus = n6;
    }

    public int getTid() {
        return this.tid;
    }

    public int getMmiPopupID() {
        return this.mmiPopupID;
    }

    public int getMmiPriority() {
        return this.mmiPriority;
    }

    public int getZpmPrioritySlotID() {
        return this.zpmPrioritySlotID;
    }

    public boolean isShow() {
        return this.show;
    }

    public int getScreenFormat() {
        return this.screenFormat;
    }

    public int getFocus() {
        return this.focus;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("MMIPopupRequest");
        stringBuffer.append('(');
        stringBuffer.append("tid");
        stringBuffer.append('=');
        stringBuffer.append(this.tid);
        stringBuffer.append(',');
        stringBuffer.append("mmiPopupID");
        stringBuffer.append('=');
        stringBuffer.append(this.mmiPopupID);
        stringBuffer.append(',');
        stringBuffer.append("mmiPriority");
        stringBuffer.append('=');
        stringBuffer.append(this.mmiPriority);
        stringBuffer.append(',');
        stringBuffer.append("zpmPrioritySlotID");
        stringBuffer.append('=');
        stringBuffer.append(this.zpmPrioritySlotID);
        stringBuffer.append(',');
        stringBuffer.append("show");
        stringBuffer.append('=');
        stringBuffer.append(this.show);
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

