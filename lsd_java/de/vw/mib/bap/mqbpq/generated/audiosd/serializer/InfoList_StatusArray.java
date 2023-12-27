/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.audiosd.serializer;

import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.InfoList_Data;
import de.vw.mib.bap.stream.BitStream;

public final class InfoList_StatusArray
implements BAPStatusArray {
    public int totalNumListElements;
    private ArrayHeader arrayHeader = new ArrayHeader();
    private BAPArrayData data = new BAPArrayData(6);
    private static final int MAX_DATA_ELEMENTS;

    @Override
    public int getNumberOfElements() {
        return this.totalNumListElements;
    }

    @Override
    public void setNumberOfElements(int n) {
        this.totalNumListElements = n;
    }

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
        return new InfoList_Data(this.getArrayHeader());
    }

    public InfoList_StatusArray() {
        this.internalReset();
        this.customInitialization();
    }

    public InfoList_StatusArray(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.totalNumListElements = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.data.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        InfoList_StatusArray infoList_StatusArray = (InfoList_StatusArray)bAPEntity;
        return this.totalNumListElements == infoList_StatusArray.totalNumListElements && this.arrayHeader.equalTo(infoList_StatusArray.arrayHeader) && this.data.equalTo(infoList_StatusArray.data);
    }

    @Override
    public int getAsgId() {
        throw new UnsupportedOperationException("This operation is not supported in InfoList_StatusArray");
    }

    @Override
    public void setAsgId(int n) {
        throw new UnsupportedOperationException("This operation is not supported in InfoList_StatusArray");
    }

    @Override
    public boolean isBroadcast() {
        throw new UnsupportedOperationException("This operation is not supported in InfoList_StatusArray");
    }

    @Override
    public void setBroadcast(boolean bl) {
        throw new UnsupportedOperationException("This operation is not supported in InfoList_StatusArray");
    }

    @Override
    public int getTransactionId() {
        throw new UnsupportedOperationException("This operation is not supported in InfoList_StatusArray");
    }

    @Override
    public void setTransactionId(int n) {
        throw new UnsupportedOperationException("This operation is not supported in LaneGuidance_StatusArray");
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "InfoList_StatusArray:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushShort((short)this.totalNumListElements);
        this.arrayHeader.serialize(bitStream);
        this.data.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 22;
    }

    @Override
    public int getFunctionId() {
        return InfoList_StatusArray.functionId();
    }
}

