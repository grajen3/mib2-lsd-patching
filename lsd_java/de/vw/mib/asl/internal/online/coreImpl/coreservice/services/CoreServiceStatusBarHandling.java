/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice.services;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.coreImpl.corecommon.CoreServiceMappingTable;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.CoreServiceImplFactory;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineService;
import de.vw.mib.collections.ints.IntBooleanMultimap;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.Util;

public class CoreServiceStatusBarHandling {
    private final String _classname = super.getClass().getName();
    private int _statusbarIconStatus = -1;
    private IntIntOptHashMap _statusBarStatus;
    private IntBooleanMultimap _deviceElementStatus;
    private IntIntOptHashMap _cumulativeStatus;
    private boolean _privacyMode;
    private boolean _trackingActive;
    private boolean _privacyModeProgress;

    private IntIntOptHashMap getStatusBarStatus() {
        if (this._statusBarStatus == null) {
            this._statusBarStatus = new IntIntOptHashMap();
        }
        return this._statusBarStatus;
    }

    private IntIntOptHashMap getCumulativeStatus() {
        if (this._cumulativeStatus == null) {
            this._cumulativeStatus = new IntIntOptHashMap();
        }
        return this._cumulativeStatus;
    }

    private IntBooleanMultimap getDeviceElementStatus() {
        if (this._deviceElementStatus == null) {
            this._deviceElementStatus = new IntBooleanMultimap();
        }
        return this._deviceElementStatus;
    }

    private void handleStatusBarIcon() {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".handleStatusBarIcon()").log();
        }
        if (!this.getDeviceElementStatus().isEmpty()) {
            int n = 0;
            this.getCumulativeStatus().clear();
            IntIterator intIterator = this.getDeviceElementStatus().keyIterator();
            while (intIterator.hasNext()) {
                int n2 = intIterator.next();
                n = this.getDeviceElementStatus().getAll(n2).size() > 1 ? 2 : (this.getDeviceElementStatus().get(n2) ? n : 1);
                this.getCumulativeStatus().put(n2, n);
            }
            IntIterator intIterator2 = this.getStatusBarStatus().keyIterator();
            int n3 = -1;
            while (intIterator2.hasNext()) {
                int n4 = intIterator2.next();
                if (n3 == 5 || n3 == 1) {
                    n3 = this._trackingActive ? 5 : 1;
                    continue;
                }
                if (this.getStatusBarStatus().get(n4) == 3) {
                    if (this.getCumulativeStatus().get(n4) > 0) {
                        n3 = this._trackingActive ? 4 : 3;
                        continue;
                    }
                    n3 = this._trackingActive ? 4 : 0;
                    continue;
                }
                n3 = this._trackingActive ? 5 : 1;
            }
            this.setStatusBarIconStatus(n3);
        }
    }

    private int getStatusLineIconwithState(int n) {
        switch (n) {
            case 3: {
                return this._trackingActive ? 4 : 0;
            }
        }
        return this._trackingActive ? 5 : 1;
    }

    public void setStatusBarIconStatus(int n) {
        if (this._statusbarIconStatus != n) {
            this._statusbarIconStatus = n;
            CoreServiceImplFactory.getServiceStatus().updateOnlineStatus(this._statusbarIconStatus);
            LogMessage logMessage = ServiceManager.logger2.info(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".setStatusBarIconStatus()-->").append(this._statusbarIconStatus).toString()).log();
        }
    }

    public void updateStatusBarState(int n, int n2) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".updateStatusBarState(state = ").append(n).append(", deviceID = ").append(n2).append(" )").toString()).log();
        }
        this.getStatusBarStatus().put(n2, n);
        this.synchronizeIconStatus(n);
    }

    public void updateClientServicelist(OnlineService[] onlineServiceArray) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".updateClientServicelist(Client = ").append(!Util.isNullOrEmpty(onlineServiceArray) ? onlineServiceArray.length : 0).append(" )").toString()).log();
        }
        if (!this._privacyMode && !this._privacyModeProgress) {
            this._trackingActive = false;
            if (!Util.isNullOrEmpty(onlineServiceArray)) {
                this.getDeviceElementStatus().clear();
                int n = onlineServiceArray.length;
                for (int i2 = 0; i2 < n; ++i2) {
                    if (!this.getDeviceElementStatus().containsKeyValuePair(onlineServiceArray[i2].getDeviceID(), CoreServiceMappingTable.isServiceStateAvailable(onlineServiceArray[i2].getServiceState()) || onlineServiceArray[i2].isEnabledState())) {
                        this.getDeviceElementStatus().put(onlineServiceArray[i2].getDeviceID(), CoreServiceMappingTable.isServiceStateAvailable(onlineServiceArray[i2].getServiceState()) || onlineServiceArray[i2].isEnabledState());
                    }
                    if (!onlineServiceArray[i2].isTrackingActive() || !CoreServiceMappingTable.isServiceStateAvailable(onlineServiceArray[i2].getServiceState())) continue;
                    this._trackingActive = true;
                }
                this.handleStatusBarIcon();
            }
        }
    }

    public void synchronizeIconStatus(int n) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".synchronizeIconStatus(status = ").append(n).append(" )").toString()).log();
        }
        if (!this._privacyMode && !this._privacyModeProgress) {
            int n2 = n;
            IntIterator intIterator = this.getStatusBarStatus().keyIterator();
            while (intIterator.hasNext()) {
                int n3 = this.getStatusBarStatus().get(intIterator.next());
                if (n2 <= n3) continue;
                n2 = n3;
            }
            this.setStatusBarIconStatus(this.getStatusLineIconwithState(n2));
        }
    }

    public void updatePrivacyModeStatus(boolean bl) {
        this._privacyMode = bl;
        if (this._privacyMode) {
            this.setStatusBarIconStatus(2);
        }
    }

    public void updatePrivacyModeProgress(boolean bl) {
        this._privacyModeProgress = bl;
    }
}

