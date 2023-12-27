/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class MediaBrowser_FileState
implements BAPEntity {
    private static final int RESERVED_BIT_7__15_BITSIZE;
    public boolean importNotPlayable;
    public boolean importPending;
    public boolean importRunning;
    public boolean deadLink;
    public boolean corruptedFileFolder;
    public boolean drmProteced;
    public boolean emptyFolder;

    public MediaBrowser_FileState() {
        this.internalReset();
        this.customInitialization();
    }

    public MediaBrowser_FileState(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.importNotPlayable = false;
        this.importPending = false;
        this.importRunning = false;
        this.deadLink = false;
        this.corruptedFileFolder = false;
        this.drmProteced = false;
        this.emptyFolder = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MediaBrowser_FileState mediaBrowser_FileState = (MediaBrowser_FileState)bAPEntity;
        return this.importNotPlayable == mediaBrowser_FileState.importNotPlayable && this.importPending == mediaBrowser_FileState.importPending && this.importRunning == mediaBrowser_FileState.importRunning && this.deadLink == mediaBrowser_FileState.deadLink && this.corruptedFileFolder == mediaBrowser_FileState.corruptedFileFolder && this.drmProteced == mediaBrowser_FileState.drmProteced && this.emptyFolder == mediaBrowser_FileState.emptyFolder;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "MediaBrowser_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(9);
        bitStream.pushBoolean(this.importNotPlayable);
        bitStream.pushBoolean(this.importPending);
        bitStream.pushBoolean(this.importRunning);
        bitStream.pushBoolean(this.deadLink);
        bitStream.pushBoolean(this.corruptedFileFolder);
        bitStream.pushBoolean(this.drmProteced);
        bitStream.pushBoolean(this.emptyFolder);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(9);
        this.importNotPlayable = bitStream.popFrontBoolean();
        this.importPending = bitStream.popFrontBoolean();
        this.importRunning = bitStream.popFrontBoolean();
        this.deadLink = bitStream.popFrontBoolean();
        this.corruptedFileFolder = bitStream.popFrontBoolean();
        this.drmProteced = bitStream.popFrontBoolean();
        this.emptyFolder = bitStream.popFrontBoolean();
    }
}

