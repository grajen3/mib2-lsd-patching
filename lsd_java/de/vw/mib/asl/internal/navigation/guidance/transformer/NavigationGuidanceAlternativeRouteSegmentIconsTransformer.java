/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.transformer;

import de.vw.mib.asl.internal.navigation.guidance.transformer.AlternativeRouteIconsCollector;
import generated.de.vw.mib.asl.internal.navigation.guidance.transformer.AbstractNavigationGuidanceAlternativeRouteSegmentIconsTransformer;

public class NavigationGuidanceAlternativeRouteSegmentIconsTransformer
extends AbstractNavigationGuidanceAlternativeRouteSegmentIconsTransformer {
    @Override
    public int getInt(int n, Object object) {
        AlternativeRouteIconsCollector alternativeRouteIconsCollector = (AlternativeRouteIconsCollector)object;
        switch (n) {
            case 0: {
                if (alternativeRouteIconsCollector.icons.length > 0) {
                    return alternativeRouteIconsCollector.icons[0];
                }
                return 1;
            }
            case 1: {
                if (alternativeRouteIconsCollector.icons.length > 1) {
                    return alternativeRouteIconsCollector.icons[1];
                }
                return 1;
            }
            case 2: {
                if (alternativeRouteIconsCollector.icons.length > 2) {
                    return alternativeRouteIconsCollector.icons[2];
                }
                return 1;
            }
            case 3: {
                if (alternativeRouteIconsCollector.icons.length > 3) {
                    return alternativeRouteIconsCollector.icons[3];
                }
                return 1;
            }
            case 4: {
                if (alternativeRouteIconsCollector.icons.length > 4) {
                    return alternativeRouteIconsCollector.icons[4];
                }
                return 1;
            }
        }
        throw new IllegalArgumentException();
    }
}

