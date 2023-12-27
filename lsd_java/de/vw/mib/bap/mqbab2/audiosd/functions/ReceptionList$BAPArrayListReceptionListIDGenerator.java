/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.mqbab2.audiosd.functions.ReceptionList;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListGenericIdGenerator;

class ReceptionList$BAPArrayListReceptionListIDGenerator
extends FsgArrayListGenericIdGenerator {
    private final /* synthetic */ ReceptionList this$0;

    public ReceptionList$BAPArrayListReceptionListIDGenerator(ReceptionList receptionList, int n, int n2) {
        this.this$0 = receptionList;
        super(n, 2);
    }

    @Override
    public int createBAPPosID(long l) {
        int n = l == this.this$0.idOfCurrentStation ? 1 : super.createBAPPosID(l);
        return n;
    }

    @Override
    public boolean isBAPPosIDValid(int n, long l) {
        boolean bl = n == 1 && l != this.this$0.idOfCurrentStation ? false : super.isBAPPosIDValid(n, l);
        return bl;
    }
}

