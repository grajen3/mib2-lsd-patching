/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.mqbab2.audiosd.functions.ReceptionList;

public class ReceptionListArabic
extends ReceptionList {
    @Override
    protected String computeReceptionListName(int n, String string, String string2) {
        String string3 = BAPString.isArabic(string) ? string2 : super.computeReceptionListName(n, string, string2);
        return string3;
    }
}

