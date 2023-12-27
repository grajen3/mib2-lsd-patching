/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice.services;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.CoreServiceImplFactory;
import de.vw.mib.asl.internal.online.coreInterfaces.CoreServiceFactory;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.Device;
import de.vw.mib.collections.ints.IntBooleanMap;
import de.vw.mib.collections.ints.IntBooleanOptHashMap;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.Util;

public class CoreServicePrivacyModeHandling {
    private final String _classname = super.getClass().getName();
    private boolean _privacyMode;
    private int _numDevices;
    private int _mainDeviceID;
    private Device[] _devices;
    private boolean _resetPrivacyMode;
    private boolean _privacyModeInProgress;
    private IntBooleanMap _privacyModeDevices;
    private boolean _synchronizePrivacyStatus;

    private IntBooleanMap getPrivacyModeDevices() {
        if (this._privacyModeDevices == null) {
            this._privacyModeDevices = new IntBooleanOptHashMap();
        }
        return this._privacyModeDevices;
    }

    private void synchronizeUpdatePrivacyModeStatus() {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(".synchronizeUpdatePrivacyModeStatus()").log();
        }
        object = this.getPrivacyModeDevices().keyIterator();
        int n = 1;
        boolean bl = this.getPrivacyModeDevices().get(1);
        while (object.hasNext()) {
            int n2 = object.next();
            if (n2 == 1 || this.getPrivacyModeDevices().get(n2) == this.getPrivacyModeDevices().get(1)) continue;
            this._synchronizePrivacyStatus = true;
            if (this.getPrivacyModeDevices().get(n2)) {
                bl = this.getPrivacyModeDevices().get(n2);
            } else {
                n = n2;
            }
            this.requestPrivacyMode(n, bl);
        }
        if (this.isPrivacyMode() != bl) {
            this.setPrivacyMode(bl);
            CoreServiceImplFactory.getCoreServiceNotifier().updatePrivacyModeStatus(this.isPrivacyMode());
        }
        this.getPrivacyModeDevices().clear();
    }

    public void reset() {
        this._numDevices = 0;
        this._mainDeviceID = 0;
        this._devices = null;
        this._resetPrivacyMode = false;
        this._privacyModeInProgress = false;
    }

    public void updatePrivacyModeStatus(boolean bl, int n) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".updatePrivacyModeStatus(deviceID = ").append(n).append(", active =  ").append(bl).append(")").toString()).log();
        }
        if (!this._privacyModeInProgress) {
            this.getPrivacyModeDevices().put(n, bl);
            if (this.getPrivacyModeDevices().size() > 1) {
                this.synchronizeUpdatePrivacyModeStatus();
            } else if (this.isPrivacyMode() != bl) {
                this.setPrivacyMode(bl);
                CoreServiceImplFactory.getCoreServiceNotifier().updatePrivacyModeStatus(this.isPrivacyMode());
            }
        }
    }

    public void handlePrivacyMode(boolean bl, Device[] deviceArray) {
        if (!Util.isNullOrEmpty(deviceArray)) {
            this._devices = deviceArray;
            this._numDevices = this._devices.length;
            for (int i2 = 0; i2 < this._numDevices; ++i2) {
                if (!this._devices[i2].isMainDevice()) continue;
                CoreServiceImplFactory.getStatusBarHandler().updatePrivacyModeProgress(true);
                this.requestPrivacyMode(this._devices[i2].getDeviceID(), bl);
                this.setPrivacyMode(bl);
                this.setMainDeviceID(this._devices[i2].getDeviceID());
            }
        } else {
            this.sendResponsePrivacyMode(29);
        }
    }

    public void requestPrivacyMode(int n, boolean bl) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append(this._classname).append(new StringBuffer().append(".requestPrivacyMode(deviceID = ").append(n).append(", privacyMode =  ").append(bl).append(")").toString()).log();
        }
        if ((object = CoreServiceFactory.getAdapterRegister().getAdapterWithID(n)) != null) {
            this._privacyModeInProgress = true;
            object.sendPrivacyModeStatus(bl, CoreServiceImplFactory.getAdapterListener());
        }
    }

    public void responsePrivacyMode(int n, int n2) {
        if (this._synchronizePrivacyStatus) {
            this._synchronizePrivacyStatus = false;
            this._privacyModeInProgress = false;
        } else if (n != 0) {
            if (n2 == this.getMainDeviceID()) {
                this.sendResponsePrivacyMode(n);
            } else {
                this._resetPrivacyMode = true;
                this.requestPrivacyMode(this.getMainDeviceID(), !this.isPrivacyMode());
            }
            this.setPrivacyMode(!this.isPrivacyMode());
        } else if (n2 == this.getMainDeviceID() && this._numDevices > 1 && !this._resetPrivacyMode) {
            if (!Util.isNullOrEmpty(this._devices)) {
                boolean bl = false;
                this._numDevices = this._devices.length;
                for (int i2 = 0; i2 < this._numDevices; ++i2) {
                    if (this._devices[i2].isMainDevice()) continue;
                    this.requestPrivacyMode(this._devices[i2].getDeviceID(), this._privacyMode);
                    bl = true;
                }
                if (!bl) {
                    this.sendResponsePrivacyMode(n);
                }
            } else {
                this.setPrivacyMode(!this.isPrivacyMode());
                this.sendResponsePrivacyMode(29);
            }
        } else {
            this.sendResponsePrivacyMode(n);
        }
    }

    public void sendResponsePrivacyMode(int n) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".sendResponsePrivacyMode(Result = ").append(n).append(" )").toString()).log();
        }
        CoreServiceImplFactory.getCoreServiceNotifier().sendPrivacyModeStatusResponse(n);
        CoreServiceImplFactory.getStatusBarHandler().updatePrivacyModeProgress(false);
        this.reset();
        if (n == 0) {
            if (this.isPrivacyMode()) {
                CoreServiceImplFactory.getStatusBarHandler().setStatusBarIconStatus(2);
            } else {
                CoreServiceImplFactory.getStatusBarHandler().synchronizeIconStatus(3);
            }
        }
    }

    public boolean isPrivacyMode() {
        return this._privacyMode;
    }

    public void setPrivacyMode(boolean bl) {
        if (this._privacyMode != bl) {
            this._privacyMode = bl;
            CoreServiceImplFactory.getStatusBarHandler().updatePrivacyModeStatus(this._privacyMode);
        }
    }

    public int getMainDeviceID() {
        return this._mainDeviceID;
    }

    public void setMainDeviceID(int n) {
        this._mainDeviceID = n;
    }
}

