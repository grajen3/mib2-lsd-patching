/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.functions.carplay;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.carplay.CarPlayService;
import de.vw.mib.bap.mqbab2.common.api.carplay.CarPlayServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.MobileServiceSupport_Status;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;

public final class MobileServiceSupportCarPlay
extends Function
implements Property,
ASLTelephoneConstants,
CarPlayServiceListener {
    protected static final int[] CAR_PLAY_LISTENER_IDS = new int[]{1092550784};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MobileServiceSupport_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getCarPlayService().addCarPlayServiceListener(this, CAR_PLAY_LISTENER_IDS);
        return this.computeMobileServiceSupportStatus();
    }

    protected MobileServiceSupport_Status dequeueBAPEntity() {
        return (MobileServiceSupport_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MobileServiceSupport_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MobileServiceSupport_Status = MobileServiceSupportCarPlay.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.MobileServiceSupport_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MobileServiceSupport_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 16;
    }

    private void setMobileServiceSupportStatusData(MobileServiceSupport_Status mobileServiceSupport_Status) {
        mobileServiceSupport_Status.fctList.fctActiveUserSupported = true;
        mobileServiceSupport_Status.fctList.fctRegisterStateSupported = true;
        mobileServiceSupport_Status.fctList.fctLockStateSupported = false;
        mobileServiceSupport_Status.fctList.fctNetworkProviderSupported = true;
        mobileServiceSupport_Status.fctList.fctSignalQualitySupported = true;
        mobileServiceSupport_Status.fctList.fctCallStateSupported = true;
        mobileServiceSupport_Status.fctList.fctCallInfoSupported = true;
        mobileServiceSupport_Status.fctList.fctCallDurationSyncSupported = false;
        mobileServiceSupport_Status.fctList.fctDisconnectReasonSupported = false;
        mobileServiceSupport_Status.fctList.fctDialNumberSupported = false;
        mobileServiceSupport_Status.fctList.fctDialServiceSupported = false;
        mobileServiceSupport_Status.fctList.fctConfirmEmergencyCallSupported = false;
        mobileServiceSupport_Status.fctList.fctHangupCallSupported = true;
        mobileServiceSupport_Status.fctList.fctAcceptCallSupported = true;
        mobileServiceSupport_Status.fctList.fctCallHoldSupported = false;
        mobileServiceSupport_Status.fctList.fctResumeCallSupported = false;
        mobileServiceSupport_Status.fctList.fctHandsFreeOnOffSupported = false;
        mobileServiceSupport_Status.fctList.fctMicroMuteOnOffSupported = false;
        mobileServiceSupport_Status.fctList.fctMpreleaseActiveCallAcceptWaitingCallSupported = false;
        mobileServiceSupport_Status.fctList.fctMpswapSupported = false;
        mobileServiceSupport_Status.fctList.fctMpcallHoldAcceptWaitingCallSupported = false;
        mobileServiceSupport_Status.fctList.fctMpreleaseAllCallsAcceptWaitingCallSupported = false;
        mobileServiceSupport_Status.fctList.fctMpsetWaitingCallOnHoldSupported = false;
        mobileServiceSupport_Status.fctList.fctCcjoinSupported = false;
        mobileServiceSupport_Status.fctList.fctCcsplitSupported = false;
        mobileServiceSupport_Status.fctList.fctKeypadSupported = false;
        mobileServiceSupport_Status.fctList.fctMobileBatteryLevelSupported = false;
        mobileServiceSupport_Status.fctList.fctDataConnectionIndicationSupported = false;
        mobileServiceSupport_Status.fctList.fctMissedCallIndicationSupported = false;
        mobileServiceSupport_Status.fctList.fctMissedCallsSupported = false;
        mobileServiceSupport_Status.fctList.fctReceivedCallsSupported = false;
        mobileServiceSupport_Status.fctList.fctDialedNumbersSupported = false;
        mobileServiceSupport_Status.fctList.fctCombinedNumbersSupported = false;
        mobileServiceSupport_Status.fctList.fctCallStackDeleteAllSupported = false;
        mobileServiceSupport_Status.fctList.fctPbStateSupported = false;
        mobileServiceSupport_Status.fctList.fctPhonebookSupported = false;
        mobileServiceSupport_Status.fctList.fctPbSpellerSupported = false;
        mobileServiceSupport_Status.fctList.fctGetNextListPosSupported = false;
        mobileServiceSupport_Status.fctList.fctSmsstateSupported = false;
        mobileServiceSupport_Status.fctList.fctRingToneMuteOnOffSupported = false;
        mobileServiceSupport_Status.fctList.fctAutomaticRedialSupported = false;
    }

    private void sendMobileServiceSupport(MobileServiceSupport_Status mobileServiceSupport_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(mobileServiceSupport_Status, this);
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(128, this);
    }

    @Override
    public void requestAcknowledge() {
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.getCarPlayService().removeCarPlayServiceListener(this, CAR_PLAY_LISTENER_IDS);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(128, this);
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void process(int n) {
        this.sendMobileServiceSupport(this.computeMobileServiceSupportStatus());
    }

    private MobileServiceSupport_Status computeMobileServiceSupportStatus() {
        MobileServiceSupport_Status mobileServiceSupport_Status = this.dequeueBAPEntity();
        this.setMobileServiceSupportStatusData(mobileServiceSupport_Status);
        return mobileServiceSupport_Status;
    }

    @Override
    public void updateCarPlayData(CarPlayService carPlayService, int n) {
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

