/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.message;

import de.esolutions.fw.comm.core.message.AbstractMessage;
import de.esolutions.fw.comm.core.message.CommStringTool;
import de.esolutions.fw.comm.core.message.MessageType;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class RejectMessage
extends AbstractMessage {
    protected String errorString;
    protected short errorCode;
    public static final short UNKNOWN_ERROR;
    public static final short DUAL_CONNECT;
    public static final short VERSION_TOO_NEW;
    public static final short VERSION_TOO_OLD;
    public static final short AGENT_TOO_OLD;
    public static final short FEATURE_MISMATCH;
    public static final String[] ERROR_NAMES;

    public RejectMessage(ISerializer iSerializer, short s, String string) {
        super(MessageType.REJECT, iSerializer);
        this.errorCode = s;
        this.errorString = string;
    }

    public RejectMessage(IDeserializer iDeserializer, boolean bl) {
        super(MessageType.REJECT, iDeserializer, bl);
    }

    @Override
    public void serializeElements(ISerializer iSerializer) {
        iSerializer.putUInt8(this.errorCode);
        CommStringTool.serializeCommString(this.errorString, iSerializer);
    }

    @Override
    public void deserializeElements(IDeserializer iDeserializer) {
        this.errorCode = iDeserializer.getUInt8();
        this.errorString = CommStringTool.deserializeCommString(iDeserializer);
    }

    public short getErrorCode() {
        return this.errorCode;
    }

    public String getErrorString() {
        return this.errorString;
    }

    static {
        ERROR_NAMES = new String[]{"Unknown Error", "Dual Connect", "Version too new", "Version too old", "Agent too old", "Feature mismatch"};
    }
}

