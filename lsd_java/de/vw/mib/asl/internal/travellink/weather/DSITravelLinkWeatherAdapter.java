/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.weather;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.travellink.GenericProperty;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class DSITravelLinkWeatherAdapter {
    public void requestWeatherForecast(long l, boolean bl, boolean bl2) {
        try {
            int n = 17;
            boolean bl3 = true;
            GenericProperty[] genericPropertyArray = new GenericProperty[2];
            genericPropertyArray[0] = new GenericProperty();
            genericPropertyArray[0].valuesLong = new long[]{l};
            genericPropertyArray[0].key = 10429440;
            genericPropertyArray[1] = new GenericProperty();
            genericPropertyArray[1].valuesBoolean = new boolean[]{bl};
            genericPropertyArray[1].key = 27206656;
            int n2 = 10;
            int n3 = 20;
            int n4 = -1;
            int n5 = -1;
            if (bl) {
                TLinkServiceManager.getServiceManager().getWeather().setWeatherStationRequested(1);
            } else {
                TLinkServiceManager.getServiceManager().getWeather().setWeatherStationRequested(2);
            }
            boolean bl4 = TLinkServiceManager.getServiceManager().getDsiProxy().checkIfDsiCallIsRedundant(17, 1, genericPropertyArray, 10, n3, n4);
            if (!bl4) {
                n5 = bl ? TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(43) : TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(44);
                if (bl2 && bl) {
                    TLinkServiceManager.getServiceManager().getWeather().setSessionIdForRequestWeatherForecast(n5);
                } else {
                    TLinkServiceManager.getServiceManager().getWeather().setSessionIdForRequestWeatherForecast(-1);
                }
                TLinkServiceManager.getServiceManager().getDsiProxy().requestToApp(17, 1, genericPropertyArray, 10, n3, n4, n5);
                TLinkServiceManager.getServiceManager().getGuiControllerWeather().updateWeatherForecast(null);
                if (bl) {
                    TLinkServiceManager.getServiceManager().getGuiControllerWeather().updateWeatherLoadingState(1);
                }
            } else if (bl2) {
                long l2 = TLinkServiceManager.getServiceManager().getWeather().getNearByWeatherStationId();
                if (l2 > -1L) {
                    TLinkServiceManager.getServiceManager().getWeather().setSelectedWeatherStationId(l2);
                }
                TLinkServiceManager.getServiceManager().getWeather().setSessionIdForRequestWeatherForecast(-1);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void checkAndRequestWeatherForecast() {
        long l = TLinkServiceManager.getServiceManager().getWeather().getSelectedWeatherStationId();
        if (l > -1L) {
            this.requestWeatherForecast(l, false, false);
        } else {
            this.requestWeatherForecast(-1L, true, false);
        }
    }

    public void requestFavoriteCityList() {
        try {
            int n = 18;
            boolean bl = true;
            GenericProperty[] genericPropertyArray = new GenericProperty[]{};
            int n2 = 200;
            int n3 = -1;
            boolean bl2 = true;
            boolean bl3 = TLinkServiceManager.getServiceManager().getDsiProxy().checkIfDsiCallIsRedundant(18, 1, genericPropertyArray, 200, -1, 1);
            if (!bl3) {
                int n4 = TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(18);
                TLinkServiceManager.getServiceManager().getDsiProxy().requestToApp(18, 1, genericPropertyArray, 200, -1, 1, n4);
                TLinkServiceManager.getServiceManager().getGuiControllerWeather().updateWeatherFavoriteCityList(null);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestWeatherStationList(int n) {
        try {
            int n2 = 20;
            boolean bl = true;
            GenericProperty[] genericPropertyArray = new GenericProperty[]{new GenericProperty()};
            genericPropertyArray[0].valuesInt = new int[]{n};
            genericPropertyArray[0].key = -929094656;
            int n3 = 200;
            int n4 = -1;
            boolean bl2 = true;
            boolean bl3 = TLinkServiceManager.getServiceManager().getDsiProxy().checkIfDsiCallIsRedundant(20, 1, genericPropertyArray, 200, -1, 1);
            if (!bl3) {
                int n5 = TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(20);
                TLinkServiceManager.getServiceManager().getDsiProxy().requestToApp(20, 1, genericPropertyArray, 200, -1, 1, n5);
                TLinkServiceManager.getServiceManager().getGuiControllerWeather().updateWeatherStationList(null);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestWeatherStationList(EventGeneric eventGeneric) {
        try {
            int n = eventGeneric.getInt(0);
            Object[] objectArray = ListManager.getGenericASLList(-1891687680).getDSIObjects();
            if (null == objectArray || objectArray.length < 1) {
                return;
            }
            GenericPropertyContainer[] genericPropertyContainerArray = (GenericPropertyContainer[])objectArray;
            if (null != genericPropertyContainerArray && n > -1 && n < genericPropertyContainerArray.length && null != genericPropertyContainerArray[n]) {
                int n2 = GenericPropertyUtility.getInt(-468056576, 0, genericPropertyContainerArray[n]);
                this.requestWeatherStationList(n2);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestWeatherSelectStationList(EventGeneric eventGeneric) {
        try {
            int n = eventGeneric.getInt(0);
            Object[] objectArray = ListManager.getGenericASLList(-968940800).getDSIObjects();
            if (null == objectArray || objectArray.length < 1) {
                return;
            }
            GenericPropertyContainer[] genericPropertyContainerArray = (GenericPropertyContainer[])objectArray;
            if (null != genericPropertyContainerArray && n > -1 && n < genericPropertyContainerArray.length && null != genericPropertyContainerArray[n]) {
                int n2 = GenericPropertyUtility.getInt(-468056576, 0, genericPropertyContainerArray[n]);
                this.requestWeatherStationList(n2);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestWeatherSelectStation(EventGeneric eventGeneric) {
        try {
            int n = TLinkServiceManager.getServiceManager().getCurrentViewId();
            if (n == 9) {
                long l = eventGeneric.getInt(0);
                this.requestWeatherForecast(l, false, false);
                TLinkServiceManager.getServiceManager().getWeather().setSelectedWeatherStationId(l);
            } else {
                this.requestToSelectedWeatherStation(eventGeneric);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestStateList() {
        try {
            int n = 19;
            boolean bl = true;
            GenericProperty[] genericPropertyArray = new GenericProperty[]{};
            int n2 = 200;
            int n3 = -1;
            boolean bl2 = true;
            boolean bl3 = TLinkServiceManager.getServiceManager().getDsiProxy().checkIfDsiCallIsRedundant(19, 1, genericPropertyArray, 200, -1, 1);
            if (!bl3) {
                int n4 = TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(19);
                TLinkServiceManager.getServiceManager().getDsiProxy().requestToApp(19, 1, genericPropertyArray, 200, -1, 1, n4);
                TLinkServiceManager.getServiceManager().getGuiControllerWeather().updateStateListForWeather(null);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestToAddFavoriteWeatherStation(long l) {
        try {
            int n = 22;
            boolean bl = true;
            GenericProperty[] genericPropertyArray = new GenericProperty[]{new GenericProperty()};
            genericPropertyArray[0].valuesLong = new long[]{l};
            genericPropertyArray[0].key = -1868553216;
            boolean bl2 = true;
            int n2 = -1;
            boolean bl3 = true;
            boolean bl4 = TLinkServiceManager.getServiceManager().getDsiProxy().checkIfDsiCallIsRedundant(22, 1, genericPropertyArray, 1, -1, 1);
            if (!bl4) {
                int n3 = TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(22);
                TLinkServiceManager.getServiceManager().getDsiProxy().requestToApp(22, 1, genericPropertyArray, 1, -1, 1, n3);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestToAddFavoriteWeatherStation(EventGeneric eventGeneric) {
        try {
            int n = eventGeneric.getInt(0);
            Object[] objectArray = ListManager.getGenericASLList(-1874910464).getDSIObjects();
            if (null == objectArray || objectArray.length < 1) {
                return;
            }
            GenericPropertyContainer[] genericPropertyContainerArray = (GenericPropertyContainer[])objectArray;
            if (null != genericPropertyContainerArray && n > -1 && n < genericPropertyContainerArray.length && null != genericPropertyContainerArray[n]) {
                long l = GenericPropertyUtility.getLong(1209730560, 0, genericPropertyContainerArray[n]);
                this.requestToAddFavoriteWeatherStation(l);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestToDeleteFavoriteWeatherStation() {
        try {
            long l = TLinkServiceManager.getServiceManager().getWeather().getSelectedWeatherStationIdToDelete();
            if (-1L != l) {
                int n = 21;
                boolean bl = true;
                GenericProperty[] genericPropertyArray = new GenericProperty[]{new GenericProperty()};
                genericPropertyArray[0].valuesLong = new long[]{l};
                genericPropertyArray[0].key = -190831616;
                boolean bl2 = true;
                int n2 = -1;
                boolean bl3 = true;
                boolean bl4 = TLinkServiceManager.getServiceManager().getDsiProxy().checkIfDsiCallIsRedundant(21, 1, genericPropertyArray, 1, -1, 1);
                if (!bl4) {
                    int n3 = TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(21);
                    TLinkServiceManager.getServiceManager().getDsiProxy().requestToApp(21, 1, genericPropertyArray, 1, -1, 1, n3);
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestToSelectedWeatherStation(EventGeneric eventGeneric) {
        try {
            int n = eventGeneric.getInt(0);
            Object[] objectArray = ListManager.getGenericASLList(-952163584).getDSIObjects();
            if (null == objectArray || objectArray.length < 1) {
                return;
            }
            GenericPropertyContainer[] genericPropertyContainerArray = (GenericPropertyContainer[])objectArray;
            if (null != genericPropertyContainerArray && n > -1 && n < genericPropertyContainerArray.length && null != genericPropertyContainerArray[n]) {
                long l = GenericPropertyUtility.getLong(1209730560, 0, genericPropertyContainerArray[n]);
                this.requestWeatherForecast(l, false, false);
                TLinkServiceManager.getServiceManager().getWeather().setSelectedWeatherStationId(l);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestToSelectedWeatherStationFromFavoriteList(EventGeneric eventGeneric) {
        try {
            int n = eventGeneric.getInt(0);
            Object[] objectArray = ListManager.getGenericASLList(4109).getDSIObjects();
            if (null == objectArray || objectArray.length < 1) {
                return;
            }
            GenericPropertyContainer[] genericPropertyContainerArray = (GenericPropertyContainer[])objectArray;
            if (null != genericPropertyContainerArray && n > -1 && n < genericPropertyContainerArray.length && null != genericPropertyContainerArray[n]) {
                long l = GenericPropertyUtility.getLong(-1407515136, 0, genericPropertyContainerArray[n]);
                this.requestWeatherForecast(l, false, false);
                TLinkServiceManager.getServiceManager().getWeather().setSelectedWeatherStationId(l);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }
}

