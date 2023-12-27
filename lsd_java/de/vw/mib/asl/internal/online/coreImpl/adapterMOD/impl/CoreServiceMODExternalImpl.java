/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.adapterMOD.impl;

import de.vw.mib.asl.internal.online.coreImpl.adapterMOD.CoreServiceMODFactory;
import de.vw.mib.asl.internal.online.coreImpl.adapterMOD.states.CoreServiceMODTarget;
import de.vw.mib.asl.internal.online.coreImpl.corecommon.CoreServiceCollector;
import de.vw.mib.asl.internal.online.coreInterfaces.external.CoreServiceExternal;
import de.vw.mib.asl.internal.online.coreInterfaces.external.CoreServiceExternalListener;
import de.vw.mib.util.Util;

public class CoreServiceMODExternalImpl
implements CoreServiceExternal {
    private final String _classname = super.getClass().getName();
    private final CoreServiceMODTarget _target;
    final int[] SUPPORTED_FUNCTIONS = new int[]{2, 1, 4, 5};

    public CoreServiceMODExternalImpl(CoreServiceMODTarget coreServiceMODTarget) {
        this._target = coreServiceMODTarget;
    }

    @Override
    public void getServiceURL(String string, CoreServiceExternalListener coreServiceExternalListener) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".getServiceURL(").append(Util.isNullOrEmpty(string) ? "NULL" : string).append(" )").log();
        }
        if (coreServiceExternalListener != null) {
            if (this._target.getDSIOnlineServiceRegistration() != null) {
                CoreServiceMODFactory.getNotifier().getEventQueue().put(12, new CoreServiceCollector(CoreServiceMODFactory.getNotifier().generateUniqueID(12), string, coreServiceExternalListener));
                this._target.getDSIOnlineServiceRegistration().getServiceURL(string);
            } else {
                this._target.info().append(this._classname).append(".getServiceURL()").append("--> DSI Instance is NULL").log();
            }
        } else {
            this._target.info().append(this._classname).append(".getServiceURL()").append("-->CoreServiceExternalListener is NULL").log();
        }
    }

    /*
     * Handled unverifiable bytecode (illegal stack merge).
     */
    @Override
    public void downloadImage(String string, String string2, String string3, boolean bl, CoreServiceExternalListener coreServiceExternalListener) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".downloadImage(").append(Util.isNullOrEmpty(string2) ? "NULL" : string2).append(" )").log();
        }
        if (coreServiceExternalListener != null) {
            if (this._target.getDSIOnlineServiceRegistration() != null) {
                CoreServiceMODFactory.getNotifier().getEventQueue().put(14, new CoreServiceCollector(CoreServiceMODFactory.getNotifier().generateUniqueID(14), string, coreServiceExternalListener));
                this._target.getDSIOnlineServiceRegistration().downloadRaw("local_filedownloader", string2, string3, bl ? 0 : (int)0L, 0L);
            } else {
                this._target.info().append(this._classname).append(".downloadImage()").append("--> DSI Instance is NULL").log();
            }
        } else {
            this._target.info().append(this._classname).append(".downloadImage()").append("-->CoreServiceExternalListener is NULL").log();
        }
    }

    @Override
    public void calculateSPinHash(String string, String string2, String string3, String string4, int n, CoreServiceExternalListener coreServiceExternalListener) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".calculateSPinHash( SPIN = ").append(Util.isNullOrEmpty(string2) ? "NULL" : string2).append(" )").log();
        }
        if (coreServiceExternalListener != null) {
            CoreServiceMODFactory.getNotifier().getEventQueue().put(16, new CoreServiceCollector(CoreServiceMODFactory.getNotifier().generateUniqueID(16), string, coreServiceExternalListener));
            if (this._target.getDSIOnlineServiceRegistration() != null) {
                this._target.getDSIOnlineServiceRegistration().getSPINHash(string3, string4, n, string2);
            } else {
                CoreServiceMODFactory.getNotifier().calculateSPinHashResponse(string2, string3, string4, n, "", 8);
                this._target.info().append(this._classname).append(".calculateSPinHash()").append("--> DSI Instance is NULL").log();
            }
        } else {
            this._target.info().append(this._classname).append(".calculateSPinHash()").append("-->CoreServiceExternalListener is NULL").log();
        }
    }

    @Override
    public void setSPin(String string, String string2, CoreServiceExternalListener coreServiceExternalListener) {
        if (this._target.isTraceEnabled()) {
            this._target.trace().append(this._classname).append(".setSPin( SPIN = ").append(Util.isNullOrEmpty(string2) ? "NULL" : string2).append(" )").log();
        }
        if (coreServiceExternalListener != null) {
            if (this._target.getDSIOnlineServiceRegistration() != null) {
                CoreServiceMODFactory.getNotifier().getEventQueue().put(17, new CoreServiceCollector(CoreServiceMODFactory.getNotifier().generateUniqueID(17), string, coreServiceExternalListener));
                this._target.getDSIOnlineServiceRegistration().setSPIN("", string, string2);
            } else {
                this._target.info().append(this._classname).append(".setSPin()").append("--> DSI Instance is NULL").log();
            }
        } else {
            this._target.info().append(this._classname).append(".setSPin()").append("-->CoreServiceExternalListener is NULL").log();
        }
    }

    @Override
    public void setTrackingServicesUpdateValid(boolean bl) {
    }

    @Override
    public int[] getSupportedFunctions() {
        return this.SUPPORTED_FUNCTIONS;
    }

    @Override
    public boolean isFuntionSupported(int n) {
        if (!Util.isNullOrEmpty(this.SUPPORTED_FUNCTIONS)) {
            int n2 = this.SUPPORTED_FUNCTIONS.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (this.SUPPORTED_FUNCTIONS[i2] != n) continue;
                return true;
            }
        }
        return false;
    }
}

