/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.swap;

import edu.emory.mathcs.backport.java.util.Arrays;
import java.util.ArrayList;
import org.dsi.ifc.swap.SFscStatus;

public final class SFscStatusUtil {
    public static boolean containsLegalStatus(SFscStatus[] sFscStatusArray, int n) {
        SFscStatus sFscStatus = SFscStatusUtil.findBySwid(sFscStatusArray, n);
        if (sFscStatus == null) {
            return false;
        }
        return sFscStatus.state == 0;
    }

    public static SFscStatus findBySwid(SFscStatus[] sFscStatusArray, int n) {
        if (sFscStatusArray == null) {
            return null;
        }
        for (int i2 = 0; i2 < sFscStatusArray.length; ++i2) {
            SFscStatus sFscStatus = sFscStatusArray[i2];
            if (sFscStatus == null || sFscStatus.swid != n) continue;
            return sFscStatus;
        }
        return null;
    }

    public static SFscStatus[] filterByState(SFscStatus[] sFscStatusArray, int n) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < sFscStatusArray.length; ++i2) {
            SFscStatus sFscStatus = sFscStatusArray[i2];
            if (sFscStatus.state != n) continue;
            arrayList.add(sFscStatus);
        }
        return (SFscStatus[])arrayList.toArray(new SFscStatus[arrayList.size()]);
    }

    public static String toHexString(int n) {
        String string = Integer.toHexString(n);
        char[] cArray = new char[Math.max(0, 8 - string.length())];
        Arrays.fill(cArray, '0');
        return new StringBuffer().append(new String(cArray)).append(string).toString();
    }

    private SFscStatusUtil() {
    }
}

