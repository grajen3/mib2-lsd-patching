/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiDab;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.api.impl.speech.AslRadioDabFacadeImpl;
import de.vw.mib.asl.internal.radio.dab.DabAudioManager;
import de.vw.mib.asl.internal.radio.dab.DabFrequencyTable;
import de.vw.mib.asl.internal.radio.dab.DabOptionAnnouncement;
import de.vw.mib.asl.internal.radio.dab.DabOptionLinking;
import de.vw.mib.asl.internal.radio.dab.DabPersistable;
import de.vw.mib.asl.internal.radio.dab.DabTunerState;
import de.vw.mib.asl.internal.radio.dab.DabViewMode;
import de.vw.mib.asl.internal.radio.dab.presets.DabPreset;
import de.vw.mib.asl.internal.radio.dab.presets.DabPresetList;
import de.vw.mib.genericevents.AbstractTarget;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.DataServiceInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.ServiceInfo;

public final class DabDatabase {
    public final DabPresetList dabPresetList = new DabPresetList();
    public final DabOptionLinking mOptionLinking = new DabOptionLinking();
    public final DabViewMode mRadioTextSetupState = new DabViewMode();
    public final DabOptionAnnouncement mAnnouncement = new DabOptionAnnouncement();
    public final DabFrequencyTable mFrequencyTable = new DabFrequencyTable();
    private boolean dabDeviceFitted = false;
    public boolean learnMemoryUpdateRunning = false;
    public boolean mManualMode = false;
    public boolean mInitialStartup = true;
    public DabPersistable mPersistable = new DabPersistable();
    public DabAudioManager mAudioManager = new DabAudioManager();
    public DabTunerState mTunerState = new DabTunerState();
    public static AbstractTarget mDabMainTarget = null;
    public static AbstractTarget mDabSlsTarget = null;
    private static boolean isDabSpeechServiceRegistered = false;
    public boolean scanActive = false;
    public boolean searchingActive = false;
    private int dabTunerAvailability = 0;
    private boolean dabReadyFirstTime = true;
    private boolean dabTunerIsInitialized = false;
    static /* synthetic */ Class class$de$vw$mib$asl$api$radio$speech$dab$AslRadioDabFacade;

    public int getDabTunerAvailability() {
        return this.dabTunerAvailability;
    }

    public void setDabTunerAvailability(int n) {
        this.dabTunerAvailability = n;
        this.triggerDabPerformanceTrace();
    }

    public void clear() {
        try {
            this.mOptionLinking.reset();
            this.mRadioTextSetupState.reset();
            this.mAnnouncement.reset();
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void resetLSMAndLists(boolean bl) {
        try {
            DabPreset[] dabPresetArray = this.dabPresetList.getPresets();
            if (null == dabPresetArray) {
                return;
            }
            this.dabPresetList.resetPictures();
            for (int i2 = 0; i2 < dabPresetArray.length; ++i2) {
                this.dabPresetList.reset();
            }
            this.dabPresetList.deleteAllPresets();
            this.dabPresetList.setVisibleBankIndex(0);
            this.mTunerState.setServiceList(new ServiceInfo[0]);
            this.mTunerState.setEnsembleList(new EnsembleInfo[0]);
            this.mTunerState.setComponentList(new ComponentInfo[0]);
            this.mTunerState.mDataServiceList = new DataServiceInfo[0];
            this.resetLSM(bl);
            this.dabPresetList.notifyFriendsAboutList();
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void resetLSM(boolean bl) {
        try {
            this.dabPresetList.setCurrentVisibleIndex(-1, false);
            RadioData.getDabDatabase().mPersistable.setCurrentEnsemble(null);
            RadioData.getDabDatabase().mPersistable.setCurrentService(null);
            RadioData.getDabDatabase().mPersistable.setCurrentComponent(null);
            RadioData.getDabDatabase().mTunerState.setCurrentFrequency(0);
            RadioData.getDabDatabase().mTunerState.setCurrentService(null, null);
            if (bl) {
                this.dabPresetList.notifyHmi();
                GuiApiDab.UpdateDefaultStation();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public boolean getDabDeviceFitted() {
        return this.dabDeviceFitted;
    }

    public void setDabDeviceFitted(boolean bl) {
        try {
            this.dabDeviceFitted = bl;
            this.triggerDabPerformanceTrace();
            if (this.dabDeviceFitted && !isDabSpeechServiceRegistered) {
                isDabSpeechServiceRegistered = true;
                ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().registerAPI(class$de$vw$mib$asl$api$radio$speech$dab$AslRadioDabFacade == null ? (class$de$vw$mib$asl$api$radio$speech$dab$AslRadioDabFacade = DabDatabase.class$("de.vw.mib.asl.api.radio.speech.dab.AslRadioDabFacade")) : class$de$vw$mib$asl$api$radio$speech$dab$AslRadioDabFacade, new AslRadioDabFacadeImpl());
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void setDabTunerIsInitialized(boolean bl) {
        this.dabTunerIsInitialized = bl;
        this.triggerDabPerformanceTrace();
    }

    public boolean isDabTunerIsInitialized() {
        return this.dabTunerIsInitialized;
    }

    void triggerDabPerformanceTrace() {
        if (this.dabReadyFirstTime && this.dabTunerIsInitialized && this.dabTunerAvailability == 2 && this.dabDeviceFitted) {
            this.dabReadyFirstTime = false;
            if (ServiceManager.perfService != null) {
                ServiceManager.perfService.performanceLogMsgByID(4);
            }
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

