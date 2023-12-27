/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import de.vw.mib.asl.internal.travellink.movies.MovieShowTime;
import generated.de.vw.mib.asl.internal.travellink.transformer.AbstractTravelLinkMovieTheaterResultsShowTimesListTransformer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.travellink.GenericPropertyContainer;
import org.dsi.ifc.travellink.TravelLinkDate;

public final class TravelLinkMovieTheaterResultsShowTimesListTransformer
extends AbstractTravelLinkMovieTheaterResultsShowTimesListTransformer {
    @Override
    public int getInt(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 0: {
                return GenericPropertyUtility.getInt(-863567616, 0, genericPropertyContainer);
            }
            case 3: {
                return GenericPropertyUtility.getInt(-779681536, 0, genericPropertyContainer);
            }
            case 4: {
                return 0;
            }
            case 5: {
                return 0;
            }
            case 6: {
                return 0;
            }
            case 7: {
                return 0;
            }
            case 8: {
                return 0;
            }
            case 9: {
                return 0;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        switch (n) {
            case 1: {
                return new ResourceLocator();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 2: {
                return GenericPropertyUtility.getString(-813235968, 0, genericPropertyContainer);
            }
            case 10: {
                MovieShowTime movieShowTime = TravelLinkMovieTheaterResultsShowTimesListTransformer.getMovieShowTime(0, genericPropertyContainer);
                return TravelLinkMovieTheaterResultsShowTimesListTransformer.getFormattedMovieShowTime(movieShowTime);
            }
            case 11: {
                MovieShowTime movieShowTime = TravelLinkMovieTheaterResultsShowTimesListTransformer.getMovieShowTime(1, genericPropertyContainer);
                return TravelLinkMovieTheaterResultsShowTimesListTransformer.getFormattedMovieShowTime(movieShowTime);
            }
            case 12: {
                MovieShowTime movieShowTime = TravelLinkMovieTheaterResultsShowTimesListTransformer.getMovieShowTime(2, genericPropertyContainer);
                return TravelLinkMovieTheaterResultsShowTimesListTransformer.getFormattedMovieShowTime(movieShowTime);
            }
        }
        throw new IllegalArgumentException();
    }

    public static int getMovieShowTime(int n, GenericPropertyContainer genericPropertyContainer, boolean bl) {
        TravelLinkDate[] travelLinkDateArray = GenericPropertyUtility.getDateArray(-746127104, genericPropertyContainer);
        TravelLinkDate[] travelLinkDateArray2 = GenericPropertyUtility.getDateArray(-729349888, genericPropertyContainer);
        return TLinkServiceManager.getServiceManager().getTravelLinkDateUtility().getMovieShowTime(n, travelLinkDateArray, travelLinkDateArray2, bl);
    }

    public static MovieShowTime getMovieShowTime(int n, GenericPropertyContainer genericPropertyContainer) {
        TravelLinkDate[] travelLinkDateArray = GenericPropertyUtility.getDateArray(-746127104, genericPropertyContainer);
        TravelLinkDate[] travelLinkDateArray2 = GenericPropertyUtility.getDateArray(-729349888, genericPropertyContainer);
        return TLinkServiceManager.getServiceManager().getTravelLinkDateUtility().getMovieShowTime(n, travelLinkDateArray, travelLinkDateArray2);
    }

    public static String getFormattedMovieShowTime(MovieShowTime movieShowTime) {
        if (null == movieShowTime) {
            return "--";
        }
        if (movieShowTime.getHour() < 0 || movieShowTime.getMinute() < 0) {
            return "--";
        }
        String string = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedTime(movieShowTime.getHour(), movieShowTime.getMinute());
        if (movieShowTime.isTomorrow()) {
            return new StringBuffer().append(string).append(" (+1)").toString();
        }
        return string;
    }
}

