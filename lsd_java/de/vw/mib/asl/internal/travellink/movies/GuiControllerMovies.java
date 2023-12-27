/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.movies;

import de.vw.mib.asl.api.navigation.GuidanceInfo;
import de.vw.mib.asl.api.navigation.NavAddress;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.GuiControllerCommon;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.dsi.Constants;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyTraces;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkMovieStartTimesCollector;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkMovieTheaterResultsShowTimesListTransformer;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.travellink.transformer.TravelLinkMovieInfoCollector;
import generated.de.vw.mib.asl.internal.travellink.transformer.TravelLinkMovieTheaterAddressCollector;
import java.util.Arrays;
import org.dsi.ifc.travellink.GenericPropertyContainer;
import org.dsi.ifc.travellink.TravelLinkDate;

public final class GuiControllerMovies
implements GuiControllerCommon {
    private final int ITEM_COUNT_SHOW_TIMES_MAIN_VIEW;
    private String closestMovieTheaterNameForMainView = null;

    public GuiControllerMovies() {
        this.ITEM_COUNT_SHOW_TIMES_MAIN_VIEW = 4;
    }

    @Override
    public void setSubscriptionState(int n) {
        if (ServiceManager.logger2.isTraceEnabled(8)) {
            ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("GuiControllerMovies - setSubscriptionState(").append(n).append(")").log();
        }
        if (n == 2) {
            ServiceManager.aslPropertyManager.valueChangedInteger(4152, 1);
        } else if (n == 0) {
            ServiceManager.aslPropertyManager.valueChangedInteger(4152, 2);
        } else {
            ServiceManager.aslPropertyManager.valueChangedInteger(4152, 0);
        }
    }

    public void setListSortOrderForMoviesResult(int n) {
        if (ServiceManager.logger2.isTraceEnabled(8)) {
            ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("GuiControllerMovies - setListSortOrderForMoviesResult(").append(n).append(")").log();
        }
        if (n >= 0 && n <= 2) {
            ServiceManager.aslPropertyManager.valueChangedInteger(-1321262336, n);
        } else {
            ServiceManager.aslPropertyManager.valueChangedInteger(-1321262336, 2);
        }
    }

    public void prepareAndUpdateTheaterListForOneMovie(GenericPropertyContainer[] genericPropertyContainerArray) {
        if (ServiceManager.logger2.isTraceEnabled(8)) {
            ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("GuiControllerMovies : prepareAndUpdateTheaterListForOneMovie()").log();
            GenericPropertyTraces.printData(genericPropertyContainerArray);
        }
        if (null == genericPropertyContainerArray || genericPropertyContainerArray.length < 1) {
            ListManager.getGenericASLList(-1338039552).updateList(new GenericPropertyContainer[0]);
            if (TLinkServiceManager.getServiceManager().getCurrentViewId() == 38) {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(2067735296);
            }
        } else {
            Object[] objectArray = new GenericPropertyContainer[genericPropertyContainerArray.length];
            for (int i2 = 0; i2 < genericPropertyContainerArray.length; ++i2) {
                objectArray[i2] = GenericPropertyUtility.getCopy(genericPropertyContainerArray[i2]);
            }
            Arrays.sort(objectArray, TLinkServiceManager.getServiceManager().getComparatorTheaterListForOneMovie());
            ListManager.getGenericASLList(-1338039552).updateList(objectArray);
        }
    }

    public void prepareAndUpdateNearestTheaterForOneMovie(GenericPropertyContainer[] genericPropertyContainerArray) {
        if (ServiceManager.logger2.isTraceEnabled(8)) {
            ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("GuiControllerMovies : prepareAndUpdateNearestTheaterForOneMovie()").log();
            GenericPropertyTraces.printData(genericPropertyContainerArray);
        }
        if (null != genericPropertyContainerArray && genericPropertyContainerArray.length > 0) {
            Arrays.sort(genericPropertyContainerArray, TLinkServiceManager.getServiceManager().getComparatorTheaterListForOneMovie());
            TLinkServiceManager.getServiceManager().getGuiControllerMovies().updateSelectedMovieTheater(genericPropertyContainerArray[0]);
        }
    }

    public void prepareAndUpdateSelectMovieList(GenericPropertyContainer[] genericPropertyContainerArray) {
        if (ServiceManager.logger2.isTraceEnabled(8)) {
            ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("GuiControllerMovies : prepareAndUpdateSelectMovieList()").log();
            GenericPropertyTraces.printData(genericPropertyContainerArray);
        }
        if (null == genericPropertyContainerArray || genericPropertyContainerArray.length < 1) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(188752640, true);
            ListManager.getGenericASLList(-1388371200).updateList(new GenericPropertyContainer[0]);
        } else {
            ServiceManager.aslPropertyManager.valueChangedBoolean(188752640, false);
            Arrays.sort(genericPropertyContainerArray, TLinkServiceManager.getServiceManager().getComparatorMovies());
            Object[] objectArray = new GenericPropertyContainer[genericPropertyContainerArray.length];
            for (int i2 = 0; i2 < genericPropertyContainerArray.length; ++i2) {
                objectArray[i2] = GenericPropertyUtility.getCopy(genericPropertyContainerArray[i2]);
            }
            ListManager.getGenericASLList(-1388371200).updateList(objectArray);
        }
    }

    public void setMovieTheaterShowTimesListSortOrder(int n) {
        if (ServiceManager.logger2.isTraceEnabled(8)) {
            ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("GuiControllerMovies - setMovieTheaterShowTimesListSortOrder(").append(n).append(")").log();
        }
        if (n >= 0 && n <= 1) {
            ServiceManager.aslPropertyManager.valueChangedInteger(-1606475008, n);
        } else {
            ServiceManager.aslPropertyManager.valueChangedInteger(-1606475008, 1);
        }
    }

    public void setMovieTheatersSearchArea(int n) {
        if (ServiceManager.logger2.isTraceEnabled(8)) {
            ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("GuiControllerMovies - setMovieTheatersSearchArea(").append(n).append(")").log();
        }
        if (n >= 0 && n <= 2) {
            ServiceManager.aslPropertyManager.valueChangedInteger(-1841356032, n);
        } else {
            ServiceManager.aslPropertyManager.valueChangedInteger(-1841356032, 0);
        }
    }

    public void setMoviesSearchArea(int n) {
        if (ServiceManager.logger2.isTraceEnabled(8)) {
            ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("GuiControllerMovies - setMoviesSearchArea(").append(n).append(")").log();
        }
        if (n >= 0 && n <= 2) {
            ServiceManager.aslPropertyManager.valueChangedInteger(-1824578816, n);
        } else {
            ServiceManager.aslPropertyManager.valueChangedInteger(-1824578816, 0);
        }
    }

    public void updateSelectedMovieTheater(GenericPropertyContainer genericPropertyContainer) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(8)) {
                ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("GuiControllerMovies - updateSelectedMovieTheater()").log();
                GenericPropertyTraces.printData(new GenericPropertyContainer[]{genericPropertyContainer});
            }
            Object[] objectArray = new TravelLinkMovieTheaterAddressCollector[]{new TravelLinkMovieTheaterAddressCollector()};
            if (null == genericPropertyContainer) {
                objectArray[0].travellink_movie_theater_address__direction = 0;
                objectArray[0].travellink_movie_theater_address__distance = 0;
                objectArray[0].travellink_movie_theater_address__distance_and_unit = "";
                objectArray[0].travellink_movie_theater_address__name = "";
                objectArray[0].travellink_movie_theater_address__icon = Constants.INVALID_RESOURCE_LOCATOR_VALUE;
                objectArray[0].travellink_movie_theater_address__address = "";
            } else {
                String string;
                int n = GenericPropertyUtility.getInt(159842560, 0, genericPropertyContainer);
                objectArray[0].travellink_movie_theater_address__direction = n = TLinkServiceManager.getServiceManager().getTravelLinkUtil().checkDirection(n);
                objectArray[0].travellink_movie_theater_address__distance = GenericPropertyUtility.getInt(143065344, 0, genericPropertyContainer);
                int n2 = GenericPropertyUtility.getInt(143065344, 0, genericPropertyContainer);
                objectArray[0].travellink_movie_theater_address__distance_and_unit = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getDistanceValueAndUnit(n2);
                ((TravelLinkMovieTheaterAddressCollector)objectArray[0]).travellink_movie_theater_address__icon = GenericPropertyUtility.getResourceLocator(92733696, 0, genericPropertyContainer);
                ((TravelLinkMovieTheaterAddressCollector)objectArray[0]).travellink_movie_theater_address__name = GenericPropertyUtility.getString(126288128, 0, genericPropertyContainer);
                String string2 = GenericPropertyUtility.getString(310837504, 0, genericPropertyContainer);
                String string3 = GenericPropertyUtility.getString(260505856, 0, genericPropertyContainer);
                String string4 = GenericPropertyUtility.getString(277283072, 0, genericPropertyContainer);
                String string5 = GenericPropertyUtility.getString(327614720, 0, genericPropertyContainer);
                String string6 = GenericPropertyUtility.getString(344391936, 0, genericPropertyContainer);
                String string7 = GenericPropertyUtility.getString(294060288, 0, genericPropertyContainer);
                ((TravelLinkMovieTheaterAddressCollector)objectArray[0]).travellink_movie_theater_address__address = string = TLinkServiceManager.getServiceManager().getTravelLinkUtil().generateFormattedAddressNamingRuleA(string2, string3, string4, string5, string6, string7);
            }
            ListManager.getGenericASLList(-398515456).updateList(objectArray);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateSelectedMovieTheaterUpcomingStartingTimes(GenericPropertyContainer genericPropertyContainer) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(8)) {
                ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("GuiControllerMovies - updateSelectedMovieTheaterUpcomingStartingTimes()").log();
                GenericPropertyTraces.printData(new GenericPropertyContainer[]{genericPropertyContainer});
            }
            if (null != genericPropertyContainer) {
                TravelLinkDate[] travelLinkDateArray = GenericPropertyUtility.getDateArray(193396992, genericPropertyContainer);
                TravelLinkDate[] travelLinkDateArray2 = GenericPropertyUtility.getDateArray(210174208, genericPropertyContainer);
                this.updateSelectedMovieTheaterUpcomingStartingTimes(-566287616, travelLinkDateArray);
                this.updateSelectedMovieTheaterUpcomingStartingTimes(-549510400, travelLinkDateArray2);
            } else {
                this.updateSelectedMovieTheaterUpcomingStartingTimes(-566287616, null);
                this.updateSelectedMovieTheaterUpcomingStartingTimes(-549510400, null);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateSelectedMovieTheaterUpcomingStartingTimes(int n, TravelLinkDate[] travelLinkDateArray) {
        if (null != travelLinkDateArray) {
            int n2;
            if (ServiceManager.logger2.isTraceEnabled(8)) {
                ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("GuiControllerMovies - updateSelectedMovieTheaterUpcomingStartingTimes(), listId = ").append(n).log();
            }
            int n3 = travelLinkDateArray.length / 3;
            if (travelLinkDateArray.length % 3 > 0) {
                ++n3;
            }
            Object[] objectArray = new TravelLinkMovieStartTimesCollector[n3];
            for (n2 = 0; n2 < objectArray.length; ++n2) {
                objectArray[n2] = new TravelLinkMovieStartTimesCollector();
            }
            n2 = 0;
            for (int i2 = 0; i2 < travelLinkDateArray.length; ++i2) {
                if (null == travelLinkDateArray[i2]) continue;
                byte by = travelLinkDateArray[i2].getHour();
                byte by2 = travelLinkDateArray[i2].getMinute();
                if (by <= -1 || by2 <= -1) continue;
                String string = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedTime(by, by2);
                if (n2 <= -1 || n2 >= objectArray.length) continue;
                if (i2 % 3 == 0) {
                    ((TravelLinkMovieStartTimesCollector)objectArray[n2]).movieStartTimesColumn1 = string;
                    continue;
                }
                if (i2 % 3 == 1) {
                    ((TravelLinkMovieStartTimesCollector)objectArray[n2]).movieStartTimesColumn2 = string;
                    continue;
                }
                if (i2 % 3 != 2) continue;
                ((TravelLinkMovieStartTimesCollector)objectArray[n2]).movieStartTimesColumn3 = string;
                ++n2;
            }
            ListManager.getGenericASLList(n).updateList(objectArray);
        } else {
            ListManager.getGenericASLList(n).updateList(new TravelLinkMovieStartTimesCollector[0]);
        }
    }

    public void updateSelectedMovie(GenericPropertyContainer[] genericPropertyContainerArray) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(8)) {
                ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("GuiControllerMovies - updateSelectedMovie()").log();
                GenericPropertyTraces.printData(genericPropertyContainerArray);
            }
            boolean bl = true;
            Object[] objectArray = new TravelLinkMovieInfoCollector[]{new TravelLinkMovieInfoCollector()};
            if (null != genericPropertyContainerArray && genericPropertyContainerArray.length > 0 && null != genericPropertyContainerArray[0] && null != genericPropertyContainerArray[0].values) {
                int n;
                StringBuffer stringBuffer = new StringBuffer(50);
                if (genericPropertyContainerArray[0].values.length > 1 && null != genericPropertyContainerArray[0].values[1] && null != genericPropertyContainerArray[0].values[1].valuesString) {
                    n = genericPropertyContainerArray[0].values[1].valuesString.length;
                    Object[] objectArray2 = new String[n];
                    for (int i2 = 0; i2 < n; ++i2) {
                        if (null != genericPropertyContainerArray[0].values[1].valuesString[i2]) {
                            if (i2 > 0) {
                                stringBuffer.append("\n");
                            }
                            stringBuffer.append(genericPropertyContainerArray[0].values[1].valuesString[i2]);
                            objectArray2[i2] = genericPropertyContainerArray[0].values[1].valuesString[i2];
                            continue;
                        }
                        objectArray2[i2] = "";
                    }
                    ListManager.getGenericASLList(-583064832).updateList(objectArray2);
                } else {
                    ListManager.getGenericASLList(-583064832).updateList(new String[0]);
                }
                objectArray[0].travellink_movie_info__actors = stringBuffer.toString();
                ((TravelLinkMovieInfoCollector)objectArray[0]).travellink_movie_info__duration = GenericPropertyUtility.getInt(1820786944, 0, genericPropertyContainerArray[0]);
                ((TravelLinkMovieInfoCollector)objectArray[0]).travellink_movie_info__name = GenericPropertyUtility.getString(1804009728, 0, genericPropertyContainerArray[0]);
                ((TravelLinkMovieInfoCollector)objectArray[0]).travellink_movie_info__synopsis = GenericPropertyUtility.getString(1787232512, 0, genericPropertyContainerArray[0]);
                n = GenericPropertyUtility.getInt(1837564160, 0, genericPropertyContainerArray[0]);
                ((TravelLinkMovieInfoCollector)objectArray[0]).travellink_movie_info__rating = n >= 0 && n <= 6 ? n : 6;
            } else {
                ListManager.getGenericASLList(-583064832).updateList(new String[0]);
                objectArray[0].travellink_movie_info__actors = "";
                objectArray[0].travellink_movie_info__duration = 0;
                objectArray[0].travellink_movie_info__name = "";
                objectArray[0].travellink_movie_info__rating = 6;
                objectArray[0].travellink_movie_info__synopsis = "";
                if (ServiceManager.logger2.isTraceEnabled(8)) {
                    ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("GuiControllerMovies : prepareAndUpdateMovieInfoView : containerArray is not valid").log();
                }
            }
            ListManager.getGenericASLList(-1371593984).updateList(objectArray);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void prepareAndUpdateSelectedMovieName(String string) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(8)) {
                ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("GuiControllerMovies - prepareAndUpdateSelectedMovieName(").append(string).append(")").log();
            }
            Object[] objectArray = new TravelLinkMovieInfoCollector[]{new TravelLinkMovieInfoCollector()};
            objectArray[0].travellink_movie_info__actors = "";
            objectArray[0].travellink_movie_info__duration = 0;
            objectArray[0].travellink_movie_info__name = "";
            if (null != string) {
                objectArray[0].travellink_movie_info__name = string;
            }
            objectArray[0].travellink_movie_info__synopsis = "";
            ListManager.getGenericASLList(-1371593984).updateList(objectArray);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void prepareAndUpdateClosestMovieTheater(GenericPropertyContainer[] genericPropertyContainerArray) {
        if (null != genericPropertyContainerArray && genericPropertyContainerArray.length > 0) {
            if (ServiceManager.logger2.isTraceEnabled(8)) {
                ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("GuiControllerMovies - prepareAndUpdateClosestMovieTheater()").log();
                GenericPropertyTraces.printData(genericPropertyContainerArray);
            }
            int n = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getListSortOrderForMovieTheaterResult();
            TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setListSortOrderForMovieTheaterResult(1);
            Arrays.sort(genericPropertyContainerArray, TLinkServiceManager.getServiceManager().getComparatorMovieTheatersResultsList());
            if (ServiceManager.logger2.isTraceEnabled(8)) {
                ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("GuiControllerMovies - prepareAndUpdateClosestMovieTheater() - After sorting:").log();
                GenericPropertyTraces.printData(genericPropertyContainerArray);
            }
            TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setListSortOrderForMovieTheaterResult(n);
            if (null != genericPropertyContainerArray && genericPropertyContainerArray.length > 0 && null != genericPropertyContainerArray[0]) {
                String string = GenericPropertyUtility.getString(126288128, 0, genericPropertyContainerArray[0]);
                TLinkServiceManager.getServiceManager().getMovieTheaters().setClosestTheaterForMovieTheaters(GenericPropertyUtility.getCopy(genericPropertyContainerArray[0]));
                if (null == string) {
                    string = "";
                }
                ServiceManager.aslPropertyManager.valueChangedString(2017403648, string);
                if (null == this.closestMovieTheaterNameForMainView || !string.equals(this.closestMovieTheaterNameForMainView)) {
                    Object[] objectArray = new TravelLinkMovieStartTimesCollector[4];
                    for (int i2 = 0; i2 < objectArray.length; ++i2) {
                        objectArray[i2] = new TravelLinkMovieStartTimesCollector();
                    }
                    ListManager.getGenericASLList(-1438702848).updateList(objectArray);
                    this.closestMovieTheaterNameForMainView = string;
                }
                long l = GenericPropertyUtility.getLong(75956480, 0, genericPropertyContainerArray[0]);
                TLinkServiceManager.getServiceManager().getDsiTravelLinkMoviesAdapter().requestTheaterShowTimes(l, 54);
            } else {
                int n2 = TLinkServiceManager.getServiceManager().getGuiControllerMovieTheaters().getMovieLoadingState();
                if (n2 != 0) {
                    TLinkServiceManager.getServiceManager().getGuiControllerMovieTheaters().updateMovieLoadingState(0);
                }
                if (ServiceManager.logger2.isTraceEnabled(8)) {
                    ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("GuiControllerMovies : prepareAndUpdateClosestMovieTheater : containerArray is not valid").log();
                }
            }
        } else {
            int n = TLinkServiceManager.getServiceManager().getGuiControllerMovieTheaters().getMovieLoadingState();
            if (n != 0) {
                TLinkServiceManager.getServiceManager().getGuiControllerMovieTheaters().updateMovieLoadingState(0);
            }
        }
    }

    public void prepareAndUpdateMovieTheaterShowTimes(GenericPropertyContainer[] genericPropertyContainerArray) {
        int n;
        if (ServiceManager.logger2.isTraceEnabled(8)) {
            ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("GuiControllerMovies : prepareAndUpdateMovieTheaterShowTimes()").log();
            GenericPropertyTraces.printData(genericPropertyContainerArray);
        }
        Object[] objectArray = new TravelLinkMovieStartTimesCollector[4];
        for (n = 0; n < objectArray.length; ++n) {
            objectArray[n] = new TravelLinkMovieStartTimesCollector();
        }
        if (null != genericPropertyContainerArray && genericPropertyContainerArray.length > 0) {
            int n2;
            n = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getListSortOrderForMovieTheaterShowTimes();
            TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setListSortOrderForMovieTheaterShowTimes(1);
            Arrays.sort(genericPropertyContainerArray, TLinkServiceManager.getServiceManager().getComparatorMovieShowTimes());
            TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setListSortOrderForMovieTheaterShowTimes(n);
            for (n2 = 0; n2 < genericPropertyContainerArray.length && n2 < 4; ++n2) {
                if (null == genericPropertyContainerArray[n2]) continue;
                ((TravelLinkMovieStartTimesCollector)objectArray[n2]).movieStartTimesColumn1 = GenericPropertyUtility.getString(-813235968, 0, genericPropertyContainerArray[n2]);
                int n3 = TravelLinkMovieTheaterResultsShowTimesListTransformer.getMovieShowTime(0, genericPropertyContainerArray[n2], false);
                int n4 = TravelLinkMovieTheaterResultsShowTimesListTransformer.getMovieShowTime(0, genericPropertyContainerArray[n2], true);
                ((TravelLinkMovieStartTimesCollector)objectArray[n2]).movieStartTimesColumn2 = "--";
                if (!TLinkServiceManager.getServiceManager().getTravelLinkUtil().isHourValid(n3) || !TLinkServiceManager.getServiceManager().getTravelLinkUtil().isMinuteValid(n4)) continue;
                ((TravelLinkMovieStartTimesCollector)objectArray[n2]).movieStartTimesColumn2 = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedTime(n3, n4);
                if (((TravelLinkMovieStartTimesCollector)objectArray[n2]).movieStartTimesColumn2.length() >= 1) continue;
                ((TravelLinkMovieStartTimesCollector)objectArray[n2]).movieStartTimesColumn2 = "--";
            }
            n2 = TLinkServiceManager.getServiceManager().getGuiControllerMovieTheaters().getMovieLoadingState();
            if (n2 != 2) {
                TLinkServiceManager.getServiceManager().getGuiControllerMovieTheaters().updateMovieLoadingState(2);
            }
        } else {
            n = TLinkServiceManager.getServiceManager().getGuiControllerMovieTheaters().getMovieLoadingState();
            if (n != 4) {
                TLinkServiceManager.getServiceManager().getGuiControllerMovieTheaters().updateMovieLoadingState(4);
            }
        }
        ListManager.getGenericASLList(-1438702848).updateList(objectArray);
    }

    public void setMoviesHeadline(String string) {
        if (ServiceManager.logger2.isTraceEnabled(8)) {
            if (ServiceManager.logger2.isTraceEnabled(8)) {
                ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("GuiControllerMovies - setMoviesHeadline(").append(string).append(")").log();
            }
            if (null != string) {
                ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("GuiControllerMovies : setMoviesHeadline(), movieName = ").append(string).log();
            } else {
                ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("GuiControllerMovies : setMoviesHeadline(), movieName == null").log();
            }
        }
        if (null != string) {
            ServiceManager.aslPropertyManager.valueChangedString(-666950912, string);
        } else {
            ServiceManager.aslPropertyManager.valueChangedString(-666950912, "");
        }
    }

    public void updateNavigationAddressWithSelectedSearchArea() {
        try {
            NavAddress navAddress;
            GuidanceInfo[] guidanceInfoArray;
            int n = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getMoviesSearchArea();
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
}

