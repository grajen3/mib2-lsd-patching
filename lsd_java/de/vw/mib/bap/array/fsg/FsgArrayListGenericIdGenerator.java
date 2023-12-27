/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.array.fsg;

import de.vw.mib.bap.array.fsg.FsgArrayListIdGenerator;

class FsgArrayListGenericIdGenerator
implements FsgArrayListIdGenerator {
    private final int maxID;
    private final int minID;
    private int nextID;
    private static final int TRANSMIT_LONG_ID_THRESHOLD;

    FsgArrayListGenericIdGenerator(int n, int n2) {
        this.maxID = n;
        this.minID = n2;
        this.nextID = 0;
    }

    @Override
    public boolean isLongID() {
        return this.nextID > 255;
    }

    @Override
    public int createBAPPosID(long l) {
        this.nextID %= this.maxID;
        return this.nextID++ + this.minID;
    }

    @Override
    public void reset() {
        this.nextID = 0;
    }

    @Override
    public boolean isBAPPosIDValid(int n, long l) {
        return n <= 255 || this.nextID >= 255;
    }
}

