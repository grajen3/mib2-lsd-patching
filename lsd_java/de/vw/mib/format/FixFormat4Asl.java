/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.format;

import de.vw.mib.format.FixFormat;
import java.util.HashMap;

public interface FixFormat4Asl
extends FixFormat {
    default public String getRulesetBasedFormattedString(int n, HashMap hashMap) {
    }

    default public String fmtGeoCoordinatesLongitude(double d2) {
    }

    default public String fmtGeoCoordinatesLatitude(double d2) {
    }
}

