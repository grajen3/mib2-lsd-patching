/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.phone;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.collections.ints.IntOptHashSet;
import java.util.ArrayList;

public final class PhoneConstants {
    public static String[] NEEDED_PHONE_DSIS;
    public static int[] NEEDED_PHONE_DSI_IDS;
    public static int DOMAIN_RUN_LEVEL;
    public static int[] NEEDED_PHONE_TARGETS;

    public static int[] getNeededPhoneDsiIds() {
        PhoneConstants.fillNeededPhoneDsis();
        return NEEDED_PHONE_DSI_IDS;
    }

    public static int getDomainRunLevel() {
        return DOMAIN_RUN_LEVEL;
    }

    public static boolean isFeatureFlagsDsiDataXXX() {
        return ServiceManager.configManagerDiag.isFeatureFlagSet(184) || ServiceManager.configManagerDiag.isFeatureFlagSet(378);
    }

    public static boolean isFeatureFlagsDsiWLAN() {
        return ServiceManager.configManagerDiag.isFeatureFlagSet(479);
    }

    public static boolean isFeatureFlagsDsiMessagingXXX() {
        return ServiceManager.configManagerDiag.isFeatureFlagSet(97) || ServiceManager.configManagerDiag.isFeatureFlagSet(94);
    }

    private static void fillDomainRunLevel() {
        int n = 0x1E0E00;
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(97) || ServiceManager.configManagerDiag.isFeatureFlagSet(94)) {
            n |= 0x100;
        }
        DOMAIN_RUN_LEVEL = n;
    }

    private static void fillNeededPhoneDsis() {
        ArrayList arrayList = new ArrayList(9);
        IntArrayList intArrayList = new IntArrayList(9);
        intArrayList.add(140);
        intArrayList.add(139);
        intArrayList.add(8);
        intArrayList.add(9);
        if (PhoneConstants.isFeatureFlagsDsiMessagingXXX()) {
            intArrayList.add(71);
            intArrayList.add(72);
        }
        if (PhoneConstants.isFeatureFlagsDsiWLAN()) {
            intArrayList.add(87);
        }
        if (PhoneConstants.isFeatureFlagsDsiDataXXX()) {
            intArrayList.add(85);
            intArrayList.add(86);
        }
        for (int i2 = 0; i2 < intArrayList.size(); ++i2) {
            arrayList.add(RuntimeGeneratedConstants.SERVICE_TS_NS[intArrayList.get(i2)]);
        }
        NEEDED_PHONE_DSIS = (String[])arrayList.toArray(new String[arrayList.size()]);
        NEEDED_PHONE_DSI_IDS = intArrayList.toArray();
    }

    public static int[] getNeededPhoneTargets() {
        PhoneConstants.fillNeededPhoneTargets();
        return NEEDED_PHONE_TARGETS;
    }

    private static void fillNeededPhoneTargets() {
        IntOptHashSet intOptHashSet = new IntOptHashSet(32);
        intOptHashSet.add(1939411968);
        intOptHashSet.add(5270);
        intOptHashSet.add(5252);
        intOptHashSet.add(5257);
        intOptHashSet.add(5258);
        intOptHashSet.add(5260);
        intOptHashSet.add(5259);
        intOptHashSet.add(5266);
        intOptHashSet.add(5254);
        intOptHashSet.add(1922634752);
        intOptHashSet.add(5255);
        intOptHashSet.add(5272);
        intOptHashSet.add(5250);
        intOptHashSet.add(5251);
        intOptHashSet.add(5256);
        intOptHashSet.add(5262);
        intOptHashSet.add(5261);
        intOptHashSet.add(5264);
        intOptHashSet.add(5268);
        intOptHashSet.add(5271);
        intOptHashSet.add(5253);
        intOptHashSet.add(5265);
        intOptHashSet.add(5263);
        intOptHashSet.add(5278);
        intOptHashSet.add(5281);
        if (PhoneConstants.isFeatureFlagsDsiMessagingXXX()) {
            intOptHashSet.add(5273);
            intOptHashSet.add(5279);
            intOptHashSet.add(5282);
            intOptHashSet.add(5275);
            intOptHashSet.add(567677696);
        }
        if (PhoneConstants.isFeatureFlagsDsiWLAN()) {
            intOptHashSet.add(7800);
        }
        if (PhoneConstants.isFeatureFlagsDsiDataXXX()) {
            intOptHashSet.add(7801);
        }
        NEEDED_PHONE_TARGETS = intOptHashSet.toArray();
    }

    static {
        PhoneConstants.fillNeededPhoneDsis();
        PhoneConstants.fillDomainRunLevel();
        PhoneConstants.fillNeededPhoneTargets();
    }
}

