/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class MediaBrowserControl_Result
implements ResultMethod {
    public int browserControlResult;
    public static final int BROWSER_CONTROL_RESULT_ABORT_NOT_SUCCESSFUL;
    public static final int BROWSER_CONTROL_RESULT_ABORT_SUCCESSFUL;
    public static final int BROWSER_CONTROL_RESULT_NOT_SUCCESFUL_NOT_SUPPORTED;
    public static final int BROWSER_CONTROL_RESULT_SUCCESSFUL;

    public MediaBrowserControl_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public MediaBrowserControl_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.browserControlResult = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MediaBrowserControl_Result mediaBrowserControl_Result = (MediaBrowserControl_Result)bAPEntity;
        return this.browserControlResult == mediaBrowserControl_Result.browserControlResult;
    }

    private void customInitialization() {
    }

    @Override
    public int getResultCode() {
        return this.browserControlResult;
    }

    @Override
    public String toString() {
        return "MediaBrowserControl_Result:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.browserControlResult);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.browserControlResult = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 38;
    }

    @Override
    public int getFunctionId() {
        return MediaBrowserControl_Result.functionId();
    }
}

