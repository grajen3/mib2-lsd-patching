/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.system;

import de.vw.mib.asl.api.system.AbtFeatureService;
import de.vw.mib.asl.api.system.DriverDistractionPreventionService;
import de.vw.mib.asl.api.system.FactorySettingsService;
import de.vw.mib.asl.api.system.KeyListener;
import de.vw.mib.asl.api.system.SharedSystemCommonPersistence;
import de.vw.mib.asl.api.system.UnitChangeListener;
import de.vw.mib.asl.api.system.VelocityThresholdService;
import de.vw.mib.asl.api.system.clock.DateTimeService;
import de.vw.mib.asl.api.system.content.ContentIdValidator;
import de.vw.mib.asl.api.system.content.StageContentRequestProcessor;
import de.vw.mib.asl.api.system.daynight.DayNightService;
import de.vw.mib.asl.api.system.emergency.EmergencyAnnouncementService;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.api.system.input.SpaceGestureService;
import de.vw.mib.asl.api.system.input.UserInteractionLockService;
import de.vw.mib.asl.api.system.powerstate.ClampSignalService;
import de.vw.mib.asl.api.system.powerstate.PowerStateService;
import de.vw.mib.asl.api.system.proximity.ProximityService;
import de.vw.mib.asl.api.system.systemstate.SystemStateService;
import de.vw.mib.asl.api.system.valetparking.ValetParkingService;
import java.util.Calendar;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;

public interface ASLSystemAPI {
    public static final int APPLICATION_ID_MIRRORLINK;

    default public void setSWaPStatusForApplication(int n, boolean bl) {
    }

    default public int getPrimaryEngineType() {
    }

    default public int getSecondaryEngineType() {
    }

    default public void setClimateECUhasMenuHK(boolean bl) {
    }

    default public void setEngineTypes(int n, int n2) {
    }

    default public void setExternalApps(boolean bl) {
    }

    default public boolean getFeatureFlagValueCombustion() {
    }

    default public boolean getFeatureFlagValueBEV() {
    }

    default public boolean getFeatureFlagValuePHEV() {
    }

    default public boolean isTimeDateValid() {
    }

    default public ClockTime getCurrentTime() {
    }

    default public byte getCurrentTimeHour() {
    }

    default public byte getCurrentTimeMinute() {
    }

    default public byte getCurrentTimeSecond() {
    }

    default public ClockDate getCurrentDate() {
    }

    default public long getCurrentTimestamp() {
    }

    default public Calendar getCurrentCalendar(int n) {
    }

    default public String getCurrentDateTimeAsString() {
    }

    default public int getConfiguredDistanceUnit() {
    }

    default public int getTemperatureUnit() {
    }

    default public int getSpeedUnit() {
    }

    default public int getConfiguredDateFormat() {
    }

    default public int getConfiguredTimeFormat() {
    }

    default public int mapValue(int n, int n2, int n3, int n4, int n5) {
    }

    default public void createAndSubmitHardkeyEvent(int n, int n2) {
    }

    default public void switchPendingDisplayState() {
    }

    default public void languageDataStart() {
    }

    default public void languageDataAdd(String string, boolean bl) {
    }

    default public void languageDataEnd() {
    }

    default public void updateSystemCurrentLanguageConfiguration(int n, String string, String string2, String string3, String string4) {
    }

    default public void setXResolution(int n) {
    }

    default public void setYResolution(int n) {
    }

    default public void addUnitChangeListener(int n, UnitChangeListener unitChangeListener) {
    }

    default public void addKeyListener(int n, KeyListener keyListener) {
    }

    default public void removeKeyListener(int n, KeyListener keyListener) {
    }

    default public void addKeyListener(int n, int n2, KeyListener keyListener) {
    }

    default public void removeKeyListener(int n, int n2, KeyListener keyListener) {
    }

    default public SharedSystemCommonPersistence getSharedSystemCommonPersistence() {
    }

    default public FactorySettingsService getFactorySettingsService() {
    }

    default public VelocityThresholdService getVelocityThresholdService() {
    }

    default public PowerStateService getPowerStateService() {
    }

    default public ValetParkingService getValetParkingService() {
    }

    default public AbtFeatureService getAbtFeatureService() {
    }

    default public FactoryResetService getFactoryResetService() {
    }

    default public SystemStateService getSystemStateService() {
    }

    default public ProximityService getProximityService() {
    }

    default public DateTimeService getDateTimeService() {
    }

    default public DayNightService getDayNightService() {
    }

    default public SpaceGestureService getSpaceGestureService() {
    }

    default public UserInteractionLockService getUserInteractionLockService() {
    }

    default public ClampSignalService getClampSignalService() {
    }

    default public DriverDistractionPreventionService getDriverDistractionPreventionService() {
    }

    default public StageContentRequestProcessor getStageContentRequestProcessor() {
    }

    default public ContentIdValidator getContentIdValidator() {
    }

    default public EmergencyAnnouncementService getEmergencyAnnouncementService() {
    }
}

