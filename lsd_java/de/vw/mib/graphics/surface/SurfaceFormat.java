/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.surface;

import de.vw.mib.graphics.math.Util;

public final class SurfaceFormat {
    public static final int COLOR_RGB565;
    public static final int COLOR_RGBA5551;
    public static final int COLOR_RGBA4;
    public static final int COLOR_RGB8;
    public static final int COLOR_RGBA8;
    public static final int DEPTH_COMPONENT16;
    public static final int DEPTH_COMPONENT24;
    public static final int DEPTH_COMPONENT32;
    public static final int STENCIL_INDEX1;
    public static final int STENCIL_INDEX4;
    public static final int STENCIL_INDEX8;
    public static final int DEPTH_COMPONENT24_STENCIL_INDEX8;

    private SurfaceFormat() {
    }

    public static int getSurfaceSize(int n, int n2, int n3) {
        int n4 = n2 * n3;
        switch (n) {
            case 4352: 
            case 4353: 
            case 4354: 
            case 4864: {
                return 2 * n4;
            }
            case 4355: 
            case 4865: {
                return 3 * n4;
            }
            case 4356: 
            case 4866: 
            case 5376: {
                return 4 * n4;
            }
            case 5120: {
                return Util.divideAndCeil(n4, 8);
            }
            case 5121: {
                return Util.divideAndCeil(n4, 4);
            }
            case 5122: {
                return 1 * n4;
            }
        }
        throw new IllegalStateException("Invalid surface format");
    }
}

