/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.ecall.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class ServiceState_DataTransmissionState
implements BAPEntity {
    public boolean dataTransmissionViaInbandModemFailed;
    public boolean dataSentViaInbandModemSuccessfully;
    public boolean dataTransmissionViaIpConnectionFailed;
    public boolean dataSentConnectionSuccessfully;
    public boolean mdsReceptionOnBackEndFailed;
    public boolean mdsReceivedOnBackEndSuccessfully;
    public boolean mdsTransmissionViaSmsFailedE_g_NoNet;
    public boolean mdsMinimumDataSetSentViaSmsSuccessfully;
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

    public ServiceState_DataTransmissionState() {
        this.internalReset();
        this.customInitialization();
    }

    public ServiceState_DataTransmissionState(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.dataTransmissionViaInbandModemFailed = false;
        this.dataSentViaInbandModemSuccessfully = false;
        this.dataTransmissionViaIpConnectionFailed = false;
        this.dataSentConnectionSuccessfully = false;
        this.mdsReceptionOnBackEndFailed = false;
        this.mdsReceivedOnBackEndSuccessfully = false;
        this.mdsTransmissionViaSmsFailedE_g_NoNet = false;
        this.mdsMinimumDataSetSentViaSmsSuccessfully = false;
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
        ServiceState_DataTransmissionState serviceState_DataTransmissionState = (ServiceState_DataTransmissionState)bAPEntity;
        return this.dataTransmissionViaInbandModemFailed == serviceState_DataTransmissionState.dataTransmissionViaInbandModemFailed && this.dataSentViaInbandModemSuccessfully == serviceState_DataTransmissionState.dataSentViaInbandModemSuccessfully && this.dataTransmissionViaIpConnectionFailed == serviceState_DataTransmissionState.dataTransmissionViaIpConnectionFailed && this.dataSentConnectionSuccessfully == serviceState_DataTransmissionState.dataSentConnectionSuccessfully && this.mdsReceptionOnBackEndFailed == serviceState_DataTransmissionState.mdsReceptionOnBackEndFailed && this.mdsReceivedOnBackEndSuccessfully == serviceState_DataTransmissionState.mdsReceivedOnBackEndSuccessfully && this.mdsTransmissionViaSmsFailedE_g_NoNet == serviceState_DataTransmissionState.mdsTransmissionViaSmsFailedE_g_NoNet && this.mdsMinimumDataSetSentViaSmsSuccessfully == serviceState_DataTransmissionState.mdsMinimumDataSetSentViaSmsSuccessfully && this.reserved_bit_15 == serviceState_DataTransmissionState.reserved_bit_15 && this.reserved_bit_14 == serviceState_DataTransmissionState.reserved_bit_14 && this.reserved_bit_13 == serviceState_DataTransmissionState.reserved_bit_13 && this.reserved_bit_12 == serviceState_DataTransmissionState.reserved_bit_12 && this.reserved_bit_11 == serviceState_DataTransmissionState.reserved_bit_11 && this.reserved_bit_10 == serviceState_DataTransmissionState.reserved_bit_10 && this.reserved_bit_9 == serviceState_DataTransmissionState.reserved_bit_9 && this.reserved_bit_8 == serviceState_DataTransmissionState.reserved_bit_8 && this.reserved_bit_23 == serviceState_DataTransmissionState.reserved_bit_23 && this.reserved_bit_22 == serviceState_DataTransmissionState.reserved_bit_22 && this.reserved_bit_21 == serviceState_DataTransmissionState.reserved_bit_21 && this.reserved_bit_20 == serviceState_DataTransmissionState.reserved_bit_20 && this.reserved_bit_19 == serviceState_DataTransmissionState.reserved_bit_19 && this.reserved_bit_18 == serviceState_DataTransmissionState.reserved_bit_18 && this.reserved_bit_17 == serviceState_DataTransmissionState.reserved_bit_17 && this.reserved_bit_16 == serviceState_DataTransmissionState.reserved_bit_16 && this.reserved_bit_31 == serviceState_DataTransmissionState.reserved_bit_31 && this.reserved_bit_30 == serviceState_DataTransmissionState.reserved_bit_30 && this.reserved_bit_29 == serviceState_DataTransmissionState.reserved_bit_29 && this.reserved_bit_28 == serviceState_DataTransmissionState.reserved_bit_28 && this.reserved_bit_27 == serviceState_DataTransmissionState.reserved_bit_27 && this.reserved_bit_26 == serviceState_DataTransmissionState.reserved_bit_26 && this.reserved_bit_25 == serviceState_DataTransmissionState.reserved_bit_25 && this.reserved_bit_24 == serviceState_DataTransmissionState.reserved_bit_24;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ServiceState_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.dataTransmissionViaInbandModemFailed);
        bitStream.pushBoolean(this.dataSentViaInbandModemSuccessfully);
        bitStream.pushBoolean(this.dataTransmissionViaIpConnectionFailed);
        bitStream.pushBoolean(this.dataSentConnectionSuccessfully);
        bitStream.pushBoolean(this.mdsReceptionOnBackEndFailed);
        bitStream.pushBoolean(this.mdsReceivedOnBackEndSuccessfully);
        bitStream.pushBoolean(this.mdsTransmissionViaSmsFailedE_g_NoNet);
        bitStream.pushBoolean(this.mdsMinimumDataSetSentViaSmsSuccessfully);
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
        this.dataTransmissionViaInbandModemFailed = bitStream.popFrontBoolean();
        this.dataSentViaInbandModemSuccessfully = bitStream.popFrontBoolean();
        this.dataTransmissionViaIpConnectionFailed = bitStream.popFrontBoolean();
        this.dataSentConnectionSuccessfully = bitStream.popFrontBoolean();
        this.mdsReceptionOnBackEndFailed = bitStream.popFrontBoolean();
        this.mdsReceivedOnBackEndSuccessfully = bitStream.popFrontBoolean();
        this.mdsTransmissionViaSmsFailedE_g_NoNet = bitStream.popFrontBoolean();
        this.mdsMinimumDataSetSentViaSmsSuccessfully = bitStream.popFrontBoolean();
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

