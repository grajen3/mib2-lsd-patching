/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.datapool.internal;

import de.vw.mib.datapool.internal.I18nLanguageDelta;
import de.vw.mib.datapool.internal.I18nLanguageFull;
import de.vw.mib.hmi.utils.MagicNumber;
import de.vw.mib.hmi.utils.ResData;
import de.vw.mib.i18n.I18nLanguage;

public abstract class I18nLanguageBase
implements I18nLanguage {
    protected static final int NOT_AVAILABLE;
    private static final int TEXT_ARRAY_INDEX;
    private static final int SCALAR_ARRAY_INDEX;
    protected final int checksum;
    private String[] rawTexts;
    private int[] rawScalars;
    protected final String[] scalars;
    private int notLoadedScalars;
    private int[][] rawArrays;
    protected final String[][] arrays;
    private int notLoadedArrays;

    public static I18nLanguage createFullLanguage(Object[] objectArray) {
        return new I18nLanguageFull(objectArray);
    }

    public static I18nLanguage createDeltaLanguage(Object[] objectArray) {
        return new I18nLanguageDelta(objectArray);
    }

    I18nLanguageBase(Object[] objectArray, MagicNumber magicNumber, int n) {
        I18nLanguageBase.checkCompatible("magic number", magicNumber.getIntValue(), ResData.getHeaderInfo(objectArray, 0, 0));
        this.checksum = ResData.getHeaderInfo(objectArray, 1, 0);
        this.rawTexts = (String[])objectArray[1];
        this.rawScalars = (int[])objectArray[2];
        this.scalars = new String[this.rawScalars.length];
        this.notLoadedScalars = this.rawScalars.length;
        this.rawArrays = I18nLanguageBase.copyRawArrays(objectArray, n, objectArray.length);
        this.arrays = new String[this.rawArrays.length][];
        this.notLoadedArrays = this.rawArrays.length;
    }

    private static int[][] copyRawArrays(Object[] objectArray, int n, int n2) {
        int[][] nArrayArray = new int[n2 - n][];
        System.arraycopy((Object)objectArray, n, nArrayArray, 0, n2 - n);
        return nArrayArray;
    }

    @Override
    public abstract int getScaleStringUpperLimit() {
    }

    @Override
    public String getScalarString(int n) {
        this.checkIndex("scale index", n, this.getScaleStringUpperLimit());
        int n2 = this.getScalarSlot(n);
        if (n2 == -1) {
            return null;
        }
        if (this.scalars[n2] == null) {
            this.loadScalar(n2);
        }
        return this.scalars[n2];
    }

    @Override
    public abstract int getStringArrayUpperLimit() {
    }

    @Override
    public String[] getStringArray(int n) {
        this.checkIndex("array index", n, this.getStringArrayUpperLimit());
        int n2 = this.getArraySlot(n);
        if (n2 == -1) {
            return null;
        }
        if (this.arrays[n2] == null) {
            this.loadArray(n2);
        }
        return this.arrays[n2];
    }

    private void checkIndex(String string, int n, int n2) {
        if (n < 0 || n >= n2) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("The ").append(string).append(" is out of range [0..").append(n2).append(").").toString());
        }
    }

    protected abstract int getScalarSlot(int n) {
    }

    protected abstract int getArraySlot(int n) {
    }

    private void loadScalar(int n) {
        int n2 = this.rawScalars[n];
        this.scalars[n] = this.rawTexts[n2];
        this.unloadRawScalars();
    }

    private void loadArray(int n) {
        int[] nArray = this.rawArrays[n];
        String[] stringArray = new String[nArray.length];
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            stringArray[i2] = this.rawTexts[nArray[i2]];
        }
        this.arrays[n] = stringArray;
        this.unloadRawArrays(n);
    }

    private void unloadRawScalars() {
        --this.notLoadedScalars;
        if (this.notLoadedScalars == 0) {
            this.rawScalars = null;
            this.unloadRawTexts();
        }
    }

    private void unloadRawArrays(int n) {
        --this.notLoadedArrays;
        if (this.notLoadedArrays == 0) {
            this.rawArrays = null;
            this.unloadRawTexts();
        } else {
            this.rawArrays[n] = null;
        }
    }

    private void unloadRawTexts() {
        if (this.notLoadedScalars == 0 && this.notLoadedArrays == 0) {
            this.rawTexts = null;
        }
    }

    @Override
    public void checkCompatibility(I18nLanguage i18nLanguage) {
        String string;
        String string2 = string = i18nLanguage == null ? "null" : super.getClass().getName();
        if (!(i18nLanguage instanceof I18nLanguageBase) || super.getClass() != super.getClass()) {
            throw new IllegalArgumentException(new StringBuffer().append("Expecting type ").append(super.getClass().getName()).append(" but was ").append(string).append(".").toString());
        }
        I18nLanguageBase i18nLanguageBase = (I18nLanguageBase)i18nLanguage;
        I18nLanguageBase.checkCompatible("checksum", this.checksum, i18nLanguageBase.checksum);
        I18nLanguageBase.checkCompatible("scalar string upper limit", this.getScaleStringUpperLimit(), i18nLanguageBase.getScaleStringUpperLimit());
        I18nLanguageBase.checkCompatible("string array upper limit", this.getStringArrayUpperLimit(), i18nLanguageBase.getStringArrayUpperLimit());
    }

    protected static void checkCompatible(String string, int n, int n2) {
        if (n != n2) {
            String string2 = new StringBuffer().append("Expecting ").append(string).append(" to be ").append(n).append(" but was ").append(n2).append(".").toString();
            throw new IllegalArgumentException(string2);
        }
    }
}

