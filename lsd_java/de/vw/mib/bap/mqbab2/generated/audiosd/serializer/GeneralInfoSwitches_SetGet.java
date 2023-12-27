/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.GeneralInfoSwitches_OnOffSwitches;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class GeneralInfoSwitches_SetGet
implements SetGetProperty {
    public GeneralInfoSwitches_OnOffSwitches onOffSwitches = new GeneralInfoSwitches_OnOffSwitches();
    public int reserve1;
    public static final int RESERVE1_MIN;

    public GeneralInfoSwitches_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public GeneralInfoSwitches_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserve1 = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.onOffSwitches.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        GeneralInfoSwitches_SetGet generalInfoSwitches_SetGet = (GeneralInfoSwitches_SetGet)bAPEntity;
        return this.onOffSwitches.equalTo(generalInfoSwitches_SetGet.onOffSwitches) && this.reserve1 == generalInfoSwitches_SetGet.reserve1;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "GeneralInfoSwitches_SetGet:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.onOffSwitches.serialize(bitStream);
        bitStream.pushByte((byte)this.reserve1);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.onOffSwitches.deserialize(bitStream);
        this.reserve1 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 25;
    }

    @Override
    public int getFunctionId() {
        return GeneralInfoSwitches_SetGet.functionId();
    }
}

