/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class Last_ActiveSource_Status
implements StatusProperty {
    public int sourceList_Reference;
    public static final int SOURCE_LIST_REFERENCE_MIN;
    public int extension1;
    public static final int EXTENSION1_MIN;
    public int extension2;
    public static final int EXTENSION2_MIN;
    public int extension3;
    public static final int EXTENSION3_MIN;
    public int extension4;
    public static final int EXTENSION4_MIN;

    public Last_ActiveSource_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public Last_ActiveSource_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.sourceList_Reference = 0;
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
        Last_ActiveSource_Status last_ActiveSource_Status = (Last_ActiveSource_Status)bAPEntity;
        return this.sourceList_Reference == last_ActiveSource_Status.sourceList_Reference && this.extension1 == last_ActiveSource_Status.extension1 && this.extension2 == last_ActiveSource_Status.extension2 && this.extension3 == last_ActiveSource_Status.extension3 && this.extension4 == last_ActiveSource_Status.extension4;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "Last_ActiveSource_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushShort((short)this.sourceList_Reference);
        bitStream.pushByte((byte)this.extension1);
        bitStream.pushByte((byte)this.extension2);
        bitStream.pushByte((byte)this.extension3);
        bitStream.pushByte((byte)this.extension4);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.sourceList_Reference = bitStream.popFrontShort();
        this.extension1 = bitStream.popFrontByte();
        this.extension2 = bitStream.popFrontByte();
        this.extension3 = bitStream.popFrontByte();
        this.extension4 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 55;
    }

    @Override
    public int getFunctionId() {
        return Last_ActiveSource_Status.functionId();
    }
}

