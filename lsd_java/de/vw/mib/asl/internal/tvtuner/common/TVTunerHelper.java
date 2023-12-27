/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.common;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.log4mib.LogMessage;

public class TVTunerHelper {
    public static Integer[] convertInt2IntegerArray(int[] nArray) {
        Integer[] integerArray = new Integer[nArray.length];
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            integerArray[i2] = new Integer(nArray[i2]);
        }
        return integerArray;
    }

    public static Integer[] convertShort2IntegerArray(short[] sArray) {
        Integer[] integerArray = new Integer[sArray.length];
        for (int i2 = 0; i2 < sArray.length; ++i2) {
            integerArray[i2] = new Integer(sArray[i2]);
        }
        return integerArray;
    }

    public static int[] convertIntSet2IntArray(IntSet intSet) {
        int[] nArray = new int[intSet.size()];
        int n = 0;
        IntIterator intIterator = intSet.iterator();
        while (intIterator.hasNext()) {
            nArray[n++] = intIterator.next();
        }
        return nArray;
    }

    public static void trace(String string) {
        LogMessage logMessage = ServiceManager.logger2.trace(2);
        logMessage.append(string).log();
    }

    public static void warn(String string) {
        LogMessage logMessage = ServiceManager.logger2.warn(2);
        logMessage.append(string).log();
    }

    public static boolean isTraceEnabled() {
        return ServiceManager.logger2.isTraceEnabled(2);
    }

    public static int convertBcdToInt(int n) {
        int n2 = 0;
        int n3 = 0;
        int n4 = 15;
        int n5 = 0;
        int n6 = 1;
        while ((n & n5) < n) {
            int n7 = (n & n4) >> n3;
            if (n7 > 9) {
                n7 = 0;
            } else {
                n2 += n7 * n6;
            }
            n6 *= 10;
            n5 |= n4;
            n4 <<= 4;
            n3 += 4;
        }
        return n2;
    }
}

