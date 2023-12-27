/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.script;

public class ScriptWidgetUtility {
    public int indexOf(CharSequence[] charSequenceArray, CharSequence charSequence, int n) {
        for (int i2 = 0; i2 < charSequenceArray.length; ++i2) {
            if (charSequenceArray[i2] != charSequence) continue;
            return i2;
        }
        return n;
    }

    public int indexOf(float[] fArray, float f2, int n) {
        for (int i2 = 0; i2 < fArray.length; ++i2) {
            if (fArray[i2] != f2) continue;
            return i2;
        }
        return n;
    }

    public int indexOf(int[] nArray, int n, int n2) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (nArray[i2] != n) continue;
            return i2;
        }
        return n2;
    }

    public int indexOf(long[] lArray, long l, int n) {
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            if (lArray[i2] != l) continue;
            return i2;
        }
        return n;
    }

    public int indexOf(Object[] objectArray, Object object, int n) {
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            if (objectArray[i2] != object) continue;
            return i2;
        }
        return n;
    }
}

