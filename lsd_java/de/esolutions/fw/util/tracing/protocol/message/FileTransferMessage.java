/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol.message;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.tracing.protocol.message.AbstractMessage;
import de.esolutions.fw.util.tracing.protocol.message.MessageType;

public class FileTransferMessage
extends AbstractMessage {
    private int id;
    private int blockNumber;
    private byte flag;
    private int blockSize;
    private byte[] blockData;

    public FileTransferMessage() {
        super(MessageType.FILE_TRANSFER);
    }

    public FileTransferMessage(FileTransferMessage fileTransferMessage) {
        super(MessageType.FILE_TRANSFER);
        this.id = fileTransferMessage.getTransferId();
        this.blockNumber = fileTransferMessage.getBlockNumber();
        this.flag = fileTransferMessage.getFlag();
        this.blockSize = fileTransferMessage.getBlockSize();
        this.blockData = fileTransferMessage.getBlockData();
    }

    public FileTransferMessage(int n, int n2, byte by, int n3, byte[] byArray) {
        super(MessageType.FILE_TRANSFER);
        this.id = n;
        this.blockNumber = n2;
        this.flag = by;
        this.blockSize = n3;
        this.blockData = byArray;
    }

    @Override
    protected void serializeElements(ISerializer iSerializer) {
        iSerializer.putInt32(this.id);
        iSerializer.putInt32(this.blockNumber);
        iSerializer.putInt8(this.flag);
        iSerializer.putInt32(this.blockSize);
        iSerializer.putInt8VarArray(this.blockData);
    }

    @Override
    protected void deserializeElements(IDeserializer iDeserializer) {
        this.id = iDeserializer.getInt32();
        this.blockNumber = iDeserializer.getInt32();
        this.flag = iDeserializer.getInt8();
        this.blockSize = iDeserializer.getInt32();
        this.blockData = iDeserializer.getInt8VarArray();
    }

    @Override
    public void toStringBuffer(Buffer buffer) {
        buffer.append("FILE_TRANSFER: transferId=");
        buffer.append(this.id);
        buffer.append(" flag=");
        buffer.append(this.flag);
        buffer.append(" blockNumber=");
        buffer.append(this.blockNumber);
        buffer.append(" blockSize=");
        buffer.append(this.blockSize);
    }

    public int getTransferId() {
        return this.id;
    }

    public int getBlockNumber() {
        return this.blockNumber;
    }

    public byte getFlag() {
        return this.flag;
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    public byte[] getBlockData() {
        return this.blockData;
    }
}

