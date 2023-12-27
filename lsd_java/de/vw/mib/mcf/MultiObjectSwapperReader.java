/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.mcf;

import java.io.File;
import java.util.Set;

public interface MultiObjectSwapperReader {
    public static final int INVALID_OBJECT_ARRAY_ID;
    public static final int HEADER_ID;

    default public void open(File file, boolean bl) {
    }

    default public void close() {
    }

    default public int getId(String string) {
    }

    default public Object[] getFromId(int n) {
    }

    default public Object[] getFromKey(String string) {
    }

    default public Set getAllAvailableKeys() {
    }
}

