/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class SDS_RecognizerState_Status
implements StatusProperty {
    public int inputLevel;
    public static final int INPUT_LEVEL_MIN;
    public int inputQuality;
    public static final int INPUT_QUALITY_MIN;
    public int extension1;
    public static final int EXTENSION1_MIN;
    public int extension2;
    public static final int EXTENSION2_MIN;
    public int extension3;
    public static final int EXTENSION3_MIN;
    public int extension4;
    public static final int EXTENSION4_MIN;

    public SDS_RecognizerState_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public SDS_RecognizerState_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.inputLevel = 0;
        this.inputQuality = 0;
        this.extension1 = 0;
        this.extension2 = 0;
        this.extension3 = 0;
        this.extension4 = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SDS_RecognizerState_Status sDS_RecognizerState_Status = (SDS_RecognizerState_Status)bAPEntity;
        return this.inputLevel == sDS_RecognizerState_Status.inputLevel && this.inputQuality == sDS_RecognizerState_Status.inputQuality && this.extension1 == sDS_RecognizerState_Status.extension1 && this.extension2 == sDS_RecognizerState_Status.extension2 && this.extension3 == sDS_RecognizerState_Status.extension3 && this.extension4 == sDS_RecognizerState_Status.extension4;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "SDS_RecognizerState_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.inputLevel);
        bitStream.pushByte((byte)this.inputQuality);
        bitStream.pushByte((byte)this.extension1);
        bitStream.pushByte((byte)this.extension2);
        bitStream.pushByte((byte)this.extension3);
        bitStream.pushByte((byte)this.extension4);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.inputLevel = bitStream.popFrontByte();
        this.inputQuality = bitStream.popFrontByte();
        this.extension1 = bitStream.popFrontByte();
        this.extension2 = bitStream.popFrontByte();
        this.extension3 = bitStream.popFrontByte();
        this.extension4 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 53;
    }

    @Override
    public int getFunctionId() {
        return SDS_RecognizerState_Status.functionId();
    }
}

