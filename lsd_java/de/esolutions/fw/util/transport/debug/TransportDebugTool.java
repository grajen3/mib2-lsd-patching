/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.debug;

import de.esolutions.fw.util.commons.Buffer;

public class TransportDebugTool {
    public static void decodeState(int n, Buffer buffer) {
        if ((n & 1) == 1) {
            buffer.append("TX ");
        } else if ((n & 2) == 2) {
            buffer.append("rx ");
        }
        if ((n & 8) == 8) {
            buffer.append("enter ");
        } else if ((n & 4) == 4) {
            buffer.append("inside ");
        } else if ((n & 0x10) == 16) {
            buffer.append("leave ");
        } else if ((n & 0x20) == 32) {
            buffer.append("ERROR ");
        }
        if ((n & 0x100) == 256) {
            buffer.append("syscall ");
        } else if ((n & 0x200) == 512) {
            buffer.append("packet ");
        } else if ((n & 0x400) == 1024) {
            buffer.append("queue ");
        } else if ((n & 0x800) == 2048) {
            buffer.append("app ");
        } else if ((n & 0x1000) == 4096) {
            buffer.append("callback");
        }
    }
}

