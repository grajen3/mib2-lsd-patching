/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.ssl;

import com.ibm.j9.ssl.SSLProtocol;
import com.ibm.j9.ssl.Util;
import com.ibm.oti.util.Msg;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Record {
    public static final int MAX_RECORD_LENGTH;
    private static final int HEADER_LENGTH;
    private final byte[] version;
    private final byte contentType;
    private final byte[] data;
    private static boolean recordDebug;
    private static String lineTerminator;

    static {
        recordDebug = false;
        lineTerminator = Util.getLineTerminator();
    }

    public Record(byte by, byte[] byArray, byte[] byArray2) {
        this.contentType = by;
        this.version = new byte[2];
        System.arraycopy((Object)byArray, 0, (Object)this.version, 0, 2);
        this.data = new byte[byArray2.length];
        System.arraycopy((Object)byArray2, 0, (Object)this.data, 0, byArray2.length);
    }

    public static Record readRecord(InputStream inputStream) {
        int n = -1;
        int n2 = 0;
        byte[] byArray = new byte[5];
        while (n2 < byArray.length) {
            n = inputStream.read(byArray, n2, byArray.length - n2);
            if (n == -1) {
                return null;
            }
            if (n == 0 && n2 == 0) {
                return null;
            }
            if (n <= 0) continue;
            n2 += n;
        }
        byte by = byArray[0];
        byte[] byArray2 = new byte[2];
        System.arraycopy((Object)byArray, 1, (Object)byArray2, 0, byArray2.length);
        int n3 = (int)Util.getLong(byArray, 3, 2);
        if (!SSLProtocol.isValidContentType(by)) {
            throw new IOException(Msg.getString("K01ef"));
        }
        if (!SSLProtocol.isValidVersion(byArray2)) {
            throw new IOException(Msg.getString("K01f0"));
        }
        n2 = 0;
        byte[] byArray3 = new byte[n3];
        while (n2 < n3) {
            n = inputStream.read(byArray3, n2, n3 - n2);
            if (n == -1) {
                return null;
            }
            if (n <= 0) continue;
            n2 += n;
        }
        Record record = new Record(by, byArray2, byArray3);
        if (recordDebug) {
            System.err.println("=====READ=====");
            System.err.print(record.toString());
            System.err.println("==============");
            System.err.flush();
        }
        return record;
    }

    public void writeRecord(OutputStream outputStream) {
        if (recordDebug) {
            System.err.println("====WRITE=====");
            System.err.print(this.toString());
            System.err.println("==============");
            System.err.flush();
        }
        byte[] byArray = this.toByteArray();
        outputStream.write(byArray);
        outputStream.flush();
    }

    private byte[] toByteArray() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(this.contentType);
            byteArrayOutputStream.write(this.version);
            byteArrayOutputStream.write(Util.getBytes(this.data.length, 2));
            byteArrayOutputStream.write(this.data);
        }
        catch (IOException iOException) {}
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] getVersion() {
        return this.version;
    }

    public byte getContentType() {
        return this.contentType;
    }

    public byte[] getData() {
        return this.data;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(new StringBuffer("ContentType: ").append(SSLProtocol.getContentTypeName(this.contentType)).append(lineTerminator).toString());
        stringBuffer.append(new StringBuffer("Version: ").append(this.version[0]).append(".").append(this.version[1]).append(lineTerminator).toString());
        stringBuffer.append(new StringBuffer("Data (").append(this.data.length).append("): ").append(Util.getStringForByteArray(this.data)).append(lineTerminator).toString());
        return stringBuffer.toString();
    }
}

