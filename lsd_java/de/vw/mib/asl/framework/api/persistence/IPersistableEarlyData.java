/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence;

public interface IPersistableEarlyData {
    public static final int DO_NOT_CHANGE_VALUE;

    default public void setDisplayBrightness(int n) {
    }

    default public int getDisplayBrightness() {
    }

    default public void setShowClock(boolean bl) {
    }

    default public boolean isShowClock() {
    }

    default public void setDayNightMode(int n) {
    }

    default public int getDayNightMode() {
    }

    default public boolean isLastConnRadio() {
    }

    default public void setLastConnRadio(boolean bl) {
    }

    default public int getLastActiveSkin() {
    }

    default public int getLastActiveLanguagePrefetch() {
    }

    default public void setLastActiveLanguagePrefetch(int n) {
    }

    default public boolean isAcousticTouchscreenFeedback() {
    }

    default public void setAcousticTouchscreenFeedback(boolean bl) {
    }

    default public int getUserMuteStarted() {
    }

    default public void setUserMuteStarted(int n) {
    }

    default public void setLastClamp15OffTimestamp(long l) {
    }

    default public long getLastClamp15OffTimestamp() {
    }

    default public void setLanguageWasUsedOnceBeforeBitfield(int n) {
    }

    default public int getLanguageWasUsedOnceBeforeBitfield() {
    }

    default public void setSpellerLayout(int n) {
    }

    default public int getSpellerLayout() {
    }

    default public void setProximityAnimationsActive(boolean bl) {
    }

    default public boolean getProximityAnimationsActive() {
    }

    default public String getCurrentVersion() {
    }

    default public void setDebugProbeConfiguration(int n) {
    }

    default public int getDebugProbeConfiguration() {
    }

    default public boolean isAutoDaylightSaving() {
    }

    default public void setAutoDaylightSaving(boolean bl) {
    }

    default public boolean isSDSActive() {
    }

    default public void setSDSActive(boolean bl) {
    }

    default public boolean getTestmodeAlternativeViewSetup1() {
    }

    default public void toggleTestmodeAlternativeViewSetup1() {
    }

    default public boolean getTestmodeAlternativeViewSetup2() {
    }

    default public void toggleTestmodeAlternativeViewSetup2() {
    }

    default public byte getEffectiveSkinMode() {
    }

    default public void setEffectiveSkinMode(int n) {
    }

    default public byte getLastPersistedCodedSkin() {
    }

    default public void setNavOverwriteEnableOnlineFunctions(boolean bl) {
    }

    default public boolean getNavOverwriteEnableOnlineFunctions() {
    }

    default public void setPqLscAutomaticModeActive(boolean bl) {
    }

    default public boolean getPqLscAutomaticModeActive() {
    }

    default public void setSkinValues(int n, int n2) {
    }

    default public void setHWREnabled(boolean bl) {
    }

    default public boolean getHWREnabled() {
    }

    default public void setSportHMIEnabled(boolean bl) {
    }

    default public boolean getSportHMIEnabled() {
    }
}

