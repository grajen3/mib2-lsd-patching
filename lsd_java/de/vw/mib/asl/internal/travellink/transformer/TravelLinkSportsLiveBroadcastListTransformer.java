/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import generated.de.vw.mib.asl.internal.travellink.transformer.AbstractTravelLinkSportsLiveBroadcastListTransformer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class TravelLinkSportsLiveBroadcastListTransformer
extends AbstractTravelLinkSportsLiveBroadcastListTransformer {
    @Override
    public int getInt(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 7: {
                return GenericPropertyUtility.getInt(580191232, 0, genericPropertyContainer);
            }
            case 0: {
                return GenericPropertyUtility.getInt(596968448, 0, genericPropertyContainer);
            }
            case 1: {
                return GenericPropertyUtility.getInt(613745664, 0, genericPropertyContainer);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 2: {
                return GenericPropertyUtility.getString(546636800, 0, genericPropertyContainer);
            }
            case 3: {
                return GenericPropertyUtility.getString(647300096, 0, genericPropertyContainer);
            }
            case 5: {
                return GenericPropertyUtility.getString(630522880, 0, genericPropertyContainer);
            }
            case 4: {
                return "";
            }
            case 6: {
                return "";
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 8: {
                return GenericPropertyUtility.getResourceLocator(563414016, 0, genericPropertyContainer);
            }
        }
        throw new IllegalArgumentException();
    }
}

