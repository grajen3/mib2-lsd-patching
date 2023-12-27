/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.androidauto.api.impl;

import de.vw.mib.asl.api.androidauto.ASLAndroidAutoAPI;
import de.vw.mib.asl.api.androidauto.ASLAndroidAutoExBoxService;
import de.vw.mib.asl.framework.internal.framework.id.PreRegisteredIds;
import de.vw.mib.asl.internal.androidauto.api.impl.ASLAndroidAutoExBoxServiceImpl;

public class ASLAndroidAutoAPIImpl
implements ASLAndroidAutoAPI {
    ASLAndroidAutoExBoxService service;

    @Override
    public ASLAndroidAutoExBoxService getExBoxService() {
        if (this.service == null) {
            this.service = new ASLAndroidAutoExBoxServiceImpl();
        }
        return this.service;
    }

    static {
        PreRegisteredIds.addServiceOrObserverToArray(2, -230549504, 541076544);
        PreRegisteredIds.addServiceOrObserverToArray(2, -230549504, 557853760);
        PreRegisteredIds.addServiceOrObserverToArray(2, -230549504, 574630976);
        PreRegisteredIds.addServiceOrObserverToArray(2, -230549504, 608185408);
        PreRegisteredIds.addServiceOrObserverToArray(0, -230549504, -1030070784);
        PreRegisteredIds.addServiceOrObserverToArray(0, -230549504, -1013293568);
    }
}

