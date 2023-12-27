/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mirrorlink.model;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.ASLListDataUpdateListener;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.mirrorlink.model.list.AppList;
import de.vw.mib.asl.internal.mirrorlink.model.list.OpenAppList;
import de.vw.mib.asl.internal.mirrorlink.model.list.SoftKeyList;
import de.vw.mib.asl.internal.mirrorlink.target.MirrorLinkTarget;
import de.vw.mib.asl.internal.mirrorlink.transformer.MirrorLinkAppListCollector;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.Util;
import org.dsi.ifc.mirrorlink.Application;

public class MirrorLinkHmiGetter {
    private final String classname;
    private final MirrorLinkTarget target;
    private boolean bProximityModeActivated = false;
    private final AppList hmiAppList;
    private final OpenAppList hmiOpenAppList;
    private final SoftKeyList softKeyList;
    private Application currentSelectedApplication = null;
    private boolean appIncompatible = false;
    private boolean deviceLocked = false;
    private boolean deviceWithSingleApp = false;
    private boolean displayOff = false;
    private boolean speedLimitPassed = false;

    public MirrorLinkHmiGetter(MirrorLinkTarget mirrorLinkTarget) {
        this.classname = "MirrorLinkHmiGetter";
        this.target = mirrorLinkTarget;
        this.hmiOpenAppList = new OpenAppList(this.getTarget());
        this.softKeyList = new SoftKeyList(this.getTarget());
        this.hmiAppList = new AppList(this.getTarget());
        this.reset();
    }

    private MirrorLinkTarget getTarget() {
        return this.target;
    }

    public void reset() {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkHmiGetter").append(".reset()").log();
        }
        this.setStartupFinished(false);
        this.setCurrentAudioSource(1);
        this.setConnectionTypeCodingActive(true);
        this.setAudioSourceOptionAvailable(true);
        this.setSpeedLimitPassed(false);
        this.setDisplayOrientationAvailable(false);
        this.setScreenRotationAvailable(false);
        this.setDeviceLocked(false);
    }

    public boolean isProximityModeActivated() {
        return this.bProximityModeActivated;
    }

    public boolean isSpeedLimitPassed() {
        return this.speedLimitPassed;
    }

    public boolean isDeviceLocked() {
        return this.deviceLocked;
    }

    public boolean isDisplayOff() {
        return this.displayOff;
    }

    public boolean isAppIncompatible() {
        return this.appIncompatible;
    }

    public MirrorLinkAppListCollector getApplicationCollector(int n) {
        return this.hmiAppList.getApplicationCollector(n);
    }

    public Application getApplication(int n) {
        int n2 = this.hmiAppList.getIndex(n);
        if (n2 > -1) {
            return this.getApplicationCollector(n2).getApplication();
        }
        return null;
    }

    public MirrorLinkAppListCollector getOpenApplicationCollector(int n) {
        return this.hmiOpenAppList.getApplicationCollector(n);
    }

    public Application[] getOpenApplications() {
        return this.hmiOpenAppList.getApplications();
    }

    public Application[] getAvailableApplications() {
        return this.hmiAppList.getAvailableApplicationList();
    }

    public int getAvailableApplicationListSize() {
        return this.hmiAppList.getAvailableAppListSize();
    }

    public boolean checkIfDeviceWithSingleAppRunning() {
        if (this.hmiAppList.getAvailableAppListSize() == 1) {
            Object[] objectArray = this.getAvailableApplications();
            Object[] objectArray2 = this.getOpenApplications();
            if (!Util.isNullOrEmpty(objectArray2) && !Util.isNullOrEmpty(objectArray)) {
                int n = objectArray2.length;
                for (int i2 = 0; i2 < n; ++i2) {
                    if (objectArray2[i2] == null || objectArray[i2] == null || ((Application)objectArray2[i2]).getAppID() != ((Application)objectArray[i2]).getAppID()) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkIfApplicationIsAlreadyRunning(Application application) {
        Application application2 = this.getCurrentSelectedApplication();
        return application2 != null && application != null && application2.getAppID() == application.getAppID();
    }

    public void updateAvailableApplicationsListSize(int n) {
        Object object;
        if (this.getTarget().isTraceEnabled()) {
            object = this.getTarget().trace();
            object.append("MirrorLinkHmiGetter").append(".updateAvailableApplicationsListSize( ").append(n).append(" )").log();
        }
        if ((object = this.hmiAppList.getList()) != null) {
            ((GenericASLList)object).setSizeClearCache(n);
            this.setNoAppExist(0 == n);
            this.setOnlyOneAppExist(1 == n);
        }
    }

    public void resetAvailableApplicationsList() {
        Object object;
        if (this.getTarget().isTraceEnabled()) {
            object = this.getTarget().trace();
            object.append("MirrorLinkHmiGetter").append(".resetAvailableApplicationsList()").log();
        }
        if ((object = this.hmiAppList.getList()) != null) {
            ((GenericASLList)object).setSizeClearCache(0);
            this.setNoAppExist(false);
            this.setOnlyOneAppExist(false);
        }
    }

    public void updateAvailableApplications(int n, Application[] applicationArray) {
        this.hmiAppList.updateAvailableApplications(n, applicationArray);
    }

    public void addASLListDataUpdateListener(ASLListDataUpdateListener aSLListDataUpdateListener) {
        this.hmiAppList.addASLListDataUpdateListener(aSLListDataUpdateListener);
    }

    public void removeASLListDataUpdateListener(ASLListDataUpdateListener aSLListDataUpdateListener) {
        this.hmiAppList.removeASLListDataUpdateListener(aSLListDataUpdateListener);
    }

    public void addOpenApp(Application application) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkHmiGetter").append(".addOpenApp( ").append(application != null ? application.toString() : "NULL").append(" )").log();
        }
        this.hmiOpenAppList.addOpenApp(application);
    }

    public void removeOpenApp(Application application) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkHmiGetter").append(".removeOpenApp( ").append(application != null ? application.toString() : "NULL").append(" )").log();
        }
        if (this.currentSelectedApplication != null && application != null && this.currentSelectedApplication.getAppID() == application.getAppID()) {
            this.setCurrentSelectedApplication(null);
        }
        this.hmiOpenAppList.removeOpenApp(application);
    }

    public void removeOpenAppsOnTimer() {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkHmiGetter").append(".removeOpenAppOnTimer()").log();
        }
        this.hmiOpenAppList.removeQueuedApps();
    }

    public void closeAllOpenApps() {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkHmiGetter").append(".closeAllOpenApps()").log();
        }
        this.setCurrentSelectedApplication(null);
        this.hmiOpenAppList.closeAllOpenApps();
    }

    public void setCurrentSelectedAppState(int n) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkHmiGetter").append(".setCurrentSelectedAppState( ").append(n).append(" )").log();
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(3707, n);
    }

    public void setCurrentAppIndex(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(3706, n);
    }

    public void setDisplayOrientationAvailable(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(3709, bl);
    }

    public void setScreenRotationAvailable(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(1365839616, bl);
    }

    public void setDisplayOff(boolean bl) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkHmiGetter").append(".setDisplayOff( ").append(bl).append(" )").log();
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(1466502912, bl);
        this.displayOff = bl;
    }

    public void setDisplayOrientation(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(3416, n);
    }

    public void setCurrentAudioSource(int n) {
        ServiceManager.aslPropertyManager.valueChangedInteger(3546, n);
    }

    public void toggleProximityModeActivated() {
        this.bProximityModeActivated = !this.bProximityModeActivated;
        ServiceManager.aslPropertyManager.valueChangedBoolean(3418, this.bProximityModeActivated);
    }

    public void setDeviceLocked(boolean bl) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkHmiGetter").append(new StringBuffer().append(".setDeviceLocked( ").append(bl).append(" )").toString()).log();
        }
        this.deviceLocked = bl;
        ServiceManager.aslPropertyManager.valueChangedBoolean(1382616832, bl);
    }

    public void setStartupFinished(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(3854, bl);
    }

    public void setSpeedLimitPassed(boolean bl) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkHmiGetter").append(new StringBuffer().append(".setSpeedLimitPassed( ").append(bl).append(" )").toString()).log();
        }
        this.speedLimitPassed = bl;
        ServiceManager.aslPropertyManager.valueChangedBoolean(1399394048, bl);
    }

    public void setOnlyOneAppExist(boolean bl) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkHmiGetter").append(new StringBuffer().append(".setOnlyOneAppExist( ").append(bl).append(" )").toString()).log();
        }
        this.deviceWithSingleApp = bl;
        ServiceManager.aslPropertyManager.valueChangedBoolean(3541, bl);
    }

    public void setMirrorLinkActive(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(3548, bl);
    }

    public void setUpsideDownActive(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(3549, bl);
    }

    public void setConnectionTypeCodingActive(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(3550, bl);
    }

    public void setNoAppExist(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(3542, bl);
    }

    public void setPhoneViewModeActive(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(3543, bl);
    }

    public void setAppPopupEnabled(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(1533611776, bl);
    }

    public void setAudioSourceOptionAvailable(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(3708, bl);
    }

    public void setAppIncompatible(boolean bl) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkHmiGetter").append(".setAppIncompatible( ").append(bl).append(" )").log();
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(1416171264, bl);
        this.appIncompatible = bl;
    }

    public void setControlbarVisibilityMode(boolean bl) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkHmiGetter").append(".setControlbarVisibilityMode( ").append(bl).append(" )").log();
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(1483280128, bl);
    }

    public void updateApplicationStatus(int n, int n2, int n3) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkHmiGetter").append(".updateApplicationStatus( ").append(new StringBuffer().append(n).append(", ").append(n2).append(", ").append(n3).toString()).append(" )").log();
        }
        this.hmiAppList.updateApplicationStatus(n, n2, n3);
        this.hmiOpenAppList.updateApplicationStatus(n, n2, n3);
        if (this.currentSelectedApplication != null && this.currentSelectedApplication.getAppID() == n) {
            int n4 = 0;
            if (this.isAppIncompatible() && n4 != 7) {
                this.setAppIncompatible(false);
            }
            switch (n2) {
                case 0: {
                    n4 = 3;
                    break;
                }
                case 7: {
                    this.setAppIncompatible(true);
                    n4 = 3;
                    break;
                }
                case 9: {
                    n4 = 4;
                    break;
                }
                case 6: {
                    n4 = 2;
                    break;
                }
                case 8: {
                    n4 = 1;
                    break;
                }
            }
            switch (n3) {
                case 0: {
                    break;
                }
                case 1: {
                    break;
                }
                case 2: {
                    break;
                }
                case 3: {
                    break;
                }
            }
            this.setCurrentSelectedAppState(n4);
        }
    }

    public int getDSITypeFromHMIType(int n) {
        return this.softKeyList.getDSITypeFromHMIType(n);
    }

    public void updateDeviceSoftKeys(int[] nArray) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append("MirrorLinkHmiGetter").append(".updateDeviceSoftKeys( ").append(!Util.isNullOrEmpty(nArray) ? nArray.length : 0).append(" )").log();
        }
        this.softKeyList.updateSoftKeys(nArray);
    }

    public Application getCurrentSelectedApplication() {
        return this.currentSelectedApplication;
    }

    public void setCurrentSelectedApplication(Application application) {
        this.currentSelectedApplication = application;
        this.setCurrentSelectedAppState(0);
    }

    public boolean checkIfDeviceIsWithSingleApp() {
        return this.deviceWithSingleApp;
    }

    public void setDeveloperMode() {
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1567166208);
    }

    public void returnToNativeUI() {
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1617497856);
    }

    public void setLocationDataServicesEnabled(boolean bl) {
    }
}

