/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.asl.internal.ocu.generated.eni.serializer.OnlineUpdateState_Deprecated_UpdateDomain0;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class OnlineUpdateState_Deprecated_UpdateDomain
implements BAPEntity {
    public OnlineUpdateState_Deprecated_UpdateDomain0 updateDomain0 = new OnlineUpdateState_Deprecated_UpdateDomain0();
    public static final int UPDATE_DOMAIN1_MIN;
    public int updateDomain1;
    public static final int UPDATE_DOMAIN2_MIN;
    public int updateDomain2;
    public static final int UPDATE_DOMAIN3_MIN;
    public int updateDomain3;

    public OnlineUpdateState_Deprecated_UpdateDomain() {
        this.internalReset();
        this.customInitialization();
    }

    public OnlineUpdateState_Deprecated_UpdateDomain(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.updateDomain1 = 0;
        this.updateDomain2 = 0;
        this.updateDomain3 = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.updateDomain0.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        OnlineUpdateState_Deprecated_UpdateDomain onlineUpdateState_Deprecated_UpdateDomain = (OnlineUpdateState_Deprecated_UpdateDomain)bAPEntity;
        return this.updateDomain0.equalTo(onlineUpdateState_Deprecated_UpdateDomain.updateDomain0) && this.updateDomain1 == onlineUpdateState_Deprecated_UpdateDomain.updateDomain1 && this.updateDomain2 == onlineUpdateState_Deprecated_UpdateDomain.updateDomain2 && this.updateDomain3 == onlineUpdateState_Deprecated_UpdateDomain.updateDomain3;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "OnlineUpdateState_Deprecated_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.updateDomain0.serialize(bitStream);
        bitStream.pushByte((byte)this.updateDomain1);
        bitStream.pushByte((byte)this.updateDomain2);
        bitStream.pushByte((byte)this.updateDomain3);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.updateDomain0.deserialize(bitStream);
        this.updateDomain1 = bitStream.popFrontByte();
        this.updateDomain2 = bitStream.popFrontByte();
        this.updateDomain3 = bitStream.popFrontByte();
    }
}

