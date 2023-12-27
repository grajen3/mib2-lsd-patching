/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class GeneralInfoSwitches_OnOffSwitches
implements BAPEntity {
    private static final int RESERVED_BIT_6__7_BITSIZE;
    public boolean onlineTrafficOnDf4_1;
    public boolean vicsOn;
    public boolean tmcOn;
    public boolean jpTrafficOnDynamic;
    public boolean rdsOn;
    public boolean tpTaOn;

    public GeneralInfoSwitches_OnOffSwitches() {
        this.internalReset();
        this.customInitialization();
    }

    public GeneralInfoSwitches_OnOffSwitches(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.onlineTrafficOnDf4_1 = false;
        this.vicsOn = false;
        this.tmcOn = false;
        this.jpTrafficOnDynamic = false;
        this.rdsOn = false;
        this.tpTaOn = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        GeneralInfoSwitches_OnOffSwitches generalInfoSwitches_OnOffSwitches = (GeneralInfoSwitches_OnOffSwitches)bAPEntity;
        return this.onlineTrafficOnDf4_1 == generalInfoSwitches_OnOffSwitches.onlineTrafficOnDf4_1 && this.vicsOn == generalInfoSwitches_OnOffSwitches.vicsOn && this.tmcOn == generalInfoSwitches_OnOffSwitches.tmcOn && this.jpTrafficOnDynamic == generalInfoSwitches_OnOffSwitches.jpTrafficOnDynamic && this.rdsOn == generalInfoSwitches_OnOffSwitches.rdsOn && this.tpTaOn == generalInfoSwitches_OnOffSwitches.tpTaOn;
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
        bitStream.pushBoolean(this.onlineTrafficOnDf4_1);
        bitStream.pushBoolean(this.vicsOn);
        bitStream.pushBoolean(this.tmcOn);
        bitStream.pushBoolean(this.jpTrafficOnDynamic);
        bitStream.pushBoolean(this.rdsOn);
        bitStream.pushBoolean(this.tpTaOn);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(2);
        this.onlineTrafficOnDf4_1 = bitStream.popFrontBoolean();
        this.vicsOn = bitStream.popFrontBoolean();
        this.tmcOn = bitStream.popFrontBoolean();
        this.jpTrafficOnDynamic = bitStream.popFrontBoolean();
        this.rdsOn = bitStream.popFrontBoolean();
        this.tpTaOn = bitStream.popFrontBoolean();
    }
}

