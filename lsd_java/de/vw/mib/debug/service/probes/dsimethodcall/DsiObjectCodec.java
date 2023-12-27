/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.dsimethodcall;

import de.vw.mib.debug.service.probes.dsimethodcall.DsiObjectCodec$1;
import de.vw.mib.dsi.trace.DSITraceService;
import de.vw.mib.log4mib.BinaryMessage;
import java.io.OutputStream;
import java.io.PrintWriter;

public class DsiObjectCodec
extends PrintWriter {
    private BinaryMessage debugMessage;
    private final DSITraceService dsiTraceService;
    private static final OutputStream DEFAULT_OUTPUT_STREAM = new DsiObjectCodec$1();
    private static final byte TYPE_CHAR;
    private static final byte TYPE_DOUBLE;
    private static final byte TYPE_FLOAD;
    private static final byte TYPE_INT;
    private static final byte TYPE_LONG;
    private static final byte TYPE_STRING;
    private static final byte TYPE_NULL_STRING;
    private static final byte TYPE_BOOL;
    public static final byte FLAG_DSIITEM_INDICATE_OK;

    public DsiObjectCodec(DSITraceService dSITraceService) {
        super(DEFAULT_OUTPUT_STREAM);
        this.dsiTraceService = dSITraceService;
    }

    @Override
    public boolean checkError() {
        return false;
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("In this special implementation is just for writing DSIObjects to DebugMessage. In this case no stream is used.");
    }

    @Override
    public void flush() {
        throw new UnsupportedOperationException("In this special implementation is just for writing DSIObjects to DebugMessage. In this case no stream is used.");
    }

    @Override
    protected void setError() {
        throw new UnsupportedOperationException("In this special implementation is just for writing DSIObjects to DebugMessage. In this case no stream is used.");
    }

    @Override
    public void write(char[] cArray) {
        throw new UnsupportedOperationException("In this special implementation is just for writing DSIObjects to DebugMessage. In this case no stream is used.");
    }

    @Override
    public void write(char[] cArray, int n, int n2) {
        throw new UnsupportedOperationException("In this special implementation is just for writing DSIObjects to DebugMessage. In this case no stream is used.");
    }

    @Override
    public void write(int n) {
        throw new UnsupportedOperationException("In this special implementation is just for writing DSIObjects to DebugMessage. In this case no stream is used.");
    }

    @Override
    public void write(String string) {
        throw new UnsupportedOperationException("In this special implementation is just for writing DSIObjects to DebugMessage. In this case no stream is used.");
    }

    @Override
    public void write(String string, int n, int n2) {
        throw new UnsupportedOperationException("In this special implementation is just for writing DSIObjects to DebugMessage. In this case no stream is used.");
    }

    @Override
    public void print(char[] cArray) {
        throw new UnsupportedOperationException("In this special implementation only primitive datatype are allowed.");
    }

    @Override
    public void print(char c2) {
        this.debugMessage.append((byte)0);
        this.debugMessage.append(c2);
    }

    @Override
    public void print(double d2) {
        this.debugMessage.append((byte)1);
        this.debugMessage.append(d2);
    }

    @Override
    public void print(float f2) {
        this.debugMessage.append((byte)2);
        this.debugMessage.append(f2);
    }

    @Override
    public void print(int n) {
        this.debugMessage.append((byte)3);
        this.debugMessage.append(n);
    }

    @Override
    public void print(long l) {
        this.debugMessage.append((byte)4);
        this.debugMessage.append(l);
    }

    @Override
    public void print(Object object) {
        throw new UnsupportedOperationException("In this special implementation only primitive datatype are allowed.");
    }

    @Override
    public void print(String string) {
        if (string == null) {
            this.debugMessage.append((byte)6);
            return;
        }
        this.debugMessage.append((byte)5);
        this.debugMessage.append(string);
    }

    @Override
    public void print(boolean bl) {
        this.debugMessage.append((byte)7);
        this.debugMessage.append(bl);
    }

    public void write(BinaryMessage binaryMessage, Object object) {
        this.debugMessage = binaryMessage;
        if (this.dsiTraceService == null || this.dsiTraceService.getDSITraceServiceType() != 2) {
            binaryMessage.append((byte)5);
            if (object == null) {
                binaryMessage.append("null");
            } else {
                binaryMessage.append(object.toString());
            }
        } else {
            binaryMessage.append((byte)11);
            int n = binaryMessage.beginElement();
            this.dsiTraceService.toTrace(this, object);
            binaryMessage.endElement(n);
        }
    }
}

