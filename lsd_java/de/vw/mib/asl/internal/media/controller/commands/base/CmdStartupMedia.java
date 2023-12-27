/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands.base;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.accessor.MediaObjectAccessor;
import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;
import de.vw.mib.asl.internal.media.targets.TargetMediaStartup;
import de.vw.mib.genericevents.GenericEvents;

public class CmdStartupMedia
extends AbstractCommand {
    private final TargetMediaStartup targetMediaStartup;

    public CmdStartupMedia() {
        super(-1, 1, 1, -2131872256);
        GenericEvents genericEvents = ServiceManager.eventMain;
        String string = "hsmtask";
        this.targetMediaStartup = MediaObjectAccessor.mMediaController.mStartup != null ? MediaObjectAccessor.mMediaController.mStartup : new TargetMediaStartup(genericEvents, "hsmtask");
    }

    @Override
    protected void execute(int n) {
        switch (n) {
            case 1: {
                this.targetMediaStartup.rqPowerOn(this.NEXT_STEP);
                break;
            }
        }
    }

    @Override
    protected String getParameterStr() {
        return null;
    }

    @Override
    protected String getStepStr(int n) {
        return null;
    }
}

