/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.valetparking;

import de.vw.mib.asl.api.system.valetparking.ValetParkingCallback;
import de.vw.mib.asl.api.system.valetparking.ValetParkingListenerAdapter;
import de.vw.mib.asl.systemcommon.persistence.SystemCommon;
import de.vw.mib.asl.systemcommon.persistence.SystemCommonPersistenceService;

class ValetParkingPersistence
extends ValetParkingListenerAdapter {
    private final SystemCommon systemCommon;

    ValetParkingPersistence(SystemCommonPersistenceService systemCommonPersistenceService) {
        if (systemCommonPersistenceService == null) {
            throw new IllegalArgumentException("ASL-System Common Persistence Service must not be null.");
        }
        this.systemCommon = systemCommonPersistenceService.loadSystemCommon();
    }

    boolean loadPersistedValetParkingActive() {
        return this.systemCommon.isValetParkingActive();
    }

    @Override
    public void notifyValetParkingStateChanged(boolean bl, ValetParkingCallback valetParkingCallback) {
        this.systemCommon.setValetParkingActive(bl);
        valetParkingCallback.notifyValetParkingTransitionFinished(true);
    }
}

