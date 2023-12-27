/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.displaymanagement.displayoperation;

import de.vw.mib.asl.framework.internal.displaymanagement.displayoperation.AbstractDsiDisplayOperation$DSIDisplayManagementListenerAsyncExceptionAdapter;
import de.vw.mib.asl.framework.internal.displaymanagement.displayoperation.SetDisplayTypeOperation;

class SetDisplayTypeOperation$1
extends AbstractDsiDisplayOperation$DSIDisplayManagementListenerAsyncExceptionAdapter {
    private final /* synthetic */ SetDisplayTypeOperation this$0;

    SetDisplayTypeOperation$1(SetDisplayTypeOperation setDisplayTypeOperation) {
        this.this$0 = setDisplayTypeOperation;
        super(setDisplayTypeOperation);
    }

    @Override
    public void setDisplayTypeResult(int n, int n2) {
        this.this$0.reportSuccess();
        if (this.this$0.getLogger().isTraceEnabled(4096)) {
            this.this$0.getLogger().trace(4096, new StringBuffer().append("[ SetDisplayTypeOperation ] The DSI display operation with displayId >").append(n).append("< and type >").append(n2).append("<").append(" is finished.").toString());
        }
    }
}

