/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.light.arrays.asgarrays;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public abstract class ASGArrayListElementAdapter
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    private int pos;

    protected ASGArrayListElementAdapter() {
        this.arrayHeader = new ArrayHeader();
    }

    protected ASGArrayListElementAdapter(ArrayHeader arrayHeader, int n) {
        this.arrayHeader = arrayHeader;
        this.pos = n;
    }

    @Override
    public void reset() {
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        return false;
    }

    @Override
    public int getPos() {
        return this.pos;
    }

    @Override
    public void setPos(int n) {
        this.pos = n;
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
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }
}

