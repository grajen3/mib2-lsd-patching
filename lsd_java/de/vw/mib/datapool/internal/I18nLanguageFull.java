/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.datapool.internal;

import de.vw.mib.datapool.internal.I18nLanguageBase;
import de.vw.mib.hmi.utils.MagicNumber;

final class I18nLanguageFull
extends I18nLanguageBase {
    private static final int FULL_ARRAY_ARRAY_START_INDEX;

    I18nLanguageFull(Object[] objectArray) {
        super(objectArray, MagicNumber.I18N, 3);
    }

    @Override
    public int getScaleStringUpperLimit() {
        return this.scalars.length;
    }

    @Override
    public int getStringArrayUpperLimit() {
        return this.arrays.length;
    }

    @Override
    protected int getScalarSlot(int n) {
        return n;
    }

    @Override
    protected int getArraySlot(int n) {
        return n;
    }
}

