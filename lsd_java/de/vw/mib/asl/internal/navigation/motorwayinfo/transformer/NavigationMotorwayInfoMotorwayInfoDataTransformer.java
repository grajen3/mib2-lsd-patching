/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.motorwayinfo.transformer;

import de.vw.mib.asl.internal.navigation.motorwayinfo.transformer.NavigationMotorwayInfoDataCollector;
import generated.de.vw.mib.asl.internal.navigation.motorwayinfo.transformer.AbstractNavigationMotorwayInfoMotorwayInfoDataTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class NavigationMotorwayInfoMotorwayInfoDataTransformer
extends AbstractNavigationMotorwayInfoMotorwayInfoDataTransformer {
    @Override
    public int getInt(int n, Object object) {
        NavigationMotorwayInfoDataCollector navigationMotorwayInfoDataCollector = (NavigationMotorwayInfoDataCollector)object;
        switch (n) {
            case 9: {
                return navigationMotorwayInfoDataCollector.dtm;
            }
            case 10: {
                return navigationMotorwayInfoDataCollector.rtth;
            }
            case 11: {
                return navigationMotorwayInfoDataCollector.rttm;
            }
            case 19: {
                return navigationMotorwayInfoDataCollector.speedFlowSegments.length > 0 ? navigationMotorwayInfoDataCollector.speedFlowSegments[0] : 0;
            }
            case 20: {
                return navigationMotorwayInfoDataCollector.speedFlowSegments.length > 0 ? navigationMotorwayInfoDataCollector.speedFlowSegments[1] : 0;
            }
            case 21: {
                return navigationMotorwayInfoDataCollector.speedFlowSegments.length > 0 ? navigationMotorwayInfoDataCollector.speedFlowSegments[2] : 0;
            }
            case 22: {
                return navigationMotorwayInfoDataCollector.speedFlowSegments.length > 0 ? navigationMotorwayInfoDataCollector.speedFlowSegments[3] : 0;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        NavigationMotorwayInfoDataCollector navigationMotorwayInfoDataCollector = (NavigationMotorwayInfoDataCollector)object;
        switch (n) {
            case 0: {
                return navigationMotorwayInfoDataCollector.exitOrSAPAIcon;
            }
            case 3: {
                return navigationMotorwayInfoDataCollector.poiIcons.length > 0 ? navigationMotorwayInfoDataCollector.poiIcons[0] : null;
            }
            case 4: {
                return navigationMotorwayInfoDataCollector.poiIcons.length > 1 ? navigationMotorwayInfoDataCollector.poiIcons[1] : null;
            }
            case 5: {
                return navigationMotorwayInfoDataCollector.poiIcons.length > 2 ? navigationMotorwayInfoDataCollector.poiIcons[2] : null;
            }
            case 6: {
                return navigationMotorwayInfoDataCollector.poiIcons.length > 3 ? navigationMotorwayInfoDataCollector.poiIcons[3] : null;
            }
            case 7: {
                return navigationMotorwayInfoDataCollector.poiIcons.length > 4 ? navigationMotorwayInfoDataCollector.poiIcons[4] : null;
            }
            case 8: {
                return navigationMotorwayInfoDataCollector.poiIcons.length > 5 ? navigationMotorwayInfoDataCollector.poiIcons[5] : null;
            }
            case 12: {
                return navigationMotorwayInfoDataCollector.tmcIcons != null && navigationMotorwayInfoDataCollector.tmcIcons.length > 0 ? navigationMotorwayInfoDataCollector.tmcIcons[0] : null;
            }
            case 13: {
                return navigationMotorwayInfoDataCollector.tmcIcons != null && navigationMotorwayInfoDataCollector.tmcIcons.length > 1 ? navigationMotorwayInfoDataCollector.tmcIcons[1] : null;
            }
            case 14: {
                return navigationMotorwayInfoDataCollector.tmcIcons != null && navigationMotorwayInfoDataCollector.tmcIcons.length > 2 ? navigationMotorwayInfoDataCollector.tmcIcons[2] : null;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        NavigationMotorwayInfoDataCollector navigationMotorwayInfoDataCollector = (NavigationMotorwayInfoDataCollector)object;
        switch (n) {
            case 2: {
                return this.checkNull(navigationMotorwayInfoDataCollector.name);
            }
            case 1: {
                return this.checkNull(navigationMotorwayInfoDataCollector.exitNumber);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        NavigationMotorwayInfoDataCollector navigationMotorwayInfoDataCollector = (NavigationMotorwayInfoDataCollector)object;
        switch (n) {
            case 23: {
                return navigationMotorwayInfoDataCollector.tmcIcons != null && navigationMotorwayInfoDataCollector.tmcIcons.length > 0;
            }
            case 24: {
                return navigationMotorwayInfoDataCollector.tmcIcons != null && navigationMotorwayInfoDataCollector.tmcIcons.length > 1;
            }
            case 25: {
                return navigationMotorwayInfoDataCollector.tmcIcons != null && navigationMotorwayInfoDataCollector.tmcIcons.length > 2;
            }
        }
        throw new IllegalArgumentException();
    }

    String checkNull(String string) {
        return string != null ? string : "";
    }
}

