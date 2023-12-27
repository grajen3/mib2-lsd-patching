/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice.services;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.CoreServiceImplFactory;
import de.vw.mib.asl.internal.online.coreInterfaces.CoreServiceFactory;
import de.vw.mib.util.Util;

public class CoreServiceFactoryResetHandling {
    private final String _classname = super.getClass().getName();
    private int _size;
    private boolean _handlingResetFactorySettings;

    public void requestResetToFactorySettings(String string) {
        Object[] objectArray;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            objectArray = ServiceManager.logger2.trace(16384);
            objectArray.append(this._classname).append(".requestResetToFactorySettings(").append(Util.isNullOrEmpty(string) ? string : "NULL").append(" )").log();
        }
        if (!Util.isNullOrEmpty(objectArray = CoreServiceFactory.getAdapterRegister().getAdapterList())) {
            this._size = objectArray.length;
            for (int i2 = 0; i2 < this._size; ++i2) {
                if (objectArray[i2] == null) continue;
                this._handlingResetFactorySettings = true;
                if (this._size > 1) {
                    if (objectArray[i2] == CoreServiceFactory.getAdapterRegister().getMainAdapter()) continue;
                    objectArray[i2].resetToFactorySettings(string, CoreServiceImplFactory.getAdapterListener());
                    return;
                }
                objectArray[i2].resetToFactorySettings(string, CoreServiceImplFactory.getAdapterListener());
                return;
            }
        }
        CoreServiceImplFactory.getCoreServiceNotifier().resetToFactorSettingsResponse(CoreServiceFactory.getAdapterRegister().getMainAdapterID(), string, 2);
    }

    public void responseResetToFactorSettings(int n, String string, int n2) {
        Object[] objectArray;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            objectArray = ServiceManager.logger2.trace(16384);
            objectArray.append(this._classname).append(new StringBuffer().append(".responseResetToFactorSettings(result= ").append(n2).append(")").toString()).log();
        }
        if (n2 == 0) {
            if (this._size > 1 && n != CoreServiceFactory.getAdapterRegister().getMainAdapterID() && !Util.isNullOrEmpty(objectArray = CoreServiceFactory.getAdapterRegister().getAdapterList())) {
                for (int i2 = 0; i2 < this._size; ++i2) {
                    if (objectArray[i2] == null || objectArray[i2] != CoreServiceFactory.getAdapterRegister().getMainAdapter()) continue;
                    objectArray[i2].resetToFactorySettings(string, CoreServiceImplFactory.getAdapterListener());
                    return;
                }
            }
            this._handlingResetFactorySettings = false;
            CoreServiceImplFactory.getCoreServiceNotifier().resetToFactorSettingsResponse(n, string, 0);
        } else {
            this._handlingResetFactorySettings = false;
            if (this._size > 1 && n != CoreServiceFactory.getAdapterRegister().getMainAdapterID()) {
                CoreServiceImplFactory.getCoreServiceNotifier().resetToFactorSettingsResponse(n, string, 2);
            } else {
                CoreServiceImplFactory.getCoreServiceNotifier().resetToFactorSettingsResponse(n, string, 1);
            }
        }
    }

    public boolean isResetFactorySettingsInProcess() {
        return this._handlingResetFactorySettings;
    }
}

