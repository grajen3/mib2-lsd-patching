/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.titles.controller;

import de.vw.mib.asl.api.media.services.Callback;
import de.vw.mib.asl.api.media.services.ResultCode;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.speechmedia.titles.controller.SelectTrackAction;

class SelectTrackAction$1
implements Callback {
    private final /* synthetic */ SelectTrackAction this$0;

    SelectTrackAction$1(SelectTrackAction selectTrackAction) {
        this.this$0 = selectTrackAction;
    }

    @Override
    public void response(ResultCode resultCode) {
        if (resultCode == ResultCode.OK) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-595512832);
        } else {
            this.this$0.msContr.doFatalError();
        }
    }
}

