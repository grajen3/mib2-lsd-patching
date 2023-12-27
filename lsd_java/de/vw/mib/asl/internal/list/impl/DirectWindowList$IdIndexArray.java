/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

class DirectWindowList$IdIndexArray {
    static final int NO_MATCH;
    final long[] ids;
    final int[] indices;
    int count;
    int matchIndex = -1;

    DirectWindowList$IdIndexArray(int n) {
        this.ids = new long[n];
        this.indices = new int[n];
    }

    void sort() {
        int n;
        int n2 = this.count;
        for (n = 0; n < n2; ++n) {
            this.indices[n] = n;
        }
        for (n = 0; n < n2 - 1; ++n) {
            int n3;
            long l = this.ids[n];
            int n4 = n;
            for (n3 = n + 1; n3 < n2; ++n3) {
                long l2 = this.ids[n3];
                if (l2 >= l) continue;
                l = l2;
                n4 = n3;
            }
            if (n4 == n) continue;
            this.ids[n4] = this.ids[n];
            this.ids[n] = l;
            n3 = this.indices[n4];
            this.indices[n4] = this.indices[n];
            this.indices[n] = n3;
        }
    }

    int findID(long l) {
        int n = 0;
        int n2 = this.count - 1;
        int n3 = -1;
        while (n3 == -1 && n <= n2) {
            int n4 = n + n2 >> 1;
            long l2 = this.ids[n4];
            if (l2 == l) {
                n3 = n4;
                continue;
            }
            if (l2 < l) {
                n = n4 + 1;
                continue;
            }
            n2 = n4 - 1;
        }
        return n3 == -1 ? -1 : this.indices[n3];
    }

    static boolean findMatch(DirectWindowList$IdIndexArray directWindowList$IdIndexArray, DirectWindowList$IdIndexArray directWindowList$IdIndexArray2) {
        directWindowList$IdIndexArray.matchIndex = -1;
        directWindowList$IdIndexArray2.matchIndex = -1;
        int n = directWindowList$IdIndexArray.count;
        int n2 = directWindowList$IdIndexArray2.count;
        int n3 = 0;
        int n4 = 0;
        boolean bl = false;
        while (!bl && n3 < n && n4 < n2) {
            long l = directWindowList$IdIndexArray.ids[n3];
            long l2 = directWindowList$IdIndexArray2.ids[n4];
            if (l == -1L) {
                ++n3;
                continue;
            }
            if (l2 == -1L) {
                ++n4;
                continue;
            }
            if (l == l2) {
                directWindowList$IdIndexArray.matchIndex = directWindowList$IdIndexArray.indices[n3];
                directWindowList$IdIndexArray2.matchIndex = directWindowList$IdIndexArray2.indices[n4];
                bl = true;
                continue;
            }
            if (l < l2) {
                ++n3;
                continue;
            }
            ++n4;
        }
        return bl;
    }
}

