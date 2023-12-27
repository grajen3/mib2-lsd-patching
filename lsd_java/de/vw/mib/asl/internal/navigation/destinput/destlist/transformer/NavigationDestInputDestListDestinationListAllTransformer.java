/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.destinput.destlist.transformer;

import de.vw.mib.asl.internal.navigation.destinput.destlist.transformer.DestListCollector;
import generated.de.vw.mib.asl.internal.navigation.destinput.destlist.transformer.AbstractNavigationDestInputDestListDestinationListAllTransformer;

public class NavigationDestInputDestListDestinationListAllTransformer
extends AbstractNavigationDestInputDestListDestinationListAllTransformer {
    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 4: {
                DestListCollector destListCollector = (DestListCollector)object;
                return destListCollector.latDegree;
            }
            case 5: {
                DestListCollector destListCollector = (DestListCollector)object;
                return destListCollector.latMin;
            }
            case 6: {
                DestListCollector destListCollector = (DestListCollector)object;
                return destListCollector.latSec;
            }
            case 11: {
                DestListCollector destListCollector = (DestListCollector)object;
                return destListCollector.type;
            }
            case 7: {
                DestListCollector destListCollector = (DestListCollector)object;
                return destListCollector.lonDegree;
            }
            case 8: {
                DestListCollector destListCollector = (DestListCollector)object;
                return destListCollector.lonMin;
            }
            case 9: {
                DestListCollector destListCollector = (DestListCollector)object;
                return destListCollector.lonSec;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        switch (n) {
            case 0: {
                DestListCollector destListCollector = (DestListCollector)object;
                return destListCollector.city;
            }
            case 2: {
                DestListCollector destListCollector = (DestListCollector)object;
                return destListCollector.crossing;
            }
            case 3: {
                DestListCollector destListCollector = (DestListCollector)object;
                return destListCollector.hno;
            }
            case 10: {
                DestListCollector destListCollector = (DestListCollector)object;
                return destListCollector.poiName;
            }
            case 1: {
                DestListCollector destListCollector = (DestListCollector)object;
                return destListCollector.street;
            }
        }
        throw new IllegalArgumentException();
    }
}

