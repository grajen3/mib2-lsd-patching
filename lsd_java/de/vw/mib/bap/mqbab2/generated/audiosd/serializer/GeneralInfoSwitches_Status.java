/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.GeneralInfoSwitches_Modification;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.GeneralInfoSwitches_OnOffSwitches;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class GeneralInfoSwitches_Status
implements StatusProperty {
    public GeneralInfoSwitches_OnOffSwitches onOffSwitches = new GeneralInfoSwitches_OnOffSwitches();
    public GeneralInfoSwitches_Modification modification = new GeneralInfoSwitches_Modification();

    public GeneralInfoSwitches_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public GeneralInfoSwitches_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.onOffSwitches.reset();
        this.modification.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        GeneralInfoSwitches_Status generalInfoSwitches_Status = (GeneralInfoSwitches_Status)bAPEntity;
        return this.onOffSwitches.equalTo(generalInfoSwitches_Status.onOffSwitches) && this.modification.equalTo(generalInfoSwitches_Status.modification);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "GeneralInfoSwitches_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.onOffSwitches.serialize(bitStream);
        this.modification.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.onOffSwitches.deserialize(bitStream);
        this.modification.deserialize(bitStream);
    }

    public static int functionId() {
        return 25;
    }

    @Override
    public int getFunctionId() {
        return GeneralInfoSwitches_Status.functionId();
    }
}

