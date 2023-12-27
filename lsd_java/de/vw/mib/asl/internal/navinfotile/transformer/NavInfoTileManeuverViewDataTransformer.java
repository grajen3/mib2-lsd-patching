/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navinfotile.transformer;

import de.vw.mib.asl.api.navigation.IManeuverViewElement;
import generated.de.vw.mib.asl.internal.navinfotile.transformer.AbstractNavInfoTileManeuverViewDataTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class NavInfoTileManeuverViewDataTransformer
extends AbstractNavInfoTileManeuverViewDataTransformer {
    @Override
    public int getInt(int n, Object object) {
        IManeuverViewElement iManeuverViewElement = (IManeuverViewElement)object;
        switch (n) {
            case 3: {
                return iManeuverViewElement.getDtm();
            }
            case 7: {
                return iManeuverViewElement.getDirection();
            }
            case 6: {
                return iManeuverViewElement.getMainElement();
            }
            case 8: {
                return iManeuverViewElement.getNumberOfPoiIcons();
            }
            case 4: {
                return iManeuverViewElement.getRtth();
            }
            case 5: {
                return iManeuverViewElement.getRttm();
            }
            case 0: {
                return iManeuverViewElement.getType();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        IManeuverViewElement iManeuverViewElement = (IManeuverViewElement)object;
        switch (n) {
            case 9: {
                return iManeuverViewElement.getPoiIcons()[0];
            }
            case 10: {
                return iManeuverViewElement.getPoiIcons()[1];
            }
            case 11: {
                return iManeuverViewElement.getPoiIcons()[2];
            }
            case 12: {
                return iManeuverViewElement.getPoiIcons()[3];
            }
            case 13: {
                return iManeuverViewElement.getPoiIcons()[4];
            }
            case 17: {
                return iManeuverViewElement.getTmcListIcon();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        IManeuverViewElement iManeuverViewElement = (IManeuverViewElement)object;
        switch (n) {
            case 2: {
                return iManeuverViewElement.getSignPost();
            }
            case 1: {
                return iManeuverViewElement.getName();
            }
            case 16: {
                return iManeuverViewElement.getTmcMessageText();
            }
            case 14: {
                return iManeuverViewElement.getTmcRoadName();
            }
            case 15: {
                return iManeuverViewElement.getTmcStartLocation();
            }
        }
        throw new IllegalArgumentException();
    }
}

