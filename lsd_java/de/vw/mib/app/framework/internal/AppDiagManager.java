/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.framework.diag.AppDiag;
import de.vw.mib.app.framework.diag.AppFrameworkDiagListener;
import de.vw.mib.app.framework.diag.AppFrameworkDiagService;
import de.vw.mib.app.framework.diag.EsamDiagListener;
import de.vw.mib.app.framework.diag.EsamDiagService;
import de.vw.mib.app.framework.diag.ModelApiTracer;
import de.vw.mib.app.framework.internal.AppDiagController;
import de.vw.mib.app.framework.internal.AppDiagManager$EsamDiagServiceHelper;
import de.vw.mib.app.framework.internal.EsamRuleEngine;
import de.vw.mib.app.framework.internal.EsamRuleEngine$EsamRuleEngineDiagService;
import de.vw.mib.collections.copyonwrite.CowArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class AppDiagManager
implements AppFrameworkDiagService,
EsamDiagService {
    private List appDiagControllers;
    private final CowArray appDiagListeners;
    private final CowArray esamDiagListeners;
    private final AppDiagManager$EsamDiagServiceHelper esamDiagServiceHelper;
    private final EsamRuleEngine esamRuleEngine;
    private final CowArray modelApiTracers;

    AppDiagManager(EsamRuleEngine esamRuleEngine) {
        this.esamRuleEngine = esamRuleEngine;
        this.esamDiagServiceHelper = new AppDiagManager$EsamDiagServiceHelper(this, null);
        this.appDiagControllers = new ArrayList();
        this.appDiagListeners = new CowArray();
        this.esamDiagListeners = new CowArray();
        this.modelApiTracers = new CowArray();
    }

    @Override
    public AppDiag getApp(String string, String string2) {
        if (string == null || string2 == null) {
            return null;
        }
        Iterator iterator = this.appDiagControllers.iterator();
        while (iterator.hasNext()) {
            AppDiag appDiag = (AppDiag)iterator.next();
            if (!string.equals(appDiag.getAppName()) || !string2.equals(appDiag.getAppInstanceName())) continue;
            return appDiag;
        }
        return null;
    }

    @Override
    public List getApps() {
        return this.appDiagControllers;
    }

    @Override
    public Map getEsamMembersAndCategories() {
        return this.esamRuleEngine.getEsamMembersAndCategories();
    }

    @Override
    public Set getVisibleEsamMembers() {
        return this.esamRuleEngine.getVisibleEsamMembers();
    }

    @Override
    public void releaseVisibility(String string) {
        this.esamRuleEngine.releaseVisibility(this.esamDiagServiceHelper, string);
    }

    @Override
    public boolean requestVisibility(String string) {
        return this.esamRuleEngine.requestVisibility((EsamRuleEngine$EsamRuleEngineDiagService)this.esamDiagServiceHelper, string, this.esamDiagServiceHelper);
    }

    void registerAppDiagController(AppDiagController appDiagController) {
        this.appDiagControllers.add(appDiagController);
        Object[] objectArray = this.appDiagListeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            AppFrameworkDiagListener appFrameworkDiagListener = (AppFrameworkDiagListener)objectArray[i2];
            appFrameworkDiagListener.onAppCreated(appDiagController);
            appDiagController.registerAppDiagListener(appFrameworkDiagListener);
        }
        Object[] objectArray2 = this.esamDiagListeners.getArray();
        for (int i3 = objectArray2.length - 1; i3 >= 0; --i3) {
            EsamDiagListener esamDiagListener = (EsamDiagListener)objectArray2[i3];
            appDiagController.registerEsamDiagListener(esamDiagListener);
        }
        Object[] objectArray3 = this.modelApiTracers.getArray();
        for (int i4 = objectArray3.length - 1; i4 >= 0; --i4) {
            ModelApiTracer modelApiTracer = (ModelApiTracer)objectArray3[i4];
            appDiagController.registerModelApiTracer(modelApiTracer);
        }
    }

    void registerAppFrameworkDiagListener(AppFrameworkDiagListener appFrameworkDiagListener) {
        this.appDiagListeners.addIfNotAlreadyIn(appFrameworkDiagListener);
        Iterator iterator = this.appDiagControllers.iterator();
        while (iterator.hasNext()) {
            AppDiagController appDiagController = (AppDiagController)iterator.next();
            appDiagController.registerAppDiagListener(appFrameworkDiagListener);
        }
    }

    void registerEsamDiagListener(EsamDiagListener esamDiagListener) {
        this.esamDiagListeners.addIfNotAlreadyIn(esamDiagListener);
        Iterator iterator = this.appDiagControllers.iterator();
        while (iterator.hasNext()) {
            AppDiagController appDiagController = (AppDiagController)iterator.next();
            appDiagController.registerEsamDiagListener(esamDiagListener);
        }
    }

    void registerModelApiTracer(ModelApiTracer modelApiTracer) {
        this.modelApiTracers.addIfNotAlreadyIn(modelApiTracer);
        Iterator iterator = this.appDiagControllers.iterator();
        while (iterator.hasNext()) {
            AppDiagController appDiagController = (AppDiagController)iterator.next();
            appDiagController.registerModelApiTracer(modelApiTracer);
        }
    }

    void unregisterAppDiagController(AppDiagController appDiagController) {
        this.appDiagControllers.remove(appDiagController);
        Object[] objectArray = this.appDiagListeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            AppFrameworkDiagListener appFrameworkDiagListener = (AppFrameworkDiagListener)objectArray[i2];
            appFrameworkDiagListener.onAppDisposed(appDiagController);
            appDiagController.unregisterAppDiagListener(appFrameworkDiagListener);
        }
        Object[] objectArray2 = this.modelApiTracers.getArray();
        for (int i3 = objectArray2.length - 1; i3 >= 0; --i3) {
            ModelApiTracer modelApiTracer = (ModelApiTracer)objectArray2[i3];
            appDiagController.unregisterModelApiTracer(modelApiTracer);
        }
    }

    void unregisterAppFrameworkDiagListener(AppFrameworkDiagListener appFrameworkDiagListener) {
        this.appDiagListeners.remove(appFrameworkDiagListener);
        Iterator iterator = this.appDiagControllers.iterator();
        while (iterator.hasNext()) {
            AppDiagController appDiagController = (AppDiagController)iterator.next();
            appDiagController.unregisterAppDiagListener(appFrameworkDiagListener);
        }
    }

    void unregisterEsamDiagListener(EsamDiagListener esamDiagListener) {
        this.esamDiagListeners.remove(esamDiagListener);
        Iterator iterator = this.appDiagControllers.iterator();
        while (iterator.hasNext()) {
            AppDiagController appDiagController = (AppDiagController)iterator.next();
            appDiagController.unregisterEsamDiagListener(esamDiagListener);
        }
    }

    void unregisterModelApiTracer(ModelApiTracer modelApiTracer) {
        this.modelApiTracers.remove(modelApiTracer);
        Iterator iterator = this.appDiagControllers.iterator();
        while (iterator.hasNext()) {
            AppDiagController appDiagController = (AppDiagController)iterator.next();
            appDiagController.unregisterModelApiTracer(modelApiTracer);
        }
    }

    static /* synthetic */ CowArray access$000(AppDiagManager appDiagManager) {
        return appDiagManager.esamDiagListeners;
    }
}

