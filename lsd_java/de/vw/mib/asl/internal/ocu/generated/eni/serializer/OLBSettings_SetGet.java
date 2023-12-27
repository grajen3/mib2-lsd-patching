/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.asl.internal.ocu.generated.eni.serializer.OLBSettings_Olb_Setup;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class OLBSettings_SetGet
implements SetGetProperty {
    public OLBSettings_Olb_Setup olb_Setup = new OLBSettings_Olb_Setup();
    public int reserve;
    public static final int RESERVE_MIN;
    public int extension1;
    public static final int EXTENSION1_MIN;
    public int extension2;
    public static final int EXTENSION2_MIN;
    public int extension3;
    public static final int EXTENSION3_MIN;
    public int extension4;
    public static final int EXTENSION4_MIN;

    public OLBSettings_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public OLBSettings_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserve = 0;
        this.extension1 = 0;
        this.extension2 = 0;
        this.extension3 = 0;
        this.extension4 = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.olb_Setup.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        OLBSettings_SetGet oLBSettings_SetGet = (OLBSettings_SetGet)bAPEntity;
        return this.olb_Setup.equalTo(oLBSettings_SetGet.olb_Setup) && this.reserve == oLBSettings_SetGet.reserve && this.extension1 == oLBSettings_SetGet.extension1 && this.extension2 == oLBSettings_SetGet.extension2 && this.extension3 == oLBSettings_SetGet.extension3 && this.extension4 == oLBSettings_SetGet.extension4;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "OLBSettings_SetGet:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.olb_Setup.serialize(bitStream);
        bitStream.pushByte((byte)this.reserve);
        bitStream.pushByte((byte)this.extension1);
        bitStream.pushByte((byte)this.extension2);
        bitStream.pushByte((byte)this.extension3);
        bitStream.pushByte((byte)this.extension4);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.olb_Setup.deserialize(bitStream);
        this.reserve = bitStream.popFrontByte();
        this.extension1 = bitStream.popFrontByte();
        this.extension2 = bitStream.popFrontByte();
        this.extension3 = bitStream.popFrontByte();
        this.extension4 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 34;
    }

    @Override
    public int getFunctionId() {
        return OLBSettings_SetGet.functionId();
    }
}

