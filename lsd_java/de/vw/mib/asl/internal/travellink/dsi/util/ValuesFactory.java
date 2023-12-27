/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.dsi.util;

import org.dsi.ifc.travellink.TravelLinkDate;
import org.dsi.ifc.travellink.Values;

public final class ValuesFactory {
    private ValuesFactory() {
    }

    public static Values createValue(String string) {
        return ValuesFactory.createValue(new String[]{string});
    }

    public static Values createValue(String[] stringArray) {
        return new Values(stringArray, null, null, null, null, null, null, null);
    }

    public static Values createValue(boolean bl) {
        return ValuesFactory.createValue(new boolean[]{bl});
    }

    public static Values createValue(boolean[] blArray) {
        return new Values(null, null, null, null, null, blArray, null, null);
    }

    public static Values createValue(int n) {
        return ValuesFactory.createValue(new int[]{n});
    }

    public static Values createValue(int[] nArray) {
        return new Values(null, nArray, null, null, null, null, null, null);
    }

    public static Values createValue(long l) {
        return ValuesFactory.createValue(new long[]{l});
    }

    public static Values createValue(long[] lArray) {
        return new Values(null, null, lArray, null, null, null, null, null);
    }

    public static Values createValue(float f2) {
        return ValuesFactory.createValue(new float[]{f2});
    }

    public static Values createValue(float[] fArray) {
        return new Values(null, null, null, fArray, null, null, null, null);
    }

    public static Values createValue(double d2) {
        return ValuesFactory.createValue(new double[]{d2});
    }

    public static Values createValue(double[] dArray) {
        return new Values(null, null, null, null, dArray, null, null, null);
    }

    public static Values createValue(TravelLinkDate travelLinkDate) {
        return ValuesFactory.createValue(new TravelLinkDate[]{travelLinkDate});
    }

    public static Values createValue(TravelLinkDate[] travelLinkDateArray) {
        return new Values(null, null, null, null, null, null, null, travelLinkDateArray);
    }
}

