/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.ReceptionList_Data;
import de.vw.mib.bap.stream.BitStream;

public final class ReceptionList_ChangedArray
implements BAPChangedArray {
    public int elementType;
    public static final int ELEMENT_TYPE_FLAT_LIST_PRIMARY_SERVICES_ONLY;
    public static final int ELEMENT_TYPE_FLAT_LIST_PRIMARY_AND_SECONDARY_SERVICES;
    public static final int ELEMENT_TYPE_FLAT_LIST_ENSEMBLES_PRIMARY_SERVICES_AND_SECONDARY_SERVICES;
    public static final int ELEMENT_TYPE_SECONDARY_AND_PRIMARY_SERVICES;
    public static final int ELEMENT_TYPE_PRIMARY_SERVICES_ONLY;
    public static final int ELEMENT_TYPE_ENSEMBLES;
    public int parent_Id;
    public static final int PARENT_ID_MIN;
    public ArrayHeader arrayHeader = new ArrayHeader();
    private static final int MAX_DATA_ELEMENTS;
    public BAPArrayData data = new BAPArrayData(-65536, this.arrayHeader);

    @Override
    public BAPArrayElement createArrayElement() {
        return new ReceptionList_Data(this.getArrayHeader());
    }

    public ReceptionList_ChangedArray() {
        this.internalReset();
        this.customInitialization();
    }

    public ReceptionList_ChangedArray(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.elementType = 0;
        this.parent_Id = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.data.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ReceptionList_ChangedArray receptionList_ChangedArray = (ReceptionList_ChangedArray)bAPEntity;
        return this.elementType == receptionList_ChangedArray.elementType && this.parent_Id == receptionList_ChangedArray.parent_Id && this.arrayHeader.equalTo(receptionList_ChangedArray.arrayHeader) && this.data.equalTo(receptionList_ChangedArray.data);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ReceptionList_ChangedArray:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.elementType);
        bitStream.pushShort((short)this.parent_Id);
        this.arrayHeader.serialize(bitStream);
        this.data.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.elementType = bitStream.popFrontByte();
        this.parent_Id = bitStream.popFrontShort();
        this.arrayHeader.deserialize(bitStream);
        this.arrayHeader.evaluateRecordAddressPosForChangedArray();
        this.data.reset();
        if (!this.arrayHeader.isFullRangeUpdate()) {
            int n = this.arrayHeader.getNumberOfElements();
            for (int i2 = 0; i2 < n; ++i2) {
                this.data.add(new ReceptionList_Data(bitStream, this.arrayHeader));
            }
        }
    }

    public static int functionId() {
        return 23;
    }

    @Override
    public int getFunctionId() {
        return ReceptionList_ChangedArray.functionId();
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
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }
}

