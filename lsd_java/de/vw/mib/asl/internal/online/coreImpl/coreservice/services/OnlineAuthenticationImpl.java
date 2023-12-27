/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice.services;

import de.vw.mib.asl.api.online.services.authenticate.OnlineAuthentication;
import de.vw.mib.asl.api.online.services.authenticate.OnlineAuthenticationListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.CoreServiceImplFactory;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.services.OnlineAuthenticationImpl$AuthenticationCollector;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.services.OnlineAuthenticationImpl$AuthenticationListener;
import de.vw.mib.asl.internal.online.coreInterfaces.CoreServiceFactory;
import de.vw.mib.collections.ObjectObjectMap;
import de.vw.mib.collections.ObjectObjectOptHashMap;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.Util;
import java.util.Iterator;

public class OnlineAuthenticationImpl
implements OnlineAuthentication {
    private final String _classname = super.getClass().getName();
    private static OnlineAuthenticationImpl$AuthenticationListener _authentication;
    private static ObjectObjectMap _registery;
    private static ObjectObjectMap _queue;
    private final int TYPE_SPIN_HASH;
    private final int TYPE_SPIN_SET;
    private int _onlineState;
    private static String _userName;

    public OnlineAuthenticationImpl() {
        this.TYPE_SPIN_HASH = 0;
        this.TYPE_SPIN_SET = 1;
    }

    @Override
    public String getMainUserName() {
        _userName = !Util.isNullOrEmpty(this.getMainUserEnrolled()) ? this.getMainUserEnrolled() : _userName;
        return _userName;
    }

    @Override
    public String getMainUserEnrolled() {
        return CoreServiceImplFactory.getCoreServiceController().getMainUserEnrolled();
    }

    @Override
    public void setSPIN(String string, String string2, OnlineAuthenticationListener onlineAuthenticationListener) {
        if (onlineAuthenticationListener != null) {
            if (_authentication == null) {
                _authentication = new OnlineAuthenticationImpl$AuthenticationListener(this, onlineAuthenticationListener);
                this.requestSPin(string, string2, "", "", 0, 1);
            } else if (!this.getQueue().containsKey(string)) {
                this.getQueue().put(string, new OnlineAuthenticationImpl$AuthenticationCollector(this, string, string2, "", "", 0, onlineAuthenticationListener));
            } else {
                LogMessage logMessage = ServiceManager.logger2.info(16384);
                logMessage.append(this._classname).append(".setSPIN() --> Request already existing").log();
            }
        } else {
            LogMessage logMessage = ServiceManager.logger2.info(16384);
            logMessage.append(this._classname).append(".setSPIN() --> Listener is NULL").log();
        }
    }

    @Override
    public void calculateSpinHash(String string, String string2, String string3, String string4, int n, OnlineAuthenticationListener onlineAuthenticationListener) {
        if (onlineAuthenticationListener != null) {
            if (_authentication == null) {
                _authentication = new OnlineAuthenticationImpl$AuthenticationListener(this, onlineAuthenticationListener);
                this.requestSPin(string, string2, string3, string4, n, 0);
            } else if (!this.getQueue().containsKey(string)) {
                this.getQueue().put(string, new OnlineAuthenticationImpl$AuthenticationCollector(this, string, string2, string3, string4, n, onlineAuthenticationListener));
            } else {
                LogMessage logMessage = ServiceManager.logger2.info(16384);
                logMessage.append(this._classname).append(".calculateSpinHash() --> Request already existing").log();
            }
        } else {
            LogMessage logMessage = ServiceManager.logger2.info(16384);
            logMessage.append(this._classname).append(".calculateSpinHash() --> Listener is NULL").log();
        }
    }

    @Override
    public void register(String string, OnlineAuthenticationListener onlineAuthenticationListener) {
        if (!this.getRegisteredServices().containsKey(string)) {
            this.getRegisteredServices().put(string, new OnlineAuthenticationImpl$AuthenticationListener(this, onlineAuthenticationListener));
        } else {
            LogMessage logMessage = ServiceManager.logger2.info(16384);
            logMessage.append(this._classname).append(".register() --> ServiceID already registered").log();
        }
    }

    @Override
    public void unregister(String string, OnlineAuthenticationListener onlineAuthenticationListener) {
        if (this.getRegisteredServices().containsKey(string)) {
            this.getRegisteredServices().remove(string);
        } else {
            LogMessage logMessage = ServiceManager.logger2.info(16384);
            logMessage.append(this._classname).append(".register() --> ServiceID does not exist").log();
        }
    }

    @Override
    public void registerForMainUserEnrollment(OnlineAuthenticationListener onlineAuthenticationListener) {
        CoreServiceImplFactory.getCoreServiceController().registerForMainUserEnrollment(onlineAuthenticationListener);
    }

    @Override
    public void unRegisterForMainUserEnrollment(OnlineAuthenticationListener onlineAuthenticationListener) {
        CoreServiceImplFactory.getCoreServiceController().unRegisterForMainUserEnrollment(onlineAuthenticationListener);
    }

    public void setMainUserName(String string) {
        _userName = string;
    }

    public void updateServiceListState(int n, int n2) {
        if (n2 == 1) {
            this._onlineState = n;
        }
    }

    public void deleteMainUserName(boolean bl) {
        _userName = bl ? (this._onlineState == 3 ? "" : _userName) : "";
    }

    public void calculateSpinHashResponse(String string, String string2, String string3, String string4, int n, String string5, int n2) {
        if (_authentication != null) {
            _authentication.updateSpinHashResult(string5, this.convertResult(n2));
            _authentication = null;
            if (!this.getQueue().isEmpty()) {
                Iterator iterator = this.getQueue().entryIterator();
                if (iterator.hasNext()) {
                    OnlineAuthenticationImpl$AuthenticationCollector onlineAuthenticationImpl$AuthenticationCollector = (OnlineAuthenticationImpl$AuthenticationCollector)iterator.next();
                    int n3 = 0;
                    if (Util.isNullOrEmpty(onlineAuthenticationImpl$AuthenticationCollector.getChallenge())) {
                        n3 = 1;
                    }
                    this.requestSPin(onlineAuthenticationImpl$AuthenticationCollector.getServiceID(), onlineAuthenticationImpl$AuthenticationCollector.getSPin(), onlineAuthenticationImpl$AuthenticationCollector.getChallenge(), onlineAuthenticationImpl$AuthenticationCollector.getUserChallenge(), onlineAuthenticationImpl$AuthenticationCollector.getVersion(), n3);
                    _authentication = new OnlineAuthenticationImpl$AuthenticationListener(this, onlineAuthenticationImpl$AuthenticationCollector.getListener());
                    this.getQueue().remove(onlineAuthenticationImpl$AuthenticationCollector.getServiceID());
                }
            } else {
                LogMessage logMessage = ServiceManager.logger2.trace(16384);
                logMessage.append(this._classname).append(".calculateSpinHashResponse() --> next element is empty").log();
            }
        } else {
            LogMessage logMessage = ServiceManager.logger2.info(16384);
            logMessage.append(this._classname).append(".calculateSpinHashResponse() --> Listener is NULL").log();
        }
    }

    public void updateSPinRequired(String string) {
        if (!Util.isNullOrEmpty(string)) {
            OnlineAuthenticationImpl$AuthenticationListener onlineAuthenticationImpl$AuthenticationListener;
            if (this.getRegisteredServices().containsKey(string) && (onlineAuthenticationImpl$AuthenticationListener = (OnlineAuthenticationImpl$AuthenticationListener)this.getRegisteredServices().get(string)) != null) {
                onlineAuthenticationImpl$AuthenticationListener.updateSpinRequired(string);
            }
        } else {
            LogMessage logMessage = ServiceManager.logger2.info(16384);
            logMessage.append(this._classname).append(".updateSPinRequired() --> ServiceID is NULL").log();
        }
    }

    public void setSPinResponse(String string, int n, int n2) {
        if (!Util.isNullOrEmpty(string)) {
            if (_authentication != null) {
                Iterator iterator;
                _authentication.setSPinResponse(string, this.convertResult(n2));
                _authentication = null;
                if (!this.getQueue().isEmpty() && (iterator = this.getQueue().entryIterator()).hasNext()) {
                    OnlineAuthenticationImpl$AuthenticationCollector onlineAuthenticationImpl$AuthenticationCollector = (OnlineAuthenticationImpl$AuthenticationCollector)iterator.next();
                    int n3 = 0;
                    if (Util.isNullOrEmpty(onlineAuthenticationImpl$AuthenticationCollector.getChallenge())) {
                        n3 = 1;
                    }
                    this.requestSPin(onlineAuthenticationImpl$AuthenticationCollector.getServiceID(), onlineAuthenticationImpl$AuthenticationCollector.getSPin(), onlineAuthenticationImpl$AuthenticationCollector.getChallenge(), onlineAuthenticationImpl$AuthenticationCollector.getUserChallenge(), onlineAuthenticationImpl$AuthenticationCollector.getVersion(), n3);
                    _authentication = new OnlineAuthenticationImpl$AuthenticationListener(this, onlineAuthenticationImpl$AuthenticationCollector.getListener());
                    this.getQueue().remove(onlineAuthenticationImpl$AuthenticationCollector.getServiceID());
                }
            } else {
                LogMessage logMessage = ServiceManager.logger2.info(16384);
                logMessage.append(this._classname).append(".setSPinResponse() --> Listener is NULL").log();
            }
        }
    }

    private ObjectObjectMap getRegisteredServices() {
        if (_registery == null) {
            _registery = new ObjectObjectOptHashMap();
        }
        return _registery;
    }

    private ObjectObjectMap getQueue() {
        if (_queue == null) {
            _queue = new ObjectObjectOptHashMap();
        }
        return _queue;
    }

    private int convertResult(int n) {
        int n2 = -1;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 8: {
                n2 = 2;
                break;
            }
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: 
            case 26: 
            case 27: 
            case 28: 
            case 29: 
            case 30: 
            case 51: 
            case 52: 
            case 53: 
            case 54: 
            case 55: 
            case 58: {
                n2 = 1;
                break;
            }
            case 56: {
                n2 = 3;
                break;
            }
            case 57: {
                n2 = 4;
                break;
            }
        }
        return n2;
    }

    private void requestSPin(String string, String string2, String string3, String string4, int n, int n2) {
        Object[] objectArray = CoreServiceFactory.getExternalRegister().getExternalsWithSupportedFunction(4);
        if (!Util.isNullOrEmpty(objectArray)) {
            int n3 = objectArray.length;
            for (int i2 = 0; i2 < n3; ++i2) {
                if (n2 == 0) {
                    objectArray[i2].calculateSPinHash(string, string2, string3, string4, n, CoreServiceImplFactory.getExternalListener());
                    continue;
                }
                objectArray[i2].setSPin(string, string2, CoreServiceImplFactory.getExternalListener());
            }
        } else {
            this.calculateSpinHashResponse(string, string2, string3, string4, n, "", 8);
        }
    }

    static /* synthetic */ String access$000(OnlineAuthenticationImpl onlineAuthenticationImpl) {
        return onlineAuthenticationImpl._classname;
    }

    static {
        _userName = "";
    }
}

