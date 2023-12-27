/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.Mute_MuteState;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class Mute_SetGet
implements SetGetProperty {
    public Mute_MuteState muteState = new Mute_MuteState();

    public Mute_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public Mute_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.muteState.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        Mute_SetGet mute_SetGet = (Mute_SetGet)bAPEntity;
        return this.muteState.equalTo(mute_SetGet.muteState);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "Mute_SetGet:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.muteState.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.muteState.deserialize(bitStream);
    }

    public static int functionId() {
        return 19;
    }

    @Override
    public int getFunctionId() {
        return Mute_SetGet.functionId();
    }
}

