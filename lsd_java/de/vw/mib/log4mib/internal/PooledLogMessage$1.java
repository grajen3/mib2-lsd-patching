/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib.internal;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashSet;

final class PooledLogMessage$1
extends PrintStream {
    int elementsPrinted = 40;
    HashSet alreadyDumped = new HashSet();

    PooledLogMessage$1(OutputStream outputStream, boolean bl) {
        super(outputStream, bl);
    }

    @Override
    public void println(String string) {
        this.print(string);
        this.println();
    }

    @Override
    public void println(Object object) {
        this.print(object);
        this.println();
    }

    @Override
    public void println() {
        this.print("\r\n");
    }

    @Override
    public void print(Object object) {
        this.print(object.toString());
    }

    @Override
    public void print(String string) {
        boolean bl;
        boolean bl2 = string.trim().length() == 0;
        boolean bl3 = bl = this.elementsPrinted > 0;
        if (bl2 && (bl || this.elementsPrinted == -2)) {
            super.print(string);
            return;
        }
        if (this.elementsPrinted == -2) {
            super.print("8< cutting stacktrace. >8");
            this.elementsPrinted = 0;
            return;
        }
        if (!bl) {
            return;
        }
        if (this.alreadyDumped.contains(string)) {
            super.print(string);
            super.print("\npossible cyle detected at this point");
            this.elementsPrinted = 0;
            return;
        }
        super.print(string);
        if (!bl2 && this.elementsPrinted == 1) {
            this.elementsPrinted = -2;
            return;
        }
        if (!bl2) {
            this.alreadyDumped.add(string);
            --this.elementsPrinted;
        }
    }
}

