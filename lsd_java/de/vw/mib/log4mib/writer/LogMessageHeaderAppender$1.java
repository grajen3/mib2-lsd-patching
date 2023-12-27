/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib.writer;

import de.vw.mib.log4mib.writer.LogMessageHeaderAppender;
import de.vw.mib.util.StringBuilder;

final class LogMessageHeaderAppender$1
implements LogMessageHeaderAppender {
    LogMessageHeaderAppender$1() {
    }

    @Override
    public StringBuilder appendHeader(long l, int n, int n2, int n3, int n4, StringBuilder stringBuilder) {
        stringBuilder.append(l).append(" ").append(this.getLevelName(n));
        stringBuilder.appendHex(n2).append(", ").appendHex(n3).append(", ").appendHex(n4);
        stringBuilder.append("]");
        return stringBuilder;
    }

    private String getLevelName(int n) {
        switch (n) {
            case 16: {
                return " TRACE [";
            }
            case 12: {
                return "NORMAL [";
            }
            case 8: {
                return "  INFO [";
            }
            case 4: {
                return "  WARN [";
            }
            case 2: {
                return " ERROR [";
            }
            case 1: {
                return " FATAL [";
            }
        }
        return "";
    }
}

