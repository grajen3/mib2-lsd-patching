/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.api.tile.impl;

import de.vw.mib.asl.internal.tvtuner.accessor.TVTunerObjectAccessor;

public class TVTunerTileDisclaimerHelper {
    public void checkDisclaimers() {
        this.checkDisclaimerTunerNotAvailable();
        this.checkDisclaimerTunerStarting();
        this.checkDisclaimerCas();
        this.checkDisclaimerRadio();
    }

    private void checkDisclaimerCas() {
        boolean bl = TVTunerObjectAccessor.getStartUpConfigHandler().getLastStartupConfig().isTmCASAvail();
        boolean bl2 = TVTunerObjectAccessor.getTvTunerSettings().getCasStatus() == 5;
        int n = TVTunerObjectAccessor.getTvAvSourceHandler().getActiveSource();
        if (bl && bl2 && n == 0) {
            TVTunerObjectAccessor.getTileService().updateDisclaimerCasVisible(true);
        } else {
            TVTunerObjectAccessor.getTileService().updateDisclaimerCasVisible(false);
        }
    }

    private void checkDisclaimerRadio() {
        int n = TVTunerObjectAccessor.getTvAvSourceHandler().getActiveSource();
        int n2 = TVTunerObjectAccessor.getTVInfo().getCurrentStationSType();
        boolean bl = n2 == 3 || n2 == 10;
        boolean bl2 = n2 == 6;
        boolean bl3 = TVTunerObjectAccessor.getTvTunerSettings().isVisualAudioShowPictures();
        if (n == 0 && (bl || bl2 && !bl3)) {
            TVTunerObjectAccessor.getTileService().updateDisclaimerRadioVisible(true);
        } else {
            TVTunerObjectAccessor.getTileService().updateDisclaimerRadioVisible(false);
        }
    }

    private void checkDisclaimerTunerNotAvailable() {
        boolean bl = false;
        if (TVTunerObjectAccessor.getTargetTVTunerDSI().getTunerActiveState() == 1) {
            bl = true;
        } else if (TVTunerObjectAccessor.getTargetTVTunerDSI().getTunerActiveState() == 0) {
            bl = false;
        }
        TVTunerObjectAccessor.getTileService().updateDisclaimerTunerNotAvailableVisible(!bl);
    }

    private void checkDisclaimerTunerStarting() {
        boolean bl = false;
        if (TVTunerObjectAccessor.getTargetTVTunerDSI().getTunerWaitState() == 1) {
            bl = false;
        } else if (TVTunerObjectAccessor.getTargetTVTunerDSI().getTunerWaitState() == 0) {
            bl = true;
        }
        TVTunerObjectAccessor.getTileService().updateDisclaimerTunerStartingVisible(bl);
    }
}

