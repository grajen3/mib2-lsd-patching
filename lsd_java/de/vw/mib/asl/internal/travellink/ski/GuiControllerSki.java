/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.ski;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.GuiControllerCommon;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.travellink.transformer.TravelLinkCurrentSkiResortInfoCollector;
import java.util.Arrays;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class GuiControllerSki
implements GuiControllerCommon {
    @Override
    public void setSubscriptionState(int n) {
    }

    public void updateSkiConditions(GenericPropertyContainer[] genericPropertyContainerArray) {
        if (null == genericPropertyContainerArray || genericPropertyContainerArray.length < 1) {
            this.prepareAndUpdateSkiConditions(genericPropertyContainerArray);
        } else {
            GenericPropertyContainer[] genericPropertyContainerArray2 = new GenericPropertyContainer[genericPropertyContainerArray.length];
            for (int i2 = 0; i2 < genericPropertyContainerArray.length; ++i2) {
                genericPropertyContainerArray2[i2] = GenericPropertyUtility.getCopy(genericPropertyContainerArray[i2]);
            }
            this.prepareAndUpdateSkiConditions(genericPropertyContainerArray2);
        }
    }

    public void updateStatusForSkiConditions(int n) {
        if (n == 6 || n == 1 || n == 2 || n == 5 || n == 0) {
            TLinkServiceManager.getServiceManager().getSki().setNearByAvailable(1);
            boolean bl = TLinkServiceManager.getServiceManager().getSki().getNearestSkiResortPopupShown();
            if (bl) {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1967072000);
                TLinkServiceManager.getServiceManager().getSki().setNearestSkiResortPopupShown(false);
            }
        } else if (n == 3) {
            TLinkServiceManager.getServiceManager().getSki().setNearByAvailable(2);
            boolean bl = TLinkServiceManager.getServiceManager().getSki().getNearestSkiResortPopupShown();
            if (bl) {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1983849216);
                TLinkServiceManager.getServiceManager().getSki().setNearestSkiResortPopupShown(false);
            }
        }
    }

    public void updateStatusForSkiResortClosed(int n) {
        if (n == 5) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(-247520512, true);
        } else {
            ServiceManager.aslPropertyManager.valueChangedBoolean(-247520512, false);
        }
    }

    private void prepareAndUpdateSkiConditions(GenericPropertyContainer[] genericPropertyContainerArray) {
        Object[] objectArray = new TravelLinkCurrentSkiResortInfoCollector[]{new TravelLinkCurrentSkiResortInfoCollector()};
        int n = 10;
        if (genericPropertyContainerArray != null && genericPropertyContainerArray.length > 0 && genericPropertyContainerArray[0] != null) {
            String string;
            String string2;
            objectArray[0].travellink_current_ski_resort_info__current_temp = 10 * TLinkServiceManager.getServiceManager().getTravelLinkUtil().getTemperatureFahrenheit2Celsius(GenericPropertyUtility.getInt(1141703424, 0, genericPropertyContainerArray[0]));
            int n2 = GenericPropertyUtility.getInt(1141703424, 0, genericPropertyContainerArray[0]);
            objectArray[0].travellink_current_ski_resort_info__current_temp_string = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedTemperature(n2, true);
            objectArray[0].travellink_current_ski_resort_info__max_snow_height = GenericPropertyUtility.getInt(1393361664, 0, genericPropertyContainerArray[0]);
            objectArray[0].travellink_current_ski_resort_info__min_snow_height = GenericPropertyUtility.getInt(1410138880, 0, genericPropertyContainerArray[0]);
            objectArray[0].travellink_current_ski_resort_info__max_new_snow_height = GenericPropertyUtility.getInt(1426916096, 0, genericPropertyContainerArray[0]);
            objectArray[0].travellink_current_ski_resort_info__min_new_snow_height = GenericPropertyUtility.getInt(1443693312, 0, genericPropertyContainerArray[0]);
            int n3 = GenericPropertyUtility.getInt(1292698368, 0, genericPropertyContainerArray[0]);
            objectArray[0].travellink_current_ski_resort_info__weather_condition = n3 >= 0 && n3 <= 59 ? n3 : 0;
            int n4 = GenericPropertyUtility.getInt(1225589504, 0, genericPropertyContainerArray[0]);
            objectArray[0].travellink_current_ski_resort_info__grooming = n4 == 1 ? 2 : (n4 == 2 ? 1 : 0);
            objectArray[0].travellink_current_ski_resort_info__max_temp = GenericPropertyUtility.getInt(1108148992, 0, genericPropertyContainerArray[0]);
            ((TravelLinkCurrentSkiResortInfoCollector)objectArray[0]).travellink_current_ski_resort_info__min_temp = GenericPropertyUtility.getInt(1124926208, 0, genericPropertyContainerArray[0]);
            ((TravelLinkCurrentSkiResortInfoCollector)objectArray[0]).travellink_current_ski_resort_info__name = string2 = GenericPropertyUtility.getString(1343030016, 0, genericPropertyContainerArray[0]);
            ((TravelLinkCurrentSkiResortInfoCollector)objectArray[0]).travellink_current_ski_resort_info__state_abbreviation = string = GenericPropertyUtility.getString(1460470528, 0, genericPropertyContainerArray[0]);
            int n5 = GenericPropertyUtility.getInt(1259143936, 0, genericPropertyContainerArray[0]);
            ((TravelLinkCurrentSkiResortInfoCollector)objectArray[0]).travellink_current_ski_resort_info__night_skiing = n5 == 1 ? 2 : (n5 == 2 ? 1 : 0);
            ((TravelLinkCurrentSkiResortInfoCollector)objectArray[0]).travellink_current_ski_resort_info__max_open_trails = GenericPropertyUtility.getInt(1192035072, 0, genericPropertyContainerArray[0]);
            ((TravelLinkCurrentSkiResortInfoCollector)objectArray[0]).travellink_current_ski_resort_info__min_open_trails = GenericPropertyUtility.getInt(1175257856, 0, genericPropertyContainerArray[0]);
            ((TravelLinkCurrentSkiResortInfoCollector)objectArray[0]).travellink_current_ski_resort_info__open_lifts = GenericPropertyUtility.getInt(1158480640, 0, genericPropertyContainerArray[0]);
            boolean bl = GenericPropertyUtility.getBoolean(1275921152, 0, genericPropertyContainerArray[0]);
            ((TravelLinkCurrentSkiResortInfoCollector)objectArray[0]).travellink_current_ski_resort_info__resort_closed = !bl;
            int n6 = GenericPropertyUtility.getInt(1242366720, 0, genericPropertyContainerArray[0]);
            ((TravelLinkCurrentSkiResortInfoCollector)objectArray[0]).travellink_current_ski_resort_info__snowboarding = n6 == 1 ? 2 : (n6 == 2 ? 1 : 0);
            int n7 = GenericPropertyUtility.getInt(1091371776, 0, genericPropertyContainerArray[0]);
            ((TravelLinkCurrentSkiResortInfoCollector)objectArray[0]).travellink_current_ski_resort_info__snow_condition = n7 >= 0 && n7 <= 8 ? n7 : 8;
            int n8 = GenericPropertyUtility.getInt(1208812288, 0, genericPropertyContainerArray[0]);
            ((TravelLinkCurrentSkiResortInfoCollector)objectArray[0]).travellink_current_ski_resort_info__snow_making = n8 == 1 ? 2 : (n8 == 2 ? 1 : 0);
            int n9 = GenericPropertyUtility.getInt(1074594560, 0, genericPropertyContainerArray[0]);
            ((TravelLinkCurrentSkiResortInfoCollector)objectArray[0]).travellink_current_ski_resort_info__wind_condition = n9 >= 0 && n9 <= 7 ? n9 : 7;
            String string3 = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedNamingRuleF(string2, string);
            ServiceManager.aslPropertyManager.valueChangedString(155198208, string3);
            ListManager.getGenericASLList(-2093014272).updateList(objectArray);
        } else {
            ServiceManager.aslPropertyManager.valueChangedString(155198208, "--");
            objectArray[0].travellink_current_ski_resort_info__current_temp = 0;
            objectArray[0].travellink_current_ski_resort_info__current_temp_string = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedTemperature(-9999, false);
            objectArray[0].travellink_current_ski_resort_info__max_new_snow_height = 0;
            objectArray[0].travellink_current_ski_resort_info__min_new_snow_height = 0;
            objectArray[0].travellink_current_ski_resort_info__max_snow_height = 0;
            objectArray[0].travellink_current_ski_resort_info__min_snow_height = 0;
            objectArray[0].travellink_current_ski_resort_info__weather_condition = 0;
            objectArray[0].travellink_current_ski_resort_info__grooming = 0;
            objectArray[0].travellink_current_ski_resort_info__max_temp = 0;
            objectArray[0].travellink_current_ski_resort_info__min_temp = 0;
            objectArray[0].travellink_current_ski_resort_info__name = "--";
            objectArray[0].travellink_current_ski_resort_info__night_skiing = 0;
            objectArray[0].travellink_current_ski_resort_info__max_open_trails = 0;
            objectArray[0].travellink_current_ski_resort_info__min_open_trails = 0;
            objectArray[0].travellink_current_ski_resort_info__open_lifts = 0;
            objectArray[0].travellink_current_ski_resort_info__resort_closed = false;
            objectArray[0].travellink_current_ski_resort_info__snowboarding = 0;
            objectArray[0].travellink_current_ski_resort_info__snow_condition = 8;
            objectArray[0].travellink_current_ski_resort_info__snow_making = 0;
            objectArray[0].travellink_current_ski_resort_info__state_abbreviation = "--";
            objectArray[0].travellink_current_ski_resort_info__wind_condition = 7;
            ListManager.getGenericASLList(-2093014272).updateList(objectArray);
        }
    }

    public void updateFavoriteSkiResorts(GenericPropertyContainer[] genericPropertyContainerArray) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(16)) {
                ServiceManager.logger2.trace(16).append("TL <SKI> ").append("GuiControllerSki : updateFavoriteSkiResorts()").log();
            }
            if (genericPropertyContainerArray == null || genericPropertyContainerArray.length < 1) {
                if (ServiceManager.logger2.isTraceEnabled(16)) {
                    ServiceManager.logger2.trace(16).append("TL <SKI> ").append("GuiControllerSki : updateFavoriteSkiResorts() - new GenericPropertyContainer[0]").log();
                }
                ListManager.getGenericASLList(4110).updateList(new GenericPropertyContainer[0]);
            } else {
                this.prepareAndUpdateFavoriteSkiResorts(genericPropertyContainerArray);
                int n = genericPropertyContainerArray.length;
                if (n >= 20) {
                    ServiceManager.aslPropertyManager.valueChangedBoolean(-918609152, false);
                } else {
                    ServiceManager.aslPropertyManager.valueChangedBoolean(-918609152, true);
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateStateListForSki(GenericPropertyContainer[] genericPropertyContainerArray) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(16)) {
                ServiceManager.logger2.trace(16).append("TL <SKI> ").append("GuiControllerSki : updateStateListForSki()").log();
            }
            if (null == genericPropertyContainerArray || genericPropertyContainerArray.length < 1) {
                ListManager.getGenericASLList(-985718016).updateList(new GenericPropertyContainer[0]);
            } else {
                Object[] objectArray = new GenericPropertyContainer[genericPropertyContainerArray.length];
                for (int i2 = 0; i2 < genericPropertyContainerArray.length; ++i2) {
                    objectArray[i2] = GenericPropertyUtility.getCopy(genericPropertyContainerArray[i2]);
                }
                Arrays.sort(objectArray, TLinkServiceManager.getServiceManager().getComparatorString(-1525873920));
                ListManager.getGenericASLList(-985718016).updateList(objectArray);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateStateListForSetupSki(GenericPropertyContainer[] genericPropertyContainerArray) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(16)) {
                ServiceManager.logger2.trace(16).append("TL <SKI> ").append("GuiControllerSki : updateStateListForSetupSki()").log();
            }
            if (null == genericPropertyContainerArray || genericPropertyContainerArray.length < 1) {
                ListManager.getGenericASLList(-1891687680).updateList(new GenericPropertyContainer[0]);
            } else {
                Object[] objectArray = new GenericPropertyContainer[genericPropertyContainerArray.length];
                for (int i2 = 0; i2 < genericPropertyContainerArray.length; ++i2) {
                    objectArray[i2] = GenericPropertyUtility.getCopy(genericPropertyContainerArray[i2]);
                }
                Arrays.sort(objectArray, TLinkServiceManager.getServiceManager().getComparatorString(-1525873920));
                ListManager.getGenericASLList(-1891687680).updateList(objectArray);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateResortListForSki(GenericPropertyContainer[] genericPropertyContainerArray) {
        try {
            int n;
            if (ServiceManager.logger2.isTraceEnabled(16)) {
                ServiceManager.logger2.trace(16).append("TL <SKI> ").append("GuiControllerSki : updateResortListForSki()").log();
            }
            if ((n = TLinkServiceManager.getServiceManager().getCurrentViewId()) == 43) {
                if (null == genericPropertyContainerArray || genericPropertyContainerArray.length < 1) {
                    ListManager.getGenericASLList(-1002495232).updateList(new GenericPropertyContainer[0]);
                } else {
                    this.prepareAndUpdateResortListForSki(genericPropertyContainerArray);
                }
            } else if (n == 25) {
                if (null == genericPropertyContainerArray || genericPropertyContainerArray.length < 1) {
                    ListManager.getGenericASLList(-1874910464).updateList(new GenericPropertyContainer[0]);
                } else {
                    this.prepareAndUpdateResortListForSetupSki(genericPropertyContainerArray);
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateAddFavoriteSkiResortStatus(GenericPropertyContainer[] genericPropertyContainerArray, int n) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(16)) {
                ServiceManager.logger2.trace(16).append("TL <SKI> ").append("GuiControllerSki : updateAddFavoriteSkiResortStatus()").log();
            }
            if (n == 14) {
                this.updateAddFavoriteSkiResortStatus(n);
                if (ServiceManager.logger2.isTraceEnabled(16)) {
                    ServiceManager.logger2.trace(16).append("TL <SKI> ").append("GuiController : updateAddFavoriteSkiResortStatus : Seleceted resort is successfully added in to favorite ").log();
                }
            } else if (n == 15) {
                this.updateAddFavoriteSkiResortStatus(n);
                if (ServiceManager.logger2.isTraceEnabled(16)) {
                    ServiceManager.logger2.trace(16).append("TL <SKI> ").append("GuiController : updateAddFavoriteSkiResortStatus : Seleceted resort is already exists in favorite ").log();
                }
            }
            if (n == 13) {
                this.updateAddFavoriteSkiResortStatus(n);
                if (ServiceManager.logger2.isTraceEnabled(16)) {
                    ServiceManager.logger2.error(16).append("TL <SKI> ").append("GuiControllerSki : updateAddFavoriteSkiResortStatus : Adding favorite resort  is unsuccessful ").log();
                }
            } else if (ServiceManager.logger2.isTraceEnabled(16)) {
                ServiceManager.logger2.error(16).append("TL <SKI> ").append("GuiControllerSki : updateAddFavoriteSkiResortStatus : Adding favorite resort  is unknown ").log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateAddFavoriteSkiResortStatus(int n) {
        try {
            if (n == 15) {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-2109791488);
            } else if (n == 14) {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-2076237056);
            } else if (n == 13) {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-2093014272);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateDeleteFavoriteSkiResortStatus(GenericPropertyContainer[] genericPropertyContainerArray, int n) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(16)) {
                ServiceManager.logger2.trace(16).append("TL <SKI> ").append("GuiControllerSki : updateDeleteFavoriteSkiResortStatus()").log();
            }
            if (n == 11) {
                if (ServiceManager.logger2.isTraceEnabled(16)) {
                    ServiceManager.logger2.info(16).append("TL <SKI> ").append("GuiControllerSki : updateDeleteFavoriteSkiResortStatus : Seleceted resort is successfully deleted from the favorite  ").log();
                }
            } else if (n == 10) {
                if (ServiceManager.logger2.isTraceEnabled(16)) {
                    ServiceManager.logger2.error(16).append("TL <SKI> ").append("GuiControllerSki : updateDeleteFavoriteSkiResortStatus : Seleceted resort is not deleted from the favorite ").log();
                }
            } else if (n == 9) {
                if (ServiceManager.logger2.isTraceEnabled(16)) {
                    ServiceManager.logger2.error(16).append("TL <SKI> ").append("GuiControllerSki : updateDeleteFavoriteSkiResortStatus :  Seleceted resort does not exists in the favorite ").log();
                }
            } else if (ServiceManager.logger2.isTraceEnabled(16)) {
                ServiceManager.logger2.error(16).append("TL <SKI> ").append("GuiControllerSki : updateDeleteFavoriteSkiResortStatus : Deleting favorite resort  is unknown ").log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    private void prepareAndUpdateFavoriteSkiResorts(GenericPropertyContainer[] genericPropertyContainerArray) {
        Object[] objectArray = new GenericPropertyContainer[genericPropertyContainerArray.length];
        for (int i2 = 0; i2 < genericPropertyContainerArray.length; ++i2) {
            objectArray[i2] = GenericPropertyUtility.getCopy(genericPropertyContainerArray[i2]);
        }
        Arrays.sort(objectArray, TLinkServiceManager.getServiceManager().getComparatorString(1829634816));
        ListManager.getGenericASLList(4110).updateList(objectArray);
    }

    private void prepareAndUpdateResortListForSki(GenericPropertyContainer[] genericPropertyContainerArray) {
        Object[] objectArray = new GenericPropertyContainer[genericPropertyContainerArray.length];
        for (int i2 = 0; i2 < genericPropertyContainerArray.length; ++i2) {
            objectArray[i2] = GenericPropertyUtility.getCopy(genericPropertyContainerArray[i2]);
        }
        Arrays.sort(objectArray, TLinkServiceManager.getServiceManager().getComparatorString(151913216));
        ListManager.getGenericASLList(-1002495232).updateList(objectArray);
    }

    private void prepareAndUpdateResortListForSetupSki(GenericPropertyContainer[] genericPropertyContainerArray) {
        Object[] objectArray = new GenericPropertyContainer[genericPropertyContainerArray.length];
        for (int i2 = 0; i2 < genericPropertyContainerArray.length; ++i2) {
            objectArray[i2] = GenericPropertyUtility.getCopy(genericPropertyContainerArray[i2]);
        }
        Arrays.sort(objectArray, TLinkServiceManager.getServiceManager().getComparatorString(151913216));
        ListManager.getGenericASLList(-1874910464).updateList(objectArray);
    }

    public void setSelectedFavoriteSkiResortNameToDelete(String string) {
        if (null == string) {
            string = "";
        }
        if (ServiceManager.logger2.isTraceEnabled(8)) {
            ServiceManager.logger2.trace(8).append("TL <SKI> ").append("GuiControllerSki - setSelectedFavoriteSkiResortNameToDelete(").append(string).append(")").log();
        }
        ServiceManager.aslPropertyManager.valueChangedString(-364961024, string);
    }
}

