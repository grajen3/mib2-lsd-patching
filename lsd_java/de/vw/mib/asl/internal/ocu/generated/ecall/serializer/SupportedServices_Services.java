/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.ecall.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class SupportedServices_Services
implements BAPEntity {
    public boolean reserved_bit_7;
    public boolean testModeSupportedDf3_4;
    public boolean mecSupported;
    public boolean reserved_bit_4;
    public boolean infoCallSupported;
    public boolean usmSupportedDf3_7;
    public boolean serviceBreakdownCallSupported;
    public boolean reserved_bit_0;
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

    public SupportedServices_Services() {
        this.internalReset();
        this.customInitialization();
    }

    public SupportedServices_Services(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserved_bit_7 = false;
        this.testModeSupportedDf3_4 = false;
        this.mecSupported = false;
        this.reserved_bit_4 = false;
        this.infoCallSupported = false;
        this.usmSupportedDf3_7 = false;
        this.serviceBreakdownCallSupported = false;
        this.reserved_bit_0 = false;
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
        SupportedServices_Services supportedServices_Services = (SupportedServices_Services)bAPEntity;
        return this.reserved_bit_7 == supportedServices_Services.reserved_bit_7 && this.testModeSupportedDf3_4 == supportedServices_Services.testModeSupportedDf3_4 && this.mecSupported == supportedServices_Services.mecSupported && this.reserved_bit_4 == supportedServices_Services.reserved_bit_4 && this.infoCallSupported == supportedServices_Services.infoCallSupported && this.usmSupportedDf3_7 == supportedServices_Services.usmSupportedDf3_7 && this.serviceBreakdownCallSupported == supportedServices_Services.serviceBreakdownCallSupported && this.reserved_bit_0 == supportedServices_Services.reserved_bit_0 && this.reserved_bit_15 == supportedServices_Services.reserved_bit_15 && this.reserved_bit_14 == supportedServices_Services.reserved_bit_14 && this.reserved_bit_13 == supportedServices_Services.reserved_bit_13 && this.reserved_bit_12 == supportedServices_Services.reserved_bit_12 && this.reserved_bit_11 == supportedServices_Services.reserved_bit_11 && this.reserved_bit_10 == supportedServices_Services.reserved_bit_10 && this.reserved_bit_9 == supportedServices_Services.reserved_bit_9 && this.reserved_bit_8 == supportedServices_Services.reserved_bit_8 && this.reserved_bit_23 == supportedServices_Services.reserved_bit_23 && this.reserved_bit_22 == supportedServices_Services.reserved_bit_22 && this.reserved_bit_21 == supportedServices_Services.reserved_bit_21 && this.reserved_bit_20 == supportedServices_Services.reserved_bit_20 && this.reserved_bit_19 == supportedServices_Services.reserved_bit_19 && this.reserved_bit_18 == supportedServices_Services.reserved_bit_18 && this.reserved_bit_17 == supportedServices_Services.reserved_bit_17 && this.reserved_bit_16 == supportedServices_Services.reserved_bit_16 && this.reserved_bit_31 == supportedServices_Services.reserved_bit_31 && this.reserved_bit_30 == supportedServices_Services.reserved_bit_30 && this.reserved_bit_29 == supportedServices_Services.reserved_bit_29 && this.reserved_bit_28 == supportedServices_Services.reserved_bit_28 && this.reserved_bit_27 == supportedServices_Services.reserved_bit_27 && this.reserved_bit_26 == supportedServices_Services.reserved_bit_26 && this.reserved_bit_25 == supportedServices_Services.reserved_bit_25 && this.reserved_bit_24 == supportedServices_Services.reserved_bit_24;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "SupportedServices_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.reserved_bit_7);
        bitStream.pushBoolean(this.testModeSupportedDf3_4);
        bitStream.pushBoolean(this.mecSupported);
        bitStream.pushBoolean(this.reserved_bit_4);
        bitStream.pushBoolean(this.infoCallSupported);
        bitStream.pushBoolean(this.usmSupportedDf3_7);
        bitStream.pushBoolean(this.serviceBreakdownCallSupported);
        bitStream.pushBoolean(this.reserved_bit_0);
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
        this.testModeSupportedDf3_4 = bitStream.popFrontBoolean();
        this.mecSupported = bitStream.popFrontBoolean();
        this.reserved_bit_4 = bitStream.popFrontBoolean();
        this.infoCallSupported = bitStream.popFrontBoolean();
        this.usmSupportedDf3_7 = bitStream.popFrontBoolean();
        this.serviceBreakdownCallSupported = bitStream.popFrontBoolean();
        this.reserved_bit_0 = bitStream.popFrontBoolean();
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

