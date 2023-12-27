/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api.onlineupdatev10.data;

import de.vw.mib.asl.api.ocu.onlineupdatev10.data.OnlineUpdateList$OnlineUpdateListState;
import java.util.List;

public class OnlineUpdateList
implements de.vw.mib.asl.api.ocu.onlineupdatev10.data.OnlineUpdateList {
    private final OnlineUpdateList$OnlineUpdateListState listState;
    private final List listData;

    public OnlineUpdateList(OnlineUpdateList$OnlineUpdateListState onlineUpdateList$OnlineUpdateListState, List list) {
        this.listState = onlineUpdateList$OnlineUpdateListState;
        this.listData = list;
    }

    @Override
    public OnlineUpdateList$OnlineUpdateListState getListState() {
        return this.listState;
    }

    @Override
    public List getListData() {
        return this.listData;
    }

    public int hashCode() {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + (this.listData == null ? 0 : ((Object)this.listData).hashCode());
        n2 = 31 * n2 + (this.listState == null ? 0 : this.listState.hashCode());
        return n2;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        OnlineUpdateList onlineUpdateList = (OnlineUpdateList)object;
        if (this.listData == null ? onlineUpdateList.listData != null : !((Object)this.listData).equals(onlineUpdateList.listData)) {
            return false;
        }
        return !(this.listState == null ? onlineUpdateList.listState != null : this.listState.value() != onlineUpdateList.listState.value());
    }
}

