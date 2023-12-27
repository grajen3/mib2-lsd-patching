/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.message;

import de.esolutions.fw.comm.core.message.AbstractMessage;
import de.esolutions.fw.comm.core.message.MessageType;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class PingMessage
extends AbstractMessage {
    public PingMessage(ISerializer iSerializer) {
        super(MessageType.PING, iSerializer);
    }

    public PingMessage(IDeserializer iDeserializer, boolean bl) {
        super(MessageType.PING, iDeserializer, bl);
    }

    @Override
    public void serializeElements(ISerializer iSerializer) {
    }

    @Override
    public void deserializeElements(IDeserializer iDeserializer) {
    }
}

