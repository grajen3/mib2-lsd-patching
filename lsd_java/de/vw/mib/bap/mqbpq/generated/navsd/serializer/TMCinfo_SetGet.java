/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class TMCinfo_SetGet
implements SetGetProperty {
    public int messageNumber;
    private static final int MESSAGE_NUMBER_BITSIZE;
    public int messageStatus;
    private static final int MESSAGE_STATUS_BITSIZE;
    public static final int MESSAGE_STATUS_NO_MESSAGE;
    public static final int MESSAGE_STATUS_PRESENTATION_REQUEST_FOR_NEW_MESSAGE;
    public static final int MESSAGE_STATUS_MESSAGE_PRESENTATION_CONFIRMED;

    public TMCinfo_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public TMCinfo_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.messageNumber = 0;
        this.messageStatus = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        TMCinfo_SetGet tMCinfo_SetGet = (TMCinfo_SetGet)bAPEntity;
        return this.messageNumber == tMCinfo_SetGet.messageNumber && this.messageStatus == tMCinfo_SetGet.messageStatus;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "TMCinfo_SetGet:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.messageNumber = bitStream.popFrontBits(4);
        this.messageStatus = bitStream.popFrontBits(4);
    }

    public static int functionId() {
        return 24;
    }

    @Override
    public int getFunctionId() {
        return TMCinfo_SetGet.functionId();
    }
}

