/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.ocu.impl;

import de.vw.mib.asl.internal.online.ocu.common.OCUUpdateService;
import de.vw.mib.asl.internal.online.ocu.impl.OCUUpdateServiceResponseListener;
import de.vw.mib.asl.internal.online.ocu.states.OCUUpdateServiceTarget;
import java.util.Date;

public class OCUUpdateServiceHandler {
    private final OCUUpdateServiceTarget _target;

    public OCUUpdateServiceHandler(OCUUpdateServiceTarget oCUUpdateServiceTarget) {
        this._target = oCUUpdateServiceTarget;
    }

    private OCUUpdateServiceResponseListener getResponseListener() {
        return new OCUUpdateServiceResponseListener(this._target);
    }

    public void sendUpdateServiceStatus(int n, OCUUpdateService oCUUpdateService) {
        if (oCUUpdateService != null) {
            switch (n) {
                case 1: {
                    this._target.getUpdateService().postponeOnlineDownload(oCUUpdateService.getUpdateID(), new Date(), this.getResponseListener());
                    break;
                }
                case 7: {
                    this._target.getUpdateService().confirmOnlineDownloadError(oCUUpdateService.getUpdateID(), this.getResponseListener());
                    break;
                }
                case 4: {
                    this._target.getUpdateService().postponeUpdateInstallation(oCUUpdateService.getUpdateID(), new Date(), this.getResponseListener());
                    break;
                }
                case 5: {
                    this._target.getUpdateService().confirmUpdateInstallation(oCUUpdateService.getUpdateID(), this.getResponseListener());
                    break;
                }
                case 8: {
                    this._target.getUpdateService().confirmInstallationFinished(oCUUpdateService.getUpdateID(), this.getResponseListener());
                    break;
                }
                case 9: {
                    this._target.getUpdateService().confirmUpdateWithdrawn(oCUUpdateService.getUpdateID(), this.getResponseListener());
                    break;
                }
            }
        }
    }

    public void sendForUpdateServiceAuthentication(String string) {
        this._target.getUpdateService().authenticateOnlineDownload(string, this.getResponseListener());
    }

    public void requestChallenge() {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(".requestChallenge( )").log();
        }
        this._target.getUpdateService().requestChallenge(this.getResponseListener());
    }
}

