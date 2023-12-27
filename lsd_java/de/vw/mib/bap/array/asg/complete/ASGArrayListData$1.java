/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.array.asg.complete;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

final class ASGArrayListData$1
implements BAPArrayElement {
    ASGArrayListData$1() {
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
    public void reset() {
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        return false;
    }

    @Override
    public void setPos(int n) {
    }

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
    }

    @Override
    public int getPos() {
        return 0;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return null;
    }
}

