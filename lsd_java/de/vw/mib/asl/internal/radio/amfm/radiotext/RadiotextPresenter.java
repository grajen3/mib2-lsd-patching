/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.radiotext;

import de.vw.mib.asl.internal.radio.GuiApiTunerCommon;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.amfm.AmFmFactory;
import de.vw.mib.asl.internal.radio.amfm.radiotext.RadiotextStorage;
import de.vw.mib.asl.internal.radio.has.RadioHASUpdater;

final class RadiotextPresenter {
    private final RadiotextStorage mRadiotextStorage;
    private int mLastState;
    private boolean mDebugMode;

    RadiotextPresenter(RadiotextStorage radiotextStorage) {
        this.mRadiotextStorage = radiotextStorage;
        this.mLastState = 2;
        this.mDebugMode = false;
    }

    private boolean isPlusAllowedAndAvailable() {
        return RadioCodingAdapter.isRadioTextPlusActivated() && this.mRadiotextStorage.isPlus();
    }

    private void updateHmi() {
        String string = this.mRadiotextStorage.getText();
        AmFmFactory.getAslAmfmModelController().updateFmRadiotextAndState(string, 1);
        if (this.isPlusAllowedAndAvailable()) {
            String string2 = this.mRadiotextStorage.getArtist();
            String string3 = this.mRadiotextStorage.getTitle();
            AmFmFactory.getAslAmfmModelController().updateFmRadioTextPlus(string2, string3);
            GuiApiTunerCommon.updateFmRadioTextPlusActive(true);
            RadioHASUpdater.updateRadioTextInfo(string, string3, string2, "");
        } else {
            GuiApiTunerCommon.updateFmRadioTextPlusActive(false);
            AmFmFactory.getAslAmfmModelController().updateFmRadioTextPlus("", "");
            RadioHASUpdater.updateRadioTextInfo(string, "", "", "");
        }
    }

    private void updateHmi(int n) {
        AmFmFactory.getAslAmfmModelController().updateFmRadiotextAndState("", n);
        GuiApiTunerCommon.updateFmRadioTextPlusActive(false);
        AmFmFactory.getAslAmfmModelController().updateFmRadioTextPlus("", "");
        RadioHASUpdater.updateRadioTextInfo("", "", "", "");
    }

    void show(String string, String string2) {
        String string3;
        String string4 = string != null ? string.trim() : "";
        String string5 = string3 = string2 != null ? string2.trim() : "";
        if (string4.length() + string3.length() > 0) {
            this.mDebugMode = true;
            AmFmFactory.getAslAmfmModelController().updateFmRadiotextAndState("", 1);
            AmFmFactory.getAslAmfmModelController().updateFmRadioTextPlus(string4, string3);
            GuiApiTunerCommon.updateFmRadioTextPlusActive(true);
        } else {
            this.mDebugMode = false;
            if (this.mLastState == 1) {
                this.updateHmi();
            } else {
                this.updateHmi(this.mLastState);
            }
        }
    }

    void show() {
        this.mLastState = 1;
        if (!this.mDebugMode) {
            this.updateHmi();
        }
    }

    void show(int n) {
        this.mLastState = n;
        if (!this.mDebugMode) {
            this.updateHmi(n);
        }
    }
}

