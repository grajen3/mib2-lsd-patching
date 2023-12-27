/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.vw.mib.asl.framework.internal.impl.displaymanagement.screenshot;

import de.vw.mib.asl.api.infotainmentrecorder.ASLInfotainmentrecorderAPI;
import de.vw.mib.asl.api.navigation.ASLNavigationAPI;
import de.vw.mib.asl.api.navigation.INavigationPosPosition;
import de.vw.mib.asl.api.system.ASLSystemAPI;
import de.vw.mib.asl.framework.internal.displaymanagement.DisplayManagementPersistence;
import de.vw.mib.asl.framework.internal.displaymanagement.DisplayManagementServices;
import de.vw.mib.asl.framework.internal.displaymanagement.ScreenshotService;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;
import de.vw.mib.timer.TimerManager;
import org.dsi.ifc.displaymanagement.DSIDisplayManagement;

public abstract class AbstractScreenshotService
implements ScreenshotService {
    public static final int COUNTER_MIN;
    private static final int COUNTER_MAX;
    private static final String FILENAME;
    private static final String TIMESTAMP_STRING;
    private static final String GEO_STRING;
    private static final String GEO_LONG_STRING;
    private static final String FILENAME_EXTENSION;
    private final ConfigurationManagerDiag configurationManager;
    private final GenericEvents genericEvents;
    private final ASLInfotainmentrecorderAPI infotainmentRecorder;
    private final ASLNavigationAPI navigation;
    private final ASLSystemAPI system;
    private final DisplayManagementPersistence persistableData;
    private final TimerManager timerManager;
    private final boolean isGpsAvailable;
    private DSIDisplayManagement dsiDisplayManagement;
    private String[] externalScreenshotPaths;
    static /* synthetic */ Class class$org$dsi$ifc$displaymanagement$DSIDisplayManagement;

    public AbstractScreenshotService(DisplayManagementServices displayManagementServices, DisplayManagementPersistence displayManagementPersistence) {
        this.configurationManager = displayManagementServices.getConfigurationManager();
        this.genericEvents = displayManagementServices.getGenericEvents();
        this.infotainmentRecorder = displayManagementServices.getAslInfotainmentrecorderApi();
        this.navigation = displayManagementServices.getAslNavigationApi();
        this.system = displayManagementServices.getAslSystemApi();
        this.timerManager = displayManagementServices.getTimerManager();
        this.persistableData = displayManagementPersistence;
        this.isGpsAvailable = this.configurationManager.getGpsAvailable();
        this.connectToDsi(displayManagementServices);
    }

    @Override
    public void takeScreenshot() {
        this.takeScreenshot(this.createFileName());
    }

    @Override
    public void takeScreenshot(String string) {
        boolean bl = this.configurationManager.isFeatureFlagSet(400);
        if (bl) {
            this.doTakeScreenshot(string);
            this.createBeep();
        }
    }

    @Override
    public void setExternalScreenshotPaths(String[] stringArray) {
        this.externalScreenshotPaths = stringArray;
    }

    public String[] getExternalScreenshotPaths() {
        return this.externalScreenshotPaths;
    }

    protected abstract void doTakeScreenshot(String string) {
    }

    protected String createFileName() {
        String string = this.system.getCurrentDateTimeAsString();
        StringBuffer stringBuffer = new StringBuffer(256);
        this.appendBasicInfo(string, stringBuffer);
        this.appendGpsInfo(stringBuffer);
        this.appendSystemTimeInfo(stringBuffer);
        this.ensureValidFileNameLength(stringBuffer);
        this.appendScreenshotCounter(stringBuffer);
        this.appendFileExtension(stringBuffer);
        this.increaseScreenshotCounter();
        return stringBuffer.toString();
    }

    protected DSIDisplayManagement getDsiDisplayManagement() {
        return this.dsiDisplayManagement;
    }

    private void ensureValidFileNameLength(StringBuffer stringBuffer) {
        int n = 250;
        if (stringBuffer.length() > n) {
            stringBuffer.setLength(n);
        }
    }

    private void appendFileExtension(StringBuffer stringBuffer) {
        stringBuffer.append(".png");
    }

    private void appendScreenshotCounter(StringBuffer stringBuffer) {
        stringBuffer.append("_Nr_");
        int n = this.persistableData.getScreenshotCounter();
        stringBuffer.append(n);
    }

    private void appendSystemTimeInfo(StringBuffer stringBuffer) {
        stringBuffer.append("_");
        stringBuffer.append(this.timerManager.getSystemTimeMillis());
    }

    private void appendGpsInfo(StringBuffer stringBuffer) {
        if (this.isGpsAvailable && this.navigation.isGatwayInstance()) {
            String string;
            String string2;
            INavigationPosPosition iNavigationPosPosition = this.navigation.getPositionInfo();
            if (iNavigationPosPosition != null) {
                string2 = new Double(iNavigationPosPosition.getLatitude()).toString();
                string = new Double(iNavigationPosPosition.getLongitude()).toString();
                int n = 6;
                if (string2.length() > 6) {
                    string2 = string2.substring(0, 6);
                }
                if (string.length() > 6) {
                    string = string.substring(0, 6);
                }
            } else {
                string2 = "null";
                string = "null";
            }
            stringBuffer.append("_GEOCOORD_LAT_").append(string2).append("_LONG_").append(string);
        }
    }

    private void appendBasicInfo(String string, StringBuffer stringBuffer) {
        String string2 = this.retrieveCurrentViewName();
        if (string2 == null) {
            string2 = "";
        }
        stringBuffer.append("SCREENSHOT_").append(string2).append("_").append("TIME_").append(string);
    }

    private void increaseScreenshotCounter() {
        int n = this.persistableData.getScreenshotCounter();
        n = n >= 999 ? 1 : ++n;
        this.persistableData.setScreenshotCounter(n);
    }

    private void createBeep() {
        EventGeneric eventGeneric = this.genericEvents.getEventFactory().newEvent(638139648);
        eventGeneric.setInt(0, 1);
        this.genericEvents.getEventDispatcher().sendSafe(eventGeneric);
    }

    private String retrieveCurrentViewName() {
        return this.infotainmentRecorder.getCurrentViewName();
    }

    private void connectToDsi(DisplayManagementServices displayManagementServices) {
        Target target = null;
        this.dsiDisplayManagement = (DSIDisplayManagement)displayManagementServices.getDsiProxy().getService(target, class$org$dsi$ifc$displaymanagement$DSIDisplayManagement == null ? (class$org$dsi$ifc$displaymanagement$DSIDisplayManagement = AbstractScreenshotService.class$("org.dsi.ifc.displaymanagement.DSIDisplayManagement")) : class$org$dsi$ifc$displaymanagement$DSIDisplayManagement);
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

