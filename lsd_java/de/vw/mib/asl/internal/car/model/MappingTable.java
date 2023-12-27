/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model;

public class MappingTable {
    private static final int[][] TABLE_REASON = new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 8}, {6, 14}, {7, 13}};

    public static int getModelValue(int n) {
        for (int i2 = 0; i2 < TABLE_REASON.length; ++i2) {
            if (TABLE_REASON[i2][1] != n) continue;
            return TABLE_REASON[i2][0];
        }
        return 6;
    }
}

