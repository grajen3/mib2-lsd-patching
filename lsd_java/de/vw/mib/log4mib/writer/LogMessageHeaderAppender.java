/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib.writer;

import de.vw.mib.log4mib.writer.LogMessageHeaderAppender$1;
import de.vw.mib.util.StringBuilder;

public interface LogMessageHeaderAppender {
    public static final LogMessageHeaderAppender DEFAULT = new LogMessageHeaderAppender$1();

    default public StringBuilder appendHeader(long l, int n, int n2, int n3, int n4, StringBuilder stringBuilder) {
    }
}

