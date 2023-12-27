/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol.message;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.tracing.protocol.message.AbstractMessage;
import de.esolutions.fw.util.tracing.protocol.message.MessageType;

public class ExitMessage
extends AbstractMessage {
    public ExitMessage() {
        super(MessageType.EXIT);
    }

    @Override
    public void serializeElements(ISerializer iSerializer) {
    }

    @Override
    public void deserializeElements(IDeserializer iDeserializer) {
    }

    @Override
    public void toStringBuffer(Buffer buffer) {
        buffer.append("EXIT");
    }
}

