/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.androidauto.api.impl;

import de.vw.mib.asl.api.androidauto.ASLAndroidAutoExBoxService;
import de.vw.mib.asl.api.androidauto.ASLAndroidAutoExBoxServiceListener;
import de.vw.mib.asl.internal.androidauto.target.AndroidAutoTarget;

public class ASLAndroidAutoExBoxServiceImpl
implements ASLAndroidAutoExBoxService {
    private AndroidAutoTarget myTarget;
    ASLAndroidAutoExBoxServiceListener listener;

    @Override
    public void pairingResponse(String string) {
    }

    @Override
    public void sendBluetoothAuthData(String string) {
    }

    @Override
    public void setPairingSuccessful(boolean bl) {
    }

    @Override
    public void setExBoxBluetoothMacAddress(String string) {
    }

    @Override
    public void setListener(ASLAndroidAutoExBoxServiceListener aSLAndroidAutoExBoxServiceListener) {
        this.listener = aSLAndroidAutoExBoxServiceListener;
    }

    @Override
    public void removeListener() {
        this.listener = null;
    }

    public void setTarget(AndroidAutoTarget androidAutoTarget) {
        this.myTarget = androidAutoTarget;
    }

    public void notifyListenersPairingRequest(String string) {
        if (this.listener != null) {
            this.listener.pairingRequest(string);
        }
    }
}

