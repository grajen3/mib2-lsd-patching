/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.audiosd.serializer;

import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class InfoList_GetArray
implements BAPGetArray {
    private ArrayHeader arrayHeader = new ArrayHeader();

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    public InfoList_GetArray() {
        this.internalReset();
        this.customInitialization();
    }

    public InfoList_GetArray(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        InfoList_GetArray infoList_GetArray = (InfoList_GetArray)bAPEntity;
        return this.arrayHeader.equalTo(infoList_GetArray.arrayHeader);
    }

    @Override
    public int getAsgId() {
        throw new UnsupportedOperationException("This operation is not supported in InfoList_GetArray");
    }

    @Override
    public void setAsgId(int n) {
        throw new UnsupportedOperationException("This operation is not supported in InfoList_GetArray");
    }

    @Override
    public int getTransactionId() {
        throw new UnsupportedOperationException("This operation is not supported in InfoList_GetArray");
    }

    @Override
    public void setTransactionId(int n) {
        throw new UnsupportedOperationException("This operation is not supported in InfoList_GetArray");
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "InfoList_GetArray:";
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
        this.arrayHeader.deserialize(bitStream);
    }

    public static int functionId() {
        return 22;
    }

    @Override
    public int getFunctionId() {
        return InfoList_GetArray.functionId();
    }
}

