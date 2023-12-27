/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.infotainmentrecorder.backuptrigger;

import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.infotainmentrecorder.backuptrigger.BackupService;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.infotainmentrecorder.DSIInfotainmentRecorder;

public class BackupServiceImpl
implements BackupService {
    private final GenericEvents genericEvents;
    private DSIInfotainmentRecorder dsiInfotainmentRecorder;

    public BackupServiceImpl(DSIInfotainmentRecorder dSIInfotainmentRecorder, Services services) {
        this.genericEvents = services.getGenericEvents();
        this.dsiInfotainmentRecorder = dSIInfotainmentRecorder;
    }

    @Override
    public void backup() {
        this.dsiInfotainmentRecorder.backupTrigger(63);
        this.createBeep();
    }

    private void createBeep() {
        EventGeneric eventGeneric = this.genericEvents.getEventFactory().newEvent(638139648);
        eventGeneric.setInt(0, 1);
        this.genericEvents.getEventDispatcher().sendSafe(eventGeneric);
    }
}

