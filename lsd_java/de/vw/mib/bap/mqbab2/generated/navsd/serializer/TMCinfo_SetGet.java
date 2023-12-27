/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class TMCinfo_SetGet
implements SetGetProperty {
    public int messageId;
    private static final int MESSAGE_ID_BITSIZE;
    public int messageStatus;
    private static final int MESSAGE_STATUS_BITSIZE;
    public static final int MESSAGE_STATUS_NO_MESSAGE;
    public static final int MESSAGE_STATUS_PRESENTATION_REQUEST_FOR_NEW_MESSAGE;
    public static final int MESSAGE_STATUS_MESSAGE_PRESENTATION_CONFIRMED_TO_BE_SET_BY_ASG;
    public int reserve1;
    public final BAPString reserve2 = new BAPString(250);
    private static final int MAX_RESERVE2_LENGTH;

    public TMCinfo_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public TMCinfo_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.messageId = 0;
        this.messageStatus = 0;
        this.reserve1 = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.reserve2.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        TMCinfo_SetGet tMCinfo_SetGet = (TMCinfo_SetGet)bAPEntity;
        return this.messageId == tMCinfo_SetGet.messageId && this.messageStatus == tMCinfo_SetGet.messageStatus && this.reserve1 == tMCinfo_SetGet.reserve1 && this.reserve2.equalTo(tMCinfo_SetGet.reserve2);
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
        this.messageId = bitStream.popFrontBits(4);
        this.messageStatus = bitStream.popFrontBits(4);
        this.reserve1 = bitStream.popFrontByte();
        this.reserve2.deserialize(bitStream);
    }

    public static int functionId() {
        return 25;
    }

    @Override
    public int getFunctionId() {
        return TMCinfo_SetGet.functionId();
    }
}

