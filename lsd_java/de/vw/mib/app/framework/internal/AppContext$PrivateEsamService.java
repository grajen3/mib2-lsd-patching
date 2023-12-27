/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.esam.CloseEsamMemberHandler;
import de.vw.mib.app.esam.EsamChangeListener;
import de.vw.mib.app.esam.EsamService;
import de.vw.mib.app.esam.EsamServiceForViews;
import de.vw.mib.app.framework.internal.AppContext;
import de.vw.mib.app.framework.internal.EsamRuleEngine;
import de.vw.mib.app.framework.internal.EsamRuleEngine$EsamRuleEngineDiagService;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.log4mib.LogMessage;

final class AppContext$PrivateEsamService
implements EsamService,
EsamServiceForViews {
    private final EsamRuleEngine esamRuleEngine;
    private final /* synthetic */ AppContext this$0;

    AppContext$PrivateEsamService(AppContext appContext, EsamRuleEngine esamRuleEngine) {
        this.this$0 = appContext;
        this.esamRuleEngine = esamRuleEngine;
    }

    @Override
    public void clearScreen(String string) {
        if (this.this$0.logger.isTraceEnabled(1024)) {
            this.this$0.logger.trace(1024).append(this.this$0).append(" - request clear screen by esam member '").append(string).append("'!").log();
        }
        this.esamRuleEngine.clearScreen(this.this$0.appDiagController, string);
    }

    @Override
    public int getVisibleEsamMemberCount() {
        return this.esamRuleEngine.getVisibleEsamMemberCount();
    }

    @Override
    public boolean isEsamMemberVisible(String string) {
        return this.esamRuleEngine.isEsamMemberVisible(string);
    }

    @Override
    public boolean isEsamMemberExclusivelyVisible(String string) {
        return this.esamRuleEngine.isEsamMemberExclusivelyVisible(string);
    }

    @Override
    public void registerEsamChangeListener(EsamChangeListener esamChangeListener) {
        this.esamRuleEngine.registerEsamChangeListener(esamChangeListener);
    }

    @Override
    public boolean requestVisibility(String string, CioIntent cioIntent) {
        if (this.this$0.logger.isTraceEnabled(1024)) {
            this.this$0.logger.trace(1024).append(this).append(" - request visibility for esam member '").append(string).append("'!").log();
        }
        boolean bl = this.esamRuleEngine.requestVisibility((EsamRuleEngine$EsamRuleEngineDiagService)this.this$0.appDiagController, string, cioIntent);
        if (this.this$0.logger.isTraceEnabled(1024)) {
            LogMessage logMessage = this.this$0.logger.trace(1024).append(this.this$0).append(" - visibility for esam member '").append(string).append("'");
            if (bl) {
                logMessage.append(" granted!");
            } else {
                logMessage.append(" denied!");
            }
            logMessage.log();
        }
        return bl;
    }

    @Override
    public boolean requestVisibility(String string, CloseEsamMemberHandler closeEsamMemberHandler) {
        if (this.this$0.logger.isTraceEnabled(1024)) {
            this.this$0.logger.trace(1024).append(this.this$0).append(" - request visibility for esam member '").append(string).append("'!").log();
        }
        boolean bl = this.esamRuleEngine.requestVisibility((EsamRuleEngine$EsamRuleEngineDiagService)this.this$0.appDiagController, string, closeEsamMemberHandler);
        if (this.this$0.logger.isTraceEnabled(1024)) {
            LogMessage logMessage = this.this$0.logger.trace(1024).append(this.this$0).append(" - visibility for esam member '").append(string).append("'");
            if (bl) {
                logMessage.append(" granted!");
            } else {
                logMessage.append(" denied!");
            }
            logMessage.log();
        }
        return bl;
    }

    @Override
    public void releaseVisibility(String string) {
        if (this.this$0.logger.isTraceEnabled(1024)) {
            this.this$0.logger.trace(1024).append(this.this$0).append(" - release visibility for esam member '").append(string).append("'!").log();
        }
        this.esamRuleEngine.releaseVisibility(this.this$0.appDiagController, string);
    }

    @Override
    public void unregisterEsamChangeListener(EsamChangeListener esamChangeListener) {
        this.esamRuleEngine.unregisterEsamChangeListener(esamChangeListener);
    }
}

