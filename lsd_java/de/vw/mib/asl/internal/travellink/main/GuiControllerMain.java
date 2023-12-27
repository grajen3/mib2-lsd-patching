/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.main;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.GuiControllerCommon;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class GuiControllerMain
implements GuiControllerCommon {
    public void printStopUpdateStatus(GenericPropertyContainer[] genericPropertyContainerArray) {
        if (genericPropertyContainerArray != null && genericPropertyContainerArray.length > 0 && genericPropertyContainerArray[0] != null && genericPropertyContainerArray[0].values != null && genericPropertyContainerArray[0].values.length == 1 && genericPropertyContainerArray[0].values[0].valuesInt.length > 0) {
            int n = 0;
            for (int i2 = 0; i2 < genericPropertyContainerArray[0].values[0].valuesInt.length; ++i2) {
                n = GenericPropertyUtility.getInt(0, i2, genericPropertyContainerArray[0]);
                if (!ServiceManager.logger2.isTraceEnabled(2)) continue;
                ServiceManager.logger2.info(2).append(new StringBuffer().append("Updates for the request type ").append(TLinkServiceManager.getServiceManager().getTravelLinkTrace().getRequestTypeAsString(n)).append(" is stopped !").toString()).log();
            }
        } else if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.error(2).append("Feed back for Stop updates is not correct ! ").log();
        }
    }

    @Override
    public void setSubscriptionState(int n) {
    }

    public int getHMINavigationStatus(int n) {
        switch (n) {
            case 1: {
                if (ServiceManager.logger2.isTraceEnabled(2)) {
                    ServiceManager.logger2.warn(2).append("Navigation customer update is active !").log();
                }
                return 2;
            }
            case 2: {
                if (ServiceManager.logger2.isTraceEnabled(2)) {
                    ServiceManager.logger2.warn(2).append("Navigation init database not granted !").log();
                }
                return 3;
            }
            case 3: {
                if (ServiceManager.logger2.isTraceEnabled(2)) {
                    ServiceManager.logger2.warn(2).append("Navigation init database failure !").log();
                }
                return 4;
            }
            case 4: {
                return 5;
            }
            case 5: {
                return 6;
            }
            case 0: {
                return 1;
            }
        }
        ServiceManager.logger2.error(2, new StringBuffer().append("GuiControllerMain : getHMINavigationStatus : Navigation status received from application doesnot match the defined error ! Navigation status is  ").append(n).toString());
        return 1;
    }

    public void updateNavigationStatusOnServiceReady() {
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-1841356032);
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("GuiControllerMain : updateNavigationStatusOnServiceReady : Navigation event service ready ! Recovered from error state").log();
        }
    }

    public void updateNavigationStatus(int n) {
        if (0 == n || 1 == n || 2 == n || 3 == n || 4 == n || 5 == n) {
            this.showDesktopNavError(n);
        } else if (7 == n) {
            this.showDesktopNavWait(0);
        } else if (6 == n) {
            ServiceManager.logger2.error(64).append(" GuiControllerMain : updateNavigationStatus : Last Api call to navigation is not processed due to undefined error ").log();
        }
    }

    public void showDesktopNavError(int n) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(4203264, true);
        ServiceManager.aslPropertyManager.valueChangedBoolean(20980480, false);
        ServiceManager.aslPropertyManager.valueChangedInteger(37757696, this.getHMINavigationStatus(n));
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-1874910464);
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("GuiControllerMain: showDesktopNavError : Navigation init coded off !").log();
        }
    }

    public void showDesktopNavWait(int n) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(4203264, false);
        ServiceManager.aslPropertyManager.valueChangedBoolean(20980480, true);
        ServiceManager.aslPropertyManager.valueChangedInteger(54534912, n);
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-1858133248);
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("GuiControllerMain: showDesktopNavWait : Navigation desktop navigation wait view !").log();
        }
    }

    public void updateNavigationCodingInformation() {
        try {
            boolean bl = ServiceManager.configManagerDiag.isFeatureFlagSet(652);
            if (bl) {
                if (ServiceManager.logger2.isTraceEnabled(2)) {
                    ServiceManager.logger2.trace(2).append("GuiControllerMain - updateNavigationCodingInformation() - Navigation coding available!").log();
                }
                TLinkServiceManager.getServiceManager().getMain().updateNavigationStatus();
            } else {
                ServiceManager.aslPropertyManager.valueChangedBoolean(4203264, true);
                ServiceManager.aslPropertyManager.valueChangedBoolean(20980480, false);
                ServiceManager.aslPropertyManager.valueChangedInteger(37757696, 0);
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-1874910464);
                ServiceManager.logger2.error(2).append("GuiControllerMain - updateNavigationCodingInformation() - Navigation coding not available !").log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateTunerStatus(int n) {
        if (1 == n) {
            ServiceManager.aslPropertyManager.valueChangedInteger(-515955968, 1);
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.trace(2).append("GuiControllerMain - Tuner is functional!").log();
            }
        } else if (2 == n) {
            ServiceManager.aslPropertyManager.valueChangedInteger(-515955968, 2);
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.trace(2).append("GuiControllerMain - Tuner is initializing!").log();
            }
        } else if (0 == n) {
            ServiceManager.aslPropertyManager.valueChangedInteger(-515955968, 0);
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.warn(2).append("GuiControllerMain - Tuner is not functional!").log();
            }
        }
    }

    public void setButtonEnabled(int n, boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(n, bl);
    }

    public void updateMainViewWeatherWidget(GenericPropertyContainer genericPropertyContainer, GenericPropertyContainer genericPropertyContainer2) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.trace(2).append("GuiControllerMain : updateMainViewWeatherWidget() ").log();
            }
            ClockTime clockTime = ASLSystemFactory.getSystemApi().getCurrentTime();
            byte by = clockTime.getHours();
            byte by2 = clockTime.getMinutes();
            int n = TLinkServiceManager.getServiceManager().getTravelLinkUtil().addHours(by, 3);
            int n2 = TLinkServiceManager.getServiceManager().getTravelLinkUtil().addHours(by, 6);
            String string = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getWeatherFormattedTimeHour(n, by2);
            String string2 = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getWeatherFormattedTimeHour(n2, by2);
            ServiceManager.aslPropertyManager.valueChangedString(-96525568, string);
            ServiceManager.aslPropertyManager.valueChangedString(-79748352, string2);
            int n3 = GenericPropertyUtility.getInt(-2011560448, 0, genericPropertyContainer);
            String string3 = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedTemperature(n3, true);
            int n4 = GenericPropertyUtility.getInt(-2011560448, 0, genericPropertyContainer2);
            String string4 = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedTemperature(n4, true);
            ServiceManager.aslPropertyManager.valueChangedString(-62971136, string3);
            ServiceManager.aslPropertyManager.valueChangedString(-46193920, string4);
            int n5 = GenericPropertyUtility.getInt(-2095446528, 0, genericPropertyContainer);
            if (n5 >= 0 && n5 <= 59) {
                ServiceManager.aslPropertyManager.valueChangedInteger(-29416704, n5);
            } else {
                if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.error(64).append("Weather condition not in range. Expected values are from 0 to 59. But the received value is ").append(n5).log();
                }
                ServiceManager.aslPropertyManager.valueChangedInteger(-29416704, n5);
            }
            int n6 = GenericPropertyUtility.getInt(-2095446528, 0, genericPropertyContainer2);
            if (n6 >= 0 && n6 <= 59) {
                ServiceManager.aslPropertyManager.valueChangedInteger(-12639488, n6);
            } else {
                if (ServiceManager.logger2.isTraceEnabled(64)) {
                    ServiceManager.logger2.error(64).append("Weather condition not in range. Expected values are from 0 to 59. But the received value is ").append(n6).log();
                }
                ServiceManager.aslPropertyManager.valueChangedInteger(-12639488, 0);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateVisibleMainViewWidgetInAreaOne(int n) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.trace(2).append("updateVisibleMainViewWidgetInAreaOne( ").append(n).append(" )").log();
            }
            if (n >= 0 && n <= 4) {
                ServiceManager.aslPropertyManager.valueChangedInteger(-348183808, n);
            } else if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.trace(2).append(" The widget position for widget area 1 is out of range - ").append(n).log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateVisibleMainViewWidgetInAreaTwo(int n) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.trace(2).append("updateVisibleMainViewWidgetInAreaTwo( ").append(n).append(" )").log();
            }
            if (n >= 0 && n <= 4) {
                ServiceManager.aslPropertyManager.valueChangedInteger(-331406592, n);
            } else if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.trace(2).append(" The widget position for widget area 2 is out of range - ").append(n).log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void showSubscriptionChangedPopup() {
        try {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-1992350976);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateAudioSubscriptionState(int n) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.trace(2).append("TL <MAIN> ").append("GuiControllerMain - setAudioSubscriptionState(").append(n).append(")").log();
            }
            if (n == 2) {
                ServiceManager.aslPropertyManager.valueChangedInteger(-1237376256, 1);
            } else {
                ServiceManager.aslPropertyManager.valueChangedInteger(-1237376256, 0);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateRouteGuidanceState(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(-1807801600, bl);
    }
}

