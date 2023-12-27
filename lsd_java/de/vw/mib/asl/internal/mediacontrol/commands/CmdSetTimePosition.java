/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.commands;

import de.vw.mib.asl.internal.mediacontrol.common.commands.AbstractCommand;
import de.vw.mib.asl.internal.mediacontrol.components.player.Player;

public final class CmdSetTimePosition
extends AbstractCommand {
    private static int TIMEOUT = 10000;
    private static final int STEP_0_SET_TIME_POSITION;
    private final Player mPlayer;
    private final String mDeviceId;
    private final int mTimePosition;

    public CmdSetTimePosition(Player player, String string, int n) {
        super(1, 1, 1, TIMEOUT);
        this.mPlayer = player;
        this.mDeviceId = string;
        this.mTimePosition = n;
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1: {
                this.mPlayer.rqSetTimePosition(this.mDeviceId, this.mTimePosition, this.NEXT_STEP);
                return;
            }
        }
    }

    @Override
    protected String getStepStr(int n) {
        switch (n) {
            case 1: {
                return "SET_TIME_POSITION";
            }
        }
        return "UNKNOWN";
    }

    @Override
    protected String getParameterStr() {
        return new StringBuffer().append("deviceId: ").append(this.mDeviceId).append(" timePosition:").append(this.mTimePosition).toString();
    }
}

