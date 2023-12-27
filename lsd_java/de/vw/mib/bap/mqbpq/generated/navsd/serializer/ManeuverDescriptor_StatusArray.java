/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.navsd.serializer;

import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbpq.generated.navsd.serializer.ManeuverDescriptor_ManeuverDescription;
import de.vw.mib.bap.stream.BitStream;

public final class ManeuverDescriptor_StatusArray
implements BAPStatusArray {
    private ArrayHeader arrayHeader = new ArrayHeader();
    private BAPArrayData maneuverDescription = new BAPArrayData(3);
    private static final int MAX_MANEUVER_DESCRIPTION_ELEMENTS;

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
        this.maneuverDescription = bAPArrayData;
    }

    @Override
    public BAPArrayData getArrayData() {
        return this.maneuverDescription;
    }

    @Override
    public BAPArrayElement createArrayElement() {
        return new ManeuverDescriptor_ManeuverDescription(this.getArrayHeader());
    }

    public ManeuverDescriptor_StatusArray() {
        this.internalReset();
        this.customInitialization();
    }

    public ManeuverDescriptor_StatusArray(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.maneuverDescription.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ManeuverDescriptor_StatusArray maneuverDescriptor_StatusArray = (ManeuverDescriptor_StatusArray)bAPEntity;
        return this.arrayHeader.equalTo(maneuverDescriptor_StatusArray.arrayHeader) && this.maneuverDescription.equalTo(maneuverDescriptor_StatusArray.maneuverDescription);
    }

    @Override
    public int getAsgId() {
        throw new UnsupportedOperationException("This operation is not supported in ManeuverDescriptor_StatusArray");
    }

    @Override
    public void setAsgId(int n) {
        throw new UnsupportedOperationException("This operation is not supported in ManeuverDescriptor_StatusArray");
    }

    @Override
    public boolean isBroadcast() {
        throw new UnsupportedOperationException("This operation is not supported in ManeuverDescriptor_StatusArray");
    }

    @Override
    public void setBroadcast(boolean bl) {
        throw new UnsupportedOperationException("This operation is not supported in ManeuverDescriptor_StatusArray");
    }

    @Override
    public int getTransactionId() {
        throw new UnsupportedOperationException("This operation is not supported in ManeuverDescriptor_StatusArray");
    }

    @Override
    public void setTransactionId(int n) {
        throw new UnsupportedOperationException("This operation is not supported in ManeuverDescriptor_StatusArray");
    }

    @Override
    public int getNumberOfElements() {
        throw new UnsupportedOperationException("This operation is not supported in ManeuverDescriptor_StatusArray");
    }

    @Override
    public void setNumberOfElements(int n) {
        throw new UnsupportedOperationException("This operation is not supported in ManeuverDescriptor_StatusArray");
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ManeuverDescriptor_StatusArray:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.arrayHeader.serialize(bitStream);
        this.maneuverDescription.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 22;
    }

    @Override
    public int getFunctionId() {
        return ManeuverDescriptor_StatusArray.functionId();
    }
}

