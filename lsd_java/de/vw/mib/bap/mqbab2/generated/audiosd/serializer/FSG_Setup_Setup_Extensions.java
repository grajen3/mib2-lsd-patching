/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_Setup_Setup_Extensions
implements BAPEntity {
    private static final int RESERVED_BIT_2__7_BITSIZE;
    public boolean commonListIsAutomaticallyUpdatedDf4_1;
    public boolean dabServiceSortedList;

    public FSG_Setup_Setup_Extensions() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_Setup_Setup_Extensions(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.commonListIsAutomaticallyUpdatedDf4_1 = false;
        this.dabServiceSortedList = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_Setup_Setup_Extensions fSG_Setup_Setup_Extensions = (FSG_Setup_Setup_Extensions)bAPEntity;
        return this.commonListIsAutomaticallyUpdatedDf4_1 == fSG_Setup_Setup_Extensions.commonListIsAutomaticallyUpdatedDf4_1 && this.dabServiceSortedList == fSG_Setup_Setup_Extensions.dabServiceSortedList;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "FSG_Setup_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(6);
        bitStream.pushBoolean(this.commonListIsAutomaticallyUpdatedDf4_1);
        bitStream.pushBoolean(this.dabServiceSortedList);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(6);
        this.commonListIsAutomaticallyUpdatedDf4_1 = bitStream.popFrontBoolean();
        this.dabServiceSortedList = bitStream.popFrontBoolean();
    }
}

