/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia;

import de.vw.mib.asia.AsiaInput;
import de.vw.mib.widgets.speller.asia.AbstractAsiaInputInitializer;
import de.vw.mib.widgets.speller.asia.AbstractAsiaInputInitializer$AbstractAsiaInputConfigurator;

public final class AbstractAsiaInputInitializer$UserDatabaseStateHandler
extends AbstractAsiaInputInitializer$AbstractAsiaInputConfigurator {
    private final int databaseId;
    private final int databaseState;
    private final String databaseStateName;
    private final /* synthetic */ AbstractAsiaInputInitializer this$0;

    public AbstractAsiaInputInitializer$UserDatabaseStateHandler(AbstractAsiaInputInitializer abstractAsiaInputInitializer, int n, String string, int n2) {
        this.this$0 = abstractAsiaInputInitializer;
        super(abstractAsiaInputInitializer, false);
        this.databaseId = n;
        this.databaseStateName = string;
        this.databaseState = n2;
    }

    @Override
    public void asiaSetUserDatabaseState(int n, int n2) {
        if (this.databaseId == n && this.databaseState == n2) {
            this.handleResponse(true);
        } else {
            this.this$0.warn().append("setting user database state failed! ").append("databaseId=").append(this.databaseId).append(" databaseState=").append(this.databaseState).append(" [").append(this.databaseStateName).append("]").log();
            this.handleResponse(false);
        }
    }

    @Override
    protected void onConfigure(AsiaInput asiaInput) {
        if (this.this$0.isTraceEnabled()) {
            this.this$0.trace().append("databaseId=").append(this.databaseId).append(" databaseState=").append(this.databaseState).append(" [").append(this.databaseStateName).append("]").log();
        }
        asiaInput.setUserDatabaseState(this.databaseId, this.databaseState);
    }

    @Override
    protected void onHandleResponse(boolean bl, long l) {
        if (bl && this.this$0.isTraceEnabled()) {
            this.this$0.trace().append("Took ").append(l).append("[ms] to set databaseId=").append(this.databaseId).append(" databaseState=").append(this.databaseState).append(" [").append(this.databaseStateName).append("]").log();
        }
    }
}

