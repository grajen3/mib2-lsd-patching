/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.uota.service;

import de.vw.mib.asl.api.download.DownloadStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.uota.states.UotATarget;
import de.vw.mib.genericevents.EventGeneric;

public class UotAInstallationService
implements DownloadStateListener {
    private final String _classname = super.getClass().getName();
    private UotATarget _target;

    public UotAInstallationService(UotATarget uotATarget) {
        this._target = uotATarget;
    }

    @Override
    public void onNewDownloadProgressState(int n) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(new StringBuffer().append(".onNewDownloadProgressState(").append(n).append(")").toString()).log();
        }
        boolean bl = false;
        int n2 = 0;
        switch (n) {
            case 0: {
                n2 = 913;
                bl = true;
                break;
            }
            case 1: {
                n2 = 914;
                bl = true;
                break;
            }
            case 2: {
                n2 = 915;
                bl = true;
                break;
            }
        }
        if (bl) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this._target.getDefaultTargetId(), this._target.getDefaultTargetId(), -1568276224);
            eventGeneric.setInt(0, n2);
            this._target.sendSafe(eventGeneric);
        }
    }
}

