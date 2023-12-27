/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.arrays;

import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.mqbpq.common.arrays.BAPArrayListIDGenerator;

public class BAPArrayListGenericIDGenerator
implements BAPArrayListIDGenerator {
    private final int maxID;
    private final int minID;
    private int nextID;
    private static final int TRANSMIT_LONG_ID_THRESHOLD;

    public BAPArrayListGenericIDGenerator(int n, int n2) {
        this.maxID = n;
        this.minID = n2;
        this.nextID = 0;
    }

    @Override
    public boolean isLongID() {
        return this.nextID > 255;
    }

    @Override
    public int createBAPPosID(BAPArrayElement bAPArrayElement, long l) {
        this.nextID %= this.maxID;
        return this.nextID++ + this.minID;
    }

    @Override
    public boolean isBAPPosIDValid(int n, long l) {
        return n <= 255 || this.nextID >= 255;
    }
}

