/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FunctionList_Status
implements StatusProperty {
    public boolean reserved_bit_0;
    public boolean fctIdGetAllSupported;
    public boolean fctIdBapConfigSupported;
    public boolean fctIdFunctionListSupported;
    public boolean fctIdHeartbeatSupported;
    public boolean reserved_bit_5;
    public boolean reserved_bit_6;
    public boolean reserved_bit_7;
    public boolean reserved_bit_8;
    public boolean reserved_bit_9;
    public boolean reserved_bit_10;
    public boolean reserved_bit_11;
    public boolean reserved_bit_12;
    public boolean fctIdFsgControlSupported;
    public boolean fctIdFsgSetupSupported;
    public boolean fctIdFsgOperationStateSupported;
    public boolean fctIdCompassInfoSupported;
    public boolean fctIdRouteGuidance_StatusSupported;
    public boolean fctIdDistanceToNextManeuverSupported;
    public boolean fctIdCurrentPositionInfoSupported;
    public boolean fctIdTurnToInfoSupported;
    public boolean fctIdDistanceTimeToDestinationSupported;
    public boolean fctIdManeuverDescriptorSupported;
    private static final int RESERVED_BIT_23___63_BITSIZE;

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
        this.fctIdGetAllSupported = false;
        this.fctIdBapConfigSupported = false;
        this.fctIdFunctionListSupported = false;
        this.fctIdHeartbeatSupported = false;
        this.reserved_bit_5 = false;
        this.reserved_bit_6 = false;
        this.reserved_bit_7 = false;
        this.reserved_bit_8 = false;
        this.reserved_bit_9 = false;
        this.reserved_bit_10 = false;
        this.reserved_bit_11 = false;
        this.reserved_bit_12 = false;
        this.fctIdFsgControlSupported = false;
        this.fctIdFsgSetupSupported = false;
        this.fctIdFsgOperationStateSupported = false;
        this.fctIdCompassInfoSupported = false;
        this.fctIdRouteGuidance_StatusSupported = false;
        this.fctIdDistanceToNextManeuverSupported = false;
        this.fctIdCurrentPositionInfoSupported = false;
        this.fctIdTurnToInfoSupported = false;
        this.fctIdDistanceTimeToDestinationSupported = false;
        this.fctIdManeuverDescriptorSupported = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FunctionList_Status functionList_Status = (FunctionList_Status)bAPEntity;
        return this.reserved_bit_0 == functionList_Status.reserved_bit_0 && this.fctIdGetAllSupported == functionList_Status.fctIdGetAllSupported && this.fctIdBapConfigSupported == functionList_Status.fctIdBapConfigSupported && this.fctIdFunctionListSupported == functionList_Status.fctIdFunctionListSupported && this.fctIdHeartbeatSupported == functionList_Status.fctIdHeartbeatSupported && this.reserved_bit_5 == functionList_Status.reserved_bit_5 && this.reserved_bit_6 == functionList_Status.reserved_bit_6 && this.reserved_bit_7 == functionList_Status.reserved_bit_7 && this.reserved_bit_8 == functionList_Status.reserved_bit_8 && this.reserved_bit_9 == functionList_Status.reserved_bit_9 && this.reserved_bit_10 == functionList_Status.reserved_bit_10 && this.reserved_bit_11 == functionList_Status.reserved_bit_11 && this.reserved_bit_12 == functionList_Status.reserved_bit_12 && this.fctIdFsgControlSupported == functionList_Status.fctIdFsgControlSupported && this.fctIdFsgSetupSupported == functionList_Status.fctIdFsgSetupSupported && this.fctIdFsgOperationStateSupported == functionList_Status.fctIdFsgOperationStateSupported && this.fctIdCompassInfoSupported == functionList_Status.fctIdCompassInfoSupported && this.fctIdRouteGuidance_StatusSupported == functionList_Status.fctIdRouteGuidance_StatusSupported && this.fctIdDistanceToNextManeuverSupported == functionList_Status.fctIdDistanceToNextManeuverSupported && this.fctIdCurrentPositionInfoSupported == functionList_Status.fctIdCurrentPositionInfoSupported && this.fctIdTurnToInfoSupported == functionList_Status.fctIdTurnToInfoSupported && this.fctIdDistanceTimeToDestinationSupported == functionList_Status.fctIdDistanceTimeToDestinationSupported && this.fctIdManeuverDescriptorSupported == functionList_Status.fctIdManeuverDescriptorSupported;
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
        bitStream.pushBoolean(this.fctIdGetAllSupported);
        bitStream.pushBoolean(this.fctIdBapConfigSupported);
        bitStream.pushBoolean(this.fctIdFunctionListSupported);
        bitStream.pushBoolean(this.fctIdHeartbeatSupported);
        bitStream.pushBoolean(this.reserved_bit_5);
        bitStream.pushBoolean(this.reserved_bit_6);
        bitStream.pushBoolean(this.reserved_bit_7);
        bitStream.pushBoolean(this.reserved_bit_8);
        bitStream.pushBoolean(this.reserved_bit_9);
        bitStream.pushBoolean(this.reserved_bit_10);
        bitStream.pushBoolean(this.reserved_bit_11);
        bitStream.pushBoolean(this.reserved_bit_12);
        bitStream.pushBoolean(this.fctIdFsgControlSupported);
        bitStream.pushBoolean(this.fctIdFsgSetupSupported);
        bitStream.pushBoolean(this.fctIdFsgOperationStateSupported);
        bitStream.pushBoolean(this.fctIdCompassInfoSupported);
        bitStream.pushBoolean(this.fctIdRouteGuidance_StatusSupported);
        bitStream.pushBoolean(this.fctIdDistanceToNextManeuverSupported);
        bitStream.pushBoolean(this.fctIdCurrentPositionInfoSupported);
        bitStream.pushBoolean(this.fctIdTurnToInfoSupported);
        bitStream.pushBoolean(this.fctIdDistanceTimeToDestinationSupported);
        bitStream.pushBoolean(this.fctIdManeuverDescriptorSupported);
        bitStream.resetBits(41);
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

