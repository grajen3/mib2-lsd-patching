/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.travellink.transformer.TravelLinkMovieStartTimesCollector;
import generated.de.vw.mib.asl.internal.travellink.transformer.AbstractTravelLinkMovieStarttimesTodayListTransformer;

public final class TravelLinkMovieStarttimesTodayListTransformer
extends AbstractTravelLinkMovieStarttimesTodayListTransformer {
    @Override
    public String getString(int n, Object object) {
        TravelLinkMovieStartTimesCollector travelLinkMovieStartTimesCollector = (TravelLinkMovieStartTimesCollector)object;
        switch (n) {
            case 0: {
                return travelLinkMovieStartTimesCollector.movieStartTimesColumn1;
            }
            case 1: {
                return travelLinkMovieStartTimesCollector.movieStartTimesColumn2;
            }
            case 2: {
                return travelLinkMovieStartTimesCollector.movieStartTimesColumn3;
            }
        }
        throw new IllegalArgumentException();
    }
}

