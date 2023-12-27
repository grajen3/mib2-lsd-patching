/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.esam.CloseEsamMemberHandler;
import de.vw.mib.app.framework.internal.EsamRuleEngine;
import de.vw.mib.app.framework.internal.EsamRuleEngine$EsamRuleEngineDiagService;
import de.vw.mib.cio.CioIntent;

final class EsamRuleEngine$EsamVisibilityGrant
implements CloseEsamMemberHandler {
    private final CioIntent closeEsamMemberCio;
    final CloseEsamMemberHandler closeEsamMemberHandler;
    final EsamRuleEngine$EsamRuleEngineDiagService diagService;
    final String esamCategory;
    final String esamMemberName;
    private final /* synthetic */ EsamRuleEngine this$0;

    EsamRuleEngine$EsamVisibilityGrant(EsamRuleEngine esamRuleEngine, EsamRuleEngine$EsamRuleEngineDiagService esamRuleEngine$EsamRuleEngineDiagService, String string, String string2, CioIntent cioIntent) {
        this.this$0 = esamRuleEngine;
        this.diagService = esamRuleEngine$EsamRuleEngineDiagService;
        this.esamMemberName = string;
        this.esamCategory = string2;
        this.closeEsamMemberCio = cioIntent;
        this.closeEsamMemberHandler = this;
    }

    EsamRuleEngine$EsamVisibilityGrant(EsamRuleEngine esamRuleEngine, EsamRuleEngine$EsamRuleEngineDiagService esamRuleEngine$EsamRuleEngineDiagService, String string, String string2, CloseEsamMemberHandler closeEsamMemberHandler) {
        this.this$0 = esamRuleEngine;
        this.diagService = esamRuleEngine$EsamRuleEngineDiagService;
        this.esamMemberName = string;
        this.esamCategory = string2;
        this.closeEsamMemberCio = null;
        this.closeEsamMemberHandler = closeEsamMemberHandler;
    }

    @Override
    public void closeEsamMember(String string) {
        this.this$0.cioDispatcher.dispatch(this.closeEsamMemberCio);
    }
}

