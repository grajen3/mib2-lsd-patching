/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.ecall.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FunctionalRestrictions_Restrictions
implements BAPEntity {
    public boolean reserved_bit_7;
    public boolean reserved_bit_6;
    public boolean reserved_bit_5;
    public boolean reserved_bit_4;
    public boolean reserved_bit_3;
    public boolean audioDownlinkNotFullyFunctional;
    public boolean audioUplinkNotFullyFunctional;
    public boolean audioNotFullyFunctional;
    public boolean reserved_bit_15;
    public boolean reserved_bit_14;
    public boolean reserved_bit_13;
    public boolean reserved_bit_12;
    public boolean reserved_bit_11;
    public boolean reserved_bit_10;
    public boolean reserved_bit_9;
    public boolean reserved_bit_8;
    public boolean reserved_bit_23;
    public boolean reserved_bit_22;
    public boolean reserved_bit_21;
    public boolean reserved_bit_20;
    public boolean reserved_bit_19;
    public boolean reserved_bit_18;
    public boolean reserved_bit_17;
    public boolean reserved_bit_16;
    public boolean reserved_bit_31;
    public boolean reserved_bit_30;
    public boolean reserved_bit_29;
    public boolean reserved_bit_28;
    public boolean reserved_bit_27;
    public boolean reserved_bit_26;
    public boolean reserved_bit_25;
    public boolean reserved_bit_24;

    public FunctionalRestrictions_Restrictions() {
        this.internalReset();
        this.customInitialization();
    }

    public FunctionalRestrictions_Restrictions(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserved_bit_7 = false;
        this.reserved_bit_6 = false;
        this.reserved_bit_5 = false;
        this.reserved_bit_4 = false;
        this.reserved_bit_3 = false;
        this.audioDownlinkNotFullyFunctional = false;
        this.audioUplinkNotFullyFunctional = false;
        this.audioNotFullyFunctional = false;
        this.reserved_bit_15 = false;
        this.reserved_bit_14 = false;
        this.reserved_bit_13 = false;
        this.reserved_bit_12 = false;
        this.reserved_bit_11 = false;
        this.reserved_bit_10 = false;
        this.reserved_bit_9 = false;
        this.reserved_bit_8 = false;
        this.reserved_bit_23 = false;
        this.reserved_bit_22 = false;
        this.reserved_bit_21 = false;
        this.reserved_bit_20 = false;
        this.reserved_bit_19 = false;
        this.reserved_bit_18 = false;
        this.reserved_bit_17 = false;
        this.reserved_bit_16 = false;
        this.reserved_bit_31 = false;
        this.reserved_bit_30 = false;
        this.reserved_bit_29 = false;
        this.reserved_bit_28 = false;
        this.reserved_bit_27 = false;
        this.reserved_bit_26 = false;
        this.reserved_bit_25 = false;
        this.reserved_bit_24 = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FunctionalRestrictions_Restrictions functionalRestrictions_Restrictions = (FunctionalRestrictions_Restrictions)bAPEntity;
        return this.reserved_bit_7 == functionalRestrictions_Restrictions.reserved_bit_7 && this.reserved_bit_6 == functionalRestrictions_Restrictions.reserved_bit_6 && this.reserved_bit_5 == functionalRestrictions_Restrictions.reserved_bit_5 && this.reserved_bit_4 == functionalRestrictions_Restrictions.reserved_bit_4 && this.reserved_bit_3 == functionalRestrictions_Restrictions.reserved_bit_3 && this.audioDownlinkNotFullyFunctional == functionalRestrictions_Restrictions.audioDownlinkNotFullyFunctional && this.audioUplinkNotFullyFunctional == functionalRestrictions_Restrictions.audioUplinkNotFullyFunctional && this.audioNotFullyFunctional == functionalRestrictions_Restrictions.audioNotFullyFunctional && this.reserved_bit_15 == functionalRestrictions_Restrictions.reserved_bit_15 && this.reserved_bit_14 == functionalRestrictions_Restrictions.reserved_bit_14 && this.reserved_bit_13 == functionalRestrictions_Restrictions.reserved_bit_13 && this.reserved_bit_12 == functionalRestrictions_Restrictions.reserved_bit_12 && this.reserved_bit_11 == functionalRestrictions_Restrictions.reserved_bit_11 && this.reserved_bit_10 == functionalRestrictions_Restrictions.reserved_bit_10 && this.reserved_bit_9 == functionalRestrictions_Restrictions.reserved_bit_9 && this.reserved_bit_8 == functionalRestrictions_Restrictions.reserved_bit_8 && this.reserved_bit_23 == functionalRestrictions_Restrictions.reserved_bit_23 && this.reserved_bit_22 == functionalRestrictions_Restrictions.reserved_bit_22 && this.reserved_bit_21 == functionalRestrictions_Restrictions.reserved_bit_21 && this.reserved_bit_20 == functionalRestrictions_Restrictions.reserved_bit_20 && this.reserved_bit_19 == functionalRestrictions_Restrictions.reserved_bit_19 && this.reserved_bit_18 == functionalRestrictions_Restrictions.reserved_bit_18 && this.reserved_bit_17 == functionalRestrictions_Restrictions.reserved_bit_17 && this.reserved_bit_16 == functionalRestrictions_Restrictions.reserved_bit_16 && this.reserved_bit_31 == functionalRestrictions_Restrictions.reserved_bit_31 && this.reserved_bit_30 == functionalRestrictions_Restrictions.reserved_bit_30 && this.reserved_bit_29 == functionalRestrictions_Restrictions.reserved_bit_29 && this.reserved_bit_28 == functionalRestrictions_Restrictions.reserved_bit_28 && this.reserved_bit_27 == functionalRestrictions_Restrictions.reserved_bit_27 && this.reserved_bit_26 == functionalRestrictions_Restrictions.reserved_bit_26 && this.reserved_bit_25 == functionalRestrictions_Restrictions.reserved_bit_25 && this.reserved_bit_24 == functionalRestrictions_Restrictions.reserved_bit_24;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "FunctionalRestrictions_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.reserved_bit_7);
        bitStream.pushBoolean(this.reserved_bit_6);
        bitStream.pushBoolean(this.reserved_bit_5);
        bitStream.pushBoolean(this.reserved_bit_4);
        bitStream.pushBoolean(this.reserved_bit_3);
        bitStream.pushBoolean(this.audioDownlinkNotFullyFunctional);
        bitStream.pushBoolean(this.audioUplinkNotFullyFunctional);
        bitStream.pushBoolean(this.audioNotFullyFunctional);
        bitStream.pushBoolean(this.reserved_bit_15);
        bitStream.pushBoolean(this.reserved_bit_14);
        bitStream.pushBoolean(this.reserved_bit_13);
        bitStream.pushBoolean(this.reserved_bit_12);
        bitStream.pushBoolean(this.reserved_bit_11);
        bitStream.pushBoolean(this.reserved_bit_10);
        bitStream.pushBoolean(this.reserved_bit_9);
        bitStream.pushBoolean(this.reserved_bit_8);
        bitStream.pushBoolean(this.reserved_bit_23);
        bitStream.pushBoolean(this.reserved_bit_22);
        bitStream.pushBoolean(this.reserved_bit_21);
        bitStream.pushBoolean(this.reserved_bit_20);
        bitStream.pushBoolean(this.reserved_bit_19);
        bitStream.pushBoolean(this.reserved_bit_18);
        bitStream.pushBoolean(this.reserved_bit_17);
        bitStream.pushBoolean(this.reserved_bit_16);
        bitStream.pushBoolean(this.reserved_bit_31);
        bitStream.pushBoolean(this.reserved_bit_30);
        bitStream.pushBoolean(this.reserved_bit_29);
        bitStream.pushBoolean(this.reserved_bit_28);
        bitStream.pushBoolean(this.reserved_bit_27);
        bitStream.pushBoolean(this.reserved_bit_26);
        bitStream.pushBoolean(this.reserved_bit_25);
        bitStream.pushBoolean(this.reserved_bit_24);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.reserved_bit_7 = bitStream.popFrontBoolean();
        this.reserved_bit_6 = bitStream.popFrontBoolean();
        this.reserved_bit_5 = bitStream.popFrontBoolean();
        this.reserved_bit_4 = bitStream.popFrontBoolean();
        this.reserved_bit_3 = bitStream.popFrontBoolean();
        this.audioDownlinkNotFullyFunctional = bitStream.popFrontBoolean();
        this.audioUplinkNotFullyFunctional = bitStream.popFrontBoolean();
        this.audioNotFullyFunctional = bitStream.popFrontBoolean();
        this.reserved_bit_15 = bitStream.popFrontBoolean();
        this.reserved_bit_14 = bitStream.popFrontBoolean();
        this.reserved_bit_13 = bitStream.popFrontBoolean();
        this.reserved_bit_12 = bitStream.popFrontBoolean();
        this.reserved_bit_11 = bitStream.popFrontBoolean();
        this.reserved_bit_10 = bitStream.popFrontBoolean();
        this.reserved_bit_9 = bitStream.popFrontBoolean();
        this.reserved_bit_8 = bitStream.popFrontBoolean();
        this.reserved_bit_23 = bitStream.popFrontBoolean();
        this.reserved_bit_22 = bitStream.popFrontBoolean();
        this.reserved_bit_21 = bitStream.popFrontBoolean();
        this.reserved_bit_20 = bitStream.popFrontBoolean();
        this.reserved_bit_19 = bitStream.popFrontBoolean();
        this.reserved_bit_18 = bitStream.popFrontBoolean();
        this.reserved_bit_17 = bitStream.popFrontBoolean();
        this.reserved_bit_16 = bitStream.popFrontBoolean();
        this.reserved_bit_31 = bitStream.popFrontBoolean();
        this.reserved_bit_30 = bitStream.popFrontBoolean();
        this.reserved_bit_29 = bitStream.popFrontBoolean();
        this.reserved_bit_28 = bitStream.popFrontBoolean();
        this.reserved_bit_27 = bitStream.popFrontBoolean();
        this.reserved_bit_26 = bitStream.popFrontBoolean();
        this.reserved_bit_25 = bitStream.popFrontBoolean();
        this.reserved_bit_24 = bitStream.popFrontBoolean();
    }
}

