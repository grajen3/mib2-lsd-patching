/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.ReceivedCalls_Data;
import de.vw.mib.bap.stream.BitStream;

public final class ReceivedCalls_ChangedArray
implements BAPChangedArray {
    private ArrayHeader arrayHeader = new ArrayHeader();
    private BAPArrayData data = new BAPArrayData(60);
    private static final int MAX_DATA_ELEMENTS;

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    @Override
    public void setArrayData(BAPArrayData bAPArrayData) {
        this.data = bAPArrayData;
    }

    @Override
    public BAPArrayData getArrayData() {
        return this.data;
    }

    @Override
    public BAPArrayElement createArrayElement() {
        return new ReceivedCalls_Data(this.getArrayHeader());
    }

    public ReceivedCalls_ChangedArray() {
        this.internalReset();
        this.customInitialization();
    }

    public ReceivedCalls_ChangedArray(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.data.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ReceivedCalls_ChangedArray receivedCalls_ChangedArray = (ReceivedCalls_ChangedArray)bAPEntity;
        return this.arrayHeader.equalTo(receivedCalls_ChangedArray.arrayHeader) && this.data.equalTo(receivedCalls_ChangedArray.data);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ReceivedCalls_ChangedArray:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.arrayHeader.serialize(bitStream);
        this.data.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 47;
    }

    @Override
    public int getFunctionId() {
        return ReceivedCalls_ChangedArray.functionId();
    }
}

