/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.movies;

import de.vw.mib.asl.api.navigation.GuidanceInfo;
import de.vw.mib.asl.api.navigation.NavAddress;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.travellink.transformer.TravelLinkMovieInfoCollector;
import java.util.Arrays;
import org.dsi.ifc.travellink.GenericPropertyContainer;
import org.dsi.ifc.travellink.TravelLinkDate;

public final class GuiControllerMovieTheaters {
    private int movieLoadingState = -1;

    public void setMovieTheatersResultListSortOrder(int n) {
        if (n >= 0 && n <= 1) {
            ServiceManager.aslPropertyManager.valueChangedInteger(2101289728, n);
        } else {
            ServiceManager.aslPropertyManager.valueChangedInteger(2101289728, 1);
        }
    }

    public void prepareAndUpdateMovieTheatersResultsList(GenericPropertyContainer[] genericPropertyContainerArray) {
        if (ServiceManager.logger2.isTraceEnabled(8)) {
            ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("GuiControllerMovieTheaters : prepareAndUpdateMovieTheatersResultsList()").log();
        }
        if (null == genericPropertyContainerArray || genericPropertyContainerArray.length < 1) {
            ListManager.getGenericASLList(-1656806656).updateList(new GenericPropertyContainer[0]);
            if (2 == TLinkServiceManager.getServiceManager().getMovies().getMovieTheatersSearchTheatersRequestType()) {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(2067735296);
            }
        } else {
            Object[] objectArray = new GenericPropertyContainer[genericPropertyContainerArray.length];
            for (int i2 = 0; i2 < genericPropertyContainerArray.length; ++i2) {
                objectArray[i2] = GenericPropertyUtility.getCopy(genericPropertyContainerArray[i2]);
            }
            Arrays.sort(objectArray, TLinkServiceManager.getServiceManager().getComparatorMovieTheatersResultsList());
            ListManager.getGenericASLList(-1656806656).updateList(objectArray);
        }
    }

    public void prepareAndUpdateMovieTheaterShowTimes(GenericPropertyContainer[] genericPropertyContainerArray) {
        if (ServiceManager.logger2.isTraceEnabled(8)) {
            ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("GuiControllerMovieTheaters : prepareAndUpdateMovieTheaterShowTimes()").log();
        }
        if (null == genericPropertyContainerArray || genericPropertyContainerArray.length < 1) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(104866560, true);
            ListManager.getGenericASLList(-1589697792).updateList(new GenericPropertyContainer[0]);
        } else {
            ServiceManager.aslPropertyManager.valueChangedBoolean(104866560, false);
            Object[] objectArray = new GenericPropertyContainer[genericPropertyContainerArray.length];
            for (int i2 = 0; i2 < genericPropertyContainerArray.length; ++i2) {
                objectArray[i2] = GenericPropertyUtility.getCopy(genericPropertyContainerArray[i2]);
            }
            Arrays.sort(objectArray, TLinkServiceManager.getServiceManager().getComparatorMovieShowTimes());
            ListManager.getGenericASLList(-1589697792).updateList(objectArray);
        }
    }

    public void prepareAndUpdateSelectedMovieDetails(GenericPropertyContainer genericPropertyContainer) {
        try {
            boolean bl = true;
            Object[] objectArray = new TravelLinkMovieInfoCollector[]{new TravelLinkMovieInfoCollector()};
            if (null != genericPropertyContainer && null != genericPropertyContainer.values) {
                Object[] objectArray2;
                int n;
                StringBuffer stringBuffer = new StringBuffer(50);
                if (genericPropertyContainer.values.length > 1 && null != genericPropertyContainer.values[1] && null != genericPropertyContainer.values[1].valuesString) {
                    n = genericPropertyContainer.values[1].valuesString.length;
                    objectArray2 = new String[n];
                    for (int i2 = 0; i2 < n; ++i2) {
                        if (null != genericPropertyContainer.values[1].valuesString[i2]) {
                            if (i2 > 0) {
                                stringBuffer.append("\n");
                            }
                            stringBuffer.append(genericPropertyContainer.values[1].valuesString[i2]);
                            objectArray2[i2] = genericPropertyContainer.values[1].valuesString[i2];
                            continue;
                        }
                        objectArray2[i2] = "";
                    }
                    ListManager.getGenericASLList(-583064832).updateList(objectArray2);
                } else {
                    ListManager.getGenericASLList(-583064832).updateList(new String[0]);
                }
                objectArray[0].travellink_movie_info__actors = stringBuffer.toString();
                objectArray[0].travellink_movie_info__duration = GenericPropertyUtility.getInt(-796458752, 0, genericPropertyContainer);
                objectArray[0].travellink_movie_info__name = GenericPropertyUtility.getString(-813235968, 0, genericPropertyContainer);
                ((TravelLinkMovieInfoCollector)objectArray[0]).travellink_movie_info__synopsis = GenericPropertyUtility.getString(-830013184, 0, genericPropertyContainer);
                n = GenericPropertyUtility.getInt(-779681536, 0, genericPropertyContainer);
                ((TravelLinkMovieInfoCollector)objectArray[0]).travellink_movie_info__rating = n >= 0 && n <= 6 ? n : 6;
                objectArray2 = GenericPropertyUtility.getDateArray(-746127104, genericPropertyContainer);
                TravelLinkDate[] travelLinkDateArray = GenericPropertyUtility.getDateArray(-729349888, genericPropertyContainer);
                TLinkServiceManager.getServiceManager().getGuiControllerMovies().updateSelectedMovieTheaterUpcomingStartingTimes(-566287616, (TravelLinkDate[])objectArray2);
                TLinkServiceManager.getServiceManager().getGuiControllerMovies().updateSelectedMovieTheaterUpcomingStartingTimes(-549510400, travelLinkDateArray);
            } else {
                objectArray[0].travellink_movie_info__actors = "";
                objectArray[0].travellink_movie_info__duration = 0;
                objectArray[0].travellink_movie_info__name = "";
                objectArray[0].travellink_movie_info__rating = 6;
                objectArray[0].travellink_movie_info__synopsis = "";
                TLinkServiceManager.getServiceManager().getGuiControllerMovies().updateSelectedMovieTheaterUpcomingStartingTimes(-566287616, null);
                TLinkServiceManager.getServiceManager().getGuiControllerMovies().updateSelectedMovieTheaterUpcomingStartingTimes(-549510400, null);
                if (ServiceManager.logger2.isTraceEnabled(8)) {
                    ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("GuiControllerMovieTheaters : prepareAndUpdateSelectedMovieDetails : containerArray is not valid").log();
                }
            }
            ListManager.getGenericASLList(-1371593984).updateList(objectArray);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void setMovieTheatersHeadline(String string) {
        if (ServiceManager.logger2.isTraceEnabled(8)) {
            if (null != string) {
                ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("GuiControllerMovieTheaters : setMovieTheatersHeadline(), movieTheaterName = ").append(string).log();
            } else {
                ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("GuiControllerMovieTheaters : setMovieTheatersHeadline(), movieTheaterName == null").log();
            }
        }
        if (null != string) {
            ServiceManager.aslPropertyManager.valueChangedString(-650173696, string);
        } else {
            ServiceManager.aslPropertyManager.valueChangedString(-650173696, "");
        }
    }

    public void updateNavigationAddressWithSelectedSearchArea() {
        try {
            NavAddress navAddress;
            GuidanceInfo[] guidanceInfoArray;
            int n = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getMovieTheatersSearchArea();
            String string = "";
            if (0 == n) {
                NavAddress navAddress2 = TLinkServiceManager.getServiceManager().getApiNavigation().getCurrentCarPosition();
                if (null != navAddress2) {
                    String string2 = navAddress2.getCity();
                    String string3 = navAddress2.getStreet();
                    String string4 = navAddress2.getHousenumber();
                    String string5 = navAddress2.getCountry();
                    String string6 = navAddress2.getState();
                    String string7 = navAddress2.getZip();
                    string = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getNavigationFormattedAddressNamingRule14(string2, string3, string4, string5, string6, string7);
                }
            } else if (2 == n && null != (guidanceInfoArray = TLinkServiceManager.getServiceManager().getApiNavigation().getGuidanceInfo()) && null != (navAddress = guidanceInfoArray[1].getAddress())) {
                String string8 = navAddress.getCity();
                String string9 = navAddress.getStreet();
                String string10 = navAddress.getHousenumber();
                String string11 = navAddress.getCountry();
                String string12 = navAddress.getState();
                String string13 = navAddress.getZip();
                string = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getNavigationFormattedAddressNamingRule14(string8, string9, string10, string11, string12, string13);
            }
            ServiceManager.aslPropertyManager.valueChangedString(138420992, string);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateMovieLoadingState(int n) {
        this.movieLoadingState = n;
        ServiceManager.aslPropertyManager.valueChangedInteger(-1522588928, n);
    }

    public int getMovieLoadingState() {
        return this.movieLoadingState;
    }
}

