/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.socket;

import de.esolutions.fw.util.transport.socket.MultiFileNamer;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MultiFileOutputStream
extends OutputStream {
    private final int splitSize;
    private final MultiFileNamer namer;
    private FileOutputStream stream;
    private int currentSize;

    private void beginNewFile() {
        this.stream.close();
        this.currentSize = 0;
        String string = this.namer.nextFileName();
        try {
            this.stream = new FileOutputStream(string);
        }
        catch (FileNotFoundException fileNotFoundException) {
            throw new IOException(new StringBuffer().append("Can't open file: ").append(string).toString());
        }
    }

    public MultiFileOutputStream(String string, String string2, int n, int n2, int n3) {
        this.splitSize = n3;
        this.namer = new MultiFileNamer(string, string2, n, n2);
        this.stream = new FileOutputStream(this.namer.nextFileName());
    }

    public MultiFileOutputStream(String string, String string2, int n) {
        this(string, string2, 4, 0, n);
    }

    @Override
    public void close() {
        super.close();
        this.stream.close();
    }

    @Override
    public void write(int n) {
        if (this.currentSize + 1 > this.splitSize) {
            this.beginNewFile();
        }
        this.stream.write(n);
        ++this.currentSize;
    }

    @Override
    public void write(byte[] byArray) {
        int n = byArray.length;
        if (this.currentSize + n > this.splitSize) {
            this.beginNewFile();
        }
        this.stream.write(byArray);
        this.currentSize += n;
    }

    @Override
    public void write(byte[] byArray, int n, int n2) {
        if (this.currentSize + n2 > this.splitSize) {
            this.beginNewFile();
        }
        this.stream.write(byArray, n, n2);
        this.currentSize += n2;
    }
}

