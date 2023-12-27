/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol.message;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.tracing.protocol.message.AbstractMessage;
import de.esolutions.fw.util.tracing.protocol.message.MessageType;

public class FileStatusMessage
extends AbstractMessage {
    private int id;
    private String path;
    private byte flag;
    private long size;
    private long timestamp;
    private byte hashType;
    private byte[] hash;

    public FileStatusMessage() {
        super(MessageType.FILE_STATUS);
    }

    public FileStatusMessage(FileStatusMessage fileStatusMessage) {
        super(MessageType.FILE_STATUS);
        this.id = fileStatusMessage.getTransferId();
        this.path = fileStatusMessage.getFilePath();
        this.flag = fileStatusMessage.getFileFlag();
        this.size = fileStatusMessage.getFileSize();
        this.timestamp = fileStatusMessage.getFileTimeStamp();
        this.hashType = fileStatusMessage.getFileHashType();
        this.hash = fileStatusMessage.getFileHash();
    }

    public FileStatusMessage(int n, String string, byte by, long l, long l2, byte by2, byte[] byArray) {
        super(MessageType.FILE_STATUS);
        this.id = n;
        this.path = string;
        this.flag = by;
        this.size = l;
        this.timestamp = l2;
        this.hashType = by2;
        this.hash = byArray;
    }

    @Override
    protected void serializeElements(ISerializer iSerializer) {
        iSerializer.putInt32(this.id);
        iSerializer.putString(this.path);
        iSerializer.putInt8(this.flag);
        iSerializer.putInt64(this.size);
        iSerializer.putInt64(this.timestamp);
        iSerializer.putInt8(this.hashType);
        iSerializer.putInt8VarArray(this.hash);
    }

    @Override
    protected void deserializeElements(IDeserializer iDeserializer) {
        this.id = iDeserializer.getInt32();
        this.path = iDeserializer.getString();
        this.flag = iDeserializer.getInt8();
        this.size = iDeserializer.getInt64();
        this.timestamp = iDeserializer.getInt64();
        this.hashType = iDeserializer.getInt8();
        this.hash = iDeserializer.getInt8VarArray();
    }

    @Override
    public void toStringBuffer(Buffer buffer) {
        buffer.append("FILE_STATUS: transferId=");
        buffer.append(this.id);
        buffer.append(" flag=");
        buffer.append(this.flag);
        buffer.append(" path=");
        buffer.append(this.path);
        buffer.append(" size=");
        buffer.append(this.size);
        buffer.append(" timestamp=");
        buffer.append(this.timestamp);
    }

    public int getTransferId() {
        return this.id;
    }

    public String getFilePath() {
        return this.path;
    }

    public byte getFileFlag() {
        return this.flag;
    }

    public long getFileSize() {
        return this.size;
    }

    public long getFileTimeStamp() {
        return this.timestamp;
    }

    public byte getFileHashType() {
        return this.hashType;
    }

    public byte[] getFileHash() {
        return this.hash;
    }
}

