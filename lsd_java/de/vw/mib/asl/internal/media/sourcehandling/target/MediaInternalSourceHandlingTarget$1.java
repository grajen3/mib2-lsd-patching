/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.sourcehandling.target;

import de.vw.mib.asl.framework.api.entertainmentmanager.participant.EntertainmentManagerParticipantService;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentAPICallback;
import de.vw.mib.asl.internal.media.sourcehandling.target.MediaInternalSourceHandlingTarget;

class MediaInternalSourceHandlingTarget$1
implements ASLComponentAPICallback {
    private final /* synthetic */ MediaInternalSourceHandlingTarget this$0;

    MediaInternalSourceHandlingTarget$1(MediaInternalSourceHandlingTarget mediaInternalSourceHandlingTarget) {
        this.this$0 = mediaInternalSourceHandlingTarget;
    }

    @Override
    public void registered(Class clazz, Object object) {
        EntertainmentManagerParticipantService entertainmentManagerParticipantService = (EntertainmentManagerParticipantService)object;
        entertainmentManagerParticipantService.registerParticipant(2, this.this$0);
    }
}

