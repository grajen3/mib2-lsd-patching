/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.HandsFreeOnOff_HandsFreeOnOff;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class HandsFreeOnOff_SetGet
implements SetGetProperty {
    public final HandsFreeOnOff_HandsFreeOnOff handsFreeOnOff = new HandsFreeOnOff_HandsFreeOnOff();

    public HandsFreeOnOff_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public HandsFreeOnOff_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.handsFreeOnOff.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        HandsFreeOnOff_SetGet handsFreeOnOff_SetGet = (HandsFreeOnOff_SetGet)bAPEntity;
        return this.handsFreeOnOff.equalTo(handsFreeOnOff_SetGet.handsFreeOnOff);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "HandsFreeOnOff_SetGet:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.handsFreeOnOff.deserialize(bitStream);
    }

    public static int functionId() {
        return 33;
    }

    @Override
    public int getFunctionId() {
        return HandsFreeOnOff_SetGet.functionId();
    }
}

