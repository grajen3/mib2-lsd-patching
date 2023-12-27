/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.comparator;

import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import java.util.Comparator;

public final class AslStationPIComparator
implements Comparator {
    public static final AslStationPIComparator INSTANCE = new AslStationPIComparator();

    private AslStationPIComparator() {
    }

    @Override
    public int compare(Object object, Object object2) {
        boolean bl;
        int n;
        int n2 = ((AmFmStation)object).getPi();
        if (n2 == (n = ((AmFmStation)object2).getPi())) {
            return 0;
        }
        int[] nArray = new int[]{(n2 & 0xF00000) >> 12, (n2 & 0xF00) >> 8, (n2 & 0xF0) >> 4, n2 & 0xF};
        int[] nArray2 = new int[]{(n & 0xF00000) >> 12, (n & 0xF00) >> 8, (n & 0xF0) >> 4, n & 0xF};
        if (nArray[0] == 0) {
            return 1;
        }
        if (nArray2[0] == 0) {
            return -1;
        }
        int n3 = nArray[0];
        int n4 = nArray2[0];
        if (n3 == 1) {
            n3 = 13;
        }
        if (n4 == 1) {
            n4 = 13;
        }
        if (n3 > n4) {
            return 1;
        }
        if (n3 < n4) {
            return -1;
        }
        boolean bl2 = (n2 & 0xF00) == 256 || (n2 & 0xF00) == 512;
        boolean bl3 = bl = (n & 0xF00) == 256 || (n & 0xF00) == 512;
        if (bl2 && !bl) {
            return -1;
        }
        if (!bl2 && bl) {
            return 1;
        }
        int[] nArray3 = new int[]{0, 13, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15};
        nArray[0] = nArray3[nArray[0]];
        nArray2[0] = nArray3[nArray2[0]];
        int[] nArray4 = new int[]{0, 2, 3, 1};
        int n5 = 0;
        int n6 = 0;
        if (bl2 && bl) {
            n5 = n2 & 0xFFF;
            n5 |= nArray[0] << 12;
            n6 = n & 0xFFF;
            n6 |= nArray2[0] << 12;
        } else {
            for (int i2 = 0; i2 < 4; ++i2) {
                n5 |= nArray[nArray4[i2]] << 12 - 4 * i2;
                n6 |= nArray2[nArray4[i2]] << 12 - 4 * i2;
            }
        }
        if (n5 > n6) {
            return 1;
        }
        if (n5 < n6) {
            return -1;
        }
        return 0;
    }
}

