/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.presets;

import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetList;
import de.vw.mib.asl.internal.radio.amfm.presets.AmFmPresetModel;

final class AmFmPresetUpdater {
    private final AmFmPresetModel model;

    AmFmPresetUpdater(AmFmPresetModel amFmPresetModel) {
        this.model = amFmPresetModel;
    }

    void updateCurrentPreset() {
        this.model.updateCurrentPreset();
    }

    void updateGuiBank() {
        AmFmPresetList amFmPresetList = this.model.getList(RadioCurrentWaveband.get());
        if (amFmPresetList != null) {
            amFmPresetList.updateGuiBank();
        }
    }

    void setDsiDirty() {
        this.model.updateDsi();
    }
}

