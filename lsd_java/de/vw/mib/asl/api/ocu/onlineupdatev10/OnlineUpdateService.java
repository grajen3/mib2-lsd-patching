/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.ocu.onlineupdatev10;

import de.vw.mib.asl.api.ocu.onlineupdatev10.OnlineUpdateServiceResponseListener;
import de.vw.mib.asl.api.ocu.onlineupdatev10.data.OnlineUpdateChallengeList;
import de.vw.mib.asl.api.ocu.onlineupdatev10.data.OnlineUpdateList;
import de.vw.mib.asl.api.ocu.onlineupdatev10.data.OnlineUpdateState;
import java.util.Date;

public interface OnlineUpdateService {
    default public OnlineUpdateState getOnlineUpdateState() {
    }

    default public OnlineUpdateChallengeList getOnlineUpdateChallengeList() {
    }

    default public OnlineUpdateList getOnlineUpdateList() {
    }

    default public void postponeOnlineDownload(String string, Date date, OnlineUpdateServiceResponseListener onlineUpdateServiceResponseListener) {
    }

    default public void authenticateOnlineDownload(String string, OnlineUpdateServiceResponseListener onlineUpdateServiceResponseListener) {
    }

    default public void requestChallenge(OnlineUpdateServiceResponseListener onlineUpdateServiceResponseListener) {
    }

    default public void confirmOnlineDownloadError(String string, OnlineUpdateServiceResponseListener onlineUpdateServiceResponseListener) {
    }

    default public void postponeUpdateInstallation(String string, Date date, OnlineUpdateServiceResponseListener onlineUpdateServiceResponseListener) {
    }

    default public void confirmUpdateInstallation(String string, OnlineUpdateServiceResponseListener onlineUpdateServiceResponseListener) {
    }

    default public void confirmInstallationError(String string, OnlineUpdateServiceResponseListener onlineUpdateServiceResponseListener) {
    }

    default public void confirmInstallationFinished(String string, OnlineUpdateServiceResponseListener onlineUpdateServiceResponseListener) {
    }

    default public void confirmUpdateWithdrawn(String string, OnlineUpdateServiceResponseListener onlineUpdateServiceResponseListener) {
    }
}

