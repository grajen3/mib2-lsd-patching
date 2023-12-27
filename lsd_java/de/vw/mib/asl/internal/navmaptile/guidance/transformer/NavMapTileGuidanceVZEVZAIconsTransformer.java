/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navmaptile.guidance.transformer;

import de.vw.mib.asl.internal.navmaptile.transformer.NavMapTileGuidanceVZEVZAIconsCollector;
import generated.de.vw.mib.asl.internal.navmaptile.guidance.transformer.AbstractNavMapTileGuidanceVZEVZAIconsTransformer;

public class NavMapTileGuidanceVZEVZAIconsTransformer
extends AbstractNavMapTileGuidanceVZEVZAIconsTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        NavMapTileGuidanceVZEVZAIconsCollector navMapTileGuidanceVZEVZAIconsCollector = (NavMapTileGuidanceVZEVZAIconsCollector)object;
        switch (n) {
            case 4: {
                return navMapTileGuidanceVZEVZAIconsCollector.getAdditionalIconActive();
            }
            case 3: {
                return navMapTileGuidanceVZEVZAIconsCollector.getMainIconActive();
            }
            case 5: {
                return navMapTileGuidanceVZEVZAIconsCollector.getSpeedIconActive();
            }
        }
        return false;
    }

    @Override
    public String getString(int n, Object object) {
        NavMapTileGuidanceVZEVZAIconsCollector navMapTileGuidanceVZEVZAIconsCollector = (NavMapTileGuidanceVZEVZAIconsCollector)object;
        switch (n) {
            case 1: {
                return navMapTileGuidanceVZEVZAIconsCollector.getAdditionalIconString();
            }
            case 0: {
                return navMapTileGuidanceVZEVZAIconsCollector.getMainIconString();
            }
            case 2: {
                return navMapTileGuidanceVZEVZAIconsCollector.getSpeedIconString();
            }
        }
        return null;
    }
}

