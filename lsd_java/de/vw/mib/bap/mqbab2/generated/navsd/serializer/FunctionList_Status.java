/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FunctionList_Status
implements StatusProperty {
    public boolean reserved_bit_0;
    public boolean fctGetAllAvailable;
    public boolean fctBap_ConfigAvailable;
    public boolean fctFunctionListAvailable;
    public boolean fctHeartBeatAvailable;
    private static final int RESERVED_BIT_5__14_BITSIZE;
    public boolean fctFsg_OperationStateAvailable;
    public boolean fctCompassInfoAvailable;
    public boolean fctRg_StatusAvailable;
    public boolean fctDistanceToNextManeuverAvailable;
    public boolean fctCurrentPositionInfoAvailable;
    public boolean fctTurnToInfoAvailable;
    public boolean fctDistanceToDestinationAvailable;
    public boolean fctTimeToDestinationAvailable;
    public boolean fctManeuverDescriptorAvailable;
    public boolean fctLaneGuidanceAvailable;
    public boolean fctTmcinfoAvailable;
    public boolean fctMagnetFieldZoneAvailable;
    public boolean fctCalibrationAvailable;
    public boolean fctAsg_CapabilitiesAvailable;
    public boolean fctLastDest_ListAvailable;
    public boolean fctFavoriteDest_ListAvailable;
    public boolean fctPreferredDest_ListAvailable;
    public boolean fctNavBookAvailable;
    public boolean fctAddress_ListAvailable;
    public boolean fctRg_ActDeactAvailable;
    public boolean fctRepeatLastNavAnnouncementAvailable;
    public boolean fctVoiceGuidanceAvailable;
    public boolean fctFunctionSynchronisationAvailable;
    public boolean fctInfoStatesAvailable;
    public boolean fctActiveRgTypeAvailable;
    public boolean fctTrafficBlock_IndicationAvailable;
    public boolean fctGetNextListPosAvailable;
    public boolean fctNbSpellerAvailable;
    public boolean fctMapColorAndTypeAvailable;
    public boolean fctMapViewAndOrientationAvailable;
    public boolean fctMapScaleAvailable;
    public boolean fctDestinationInfoAvailable;
    public boolean fctAltitudeAvailable;
    public boolean fctOnlineNavigationStateAvailable;
    public boolean fctExitviewAvailable;
    public boolean fctSemidynamicRouteGuidanceAvailable;
    public boolean fctPoi_SearchAvailable;
    public boolean fctPoi_ListAvailable;
    public boolean fctFsg_SetupAvailable;
    public boolean fctMap_PresentationAvailable;
    public boolean fctManeuverStateAvailable;
    public boolean fctEtc_StatusAvailable;
    private static final int RESERVED_BIT_57__63_BITSIZE;

    public FunctionList_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public FunctionList_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserved_bit_0 = false;
        this.fctGetAllAvailable = false;
        this.fctBap_ConfigAvailable = false;
        this.fctFunctionListAvailable = false;
        this.fctHeartBeatAvailable = false;
        this.fctFsg_OperationStateAvailable = false;
        this.fctCompassInfoAvailable = false;
        this.fctRg_StatusAvailable = false;
        this.fctDistanceToNextManeuverAvailable = false;
        this.fctCurrentPositionInfoAvailable = false;
        this.fctTurnToInfoAvailable = false;
        this.fctDistanceToDestinationAvailable = false;
        this.fctTimeToDestinationAvailable = false;
        this.fctManeuverDescriptorAvailable = false;
        this.fctLaneGuidanceAvailable = false;
        this.fctTmcinfoAvailable = false;
        this.fctMagnetFieldZoneAvailable = false;
        this.fctCalibrationAvailable = false;
        this.fctAsg_CapabilitiesAvailable = false;
        this.fctLastDest_ListAvailable = false;
        this.fctFavoriteDest_ListAvailable = false;
        this.fctPreferredDest_ListAvailable = false;
        this.fctNavBookAvailable = false;
        this.fctAddress_ListAvailable = false;
        this.fctRg_ActDeactAvailable = false;
        this.fctRepeatLastNavAnnouncementAvailable = false;
        this.fctVoiceGuidanceAvailable = false;
        this.fctFunctionSynchronisationAvailable = false;
        this.fctInfoStatesAvailable = false;
        this.fctActiveRgTypeAvailable = false;
        this.fctTrafficBlock_IndicationAvailable = false;
        this.fctGetNextListPosAvailable = false;
        this.fctNbSpellerAvailable = false;
        this.fctMapColorAndTypeAvailable = false;
        this.fctMapViewAndOrientationAvailable = false;
        this.fctMapScaleAvailable = false;
        this.fctDestinationInfoAvailable = false;
        this.fctAltitudeAvailable = false;
        this.fctOnlineNavigationStateAvailable = false;
        this.fctExitviewAvailable = false;
        this.fctSemidynamicRouteGuidanceAvailable = false;
        this.fctPoi_SearchAvailable = false;
        this.fctPoi_ListAvailable = false;
        this.fctFsg_SetupAvailable = false;
        this.fctMap_PresentationAvailable = false;
        this.fctManeuverStateAvailable = false;
        this.fctEtc_StatusAvailable = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FunctionList_Status functionList_Status = (FunctionList_Status)bAPEntity;
        return this.reserved_bit_0 == functionList_Status.reserved_bit_0 && this.fctGetAllAvailable == functionList_Status.fctGetAllAvailable && this.fctBap_ConfigAvailable == functionList_Status.fctBap_ConfigAvailable && this.fctFunctionListAvailable == functionList_Status.fctFunctionListAvailable && this.fctHeartBeatAvailable == functionList_Status.fctHeartBeatAvailable && this.fctFsg_OperationStateAvailable == functionList_Status.fctFsg_OperationStateAvailable && this.fctCompassInfoAvailable == functionList_Status.fctCompassInfoAvailable && this.fctRg_StatusAvailable == functionList_Status.fctRg_StatusAvailable && this.fctDistanceToNextManeuverAvailable == functionList_Status.fctDistanceToNextManeuverAvailable && this.fctCurrentPositionInfoAvailable == functionList_Status.fctCurrentPositionInfoAvailable && this.fctTurnToInfoAvailable == functionList_Status.fctTurnToInfoAvailable && this.fctDistanceToDestinationAvailable == functionList_Status.fctDistanceToDestinationAvailable && this.fctTimeToDestinationAvailable == functionList_Status.fctTimeToDestinationAvailable && this.fctManeuverDescriptorAvailable == functionList_Status.fctManeuverDescriptorAvailable && this.fctLaneGuidanceAvailable == functionList_Status.fctLaneGuidanceAvailable && this.fctTmcinfoAvailable == functionList_Status.fctTmcinfoAvailable && this.fctMagnetFieldZoneAvailable == functionList_Status.fctMagnetFieldZoneAvailable && this.fctCalibrationAvailable == functionList_Status.fctCalibrationAvailable && this.fctAsg_CapabilitiesAvailable == functionList_Status.fctAsg_CapabilitiesAvailable && this.fctLastDest_ListAvailable == functionList_Status.fctLastDest_ListAvailable && this.fctFavoriteDest_ListAvailable == functionList_Status.fctFavoriteDest_ListAvailable && this.fctPreferredDest_ListAvailable == functionList_Status.fctPreferredDest_ListAvailable && this.fctNavBookAvailable == functionList_Status.fctNavBookAvailable && this.fctAddress_ListAvailable == functionList_Status.fctAddress_ListAvailable && this.fctRg_ActDeactAvailable == functionList_Status.fctRg_ActDeactAvailable && this.fctRepeatLastNavAnnouncementAvailable == functionList_Status.fctRepeatLastNavAnnouncementAvailable && this.fctVoiceGuidanceAvailable == functionList_Status.fctVoiceGuidanceAvailable && this.fctFunctionSynchronisationAvailable == functionList_Status.fctFunctionSynchronisationAvailable && this.fctInfoStatesAvailable == functionList_Status.fctInfoStatesAvailable && this.fctActiveRgTypeAvailable == functionList_Status.fctActiveRgTypeAvailable && this.fctTrafficBlock_IndicationAvailable == functionList_Status.fctTrafficBlock_IndicationAvailable && this.fctGetNextListPosAvailable == functionList_Status.fctGetNextListPosAvailable && this.fctNbSpellerAvailable == functionList_Status.fctNbSpellerAvailable && this.fctMapColorAndTypeAvailable == functionList_Status.fctMapColorAndTypeAvailable && this.fctMapViewAndOrientationAvailable == functionList_Status.fctMapViewAndOrientationAvailable && this.fctMapScaleAvailable == functionList_Status.fctMapScaleAvailable && this.fctDestinationInfoAvailable == functionList_Status.fctDestinationInfoAvailable && this.fctAltitudeAvailable == functionList_Status.fctAltitudeAvailable && this.fctOnlineNavigationStateAvailable == functionList_Status.fctOnlineNavigationStateAvailable && this.fctExitviewAvailable == functionList_Status.fctExitviewAvailable && this.fctSemidynamicRouteGuidanceAvailable == functionList_Status.fctSemidynamicRouteGuidanceAvailable && this.fctPoi_SearchAvailable == functionList_Status.fctPoi_SearchAvailable && this.fctPoi_ListAvailable == functionList_Status.fctPoi_ListAvailable && this.fctFsg_SetupAvailable == functionList_Status.fctFsg_SetupAvailable && this.fctMap_PresentationAvailable == functionList_Status.fctMap_PresentationAvailable && this.fctManeuverStateAvailable == functionList_Status.fctManeuverStateAvailable && this.fctEtc_StatusAvailable == functionList_Status.fctEtc_StatusAvailable;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "FunctionList_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.reserved_bit_0);
        bitStream.pushBoolean(this.fctGetAllAvailable);
        bitStream.pushBoolean(this.fctBap_ConfigAvailable);
        bitStream.pushBoolean(this.fctFunctionListAvailable);
        bitStream.pushBoolean(this.fctHeartBeatAvailable);
        bitStream.resetBits(10);
        bitStream.pushBoolean(this.fctFsg_OperationStateAvailable);
        bitStream.pushBoolean(this.fctCompassInfoAvailable);
        bitStream.pushBoolean(this.fctRg_StatusAvailable);
        bitStream.pushBoolean(this.fctDistanceToNextManeuverAvailable);
        bitStream.pushBoolean(this.fctCurrentPositionInfoAvailable);
        bitStream.pushBoolean(this.fctTurnToInfoAvailable);
        bitStream.pushBoolean(this.fctDistanceToDestinationAvailable);
        bitStream.pushBoolean(this.fctTimeToDestinationAvailable);
        bitStream.pushBoolean(this.fctManeuverDescriptorAvailable);
        bitStream.pushBoolean(this.fctLaneGuidanceAvailable);
        bitStream.pushBoolean(this.fctTmcinfoAvailable);
        bitStream.pushBoolean(this.fctMagnetFieldZoneAvailable);
        bitStream.pushBoolean(this.fctCalibrationAvailable);
        bitStream.pushBoolean(this.fctAsg_CapabilitiesAvailable);
        bitStream.pushBoolean(this.fctLastDest_ListAvailable);
        bitStream.pushBoolean(this.fctFavoriteDest_ListAvailable);
        bitStream.pushBoolean(this.fctPreferredDest_ListAvailable);
        bitStream.pushBoolean(this.fctNavBookAvailable);
        bitStream.pushBoolean(this.fctAddress_ListAvailable);
        bitStream.pushBoolean(this.fctRg_ActDeactAvailable);
        bitStream.pushBoolean(this.fctRepeatLastNavAnnouncementAvailable);
        bitStream.pushBoolean(this.fctVoiceGuidanceAvailable);
        bitStream.pushBoolean(this.fctFunctionSynchronisationAvailable);
        bitStream.pushBoolean(this.fctInfoStatesAvailable);
        bitStream.pushBoolean(this.fctActiveRgTypeAvailable);
        bitStream.pushBoolean(this.fctTrafficBlock_IndicationAvailable);
        bitStream.pushBoolean(this.fctGetNextListPosAvailable);
        bitStream.pushBoolean(this.fctNbSpellerAvailable);
        bitStream.pushBoolean(this.fctMapColorAndTypeAvailable);
        bitStream.pushBoolean(this.fctMapViewAndOrientationAvailable);
        bitStream.pushBoolean(this.fctMapScaleAvailable);
        bitStream.pushBoolean(this.fctDestinationInfoAvailable);
        bitStream.pushBoolean(this.fctAltitudeAvailable);
        bitStream.pushBoolean(this.fctOnlineNavigationStateAvailable);
        bitStream.pushBoolean(this.fctExitviewAvailable);
        bitStream.pushBoolean(this.fctSemidynamicRouteGuidanceAvailable);
        bitStream.pushBoolean(this.fctPoi_SearchAvailable);
        bitStream.pushBoolean(this.fctPoi_ListAvailable);
        bitStream.pushBoolean(this.fctFsg_SetupAvailable);
        bitStream.pushBoolean(this.fctMap_PresentationAvailable);
        bitStream.pushBoolean(this.fctManeuverStateAvailable);
        bitStream.pushBoolean(this.fctEtc_StatusAvailable);
        bitStream.resetBits(7);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 3;
    }

    @Override
    public int getFunctionId() {
        return FunctionList_Status.functionId();
    }
}

