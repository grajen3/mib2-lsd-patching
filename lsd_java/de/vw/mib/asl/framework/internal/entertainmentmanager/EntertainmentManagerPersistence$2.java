/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.entertainmentmanager;

import de.vw.mib.asl.framework.api.entertainmentmanager.participant.EntertainmentManagerParticipantService;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence2.GlobalProfileChangeListener;
import de.vw.mib.asl.framework.internal.entertainmentmanager.EntertainmentManagerPersistence;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.genericevents.EventGeneric;

class EntertainmentManagerPersistence$2
implements GlobalProfileChangeListener {
    private final /* synthetic */ EntertainmentManagerPersistence this$0;

    EntertainmentManagerPersistence$2(EntertainmentManagerPersistence entertainmentManagerPersistence) {
        this.this$0 = entertainmentManagerPersistence;
    }

    @Override
    public void onProfileChangeStarted() {
        this.muteConnection(true);
    }

    @Override
    public void onProfileChangeCompleted() {
        int n;
        EntertainmentManagerParticipantService entertainmentManagerParticipantService = (EntertainmentManagerParticipantService)ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().getAPIInstance(EntertainmentManagerPersistence.class$de$vw$mib$asl$framework$api$entertainmentmanager$participant$EntertainmentManagerParticipantService == null ? (EntertainmentManagerPersistence.class$de$vw$mib$asl$framework$api$entertainmentmanager$participant$EntertainmentManagerParticipantService = EntertainmentManagerPersistence.class$("de.vw.mib.asl.framework.api.entertainmentmanager.participant.EntertainmentManagerParticipantService")) : EntertainmentManagerPersistence.class$de$vw$mib$asl$framework$api$entertainmentmanager$participant$EntertainmentManagerParticipantService);
        if (entertainmentManagerParticipantService.isRegistered(n = EntertainmentManagerPersistence.access$000(this.this$0).getContext())) {
            entertainmentManagerParticipantService.requestContext(n);
        }
        this.muteConnection(false);
    }

    private void muteConnection(boolean bl) {
        if (ServiceManager.logger2.isTraceEnabled(16)) {
            ServiceManager.logger2.trace(16).append("muteConnection CL_FCT_AMP_MUTE_PERSONALIZATION ").append(bl).log();
        }
        int n = bl ? 34159872 : 67714304;
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(n);
        eventGeneric.setInt(0, 206);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }
}

