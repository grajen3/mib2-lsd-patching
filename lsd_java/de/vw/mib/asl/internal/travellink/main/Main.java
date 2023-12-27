/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.main;

import de.vw.mib.asl.api.navigation.ASLNavigationServices;
import de.vw.mib.asl.api.radio.ASLRadioAPI;
import de.vw.mib.asl.api.radio.ASLRadioFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.DataProcessor;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import de.vw.mib.asl.internal.travellink.main.TargetMain;
import de.vw.mib.genericevents.EventGeneric;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class Main
implements DataProcessor {
    @Override
    public void processAndUpdate(int n, GenericPropertyContainer[] genericPropertyContainerArray, int n2, int n3) {
        switch (n) {
            case 1: {
                this.updateSubscribtionStatus(genericPropertyContainerArray);
                break;
            }
            case 58: {
                this.printFactoryResetStatus(genericPropertyContainerArray);
                break;
            }
            case 0: {
                TLinkServiceManager.getServiceManager().getGuiControllerMain().printStopUpdateStatus(genericPropertyContainerArray);
                break;
            }
            default: {
                if (!ServiceManager.logger2.isTraceEnabled(2)) break;
                ServiceManager.logger2.error(2).append("Main : processAndUpdate : RequestType is not handled. RequestTypeID --> ").append(n).log();
            }
        }
    }

    public void requestNearByData() {
        TLinkServiceManager.getServiceManager().getDsiTravelLinkFuelAdapter().requestFuelStations("", 0, 49);
        TLinkServiceManager.getServiceManager().getDsiTravelLinkMoviesAdapter().requestMovieTheaters(-1, 0, "", 50);
        TLinkServiceManager.getServiceManager().getGuiControllerMovieTheaters().updateMovieLoadingState(1);
        int n = -1;
        boolean bl = true;
        TLinkServiceManager.getServiceManager().getDsiTravelLinkWeatherAdapter().requestWeatherForecast(-1L, true, false);
        TLinkServiceManager.getServiceManager().getSports().requestSportHeadToHeadGamesForMiniView();
    }

    public void updateVisibleMainViewWidgetInAreaOne(EventGeneric eventGeneric) {
        try {
            int n = eventGeneric.getInt(0);
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.trace(2).append("Position of the visible widget in area 1 : ").append(n).log();
            }
            TLinkServiceManager.getServiceManager().getGuiControllerMain().updateVisibleMainViewWidgetInAreaOne(n);
            TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setMainViewVisibleWidgetInAreaOne(n);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateVisibleMainViewWidgetInAreaTwo(EventGeneric eventGeneric) {
        try {
            int n = eventGeneric.getInt(0);
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.trace(2).append("Position of the visible widget in area 2 : ").append(n).log();
            }
            TLinkServiceManager.getServiceManager().getGuiControllerMain().updateVisibleMainViewWidgetInAreaTwo(n);
            TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setMainViewVisibleWidgetInAreaTwo(n);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void resetVisibleMainViewWidget() {
        try {
            TLinkServiceManager.getServiceManager().getGuiControllerMain().updateVisibleMainViewWidgetInAreaOne(0);
            TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setMainViewVisibleWidgetInAreaOne(0);
            TLinkServiceManager.getServiceManager().getGuiControllerMain().updateVisibleMainViewWidgetInAreaTwo(0);
            TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setMainViewVisibleWidgetInAreaTwo(0);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateNavigationStatus(EventGeneric eventGeneric) {
        try {
            int n = eventGeneric.getInt(0);
            TLinkServiceManager.getServiceManager().getGuiControllerMain().updateNavigationStatus(n);
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.trace(2).append("Main : updateNavigationStatus : Navigation status received !").append(n).log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void printFactoryResetStatus(GenericPropertyContainer[] genericPropertyContainerArray) {
        if (genericPropertyContainerArray != null && genericPropertyContainerArray.length > 0 && genericPropertyContainerArray[0] != null) {
            int n = GenericPropertyUtility.getInt(300, 0, genericPropertyContainerArray[0]);
            switch (n) {
                case 0: {
                    ServiceManager.logger2.error(2).append("Factory reset unknown !  ").log();
                    break;
                }
                case 1: {
                    if (!ServiceManager.logger2.isTraceEnabled(2)) break;
                    ServiceManager.logger2.trace(2).append("Factory reset done !  ").log();
                    break;
                }
                case 2: {
                    ServiceManager.logger2.error(2).append("Factory reset not done !  ").log();
                    break;
                }
                default: {
                    ServiceManager.logger2.error(2).append("Factory reset status enum not in range ! Expected value range is 0 to 2. But, the received value is ").append(n).log();
                }
            }
        }
    }

    public void updateSubscribtionStatus(GenericPropertyContainer[] genericPropertyContainerArray) {
        if (genericPropertyContainerArray != null && genericPropertyContainerArray.length > 0 && genericPropertyContainerArray[0] != null) {
            int n = GenericPropertyUtility.getInt(100, 0, genericPropertyContainerArray[0]);
            ServiceManager.logger2.info(2).append("Main - updateSubscribtionStatus() - cinemaSubscribtion = ").append(n).log();
            n = this.checkSubscriptionRanges(n);
            int n2 = GenericPropertyUtility.getInt(101, 0, genericPropertyContainerArray[0]);
            ServiceManager.logger2.info(2).append("Main - updateSubscribtionStatus() - weatherTabSubscribtion = ").append(n2).log();
            n2 = this.checkSubscriptionRanges(n2);
            int n3 = GenericPropertyUtility.getInt(102, 0, genericPropertyContainerArray[0]);
            ServiceManager.logger2.info(2).append("Main - updateSubscribtionStatus() - weatherGraphicalSubscribtion = ").append(n3).log();
            n3 = this.checkSubscriptionRanges(n3);
            int n4 = GenericPropertyUtility.getInt(103, 0, genericPropertyContainerArray[0]);
            ServiceManager.logger2.info(2).append("Main - updateSubscribtionStatus() - fuelSubscribtion = ").append(n4).log();
            n4 = this.checkSubscriptionRanges(n4);
            int n5 = GenericPropertyUtility.getInt(104, 0, genericPropertyContainerArray[0]);
            ServiceManager.logger2.info(2).append("Main - updateSubscribtionStatus() - sportsSubscribtion = ").append(n5).log();
            n5 = this.checkSubscriptionRanges(n5);
            int n6 = GenericPropertyUtility.getInt(105, 0, genericPropertyContainerArray[0]);
            ServiceManager.logger2.info(2).append("Main - updateSubscribtionStatus() - trafficSubscribtion = ").append(n6).log();
            n6 = this.checkSubscriptionRanges(n6);
            TLinkServiceManager.getServiceManager().getGuiControllerFuel().setSubscriptionState(n4);
            TLinkServiceManager.getServiceManager().getGuiControllerSports().setSubscriptionState(n5);
            TLinkServiceManager.getServiceManager().getGuiControllerMovies().setSubscriptionState(n);
            TLinkServiceManager.getServiceManager().getGuiControllerWeather().setSubscriptionState(n2);
            TLinkServiceManager.getServiceManager().getGuiControllerWeatherGraphical().setSubscriptionState(n3);
            TLinkServiceManager.getServiceManager().getGuiControllerTraffic().setSubscriptionState(n6);
            int n7 = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getCinemaSubscribtion();
            int n8 = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getWeatherTabSubscribtion();
            int n9 = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getWeatherGraphicalSubscribtion();
            int n10 = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getFuelSubscribtion();
            int n11 = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getSportsSubscribtion();
            int n12 = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getTrafficSubscribtion();
            if (n != n7 || n2 != n8 || n3 != n9 || n4 != n10 || n5 != n11 || n6 != n12) {
                TLinkServiceManager.getServiceManager().getGuiControllerMain().showSubscriptionChangedPopup();
            }
            TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setFuelSubscribtion(n4);
            TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setSportsSubscribtion(n5);
            TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setCinemaSubscribtion(n);
            TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setWeatherTabSubscribtion(n2);
            TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setWeatherGraphicalSubscribtion(n3);
            TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setTrafficSubscribtion(n6);
            ASLRadioAPI aSLRadioAPI = ASLRadioFactory.getRadioApi();
            aSLRadioAPI.updateTravelLinkSubscriptions(n3, n2, n4, n, n5);
            if (1 == n && 1 == n2 && 1 == n3 && 1 == n4 && 1 == n5 && 1 == n6) {
                ServiceManager.aslPropertyManager.valueChangedInteger(-499178752, 0);
                if (ServiceManager.logger2.isTraceEnabled(2)) {
                    ServiceManager.logger2.trace(2).append("All services are unsubscribed !").log();
                }
            } else {
                ServiceManager.aslPropertyManager.valueChangedInteger(-499178752, 1);
                if (ServiceManager.logger2.isTraceEnabled(2)) {
                    ServiceManager.logger2.trace(2).append("One service or more services are subscribed").log();
                }
            }
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setInt(0, n6);
            TargetMain targetMain = TLinkServiceManager.getServiceManager().getTargetMain();
            targetMain.triggerObserver(-506376960, eventGeneric);
        }
    }

    public void updateNavigationStatus() {
        ASLNavigationServices aSLNavigationServices;
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("Main - updateNavigationStatus() - Checking for Navigation domain available status !").log();
        }
        if (null != (aSLNavigationServices = TLinkServiceManager.getServiceManager().getAslNavigationServices())) {
            boolean bl = aSLNavigationServices.isServiceAvailable();
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.trace(2).append("Main - updateNavigationStatus() - Navigation Domain availability -").append(bl).log();
            }
            if (!bl) {
                TLinkServiceManager.getServiceManager().getGuiControllerMain().showDesktopNavWait(0);
            }
        } else {
            TLinkServiceManager.getServiceManager().getGuiControllerMain().showDesktopNavWait(1);
        }
    }

    public int checkSubscriptionRanges(int n) {
        if (n >= 0 && n <= 3) {
            return n;
        }
        ServiceManager.logger2.error(2).append("checkSubscriptionRanges() - Subscription status not in range ! So, Unsuscribed is returned").log();
        return 1;
    }

    public void onUnitChange() {
        int n = TLinkServiceManager.getServiceManager().getCurrentViewId();
        switch (n) {
            case 7: {
                TLinkServiceManager.getServiceManager().getMovies().updateSelectedMovieTheater();
                break;
            }
            case 38: {
                TLinkServiceManager.getServiceManager().getMovies().updateTheaterListForOneMovie();
                break;
            }
            case 6: {
                TLinkServiceManager.getServiceManager().getMovies().updateMovieTheatersResultsList();
                break;
            }
            case 10: {
                TLinkServiceManager.getServiceManager().getFuel().updateFuelStationList();
                break;
            }
            case 2: {
                TLinkServiceManager.getServiceManager().getFuel().updateSelectedFuelStation();
                break;
            }
            case 16: {
                TLinkServiceManager.getServiceManager().getWeather().upateWeatherForecast();
                break;
            }
            case 13: {
                TLinkServiceManager.getServiceManager().getSki().upateSkiConditions();
                break;
            }
            case 0: {
                TLinkServiceManager.getServiceManager().getWeather().upateWeatherForecast();
                break;
            }
        }
    }
}

