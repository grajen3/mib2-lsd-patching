/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.error;

import java.io.PrintStream;

public interface DumpInfoProvider {
    default public String getName() {
    }

    default public void dump(PrintStream printStream, String string) {
    }
}

