/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.appadapter;

import de.vw.mib.asl.api.radio.ASLRadioFactory;
import de.vw.mib.asl.api.radio.AppAdapterTunerTileLCallback;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.manager.ManagerTarget;

public final class ApiAppAdapterTunerTileL {
    public static AppAdapterTunerTileLCallback appAdapterTunerTileLCallback = null;

    public static void setWaveband() {
        try {
            if (!RadioData.amFmTunerIsCompletelyInitialized || null == appAdapterTunerTileLCallback || !RadioServiceManager.getServiceManager().isRadioTileLCioIntentRegistrationFinished()) {
                return;
            }
            RadioServiceManager.getServiceManager().setRadioTileLNextWavebandInitializedAfterStartup(true);
            if (ManagerTarget.isRadioActive) {
                ApiAppAdapterTunerTileL.setNextWaveband();
            } else {
                ApiAppAdapterTunerTileL.setCurrentWaveband();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    private static void setNextWaveband() {
        int n = 100;
        int n2 = RadioData.getAmfmDatabase().getSettingsPersistable().getWaveband();
        if (n2 == 4) {
            if (ASLRadioFactory.getRadioApi().isWavebandAvailable(0)) {
                n = 0;
            }
        } else if (n2 == 2) {
            if (ASLRadioFactory.getRadioApi().isWavebandAvailable(1)) {
                n = 1;
            }
        } else if (n2 == 1) {
            if (ASLRadioFactory.getRadioApi().isWavebandAvailable(0)) {
                n = 0;
            } else if (ASLRadioFactory.getRadioApi().isWavebandAvailable(2)) {
                n = 2;
            }
        } else if (n2 == 0) {
            if (ASLRadioFactory.getRadioApi().isWavebandAvailable(4)) {
                n = 4;
            } else if (ASLRadioFactory.getRadioApi().isWavebandAvailable(2)) {
                n = 2;
            } else if (ASLRadioFactory.getRadioApi().isWavebandAvailable(1)) {
                n = 1;
            }
        }
        if (n != 100) {
            appAdapterTunerTileLCallback.setNextWaveband(n);
        }
    }

    private static void setCurrentWaveband() {
        int n = RadioData.getAmfmDatabase().getSettingsPersistable().getWaveband();
        appAdapterTunerTileLCallback.setNextWaveband(n);
    }
}

