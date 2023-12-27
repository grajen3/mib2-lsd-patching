/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.filetransfer.util;

public class FileTransferUtils$IdGenerator {
    private static long lastId = 0L;

    public static synchronized long getUniqueId() {
        long l = ++lastId;
    }
}

