/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.ocu.onlineupdatev10.data;

import de.vw.mib.asl.api.ocu.onlineupdatev10.data.OnlineUpdateList$OnlineUpdateListState;
import java.util.List;

public interface OnlineUpdateList {
    default public OnlineUpdateListState getListState() {
    }

    default public List getListData() {
    }
}

