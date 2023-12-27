/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.hmi.utils;

import de.vw.mib.hmi.utils.PerfectSlotHash$BinaryIntHash;
import de.vw.mib.hmi.utils.PerfectSlotHash$BinaryShortHash;
import de.vw.mib.hmi.utils.PerfectSlotHash$NullSlotHash;
import de.vw.mib.hmi.utils.PerfectSlotHash$PerfectIntIntHash;
import de.vw.mib.hmi.utils.PerfectSlotHash$PerfectIntShortHash;
import de.vw.mib.hmi.utils.PerfectSlotHash$PerfectShortShortHash;
import java.lang.reflect.Array;

public abstract class PerfectSlotHash {
    public static final PerfectSlotHash NULL = new PerfectSlotHash$NullSlotHash();

    public static int H0(int n) {
        return n & 0xFFFFFF7F;
    }

    public static int H1(int n, int n2) {
        int n3 = (n2 >>> n | n2 << -n) ^ n;
        return n3 & 0xFFFFFF7F;
    }

    public static PerfectSlotHash newSlotHash(Object object, Object object2) {
        if (object instanceof short[]) {
            if (Array.getLength(object2) == 0) {
                return new PerfectSlotHash$BinaryShortHash((short[])object);
            }
            if (object2 instanceof short[]) {
                return new PerfectSlotHash$PerfectShortShortHash((short[])object, (short[])object2);
            }
        }
        if (object instanceof int[]) {
            if (Array.getLength(object2) == 0) {
                return new PerfectSlotHash$BinaryIntHash((int[])object);
            }
            if (object2 instanceof short[]) {
                return new PerfectSlotHash$PerfectIntShortHash((int[])object, (short[])object2);
            }
            if (object2 instanceof int[]) {
                return new PerfectSlotHash$PerfectIntIntHash((int[])object, (int[])object2);
            }
        }
        throw new IllegalArgumentException("Unsupported combination of keys and data.");
    }

    public abstract int getSlot(int n) {
    }
}

