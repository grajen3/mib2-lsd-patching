/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FunctionSynchronisation_FctList_2
implements BAPEntity {
    public boolean fctCustomerDownloadStateIsToBeSynchronised;
    public boolean fctOnlineMusic_StateIsToBeSynchronised;
    public boolean reserved_bit_2;
    public boolean fctCurrentStation_Handle2IsToBeSynchronised;
    public boolean fctPlayPositionIsToBeSynchronised;
    public boolean fctSds_RecognizerStateIsToBeSynchronised;
    public boolean fctCurrentStationInfo2IsToBeSynchronised;
    public boolean fctLast_ActiveSourceIsToBeSynchronised;

    public FunctionSynchronisation_FctList_2() {
        this.internalReset();
        this.customInitialization();
    }

    public FunctionSynchronisation_FctList_2(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.fctCustomerDownloadStateIsToBeSynchronised = false;
        this.fctOnlineMusic_StateIsToBeSynchronised = false;
        this.reserved_bit_2 = false;
        this.fctCurrentStation_Handle2IsToBeSynchronised = false;
        this.fctPlayPositionIsToBeSynchronised = false;
        this.fctSds_RecognizerStateIsToBeSynchronised = false;
        this.fctCurrentStationInfo2IsToBeSynchronised = false;
        this.fctLast_ActiveSourceIsToBeSynchronised = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FunctionSynchronisation_FctList_2 functionSynchronisation_FctList_2 = (FunctionSynchronisation_FctList_2)bAPEntity;
        return this.fctCustomerDownloadStateIsToBeSynchronised == functionSynchronisation_FctList_2.fctCustomerDownloadStateIsToBeSynchronised && this.fctOnlineMusic_StateIsToBeSynchronised == functionSynchronisation_FctList_2.fctOnlineMusic_StateIsToBeSynchronised && this.reserved_bit_2 == functionSynchronisation_FctList_2.reserved_bit_2 && this.fctCurrentStation_Handle2IsToBeSynchronised == functionSynchronisation_FctList_2.fctCurrentStation_Handle2IsToBeSynchronised && this.fctPlayPositionIsToBeSynchronised == functionSynchronisation_FctList_2.fctPlayPositionIsToBeSynchronised && this.fctSds_RecognizerStateIsToBeSynchronised == functionSynchronisation_FctList_2.fctSds_RecognizerStateIsToBeSynchronised && this.fctCurrentStationInfo2IsToBeSynchronised == functionSynchronisation_FctList_2.fctCurrentStationInfo2IsToBeSynchronised && this.fctLast_ActiveSourceIsToBeSynchronised == functionSynchronisation_FctList_2.fctLast_ActiveSourceIsToBeSynchronised;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "FunctionSynchronisation_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.fctCustomerDownloadStateIsToBeSynchronised);
        bitStream.pushBoolean(this.fctOnlineMusic_StateIsToBeSynchronised);
        bitStream.pushBoolean(this.reserved_bit_2);
        bitStream.pushBoolean(this.fctCurrentStation_Handle2IsToBeSynchronised);
        bitStream.pushBoolean(this.fctPlayPositionIsToBeSynchronised);
        bitStream.pushBoolean(this.fctSds_RecognizerStateIsToBeSynchronised);
        bitStream.pushBoolean(this.fctCurrentStationInfo2IsToBeSynchronised);
        bitStream.pushBoolean(this.fctLast_ActiveSourceIsToBeSynchronised);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.fctCustomerDownloadStateIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fctOnlineMusic_StateIsToBeSynchronised = bitStream.popFrontBoolean();
        this.reserved_bit_2 = bitStream.popFrontBoolean();
        this.fctCurrentStation_Handle2IsToBeSynchronised = bitStream.popFrontBoolean();
        this.fctPlayPositionIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fctSds_RecognizerStateIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fctCurrentStationInfo2IsToBeSynchronised = bitStream.popFrontBoolean();
        this.fctLast_ActiveSourceIsToBeSynchronised = bitStream.popFrontBoolean();
    }
}

