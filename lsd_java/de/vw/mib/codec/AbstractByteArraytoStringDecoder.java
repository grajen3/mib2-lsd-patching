/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.codec;

import de.vw.mib.codec.ByteArrayDecoder;
import de.vw.mib.codec.ByteArrayReader;
import de.vw.mib.util.StringBuilder;

public abstract class AbstractByteArraytoStringDecoder
extends StringBuilder
implements ByteArrayDecoder {
    @Override
    public void read(boolean bl) {
        this.append(bl);
    }

    @Override
    public void read(char c2) {
        this.append(c2);
    }

    @Override
    public void read(double d2) {
        this.append(d2);
    }

    @Override
    public void read(float f2) {
        this.append(f2);
    }

    @Override
    public void read(int n) {
        this.append(n);
    }

    @Override
    public void read(long l) {
        this.append(l);
    }

    @Override
    public void read(String string) {
        this.append(string);
    }

    @Override
    public void readNull() {
        this.append("null");
    }

    @Override
    public void readInvocationContext(ByteArrayReader byteArrayReader) {
        byteArrayReader.readInt();
        byteArrayReader.readInt();
        byteArrayReader.readInt();
    }

    @Override
    public void readStackTrace(String string) {
        this.append(string);
    }
}

