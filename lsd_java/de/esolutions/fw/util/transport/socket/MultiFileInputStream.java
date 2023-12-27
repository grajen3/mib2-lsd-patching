/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.socket;

import de.esolutions.fw.util.transport.socket.MultiFileNamer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class MultiFileInputStream
extends InputStream {
    private MultiFileNamer namer;
    private FileInputStream stream;

    public MultiFileInputStream(String string, String string2, int n, int n2) {
        this.namer = new MultiFileNamer(string, string2, n, n2);
        this.stream = new FileInputStream(this.namer.nextFileName());
    }

    public MultiFileInputStream(String string, String string2) {
        this(string, string2, 4, 0);
    }

    @Override
    public void close() {
        this.stream.close();
    }

    @Override
    public int read() {
        int n = this.stream.read();
        if (n == -1) {
            this.stream.close();
            try {
                this.stream = new FileInputStream(this.namer.nextFileName());
                n = this.stream.read();
            }
            catch (FileNotFoundException fileNotFoundException) {
                return -1;
            }
        }
        return n;
    }

    @Override
    public int read(byte[] byArray) {
        return this.read(byArray, 0, byArray.length);
    }

    @Override
    public int read(byte[] byArray, int n, int n2) {
        int n3 = this.stream.read(byArray, n, n2);
        if (n3 == -1) {
            this.stream.close();
            try {
                this.stream = new FileInputStream(this.namer.nextFileName());
                n3 = this.stream.read(byArray, n, n2);
            }
            catch (FileNotFoundException fileNotFoundException) {
                return -1;
            }
        }
        return n3;
    }
}

