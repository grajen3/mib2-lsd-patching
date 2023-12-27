/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.datatypes;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class ArrayHeader$Mode
implements BAPEntity {
    public boolean indexSize16BitForStartElements;
    public boolean arrayPositionIsTransmitted;
    public boolean arrayDirectionIsBackward;
    public boolean shift;
    private static final int MODE_BITSIZE;

    public boolean is16BitsIndexSize() {
        return this.indexSize16BitForStartElements;
    }

    public ArrayHeader$Mode() {
        this.internalReset();
    }

    public ArrayHeader$Mode(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.indexSize16BitForStartElements = false;
        this.arrayPositionIsTransmitted = false;
        this.arrayDirectionIsBackward = false;
        this.shift = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ArrayHeader$Mode arrayHeader$Mode = (ArrayHeader$Mode)bAPEntity;
        return this.indexSize16BitForStartElements == arrayHeader$Mode.indexSize16BitForStartElements && this.arrayPositionIsTransmitted == arrayHeader$Mode.arrayPositionIsTransmitted && this.arrayDirectionIsBackward == arrayHeader$Mode.arrayDirectionIsBackward && this.shift == arrayHeader$Mode.shift;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Mode:");
        stringBuffer.append("\n - Bit 3: ");
        if (this.indexSize16BitForStartElements) {
            stringBuffer.append("true  (IndexSize 16 Bit for Start/Elements");
        } else {
            stringBuffer.append("false  (IndexSize 8 Bit for Start/Elements");
        }
        stringBuffer.append("\n - Bit 2: ");
        if (this.arrayPositionIsTransmitted) {
            stringBuffer.append("true  (Array position is transmitted");
        } else {
            stringBuffer.append("false  (Array position is not transmitted");
        }
        stringBuffer.append("\n - Bit 1: ");
        if (this.arrayDirectionIsBackward) {
            stringBuffer.append("true  (Array direction is backward");
        } else {
            stringBuffer.append("false  (Array direction is forward");
        }
        stringBuffer.append("\n - Bit 0: ");
        if (this.shift) {
            stringBuffer.append("true  (Shift");
        } else {
            stringBuffer.append("false  (Shift");
        }
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        return n += 4;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.indexSize16BitForStartElements);
        bitStream.pushBoolean(this.arrayPositionIsTransmitted);
        bitStream.pushBoolean(this.arrayDirectionIsBackward);
        bitStream.pushBoolean(this.shift);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.indexSize16BitForStartElements = bitStream.popFrontBoolean();
        this.arrayPositionIsTransmitted = bitStream.popFrontBoolean();
        this.arrayDirectionIsBackward = bitStream.popFrontBoolean();
        this.shift = bitStream.popFrontBoolean();
    }

    public void copy(ArrayHeader$Mode arrayHeader$Mode) {
        this.arrayDirectionIsBackward = arrayHeader$Mode.arrayDirectionIsBackward;
        this.arrayPositionIsTransmitted = arrayHeader$Mode.arrayPositionIsTransmitted;
        this.indexSize16BitForStartElements = arrayHeader$Mode.indexSize16BitForStartElements;
        this.shift = arrayHeader$Mode.shift;
    }
}

