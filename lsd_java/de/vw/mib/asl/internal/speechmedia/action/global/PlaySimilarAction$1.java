/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.action.global;

import de.vw.mib.asl.api.media.services.Callback;
import de.vw.mib.asl.api.media.services.ResultCode;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.speechmedia.action.global.PlaySimilarAction;

class PlaySimilarAction$1
implements Callback {
    private final /* synthetic */ PlaySimilarAction this$0;

    PlaySimilarAction$1(PlaySimilarAction playSimilarAction) {
        this.this$0 = playSimilarAction;
    }

    @Override
    public void response(ResultCode resultCode) {
        if (resultCode == ResultCode.NOK) {
            AbstractASLHsmTarget.writeIntegerToDatapool(-863948288, 0);
        } else {
            AbstractASLHsmTarget.writeIntegerToDatapool(-863948288, this.this$0.msController.getPlayViewSize());
        }
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(this.this$0.getSuccessEvent());
    }
}

