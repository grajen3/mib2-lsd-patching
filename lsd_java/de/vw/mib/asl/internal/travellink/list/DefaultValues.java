/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.list;

public final class DefaultValues {
    public static int getDefaultIntValueIfRequired(int n) {
        switch (n) {
            case 400001: {
                return 6;
            }
            case 400002: {
                return 5;
            }
            case 400003: {
                return 0;
            }
            case 400009: {
                return 0;
            }
            case 400013: {
                return 5;
            }
            case 400014: {
                return 0;
            }
            case 10000000: {
                return 7;
            }
            case 10000002: {
                return 0;
            }
            case 10000001: {
                return 0;
            }
            case 500114: {
                return 0;
            }
            case 500005: {
                return 0;
            }
            case 400604: {
                return 0;
            }
            case 300328: {
                return 26;
            }
        }
        return -9999;
    }

    public static double getDefaultDoubleValueIfRequired(int n) {
        switch (n) {
            case 500008: {
                return 0.0;
            }
            case 500009: {
                return 0.0;
            }
            case 500101: {
                return 0.0;
            }
            case 500102: {
                return 0.0;
            }
            case 100109: {
                return 0.0;
            }
            case 100110: {
                return 0.0;
            }
            case 400609: {
                return 0.0;
            }
            case 400610: {
                return 0.0;
            }
        }
        return -9999.990234375;
    }

    public static int getDefaultLongValueIfRequired(int n) {
        switch (n) {
            default: 
        }
        return -9999;
    }

    public static String getDefaultStringValueIfRequired(int n) {
        switch (n) {
            case 400023: {
                return "--";
            }
            case 400024: {
                return "--";
            }
            case 200023: {
                return "--";
            }
            case 200016: {
                return "--";
            }
        }
        return "";
    }
}

