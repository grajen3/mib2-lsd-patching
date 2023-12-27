/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class RemoteProcessCommands_SupportedCommands0
implements BAPEntity {
    public boolean getMobileDeviceKeyCountSupportedDf3_4;
    public boolean terminationByUserSupported;
    public boolean confirmServiceExpiryWarningSupported;
    public boolean pairMainUserVehiclePinSupported;
    public boolean pairMainUserPairingCodeSupported;
    public boolean remoteDeleteUserListSupported;
    public boolean remoteUpdateUserListSupported;
    public boolean reserved_bit_0;

    public RemoteProcessCommands_SupportedCommands0() {
        this.internalReset();
        this.customInitialization();
    }

    public RemoteProcessCommands_SupportedCommands0(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.getMobileDeviceKeyCountSupportedDf3_4 = false;
        this.terminationByUserSupported = false;
        this.confirmServiceExpiryWarningSupported = false;
        this.pairMainUserVehiclePinSupported = false;
        this.pairMainUserPairingCodeSupported = false;
        this.remoteDeleteUserListSupported = false;
        this.remoteUpdateUserListSupported = false;
        this.reserved_bit_0 = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        RemoteProcessCommands_SupportedCommands0 remoteProcessCommands_SupportedCommands0 = (RemoteProcessCommands_SupportedCommands0)bAPEntity;
        return this.getMobileDeviceKeyCountSupportedDf3_4 == remoteProcessCommands_SupportedCommands0.getMobileDeviceKeyCountSupportedDf3_4 && this.terminationByUserSupported == remoteProcessCommands_SupportedCommands0.terminationByUserSupported && this.confirmServiceExpiryWarningSupported == remoteProcessCommands_SupportedCommands0.confirmServiceExpiryWarningSupported && this.pairMainUserVehiclePinSupported == remoteProcessCommands_SupportedCommands0.pairMainUserVehiclePinSupported && this.pairMainUserPairingCodeSupported == remoteProcessCommands_SupportedCommands0.pairMainUserPairingCodeSupported && this.remoteDeleteUserListSupported == remoteProcessCommands_SupportedCommands0.remoteDeleteUserListSupported && this.remoteUpdateUserListSupported == remoteProcessCommands_SupportedCommands0.remoteUpdateUserListSupported && this.reserved_bit_0 == remoteProcessCommands_SupportedCommands0.reserved_bit_0;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "RemoteProcessCommands_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.getMobileDeviceKeyCountSupportedDf3_4);
        bitStream.pushBoolean(this.terminationByUserSupported);
        bitStream.pushBoolean(this.confirmServiceExpiryWarningSupported);
        bitStream.pushBoolean(this.pairMainUserVehiclePinSupported);
        bitStream.pushBoolean(this.pairMainUserPairingCodeSupported);
        bitStream.pushBoolean(this.remoteDeleteUserListSupported);
        bitStream.pushBoolean(this.remoteUpdateUserListSupported);
        bitStream.pushBoolean(this.reserved_bit_0);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.getMobileDeviceKeyCountSupportedDf3_4 = bitStream.popFrontBoolean();
        this.terminationByUserSupported = bitStream.popFrontBoolean();
        this.confirmServiceExpiryWarningSupported = bitStream.popFrontBoolean();
        this.pairMainUserVehiclePinSupported = bitStream.popFrontBoolean();
        this.pairMainUserPairingCodeSupported = bitStream.popFrontBoolean();
        this.remoteDeleteUserListSupported = bitStream.popFrontBoolean();
        this.remoteUpdateUserListSupported = bitStream.popFrontBoolean();
        this.reserved_bit_0 = bitStream.popFrontBoolean();
    }
}

