/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.androidauto.target;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.androidauto.target.AudioHandler;
import de.vw.mib.genericevents.EventGeneric;

class AudioHandler$1
implements Runnable {
    private final /* synthetic */ AudioHandler this$0;

    AudioHandler$1(AudioHandler audioHandler) {
        this.this$0 = audioHandler;
    }

    @Override
    public void run() {
        if (this.this$0.target.isTraceEnabled()) {
            this.this$0.target.trace("=> starting FadeIn GAL Media...");
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(50937088);
        eventGeneric.setInt(0, 156);
        this.this$0.target.sendSafe(eventGeneric);
    }
}

