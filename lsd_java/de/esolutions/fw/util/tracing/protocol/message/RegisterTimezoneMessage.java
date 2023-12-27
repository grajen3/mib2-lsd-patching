/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol.message;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.tracing.protocol.message.AbstractMessage;
import de.esolutions.fw.util.tracing.protocol.message.MessageType;

public class RegisterTimezoneMessage
extends AbstractMessage {
    private int id;
    private int resolution;
    private String name;

    public RegisterTimezoneMessage(int n, int n2, String string) {
        super(MessageType.REGISTER_TIMEZONE);
        this.id = n;
        this.resolution = n2;
        this.name = string;
    }

    public RegisterTimezoneMessage() {
        super(MessageType.REGISTER_TIMEZONE);
    }

    @Override
    public void serializeElements(ISerializer iSerializer) {
        iSerializer.putInt32(this.id);
        iSerializer.putInt32(this.resolution);
        iSerializer.putString(this.name);
    }

    @Override
    public void deserializeElements(IDeserializer iDeserializer) {
        this.id = iDeserializer.getInt32();
        this.resolution = iDeserializer.getInt32();
        this.name = iDeserializer.getString();
    }

    public int getId() {
        return this.id;
    }

    public int getResolution() {
        return this.resolution;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void toStringBuffer(Buffer buffer) {
        buffer.append("Register TimeZone: id=");
        buffer.append(this.id);
        buffer.append(" resolution=");
        buffer.append(this.resolution);
        buffer.append(" name=");
        buffer.append(this.name);
    }
}

