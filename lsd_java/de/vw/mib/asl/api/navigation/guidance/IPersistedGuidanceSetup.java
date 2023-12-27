/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.guidance;

public interface IPersistedGuidanceSetup {
    public static final boolean STORE_ALWAYS;
    public static final boolean STORE_ONLY_IF_CLAMP15_ON;
    public static final int LAST_GUIDANCE_MODE_NONE;

    default public void reloadPersistedData() {
    }

    default public void clear() {
    }

    default public int getDpTrafficSignMode() {
    }

    default public int getDpVoiceAnnouncements() {
    }

    default public int getDsiAcousticTrafficJamWarning() {
    }

    default public int getDsiAudioAnnouncementType() {
    }

    default public int getHmiAudioAnnouncementTypeDatapoolGetter() {
    }

    default public boolean isBorderHint() {
    }

    default public void setBorderHint(boolean bl) {
    }

    default public boolean isDemoMode() {
    }

    default public void setDemoMode(boolean bl) {
    }

    default public int getHmiAudioAnnouncementType() {
    }

    default public void setHmiAudioAnnouncementType(int n) {
    }

    default public int getHmiTrafficSignMode() {
    }

    default public void setHmiTrafficSignMode(int n) {
    }

    default public boolean getDpVoiceAnnouncementsBoolean() {
    }

    default public int getHmiVoiceAnnouncementsDuringPhoneSet() {
    }

    default public void setHmiVoiceAnnouncementsDuringPhoneSet(int n) {
    }

    default public void setVoiceAnnouncementDuringPhone(int n) {
    }

    default public void toggleAudioDuringPhone() {
    }

    default public boolean isAcousticTrafficJamWarning() {
    }

    default public void setAcousticTrafficJamWarning(boolean bl) {
    }

    default public int getDpGuidanceTimeFormat() {
    }

    default public int getHmiGuidanceTimeFormat() {
    }

    default public void setHmiGuidanceTimeFormat(int n) {
    }

    default public int getLastGuidanceMode() {
    }

    default public void setLastGuidanceMode(int n) {
    }

    default public boolean getWasGuidanceActive() {
    }

    default public void setWasGuidanceActive(boolean bl, boolean bl2) {
    }

    default public boolean isStatusLineInfo() {
    }

    default public void setStatusLineInfo(boolean bl) {
    }

    default public boolean isPersistenceRestored() {
    }

    default public void setPersistenceRestoredPublicTemp(boolean bl) {
    }

    default public boolean isVoiceAnnouncementDuringPhoneCall() {
    }

    default public int getBapAudioAnnouncentTypeDatapoolGetter() {
    }

    default public boolean isAudibleApproachPPOIHint() {
    }

    default public void setAudibleApproachPPOIHint(boolean bl) {
    }

    default public boolean isSpeedCameraWarning() {
    }

    default public void setSpeedCameraWarning(boolean bl) {
    }

    default public boolean isSoundOn() {
    }

    default public void setSoundOn(boolean bl) {
    }

    default public boolean isPnavEnabled() {
    }

    default public void setPnavEnabled(boolean bl) {
    }

    default public void updateProperties() {
    }

    default public void updatePropertyIsAudibleApproachPPOIHint() {
    }

    default public void updatePropertyDpVoiceAnnouncementsBoolean() {
    }

    default public void updatePropertyDpVoiceAnnouncements() {
    }

    default public void updatePropertyDpTrafficSignMode() {
    }

    default public void updatePropertyIsAcousticTrafficJamWarning() {
    }

    default public void updatePropertyIsStatusLineInfo() {
    }

    default public void updatePropertyIsBorderHint() {
    }

    default public void updatePropertyIsDemoMode() {
    }

    default public void updatePropertyIsDemoModeG() {
    }

    default public void updatePropertyDpGuidanceTimeFormat() {
    }

    default public long getLastTimeStampBeforeHmiOff() {
    }

    default public void setLastTimeStampBeforeHmiOff(long l) {
    }
}

