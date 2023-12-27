/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone2.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class PhonebookDownloadProgress_Status
implements StatusProperty {
    public int downloadState;
    public static final int DOWNLOAD_STATE_NO_PHONE_BOOK_AVAILABLE;
    public static final int DOWNLOAD_STATE_CURRENTLY_BEING_LOADED;
    public static final int DOWNLOAD_STATE_COMPLETELY_LOADED_FROM_MOBILE_TO_FSG;
    public static final int DOWNLOAD_STATE_INCOMPLETELY_LOADED_DOWNLOADED_ENTRIES_AVAILABLE;
    public static final int DOWNLOAD_STATE_DOWNLOAD_ABORTED_ONLY_TEMPORARY_INDICATION;
    public int progressPhonebookDownload;
    public int totalPbEntries;
    public int currentlyLoadedPbEntries;

    public PhonebookDownloadProgress_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public PhonebookDownloadProgress_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.downloadState = 0;
        this.progressPhonebookDownload = 0;
        this.totalPbEntries = 0;
        this.currentlyLoadedPbEntries = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        PhonebookDownloadProgress_Status phonebookDownloadProgress_Status = (PhonebookDownloadProgress_Status)bAPEntity;
        return this.downloadState == phonebookDownloadProgress_Status.downloadState && this.progressPhonebookDownload == phonebookDownloadProgress_Status.progressPhonebookDownload && this.totalPbEntries == phonebookDownloadProgress_Status.totalPbEntries && this.currentlyLoadedPbEntries == phonebookDownloadProgress_Status.currentlyLoadedPbEntries;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "PhonebookDownloadProgress_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.downloadState);
        bitStream.pushByte((byte)this.progressPhonebookDownload);
        bitStream.pushShort((short)this.totalPbEntries);
        bitStream.pushShort((short)this.currentlyLoadedPbEntries);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 26;
    }

    @Override
    public int getFunctionId() {
        return PhonebookDownloadProgress_Status.functionId();
    }
}

