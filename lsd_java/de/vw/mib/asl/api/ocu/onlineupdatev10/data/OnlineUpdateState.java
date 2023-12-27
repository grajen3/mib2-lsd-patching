/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.ocu.onlineupdatev10.data;

import de.vw.mib.asl.api.ocu.onlineupdatev10.data.OnlineUpdateState$UpdateState;
import java.util.Date;

public interface OnlineUpdateState {
    default public String getUpdateId() {
    }

    default public UpdateState getUpdateState() {
    }

    default public int getProgress() {
    }

    default public Date getStartTime() {
    }
}

