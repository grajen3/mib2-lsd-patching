/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance;

import de.vw.mib.asl.api.navigation.NavigationDefinitions;
import de.vw.mib.asl.api.navigation.guidance.IPersistedGuidanceSetup;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IPersistenceDefaults;
import de.vw.mib.asl.api.navigation.util.PersistableMap;
import de.vw.mib.asl.api.navigation.util.ReloadPersistedDataListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;

public final class PersistedGuidanceSetup
implements ReloadPersistedDataListener,
IPersistedGuidanceSetup {
    private static final Logger NAVI_LOGGER = NavigationDefinitions.NAVI_LOGGER;
    private static final String BORDER_CHANGE_POPUP_ACTIVE;
    private static boolean isDemoMode;
    private static final String HMI_AUDIO_ANNOUNCEMENT_TYPE;
    private static final String HMI_TRAFFIC_SIGN_MODE;
    private static final String HMI_VOICE_ANNOUNCEMENTS_DURING_PHONE_SET;
    private static final String ACOUSTIC_TRAFFIC_JAM_WARNING_ENABLED;
    private static final boolean ACOUSTIC_TRAFFIC_JAM_WARNING_DEFAULT;
    private static final String HMI_GUIDANCE_TIME_FORMAT;
    private static final String LAST_GUIDANCE_MODE;
    private static final int LAST_GUIDANCE_MODE_DEFAULT;
    private static final String WAS_GUIDANCE_ACTIVE;
    private static final boolean WAS_GUIDANCE_ACTIVE_DEFAULT;
    private static final String STATUS_LINE_INFO;
    private static final String PERSISTENCE_RESTORED;
    private static final boolean PERSISTENCE_RESTORED_DEFAULT;
    private static final String PPOI_APPROACH_WARN_ACTIVE;
    private static final boolean PPOI_APPROACH_WARN_ACTIVE_DEFAULT;
    private static final String SPEED_CAMERA_WARN_ACTIVE;
    private static final boolean SPEED_CAMERA_WARN_ACTIVE_DEFAULT;
    private static final String SOUND_NAV_ANNOUNCEMENT_STATE;
    private final PersistableMap persistableMap = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getExtendedNavPersistence().getPersistableMap("rg");
    private static IPersistedGuidanceSetup instance;

    private PersistedGuidanceSetup() {
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().addReloadPersistedDataListener(this);
    }

    @Override
    public void reloadPersistedData() {
        this.updateProperties();
        int n = this.getDpVoiceAnnouncements();
        boolean bl = this.getDpVoiceAnnouncementsBoolean();
        ServiceManager.aslPropertyManager.valueChangedInteger(977, n);
        ServiceManager.aslPropertyManager.valueChangedBoolean(1510, bl);
    }

    public static IPersistedGuidanceSetup getInstance() {
        return instance;
    }

    @Override
    public void clear() {
        this.persistableMap.clear();
        this.setDemoMode(false);
    }

    @Override
    public int getDpTrafficSignMode() {
        int n = 0;
        switch (this.getHmiTrafficSignMode()) {
            case 0: {
                n = 0;
                break;
            }
            case 1: {
                n = 1;
                break;
            }
        }
        return n;
    }

    @Override
    public int getDpVoiceAnnouncements() {
        int n = 1;
        if (this.getHmiVoiceAnnouncementsDuringPhoneSet() == 0) {
            n = 0;
        } else if (this.getHmiVoiceAnnouncementsDuringPhoneSet() == 1) {
            n = 1;
        }
        return n;
    }

    @Override
    public int getDsiAcousticTrafficJamWarning() {
        int n = this.isAcousticTrafficJamWarning() ? 3 : 2;
        return n;
    }

    @Override
    public int getDsiAudioAnnouncementType() {
        int n = this.getHmiAudioAnnouncementType();
        switch (n) {
            case 0: {
                return 1;
            }
            case 1: {
                return 0;
            }
            case 2: {
                return 2;
            }
        }
        return 0;
    }

    @Override
    public int getHmiAudioAnnouncementTypeDatapoolGetter() {
        switch (this.getHmiAudioAnnouncementType()) {
            case 0: {
                return 0;
            }
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
        }
        return 0;
    }

    @Override
    public boolean isBorderHint() {
        if (NAVI_LOGGER.isTraceEnabled(16384)) {
            LogMessage logMessage = NAVI_LOGGER.trace(16384);
            logMessage.append("PersistedGuidanceSetup: isBorderHint");
            logMessage.log();
        }
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().isBorderChangeActive();
        }
        return this.persistableMap.getBoolean("Border.Change.active", true);
    }

    @Override
    public void setBorderHint(boolean bl) {
        if (NAVI_LOGGER.isTraceEnabled(16384)) {
            LogMessage logMessage = NAVI_LOGGER.trace(16384);
            logMessage.append("PersistedGuidanceSetup: setBorderHint");
            logMessage.log();
        }
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setBorderChangeActive(bl);
        } else {
            this.persistableMap.setBoolean("Border.Change.active", bl);
        }
    }

    @Override
    public boolean isDemoMode() {
        return isDemoMode;
    }

    @Override
    public void setDemoMode(boolean bl) {
        isDemoMode = bl;
    }

    @Override
    public int getHmiAudioAnnouncementType() {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().getVoiceAnouncementDetail();
        }
        return this.persistableMap.getInt("hmi.audio.announcement.type", 0);
    }

    @Override
    public void setHmiAudioAnnouncementType(int n) {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setVoiceAnouncementDetail(n);
        } else {
            this.persistableMap.setInt("hmi.audio.announcement.type", n);
        }
    }

    @Override
    public int getHmiTrafficSignMode() {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().getTrafficSignMode();
        }
        return this.persistableMap.getInt("hmi.traffic.sign.mode", 1);
    }

    @Override
    public void setHmiTrafficSignMode(int n) {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setTrafficSignMode(n);
        } else {
            this.persistableMap.setInt("hmi.traffic.sign.mode", n);
        }
    }

    @Override
    public boolean getDpVoiceAnnouncementsBoolean() {
        return this.getHmiVoiceAnnouncementsDuringPhoneSet() == 0;
    }

    @Override
    public int getHmiVoiceAnnouncementsDuringPhoneSet() {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().getVoiceAnouncementDuringPhoneCall();
        }
        return this.persistableMap.getInt("hmi.voice.announcements.during.phone.set", 1);
    }

    @Override
    public void setHmiVoiceAnnouncementsDuringPhoneSet(int n) {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setVoiceAnouncementDuringPhoneCall(n);
        } else {
            this.persistableMap.setInt("hmi.voice.announcements.during.phone.set", n);
        }
    }

    @Override
    public void setVoiceAnnouncementDuringPhone(int n) {
        if (n == 0) {
            this.setHmiVoiceAnnouncementsDuringPhoneSet(0);
        } else if (n == 1) {
            this.setHmiVoiceAnnouncementsDuringPhoneSet(1);
        } else if (NavigationDefinitions.NAVI_LOGGER.isTraceEnabled(16384)) {
            LogMessage logMessage = NavigationDefinitions.NAVI_LOGGER.error(16384);
            logMessage.append("PersistedNaviSetup#setVoiceAnnouncementDuringPhone: Invalid VouiceAnnouncementDuringPhone Enum value: ");
            logMessage.append(n);
            logMessage.log();
        }
    }

    @Override
    public void toggleAudioDuringPhone() {
        if (this.getHmiVoiceAnnouncementsDuringPhoneSet() == 0) {
            this.setHmiVoiceAnnouncementsDuringPhoneSet(1);
        } else {
            this.setHmiVoiceAnnouncementsDuringPhoneSet(0);
        }
    }

    @Override
    public boolean isAcousticTrafficJamWarning() {
        return this.persistableMap.getBoolean("acoustic.traffic.jam.warning.active", true);
    }

    @Override
    public void setAcousticTrafficJamWarning(boolean bl) {
        this.persistableMap.setBoolean("acoustic.traffic.jam.warning.active", bl);
    }

    @Override
    public int getDpGuidanceTimeFormat() {
        if (this.getHmiGuidanceTimeFormat() == 0) {
            return 0;
        }
        return 1;
    }

    @Override
    public int getHmiGuidanceTimeFormat() {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().getGuidanceTimeFormat();
        }
        return this.persistableMap.getInt("hmi.guidance.time.format", IPersistenceDefaults.HMI_GUIDANCE_TIME_FORMAT_DEFAULT);
    }

    @Override
    public void setHmiGuidanceTimeFormat(int n) {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setGuidanceTimeFormat(n);
        } else {
            this.persistableMap.setInt("hmi.guidance.time.format", n);
        }
    }

    @Override
    public int getLastGuidanceMode() {
        return this.persistableMap.getInt("last.guidance.mode", -1);
    }

    @Override
    public void setLastGuidanceMode(int n) {
        this.persistableMap.setInt("last.guidance.mode", n);
    }

    @Override
    public boolean getWasGuidanceActive() {
        return this.persistableMap.getBoolean("was.guidance.active", false);
    }

    @Override
    public void setWasGuidanceActive(boolean bl, boolean bl2) {
        if (!bl2 || ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getClamp15On()) {
            this.persistableMap.setBoolean("was.guidance.active", bl);
        }
    }

    @Override
    public boolean isStatusLineInfo() {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().isGuidanceStatusLineInfo();
        }
        return this.persistableMap.getBoolean("status.line.info", false);
    }

    @Override
    public void setStatusLineInfo(boolean bl) {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setGuidanceStatusLineInfo(bl);
        } else {
            this.persistableMap.setBoolean("status.line.info", bl);
        }
    }

    @Override
    public boolean isPersistenceRestored() {
        return ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getExtendedNavPersistence().isLoaded();
    }

    private void setPersistenceRestored(boolean bl) {
        this.persistableMap.setBoolean("persistence.restored", bl);
    }

    @Override
    public void setPersistenceRestoredPublicTemp(boolean bl) {
        this.setPersistenceRestored(bl);
    }

    @Override
    public boolean isVoiceAnnouncementDuringPhoneCall() {
        boolean bl = true;
        if (this.getHmiVoiceAnnouncementsDuringPhoneSet() == 0) {
            bl = false;
        }
        return bl;
    }

    @Override
    public int getBapAudioAnnouncentTypeDatapoolGetter() {
        switch (this.getHmiAudioAnnouncementType()) {
            case 0: {
                return 0;
            }
            case 1: {
                return 2;
            }
            case 2: {
                return 3;
            }
        }
        return 0;
    }

    @Override
    public boolean isAudibleApproachPPOIHint() {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().isAudibleApproachPPOIHintStatus();
        }
        return this.persistableMap.getBoolean("ppoi.aw.active", true);
    }

    @Override
    public void setAudibleApproachPPOIHint(boolean bl) {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setAudibleApproachPPOIHintStatus(bl);
        } else {
            this.persistableMap.setBoolean("ppoi.aw.active", bl);
        }
    }

    @Override
    public boolean isSpeedCameraWarning() {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().isSpeedCameraWarning();
        }
        return this.persistableMap.getBoolean("speed.camera.warn.active", true);
    }

    @Override
    public void setSpeedCameraWarning(boolean bl) {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setSpeedCameraWarning(bl);
        } else {
            this.persistableMap.setBoolean("speed.camera.warn.active", bl);
        }
    }

    @Override
    public boolean isSoundOn() {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            return ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().isVoiceAnouncementState();
        }
        return this.persistableMap.getBoolean("sound.Nav.Announcement.State", true);
    }

    @Override
    public void setSoundOn(boolean bl) {
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().getASLDebugFlag("NEW_NAV_PERSISTENCE")) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setVoiceAnouncementState(bl);
        } else {
            this.persistableMap.setBoolean("sound.Nav.Announcement.State", bl);
        }
    }

    @Override
    public void updateProperties() {
        this.updatePropertyDpGuidanceTimeFormat();
        this.updatePropertyIsDemoModeG();
        this.updatePropertyIsDemoMode();
        this.updatePropertyIsBorderHint();
        this.updatePropertyIsStatusLineInfo();
        this.updatePropertyIsAcousticTrafficJamWarning();
        this.updatePropertyDpTrafficSignMode();
        this.updatePropertyDpVoiceAnnouncements();
        this.updatePropertyDpVoiceAnnouncementsBoolean();
        this.updatePropertyIsAudibleApproachPPOIHint();
        this.updatePropertyIsSpeedCameraWarning();
    }

    private void updatePropertyIsSpeedCameraWarning() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(1609568256, this.isSpeedCameraWarning());
    }

    @Override
    public void updatePropertyIsAudibleApproachPPOIHint() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(965, this.isAudibleApproachPPOIHint());
    }

    @Override
    public void updatePropertyDpVoiceAnnouncementsBoolean() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(1510, this.getDpVoiceAnnouncementsBoolean());
    }

    @Override
    public void updatePropertyDpVoiceAnnouncements() {
        ServiceManager.aslPropertyManager.valueChangedInteger(977, this.getDpVoiceAnnouncements());
    }

    @Override
    public void updatePropertyDpTrafficSignMode() {
        ServiceManager.aslPropertyManager.valueChangedInteger(976, this.getDpTrafficSignMode());
    }

    @Override
    public void updatePropertyIsAcousticTrafficJamWarning() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(1013, this.isAcousticTrafficJamWarning());
    }

    @Override
    public void updatePropertyIsStatusLineInfo() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(970, this.isStatusLineInfo());
    }

    @Override
    public void updatePropertyIsBorderHint() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(966, this.isBorderHint());
    }

    @Override
    public void updatePropertyIsDemoMode() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(3937, this.isDemoMode());
    }

    @Override
    public void updatePropertyIsDemoModeG() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(978, this.isDemoMode());
    }

    @Override
    public void updatePropertyDpGuidanceTimeFormat() {
        ServiceManager.aslPropertyManager.valueChangedInteger(975, this.getDpGuidanceTimeFormat());
        ServiceManager.aslPropertyManager.valueChangedInteger(737153024, this.getDpGuidanceTimeFormat() == 0 ? 1 : 0);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\nPersistedGuidanceSetup");
        stringBuffer.append("\nPersistedGuidanceSetup - Time Format Guidance           - HMI-Value - ").append(new Integer(this.getHmiGuidanceTimeFormat()).toString());
        stringBuffer.append("\nPersistedGuidanceSetup - Demo Mode Activated            - HMI-Value - ").append(this.isDemoMode() ? "true" : "false").append("(always off at startup, feature request)");
        stringBuffer.append("\nPersistedGuidanceSetup - Border crossing hinted         - HMI-Value - ").append(this.isBorderHint() ? "true" : "false");
        stringBuffer.append("\nPersistedGuidanceSetup - Status Line Info               - HMI-Value - ").append(this.isStatusLineInfo() ? "true" : "false");
        stringBuffer.append("\nPersistedGuidanceSetup - Acoustic Traffic Jam Warning   - HMI-Value - ").append(this.isAcousticTrafficJamWarning() ? "true" : "false");
        stringBuffer.append("\nPersistedGuidanceSetup - Voice An. off during Phone     - HMI-Value - ").append(new Integer(this.getHmiVoiceAnnouncementsDuringPhoneSet()).toString());
        stringBuffer.append("\nPersistedNaviSetup - Announcement Type              - HMI-Value - ").append(new Integer(this.getHmiVoiceAnnouncementsDuringPhoneSet()).toString());
        stringBuffer.append("\nPersistedGuidanceSetup - Sound ON                       - HMI-Value - ").append(this.isSoundOn() ? "true" : "false");
        stringBuffer.append("\nPersistedGuidanceSetup - Last guidance mode             - HMI-Value - ").append(new Integer(this.getLastGuidanceMode()).toString());
        stringBuffer.append("\nPersistedGuidanceSetup - Guidance active state          - HMI-Value - ").append(this.getWasGuidanceActive() ? "true" : "false");
        stringBuffer.append("\nPersistedGuidanceSetup - PPOI AW Activated              - HMI-Value - ").append(this.isAudibleApproachPPOIHint() ? "true" : "false");
        stringBuffer.append("\nPersistedGuidanceSetup - Speed Camera Warning Activated - HMI-Value - ").append(this.isSpeedCameraWarning() ? "true" : "false");
        stringBuffer.append("\nPersistedGuidanceSetup");
        return stringBuffer.toString();
    }

    public static int setDefaultTimeFormat() {
        return ServiceManager.configManagerDiag.getNaviCommonOptionDefault(2);
    }

    public static boolean isPersistenceRestoredDefault() {
        return false;
    }

    @Override
    public boolean isPnavEnabled() {
        return ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().isPnavEnabled();
    }

    @Override
    public void setPnavEnabled(boolean bl) {
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setPnavEnabled(bl);
    }

    @Override
    public void setLastTimeStampBeforeHmiOff(long l) {
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().setLastTimeStampBeforeHmiOff(l);
    }

    @Override
    public long getLastTimeStampBeforeHmiOff() {
        return ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().getLastTimeStampBeforeHmiOff();
    }

    static {
        isDemoMode = false;
        instance = new PersistedGuidanceSetup();
    }
}

