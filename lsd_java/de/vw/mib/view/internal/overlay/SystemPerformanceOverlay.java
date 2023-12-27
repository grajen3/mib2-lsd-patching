/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal.overlay;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.view.internal.overlay.TextOverlay;
import de.vw.mib.widgets.internal.ServiceManager;
import java.util.ArrayList;
import java.util.List;

public final class SystemPerformanceOverlay
extends TextOverlay {
    private static final Color4f SYSTEM_PERFORMANCE_TEXT_FOREGROUND_COLOR = Color4f.YELLOW;
    private static final Color4f SYSTEM_PERFORMANCE_TEXT_BACKGROUND_COLOR = Color4f.BLACK_TRANSPARENT;
    private final List systemPerformanceIndicatorList;

    public SystemPerformanceOverlay(Logger logger, Graphics3D graphics3D, Dimension dimension) {
        super(logger, graphics3D, "System Performance", dimension, SYSTEM_PERFORMANCE_TEXT_FOREGROUND_COLOR, SYSTEM_PERFORMANCE_TEXT_BACKGROUND_COLOR);
        int n = ServiceManager.performanceIndicatorService.getPerformanceIndicatorCount();
        this.systemPerformanceIndicatorList = new ArrayList(n);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void draw() {
        super.draw();
    }

    public void update() {
        int n = ServiceManager.performanceIndicatorService.getPerformanceIndicatorCount();
        String[] stringArray = new String[n];
        int[] nArray = new int[n];
        long[] lArray = new long[n];
        ServiceManager.performanceIndicatorService.getPerformanceIndicatorDescription(stringArray, nArray, lArray);
        long[] lArray2 = new long[n];
        ServiceManager.performanceIndicatorService.getPerformanceIndicatorValues(lArray2);
        StringBuilder stringBuilder = new StringBuilder();
        this.systemPerformanceIndicatorList.clear();
        for (int i2 = 0; i2 < n; ++i2) {
            int n2 = nArray[i2];
            String string = stringArray[i2];
            long l = lArray2[i2];
            stringBuilder.setLength(0);
            stringBuilder.append(string);
            stringBuilder.append(": ");
            switch (n2) {
                case 1: {
                    stringBuilder.append(l);
                    stringBuilder.append("%");
                    break;
                }
                case 2: 
                case 3: {
                    if (l > 0) {
                        stringBuilder.append(l >> 20);
                        stringBuilder.append("MiB");
                    } else if (l > 0) {
                        stringBuilder.append(l >> 10);
                        stringBuilder.append("KiB");
                    } else {
                        stringBuilder.append(l);
                        stringBuilder.append("B");
                    }
                    if (n2 != 3) break;
                    stringBuilder.append("/s");
                    break;
                }
                case 4: {
                    stringBuilder.append(l);
                    stringBuilder.append("ms");
                    break;
                }
                default: {
                    stringBuilder.append(l);
                }
            }
            this.systemPerformanceIndicatorList.add(stringBuilder.toString());
        }
        this.setTextLines(this.systemPerformanceIndicatorList);
    }
}

