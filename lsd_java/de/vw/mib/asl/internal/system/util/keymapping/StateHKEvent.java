/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.util.keymapping;

import de.vw.mib.util.StringBuilder;

public class StateHKEvent {
    private int keyStateId;
    private int hkEventId;

    public StateHKEvent() {
        this.keyStateId = -1;
        this.hkEventId = -1;
    }

    public StateHKEvent(int n, int n2) {
        this.keyStateId = n;
        this.hkEventId = n2;
    }

    public StateHKEvent(int n) {
        this.keyStateId = n;
    }

    public void setKeyStateID(int n) {
        this.keyStateId = n;
    }

    public int getKeyStateId() {
        return this.keyStateId;
    }

    public int getHkEventId() {
        return this.hkEventId;
    }

    public void setHkEventID(int n) {
        this.hkEventId = n;
    }

    public String toString() {
        return new StringBuilder().append("StateHKEvent [keyStateId=").append(this.keyStateId).append(", hkEventId=").append(new StringBuffer().append(this.hkEventId).append("]").toString()).toString();
    }
}

