/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.framework.arrays;

import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

class GenericGetArray
implements BAPGetArray {
    private ArrayHeader _arrayHeader;
    private int _asgId;
    private int _transactionId;

    GenericGetArray() {
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
    public int getTransactionId() {
        return this._transactionId;
    }

    @Override
    public void setTransactionId(int n) {
        this._transactionId = n;
    }

    @Override
    public int getFunctionId() {
        return 0;
    }
}

