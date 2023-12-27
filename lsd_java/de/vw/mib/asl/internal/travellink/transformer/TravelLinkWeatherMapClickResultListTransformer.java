/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import generated.de.vw.mib.asl.internal.travellink.transformer.AbstractTravelLinkWeatherMapClickResultListTransformer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class TravelLinkWeatherMapClickResultListTransformer
extends AbstractTravelLinkWeatherMapClickResultListTransformer {
    @Override
    public int getInt(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 1: {
                return GenericPropertyUtility.getInt(-1910897152, 0, genericPropertyContainer);
            }
            case 7: {
                return 0;
            }
            case 2: {
                return 0;
            }
            case 0: {
                return 0;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        switch (n) {
            case 4: {
                return null;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 5: {
                return GenericPropertyUtility.getString(-1759902208, 0, genericPropertyContainer);
            }
        }
        throw new IllegalArgumentException();
    }
}

