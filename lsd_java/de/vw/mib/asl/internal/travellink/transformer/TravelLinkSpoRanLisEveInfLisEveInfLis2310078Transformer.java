/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import generated.de.vw.mib.asl.internal.travellink.transformer.AbstractTravelLinkSpoRanLisEveInfLisEveInfLis2310078Transformer;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class TravelLinkSpoRanLisEveInfLisEveInfLis2310078Transformer
extends AbstractTravelLinkSpoRanLisEveInfLisEveInfLis2310078Transformer {
    @Override
    public int getInt(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 2: {
                int n2 = GenericPropertyUtility.getInt(664077312, 0, genericPropertyContainer);
                return n2;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 0: {
                String string = GenericPropertyUtility.getString(-879295488, 0, genericPropertyContainer);
                return string;
            }
        }
        throw new IllegalArgumentException();
    }
}

