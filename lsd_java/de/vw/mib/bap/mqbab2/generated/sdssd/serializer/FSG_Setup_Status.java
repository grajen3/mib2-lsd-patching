/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.sdssd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.sdssd.serializer.FSG_Setup_Status$SetupValue;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_Setup_Status
implements StatusProperty {
    public final FSG_Setup_Status$SetupValue setupValue = new FSG_Setup_Status$SetupValue();
    public static final int EXTENSION1_MIN;
    public int extension1;
    public static final int EXTENSION2_MIN;
    public int extension2;
    public static final int EXTENSION3_MIN;
    public int extension3;
    public static final int EXTENSION4_MIN;
    public int extension4;
    public static final int EXTENSION5_MIN;
    public int extension5;

    public FSG_Setup_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_Setup_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.extension1 = 0;
        this.extension2 = 0;
        this.extension3 = 0;
        this.extension4 = 0;
        this.extension5 = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.setupValue.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_Setup_Status fSG_Setup_Status = (FSG_Setup_Status)bAPEntity;
        return this.setupValue.equalTo(fSG_Setup_Status.setupValue) && this.extension1 == fSG_Setup_Status.extension1 && this.extension2 == fSG_Setup_Status.extension2 && this.extension3 == fSG_Setup_Status.extension3 && this.extension4 == fSG_Setup_Status.extension4 && this.extension5 == fSG_Setup_Status.extension5;
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
        this.setupValue.serialize(bitStream);
        bitStream.pushByte((byte)this.extension1);
        bitStream.pushByte((byte)this.extension2);
        bitStream.pushByte((byte)this.extension3);
        bitStream.pushByte((byte)this.extension4);
        bitStream.pushByte((byte)this.extension5);
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

