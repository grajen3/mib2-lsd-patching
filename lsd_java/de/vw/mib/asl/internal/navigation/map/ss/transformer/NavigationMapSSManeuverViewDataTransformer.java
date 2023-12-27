/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.ss.transformer;

import de.vw.mib.asl.internal.navigation.map.ss.transformer.ManeuverViewDataCollector;
import generated.de.vw.mib.asl.internal.navigation.map.ss.transformer.AbstractNavigationMapSSManeuverViewDataTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class NavigationMapSSManeuverViewDataTransformer
extends AbstractNavigationMapSSManeuverViewDataTransformer {
    @Override
    public int getInt(int n, Object object) {
        ManeuverViewDataCollector maneuverViewDataCollector = (ManeuverViewDataCollector)object;
        switch (n) {
            case 2: {
                return maneuverViewDataCollector.dtm;
            }
            case 6: {
                return maneuverViewDataCollector.numberOfPoiIcons;
            }
            case 3: {
                return maneuverViewDataCollector.rtth;
            }
            case 4: {
                return maneuverViewDataCollector.rttm;
            }
            case 5: {
                return maneuverViewDataCollector.symbolId;
            }
            case 0: {
                return maneuverViewDataCollector.type;
            }
            case 19: {
                return maneuverViewDataCollector.direction;
            }
            case 18: {
                return maneuverViewDataCollector.mainElement;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        ManeuverViewDataCollector maneuverViewDataCollector = (ManeuverViewDataCollector)object;
        switch (n) {
            case 7: {
                if (maneuverViewDataCollector.poiIcons != null && maneuverViewDataCollector.poiIcons.length > 0) {
                    return maneuverViewDataCollector.poiIcons[0];
                }
                return null;
            }
            case 8: {
                if (maneuverViewDataCollector.poiIcons != null && maneuverViewDataCollector.poiIcons.length > 1) {
                    return maneuverViewDataCollector.poiIcons[1];
                }
                return null;
            }
            case 9: {
                if (maneuverViewDataCollector.poiIcons != null && maneuverViewDataCollector.poiIcons.length > 2) {
                    return maneuverViewDataCollector.poiIcons[2];
                }
                return null;
            }
            case 10: {
                if (maneuverViewDataCollector.poiIcons != null && maneuverViewDataCollector.poiIcons.length > 3) {
                    return maneuverViewDataCollector.poiIcons[3];
                }
                return null;
            }
            case 11: {
                if (maneuverViewDataCollector.poiIcons != null && maneuverViewDataCollector.poiIcons.length > 4) {
                    return maneuverViewDataCollector.poiIcons[4];
                }
                return null;
            }
            case 16: {
                return maneuverViewDataCollector.tmcListIcon;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        ManeuverViewDataCollector maneuverViewDataCollector = (ManeuverViewDataCollector)object;
        switch (n) {
            case 1: {
                return maneuverViewDataCollector.name;
            }
            case 14: {
                return maneuverViewDataCollector.tmcEndLocation;
            }
            case 15: {
                return maneuverViewDataCollector.tmcMessageText;
            }
            case 12: {
                return maneuverViewDataCollector.tmcRoadName;
            }
            case 13: {
                return maneuverViewDataCollector.tmcStartLocation;
            }
            case 17: {
                return maneuverViewDataCollector.signPost;
            }
        }
        throw new IllegalArgumentException();
    }
}

