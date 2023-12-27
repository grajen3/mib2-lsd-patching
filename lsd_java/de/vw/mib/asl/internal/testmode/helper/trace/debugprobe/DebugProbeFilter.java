/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode.helper.trace.debugprobe;

import de.vw.mib.util.Util;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Vector;

public class DebugProbeFilter
implements FilenameFilter {
    private static final int DEBUG_PROBE_BODY_SEPARATOR;
    private static final String DEBUG_PROBE_NAME_SUFFIX_STRING;
    private static final String DEBUG_PROBE_NAME_PREFIX_STRING;
    private static final int P0_FIRST_INDEX;
    private static final int P1_SECOND_INDEX;
    private static final int P2_SUFFIX_INDEX;
    private Vector foundProbeNumbers = new Vector();

    @Override
    public boolean accept(File file, String string) {
        if (Util.isNullOrEmpty(string)) {
            return false;
        }
        String string2 = DebugProbeFilter.getDebugProbeName(string);
        if (Util.isNullOrEmpty(string2)) {
            return false;
        }
        Integer n = DebugProbeFilter.getDebugProbeIndex(string);
        if (n == null || n < 0 || this.foundProbeNumbers.contains(n)) {
            return false;
        }
        this.foundProbeNumbers.add(n);
        return true;
    }

    protected static Integer getDebugProbeIndex(String string) {
        Integer n = null;
        int[] nArray = DebugProbeFilter.getIndexes(string);
        if (nArray != null) {
            String string2 = string.substring(nArray[0] + 1, nArray[1]);
            try {
                n = Integer.valueOf(string2);
            }
            catch (NumberFormatException numberFormatException) {
                n = null;
            }
        }
        return n;
    }

    protected static String getDebugProbeName(String string) {
        String string2 = null;
        int[] nArray = DebugProbeFilter.getIndexes(string);
        if (nArray != null) {
            string2 = string.substring(nArray[1] + 1, nArray[2]);
        }
        return string2;
    }

    private static int[] getIndexes(String string) {
        boolean bl;
        int n = string.indexOf(95, 0);
        int n2 = string.indexOf(95, n + 1);
        int n3 = string.lastIndexOf(46);
        boolean bl2 = string.startsWith("debugprobes");
        boolean bl3 = string.endsWith(".config");
        boolean bl4 = n > "debugprobes".length() - 1;
        boolean bl5 = n2 > n;
        boolean bl6 = bl = n3 > n2;
        if (bl2 && bl3 && bl4 && bl5 && bl) {
            int[] nArray = new int[]{n, n2, n3};
            return nArray;
        }
        return null;
    }
}

