/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class OLBSettings_Olb_Setup
implements BAPEntity {
    private static final int RESERVED_BIT_2__7_BITSIZE;
    public boolean driverAuthentificationPopupForOlbIsActive;
    public boolean olbTripReminderPopupIsActive;

    public OLBSettings_Olb_Setup() {
        this.internalReset();
        this.customInitialization();
    }

    public OLBSettings_Olb_Setup(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.driverAuthentificationPopupForOlbIsActive = false;
        this.olbTripReminderPopupIsActive = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        OLBSettings_Olb_Setup oLBSettings_Olb_Setup = (OLBSettings_Olb_Setup)bAPEntity;
        return this.driverAuthentificationPopupForOlbIsActive == oLBSettings_Olb_Setup.driverAuthentificationPopupForOlbIsActive && this.olbTripReminderPopupIsActive == oLBSettings_Olb_Setup.olbTripReminderPopupIsActive;
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
        bitStream.pushBoolean(this.driverAuthentificationPopupForOlbIsActive);
        bitStream.pushBoolean(this.olbTripReminderPopupIsActive);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(6);
        this.driverAuthentificationPopupForOlbIsActive = bitStream.popFrontBoolean();
        this.olbTripReminderPopupIsActive = bitStream.popFrontBoolean();
    }
}

