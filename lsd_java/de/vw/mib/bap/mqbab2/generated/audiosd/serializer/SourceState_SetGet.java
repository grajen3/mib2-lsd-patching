/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class SourceState_SetGet
implements SetGetProperty {
    public int stateInfo;
    public static final int STATE_INFO_PLAY_MORE_LIKE_THIS;
    public static final int STATE_INFO_SEEK;
    public static final int STATE_INFO_MANUAL_TUNING;
    public static final int STATE_INFO_REPEAT_MIX;
    public static final int STATE_INFO_REPEAT;
    public static final int STATE_INFO_MIX;
    public static final int STATE_INFO_SCAN;
    public static final int STATE_INFO_UNKNOWN_OFF;
    public int stateInfo_Scope;
    public static final int STATE_INFO_SCOPE_ALL_PLAYLISTS;
    public static final int STATE_INFO_SCOPE_PLAYLIST;
    public static final int STATE_INFO_SCOPE_ALL_DIRECTORIES_ALL_FOLDERS;
    public static final int STATE_INFO_SCOPE_DIRECTORY_WITH_SUBDIRECTORIES;
    public static final int STATE_INFO_SCOPE_DIRECTORY_WITHOUT_SUBDIRECTORIES;
    public static final int STATE_INFO_SCOPE_MEDIUM;
    public static final int STATE_INFO_SCOPE_DEVICE;
    public static final int STATE_INFO_SCOPE_FILE_TRACK;
    public static final int STATE_INFO_SCOPE_UNKNOWN_SCOPE_ANY_SCOPE;

    public SourceState_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public SourceState_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.stateInfo = 0;
        this.stateInfo_Scope = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SourceState_SetGet sourceState_SetGet = (SourceState_SetGet)bAPEntity;
        return this.stateInfo == sourceState_SetGet.stateInfo && this.stateInfo_Scope == sourceState_SetGet.stateInfo_Scope;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "SourceState_SetGet:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.stateInfo);
        bitStream.pushByte((byte)this.stateInfo_Scope);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.stateInfo = bitStream.popFrontByte();
        this.stateInfo_Scope = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 20;
    }

    @Override
    public int getFunctionId() {
        return SourceState_SetGet.functionId();
    }
}

