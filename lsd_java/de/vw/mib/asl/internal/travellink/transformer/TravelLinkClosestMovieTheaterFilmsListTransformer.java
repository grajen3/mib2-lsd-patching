/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.travellink.transformer.TravelLinkMovieStartTimesCollector;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkMovieTheaterResultsShowTimesListTransformer;
import generated.de.vw.mib.asl.internal.travellink.transformer.AbstractTravelLinkClosestMovieTheaterFilmsListTransformer;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class TravelLinkClosestMovieTheaterFilmsListTransformer
extends AbstractTravelLinkClosestMovieTheaterFilmsListTransformer {
    @Override
    public int getInt(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 1: {
                return TravelLinkMovieTheaterResultsShowTimesListTransformer.getMovieShowTime(0, genericPropertyContainer, false);
            }
            case 2: {
                return TravelLinkMovieTheaterResultsShowTimesListTransformer.getMovieShowTime(0, genericPropertyContainer, true);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        TravelLinkMovieStartTimesCollector travelLinkMovieStartTimesCollector = (TravelLinkMovieStartTimesCollector)object;
        switch (n) {
            case 0: {
                return travelLinkMovieStartTimesCollector.movieStartTimesColumn1;
            }
            case 3: {
                return travelLinkMovieStartTimesCollector.movieStartTimesColumn2;
            }
        }
        throw new IllegalArgumentException();
    }
}

