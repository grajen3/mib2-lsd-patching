/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.mqbab2.audiosd.functions.ReceptionList;

public class ReceptionListNar
extends ReceptionList {
    @Override
    protected final String formatFrequency(int n, int n2, int n3) {
        return this.getFixFormatter().fmtIcFrequencyNAR(n, n2, n3);
    }

    @Override
    protected String computeReceptionListName(int n, String string, String string2) {
        String string3 = n == 1 || n == 0 ? string2 : super.computeReceptionListName(n, string, string2);
        return string3;
    }
}

