/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class OLBSettings_Olb_AvailableFunctions
implements BAPEntity {
    private static final int RESERVED_BIT_2__7_BITSIZE;
    public boolean driverAuthentificationPopupForOlbCanBeModified;
    public boolean olbTripReminderPopupReminderCanBeModified;

    public OLBSettings_Olb_AvailableFunctions() {
        this.internalReset();
        this.customInitialization();
    }

    public OLBSettings_Olb_AvailableFunctions(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.driverAuthentificationPopupForOlbCanBeModified = false;
        this.olbTripReminderPopupReminderCanBeModified = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        OLBSettings_Olb_AvailableFunctions oLBSettings_Olb_AvailableFunctions = (OLBSettings_Olb_AvailableFunctions)bAPEntity;
        return this.driverAuthentificationPopupForOlbCanBeModified == oLBSettings_Olb_AvailableFunctions.driverAuthentificationPopupForOlbCanBeModified && this.olbTripReminderPopupReminderCanBeModified == oLBSettings_Olb_AvailableFunctions.olbTripReminderPopupReminderCanBeModified;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "OLBSettings_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(6);
        bitStream.pushBoolean(this.driverAuthentificationPopupForOlbCanBeModified);
        bitStream.pushBoolean(this.olbTripReminderPopupReminderCanBeModified);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(6);
        this.driverAuthentificationPopupForOlbCanBeModified = bitStream.popFrontBoolean();
        this.olbTripReminderPopupReminderCanBeModified = bitStream.popFrontBoolean();
    }
}

