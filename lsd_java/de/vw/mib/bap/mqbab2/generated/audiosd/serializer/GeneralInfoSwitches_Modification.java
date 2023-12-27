/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class GeneralInfoSwitches_Modification
implements BAPEntity {
    private static final int RESERVED_BIT_6__7_BITSIZE;
    public boolean onlineTrafficCanBeModifiedDf4_1;
    public boolean vicsOnOffCanBeModified;
    public boolean tmcOnOffCanBeModfied;
    public boolean jpTrafficOnOffCanBeModified;
    public boolean rdsOnOffCanBeModified;
    public boolean tpTaOnCanBeModified;

    public GeneralInfoSwitches_Modification() {
        this.internalReset();
        this.customInitialization();
    }

    public GeneralInfoSwitches_Modification(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.onlineTrafficCanBeModifiedDf4_1 = false;
        this.vicsOnOffCanBeModified = false;
        this.tmcOnOffCanBeModfied = false;
        this.jpTrafficOnOffCanBeModified = false;
        this.rdsOnOffCanBeModified = false;
        this.tpTaOnCanBeModified = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        GeneralInfoSwitches_Modification generalInfoSwitches_Modification = (GeneralInfoSwitches_Modification)bAPEntity;
        return this.onlineTrafficCanBeModifiedDf4_1 == generalInfoSwitches_Modification.onlineTrafficCanBeModifiedDf4_1 && this.vicsOnOffCanBeModified == generalInfoSwitches_Modification.vicsOnOffCanBeModified && this.tmcOnOffCanBeModfied == generalInfoSwitches_Modification.tmcOnOffCanBeModfied && this.jpTrafficOnOffCanBeModified == generalInfoSwitches_Modification.jpTrafficOnOffCanBeModified && this.rdsOnOffCanBeModified == generalInfoSwitches_Modification.rdsOnOffCanBeModified && this.tpTaOnCanBeModified == generalInfoSwitches_Modification.tpTaOnCanBeModified;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "GeneralInfoSwitches_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(2);
        bitStream.pushBoolean(this.onlineTrafficCanBeModifiedDf4_1);
        bitStream.pushBoolean(this.vicsOnOffCanBeModified);
        bitStream.pushBoolean(this.tmcOnOffCanBeModfied);
        bitStream.pushBoolean(this.jpTrafficOnOffCanBeModified);
        bitStream.pushBoolean(this.rdsOnOffCanBeModified);
        bitStream.pushBoolean(this.tpTaOnCanBeModified);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(2);
        this.onlineTrafficCanBeModifiedDf4_1 = bitStream.popFrontBoolean();
        this.vicsOnOffCanBeModified = bitStream.popFrontBoolean();
        this.tmcOnOffCanBeModfied = bitStream.popFrontBoolean();
        this.jpTrafficOnOffCanBeModified = bitStream.popFrontBoolean();
        this.rdsOnOffCanBeModified = bitStream.popFrontBoolean();
        this.tpTaOnCanBeModified = bitStream.popFrontBoolean();
    }
}

