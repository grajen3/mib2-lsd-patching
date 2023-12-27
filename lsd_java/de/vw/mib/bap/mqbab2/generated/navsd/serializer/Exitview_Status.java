/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class Exitview_Status
implements StatusProperty {
    public int variant;
    public static final int VARIANT_EU;
    public static final int VARIANT_NAR;
    public static final int VARIANT_ROW;
    public static final int VARIANT_ASIA;
    public static final int VARIANT_UNKNOWN;
    public int exitview_Id;

    public Exitview_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public Exitview_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.variant = 0;
        this.exitview_Id = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        Exitview_Status exitview_Status = (Exitview_Status)bAPEntity;
        return this.variant == exitview_Status.variant && this.exitview_Id == exitview_Status.exitview_Id;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "Exitview_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.variant);
        bitStream.pushShort((short)this.exitview_Id);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 49;
    }

    @Override
    public int getFunctionId() {
        return Exitview_Status.functionId();
    }
}

