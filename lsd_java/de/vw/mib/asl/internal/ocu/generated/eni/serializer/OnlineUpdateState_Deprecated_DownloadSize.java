/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class OnlineUpdateState_Deprecated_DownloadSize
implements BAPEntity {
    public static final int SIZE_MIN;
    public int size;
    public static final int UNIT_NO_INFORMATION_DEFAULT_DURING_STARTUP;
    public static final int UNIT_BYTE;
    public static final int UNIT_KILOBYTE;
    public static final int UNIT_MEGABYTE;
    public static final int UNIT_GIGABYTE;
    public static final int UNIT_TERABYTE;
    public int unit;

    public OnlineUpdateState_Deprecated_DownloadSize() {
        this.internalReset();
        this.customInitialization();
    }

    public OnlineUpdateState_Deprecated_DownloadSize(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.size = 0;
        this.unit = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        OnlineUpdateState_Deprecated_DownloadSize onlineUpdateState_Deprecated_DownloadSize = (OnlineUpdateState_Deprecated_DownloadSize)bAPEntity;
        return this.size == onlineUpdateState_Deprecated_DownloadSize.size && this.unit == onlineUpdateState_Deprecated_DownloadSize.unit;
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
        bitStream.pushShort((short)this.size);
        bitStream.pushByte((byte)this.unit);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.size = bitStream.popFrontShort();
        this.unit = bitStream.popFrontByte();
    }
}

