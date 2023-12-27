/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone2.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_Setup_Status
implements StatusProperty {
    public static final int EXTENSION_1_MIN;
    public int extension_1;
    public static final int EXTENSION_2_MIN;
    public int extension_2;
    public static final int EXTENSION_3_MIN;
    public int extension_3;
    public static final int EXTENSION_4_MIN;
    public int extension_4;
    public static final int EXTENSION_5_MIN;
    public int extension_5;
    public static final int EXTENSION_6_MIN;
    public int extension_6;

    public FSG_Setup_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_Setup_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.extension_1 = 0;
        this.extension_2 = 0;
        this.extension_3 = 0;
        this.extension_4 = 0;
        this.extension_5 = 0;
        this.extension_6 = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_Setup_Status fSG_Setup_Status = (FSG_Setup_Status)bAPEntity;
        return this.extension_1 == fSG_Setup_Status.extension_1 && this.extension_2 == fSG_Setup_Status.extension_2 && this.extension_3 == fSG_Setup_Status.extension_3 && this.extension_4 == fSG_Setup_Status.extension_4 && this.extension_5 == fSG_Setup_Status.extension_5 && this.extension_6 == fSG_Setup_Status.extension_6;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "FSG_Setup_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.extension_1);
        bitStream.pushByte((byte)this.extension_2);
        bitStream.pushByte((byte)this.extension_3);
        bitStream.pushByte((byte)this.extension_4);
        bitStream.pushByte((byte)this.extension_5);
        bitStream.pushByte((byte)this.extension_6);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 14;
    }

    @Override
    public int getFunctionId() {
        return FSG_Setup_Status.functionId();
    }
}

