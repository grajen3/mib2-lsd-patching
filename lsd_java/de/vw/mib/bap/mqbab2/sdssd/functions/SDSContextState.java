/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.sdssd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.speech.SpeechService;
import de.vw.mib.bap.mqbab2.common.api.speech.SpeechServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.api.system.SystemService;
import de.vw.mib.bap.mqbab2.common.api.system.SystemServiceListener;
import de.vw.mib.bap.mqbab2.generated.sdssd.serializer.SDS_ContextState_Status;

public class SDSContextState
extends Function
implements Property,
SpeechServiceListener,
SystemServiceListener {
    protected final int BAP_STAGE_UPDATE_ID_TELEPROMPTER_DATA;
    protected final int STATE__IDLE;
    protected final int STATE__INFO_STATES__SHOW_POPUP;
    protected final int STATE__CONTEXT_CHANGE_STARTED;
    protected int internalState = 0;
    protected boolean waitForCommandListAck = false;
    protected boolean waitForResultListAck = false;
    protected boolean waitForSDSContextStateAck = false;
    protected int currentInfoState = 0;
    protected static final int[] SPEECH_LISTENER_IDS = new int[]{-352124800, -335347584};
    protected static final int[] SPEECH_LISTENER_HMI_EVENT_IDS = new int[]{352};
    protected static final int[] SYSTEM_LISTENER_IDS = new int[]{1632};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$sdssd$serializer$SDS_ContextState_Status;

    public SDSContextState() {
        this.BAP_STAGE_UPDATE_ID_TELEPROMPTER_DATA = 1;
        this.STATE__IDLE = 0;
        this.STATE__INFO_STATES__SHOW_POPUP = 1;
        this.STATE__CONTEXT_CHANGE_STARTED = 2;
    }

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getSpeechService().addSpeechServiceListener(this, SPEECH_LISTENER_IDS);
        this.getSpeechService().addHMIEventListener(this, SPEECH_LISTENER_HMI_EVENT_IDS);
        this.getSystemService().addSystemServiceListener(this, SYSTEM_LISTENER_IDS);
        return null;
    }

    protected SDS_ContextState_Status dequeueBAPEntity() {
        return (SDS_ContextState_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$sdssd$serializer$SDS_ContextState_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$sdssd$serializer$SDS_ContextState_Status = SDSContextState.class$("de.vw.mib.bap.mqbab2.generated.sdssd.serializer.SDS_ContextState_Status")) : class$de$vw$mib$bap$mqbab2$generated$sdssd$serializer$SDS_ContextState_Status);
    }

    private void updateNewInfoStates(int n) {
        this.currentInfoState = n;
    }

    private void receivedCommandListAcknowledgement() {
        if (this.internalState == 2) {
            this.waitForCommandListAck = false;
            if (!this.stillWaitForAcknowledgments()) {
                this.internalState = 0;
                if (this.getLogger().isTraceEnabled(1024)) {
                    this.getLogger().trace(1024).append("SDSContextState: All required Acknowledgements received").log();
                }
                this.process(-1);
            }
        }
    }

    private void receivedResultListAcknowledgement() {
        if (this.internalState == 2) {
            this.waitForResultListAck = false;
            if (!this.stillWaitForAcknowledgments()) {
                this.internalState = 0;
                if (this.getLogger().isTraceEnabled(1024)) {
                    this.getLogger().trace(1024).append("SDSContextState: All required Acknowledgements received").log();
                }
                this.process(-1);
            }
        }
    }

    private void receivedSDSContextStateAcknowledgement() {
        if (this.internalState == 2) {
            this.waitForSDSContextStateAck = false;
            this.changeBlockStatusCommandAndResultList(Boolean.FALSE);
            if (!this.stillWaitForAcknowledgments()) {
                this.internalState = 0;
                if (this.getLogger().isTraceEnabled(1024)) {
                    this.getLogger().trace(1024).append("SDSContextState: All required Acknowledgements received").log();
                }
                this.process(-1);
            }
        }
    }

    private void changeBlockStatusCommandAndResultList(Boolean bl) {
        int[] nArray = new int[]{18, 19};
        if (this.getLogger().isTraceEnabled(1024)) {
            this.getLogger().trace(1024).append("SDSContextState: isBlocked: ").append(bl).log();
        }
        this.context.updateStages(this, nArray, bl);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
        switch (bAPStage.getFunctionId()) {
            case 20: {
                this.updateNewInfoStates((Integer)object);
                break;
            }
            case 18: {
                if ((Integer)object != 1) break;
                if (this.getLogger().isTraceEnabled(1024)) {
                    this.getLogger().trace(1024).append("SDSContextState: Received CommandList Acknowledgement").log();
                }
                this.receivedCommandListAcknowledgement();
                break;
            }
            case 19: {
                if ((Integer)object != 1) break;
                if (this.getLogger().isTraceEnabled(1024)) {
                    this.getLogger().trace(1024).append("SDSContextState: Received ResultList Acknowledgement").log();
                }
                this.receivedResultListAcknowledgement();
                break;
            }
        }
    }

    @Override
    public int getFunctionId() {
        return 17;
    }

    private void pttPressed() {
        switch (this.currentInfoState) {
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                if (this.internalState == 1 || this.isSDSinKombiDeactivated()) break;
                SDS_ContextState_Status sDS_ContextState_Status = this.dequeueBAPEntity();
                this.setPopupIndicatorStatus(sDS_ContextState_Status);
                if (!this.getDelegate().getPropertyListener(this).statusProperty(sDS_ContextState_Status, this)) break;
                this.internalState = 1;
                break;
            }
        }
    }

    private boolean stillWaitForAcknowledgments() {
        return this.waitForCommandListAck || this.waitForResultListAck || this.waitForSDSContextStateAck;
    }

    private void setWaitingForAcknowledgments() {
        this.waitForSDSContextStateAck = true;
        this.waitForCommandListAck = true;
        if (this.getSpeechService().isHeadlineDynamic()) {
            this.waitForResultListAck = true;
            if (this.getLogger().isTraceEnabled(1024)) {
                this.getLogger().trace(1024).append("SDSContextState: Wait for SDSContextState, CommandList and ResultList Acknowledgements").log();
            }
        } else {
            this.waitForResultListAck = false;
            if (this.getLogger().isTraceEnabled(1024)) {
                this.getLogger().trace(1024).append("SDSContextState: Wait for SDSContextState and CommandList Acknowledgement").log();
            }
        }
    }

    @Override
    public void requestAcknowledge() {
        if (this.internalState == 2) {
            if (this.getLogger().isTraceEnabled(1024)) {
                this.getLogger().trace(1024).append("SDSContextState: Received SDSContextState Acknowledgement").log();
            }
            this.receivedSDSContextStateAcknowledgement();
        } else if (this.internalState == 1) {
            this.internalState = 0;
            this.process(-1);
        }
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void initialize(boolean bl) {
        this.internalState = 0;
        this.waitForCommandListAck = false;
        this.waitForResultListAck = false;
        this.waitForSDSContextStateAck = false;
    }

    @Override
    public void uninitialize() {
        this.getSpeechService().removeSpeechServiceListener(this, SPEECH_LISTENER_IDS);
        this.getSpeechService().removeHMIEventListener(this, SPEECH_LISTENER_HMI_EVENT_IDS);
        this.getSystemService().removeSystemServiceListener(this, SYSTEM_LISTENER_IDS);
        this.internalState = 0;
        this.waitForCommandListAck = false;
        this.waitForResultListAck = false;
        this.waitForSDSContextStateAck = false;
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        SDS_ContextState_Status sDS_ContextState_Status;
        if (!this.getSpeechService().isSdsSdInMenuActive() || this.getSystemService().getSystemOnOffState() == 0 || this.getSystemService().getSystemOnOffState() == 1) {
            sDS_ContextState_Status = this.dequeueBAPEntity();
        } else if (this.internalState == 1) {
            sDS_ContextState_Status = this.dequeueBAPEntity();
            this.setPopupIndicatorStatus(sDS_ContextState_Status);
        } else {
            sDS_ContextState_Status = this.internalState == 2 ? this.computeLoadingStatus() : this.computeSDSContextState();
        }
        propertyListener.statusProperty(sDS_ContextState_Status, this);
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
    }

    private boolean isSDSinKombiDeactivated() {
        return !this.getSpeechService().isSdsSdInMenuActive() || this.getSystemService().getSystemOnOffState() == 0 || this.getSystemService().getSystemOnOffState() == 1;
    }

    @Override
    public void process(int n) {
        if (this.isSDSinKombiDeactivated()) {
            if (this.getLogger().isTraceEnabled(1024)) {
                this.getLogger().trace(1024).append("SDSContextState: Menu option is disabled or system is OFF. Send only default values.").log();
            }
            this.sendSDSContextStateStatus(this.dequeueBAPEntity());
            return;
        }
        if (n == 1) {
            if (this.getLogger().isTraceEnabled(1024)) {
                this.getLogger().trace(1024).append("SDSContextState: TeleprompterData changed.").log();
            }
            if (this.getSpeechService().getTeleprompterType() != 1) {
                if (this.getLogger().isTraceEnabled(1024)) {
                    this.getLogger().trace(1024).append("SDSContextState: Context change started.").log();
                }
                this.internalState = 2;
                SDS_ContextState_Status sDS_ContextState_Status = this.computeLoadingStatus();
                this.changeBlockStatusCommandAndResultList(Boolean.TRUE);
                this.setWaitingForAcknowledgments();
                this.sendSDSContextStateStatus(sDS_ContextState_Status);
            } else {
                if (this.getLogger().isTraceEnabled(1024)) {
                    this.getLogger().trace(1024).append("SDSContextState: Teleprompter is in state not active.").log();
                }
                this.internalState = 0;
                this.sendSDSContextStateStatus(this.computeSDSContextState());
            }
        } else if (this.internalState != 2) {
            this.sendSDSContextStateStatus(this.computeSDSContextState());
        }
    }

    private static int computeBapContextState(SpeechService speechService) {
        int n;
        switch (speechService.getTeleprompterType()) {
            case 2: {
                n = 1;
                break;
            }
            case 5: {
                n = 4;
                break;
            }
            case 3: {
                n = 2;
                break;
            }
            case 4: {
                n = 3;
                break;
            }
            default: {
                n = 0;
            }
        }
        return n;
    }

    private SDS_ContextState_Status computeSDSContextState() {
        SpeechService speechService = this.getSpeechService();
        SDS_ContextState_Status sDS_ContextState_Status = this.dequeueBAPEntity();
        sDS_ContextState_Status.sds_ContextState = SDSContextState.computeBapContextState(speechService);
        sDS_ContextState_Status.attributes.stateIsBeingLoaded = false;
        if (speechService.isHeadlineDynamic()) {
            sDS_ContextState_Status.additionalInfo.additionalInfoType = 0;
            sDS_ContextState_Status.additionalInfo.additionalText.setContent("");
        } else {
            sDS_ContextState_Status.additionalInfo.additionalInfoType = -65536;
            sDS_ContextState_Status.additionalInfo.additionalText.setContent(speechService.getHeadline());
        }
        return sDS_ContextState_Status;
    }

    private SDS_ContextState_Status computeLoadingStatus() {
        SDS_ContextState_Status sDS_ContextState_Status = this.dequeueBAPEntity();
        sDS_ContextState_Status.sds_ContextState = SDSContextState.computeBapContextState(this.getSpeechService());
        sDS_ContextState_Status.attributes.stateIsBeingLoaded = true;
        return sDS_ContextState_Status;
    }

    private SDS_ContextState_Status setPopupIndicatorStatus(SDS_ContextState_Status sDS_ContextState_Status) {
        sDS_ContextState_Status.sds_ContextState = 1;
        sDS_ContextState_Status.sds_ContextType = 0;
        sDS_ContextState_Status.attributes.stateIsBeingLoaded = false;
        sDS_ContextState_Status.additionalInfo.additionalInfoType = 0;
        sDS_ContextState_Status.additionalInfo.additionalText.setContent("");
        return sDS_ContextState_Status;
    }

    private void sendSDSContextStateStatus(SDS_ContextState_Status sDS_ContextState_Status) {
        if (!this.getDelegate().getPropertyListener(this).statusProperty(sDS_ContextState_Status, this)) {
            if (this.getLogger().isTraceEnabled(1024)) {
                this.getLogger().trace(1024).append("SDSContextState: Status message was NOT send, because of no change to previous message.").log();
            }
            this.waitForSDSContextStateAck = false;
        } else if (this.getLogger().isTraceEnabled(1024)) {
            this.getLogger().trace(1024).append("SDSContextState: Status message was send.").log();
        }
    }

    @Override
    public void processHMIEvent(int n) {
        if (n == 352) {
            this.pttPressed();
        }
    }

    @Override
    public void updateSpeechData(SpeechService speechService, int n) {
        if (n == -352124800) {
            this.process(1);
        } else {
            this.process(-1);
        }
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
}

