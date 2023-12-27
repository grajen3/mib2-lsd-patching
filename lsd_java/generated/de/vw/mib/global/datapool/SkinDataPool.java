/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.global.datapool;

import de.vw.mib.graphics.Color;

public final class SkinDataPool {
    static Color[][] ColorVectors = new Color[118][];
    static int[] ImageVectors = new int[59];
    static int[] Integers = new int[191];
    static int[][] IntegerVectors = new int[3][];

    private SkinDataPool() {
    }

    public static void setColorVector(int n, Color[] colorArray) {
        SkinDataPool.ColorVectors[n] = colorArray;
    }

    public static Color[] getColorVector(int n) {
        return ColorVectors[n];
    }

    public static void setImageVector(int n, int n2) {
        SkinDataPool.ImageVectors[n] = n2;
    }

    public static int getImageVector(int n) {
        return ImageVectors[n];
    }

    public static void setInteger(int n, int n2) {
        SkinDataPool.Integers[n] = n2;
    }

    public static int getInteger(int n) {
        return Integers[n];
    }

    public static void setIntegerVector(int n, int[] nArray) {
        SkinDataPool.IntegerVectors[n] = nArray;
    }

    public static int[] getIntegerVector(int n) {
        return IntegerVectors[n];
    }
}

