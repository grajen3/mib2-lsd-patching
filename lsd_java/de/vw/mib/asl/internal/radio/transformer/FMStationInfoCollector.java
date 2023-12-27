/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.transformer;

import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPreset;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetApi;
import de.vw.mib.asl.internal.radio.transformer.AmFmStationInfoCollector;

public class FMStationInfoCollector
extends AmFmStationInfoCollector {
    private boolean isFirstItemInNewSection = false;
    private boolean isSelectable;

    public FMStationInfoCollector(AmFmStation amFmStation) {
        if (amFmStation.getWaveband() != 1) {
            throw new IllegalArgumentException("Station does not belong to the FM frequency band");
        }
        this.station = amFmStation;
        AmFmPreset amFmPreset = AmFmPresetApi.getPreset(1, amFmStation);
        if (amFmPreset == null) {
            this.autocompare = 0;
            this.imageResourceLocator = null;
            this.hasPresetImage = false;
        } else {
            this.autocompare = amFmPreset.getIndex() + 1;
            this.imageResourceLocator = amFmPreset.getImage();
            this.hasPresetImage = this.imageResourceLocator != null;
        }
        this.setSelectable(true);
    }

    public boolean isFirstItemInNewSection() {
        return this.isFirstItemInNewSection;
    }

    public void setFirstItemInNewSection(boolean bl) {
        this.isFirstItemInNewSection = bl;
    }

    public boolean isSelectable() {
        return this.isSelectable;
    }

    public void setSelectable(boolean bl) {
        this.isSelectable = bl;
    }
}

