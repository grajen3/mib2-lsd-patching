/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.functions.carplay;

import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.telephone.functions.GenericEmptyArray;
import de.vw.mib.bap.mqbab2.telephone.functions.GenericNotSuccessfullMethod;
import de.vw.mib.bap.mqbab2.telephone.functions.MissedCallIndication;
import de.vw.mib.bap.mqbab2.telephone.functions.TelephoneBindingFactoryAll;
import de.vw.mib.bap.mqbab2.telephone.functions.carplay.AcceptCallCarPlay;
import de.vw.mib.bap.mqbab2.telephone.functions.carplay.ActiveUserCarPlay;
import de.vw.mib.bap.mqbab2.telephone.functions.carplay.CallInfoCarPlay;
import de.vw.mib.bap.mqbab2.telephone.functions.carplay.CallStateCarPlay;
import de.vw.mib.bap.mqbab2.telephone.functions.carplay.FSGOperationStateHandlingCarPlay;
import de.vw.mib.bap.mqbab2.telephone.functions.carplay.FSGSetupCarPlay;
import de.vw.mib.bap.mqbab2.telephone.functions.carplay.HangupCallCarPlay;
import de.vw.mib.bap.mqbab2.telephone.functions.carplay.MobileServiceSupportCarPlay;
import de.vw.mib.bap.mqbab2.telephone.functions.carplay.NetworkProviderCarPlay;
import de.vw.mib.bap.mqbab2.telephone.functions.carplay.RegisterStateCarPlay;
import de.vw.mib.bap.mqbab2.telephone.functions.carplay.SignalQualityCarPlay;

public class TelephoneBindingFactoryCarPlay
extends TelephoneBindingFactoryAll {
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$DialNumber_Result;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$DialService_Result;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CallHold_Result;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$ResumeCall_Result;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MPRelActiveCallAcceptWC_Result;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MPCallHoldAcceptWC_Result;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MPRelAllCallsAcceptWC_Result;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MPSetWaitingCallOnHold_Result;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CCJoin_Result;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CCSplit_Result;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MissedCalls_StatusArray;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$telephone$functions$ReceivedCalls;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$DialedNumbers_StatusArray;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CombinedNumbers_StatusArray;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$Phonebook_StatusArray;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$FavoriteDest_List_StatusArray;

    @Override
    public BAPStage createNewFSGSetupStage() {
        return new FSGSetupCarPlay();
    }

    @Override
    public BAPStage createNewFSGOperationStateStage() {
        return new FSGOperationStateHandlingCarPlay();
    }

    @Override
    public BAPStage createNewMobileServiceSupportStage() {
        return new MobileServiceSupportCarPlay();
    }

    @Override
    public BAPStage createNewActiveUserStage() {
        return new ActiveUserCarPlay();
    }

    @Override
    public BAPStage createNewRegisterStateStage() {
        return new RegisterStateCarPlay();
    }

    @Override
    public BAPStage createNewLockStateStage() {
        return null;
    }

    @Override
    public BAPStage createNewNetworkProviderStage() {
        return new NetworkProviderCarPlay();
    }

    @Override
    public BAPStage createNewSignalQualityStage() {
        return new SignalQualityCarPlay();
    }

    @Override
    public BAPStage createNewCallStateStage() {
        return new CallStateCarPlay();
    }

    @Override
    public BAPStage createNewCallInfoStage() {
        return new CallInfoCarPlay();
    }

    @Override
    public BAPStage createNewCallDurationSyncStage() {
        return null;
    }

    @Override
    public BAPStage createNewDisconnectReasonStage() {
        return null;
    }

    @Override
    public BAPStage createNewDialNumberStage() {
        return new GenericNotSuccessfullMethod(26, 0, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$DialNumber_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$DialNumber_Result = TelephoneBindingFactoryCarPlay.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.DialNumber_Result")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$DialNumber_Result);
    }

    @Override
    public BAPStage createNewDialServiceStage() {
        return new GenericNotSuccessfullMethod(27, 1, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$DialService_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$DialService_Result = TelephoneBindingFactoryCarPlay.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.DialService_Result")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$DialService_Result);
    }

    @Override
    public BAPStage createNewConfirmEmergencyCallStage() {
        return null;
    }

    @Override
    public BAPStage createNewHangupCallStage() {
        return new HangupCallCarPlay();
    }

    @Override
    public BAPStage createNewAcceptCallStage() {
        return new AcceptCallCarPlay();
    }

    @Override
    public BAPStage createNewCallHoldStage() {
        return new GenericNotSuccessfullMethod(31, 1, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CallHold_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CallHold_Result = TelephoneBindingFactoryCarPlay.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallHold_Result")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CallHold_Result);
    }

    @Override
    public BAPStage createNewResumeCallStage() {
        return new GenericNotSuccessfullMethod(32, 1, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$ResumeCall_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$ResumeCall_Result = TelephoneBindingFactoryCarPlay.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.ResumeCall_Result")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$ResumeCall_Result);
    }

    @Override
    public BAPStage createNewHandsFreeOnOffStage() {
        return null;
    }

    @Override
    public BAPStage createNewMicroMuteOnOffStage() {
        return null;
    }

    @Override
    public BAPStage createNewMPReleaseActiveCallAccpetWaitingCallStage() {
        return new GenericNotSuccessfullMethod(35, 1, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MPRelActiveCallAcceptWC_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MPRelActiveCallAcceptWC_Result = TelephoneBindingFactoryCarPlay.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.MPRelActiveCallAcceptWC_Result")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MPRelActiveCallAcceptWC_Result);
    }

    @Override
    public BAPStage createNewMPSwapStage() {
        return null;
    }

    @Override
    public BAPStage createNewMPCallHoldAcceptWaitingCallStage() {
        return new GenericNotSuccessfullMethod(37, 1, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MPCallHoldAcceptWC_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MPCallHoldAcceptWC_Result = TelephoneBindingFactoryCarPlay.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.MPCallHoldAcceptWC_Result")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MPCallHoldAcceptWC_Result);
    }

    @Override
    public BAPStage createNewMPReleaseAllCallsAcceptWaitingCallStage() {
        return new GenericNotSuccessfullMethod(38, 1, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MPRelAllCallsAcceptWC_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MPRelAllCallsAcceptWC_Result = TelephoneBindingFactoryCarPlay.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.MPRelAllCallsAcceptWC_Result")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MPRelAllCallsAcceptWC_Result);
    }

    @Override
    public BAPStage createNewMPSetWaitingCallOnHoldStage() {
        return new GenericNotSuccessfullMethod(39, 1, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MPSetWaitingCallOnHold_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MPSetWaitingCallOnHold_Result = TelephoneBindingFactoryCarPlay.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.MPSetWaitingCallOnHold_Result")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MPSetWaitingCallOnHold_Result);
    }

    @Override
    public BAPStage createNewCCJoinStage() {
        return new GenericNotSuccessfullMethod(40, 1, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CCJoin_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CCJoin_Result = TelephoneBindingFactoryCarPlay.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.CCJoin_Result")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CCJoin_Result);
    }

    @Override
    public BAPStage createNewCCSplitStage() {
        return new GenericNotSuccessfullMethod(41, 1, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CCSplit_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CCSplit_Result = TelephoneBindingFactoryCarPlay.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.CCSplit_Result")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CCSplit_Result);
    }

    @Override
    public BAPStage createNewKeypadStage() {
        return null;
    }

    @Override
    public BAPStage createNewMobileBatteryLevelStage() {
        return null;
    }

    @Override
    public BAPStage createNewDataConnectionIndicationStage() {
        return null;
    }

    @Override
    public BAPStage createNewMissedCallIndicationStage() {
        return new MissedCallIndication();
    }

    @Override
    public BAPStage createNewMissedCallsStage() {
        return new GenericEmptyArray(class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MissedCalls_StatusArray == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MissedCalls_StatusArray = TelephoneBindingFactoryCarPlay.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.MissedCalls_StatusArray")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MissedCalls_StatusArray, 46);
    }

    @Override
    public BAPStage createNewReceivedCallsStage() {
        return new GenericEmptyArray(class$de$vw$mib$bap$mqbab2$telephone$functions$ReceivedCalls == null ? (class$de$vw$mib$bap$mqbab2$telephone$functions$ReceivedCalls = TelephoneBindingFactoryCarPlay.class$("de.vw.mib.bap.mqbab2.telephone.functions.ReceivedCalls")) : class$de$vw$mib$bap$mqbab2$telephone$functions$ReceivedCalls, 47);
    }

    @Override
    public BAPStage createNewDialedNumbersStage() {
        return new GenericEmptyArray(class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$DialedNumbers_StatusArray == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$DialedNumbers_StatusArray = TelephoneBindingFactoryCarPlay.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.DialedNumbers_StatusArray")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$DialedNumbers_StatusArray, 48);
    }

    @Override
    public BAPStage createNewCombinedNumbersStage() {
        return new GenericEmptyArray(class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CombinedNumbers_StatusArray == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CombinedNumbers_StatusArray = TelephoneBindingFactoryCarPlay.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.CombinedNumbers_StatusArray")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CombinedNumbers_StatusArray, 49);
    }

    @Override
    public BAPStage createNewCallStackDeleteAllStage() {
        return null;
    }

    @Override
    public BAPStage createNewPbStateStage() {
        return null;
    }

    @Override
    public BAPStage createNewPhonebookStage() {
        return new GenericEmptyArray(class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$Phonebook_StatusArray == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$Phonebook_StatusArray = TelephoneBindingFactoryCarPlay.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.Phonebook_StatusArray")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$Phonebook_StatusArray, 52);
    }

    @Override
    public BAPStage createNewPbSpellerStage() {
        return null;
    }

    @Override
    public BAPStage createNewGetNextListPosStage() {
        return null;
    }

    @Override
    public BAPStage createNewSMSStateStage() {
        return null;
    }

    @Override
    public BAPStage createNewRingToneMuteOnOffStage() {
        return null;
    }

    @Override
    public BAPStage createNewAutomaticRedialStage() {
        return null;
    }

    @Override
    public BAPStage createNewAutomaticRedialExtendedInfoStage() {
        return null;
    }

    @Override
    public BAPStage createNewSupportedServiceNumbersStage() {
        return null;
    }

    @Override
    public BAPStage createNewFavoriteListStage() {
        return new GenericEmptyArray(class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$FavoriteDest_List_StatusArray == null ? (class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$FavoriteDest_List_StatusArray = TelephoneBindingFactoryCarPlay.class$("de.vw.mib.bap.mqbab2.generated.navsd.serializer.FavoriteDest_List_StatusArray")) : class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$FavoriteDest_List_StatusArray, 60);
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

