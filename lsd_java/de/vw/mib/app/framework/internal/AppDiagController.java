/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.app.framework.diag.AppDiag;
import de.vw.mib.app.framework.diag.AppDiagListener;
import de.vw.mib.app.framework.diag.EsamDiagListener;
import de.vw.mib.app.framework.diag.ModelApiTracer;
import de.vw.mib.app.framework.internal.AppContext;
import de.vw.mib.app.framework.internal.EsamRuleEngine$EsamRuleEngineDiagService;
import de.vw.mib.app.framework.internal.Services$AppFrameworkManagerServices;
import de.vw.mib.collections.copyonwrite.CowArray;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.modelapi.ModelApiDownEvent;
import de.vw.mib.modelapi.ModelApiUpEvent;

final class AppDiagController
implements AppDiag,
EsamRuleEngine$EsamRuleEngineDiagService {
    private final AppDefinition appDefinition;
    private final CowArray appDiagListeners;
    private final CowArray esamDiagListeners;
    private final Logger logger;
    private final CowArray modelApiTracers;

    AppDiagController(AppContext appContext, Services$AppFrameworkManagerServices services$AppFrameworkManagerServices) {
        this.logger = appContext.getLogger();
        this.appDefinition = appContext.getAppDefinition();
        this.appDiagListeners = new CowArray();
        this.esamDiagListeners = new CowArray();
        this.modelApiTracers = new CowArray();
        services$AppFrameworkManagerServices.getAppDiagManager().registerAppDiagController(this);
    }

    @Override
    public String getAppAdapterClass() {
        return this.appDefinition.getAppAdapterClass();
    }

    @Override
    public int getAppInstanceId() {
        return this.appDefinition.getAppInstanceId();
    }

    @Override
    public String getAppInstanceName() {
        return this.appDefinition.getAppInstanceName();
    }

    @Override
    public String getAppName() {
        return this.appDefinition.getAppName();
    }

    @Override
    public void onEsamVisibilityDenied(String string, String string2, String string3) {
        Object[] objectArray = this.esamDiagListeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EsamDiagListener)objectArray[i2]).onEsamVisibilityDenied(this, string, string2, string3);
        }
    }

    @Override
    public void onEsamVisibilityDenied(String string, String string2, String string3, String string4) {
        Object[] objectArray = this.esamDiagListeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EsamDiagListener)objectArray[i2]).onEsamVisibilityDenied(this, string, string2, string3, string4);
        }
    }

    @Override
    public void onEsamVisibilityGranted(String string, String string2) {
        Object[] objectArray = this.esamDiagListeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EsamDiagListener)objectArray[i2]).onEsamVisibilityGranted(this, string, string2);
        }
    }

    @Override
    public void onEsamVisibilityRelease(String string, String string2) {
        Object[] objectArray = this.esamDiagListeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EsamDiagListener)objectArray[i2]).onEsamVisibilityRelease(this, string, string2);
        }
    }

    @Override
    public void onEsamVisibilityRequest(String string, String string2) {
        Object[] objectArray = this.esamDiagListeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EsamDiagListener)objectArray[i2]).onEsamVisibilityRequest(this, string, string2);
        }
    }

    @Override
    public void onEsamVisibilityRevoked(String string, String string2, String string3, String string4) {
        Object[] objectArray = this.esamDiagListeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EsamDiagListener)objectArray[i2]).onEsamVisibilityRevoked(this, string, string2, string3, string4);
        }
    }

    @Override
    public void onHideAllEsamMembersRequest(String string, String string2) {
        Object[] objectArray = this.esamDiagListeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EsamDiagListener)objectArray[i2]).onRequestHideAllEsamMembers(this, string, string2);
        }
    }

    @Override
    public void registerAppDiagListener(AppDiagListener appDiagListener) {
        this.appDiagListeners.addIfNotAlreadyIn(appDiagListener);
    }

    @Override
    public void registerModelApiTracer(ModelApiTracer modelApiTracer) {
        this.modelApiTracers.addIfNotAlreadyIn(modelApiTracer);
    }

    @Override
    public void unregisterAppDiagListener(AppDiagListener appDiagListener) {
        this.appDiagListeners.remove(appDiagListener);
    }

    @Override
    public void unregisterModelApiTracer(ModelApiTracer modelApiTracer) {
        this.modelApiTracers.remove(modelApiTracer);
    }

    void onEnterView(String string, String[] stringArray, String string2) {
        Object[] objectArray = this.appDiagListeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((AppDiagListener)objectArray[i2]).onEnterView(this, string, stringArray, string2);
        }
    }

    void onLeaveView(String string, String[] stringArray, String string2) {
        Object[] objectArray = this.appDiagListeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((AppDiagListener)objectArray[i2]).onLeaveView(this, string, stringArray, string2);
        }
    }

    void onLifecycleChanged(int n) {
        Object[] objectArray = this.appDiagListeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((AppDiagListener)objectArray[i2]).onLifecycleChanged(this, n);
        }
    }

    void onModelApiDownCall(ModelApiDownEvent modelApiDownEvent, int n) {
        Object[] objectArray = this.modelApiTracers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((ModelApiTracer)objectArray[i2]).traceModelApiDownCall(this, modelApiDownEvent, n);
        }
    }

    void onModelApiUnboundDownCall(ModelApiDownEvent modelApiDownEvent) {
        this.logger.warn(128).append("Couldn't perform model api down call of app ").append(this.appDefinition.getAppName()).append("! No ModelApiService instance provided by the app adapter ").append(this.appDefinition.getAppAdapterClass()).append("!").log();
        String string = modelApiDownEvent != null ? modelApiDownEvent.toString() : "";
        Object[] objectArray = this.modelApiTracers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((ModelApiTracer)objectArray[i2]).traceModelApiUnboundDownCall(this, string);
        }
    }

    void onModelApiUnboundUpCall(ModelApiUpEvent modelApiUpEvent) {
        String string = modelApiUpEvent != null ? modelApiUpEvent.toString() : "";
        Object[] objectArray = this.modelApiTracers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((ModelApiTracer)objectArray[i2]).traceModelApiUnboundUpCall(this, string);
        }
    }

    void onModelApiUpCall(ModelApiUpEvent modelApiUpEvent, int n) {
        Object[] objectArray = this.modelApiTracers.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((ModelApiTracer)objectArray[i2]).traceModelApiUpCall(this, modelApiUpEvent, n);
        }
    }

    void onVisibilityChanged(String string, String[] stringArray, boolean bl) {
        Object[] objectArray = this.appDiagListeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((AppDiagListener)objectArray[i2]).onVisibilityChanged(this, string, stringArray, bl);
        }
    }

    void onVisibilityDenied(String string) {
        Object[] objectArray = this.appDiagListeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((AppDiagListener)objectArray[i2]).onRequestVisibilityDenied(this, string);
        }
    }

    void onVisibilityRequested(String string) {
        Object[] objectArray = this.appDiagListeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((AppDiagListener)objectArray[i2]).onRequestVisibility(this, string);
        }
    }

    void registerEsamDiagListener(EsamDiagListener esamDiagListener) {
        this.esamDiagListeners.addIfNotAlreadyIn(esamDiagListener);
    }

    void unregisterEsamDiagListener(EsamDiagListener esamDiagListener) {
        this.esamDiagListeners.remove(esamDiagListener);
    }
}

