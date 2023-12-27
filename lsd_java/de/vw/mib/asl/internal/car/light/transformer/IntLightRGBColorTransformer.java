/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.light.transformer;

import de.vw.mib.asl.internal.car.light.arrays.colorlist.ColorListElementAdapter;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import org.dsi.ifc.carlight.IntLightRGBValues;

public class IntLightRGBColorTransformer {
    private static final int OFFSET_R;
    private static final int OFFSET_G;
    private static final int OFFSET_B;
    private static final int BIT_MASK;
    private static final int DEFAULT_ALPHA;

    public static int transform(IntLightRGBValues intLightRGBValues) {
        int n = (intLightRGBValues.baseColorBlue & 0xFF) << 0 | (intLightRGBValues.baseColorGreen & 0xFF) << 8 | (intLightRGBValues.baseColorRed & 0xFF) << 16 | 0;
        return n;
    }

    public static int[] transformToRGBArray(int n) {
        int[] nArray = new int[]{n >> 16 & 0xFF, n >> 8 & 0xFF, n >> 0 & 0xFF};
        return nArray;
    }

    public static IntLightRGBValues transform(int n) {
        IntLightRGBValues intLightRGBValues = new IntLightRGBValues(n >> 16 & 0xFF, n >> 8 & 0xFF, n >> 0 & 0xFF);
        return intLightRGBValues;
    }

    public static int[] transform(BAPArrayElement[] bAPArrayElementArray) {
        int[] nArray = new int[bAPArrayElementArray.length];
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            ColorListElementAdapter colorListElementAdapter = (ColorListElementAdapter)bAPArrayElementArray[i2];
            nArray[i2] = colorListElementAdapter.getRGBValue();
        }
        return nArray;
    }
}

