/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import generated.de.vw.mib.asl.internal.travellink.transformer.AbstractTravelLinkSportsRankedListEventRankingsListTransformer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class TravelLinkSportsRankedListEventRankingsListTransformer
extends AbstractTravelLinkSportsRankedListEventRankingsListTransformer {
    @Override
    public int getInt(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 1: {
                int n2 = GenericPropertyUtility.getInt(664077312, 0, genericPropertyContainer);
                return n2;
            }
            case 2: {
                String string = GenericPropertyUtility.getString(43451392, 1, genericPropertyContainer);
                int n3 = Integer.parseInt(string);
                return n3;
            }
            case 3: {
                String string = GenericPropertyUtility.getString(43451392, 3, genericPropertyContainer);
                int n4 = Integer.parseInt(string);
                return n4;
            }
            case 4: {
                String string = GenericPropertyUtility.getString(43451392, 1, genericPropertyContainer);
                int n5 = Integer.parseInt(string);
                return n5;
            }
            case 5: {
                String string = GenericPropertyUtility.getString(43451392, 3, genericPropertyContainer);
                int n6 = Integer.parseInt(string);
                return n6;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 0: {
                String string = GenericPropertyUtility.getString(43451392, 0, genericPropertyContainer);
                return string;
            }
            case 6: {
                String string = GenericPropertyUtility.getString(43451392, 2, genericPropertyContainer);
                return string;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        return null;
    }
}

