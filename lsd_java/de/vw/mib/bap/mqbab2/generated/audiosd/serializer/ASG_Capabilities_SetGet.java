/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.ASG_Capabilities_PresentationCapabilities;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class ASG_Capabilities_SetGet
implements SetGetProperty {
    public ASG_Capabilities_PresentationCapabilities presentationCapabilities = new ASG_Capabilities_PresentationCapabilities();

    public ASG_Capabilities_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public ASG_Capabilities_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.presentationCapabilities.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ASG_Capabilities_SetGet aSG_Capabilities_SetGet = (ASG_Capabilities_SetGet)bAPEntity;
        return this.presentationCapabilities.equalTo(aSG_Capabilities_SetGet.presentationCapabilities);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ASG_Capabilities_SetGet:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.presentationCapabilities.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.presentationCapabilities.deserialize(bitStream);
    }

    public static int functionId() {
        return 43;
    }

    @Override
    public int getFunctionId() {
        return ASG_Capabilities_SetGet.functionId();
    }
}

