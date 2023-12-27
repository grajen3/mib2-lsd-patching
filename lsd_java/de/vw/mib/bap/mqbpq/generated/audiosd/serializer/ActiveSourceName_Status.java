/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class ActiveSourceName_Status
implements StatusProperty {
    public final BAPString sourceName = new BAPString(49);
    private static final int MAX_SOURCE_NAME_LENGTH;

    public ActiveSourceName_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public ActiveSourceName_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.sourceName.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ActiveSourceName_Status activeSourceName_Status = (ActiveSourceName_Status)bAPEntity;
        return this.sourceName.equalTo(activeSourceName_Status.sourceName);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ActiveSourceName_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.sourceName.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 17;
    }

    @Override
    public int getFunctionId() {
        return ActiveSourceName_Status.functionId();
    }
}

