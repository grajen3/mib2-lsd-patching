/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.displaymanagement.displayoperation;

import de.vw.mib.asl.framework.internal.displaymanagement.displayoperation.AbstractDsiDisplayOperation;
import de.vw.mib.asl.framework.internal.displaymanagement.displayoperation.DSIDisplayManagementListenerAdapter;

public abstract class AbstractDsiDisplayOperation$DSIDisplayManagementListenerAsyncExceptionAdapter
extends DSIDisplayManagementListenerAdapter {
    private final /* synthetic */ AbstractDsiDisplayOperation this$0;

    protected AbstractDsiDisplayOperation$DSIDisplayManagementListenerAsyncExceptionAdapter(AbstractDsiDisplayOperation abstractDsiDisplayOperation) {
        this.this$0 = abstractDsiDisplayOperation;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.this$0.reportError();
    }
}

