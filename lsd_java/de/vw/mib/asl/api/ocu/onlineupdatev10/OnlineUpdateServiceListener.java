/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.ocu.onlineupdatev10;

import de.vw.mib.asl.api.ocu.onlineupdatev10.OnlineUpdateService;
import de.vw.mib.asl.api.ocu.onlineupdatev10.data.OnlineUpdateChallengeList;
import de.vw.mib.asl.api.ocu.onlineupdatev10.data.OnlineUpdateList;
import de.vw.mib.asl.api.ocu.onlineupdatev10.data.OnlineUpdateState;

public interface OnlineUpdateServiceListener {
    default public void updateOnlineUpdateState(OnlineUpdateService onlineUpdateService, OnlineUpdateState onlineUpdateState) {
    }

    default public void updateOnlineUpdateList(OnlineUpdateService onlineUpdateService, OnlineUpdateList onlineUpdateList) {
    }

    default public void updateOnlineUpdateChallengeList(OnlineUpdateService onlineUpdateService, OnlineUpdateChallengeList onlineUpdateChallengeList) {
    }
}

