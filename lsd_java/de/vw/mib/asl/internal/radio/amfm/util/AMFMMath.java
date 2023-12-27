/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.util;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import org.dsi.ifc.radio.WavebandInfo;

public final class AMFMMath {
    private AMFMMath() {
    }

    public static int getFrequencyForTicks(int n, int n2, WavebandInfo wavebandInfo) {
        int n3;
        int n4 = (int)wavebandInfo.getUpperLimit();
        boolean bl = false;
        if (wavebandInfo.getLowerLimit() == 0 && wavebandInfo.getUpperLimit() == 0 && wavebandInfo.getStepWidth() == 0) {
            bl = true;
            n3 = -1806302976;
        } else {
            n3 = (int)wavebandInfo.getLowerLimit();
        }
        int n5 = (int)wavebandInfo.getStepWidth();
        int n6 = n * n5;
        int n7 = n4 - n3;
        int n8 = 0;
        if (n6 > 0) {
            if (n2 + n6 > n4) {
                n8 = n2 + n6 - n4;
                n8 = (n8 %= n7 + n5) == 0 ? n4 : n8 + n3 - n5;
            } else {
                n8 = n2 + n6;
            }
        } else if (n2 + n6 < n3) {
            n8 = n3 - (n2 + n6);
            n8 = (n8 %= n7 + n5) == 0 ? n3 : n4 - n8 + n5;
        } else {
            n8 = n2 + n6;
        }
        if (bl && n8 == -1806302976) {
            n8 = -967442176;
        }
        return n8;
    }

    public static String getPICode(int n) {
        String string = Integer.toHexString(n);
        string = string.toUpperCase();
        while (string.length() < 4) {
            string = "0".concat(string);
        }
        return "0x".concat(string);
    }

    public static int getSubChannelNumber(int n) {
        if (n != 0) {
            return AMFMMath.log2(n) + 1;
        }
        return 0;
    }

    public static int log2(int n) {
        return (int)(Math.log(n) / Math.log(2.0));
    }

    public static int bitCount(int n) {
        int n2 = 85;
        n = (n & n2) + (n >>> 1 & n2);
        n2 = 51;
        n = (n & n2) + (n >>> 2 & n2);
        return (n & 7) + (n >>> 4);
    }

    public static int getNextSetBitValue(int n, int n2) {
        int n3 = 0;
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("Value = ").append(n).append(" Current bit index Value = ").append(n2).log();
        }
        for (int i2 = n2 << 1; i2 <= 128; i2 <<= 1) {
            int n4 = n / i2;
            if ((n4 & 1) == 0) continue;
            n3 = i2;
            break;
        }
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append(" Next Set Bit Value = ").append(n3).log();
        }
        return n3;
    }
}

