/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.transformer;

import de.vw.mib.asl.internal.navigation.guidance.transformer.VZAIconsCollector;
import generated.de.vw.mib.asl.internal.navigation.guidance.transformer.AbstractNavigationGuidanceVZEVZAIconsTransformer;

public class NavigationGuidanceVZEVZAIconsTransformer
extends AbstractNavigationGuidanceVZEVZAIconsTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        boolean bl = false;
        VZAIconsCollector vZAIconsCollector = (VZAIconsCollector)object;
        switch (n) {
            case 3: {
                bl = vZAIconsCollector.isMainIconActive;
                break;
            }
            case 4: {
                bl = vZAIconsCollector.isAdditionalIconActive;
                break;
            }
            case 5: {
                bl = vZAIconsCollector.isSpeedIconActive;
                break;
            }
        }
        return bl;
    }

    @Override
    public String getString(int n, Object object) {
        String string = "";
        VZAIconsCollector vZAIconsCollector = (VZAIconsCollector)object;
        switch (n) {
            case 0: {
                string = vZAIconsCollector.mainIcons;
                break;
            }
            case 1: {
                string = vZAIconsCollector.additionalIcons;
                break;
            }
            case 2: {
                string = vZAIconsCollector.speedIcons;
                break;
            }
            case 6: {
                string = vZAIconsCollector.bgInteractiveMode;
                break;
            }
            case 7: {
                string = vZAIconsCollector.bgDisplayMode;
                break;
            }
        }
        return string;
    }
}

