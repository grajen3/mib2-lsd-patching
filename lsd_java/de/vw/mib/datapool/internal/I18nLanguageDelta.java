/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.datapool.internal;

import de.vw.mib.collections.ints.IntIntMap;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.datapool.internal.I18nLanguageBase;
import de.vw.mib.hmi.utils.MagicNumber;
import de.vw.mib.hmi.utils.ResData;

final class I18nLanguageDelta
extends I18nLanguageBase {
    private static final int HEADER_SCALAR_UPPER_LIMIT;
    private static final int HEADER_ARRAY_UPPER_LIMIT;
    private static final int DELTA_SCALAR_INDICES_INDEX;
    private static final int DELTA_ARRAY_INDICES_INDEX;
    private static final int DELTA_ARRAY_ARRAY_START_INDEX;
    private final int scalarUpperLimit;
    private final int arrayUpperLimit;
    private final IntIntMap scalarSlots;
    private final IntIntMap arraySlots;

    I18nLanguageDelta(Object[] objectArray) {
        super(objectArray, MagicNumber.I18N_DELTA, 5);
        this.scalarUpperLimit = ResData.getHeaderInfo(objectArray, 3, 0);
        this.arrayUpperLimit = ResData.getHeaderInfo(objectArray, 4, 0);
        this.scalarSlots = I18nLanguageDelta.buildSlots((int[])objectArray[3]);
        this.arraySlots = I18nLanguageDelta.buildSlots((int[])objectArray[4]);
    }

    private static IntIntMap buildSlots(int[] nArray) {
        IntIntOptHashMap intIntOptHashMap = IntIntOptHashMap.createWithNeutralValue(nArray.length, 1.0f, 0.0f, -1);
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            intIntOptHashMap.put(nArray[i2], i2);
        }
        return intIntOptHashMap;
    }

    @Override
    public int getScaleStringUpperLimit() {
        return this.scalarUpperLimit;
    }

    @Override
    public int getStringArrayUpperLimit() {
        return this.arrayUpperLimit;
    }

    @Override
    protected int getScalarSlot(int n) {
        return this.scalarSlots.get(n);
    }

    @Override
    protected int getArraySlot(int n) {
        return this.arraySlots.get(n);
    }
}

