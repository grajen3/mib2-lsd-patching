/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.radiotext2;

import de.vw.mib.asl.internal.radio.GuiApiDab;
import de.vw.mib.asl.internal.radio.GuiApiTunerCommon;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.has.RadioHASUpdater;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.GenericEventException;
import java.util.Iterator;
import org.dsi.ifc.radio.DABRadioText;

final class ReceivedRadioText {
    private final AbstractTarget mTarget;
    private DABRadioText mRadioText = null;
    private boolean mDirtyRadioTextPlus = false;
    private boolean mDirtyRadioText = false;
    private final IntObjectOptHashMap mRTPlusContentList = new IntObjectOptHashMap();

    ReceivedRadioText(AbstractTarget abstractTarget) {
        this.mTarget = abstractTarget;
    }

    void clearAndUpdateRT() {
        this.mRadioText = null;
        this.mRTPlusContentList.clear();
        this.mDirtyRadioTextPlus = false;
        this.mDirtyRadioText = false;
        this.updateHmi();
        GuiApiTunerCommon.updateDabRadioTextPlusActive(false);
    }

    boolean isRadioTextDirty() {
        return (this.mDirtyRadioText || this.mDirtyRadioTextPlus) && null != this.mRadioText && this.mRadioText.getText().length() > 0;
    }

    void setRadioText(DABRadioText dABRadioText) {
        this.mDirtyRadioText = true;
        this.mRadioText = dABRadioText;
        this.checkTimer();
    }

    void setRadioTextPlus(int[] nArray, String[] stringArray) {
        if (nArray != null && stringArray != null) {
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                String string = stringArray[i2].trim();
                if (string.length() > 0) {
                    this.mRTPlusContentList.put(nArray[i2], string);
                } else {
                    this.mRTPlusContentList.remove(nArray[i2]);
                }
                this.mDirtyRadioTextPlus = true;
            }
        }
        this.checkTimer();
    }

    boolean isRTPlusAvailable() {
        return this.mRTPlusContentList.isEmpty();
    }

    void clearRTPlus() {
        this.mRTPlusContentList.clear();
    }

    void updateHmi() {
        String string = this.mRadioText == null ? "" : this.mRadioText.getText();
        GuiApiDab.updateRadioText(string);
        if (RadioCurrentWaveband.isDab() && RadioCodingAdapter.isRadioTileFeatureActivated()) {
            RadioServiceManager.getServiceManager().getApiGuiRadioTiles().updateRadioText(string);
        }
        GuiApiDab.updateRadioTextPlus(this.mRTPlusContentList);
        Iterator iterator = this.mRTPlusContentList.values().iterator();
        boolean bl = false;
        while (iterator.hasNext()) {
            String string2 = (String)iterator.next();
            if (string2.equals("")) continue;
            bl = true;
        }
        if (this.mRTPlusContentList.size() != 0 && this.mRTPlusContentList.containsKey(1)) {
            GuiApiTunerCommon.updateDabRadioTextPlusActive(bl);
            if (!bl && this.mTarget.isTraceEnabled()) {
                this.mTarget.trace("+++ RTPLUS is empty, show normal RT");
            }
        } else {
            GuiApiTunerCommon.updateDabRadioTextPlusActive(false);
        }
        this.mDirtyRadioText = false;
        this.mDirtyRadioTextPlus = false;
        this.stopDebounceTimer();
        RadioHASUpdater.updateRadioTextInfo(string, (String)this.mRTPlusContentList.get(1), (String)this.mRTPlusContentList.get(4), (String)this.mRTPlusContentList.get(2));
    }

    void startDebounceTimer() {
        if (!this.mTarget.getTimerServer().isTimerActive(this.mTarget.getTargetId(), 176619776)) {
            this.mTarget.startTimer(176619776, (long)0, false);
        }
    }

    void stopDebounceTimer() {
        this.mTarget.stopTimer(176619776);
    }

    private void checkTimer() {
        if (this.mDirtyRadioText && this.mDirtyRadioTextPlus) {
            this.stopDebounceTimer();
            try {
                this.mTarget.triggerMe(176619776);
            }
            catch (GenericEventException genericEventException) {}
        } else if (this.mDirtyRadioText != this.mDirtyRadioTextPlus) {
            this.startDebounceTimer();
        }
    }
}

