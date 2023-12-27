/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.transformer;

import de.vw.mib.asl.internal.navigation.poi.transformer.PoiConnectorDetailsCollector;
import generated.de.vw.mib.asl.internal.navigation.poi.transformer.AbstractNavigationPOIResultConnectorDetailsTransformer;

public class NavigationPOIResultConnectorDetailsTransformer
extends AbstractNavigationPOIResultConnectorDetailsTransformer {
    @Override
    public String getString(int n, Object object) {
        String string = "";
        PoiConnectorDetailsCollector poiConnectorDetailsCollector = (PoiConnectorDetailsCollector)object;
        switch (n) {
            case 1: {
                string = poiConnectorDetailsCollector.chargeMode;
                break;
            }
            case 2: {
                string = poiConnectorDetailsCollector.chargeLevel;
                break;
            }
            case 3: {
                string = poiConnectorDetailsCollector.name;
                break;
            }
            case 5: {
                string = poiConnectorDetailsCollector.fuseProtection;
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        return string;
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        switch (n) {
            default: 
        }
        throw new IllegalArgumentException("The given columnID does not contain boolean values.");
    }

    @Override
    public int getInt(int n, Object object) {
        PoiConnectorDetailsCollector poiConnectorDetailsCollector = (PoiConnectorDetailsCollector)object;
        switch (n) {
            case 0: {
                return poiConnectorDetailsCollector.count;
            }
            case 6: {
                return poiConnectorDetailsCollector.poweroutput;
            }
            case 4: {
                return poiConnectorDetailsCollector.type;
            }
        }
        throw new IllegalArgumentException("The given columnID does not contain integer values.");
    }
}

