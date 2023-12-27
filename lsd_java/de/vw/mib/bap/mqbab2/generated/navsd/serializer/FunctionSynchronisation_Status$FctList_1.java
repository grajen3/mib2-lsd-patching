/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FunctionSynchronisation_Status$FctList_1
implements BAPEntity {
    private static final int RESERVED_BIT_0__15_BITSIZE;
    public boolean fctCompassInfoIsToBeSynchronised;
    public boolean fctRg_StatusIsToBeSynchronised;
    public boolean fctDistanceToNextManeuverIsToBeSynchronised;
    public boolean fctCurrentPositionInfoIsToBeSynchronised;
    public boolean fctTurnToInfoIsToBeSynchronised;
    public boolean fctDistanceToDestinationIsToBeSynchronised;
    public boolean fctTimeToDestinationIsToBeSynchronised;
    public boolean fctManeuverDescriptorIsToBeSynchronised;
    public boolean fctLaneGuidanceIsToBeSynchronised;
    public boolean fctTmcinfoIsToBeSynchronised;
    public boolean fctMagnetFieldZoneIsToBeSynchronised;
    public boolean fctCalibrationIsToBeSynchronised;
    public boolean reserved_bit_28;
    public boolean fctLastDest_ListIsToBeSynchronised;
    public boolean fctFavoriteDest_ListIsToBeSynchronised;
    public boolean fctPreferredDest_ListIsToBeSynchronised;
    public boolean fctNavBookIsToBeSynchronised;
    public boolean fctAddress_ListIsToBeSynchronised;
    public boolean fctRg_ActDeactIsToBeSynchronised;
    public boolean reserved_bit_35;
    public boolean fctVoiceGuidanceIsToBeSynchronised;
    public boolean reserved_bit_37;
    public boolean fctInfoStatesIsToBeSynchronised;
    public boolean fctActiveRgTypeIsToBeSynchronised;
    public boolean fctTrafficBlock_IndicationIsToBeSynchronised;
    private static final int RESERVED_BIT_41__42_BITSIZE;
    public boolean fct_MapColorAndTypeIsToBeSynchronised;
    public boolean fct_MapViewAndOrientationIsToBeSynchronised;
    public boolean fct_MapScaleIsToBeSynchronised;
    public boolean fct_DestinationInfoIsToBeSynchronised;
    public boolean fct_AltitudeIsToBeSynchronised;

    public FunctionSynchronisation_Status$FctList_1() {
        this.internalReset();
        this.customInitialization();
    }

    public FunctionSynchronisation_Status$FctList_1(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.fctCompassInfoIsToBeSynchronised = false;
        this.fctRg_StatusIsToBeSynchronised = false;
        this.fctDistanceToNextManeuverIsToBeSynchronised = false;
        this.fctCurrentPositionInfoIsToBeSynchronised = false;
        this.fctTurnToInfoIsToBeSynchronised = false;
        this.fctDistanceToDestinationIsToBeSynchronised = false;
        this.fctTimeToDestinationIsToBeSynchronised = false;
        this.fctManeuverDescriptorIsToBeSynchronised = false;
        this.fctLaneGuidanceIsToBeSynchronised = false;
        this.fctTmcinfoIsToBeSynchronised = false;
        this.fctMagnetFieldZoneIsToBeSynchronised = false;
        this.fctCalibrationIsToBeSynchronised = false;
        this.reserved_bit_28 = false;
        this.fctLastDest_ListIsToBeSynchronised = false;
        this.fctFavoriteDest_ListIsToBeSynchronised = false;
        this.fctPreferredDest_ListIsToBeSynchronised = false;
        this.fctNavBookIsToBeSynchronised = false;
        this.fctAddress_ListIsToBeSynchronised = false;
        this.fctRg_ActDeactIsToBeSynchronised = false;
        this.reserved_bit_35 = false;
        this.fctVoiceGuidanceIsToBeSynchronised = false;
        this.reserved_bit_37 = false;
        this.fctInfoStatesIsToBeSynchronised = false;
        this.fctActiveRgTypeIsToBeSynchronised = false;
        this.fctTrafficBlock_IndicationIsToBeSynchronised = false;
        this.fct_MapColorAndTypeIsToBeSynchronised = false;
        this.fct_MapViewAndOrientationIsToBeSynchronised = false;
        this.fct_MapScaleIsToBeSynchronised = false;
        this.fct_DestinationInfoIsToBeSynchronised = false;
        this.fct_AltitudeIsToBeSynchronised = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FunctionSynchronisation_Status$FctList_1 functionSynchronisation_Status$FctList_1 = (FunctionSynchronisation_Status$FctList_1)bAPEntity;
        return this.fctCompassInfoIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctCompassInfoIsToBeSynchronised && this.fctRg_StatusIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctRg_StatusIsToBeSynchronised && this.fctDistanceToNextManeuverIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctDistanceToNextManeuverIsToBeSynchronised && this.fctCurrentPositionInfoIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctCurrentPositionInfoIsToBeSynchronised && this.fctTurnToInfoIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctTurnToInfoIsToBeSynchronised && this.fctDistanceToDestinationIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctDistanceToDestinationIsToBeSynchronised && this.fctTimeToDestinationIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctTimeToDestinationIsToBeSynchronised && this.fctManeuverDescriptorIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctManeuverDescriptorIsToBeSynchronised && this.fctLaneGuidanceIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctLaneGuidanceIsToBeSynchronised && this.fctTmcinfoIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctTmcinfoIsToBeSynchronised && this.fctMagnetFieldZoneIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctMagnetFieldZoneIsToBeSynchronised && this.fctCalibrationIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctCalibrationIsToBeSynchronised && this.reserved_bit_28 == functionSynchronisation_Status$FctList_1.reserved_bit_28 && this.fctLastDest_ListIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctLastDest_ListIsToBeSynchronised && this.fctFavoriteDest_ListIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctFavoriteDest_ListIsToBeSynchronised && this.fctPreferredDest_ListIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctPreferredDest_ListIsToBeSynchronised && this.fctNavBookIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctNavBookIsToBeSynchronised && this.fctAddress_ListIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctAddress_ListIsToBeSynchronised && this.fctRg_ActDeactIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctRg_ActDeactIsToBeSynchronised && this.reserved_bit_35 == functionSynchronisation_Status$FctList_1.reserved_bit_35 && this.fctVoiceGuidanceIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctVoiceGuidanceIsToBeSynchronised && this.reserved_bit_37 == functionSynchronisation_Status$FctList_1.reserved_bit_37 && this.fctInfoStatesIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctInfoStatesIsToBeSynchronised && this.fctActiveRgTypeIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctActiveRgTypeIsToBeSynchronised && this.fctTrafficBlock_IndicationIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fctTrafficBlock_IndicationIsToBeSynchronised && this.fct_MapColorAndTypeIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fct_MapColorAndTypeIsToBeSynchronised && this.fct_MapViewAndOrientationIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fct_MapViewAndOrientationIsToBeSynchronised && this.fct_MapScaleIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fct_MapScaleIsToBeSynchronised && this.fct_DestinationInfoIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fct_DestinationInfoIsToBeSynchronised && this.fct_AltitudeIsToBeSynchronised == functionSynchronisation_Status$FctList_1.fct_AltitudeIsToBeSynchronised;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "FctList_1:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(16);
        bitStream.pushBoolean(this.fctCompassInfoIsToBeSynchronised);
        bitStream.pushBoolean(this.fctRg_StatusIsToBeSynchronised);
        bitStream.pushBoolean(this.fctDistanceToNextManeuverIsToBeSynchronised);
        bitStream.pushBoolean(this.fctCurrentPositionInfoIsToBeSynchronised);
        bitStream.pushBoolean(this.fctTurnToInfoIsToBeSynchronised);
        bitStream.pushBoolean(this.fctDistanceToDestinationIsToBeSynchronised);
        bitStream.pushBoolean(this.fctTimeToDestinationIsToBeSynchronised);
        bitStream.pushBoolean(this.fctManeuverDescriptorIsToBeSynchronised);
        bitStream.pushBoolean(this.fctLaneGuidanceIsToBeSynchronised);
        bitStream.pushBoolean(this.fctTmcinfoIsToBeSynchronised);
        bitStream.pushBoolean(this.fctMagnetFieldZoneIsToBeSynchronised);
        bitStream.pushBoolean(this.fctCalibrationIsToBeSynchronised);
        bitStream.pushBoolean(this.reserved_bit_28);
        bitStream.pushBoolean(this.fctLastDest_ListIsToBeSynchronised);
        bitStream.pushBoolean(this.fctFavoriteDest_ListIsToBeSynchronised);
        bitStream.pushBoolean(this.fctPreferredDest_ListIsToBeSynchronised);
        bitStream.pushBoolean(this.fctNavBookIsToBeSynchronised);
        bitStream.pushBoolean(this.fctAddress_ListIsToBeSynchronised);
        bitStream.pushBoolean(this.fctRg_ActDeactIsToBeSynchronised);
        bitStream.pushBoolean(this.reserved_bit_35);
        bitStream.pushBoolean(this.fctVoiceGuidanceIsToBeSynchronised);
        bitStream.pushBoolean(this.reserved_bit_37);
        bitStream.pushBoolean(this.fctInfoStatesIsToBeSynchronised);
        bitStream.pushBoolean(this.fctActiveRgTypeIsToBeSynchronised);
        bitStream.pushBoolean(this.fctTrafficBlock_IndicationIsToBeSynchronised);
        bitStream.resetBits(2);
        bitStream.pushBoolean(this.fct_MapColorAndTypeIsToBeSynchronised);
        bitStream.pushBoolean(this.fct_MapViewAndOrientationIsToBeSynchronised);
        bitStream.pushBoolean(this.fct_MapScaleIsToBeSynchronised);
        bitStream.pushBoolean(this.fct_DestinationInfoIsToBeSynchronised);
        bitStream.pushBoolean(this.fct_AltitudeIsToBeSynchronised);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

