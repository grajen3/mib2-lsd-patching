/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands.base;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.api.media.services.Callback;
import de.vw.mib.asl.api.media.services.ResultCode;
import de.vw.mib.asl.internal.devicehandling.otherclients.EjectionTarget;
import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;

public class CmdEjectSource
extends AbstractCommand {
    private static int TIMEOUT = 3000;
    private static final int STEP_1_EJECT;
    private final EjectionTarget ejectionTarget;
    private final Device device;
    private final Callback callback;

    public CmdEjectSource(EjectionTarget ejectionTarget, Device device, Callback callback) {
        super(0, 1, 1, TIMEOUT);
        this.ejectionTarget = ejectionTarget;
        this.device = device;
        this.callback = callback;
    }

    @Override
    protected void execute(int n) {
        switch (n) {
            case 1: {
                this.ejectionTarget.requestEject(this.device, this.NEXT_STEP);
                break;
            }
        }
    }

    @Override
    protected String getParameterStr() {
        return this.device.toString();
    }

    @Override
    protected String getStepStr(int n) {
        switch (n) {
            case 1: {
                return "EJECT";
            }
        }
        return null;
    }

    @Override
    public void onExit() {
        this.ejectionTarget.cancelEject(this.device);
        if (this.callback != null) {
            this.callback.response(!this.device.getCurrentState().isMediaInSlot() ? ResultCode.OK : ResultCode.NOK);
        }
    }
}

