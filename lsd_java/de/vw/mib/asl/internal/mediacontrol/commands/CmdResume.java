/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.commands;

import de.vw.mib.asl.internal.mediacontrol.common.commands.AbstractCommand;
import de.vw.mib.asl.internal.mediacontrol.components.player.Player;

public final class CmdResume
extends AbstractCommand {
    private static int TIMEOUT = 10000;
    private static final int STEP_0_RESUME;
    private final Player mPlayer;
    private final String mDeviceId;

    public CmdResume(Player player, String string) {
        super(1, 1, 1, TIMEOUT);
        this.mPlayer = player;
        this.mDeviceId = string;
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1: {
                this.mPlayer.rqResume(this.mDeviceId, this.NEXT_STEP);
                return;
            }
        }
    }

    @Override
    protected String getStepStr(int n) {
        switch (n) {
            case 1: {
                return "RESUME";
            }
        }
        return "UNKNOWN";
    }

    @Override
    protected String getParameterStr() {
        return new StringBuffer().append("deviceId: ").append(this.mDeviceId).toString();
    }
}

