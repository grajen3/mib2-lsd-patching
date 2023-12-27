/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.collections.ObjectIntOptHashMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;

public class StartupConfiguration {
    private static int FEATURE_BIT_ASL = 16;
    private static int FEATURE_BIT_DSI = 32;
    private static int FEATURE_BIT_DOMAIN = 64;
    private static IntObjectOptHashMap featureFlagDependencyLookupTableNextGen = new IntObjectOptHashMap(6);
    private static ObjectIntOptHashMap featureFlagDsiDependencyLookupTable = new ObjectIntOptHashMap(6);

    public static boolean isAslTargetAllowedForStart(int n) {
        if (!featureFlagDependencyLookupTableNextGen.containsKey(n | FEATURE_BIT_ASL)) {
            return true;
        }
        int[] nArray = (int[])featureFlagDependencyLookupTableNextGen.get(n | FEATURE_BIT_ASL);
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (!ServiceManager.configManagerDiag.isFeatureFlagSet(nArray[i2])) continue;
            return true;
        }
        return false;
    }

    public static boolean isDsiAllowedForStart(String string) {
        if (!featureFlagDsiDependencyLookupTable.containsKey(string)) {
            return true;
        }
        return ServiceManager.configManagerDiag.isFeatureFlagSet(featureFlagDsiDependencyLookupTable.get(string));
    }

    public static boolean isDomainAllowedForStart(int n) {
        if (!featureFlagDependencyLookupTableNextGen.containsKey(n | FEATURE_BIT_DOMAIN)) {
            return true;
        }
        int[] nArray = (int[])featureFlagDependencyLookupTableNextGen.get(n | FEATURE_BIT_DOMAIN);
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (!ServiceManager.configManagerDiag.isFeatureFlagSet(nArray[i2])) continue;
            return true;
        }
        return false;
    }

    static {
        featureFlagDependencyLookupTableNextGen.put(0x51BC1600 | FEATURE_BIT_ASL, new int[]{104});
        featureFlagDependencyLookupTableNextGen.put(0x52BC1600 | FEATURE_BIT_ASL, new int[]{385});
        featureFlagDependencyLookupTableNextGen.put(0x53BC1600 | FEATURE_BIT_ASL, new int[]{385});
        featureFlagDependencyLookupTableNextGen.put(0x50BC1600 | FEATURE_BIT_ASL, new int[]{385});
        featureFlagDsiDependencyLookupTable.put(RuntimeGeneratedConstants.SERVICE_TS_NS[53], 385);
        featureFlagDsiDependencyLookupTable.put(RuntimeGeneratedConstants.SERVICE_TS_NS[54], 104);
        featureFlagDsiDependencyLookupTable.put(RuntimeGeneratedConstants.SERVICE_TS_NS[55], 385);
        featureFlagDependencyLookupTableNextGen.put(0x700A1700 | FEATURE_BIT_ASL, new int[]{393});
        featureFlagDependencyLookupTableNextGen.put(0x710A1700 | FEATURE_BIT_ASL, new int[]{392});
        featureFlagDependencyLookupTableNextGen.put(0x71991400 | FEATURE_BIT_ASL, new int[]{434});
        featureFlagDsiDependencyLookupTable.put(RuntimeGeneratedConstants.SERVICE_TS_NS[154], 434);
        featureFlagDependencyLookupTableNextGen.put(0xC2CD1700 | FEATURE_BIT_ASL, new int[]{196});
        featureFlagDependencyLookupTableNextGen.put(0x386E1600 | FEATURE_BIT_ASL, new int[]{473});
        featureFlagDsiDependencyLookupTable.put(RuntimeGeneratedConstants.SERVICE_TS_NS[150], 473);
        featureFlagDsiDependencyLookupTable.put(RuntimeGeneratedConstants.SERVICE_TS_NS[97], 475);
        featureFlagDependencyLookupTableNextGen.put(0x316E1600 | FEATURE_BIT_ASL, new int[]{185});
        featureFlagDsiDependencyLookupTable.put(RuntimeGeneratedConstants.SERVICE_TS_NS[88], 185);
        featureFlagDependencyLookupTableNextGen.put(0x376E1600 | FEATURE_BIT_ASL, new int[]{194});
        featureFlagDsiDependencyLookupTable.put(RuntimeGeneratedConstants.SERVICE_TS_NS[93], 194);
        featureFlagDependencyLookupTableNextGen.put(0x336E1600 | FEATURE_BIT_ASL, new int[]{190});
        featureFlagDsiDependencyLookupTable.put(RuntimeGeneratedConstants.SERVICE_TS_NS[96], 190);
        featureFlagDependencyLookupTableNextGen.put(0x326E1600 | FEATURE_BIT_ASL, new int[]{473});
        featureFlagDependencyLookupTableNextGen.put(0xF0601300 | FEATURE_BIT_ASL, new int[]{183});
        featureFlagDsiDependencyLookupTable.put(RuntimeGeneratedConstants.SERVICE_TS_NS[11], 183);
        featureFlagDsiDependencyLookupTable.put(RuntimeGeneratedConstants.SERVICE_TS_NS[13], 183);
        featureFlagDependencyLookupTableNextGen.put(0x356E1600 | FEATURE_BIT_ASL, new int[]{184});
        featureFlagDsiDependencyLookupTable.put(RuntimeGeneratedConstants.SERVICE_TS_NS[92], 184);
        featureFlagDependencyLookupTableNextGen.put(0x366E1600 | FEATURE_BIT_ASL, new int[]{392});
        featureFlagDependencyLookupTableNextGen.put(0x396E1600 | FEATURE_BIT_ASL, new int[]{474});
        featureFlagDsiDependencyLookupTable.put(RuntimeGeneratedConstants.SERVICE_TS_NS[113], 144);
    }
}

