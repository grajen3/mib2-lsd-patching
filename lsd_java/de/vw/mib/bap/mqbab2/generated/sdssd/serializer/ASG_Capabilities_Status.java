/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.sdssd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class ASG_Capabilities_Status
implements StatusProperty {
    public int displaySizeClass;
    public static final int DISPLAY_SIZE_CLASS_SMALL_DISPLAY;
    public static final int DISPLAY_SIZE_CLASS_MEDIUM_DISPLAY;
    public static final int DISPLAY_SIZE_CLASS_LARGE_DISPLAY;
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

    public ASG_Capabilities_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public ASG_Capabilities_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.displaySizeClass = 0;
        this.extension1 = 0;
        this.extension2 = 0;
        this.extension3 = 0;
        this.extension4 = 0;
        this.extension5 = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ASG_Capabilities_Status aSG_Capabilities_Status = (ASG_Capabilities_Status)bAPEntity;
        return this.displaySizeClass == aSG_Capabilities_Status.displaySizeClass && this.extension1 == aSG_Capabilities_Status.extension1 && this.extension2 == aSG_Capabilities_Status.extension2 && this.extension3 == aSG_Capabilities_Status.extension3 && this.extension4 == aSG_Capabilities_Status.extension4 && this.extension5 == aSG_Capabilities_Status.extension5;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ASG_Capabilities_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.displaySizeClass);
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
        return 16;
    }

    @Override
    public int getFunctionId() {
        return ASG_Capabilities_Status.functionId();
    }
}

