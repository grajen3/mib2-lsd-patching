/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MediaBrowser_FolderLevel_Status
implements StatusProperty {
    public int folderLevel;
    public static final int FOLDER_LEVEL_MIN;
    public int ref_MediaBrowser;
    public static final int REF_MEDIA_BROWSER_MIN;
    public int ref_MediaBrowser_absolutePosition;
    public static final int REF_MEDIA_BROWSER_ABSOLUTE_POSITION_MIN;

    public MediaBrowser_FolderLevel_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public MediaBrowser_FolderLevel_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.folderLevel = 0;
        this.ref_MediaBrowser = 0;
        this.ref_MediaBrowser_absolutePosition = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MediaBrowser_FolderLevel_Status mediaBrowser_FolderLevel_Status = (MediaBrowser_FolderLevel_Status)bAPEntity;
        return this.folderLevel == mediaBrowser_FolderLevel_Status.folderLevel && this.ref_MediaBrowser == mediaBrowser_FolderLevel_Status.ref_MediaBrowser && this.ref_MediaBrowser_absolutePosition == mediaBrowser_FolderLevel_Status.ref_MediaBrowser_absolutePosition;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "MediaBrowser_FolderLevel_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.folderLevel);
        bitStream.pushShort((short)this.ref_MediaBrowser);
        bitStream.pushShort((short)this.ref_MediaBrowser_absolutePosition);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.folderLevel = bitStream.popFrontByte();
        this.ref_MediaBrowser = bitStream.popFrontShort();
        this.ref_MediaBrowser_absolutePosition = bitStream.popFrontShort();
    }

    public static int functionId() {
        return 35;
    }

    @Override
    public int getFunctionId() {
        return MediaBrowser_FolderLevel_Status.functionId();
    }
}

