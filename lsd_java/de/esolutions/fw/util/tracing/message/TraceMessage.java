/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.message;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.StringConverter;
import de.esolutions.fw.util.tracing.TraceLevels;
import de.esolutions.fw.util.tracing.message.ITraceMessage;
import de.esolutions.fw.util.tracing.util.TraceTimeStamp;
import java.io.UnsupportedEncodingException;

public class TraceMessage
implements ITraceMessage {
    private int cid;
    private int tid;
    private final short level;
    private final short mods;
    private final short type;
    protected byte[] data;
    private long timeStamp;
    private int epoch;
    private int seqNum;
    private String[] decodedMsg;

    protected TraceMessage(long l, int n, int n2, short s, short s2, short s3) {
        this.cid = n;
        this.tid = n2;
        this.level = s;
        this.mods = s2;
        this.type = s3;
        this.data = null;
        this.timeStamp = l;
        this.epoch = 0;
        this.seqNum = 0;
    }

    public TraceMessage(long l, int n, int n2, short s, short s2, short s3, byte[] byArray) {
        this.cid = n;
        this.tid = n2;
        this.level = s;
        this.mods = s2;
        this.type = s3;
        this.data = byArray;
        this.timeStamp = l;
        this.epoch = 0;
        this.seqNum = 0;
    }

    public TraceMessage(long l, int n, int n2, short s, short s2, short s3, String string) {
        this.cid = n;
        this.tid = n2;
        this.level = s;
        this.mods = s2;
        this.type = s3;
        this.timeStamp = l;
        this.epoch = 0;
        this.seqNum = 0;
        this.setMessageString(string);
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("[TM:cid=");
        buffer.append(this.cid);
        buffer.append(",tid=");
        buffer.append(this.tid);
        buffer.append(",level=");
        buffer.append(this.level);
        buffer.append("/");
        buffer.append(TraceLevels.getName(this.level));
        buffer.append(",type=");
        buffer.append(this.type);
        buffer.append(",mods=");
        buffer.append(this.mods);
        buffer.append(",epoch=");
        buffer.append(this.epoch);
        buffer.append(",seqNum=");
        buffer.append(this.seqNum);
        buffer.append(",ts=");
        buffer.append(new TraceTimeStamp(this.timeStamp));
        if (this.data != null) {
            buffer.append(",data=#");
            buffer.append(this.data.length);
        }
        buffer.append("]");
        return buffer.toString();
    }

    @Override
    public int getChannelID() {
        return this.cid;
    }

    @Override
    public void setChannelID(int n) {
        this.cid = n;
    }

    @Override
    public int getThreadID() {
        return this.tid;
    }

    @Override
    public void setThreadID(int n) {
        this.tid = n;
    }

    @Override
    public short getLevel() {
        return this.level;
    }

    @Override
    public short getModifiers() {
        return this.mods;
    }

    @Override
    public long getTimeStamp() {
        return this.timeStamp;
    }

    @Override
    public void setTimeStamp(long l) {
        this.timeStamp = l;
    }

    @Override
    public void setEpoch(int n) {
        this.epoch = n;
    }

    @Override
    public int getEpoch() {
        return this.epoch;
    }

    @Override
    public void setSeqNum(int n) {
        this.seqNum = n;
    }

    @Override
    public int getSeqNum() {
        return this.seqNum;
    }

    @Override
    public void setDecodedMessage(String[] stringArray) {
        this.decodedMsg = stringArray;
    }

    @Override
    public String[] getDecodedMessage() {
        return this.decodedMsg;
    }

    @Override
    public short getMessageType() {
        return this.type;
    }

    @Override
    public String getMessageString() {
        if (this.data == null) {
            return null;
        }
        try {
            return StringConverter.UTF8.getString(this.data);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            return new String(this.data);
        }
    }

    @Override
    public int getMessageSize() {
        if (this.data == null) {
            return 0;
        }
        return this.data.length;
    }

    public void setMessageString(String string) {
        try {
            this.data = StringConverter.UTF8.getBytes(string);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            this.data = string.getBytes();
        }
    }

    @Override
    public byte[] getMessageData() {
        return this.data;
    }

    @Override
    public void expandNow() {
    }
}

