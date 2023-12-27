/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class DestinationList_ASGcapacity_Status
implements StatusProperty {
    public int asgcapacity;
    public static final int ASGCAPACITY_MIN;

    public DestinationList_ASGcapacity_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public DestinationList_ASGcapacity_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.asgcapacity = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        DestinationList_ASGcapacity_Status destinationList_ASGcapacity_Status = (DestinationList_ASGcapacity_Status)bAPEntity;
        return this.asgcapacity == destinationList_ASGcapacity_Status.asgcapacity;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "DestinationList_ASGcapacity_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushShort((short)this.asgcapacity);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.asgcapacity = bitStream.popFrontShort();
    }

    public static int functionId() {
        return 17;
    }

    @Override
    public int getFunctionId() {
        return DestinationList_ASGcapacity_Status.functionId();
    }
}

