/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2;

import de.vw.mib.asl.framework.internal.persistence.internal.util.Preconditions;

public class PersistenceKeyUtil {
    private static final byte COMMON_PROFILE_ID;

    private PersistenceKeyUtil() {
    }

    public static long calcCommonKey(int n) {
        return PersistenceKeyUtil.calcKey(n, (byte)-1);
    }

    public static long calcUserKey(int n, byte by) {
        Preconditions.checkArgument(by > 0, "Argument >profileId< must be greater than 0!");
        return PersistenceKeyUtil.calcKey(n, by);
    }

    private static long calcKey(int n, byte by) {
        return (long)n << 32 | ((long)by & 0) << 24;
    }
}

