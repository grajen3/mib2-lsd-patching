/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound.api.impl;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.sound.SoundUtil;
import de.vw.mib.genericevents.EventGeneric;

public class ASLSoundServices
implements de.vw.mib.asl.api.sound.ASLSoundServices {
    @Override
    public int getConnectionCarPlayRingtone() {
        return SoundUtil.getConnectionCarPlayRingtone();
    }

    @Override
    public int getConnectionNavInternal() {
        return 0;
    }

    @Override
    public int getConnectionEntLoweringAPS() {
        return 0;
    }

    @Override
    public void createBeep(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(638139648);
        eventGeneric.setInt(0, n);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }
}

