/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class CurrentStation_Handle_Status
implements StatusProperty {
    public int fsgHandle;
    public static final int FSG_HANDLE_MIN;
    public int fsgHandle_absolutePosition;
    public static final int FSG_HANDLE_ABSOLUTE_POSITION_MIN;
    public int presetList_Ref;
    public static final int PRESET_LIST_REF_MIN;
    public int presetList_absolutePosition;
    public static final int PRESET_LIST_ABSOLUTE_POSITION_MIN;
    public int dab_EnsembleHandle;
    public static final int DAB_ENSEMBLE_HANDLE_MIN;
    public int dab_Ensemble_absolutePosition;
    public static final int DAB_ENSEMBLE_ABSOLUTE_POSITION_MIN;

    public CurrentStation_Handle_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public CurrentStation_Handle_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.fsgHandle = 0;
        this.fsgHandle_absolutePosition = 0;
        this.presetList_Ref = 0;
        this.presetList_absolutePosition = 0;
        this.dab_EnsembleHandle = 0;
        this.dab_Ensemble_absolutePosition = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CurrentStation_Handle_Status currentStation_Handle_Status = (CurrentStation_Handle_Status)bAPEntity;
        return this.fsgHandle == currentStation_Handle_Status.fsgHandle && this.fsgHandle_absolutePosition == currentStation_Handle_Status.fsgHandle_absolutePosition && this.presetList_Ref == currentStation_Handle_Status.presetList_Ref && this.presetList_absolutePosition == currentStation_Handle_Status.presetList_absolutePosition && this.dab_EnsembleHandle == currentStation_Handle_Status.dab_EnsembleHandle && this.dab_Ensemble_absolutePosition == currentStation_Handle_Status.dab_Ensemble_absolutePosition;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "CurrentStation_Handle_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushShort((short)this.fsgHandle);
        bitStream.pushShort((short)this.fsgHandle_absolutePosition);
        bitStream.pushByte((byte)this.presetList_Ref);
        bitStream.pushByte((byte)this.presetList_absolutePosition);
        bitStream.pushShort((short)this.dab_EnsembleHandle);
        bitStream.pushShort((short)this.dab_Ensemble_absolutePosition);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.fsgHandle = bitStream.popFrontShort();
        this.fsgHandle_absolutePosition = bitStream.popFrontShort();
        this.presetList_Ref = bitStream.popFrontByte();
        this.presetList_absolutePosition = bitStream.popFrontByte();
        this.dab_EnsembleHandle = bitStream.popFrontShort();
        this.dab_Ensemble_absolutePosition = bitStream.popFrontShort();
    }

    public static int functionId() {
        return 22;
    }

    @Override
    public int getFunctionId() {
        return CurrentStation_Handle_Status.functionId();
    }
}

