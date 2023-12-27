/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import de.vw.mib.asl.internal.travellink.movies.MovieShowTime;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkMovieTheaterResultsShowTimesListTransformer;
import generated.de.vw.mib.asl.internal.travellink.transformer.AbstractTravelLinkMoviesResultsListTransformer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.travellink.GenericPropertyContainer;
import org.dsi.ifc.travellink.TravelLinkDate;

public final class TravelLinkMoviesResultsListTransformer
extends AbstractTravelLinkMoviesResultsListTransformer {
    @Override
    public Object get(int n, Object object) {
        return null;
    }

    @Override
    public boolean getBoolean(int n, Object object) {
        switch (n) {
            case 6: {
                return true;
            }
            case 7: {
                return true;
            }
            case 8: {
                return true;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 3: {
                return 0;
            }
            case 9: {
                return this.getMovieShowTime(0, genericPropertyContainer, false);
            }
            case 10: {
                return this.getMovieShowTime(1, genericPropertyContainer, false);
            }
            case 11: {
                return this.getMovieShowTime(2, genericPropertyContainer, false);
            }
            case 12: {
                return this.getMovieShowTime(0, genericPropertyContainer, true);
            }
            case 13: {
                return this.getMovieShowTime(1, genericPropertyContainer, true);
            }
            case 14: {
                return this.getMovieShowTime(2, genericPropertyContainer, true);
            }
            case 2: {
                return GenericPropertyUtility.getInt(143065344, 0, genericPropertyContainer);
            }
            case 1: {
                return GenericPropertyUtility.getInt(159842560, 0, genericPropertyContainer);
            }
            case 0: {
                return 0;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
        switch (n) {
            case 4: {
                return GenericPropertyUtility.getResourceLocator(92733696, 0, genericPropertyContainer);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        try {
            GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)object;
            switch (n) {
                case 19: {
                    MovieShowTime movieShowTime = TravelLinkMoviesResultsListTransformer.getMovieShowTime(0, genericPropertyContainer);
                    return TravelLinkMovieTheaterResultsShowTimesListTransformer.getFormattedMovieShowTime(movieShowTime);
                }
                case 20: {
                    MovieShowTime movieShowTime = TravelLinkMoviesResultsListTransformer.getMovieShowTime(1, genericPropertyContainer);
                    return TravelLinkMovieTheaterResultsShowTimesListTransformer.getFormattedMovieShowTime(movieShowTime);
                }
                case 21: {
                    MovieShowTime movieShowTime = TravelLinkMoviesResultsListTransformer.getMovieShowTime(2, genericPropertyContainer);
                    return TravelLinkMovieTheaterResultsShowTimesListTransformer.getFormattedMovieShowTime(movieShowTime);
                }
                case 15: 
                case 16: 
                case 17: {
                    return "";
                }
                case 5: {
                    return GenericPropertyUtility.getString(126288128, 0, genericPropertyContainer);
                }
                case 18: {
                    int n2 = GenericPropertyUtility.getInt(143065344, 0, genericPropertyContainer);
                    return TLinkServiceManager.getServiceManager().getTravelLinkUtil().getDistanceValueAndUnit(n2);
                }
            }
            throw new IllegalArgumentException();
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return "";
        }
    }

    private int getMovieShowTime(int n, GenericPropertyContainer genericPropertyContainer, boolean bl) {
        TravelLinkDate[] travelLinkDateArray = GenericPropertyUtility.getDateArray(193396992, genericPropertyContainer);
        TravelLinkDate[] travelLinkDateArray2 = GenericPropertyUtility.getDateArray(210174208, genericPropertyContainer);
        return TLinkServiceManager.getServiceManager().getTravelLinkDateUtility().getMovieShowTime(n, travelLinkDateArray, travelLinkDateArray2, bl);
    }

    public static MovieShowTime getMovieShowTime(int n, GenericPropertyContainer genericPropertyContainer) {
        TravelLinkDate[] travelLinkDateArray = GenericPropertyUtility.getDateArray(193396992, genericPropertyContainer);
        TravelLinkDate[] travelLinkDateArray2 = GenericPropertyUtility.getDateArray(210174208, genericPropertyContainer);
        return TLinkServiceManager.getServiceManager().getTravelLinkDateUtility().getMovieShowTime(n, travelLinkDateArray, travelLinkDateArray2);
    }
}

