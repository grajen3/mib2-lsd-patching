/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.framework.internal.AppContext;
import de.vw.mib.app.framework.internal.AppLifecycleManager;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.ContentInformationObject;

class AppLifecycleManager$1
implements CioExecutor {
    private final /* synthetic */ AppContext val$appContext;
    private final /* synthetic */ AppLifecycleManager this$0;

    AppLifecycleManager$1(AppLifecycleManager appLifecycleManager, AppContext appContext) {
        this.this$0 = appLifecycleManager;
        this.val$appContext = appContext;
    }

    @Override
    public boolean onCioIntentRegistration(ContentInformationObject contentInformationObject) {
        return false;
    }

    @Override
    public void execute(ContentInformationObject contentInformationObject, CioActionParameters cioActionParameters) {
        this.this$0.logger.warn(256).append(this.val$appContext).append(" - no cio executor provided").log();
    }
}

