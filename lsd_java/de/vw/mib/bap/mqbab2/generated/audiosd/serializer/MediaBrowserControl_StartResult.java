/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class MediaBrowserControl_StartResult
implements StartResultMethod {
    public int control;
    public static final int CONTROL_OPEN_FOLDER_PLAYLIST;
    public static final int CONTROL_GO_TO_SOURCE;
    public static final int CONTROL_GO_TO_PARENT_DIRECTORY;
    public static final int CONTROL_GO_TO_ROOT_DIRECTORY;
    public static final int CONTROL_GO_TO_CURRENT_FILE;
    public int reference;
    public static final int REFERENCE_MIN;

    public MediaBrowserControl_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public MediaBrowserControl_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.control = 0;
        this.reference = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MediaBrowserControl_StartResult mediaBrowserControl_StartResult = (MediaBrowserControl_StartResult)bAPEntity;
        return this.control == mediaBrowserControl_StartResult.control && this.reference == mediaBrowserControl_StartResult.reference;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "MediaBrowserControl_StartResult:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.control);
        bitStream.pushShort((short)this.reference);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.control = bitStream.popFrontByte();
        this.reference = bitStream.popFrontShort();
    }

    public static int functionId() {
        return 38;
    }

    @Override
    public int getFunctionId() {
        return MediaBrowserControl_StartResult.functionId();
    }
}

