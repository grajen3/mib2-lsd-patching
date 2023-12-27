/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.ocu.onlineupdatev10;

import de.vw.mib.asl.api.ocu.onlineupdatev10.OnlineUpdateService;
import de.vw.mib.asl.api.ocu.onlineupdatev10.OnlineUpdateServiceListener;
import de.vw.mib.asl.api.ocu.onlineupdatev10.data.OnlineUpdateChallengeList;
import de.vw.mib.asl.api.ocu.onlineupdatev10.data.OnlineUpdateList;
import de.vw.mib.asl.api.ocu.onlineupdatev10.data.OnlineUpdateState;

public class OnlineUpdateServiceListenerAdapter
implements OnlineUpdateServiceListener {
    @Override
    public void updateOnlineUpdateState(OnlineUpdateService onlineUpdateService, OnlineUpdateState onlineUpdateState) {
    }

    @Override
    public void updateOnlineUpdateList(OnlineUpdateService onlineUpdateService, OnlineUpdateList onlineUpdateList) {
    }

    public void updateOnlineUpdateChallengeData(OnlineUpdateService onlineUpdateService, OnlineUpdateChallengeList onlineUpdateChallengeList) {
    }

    @Override
    public void updateOnlineUpdateChallengeList(OnlineUpdateService onlineUpdateService, OnlineUpdateChallengeList onlineUpdateChallengeList) {
    }
}

