/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class MediaFileInfo_Result
implements ResultMethod {
    public int mediaFileInfoResult;
    public static final int MEDIA_FILE_INFO_RESULT_ABORT_NOT_SUCCESSFUL;
    public static final int MEDIA_FILE_INFO_RESULT_ABORT_SUCCESSFUL;
    public static final int MEDIA_FILE_INFO_RESULT_NOT_SUCCESSFUL_NOT_SUPPORTED;
    public static final int MEDIA_FILE_INFO_RESULT_SUCCESSFUL;
    public final BAPString artist = new BAPString(76);
    private static final int MAX_ARTIST_LENGTH;
    public final BAPString title = new BAPString(76);
    private static final int MAX_TITLE_LENGTH;
    public final BAPString album = new BAPString(76);
    private static final int MAX_ALBUM_LENGTH;

    public MediaFileInfo_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public MediaFileInfo_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.mediaFileInfoResult = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.artist.reset();
        this.title.reset();
        this.album.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MediaFileInfo_Result mediaFileInfo_Result = (MediaFileInfo_Result)bAPEntity;
        return this.mediaFileInfoResult == mediaFileInfo_Result.mediaFileInfoResult && this.artist.equalTo(mediaFileInfo_Result.artist) && this.title.equalTo(mediaFileInfo_Result.title) && this.album.equalTo(mediaFileInfo_Result.album);
    }

    private void customInitialization() {
    }

    @Override
    public int getResultCode() {
        return this.mediaFileInfoResult;
    }

    @Override
    public String toString() {
        return "MediaFileInfo_Result:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.mediaFileInfoResult);
        this.artist.serialize(bitStream);
        this.title.serialize(bitStream);
        this.album.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.mediaFileInfoResult = bitStream.popFrontByte();
        this.artist.deserialize(bitStream);
        this.title.deserialize(bitStream);
        this.album.deserialize(bitStream);
    }

    public static int functionId() {
        return 39;
    }

    @Override
    public int getFunctionId() {
        return MediaFileInfo_Result.functionId();
    }
}

