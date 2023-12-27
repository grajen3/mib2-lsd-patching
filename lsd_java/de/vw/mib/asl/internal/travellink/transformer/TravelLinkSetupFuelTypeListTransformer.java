/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import generated.de.vw.mib.asl.internal.travellink.transformer.AbstractTravelLinkSetupFuelTypeListTransformer;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public class TravelLinkSetupFuelTypeListTransformer
extends AbstractTravelLinkSetupFuelTypeListTransformer {
    @Override
    public String getString(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 0: {
                return GenericPropertyUtility.getString(-392100096, 0, genericPropertyContainer);
            }
        }
        throw new IllegalArgumentException();
    }
}

