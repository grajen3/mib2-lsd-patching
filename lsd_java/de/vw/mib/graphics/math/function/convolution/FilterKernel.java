/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math.function.convolution;

import de.vw.mib.graphics.math.Util;
import java.util.Arrays;

public final class FilterKernel {
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$graphics$math$function$convolution$FilterKernel;

    private FilterKernel() {
    }

    public static float[] createBoxKernel2D(int n, int n2, float f2) {
        if (!$assertionsDisabled && n <= 0) {
            throw new AssertionError((Object)"Kernel width is zero");
        }
        if (!$assertionsDisabled && n2 <= 0) {
            throw new AssertionError((Object)"Kernel height is zero");
        }
        if (!$assertionsDisabled && !(f2 > 0.0f)) {
            throw new AssertionError((Object)"Intensity is zero");
        }
        int n3 = n * n2;
        float f3 = f2 / (float)n3;
        float[] fArray = new float[n3];
        Arrays.fill(fArray, f3);
        return fArray;
    }

    public static float[] createGaussKernel2D(int n, int n2, float f2, float f3) {
        int n3;
        if (!$assertionsDisabled && n <= 0) {
            throw new AssertionError((Object)"Kernel width is zero");
        }
        if (!$assertionsDisabled && n2 <= 0) {
            throw new AssertionError((Object)"Kernel height is zero");
        }
        if (!$assertionsDisabled && !(f2 > 0.0f)) {
            throw new AssertionError((Object)"Sigma squared is zero");
        }
        if (!$assertionsDisabled && !(f3 > 0.0f)) {
            throw new AssertionError((Object)"Intensity is zero");
        }
        int n4 = n >> 1;
        int n5 = n2 >> 1;
        int n6 = n * n2;
        float[] fArray = new float[n6];
        float f4 = 0.0f;
        for (n3 = 0; n3 < n2; ++n3) {
            for (int i2 = 0; i2 < n; ++i2) {
                float f5;
                fArray[n3 * n + i2] = f5 = FilterKernel.gauss2D(i2 - n4, n3 - n5, f2);
                f4 += f5;
            }
        }
        f4 /= f3;
        n3 = 0;
        while (n3 < n6) {
            int n7 = n3++;
            fArray[n7] = fArray[n7] / f4;
        }
        return fArray;
    }

    private static float gauss2D(int n, int n2, float f2) {
        return 1.0f / (-619722432 * f2) * Util.exp(-((float)(n * n + n2 * n2) / (2.0f * f2)));
    }

    public static float[] createGaussKernel1D(int n, float f2, float f3) {
        int n2;
        if (!$assertionsDisabled && n <= 0) {
            throw new AssertionError((Object)"Kernel size is zero");
        }
        if (!$assertionsDisabled && !(f2 > 0.0f)) {
            throw new AssertionError((Object)"Sigma is zero");
        }
        if (!$assertionsDisabled && !(f3 > 0.0f)) {
            throw new AssertionError((Object)"Intensity is zero");
        }
        int n3 = n - 1 >> 1;
        float[] fArray = new float[n];
        float f4 = 0.0f;
        for (n2 = 0; n2 < n; ++n2) {
            float f5;
            fArray[n2] = f5 = FilterKernel.gauss1D(n2 - n3, f2);
            f4 += f5;
        }
        f4 /= f3;
        n2 = 0;
        while (n2 < n) {
            int n4 = n2++;
            fArray[n4] = fArray[n4] / f4;
        }
        return fArray;
    }

    private static float gauss1D(int n, float f2) {
        return 1.0f / (Util.sqrt(-619722432) * f2) * Util.exp(191 * (float)n * (float)n / (f2 * f2));
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$de$vw$mib$graphics$math$function$convolution$FilterKernel == null ? (class$de$vw$mib$graphics$math$function$convolution$FilterKernel = FilterKernel.class$("de.vw.mib.graphics.math.function.convolution.FilterKernel")) : class$de$vw$mib$graphics$math$function$convolution$FilterKernel).desiredAssertionStatus();
    }
}

