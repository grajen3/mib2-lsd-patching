/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.systemcommon.persistence;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.systemcommon.persistence.SystemCommon;

class SystemCommonImpl
extends AbstractPersistable
implements SystemCommon {
    private final PersistenceModule module;
    private int displayBrightness;
    private boolean showClock;
    private int offclockLayout;
    private int spellerLayout;
    private long bitfieldLanguagesThatWereSetBefore;
    private boolean acousticTouchscreenFeedback;
    private boolean valetParkingActive;
    private boolean rearSeatControlLocked;
    private boolean proximityEnabled;
    private int menuMode;
    private boolean acousticSensorButtonFeedback;
    private boolean gestureActive;
    private boolean gestureInformationActive;
    private boolean gestureSoundeffectActive;
    private String lastContentId;
    private boolean onlineAvailable;
    private boolean climateECUhasMenuHK;
    private boolean displayOffClock;

    SystemCommonImpl(PersistenceModule persistenceModule) {
        super(ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger(), ASLPersistenceFactory.getPersistenceApi());
        this.module = persistenceModule;
    }

    @Override
    public int getId() {
        return 1;
    }

    @Override
    public boolean hasUserSpecificData() {
        return true;
    }

    @Override
    public void updateRootPersistable(Persistable persistable) {
        this.setRootPersistable(persistable);
    }

    @Override
    public int getDisplayBrightness() {
        return this.displayBrightness;
    }

    @Override
    public void setDisplayBrightness(int n) {
        this.displayBrightness = n;
        this.markDirty();
    }

    @Override
    public boolean isShowClock() {
        return this.showClock;
    }

    @Override
    public void setShowClock(boolean bl) {
        this.showClock = bl;
        this.markDirty();
    }

    @Override
    public int getOffclockLayout() {
        return this.offclockLayout;
    }

    @Override
    public void setOffclockLayout(int n) {
        this.offclockLayout = n;
        this.markDirty();
    }

    @Override
    public int getSpellerLayout() {
        return this.spellerLayout;
    }

    @Override
    public void setSpellerLayout(int n) {
        this.spellerLayout = n;
        this.markDirty();
    }

    @Override
    public long getBitfieldLanguagesThatWereSetBefore() {
        return this.bitfieldLanguagesThatWereSetBefore;
    }

    @Override
    public void setBitfieldLanguagesThatWereSetBefore(long l) {
        this.bitfieldLanguagesThatWereSetBefore = l;
        this.markDirty();
    }

    @Override
    public boolean isAcousticTouchscreenFeedback() {
        return this.acousticTouchscreenFeedback;
    }

    @Override
    public void setAcousticTouchscreenFeedback(boolean bl) {
        this.acousticTouchscreenFeedback = bl;
        this.markDirty();
    }

    @Override
    public boolean isValetParkingActive() {
        return this.valetParkingActive;
    }

    @Override
    public void setValetParkingActive(boolean bl) {
        this.valetParkingActive = bl;
        this.markDirty();
    }

    @Override
    public boolean isRearSeatControlLocked() {
        return this.rearSeatControlLocked;
    }

    @Override
    public void setRearSeatControlLocked(boolean bl) {
        this.rearSeatControlLocked = bl;
        this.markDirty();
    }

    @Override
    public boolean isProximityEnabled() {
        return this.proximityEnabled;
    }

    @Override
    public void setProximityEnabled(boolean bl) {
        this.proximityEnabled = bl;
        this.markDirty();
    }

    @Override
    public int getMenuMode() {
        return this.menuMode;
    }

    @Override
    public void setMenuMode(int n) {
        this.menuMode = n;
        this.markDirty();
    }

    @Override
    public boolean isAcousticSensorButtonFeedback() {
        return this.acousticSensorButtonFeedback;
    }

    @Override
    public void setAcousticSensorButtonFeedback(boolean bl) {
        this.acousticSensorButtonFeedback = bl;
        this.markDirty();
    }

    @Override
    public boolean isGestureActive() {
        return this.gestureActive;
    }

    @Override
    public void setGestureActive(boolean bl) {
        this.gestureActive = bl;
        this.markDirty();
    }

    @Override
    public boolean isGestureInformationActive() {
        return this.gestureInformationActive;
    }

    @Override
    public void setGestureInformationActive(boolean bl) {
        this.gestureInformationActive = bl;
        this.markDirty();
    }

    @Override
    public boolean isGestureSoundeffectActive() {
        return this.gestureSoundeffectActive;
    }

    @Override
    public void setGestureSoundeffectActive(boolean bl) {
        this.gestureSoundeffectActive = bl;
        this.markDirty();
    }

    @Override
    public String getLastContentId() {
        return this.lastContentId;
    }

    @Override
    public void setLastContentId(String string) {
        this.lastContentId = string;
        this.markDirty();
    }

    @Override
    public boolean isOnlineAvailable() {
        return this.onlineAvailable;
    }

    @Override
    public void setOnlineAvailable(boolean bl) {
        this.onlineAvailable = bl;
        this.markDirty();
    }

    @Override
    public boolean isClimateECUhasMenuHK() {
        return this.climateECUhasMenuHK;
    }

    @Override
    public void setClimateECUhasMenuHK(boolean bl) {
        this.climateECUhasMenuHK = bl;
        this.markDirty();
    }

    @Override
    public boolean isDisplayOffClock() {
        return this.displayOffClock;
    }

    @Override
    public void setDisplayOffClock(boolean bl) {
        this.displayOffClock = bl;
        this.markDirty();
    }

    @Override
    public void resetToDefaults() {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        handlerFactory.createCommonHandler(this).finish();
        handlerFactory.createUserHandler(this).finish();
    }
}

