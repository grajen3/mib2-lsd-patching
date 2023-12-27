/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.tvtuner.accessor.TVTunerObjectAccessor;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.tvtuner.DSITVTuner;
import org.dsi.ifc.tvtuner.EWSInfo;
import org.dsi.ifc.tvtuner.LogoInfo;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;
import org.dsi.ifc.tvtuner.StartUpConfig;

public class TargetTVTunerDSI
extends AbstractASLTarget {
    private DSITVTuner dsiTVTuner;
    private DSIListener dsiTVTunerListener;
    private int tunerWaitState = -1;
    private int tunerActiveState = -1;
    private long lastNamePID = -1L;
    private long lastServicePID = -1L;
    static /* synthetic */ Class class$org$dsi$ifc$tvtuner$DSITVTuner;
    static /* synthetic */ Class class$org$dsi$ifc$tvtuner$DSITVTunerListener;

    void setTunerActiveState(int n) {
        this.tunerActiveState = n;
    }

    public TargetTVTunerDSI(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.trace("Target TVTunerDSI - Initialising Target TVTunerDSI!");
    }

    public TargetTVTunerDSI(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.trace("Target TVTunerDSI - Initialising Target TVTunerDSI!");
    }

    @Override
    public int getDefaultTargetId() {
        return 33101056;
    }

    public void initializeDSI() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiTVTuner = (DSITVTuner)dSIProxy.getService(this, class$org$dsi$ifc$tvtuner$DSITVTuner == null ? (class$org$dsi$ifc$tvtuner$DSITVTuner = TargetTVTunerDSI.class$("org.dsi.ifc.tvtuner.DSITVTuner")) : class$org$dsi$ifc$tvtuner$DSITVTuner);
        this.dsiTVTunerListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$tvtuner$DSITVTunerListener == null ? (class$org$dsi$ifc$tvtuner$DSITVTunerListener = TargetTVTunerDSI.class$("org.dsi.ifc.tvtuner.DSITVTunerListener")) : class$org$dsi$ifc$tvtuner$DSITVTunerListener);
        TVTunerObjectAccessor.setTargetTVTunerDSI(this);
    }

    private void setNotifications() {
        this.dsiTVTuner.setNotification(new int[]{7, 10, 19, 15, 6, 21, 17, 5, 4, 2, 8, 3, 16, 9, 14, 20, 1, 18, 11, 13, 12}, this.dsiTVTunerListener);
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$tvtuner$DSITVTunerListener == null ? (class$org$dsi$ifc$tvtuner$DSITVTunerListener = TargetTVTunerDSI.class$("org.dsi.ifc.tvtuner.DSITVTunerListener")) : class$org$dsi$ifc$tvtuner$DSITVTunerListener, this.dsiTVTunerListener);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.initializeDSI();
                this.setNotifications();
                break;
            }
        }
    }

    public DSITVTuner getDSITVTuner() {
        return this.dsiTVTuner;
    }

    @Override
    public int getSubClassifier() {
        return 2;
    }

    @Override
    public int getClassifier() {
        return 32768;
    }

    public void dsiTVTunerUpdateTunerState(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("TargetTVTunerDSI#dsiTVTunerUpdateTunerState called - validFlag is ").append(this.getValidity(n2)).toString());
        }
        if (n2 == 1) {
            if (this.isTraceEnabled()) {
                this.trace(new StringBuffer().append("TargetTVTunerDSI#dsiTVTunerUpdateTunerState - tunerState is ").append(n == 1 ? "active" : "inactive").toString());
            }
            TVTunerObjectAccessor.getTargetTVTuner().setTVTunerAvailable(n == 1);
            switch (n) {
                case 0: {
                    this.setTunerActiveState(0);
                    ServiceManager.aslPropertyManager.valueChangedInteger(2787, 0);
                    break;
                }
                case 1: {
                    this.setTunerActiveState(1);
                    ServiceManager.aslPropertyManager.valueChangedInteger(2787, 1);
                    if (TVTunerObjectAccessor.getResetParticipant().getResetState() != 2) break;
                    if (this.getTunerWaitState() == 1) {
                        TVTunerObjectAccessor.getTvTunerDB().getTvPersistable().updateTunerSettings(true);
                        TVTunerObjectAccessor.getResetParticipant().setResetState(0);
                        break;
                    }
                    TVTunerObjectAccessor.getTvAvSourceHandler().wakeUpTuner(true);
                    break;
                }
            }
            if (TVTunerObjectAccessor.getTargetTVTuner().isTVContextEntered()) {
                if (this.isTraceEnabled()) {
                    this.trace("TargetTVTunerDSI#dsiTVTunerUpdateTunerState: try to reconnect audio");
                }
                TVTunerObjectAccessor.getTvTunerAudio().requestTVAudioConnection();
            } else if (this.isTraceEnabled()) {
                this.trace("TargetTVTunerDSI#dsiTVTunerUpdateTunerState: tv context not active - no audio needed");
            }
            TVTunerObjectAccessor.getTileDisclaimerHelper().checkDisclaimers();
        }
    }

    public void dsiTVTunerUpdateServiceList(ServiceInfo[] serviceInfoArray, int n) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("TargetTVTunerDSI#dsiTVTunerUpdateServiceList called - validFlag is ").append(this.getValidity(n)).toString());
        }
        if (n == 1) {
            TVTunerObjectAccessor.getStationListHandler().updateServiceInfo(serviceInfoArray, true);
        }
    }

    public void dsiTVTunerUpdateSelectedService(ProgramInfo programInfo, int n) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("TargetTVTunerDSI#dsiTVTunerUpdateSelectedService called - validFlag is ").append(this.getValidity(n)).toString());
        }
        if (n == 1) {
            TVTunerObjectAccessor.getTvTunerSettings().updateAvailableAudioChannels(programInfo.getAvailableAudioChannels());
            TVTunerObjectAccessor.getTvTunerSettings().updateSelectedAudioChannel(programInfo.getSelectedAudioChannel());
            TVTunerObjectAccessor.getTVInfo().updateOSDProgramInfo(programInfo);
            TVTunerObjectAccessor.getTuningHandler().repeatNonStopSeeking();
            if (TVTunerObjectAccessor.getStationListHandler().isSaveStation()) {
                this.sendHMIEvent(436);
            } else if (this.lastNamePID != programInfo.serviceInfo.namePID || this.lastServicePID != (long)programInfo.serviceInfo.servicePID) {
                this.sendHMIEvent(456);
            }
            this.lastNamePID = programInfo.serviceInfo.namePID;
            this.lastServicePID = programInfo.serviceInfo.servicePID;
            TVTunerObjectAccessor.getStationListHandler().updateServiceInfo();
            TVTunerObjectAccessor.getTileDisclaimerHelper().checkDisclaimers();
        }
    }

    public void dsiTVTunerUpdateSelectedSource(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("TargetTVTunerDSI#dsiTVTunerUpdateSelectedSource called - validFlag is ").append(this.getValidity(n2)).toString());
        }
        if (n2 == 1) {
            TVTunerObjectAccessor.getTvAvSourceHandler().updateSource(n);
        }
    }

    public void dsiTVTunerUpdateTVNormArea(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("TargetTVTunerDSI#dsiTVTunerUpdateTVNormArea called - validFlag is ").append(this.getValidity(n2)).toString());
        }
        if (n2 == 1) {
            TVTunerObjectAccessor.getTvTunerSettings().updateTVNormArea(n);
        }
    }

    public void dsiTVTunerUpdateAudioChannel(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("TargetTVTunerDSI#dsiTVTunerUpdateAudioChannel called - validFlag is ").append(this.getValidity(n2)).toString());
        }
        if (n2 == 1) {
            TVTunerObjectAccessor.getTvTunerSettings().updateSelectedAudioChannel(n);
        }
    }

    public void dsiTVTunerUpdateMuteState(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("TargetTVTunerDSI#dsiTVTunerUpdateMuteState called - validFlag is ").append(this.getValidity(n2)).toString());
        }
        if (n2 == 1) {
            TVTunerObjectAccessor.getTVInfo().updateMuteState(n);
        }
    }

    public void dsiTVTunerUpdateInfoTextState(String string, int n) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("TargetTVTunerDSI#dsiTVTunerUpdateInfoTextState called - validFlag is ").append(this.getValidity(n)).toString());
        }
    }

    public void dsiTVTunerUpdateTerminalMode(int n, int n2, int n3) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("TargetTVTunerDSI#dsiTVTunerUpdateTerminalMode called - validFlag is ").append(this.getValidity(n3)).toString());
        }
        if (n3 == 1) {
            TVTunerObjectAccessor.getTMHandler().updateTerminalMode(n, n2);
        }
    }

    public void dsiTVTunerUpdateServiceLinking(boolean bl, int n) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("TargetTVTunerDSI#dsiTVTunerUpdateServiceLinking called - validFlag is ").append(this.getValidity(n)).toString());
        }
        if (n == 1) {
            TVTunerObjectAccessor.getTvTunerSettings().updateServiceLinkingState(bl);
        }
    }

    public void dsiTVTunerUpdateTVNormList(int[] nArray, int n) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("TargetTVTunerDSI#dsiTVTunerUpdateTVNormList called - validFlag is ").append(this.getValidity(n)).toString());
        }
        if (n == 1) {
            TVTunerObjectAccessor.getTvTunerSettings().updateTVNormAreasList(nArray);
            TVTunerObjectAccessor.getTargetTVTunerDSI().getDSITVTuner().setNotification(11, this.dsiTVTunerListener);
        }
    }

    public void dsiTVTunerUpdateTVNormAreaSubList(int[] nArray, int n) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("TargetTVTunerDSI#dsiTVTunerUpdateTVNormAreaSubList called - validFlag is ").append(this.getValidity(n)).toString());
        }
    }

    public void dsiTVTunerUpdateAVNorm(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("TargetTVTunerDSI#dsiTVTunerUpdateAVNorm called - validFlag is ").append(this.getValidity(n2)).toString());
        }
        if (n2 == 1) {
            TVTunerObjectAccessor.getTvTunerAVSettings().updateAVNorm(n);
        }
    }

    public void dsiTVTunerUpdateEWSInfoList(EWSInfo[] eWSInfoArray, int n) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("TargetTVTunerDSI#dsiTVTunerUpdateEWSInfoList called - validFlag is ").append(this.getValidity(n)).toString());
        }
        if (n == 1) {
            TVTunerObjectAccessor.getEWSHandler().updateEWSInfoList(eWSInfoArray);
        }
    }

    public void dsiTVTunerSelectService(int n) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("TargetTVTunerDSI#dsiTVTunerSelectService called - response =  ").append(this.getResponseResult(n)).toString());
        }
    }

    public void dsiTVTunerSelectNextService(int n) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("TargetTVTunerDSI#dsiTVTunerSelectNextService called - response =  ").append(this.getResponseResult(n)).toString());
        }
    }

    public void dsiTVTunerSwitchSource(int n) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("TargetTVTunerDSI#dsiTVTunerSwitchSource called - response =  ").append(this.getResponseResult(n)).toString());
        }
    }

    public void dsiTVTunerUpdateSubtitle(boolean bl, int n) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("TargetTVTunerDSI#dsiTVTunerUpdateSubtitle called - validFlag is ").append(this.getValidity(n)).toString());
        }
        if (n == 1) {
            TVTunerObjectAccessor.getTvTunerSettings().updateSubtitleState(bl);
        }
    }

    public void dsiTVTunerUpdateLogoList(LogoInfo[] logoInfoArray, int n) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("TargetTVTunerDSI#dsiTVTunerUpdateLogoList called - validFlag is ").append(this.getValidity(n)).toString());
        }
        if (n == 1) {
            TVTunerObjectAccessor.getLogoHandler().updateLogoList(logoInfoArray);
        }
    }

    public void dsiTVTunerUpdateCASInfo(boolean bl, String string, int n) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("TargetTVTunerDSI#dsiTVTunerUpdateCASInfo called - validFlag is ").append(this.getValidity(n)).toString());
        }
        if (n == 1) {
            TVTunerObjectAccessor.getTvTunerSettings().updateCASInfo(string, bl);
        }
    }

    public void dsiTVTunerUpdateTuneStatus(boolean bl, boolean bl2, boolean bl3, int n) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("TargetTVTunerDSI#dsiTVTunerUpdateTuneStatus called: tuneUp ").append(bl ? "enabled" : "disabled").append(", tuneDown ").append(bl2 ? "enabled" : "disabled").append(", tuneTo ").append(bl3 ? "enabled" : "disabled").append(" - validFlag is ").append(this.getValidity(n)).toString());
        }
        if (n == 1) {
            int n2 = 0;
            n2 = bl || bl2 ? 1 : 0;
            if (n2 != TVTunerObjectAccessor.getTuningHandler().getTuneUpDownState()) {
                if (this.isTraceEnabled()) {
                    this.trace(new StringBuffer().append("TargetTVTunerDSI#dsiTVTunerUpdateTuneStatus: Fire event that tune state has changed. New tune state: ").append(n2).toString());
                }
                ServiceManager.aslPropertyManager.valueChangedBoolean(4047, n2 == 1);
                this.sendHMIEvent(582);
                TVTunerObjectAccessor.getTuningHandler().setTuneUpDownState(n2);
            }
        }
    }

    public void dsiTVTunerUpdateMessageService(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("TargetTVTunerDSI#dsiTVTunerUpdateMessageService called - validFlag is ").append(this.getValidity(n2)).toString());
        }
        if (n2 == 1) {
            if (this.isTraceEnabled()) {
                this.trace(new StringBuffer().append("TargetTVTunerDSI#dsiTVTunerUpdateSleepingState - sleepingState is ").append(n == 1 ? "sleeping" : "ready").toString());
            }
            if (n == 1) {
                this.tunerWaitState = 0;
                ServiceManager.aslPropertyManager.valueChangedInteger(-1320409600, 0);
            } else {
                this.tunerWaitState = 1;
                ServiceManager.aslPropertyManager.valueChangedInteger(-1320409600, 1);
                if (TVTunerObjectAccessor.getResetParticipant().getResetState() == 1 || TVTunerObjectAccessor.getResetParticipant().getResetState() == 2) {
                    if (this.getTunerActiveState() == 1) {
                        TVTunerObjectAccessor.getTvTunerDB().getTvPersistable().updateTunerSettings(true);
                        TVTunerObjectAccessor.getResetParticipant().setResetState(0);
                    } else {
                        TVTunerObjectAccessor.getResetParticipant().setResetState(2);
                    }
                }
                TVTunerObjectAccessor.getTvTunerDB().getTvPersistable().markDirty(true);
            }
            TVTunerObjectAccessor.getTileDisclaimerHelper().checkDisclaimers();
        }
    }

    public int getTunerActiveState() {
        return this.tunerActiveState;
    }

    public void dsiTVTunerUpdateStartUpMUConfig(StartUpConfig startUpConfig, int n) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("TargetTVTunerDSI#dsiTVTunerUpdateStartUpMUConfig called - validFlag is ").append(this.getValidity(n)).toString());
        }
        if (n == 1) {
            TVTunerObjectAccessor.getStartUpConfigHandler().updateStartUpConfig(startUpConfig);
        }
    }

    public void dsiTVTunerUpdateTMTVKeyPanel(short s, short s2, int n) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("TargetTVTunerDSI#dsiTVTunerUpdateTMTVKeyPanel called - validFlag is ").append(this.getValidity(n)).toString());
        }
        if (n == 1 && s == 2 && s2 == 1 && TVTunerObjectAccessor.getTMHandler().getCurrentTerminalMode() == 12) {
            this.trace("TargetTVTunerDSI#dsiTVTunerUpdateTMTVKeyPanel called - leave bcas-disclaimer after green button was pressed");
            TVTunerObjectAccessor.getTMHandler().setTerminalMode(0);
        }
    }

    public void dsiTVTunerAbortSeek(int n) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("TargetTVTunerDSI#dsiTVTunerAbortSeek called - response = ").append(this.getResponseResult(n)).toString());
        }
    }

    public void dsiTVTunerUpdateBrowserListSort(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("TargetTVTunerDSI#dsiTVTunerupdateBrowserListSort called - validFlag is ").append(this.getValidity(n2)).toString());
        }
        if (n2 == 1) {
            TVTunerObjectAccessor.getTvTunerSettings().updateBrowserListSortState(n);
        }
    }

    private String getValidity(int n) {
        String string;
        switch (n) {
            case 2: {
                string = "invalid";
                break;
            }
            case 0: {
                string = "unknown";
                break;
            }
            case 1: {
                string = "valid";
                break;
            }
            default: {
                string = "unknown flag value";
            }
        }
        return string;
    }

    private String getResponseResult(int n) {
        String string;
        switch (n) {
            case 0: {
                string = "failure";
                break;
            }
            case 1: {
                string = "success";
                break;
            }
            default: {
                string = "unknown response result";
            }
        }
        return string;
    }

    public int getTunerWaitState() {
        return this.tunerWaitState;
    }

    public void setTunerWaitState(int n) {
        this.tunerWaitState = n;
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

