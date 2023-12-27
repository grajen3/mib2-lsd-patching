/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.exboxm.audioinformation;

import de.vw.mib.asl.api.exboxm.audioinformation.ExboxAudioInformationListener;
import de.vw.mib.asl.api.exboxm.audioinformation.StationInfoData;

public interface ExboxAudioInformationService {
    default public void addListener(ExboxAudioInformationListener exboxAudioInformationListener) {
    }

    default public int getCurrentAudioSource() {
    }

    default public StationInfoData getCurrentStationInfo() {
    }

    default public void removeListener(ExboxAudioInformationListener exboxAudioInformationListener) {
    }
}

