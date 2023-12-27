/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.navsd.serializer;

import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class ManeuverDescriptor_ChangedArray
implements BAPChangedArray {
    private ArrayHeader arrayHeader = new ArrayHeader();

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    public ManeuverDescriptor_ChangedArray() {
        this.internalReset();
        this.customInitialization();
    }

    public ManeuverDescriptor_ChangedArray(BitStream bitStream) {
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
        ManeuverDescriptor_ChangedArray maneuverDescriptor_ChangedArray = (ManeuverDescriptor_ChangedArray)bAPEntity;
        return this.arrayHeader.equalTo(maneuverDescriptor_ChangedArray.arrayHeader);
    }

    @Override
    public void setArrayData(BAPArrayData bAPArrayData) {
        throw new UnsupportedOperationException("This operation is not supported in ManeuverDescriptor_ChangedArray");
    }

    @Override
    public BAPArrayData getArrayData() {
        throw new UnsupportedOperationException("This operation is not supported in ManeuverDescriptor_ChangedArray");
    }

    @Override
    public BAPArrayElement createArrayElement() {
        throw new UnsupportedOperationException("This operation is not supported in ManeuverDescriptor_ChangedArray");
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ManeuverDescriptor_ChangedArray:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.arrayHeader.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 22;
    }

    @Override
    public int getFunctionId() {
        return ManeuverDescriptor_ChangedArray.functionId();
    }
}

