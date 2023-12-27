/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib.writer;

import de.vw.mib.codec.AbstractByteArraytoStringDecoder;
import de.vw.mib.codec.ByteArrayCodec;
import de.vw.mib.codec.ByteArrayDecoder;
import de.vw.mib.codec.ByteArrayReader;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.writer.LogMessageHeaderAppender;
import java.io.IOException;

final class AbstractStringLogWriter$LogMessageToStringConverter
extends AbstractByteArraytoStringDecoder {
    private String currentMessage;
    private String currentStackTrace;
    private final LogMessageHeaderAppender headerAppender;

    AbstractStringLogWriter$LogMessageToStringConverter(LogMessageHeaderAppender logMessageHeaderAppender) {
        this.headerAppender = logMessageHeaderAppender;
    }

    void convert(LogMessage logMessage) {
        this.currentMessage = null;
        this.currentStackTrace = null;
        try {
            ByteArrayCodec.decode(logMessage.getContent(), (ByteArrayDecoder)this);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    String getMessage() {
        return this.currentMessage;
    }

    String getStackTrace() {
        return this.currentStackTrace;
    }

    @Override
    public void finish() {
        this.currentMessage = this.toString();
    }

    @Override
    public void readHeader(ByteArrayReader byteArrayReader) {
        this.clear();
        byteArrayReader.readByte();
        byteArrayReader.readByte();
        this.headerAppender.appendHeader(byteArrayReader.readLong(), byteArrayReader.readInt(), byteArrayReader.readInt(), byteArrayReader.readInt(), byteArrayReader.readInt(), this).append(" ");
    }

    @Override
    public void readObject(ByteArrayReader byteArrayReader) {
    }

    @Override
    public void readStackTrace(String string) {
        this.currentStackTrace = string;
    }
}

