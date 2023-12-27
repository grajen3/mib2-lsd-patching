/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol.message;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.tracing.protocol.message.AbstractMessage;
import de.esolutions.fw.util.tracing.protocol.message.MessageType;

public class FileRequestMessage
extends AbstractMessage {
    private int id;
    private String path;
    private byte operation;

    public FileRequestMessage() {
        super(MessageType.FILE_REQUEST);
        this.id = 1;
        this.path = null;
        this.operation = (byte)-1;
    }

    public FileRequestMessage(FileRequestMessage fileRequestMessage) {
        super(MessageType.FILE_REQUEST);
        this.id = fileRequestMessage.getTransferId();
        this.path = fileRequestMessage.getFilePath();
        this.operation = fileRequestMessage.getOperation();
    }

    public FileRequestMessage(int n, String string, byte by) {
        super(MessageType.FILE_REQUEST);
        this.id = n;
        this.path = string;
        this.operation = by;
    }

    @Override
    protected void serializeElements(ISerializer iSerializer) {
        iSerializer.putInt32(this.id);
        iSerializer.putString(this.path);
        iSerializer.putInt8(this.operation);
    }

    @Override
    protected void deserializeElements(IDeserializer iDeserializer) {
        this.id = iDeserializer.getInt32();
        this.path = iDeserializer.getString();
        this.operation = iDeserializer.getInt8();
    }

    @Override
    public void toStringBuffer(Buffer buffer) {
        buffer.append("FILE_REQUEST: transferId=");
        buffer.append(this.id);
        buffer.append(" operation=");
        buffer.append(this.operation);
        buffer.append(" path=");
        buffer.append(this.path);
    }

    public int getTransferId() {
        return this.id;
    }

    public String getFilePath() {
        return this.path;
    }

    public byte getOperation() {
        return this.operation;
    }
}

