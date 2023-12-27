/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.arrays;

import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayList;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListComplete;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListGenericIdGenerator;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListIdGenerator;

public class FsgArrayListFactory {
    private static FsgArrayListFactory fsgArrayListFactory = null;
    private static final int MIN_8_BIT_BAP_ID;
    private static final int MAX_8_BIT_BAP_ID;
    private static final int MIN_16_BIT_BAP_ID;
    private static final int MAX_16_BIT_BAP_ID;

    public FsgArrayList createCompleteFsgArrayList(FsgArrayListIdGenerator fsgArrayListIdGenerator) {
        return new FsgArrayListComplete(fsgArrayListIdGenerator);
    }

    public FsgArrayList createCompleteFsgArrayList(boolean bl) {
        return bl ? this.createCompleteFsgArrayList(new FsgArrayListGenericIdGenerator(-65536, 1)) : this.createCompleteFsgArrayList(new FsgArrayListGenericIdGenerator(255, 1));
    }

    public static FsgArrayListFactory getInstance() {
        if (fsgArrayListFactory == null) {
            fsgArrayListFactory = new FsgArrayListFactory();
        }
        return fsgArrayListFactory;
    }
}

