/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import generated.de.vw.mib.asl.internal.travellink.transformer.AbstractTravelLinkSelectableMovieListTransformer;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class TravelLinkSelectableMovieListTransformer
extends AbstractTravelLinkSelectableMovieListTransformer {
    @Override
    public int getInt(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 0: {
                return GenericPropertyUtility.getInt(814219520, 0, genericPropertyContainer);
            }
            case 3: {
                return GenericPropertyUtility.getInt(864551168, 0, genericPropertyContainer);
            }
            case 2: {
                int n2 = GenericPropertyUtility.getInt(847773952, 0, genericPropertyContainer);
                if (n2 >= 0 && n2 <= 7) {
                    return n2;
                }
                return 6;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 1: {
                return GenericPropertyUtility.getString(830996736, 0, genericPropertyContainer);
            }
        }
        throw new IllegalArgumentException();
    }
}

