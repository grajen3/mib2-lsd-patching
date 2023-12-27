/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class AnnouncementEscape_Result
implements ResultMethod {
    public int announcementEscapeResult;
    public static final int ANNOUNCEMENT_ESCAPE_RESULT_ANNOUNCEMENT_NOT_ACTIVE;
    public static final int ANNOUNCEMENT_ESCAPE_RESULT_ABORT_NOT_SUCCESSFUL;
    public static final int ANNOUNCEMENT_ESCAPE_RESULT_ABORT_SUCCESSFUL;
    public static final int ANNOUNCEMENT_ESCAPE_RESULT_NOT_SUCCESSFUL;
    public static final int ANNOUNCEMENT_ESCAPE_RESULT_SUCCESSFUL;

    public AnnouncementEscape_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public AnnouncementEscape_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.announcementEscapeResult = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        AnnouncementEscape_Result announcementEscape_Result = (AnnouncementEscape_Result)bAPEntity;
        return this.announcementEscapeResult == announcementEscape_Result.announcementEscapeResult;
    }

    private void customInitialization() {
    }

    @Override
    public int getResultCode() {
        return this.announcementEscapeResult;
    }

    @Override
    public String toString() {
        return "AnnouncementEscape_Result:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.announcementEscapeResult);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.announcementEscapeResult = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 29;
    }

    @Override
    public int getFunctionId() {
        return AnnouncementEscape_Result.functionId();
    }
}

