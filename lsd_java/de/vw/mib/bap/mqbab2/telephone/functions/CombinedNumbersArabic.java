/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.functions;

import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CombinedNumbers_Data;
import de.vw.mib.bap.mqbab2.telephone.functions.CombinedNumbers;

public class CombinedNumbersArabic
extends CombinedNumbers {
    @Override
    protected void setTelNumberAndPbName(CombinedNumbers_Data combinedNumbers_Data, String string, String string2) {
        if (BAPString.isArabic(string2)) {
            super.setTelNumberAndPbName(combinedNumbers_Data, string, null);
        } else {
            super.setTelNumberAndPbName(combinedNumbers_Data, string, string2);
        }
    }
}

