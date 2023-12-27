/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm.api.impl.audioinformation;

import de.vw.mib.asl.internal.exboxm.api.impl.audioinformation.ExboxAudioInformationServiceImpl;
import de.vw.mib.asl.internal.exboxm.api.impl.audioinformation.StationInfoDataImpl;
import de.vw.mib.asl.internal.exboxm.util.AbstractExboxListener;

final class DsiAudioInformationListener
extends AbstractExboxListener {
    private final ExboxAudioInformationServiceImpl audioInformationService;

    DsiAudioInformationListener(ExboxAudioInformationServiceImpl exboxAudioInformationServiceImpl) {
        this.audioInformationService = exboxAudioInformationServiceImpl;
    }

    @Override
    public void updateActiveSourceType(int n, int n2) {
        if (n2 == 1) {
            this.audioInformationService.updateSourceType(n);
        }
    }

    @Override
    public void updateCurrentStationInfo(String string, int n, String string2, int n2, int n3, String string3, int n4, String string4, int n5, int n6) {
        if (n6 == 1) {
            StationInfoDataImpl stationInfoDataImpl = new StationInfoDataImpl(n2, string, n, string2, n3, string3, n4, string4, n5);
            this.audioInformationService.updateStationInfoData(stationInfoDataImpl);
        }
    }
}

