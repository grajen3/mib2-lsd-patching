/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.transformer;

import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPreset;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetApi;
import de.vw.mib.asl.internal.radio.transformer.AmFmStationInfoCollector;

public class AMStationInfoCollector
extends AmFmStationInfoCollector {
    public AMStationInfoCollector(AmFmStation amFmStation) {
        if (amFmStation.getWaveband() != 3 && amFmStation.getWaveband() != 4) {
            throw new UnsupportedOperationException("Station does neither belong to the AM/MW nor AM/LW frequency band");
        }
        if (amFmStation.getWaveband() == 3) {
            this.station = amFmStation;
            AmFmPreset amFmPreset = AmFmPresetApi.getPreset(amFmStation);
            if (amFmPreset == null) {
                this.autocompare = 0;
                this.hasPresetImage = false;
                this.imageResourceLocator = null;
            } else {
                this.autocompare = amFmPreset.getIndex() + 1;
                this.imageResourceLocator = amFmPreset.getImage();
                this.hasPresetImage = this.imageResourceLocator != null;
            }
        } else {
            this.station = amFmStation;
            this.autocompare = 0;
            this.hasPresetImage = false;
            this.imageResourceLocator = null;
        }
    }
}

