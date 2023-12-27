/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Method;
import de.vw.mib.bap.functions.MethodListener;
import de.vw.mib.bap.mqbab2.audiosd.api.ASLAudioSDConstants;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioService;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioServiceListener;
import de.vw.mib.bap.mqbab2.common.api.sound.SoundService;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.api.system.SystemService;
import de.vw.mib.bap.mqbab2.common.api.system.SystemServiceListener;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListComplete;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.SourceList_Data;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.SwitchSource_Result;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.SwitchSource_StartResult;

public class SwitchSource
extends Function
implements TimerNotifier,
Method,
ASLAudioSDConstants,
SystemServiceListener,
RadioServiceListener {
    private FsgArrayListComplete fullSourceList = null;
    private boolean switchingSourceRunning = false;
    private int switchingToSourceListReference = 0;
    private int switchingFromSourceListReference;
    private int activeSourceListReference = 0;
    private int requestedSourceListReference = 0;
    private static final int INVALID_SOURCELIST_REFERENCE;
    private Timer timer = null;
    private static final int TIMER_UPDATE_TIME;
    private static final int TIMER_ACTION_TIME_OUT_ACTION_FAILED;
    protected static final int[] SYSTEM_LISTENER_IDS;
    protected static final int[] RADIO_LISTENER_HMI_EVENT_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$SwitchSource_Result;
    static /* synthetic */ Class class$java$lang$Long;
    static /* synthetic */ Class class$java$lang$Integer;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getSystemService().addSystemServiceListener(this, SYSTEM_LISTENER_IDS);
        this.getRadioService().addHMIEventListener(this, RADIO_LISTENER_HMI_EVENT_IDS);
        this.timer = this.getTimerService().createTimer(this, 10000);
        return null;
    }

    protected SwitchSource_Result dequeueBAPEntity() {
        return (SwitchSource_Result)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$SwitchSource_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$SwitchSource_Result = SwitchSource.class$("de.vw.mib.bap.mqbab2.generated.audiosd.serializer.SwitchSource_Result")) : class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$SwitchSource_Result);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
        switch (bAPStage.getFunctionId()) {
            case 32: {
                this.setFullSourceList((FsgArrayListComplete)object);
                break;
            }
            case 16: {
                if (object.getClass() == (class$java$lang$Long == null ? (class$java$lang$Long = SwitchSource.class$("java.lang.Long")) : class$java$lang$Long)) {
                    this.setActiveSourceListReference((Long)object);
                    break;
                }
                if (object.getClass() != (class$java$lang$Integer == null ? (class$java$lang$Integer = SwitchSource.class$("java.lang.Integer")) : class$java$lang$Integer)) break;
                this.setReportedSourceListReference((Integer)object);
                break;
            }
            case 38: {
                this.setActivateBapPosId((Integer)object);
                break;
            }
        }
    }

    @Override
    public int getFunctionId() {
        return 34;
    }

    private SourceList_Data findSourceListData(int n) {
        return this.fullSourceList != null ? (SourceList_Data)this.fullSourceList.getElement(n) : null;
    }

    private void activateRadioBand(int n) {
        this.getRadioService().activateBand(n);
        SoundService soundService = this.getSoundService();
        if (soundService.getCurrentAudioComponent() != 1) {
            soundService.setCurrentAudioComponent(1);
        }
    }

    private int performSwitchSource(SourceList_Data sourceList_Data, int n) {
        switch (sourceList_Data.sourceType) {
            case 2: {
                this.activateRadioBand(0);
                break;
            }
            case 1: {
                this.activateRadioBand(1);
                break;
            }
            case 3: {
                this.activateRadioBand(2);
                break;
            }
            case 4: 
            case 5: {
                this.activateRadioBand(3);
                break;
            }
            case 12: {
                this.getRadioService().setTpMemoScreenEntered();
                break;
            }
            case 9: {
                this.getSoundService().setCurrentAudioComponent(5);
                break;
            }
            case 6: 
            case 7: 
            case 8: 
            case 10: 
            case 11: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 18: 
            case 19: 
            case 21: 
            case 22: 
            case 29: {
                this.getMediaService().activateAudioSourceByID(n);
                break;
            }
            default: {
                return 1;
            }
        }
        return 0;
    }

    private void checkSendResultOfAction() {
        if (this.switchingSourceRunning) {
            if (this.activeSourceListReference == this.switchingToSourceListReference) {
                this.switchingSourceRunning = false;
                this.switchingToSourceListReference = 0;
                this.switchingFromSourceListReference = 0;
                this.sendResult(0);
            } else if (this.activeSourceListReference != this.switchingFromSourceListReference) {
                this.switchingSourceRunning = false;
                this.switchingToSourceListReference = 0;
                this.switchingFromSourceListReference = 0;
                this.sendResult(1);
            }
        }
    }

    @Override
    public void abortResult(BAPEntity bAPEntity, MethodListener methodListener) {
        if (!this.switchingSourceRunning) {
            methodListener.requestError(80, this);
        } else {
            this.switchingSourceRunning = false;
            this.switchingToSourceListReference = 0;
            this.switchingFromSourceListReference = 0;
            this.sendResult(methodListener, 2);
        }
    }

    @Override
    public void startResult(BAPEntity bAPEntity, MethodListener methodListener) {
        int n = 0;
        if (!this.switchingSourceRunning) {
            SwitchSource_StartResult switchSource_StartResult = (SwitchSource_StartResult)bAPEntity;
            SourceList_Data sourceList_Data = this.findSourceListData(switchSource_StartResult.sourceList_Reference);
            if (sourceList_Data != null && this.canPerformSwitchSource(sourceList_Data)) {
                if (this.activeSourceListReference != sourceList_Data.getPos()) {
                    n = this.performSwitchSource(sourceList_Data, (int)this.fullSourceList.getInternalUserId(switchSource_StartResult.sourceList_Reference));
                    if (n == 0) {
                        this.switchingSourceRunning = true;
                        this.switchingToSourceListReference = sourceList_Data.getPos();
                        this.switchingFromSourceListReference = this.activeSourceListReference;
                        this.timer.retrigger(new Integer(0));
                    }
                } else {
                    n = 0;
                    this.sendResult(n);
                }
            } else {
                n = 1;
            }
        } else {
            n = 1;
        }
        if (n != 0) {
            this.sendResult(n);
        }
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void requestAcknowledge() {
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void initialize(boolean bl) {
        this.switchingSourceRunning = false;
        this.switchingToSourceListReference = 0;
        this.switchingFromSourceListReference = 0;
    }

    @Override
    public void uninitialize() {
        this.timer.stop();
        this.getSystemService().removeSystemServiceListener(this, SYSTEM_LISTENER_IDS);
        this.getRadioService().removeHMIEventListener(this, RADIO_LISTENER_HMI_EVENT_IDS);
    }

    @Override
    public void process(int n) {
        this.checkSendResultOfAction();
    }

    private void sendResult(int n) {
        SwitchSource_Result switchSource_Result = this.dequeueBAPEntity();
        switchSource_Result.switchSourceResult = n;
        this.getDelegate().getMethodListener(this).result(switchSource_Result, this);
    }

    private void sendResult(MethodListener methodListener, int n) {
        SwitchSource_Result switchSource_Result = this.dequeueBAPEntity();
        switchSource_Result.switchSourceResult = n;
        methodListener.result(switchSource_Result, this);
    }

    private boolean canPerformSwitchSource(SourceList_Data sourceList_Data) {
        return sourceList_Data != null && sourceList_Data.attributes.builtInAndReadyMediumInserted && sourceList_Data.attributes.mediumIsReadable && sourceList_Data.attributes.mediaIsPlayable;
    }

    protected void setActiveSourceListReference(Long l) {
        if (!this.switchingSourceRunning) {
            this.requestedSourceListReference = this.activeSourceListReference = l.intValue();
        }
    }

    protected void setReportedSourceListReference(Integer n) {
        this.requestedSourceListReference = this.activeSourceListReference = n.intValue();
        this.process(-1);
    }

    protected void setFullSourceList(FsgArrayListComplete fsgArrayListComplete) {
        this.fullSourceList = fsgArrayListComplete;
    }

    protected void setActivateBapPosId(Integer n) {
        int n2 = n;
        SourceList_Data sourceList_Data = this.findSourceListData(n2);
        if (this.canPerformSwitchSource(sourceList_Data)) {
            this.performSwitchSource(sourceList_Data, (int)this.fullSourceList.getInternalUserId(n2));
            this.requestedSourceListReference = n2;
        }
    }

    @Override
    public void timerFired(Timer timer) {
        if (this.switchingSourceRunning) {
            this.switchingSourceRunning = false;
            this.switchingToSourceListReference = 0;
            this.switchingFromSourceListReference = 0;
            this.sendResult(1);
        }
    }

    protected void nextAudioSource() {
        SourceList_Data sourceList_Data;
        int n = this.requestedSourceListReference;
        do {
            if ((n = this.fullSourceList.nextBapPosID(n)) != 0) continue;
            n = this.fullSourceList.firstBAPPosID();
        } while (!this.canPerformSwitchSource(sourceList_Data = this.findSourceListData(n)));
        this.performSwitchSource(sourceList_Data, (int)this.fullSourceList.getInternalUserId(n));
        this.requestedSourceListReference = n;
    }

    protected void nextAudioComponentFromMedia() {
        if (this.getConfigurationService().isTvFeatureSelected()) {
            this.getSoundService().activateTvSource();
        } else {
            this.getSoundService().activateRadioSource();
        }
    }

    protected void nextAudioComponent() {
        SoundService soundService = this.getSoundService();
        int n = soundService.getCurrentAudioComponent();
        switch (n) {
            case 1: {
                this.getSoundService().activateMediaSource();
                break;
            }
            case 2: {
                this.nextAudioComponentFromMedia();
                break;
            }
            case 5: {
                soundService.activateRadioSource();
                break;
            }
            default: {
                soundService.activateRadioSource();
            }
        }
    }

    @Override
    public void processHMIEvent(int n) {
        switch (n) {
            case 203: {
                this.nextAudioSource();
                break;
            }
            case 204: {
                this.nextAudioComponent();
                break;
            }
        }
    }

    @Override
    public void updateRadioData(RadioService radioService, int n) {
        this.process(-1);
    }

    @Override
    public void updateSystemData(SystemService systemService, int n) {
        this.process(-1);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        SYSTEM_LISTENER_IDS = new int[]{335};
        RADIO_LISTENER_HMI_EVENT_IDS = new int[]{203, 204};
    }
}

