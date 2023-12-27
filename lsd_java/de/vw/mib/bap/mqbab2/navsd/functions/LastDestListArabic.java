/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.navsd.functions;

import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.mqbab2.navsd.functions.LastDestList;

public class LastDestListArabic
extends LastDestList {
    @Override
    protected boolean isLastDestEntryDataValid(String string, int n) {
        return super.isLastDestEntryDataValid(string, n) && !BAPString.isArabic(string);
    }
}

