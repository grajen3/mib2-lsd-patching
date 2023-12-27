/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.framework.arrays;

import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

final class GenericStatusArray
implements BAPStatusArray {
    private static final int MAX_ARRAY_DATA_ELEMENTS;
    private BAPArrayData _arrrayData;
    private ArrayHeader _arrayHeader;
    private int _asgId;
    private int _transactionId;
    private int _numberOfElements;
    private boolean _broadcast;

    GenericStatusArray() {
    }

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this._arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        if (this._arrayHeader == null) {
            this._arrayHeader = new ArrayHeader();
        }
        return this._arrayHeader;
    }

    @Override
    public void reset() {
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        return false;
    }

    @Override
    public void serialize(BitStream bitStream) {
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public int getAsgId() {
        return this._asgId;
    }

    @Override
    public void setAsgId(int n) {
        this._asgId = n;
    }

    @Override
    public boolean isBroadcast() {
        return this._broadcast;
    }

    @Override
    public void setBroadcast(boolean bl) {
        this._broadcast = bl;
    }

    @Override
    public int getTransactionId() {
        return this._transactionId;
    }

    @Override
    public void setTransactionId(int n) {
        this._transactionId = n;
    }

    @Override
    public int getNumberOfElements() {
        return this._numberOfElements;
    }

    @Override
    public void setNumberOfElements(int n) {
        this._numberOfElements = n;
    }

    @Override
    public BAPArrayData getArrayData() {
        if (this._arrrayData == null) {
            this._arrrayData = new BAPArrayData(-65536);
        }
        return this._arrrayData;
    }

    @Override
    public void setArrayData(BAPArrayData bAPArrayData) {
        this._arrrayData = bAPArrayData;
    }

    @Override
    public BAPArrayElement createArrayElement() {
        return null;
    }

    @Override
    public int getFunctionId() {
        return 0;
    }
}

