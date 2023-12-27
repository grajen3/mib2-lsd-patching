/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import generated.de.vw.mib.asl.internal.travellink.transformer.AbstractTravelLinkSelectableSkiStateListTransformer;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class TravelLinkSelectableSkiStateListTransformer
extends AbstractTravelLinkSelectableSkiStateListTransformer {
    @Override
    public String getString(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 0: {
                return GenericPropertyUtility.getString(-1525873920, 0, genericPropertyContainer);
            }
        }
        throw new IllegalArgumentException();
    }
}

