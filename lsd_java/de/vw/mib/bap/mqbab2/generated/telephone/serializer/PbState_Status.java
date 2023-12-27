/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class PbState_Status
implements StatusProperty {
    public int downloadState;
    public static final int DOWNLOAD_STATE_NO_PHONE_BOOK_AVAILABLE;
    public static final int DOWNLOAD_STATE_CURRENTLY_BEING_LOADED;
    public static final int DOWNLOAD_STATE_COMPLETELY_LOADED_FROM_MOBILE_TO_UHV;
    public static final int DOWNLOAD_STATE_INCOMPLETELY_LOADED_DOWNLOADED_ENTRIES_AVAILABLE;
    public static final int DOWNLOAD_STATE_DOWNLOAD_ABORTED_ONLY_TEMPORARY_INDICATION;
    public int pbEntriesUhv;

    public PbState_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public PbState_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.downloadState = 0;
        this.pbEntriesUhv = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        PbState_Status pbState_Status = (PbState_Status)bAPEntity;
        return this.downloadState == pbState_Status.downloadState && this.pbEntriesUhv == pbState_Status.pbEntriesUhv;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "PbState_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.downloadState);
        bitStream.pushShort((short)this.pbEntriesUhv);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 51;
    }

    @Override
    public int getFunctionId() {
        return PbState_Status.functionId();
    }
}

