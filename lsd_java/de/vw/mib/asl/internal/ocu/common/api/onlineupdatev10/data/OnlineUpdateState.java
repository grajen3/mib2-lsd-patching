/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api.onlineupdatev10.data;

import de.vw.mib.asl.api.ocu.onlineupdatev10.data.OnlineUpdateState$UpdateState;
import java.util.Date;

public class OnlineUpdateState
implements de.vw.mib.asl.api.ocu.onlineupdatev10.data.OnlineUpdateState {
    private final String updateId;
    private final OnlineUpdateState$UpdateState updateState;
    private final int progress;
    private Date startTime;

    public OnlineUpdateState(String string, OnlineUpdateState$UpdateState onlineUpdateState$UpdateState, int n, String string2) {
        this.updateId = string;
        this.progress = n;
        this.updateState = onlineUpdateState$UpdateState;
    }

    @Override
    public String getUpdateId() {
        return this.updateId;
    }

    @Override
    public OnlineUpdateState$UpdateState getUpdateState() {
        return this.updateState;
    }

    @Override
    public int getProgress() {
        return this.progress;
    }

    @Override
    public Date getStartTime() {
        return this.startTime;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        OnlineUpdateState onlineUpdateState = (OnlineUpdateState)object;
        if (this.progress != onlineUpdateState.progress) {
            return false;
        }
        if (this.startTime == null ? onlineUpdateState.startTime != null : !this.startTime.equals(onlineUpdateState.startTime)) {
            return false;
        }
        if (this.updateId == null ? onlineUpdateState.updateId != null : !this.updateId.equals(onlineUpdateState.updateId)) {
            return false;
        }
        return !(this.updateState == null ? onlineUpdateState.updateState != null : this.updateState.value() != onlineUpdateState.updateState.value());
    }

    public int hashCode() {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + this.progress;
        n2 = 31 * n2 + (this.startTime == null ? 0 : this.startTime.hashCode());
        n2 = 31 * n2 + (this.updateId == null ? 0 : this.updateId.hashCode());
        n2 = 31 * n2 + (this.updateState == null ? 0 : this.updateState.hashCode());
        return n2;
    }
}

