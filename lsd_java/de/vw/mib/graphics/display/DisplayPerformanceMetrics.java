/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.display;

import de.vw.mib.graphics.performance.PerformanceMetrics;
import de.vw.mib.util.StringBuilder;

public final class DisplayPerformanceMetrics
implements PerformanceMetrics {
    public int allocatedDisplayableContents;
    public int allocatedDisplayableContentsSizeBytes;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[allocatedDisplayableContents=").append(this.allocatedDisplayableContents);
        stringBuilder.append(",allocatedDisplayableContentsSizeBytes=").append(this.allocatedDisplayableContentsSizeBytes);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

