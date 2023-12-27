/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.uota.common;

import de.vw.mib.asl.internal.online.common.uota.OnlineUotAPackage;
import java.util.Comparator;

public class UotAPacketComparator
implements Comparator {
    @Override
    public int compare(Object object, Object object2) {
        if (null == object && null == object2) {
            return 0;
        }
        if (object == null) {
            return -1;
        }
        if (object2 == null) {
            return 1;
        }
        String string = ((OnlineUotAPackage)object).getLabel();
        String string2 = ((OnlineUotAPackage)object2).getLabel();
        return string.compareToIgnoreCase(string2);
    }
}

