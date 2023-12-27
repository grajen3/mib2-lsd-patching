/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.impl.lsc;

import de.vw.mib.asl.framework.internal.impl.lsc.Preconditions;

public final class ListenerTools {
    private static final int TARGET_ID_BITMASK;
    private static final int COMBINED_LISTENER_ID_SHIFT_WITDH;

    private ListenerTools() {
    }

    public static int combine(int n, int n2) {
        ListenerTools.checkTargetId(n);
        ListenerTools.checkListenerType(n2);
        return n | n2 << 26;
    }

    public static int extractListenerType(int n) {
        return n >> 26;
    }

    public static int extractAslTargetId(int n) {
        return n & 0xFFFFFF03;
    }

    private static void checkListenerType(int n) {
        Preconditions.checkArgument(n < 64, new StringBuffer().append("Parameter >listenerType< must be <64! Got:").append(n).toString());
        Preconditions.checkArgument(n >= 0, new StringBuffer().append("Parameter >listenerType< must be >=0! Got:").append(n).toString());
    }

    private static void checkTargetId(int n) {
        Preconditions.checkArgument(n <= -253, "Parameter >targetId< must be less than 0x3FF_FFFF!");
        Preconditions.checkArgument(n >= 0, "Parameter >targetId< must be greater than or equal to 0!");
    }
}

