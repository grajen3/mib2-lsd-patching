/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone2.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class DataConnectionIndication2_Status
implements StatusProperty {
    public int connectionIndication;
    public static final int CONNECTION_INDICATION_NO_DATA_CONNECTION;
    public static final int CONNECTION_INDICATION_DATA_CONNECTION_ACTIVE;
    public int dataVolumeUplink;
    public int dataVolumeDownlink;

    public DataConnectionIndication2_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public DataConnectionIndication2_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.connectionIndication = 0;
        this.dataVolumeUplink = 0;
        this.dataVolumeDownlink = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        DataConnectionIndication2_Status dataConnectionIndication2_Status = (DataConnectionIndication2_Status)bAPEntity;
        return this.connectionIndication == dataConnectionIndication2_Status.connectionIndication && this.dataVolumeUplink == dataConnectionIndication2_Status.dataVolumeUplink && this.dataVolumeDownlink == dataConnectionIndication2_Status.dataVolumeDownlink;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "DataConnectionIndication2_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.connectionIndication);
        bitStream.pushInt(this.dataVolumeUplink);
        bitStream.pushInt(this.dataVolumeDownlink);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 21;
    }

    @Override
    public int getFunctionId() {
        return DataConnectionIndication2_Status.functionId();
    }
}

