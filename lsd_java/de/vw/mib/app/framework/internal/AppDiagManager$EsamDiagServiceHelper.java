/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.esam.CloseEsamMemberHandler;
import de.vw.mib.app.framework.diag.AppDiag;
import de.vw.mib.app.framework.diag.AppDiagListener;
import de.vw.mib.app.framework.diag.EsamDiagListener;
import de.vw.mib.app.framework.diag.ModelApiTracer;
import de.vw.mib.app.framework.internal.AppDiagManager;
import de.vw.mib.app.framework.internal.AppDiagManager$1;
import de.vw.mib.app.framework.internal.EsamRuleEngine$EsamRuleEngineDiagService;

final class AppDiagManager$EsamDiagServiceHelper
implements AppDiag,
CloseEsamMemberHandler,
EsamRuleEngine$EsamRuleEngineDiagService {
    private final /* synthetic */ AppDiagManager this$0;

    private AppDiagManager$EsamDiagServiceHelper(AppDiagManager appDiagManager) {
        this.this$0 = appDiagManager;
    }

    @Override
    public void closeEsamMember(String string) {
    }

    @Override
    public String getAppAdapterClass() {
        return null;
    }

    @Override
    public int getAppInstanceId() {
        return 0;
    }

    @Override
    public String getAppInstanceName() {
        return "ESAM-TESTER";
    }

    @Override
    public String getAppName() {
        return "ESAM-TESTER";
    }

    @Override
    public void onEsamVisibilityDenied(String string, String string2, String string3) {
        Object[] objectArray = AppDiagManager.access$000(this.this$0).getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EsamDiagListener)objectArray[i2]).onEsamVisibilityDenied(this, string, string2, string3);
        }
    }

    @Override
    public void onEsamVisibilityDenied(String string, String string2, String string3, String string4) {
        Object[] objectArray = AppDiagManager.access$000(this.this$0).getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EsamDiagListener)objectArray[i2]).onEsamVisibilityDenied(this, string, string2, string3, string4);
        }
    }

    @Override
    public void onEsamVisibilityGranted(String string, String string2) {
        Object[] objectArray = AppDiagManager.access$000(this.this$0).getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EsamDiagListener)objectArray[i2]).onEsamVisibilityGranted(this, string, string2);
        }
    }

    @Override
    public void onEsamVisibilityRelease(String string, String string2) {
        Object[] objectArray = AppDiagManager.access$000(this.this$0).getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EsamDiagListener)objectArray[i2]).onEsamVisibilityRelease(this, string, string2);
        }
    }

    @Override
    public void onEsamVisibilityRequest(String string, String string2) {
        Object[] objectArray = AppDiagManager.access$000(this.this$0).getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EsamDiagListener)objectArray[i2]).onEsamVisibilityRequest(this, string, string2);
        }
    }

    @Override
    public void onEsamVisibilityRevoked(String string, String string2, String string3, String string4) {
        Object[] objectArray = AppDiagManager.access$000(this.this$0).getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EsamDiagListener)objectArray[i2]).onEsamVisibilityRevoked(this, string, string2, string3, string4);
        }
    }

    @Override
    public void onHideAllEsamMembersRequest(String string, String string2) {
        Object[] objectArray = AppDiagManager.access$000(this.this$0).getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((EsamDiagListener)objectArray[i2]).onRequestHideAllEsamMembers(this, string, string2);
        }
    }

    @Override
    public void registerAppDiagListener(AppDiagListener appDiagListener) {
    }

    @Override
    public void registerModelApiTracer(ModelApiTracer modelApiTracer) {
    }

    @Override
    public void unregisterAppDiagListener(AppDiagListener appDiagListener) {
    }

    @Override
    public void unregisterModelApiTracer(ModelApiTracer modelApiTracer) {
    }

    /* synthetic */ AppDiagManager$EsamDiagServiceHelper(AppDiagManager appDiagManager, AppDiagManager$1 appDiagManager$1) {
        this(appDiagManager);
    }
}

