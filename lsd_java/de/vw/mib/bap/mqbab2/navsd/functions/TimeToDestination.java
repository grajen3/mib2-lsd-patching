/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.navsd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.navigation.NavigationService;
import de.vw.mib.bap.mqbab2.common.api.navigation.NavigationServiceListener;
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.NavigationRemainingTravelTime;
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.NavigationTimeToDestination;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.api.system.SystemService;
import de.vw.mib.bap.mqbab2.common.api.system.SystemServiceListener;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.TimeToDestination_Status;
import de.vw.mib.bap.mqbab2.navsd.api.ASLNavSDConstants;

public final class TimeToDestination
extends Function
implements Property,
ASLNavSDConstants,
NavigationServiceListener,
SystemServiceListener {
    protected static final int[] NAVIGATION_LISTENER_IDS = new int[]{732, 737153024, 750, 753930240};
    protected static final int[] SYSTEM_LISTENER_IDS = new int[]{1643};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$TimeToDestination_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getNavigationService().addNavigationServiceListener(this, NAVIGATION_LISTENER_IDS);
        this.getSystemService().addSystemServiceListener(this, SYSTEM_LISTENER_IDS);
        return null;
    }

    protected TimeToDestination_Status dequeueBAPEntity() {
        return (TimeToDestination_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$TimeToDestination_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$TimeToDestination_Status = TimeToDestination.class$("de.vw.mib.bap.mqbab2.generated.navsd.serializer.TimeToDestination_Status")) : class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$TimeToDestination_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 22;
    }

    private static int formatTime(int n) {
        return n > 0 ? n : 0;
    }

    private void setTimeInfo(TimeToDestination_Status timeToDestination_Status) {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        NavigationService navigationService = this.getNavigationService();
        timeToDestination_Status.timeInfo.navigationTimeFormat = this.getSystemService().getSystemTimeFormat() == 0 ? 1 : 0;
        if (navigationService.getTimeToDestinationTimeInfo() == 1) {
            NavigationTimeToDestination navigationTimeToDestination = navigationService.getTimeToDestination();
            n5 = navigationTimeToDestination.getTimeToDestinationMinutes();
            n4 = navigationTimeToDestination.getTimeToDestinationHours();
            n3 = navigationTimeToDestination.getTimeToDestinationDays();
            n2 = navigationTimeToDestination.getTimeToDestinationMonths();
            n = navigationTimeToDestination.getTimeToDestinationYears();
        } else {
            NavigationRemainingTravelTime navigationRemainingTravelTime = navigationService.getRemainingTravelTime();
            n5 = navigationRemainingTravelTime.getRemainingTravelTimeMinutes();
            n4 = navigationRemainingTravelTime.getRemainingTravelTimeHours();
            n3 = 0;
            n2 = 0;
            n = 0;
        }
        if (navigationService.getRouteGuidanceState() == 1) {
            timeToDestination_Status.validityInformation.timeInfo_MinuteIsValid = n5 >= 0;
            timeToDestination_Status.validityInformation.timeInfo_HourIsValid = n4 >= 0;
            timeToDestination_Status.validityInformation.timeInfo_DayIsAvailableToBeDisplayed = n3 > 0;
            timeToDestination_Status.validityInformation.timeInfo_MonthIsAvailableToBeDisplayed = n2 > 0;
            timeToDestination_Status.validityInformation.timeInfo_YearIsAvailableToBeDisplayed = n > 0;
        } else {
            timeToDestination_Status.validityInformation.timeInfo_MinuteIsValid = false;
            timeToDestination_Status.validityInformation.timeInfo_HourIsValid = false;
            timeToDestination_Status.validityInformation.timeInfo_DayIsAvailableToBeDisplayed = false;
            timeToDestination_Status.validityInformation.timeInfo_MonthIsAvailableToBeDisplayed = false;
            timeToDestination_Status.validityInformation.timeInfo_YearIsAvailableToBeDisplayed = false;
        }
        timeToDestination_Status.timeInfo.timeInfoType = navigationService.getTimeToDestinationTimeInfo();
        timeToDestination_Status.timeInfo.minute = TimeToDestination.formatTime(n5);
        timeToDestination_Status.timeInfo.hour = TimeToDestination.formatTime(n4);
        timeToDestination_Status.timeInfo.day = TimeToDestination.formatTime(n3);
        timeToDestination_Status.timeInfo.month = TimeToDestination.formatTime(n2);
        timeToDestination_Status.timeInfo.year = TimeToDestination.formatTime(n);
    }

    private void sendtimeToDestinationStatus(TimeToDestination_Status timeToDestination_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(timeToDestination_Status, this);
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void requestAcknowledge() {
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.getNavigationService().removeNavigationServiceListener(this, NAVIGATION_LISTENER_IDS);
        this.getSystemService().removeSystemServiceListener(this, SYSTEM_LISTENER_IDS);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void process(int n) {
        this.sendtimeToDestinationStatus(this.computeTimeToDestinationStatus());
    }

    private TimeToDestination_Status computeTimeToDestinationStatus() {
        TimeToDestination_Status timeToDestination_Status = this.dequeueBAPEntity();
        this.setTimeInfo(timeToDestination_Status);
        return timeToDestination_Status;
    }

    @Override
    public void processHMIEvent(int n) {
    }

    @Override
    public void updateSystemData(SystemService systemService, int n) {
        this.process(-1);
    }

    @Override
    public void updateNavigationData(NavigationService navigationService, int n) {
        this.process(-1);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

