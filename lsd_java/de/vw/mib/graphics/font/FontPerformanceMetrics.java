/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font;

import de.vw.mib.graphics.performance.PerformanceMetrics;
import de.vw.mib.util.StringBuilder;

public final class FontPerformanceMetrics
implements PerformanceMetrics {
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

