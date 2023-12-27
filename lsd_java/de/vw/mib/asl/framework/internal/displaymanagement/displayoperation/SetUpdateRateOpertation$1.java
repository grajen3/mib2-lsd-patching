/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.displaymanagement.displayoperation;

import de.vw.mib.asl.framework.internal.displaymanagement.displayoperation.AbstractDsiDisplayOperation$DSIDisplayManagementListenerAsyncExceptionAdapter;
import de.vw.mib.asl.framework.internal.displaymanagement.displayoperation.SetUpdateRateOpertation;

class SetUpdateRateOpertation$1
extends AbstractDsiDisplayOperation$DSIDisplayManagementListenerAsyncExceptionAdapter {
    private final /* synthetic */ SetUpdateRateOpertation this$0;

    SetUpdateRateOpertation$1(SetUpdateRateOpertation setUpdateRateOpertation) {
        this.this$0 = setUpdateRateOpertation;
        super(setUpdateRateOpertation);
    }

    @Override
    public void setUpdateRateResult(int n, int n2) {
        this.this$0.reportSuccess();
        if (this.this$0.getLogger().isTraceEnabled(4096)) {
            this.this$0.getLogger().trace(4096, new StringBuffer().append("[ SetDisplayTypeOperation ] The DSI display operation with displayId >").append(n).append("< and updaterate >").append(n2).append("<").append(" is finished.").toString());
        }
    }
}

