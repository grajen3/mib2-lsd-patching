/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab;

import java.util.Comparator;
import org.dsi.ifc.radio.ComponentInfo;

public final class DabComponentComparator
implements Comparator {
    @Override
    public int compare(Object object, Object object2) {
        if (object == null) {
            return -1;
        }
        if (object2 == null) {
            return 1;
        }
        ComponentInfo componentInfo = (ComponentInfo)object;
        ComponentInfo componentInfo2 = (ComponentInfo)object2;
        if (componentInfo.primaryService) {
            return -1;
        }
        if (componentInfo2.primaryService) {
            return 1;
        }
        if (componentInfo.sCIDI > componentInfo2.sCIDI) {
            return 1;
        }
        if (componentInfo.sCIDI < componentInfo2.sCIDI) {
            return -1;
        }
        return componentInfo.fullName.compareToIgnoreCase(componentInfo2.fullName);
    }
}

