/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class GeneralInfoSwitches_OnOffSwitches
implements BAPEntity {
    private static final int RESERVED_BIT_4__7_BITSIZE;
    public boolean tmcOn;
    public boolean jpTrafficOn;
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
        this.tmcOn = false;
        this.jpTrafficOn = false;
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
        return this.tmcOn == generalInfoSwitches_OnOffSwitches.tmcOn && this.jpTrafficOn == generalInfoSwitches_OnOffSwitches.jpTrafficOn && this.rdsOn == generalInfoSwitches_OnOffSwitches.rdsOn && this.tpTaOn == generalInfoSwitches_OnOffSwitches.tpTaOn;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "GeneralInfoSwitches_OnOffSwitches:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(4);
        bitStream.pushBoolean(this.tmcOn);
        bitStream.pushBoolean(this.jpTrafficOn);
        bitStream.pushBoolean(this.rdsOn);
        bitStream.pushBoolean(this.tpTaOn);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(4);
        this.tmcOn = bitStream.popFrontBoolean();
        this.jpTrafficOn = bitStream.popFrontBoolean();
        this.rdsOn = bitStream.popFrontBoolean();
        this.tpTaOn = bitStream.popFrontBoolean();
    }
}

