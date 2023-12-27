/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbpq.generated.navsd.serializer.TMCinfo_Status$TMCinfo;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class TMCinfo_Status
implements StatusProperty {
    public int messageNumber;
    private static final int MESSAGE_NUMBER_BITSIZE;
    public int messageStatus;
    private static final int MESSAGE_STATUS_BITSIZE;
    public static final int MESSAGE_STATUS_NO_MESSAGE;
    public static final int MESSAGE_STATUS_PRESENTATION_REQUEST_FOR_NEW_MESSAGE;
    public static final int MESSAGE_STATUS_MESSAGE_PRESENTATION_CONFIRMED;
    public final TMCinfo_Status$TMCinfo tmcinfo = new TMCinfo_Status$TMCinfo();

    public TMCinfo_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public TMCinfo_Status(BitStream bitStream) {
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
        this.tmcinfo.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        TMCinfo_Status tMCinfo_Status = (TMCinfo_Status)bAPEntity;
        return this.messageNumber == tMCinfo_Status.messageNumber && this.messageStatus == tMCinfo_Status.messageStatus && this.tmcinfo.equalTo(tMCinfo_Status.tmcinfo);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "TMCinfo_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBits(4, this.messageNumber);
        bitStream.pushBits(4, this.messageStatus);
        this.tmcinfo.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 24;
    }

    @Override
    public int getFunctionId() {
        return TMCinfo_Status.functionId();
    }
}

