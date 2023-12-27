/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound;

import de.vw.mib.asl.framework.api.persistence2.dsi.DsiAwareProfileChangeListener;
import de.vw.mib.asl.framework.api.persistence2.dsi.DsiAwareProfileChangeListenerCallback;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.sound.ASLSoundData;
import de.vw.mib.asl.internal.sound.SoundPersistence;
import de.vw.mib.genericevents.EventGeneric;

class SoundPersistence$1
implements DsiAwareProfileChangeListener {
    private final /* synthetic */ SoundPersistence this$0;

    SoundPersistence$1(SoundPersistence soundPersistence) {
        this.this$0 = soundPersistence;
    }

    @Override
    public void prepareForProfileChange(DsiAwareProfileChangeListenerCallback dsiAwareProfileChangeListenerCallback) {
        dsiAwareProfileChangeListenerCallback.notifyTaskDone(true);
    }

    @Override
    public void changeProfilePreDsi(DsiAwareProfileChangeListenerCallback dsiAwareProfileChangeListenerCallback) {
        ASLSoundData.initSoundSettings();
        if (!this.this$0.profileChanceWithAudioMuteClampOngoing) {
            ServiceManager.logger.info(16).append("SoundP detected MUTE_PERSONALIZATION not active. Save the world.").log();
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(34159872);
            eventGeneric.setInt(0, 206);
            ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
            this.this$0.mutepersonalizationTriggeredByMe = true;
        }
        dsiAwareProfileChangeListenerCallback.notifyTaskDone(true);
    }

    @Override
    public void changeProfilePostDsi(DsiAwareProfileChangeListenerCallback dsiAwareProfileChangeListenerCallback) {
        this.this$0.loadPersistence2_0();
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1305144064, -1305144064, -1534721792);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
        if (this.this$0.mutepersonalizationTriggeredByMe) {
            ServiceManager.logger.info(16).append("SoundP release my MUTE_PERSONALIZATION").log();
            EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(67714304);
            eventGeneric2.setInt(0, 206);
            ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric2);
            this.this$0.mutepersonalizationTriggeredByMe = false;
        }
        dsiAwareProfileChangeListenerCallback.notifyTaskDone(true);
    }
}

