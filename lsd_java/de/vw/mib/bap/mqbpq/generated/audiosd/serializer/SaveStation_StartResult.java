/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class SaveStation_StartResult
implements StartResultMethod {
    public int fsgHandle;
    public int audioSource;
    public static final int AUDIO_SOURCE_FM;
    public static final int AUDIO_SOURCE_AM;
    public static final int AUDIO_SOURCE_DAB;
    public static final int AUDIO_SOURCE_SDARS_XM;
    public static final int AUDIO_SOURCE_SDARS_SIRIUS;
    public static final int AUDIO_SOURCE_TV;
    public static final int AUDIO_SOURCE_HDD;
    public static final int AUDIO_SOURCE_PORTABLE_DEVICE_MDI;
    public static final int AUDIO_SOURCE_AM_TI;
    public int storeId;

    public SaveStation_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public SaveStation_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.fsgHandle = 0;
        this.audioSource = 0;
        this.storeId = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SaveStation_StartResult saveStation_StartResult = (SaveStation_StartResult)bAPEntity;
        return this.fsgHandle == saveStation_StartResult.fsgHandle && this.audioSource == saveStation_StartResult.audioSource && this.storeId == saveStation_StartResult.storeId;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "SaveStation_StartResult:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.fsgHandle = bitStream.popFrontShort();
        this.audioSource = bitStream.popFrontByte();
        this.storeId = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 32;
    }

    @Override
    public int getFunctionId() {
        return SaveStation_StartResult.functionId();
    }
}

