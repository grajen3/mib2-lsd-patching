/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.impl;

import javax.media.opengl.GL;

class Util {
    private int[] scratch = new int[1];

    Util() {
    }

    protected static int ceil(int n, int n2) {
        return n % n2 == 0 ? n / n2 : n / n2 + 1;
    }

    protected static int compPerPix(int n) {
        switch (n) {
            case 6401: 
            case 6402: 
            case 6406: 
            case 6409: {
                return 1;
            }
            case 6410: {
                return 2;
            }
            case 6407: {
                return 3;
            }
            case 6408: {
                return 4;
            }
        }
        return -1;
    }

    protected static int nearestPower(int n) {
        int n2 = 1;
        if (n == 0) {
            return -1;
        }
        while (n != 1) {
            if (n == 3) {
                return n2 << 2;
            }
            n >>= 1;
            n2 <<= 1;
        }
        return n2;
    }

    protected static int bytesPerPixel(int n, int n2) {
        int n3;
        int n4;
        switch (n) {
            case 6401: 
            case 6402: 
            case 6406: 
            case 6409: {
                n4 = 1;
                break;
            }
            case 6410: {
                n4 = 2;
                break;
            }
            case 6407: {
                n4 = 3;
                break;
            }
            case 6408: {
                n4 = 4;
                break;
            }
            default: {
                n4 = 0;
            }
        }
        switch (n2) {
            case 5121: {
                n3 = 1;
                break;
            }
            case 5120: {
                n3 = 1;
                break;
            }
            case 5123: {
                n3 = 2;
                break;
            }
            case 5122: {
                n3 = 2;
                break;
            }
            case 5125: {
                n3 = 4;
                break;
            }
            case 5124: {
                n3 = 4;
                break;
            }
            case 5126: {
                n3 = 4;
                break;
            }
            default: {
                n3 = 0;
            }
        }
        return n4 * n3;
    }

    protected int glGetIntegerv(GL gL, int n) {
        gL.glGetIntegerv(n, this.scratch, 0);
        return this.scratch[0];
    }
}

