/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneService;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.MobileServiceSupport_Status;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;

public final class MobileServiceSupport
extends Function
implements Property,
ASLTelephoneConstants,
PhoneServiceListener {
    private static final int MAX_NUMBER_OF_CALLS_TO_SUPPORT_RINGTONE_MUTE;
    protected static final int[] PHONE_LISTENER_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MobileServiceSupport_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getPhoneService().addPhoneServiceListener(this, PHONE_LISTENER_IDS);
        return this.computeMobileServiceSupportStatus();
    }

    protected MobileServiceSupport_Status dequeueBAPEntity() {
        return (MobileServiceSupport_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MobileServiceSupport_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MobileServiceSupport_Status = MobileServiceSupport.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.MobileServiceSupport_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MobileServiceSupport_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 16;
    }

    private void setMobileServiceSupportStatusData(MobileServiceSupport_Status mobileServiceSupport_Status) {
        PhoneService phoneService = this.getPhoneService();
        boolean bl = phoneService.getCurrentPhoneProfile() == 2;
        boolean bl2 = bl && phoneService.isPhoneCallActive();
        mobileServiceSupport_Status.fctList.fctActiveUserSupported = true;
        mobileServiceSupport_Status.fctList.fctRegisterStateSupported = true;
        mobileServiceSupport_Status.fctList.fctLockStateSupported = true;
        mobileServiceSupport_Status.fctList.fctNetworkProviderSupported = true;
        mobileServiceSupport_Status.fctList.fctSignalQualitySupported = phoneService.isSignalStrengthAvailable();
        mobileServiceSupport_Status.fctList.fctCallStateSupported = true;
        mobileServiceSupport_Status.fctList.fctCallInfoSupported = true;
        mobileServiceSupport_Status.fctList.fctCallDurationSyncSupported = true;
        mobileServiceSupport_Status.fctList.fctDisconnectReasonSupported = true;
        mobileServiceSupport_Status.fctList.fctDialNumberSupported = true;
        mobileServiceSupport_Status.fctList.fctDialServiceSupported = true;
        mobileServiceSupport_Status.fctList.fctConfirmEmergencyCallSupported = true;
        mobileServiceSupport_Status.fctList.fctHangupCallSupported = true;
        mobileServiceSupport_Status.fctList.fctAcceptCallSupported = true;
        mobileServiceSupport_Status.fctList.fctCallHoldSupported = true;
        mobileServiceSupport_Status.fctList.fctResumeCallSupported = true;
        mobileServiceSupport_Status.fctList.fctHandsFreeOnOffSupported = bl2;
        mobileServiceSupport_Status.fctList.fctMicroMuteOnOffSupported = phoneService.isHandsfreeAudioEnabled();
        mobileServiceSupport_Status.fctList.fctMpreleaseActiveCallAcceptWaitingCallSupported = true;
        mobileServiceSupport_Status.fctList.fctMpswapSupported = true;
        mobileServiceSupport_Status.fctList.fctMpcallHoldAcceptWaitingCallSupported = true;
        mobileServiceSupport_Status.fctList.fctMpreleaseAllCallsAcceptWaitingCallSupported = true;
        mobileServiceSupport_Status.fctList.fctMpsetWaitingCallOnHoldSupported = true;
        mobileServiceSupport_Status.fctList.fctCcjoinSupported = true;
        mobileServiceSupport_Status.fctList.fctCcsplitSupported = true;
        mobileServiceSupport_Status.fctList.fctMobileBatteryLevelSupported = true;
        mobileServiceSupport_Status.fctList.fctDataConnectionIndicationSupported = true;
        mobileServiceSupport_Status.fctList.fctMissedCallIndicationSupported = true;
        mobileServiceSupport_Status.fctList.fctMissedCallsSupported = true;
        mobileServiceSupport_Status.fctList.fctReceivedCallsSupported = true;
        mobileServiceSupport_Status.fctList.fctDialedNumbersSupported = true;
        mobileServiceSupport_Status.fctList.fctCombinedNumbersSupported = true;
        mobileServiceSupport_Status.fctList.fctCallStackDeleteAllSupported = true;
        mobileServiceSupport_Status.fctList.fctPbStateSupported = true;
        mobileServiceSupport_Status.fctList.fctPhonebookSupported = true;
        mobileServiceSupport_Status.fctList.fctPbSpellerSupported = true;
        mobileServiceSupport_Status.fctList.fctGetNextListPosSupported = true;
        mobileServiceSupport_Status.fctList.fctSmsstateSupported = true;
        mobileServiceSupport_Status.fctList.fctRingToneMuteOnOffSupported = phoneService.getCurrentPhoneCallCount() <= 1;
        mobileServiceSupport_Status.fctList.fctAutomaticRedialSupported = true;
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
        this.getPhoneService().removePhoneServiceListener(this, PHONE_LISTENER_IDS);
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
    public void processHMIEvent(int n) {
    }

    @Override
    public void updatePhoneData(PhoneService phoneService, int n) {
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
        PHONE_LISTENER_IDS = new int[]{1238, 1148, 1155, 1118, 1097};
    }
}

