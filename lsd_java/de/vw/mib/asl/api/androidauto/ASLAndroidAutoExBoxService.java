/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.androidauto;

import de.vw.mib.asl.api.androidauto.ASLAndroidAutoExBoxServiceListener;

public interface ASLAndroidAutoExBoxService {
    default public void pairingResponse(String string) {
    }

    default public void sendBluetoothAuthData(String string) {
    }

    default public void setPairingSuccessful(boolean bl) {
    }

    default public void setExBoxBluetoothMacAddress(String string) {
    }

    default public void setListener(ASLAndroidAutoExBoxServiceListener aSLAndroidAutoExBoxServiceListener) {
    }

    default public void removeListener() {
    }
}

