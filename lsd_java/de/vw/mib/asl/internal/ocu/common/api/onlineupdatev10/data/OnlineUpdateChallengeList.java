/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api.onlineupdatev10.data;

import de.vw.mib.asl.api.ocu.onlineupdatev10.data.OnlineUpdateList$OnlineUpdateListState;
import java.util.List;

public class OnlineUpdateChallengeList
implements de.vw.mib.asl.api.ocu.onlineupdatev10.data.OnlineUpdateChallengeList {
    private final OnlineUpdateList$OnlineUpdateListState listState;
    private final List listData;
    private final int hashProcedureVersion;

    public OnlineUpdateChallengeList(OnlineUpdateList$OnlineUpdateListState onlineUpdateList$OnlineUpdateListState, List list, int n) {
        this.listData = list;
        this.listState = onlineUpdateList$OnlineUpdateListState;
        this.hashProcedureVersion = n;
    }

    @Override
    public OnlineUpdateList$OnlineUpdateListState getListState() {
        return this.listState;
    }

    @Override
    public List getListData() {
        return this.listData;
    }

    @Override
    public int getHashProcedureVersion() {
        return this.hashProcedureVersion;
    }

    public int hashCode() {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + this.hashProcedureVersion;
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
        OnlineUpdateChallengeList onlineUpdateChallengeList = (OnlineUpdateChallengeList)object;
        if (this.hashProcedureVersion != onlineUpdateChallengeList.hashProcedureVersion) {
            return false;
        }
        if (this.listData == null ? onlineUpdateChallengeList.listData != null : !((Object)this.listData).equals(onlineUpdateChallengeList.listData)) {
            return false;
        }
        return !(this.listState == null ? onlineUpdateChallengeList.listState != null : this.listState.value() != onlineUpdateChallengeList.listState.value());
    }
}

