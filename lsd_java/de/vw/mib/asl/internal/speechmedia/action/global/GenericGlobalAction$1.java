/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.action.global;

import de.vw.mib.asl.api.media.services.Callback;
import de.vw.mib.asl.api.media.services.ResultCode;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.speechmedia.action.global.GenericGlobalAction;

class GenericGlobalAction$1
implements Callback {
    private final /* synthetic */ GenericGlobalAction this$0;

    GenericGlobalAction$1(GenericGlobalAction genericGlobalAction) {
        this.this$0 = genericGlobalAction;
    }

    @Override
    public void response(ResultCode resultCode) {
        if (this.this$0.logger.isTraceEnabled()) {
            this.this$0.logger.trace("Media activated. Proceed with use case.");
        }
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-1014943232);
    }
}

