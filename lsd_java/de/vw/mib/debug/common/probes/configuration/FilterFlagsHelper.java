/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.common.probes.configuration;

import de.vw.mib.debug.common.probes.configuration.FilterFlags;
import java.util.StringTokenizer;

public final class FilterFlagsHelper {
    private static final int RADIX;

    public static int getFilterFlags(String string) {
        StringTokenizer stringTokenizer = new StringTokenizer(string, ",");
        int n = 0;
        block0: for (int i2 = stringTokenizer.countTokens() - 1; i2 >= 0; --i2) {
            String string2 = stringTokenizer.nextToken().trim();
            int n2 = 1;
            for (int i3 = FilterFlags.FILTER_CLASSIFIERS.length - 1; i3 >= 0; --i3) {
                if (FilterFlags.FILTER_CLASSIFIERS[i3].equalsIgnoreCase(string2)) {
                    n |= n2;
                    continue block0;
                }
                n2 <<= 1;
            }
        }
        return n;
    }

    public static String getFilterString(int n) {
        int n2 = FilterFlags.FILTER_CLASSIFIERS.length - 1;
        StringBuffer stringBuffer = new StringBuffer();
        String string = "";
        while (n != 0) {
            if ((n & 1) != 0) {
                stringBuffer.append(string).append(FilterFlags.FILTER_CLASSIFIERS[n2]);
                string = ",";
            }
            n >>>= 1;
            if (--n2 >= 0) continue;
            break;
        }
        return stringBuffer.toString();
    }

    public static String getFilterFlagsAsString(String string) {
        return FilterFlagsHelper.flagsToStringConversion(FilterFlagsHelper.getFilterFlags(string));
    }

    public static String getFilterString(String string) {
        return FilterFlagsHelper.getFilterString(FilterFlagsHelper.StringToFlagsConversion(string));
    }

    public static String flagsToStringConversion(int n) {
        return Integer.toString(n, 36);
    }

    private static int StringToFlagsConversion(String string) {
        return Integer.parseInt(string, 36);
    }
}

