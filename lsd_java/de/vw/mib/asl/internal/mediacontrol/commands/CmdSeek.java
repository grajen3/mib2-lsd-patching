/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.commands;

import de.vw.mib.asl.internal.mediacontrol.adapter.views.Helper;
import de.vw.mib.asl.internal.mediacontrol.common.commands.AbstractCommand;
import de.vw.mib.asl.internal.mediacontrol.common.commands.Command;
import de.vw.mib.asl.internal.mediacontrol.components.player.Player;

public final class CmdSeek
extends AbstractCommand {
    private static int TIMEOUT = 5000;
    private static final int STEP_1_START_SEEK;
    private static final int STEP_2_ABORT_SEEK;
    private final Player mPlayer;
    private final String mDeviceId;
    private final int mDirection;

    private CmdSeek(Player player, String string, int n) {
        super(1, 0, 1, TIMEOUT);
        this.mPlayer = player;
        this.mDeviceId = string;
        this.mDirection = n;
    }

    public static Command createSeekFw(Player player, String string) {
        return new CmdSeek(player, string, 0);
    }

    public static Command createSeekBw(Player player, String string) {
        return new CmdSeek(player, string, 1);
    }

    @Override
    protected void execute(int n) {
        switch (n) {
            case 0: {
                this.suspendTimer("seek running");
                this.mPlayer.rqSeek(this.mDeviceId, this.mDirection, this.NEXT_STEP);
                return;
            }
            case 1: {
                this.resumeTimer();
                this.mPlayer.rqResume(this.mDeviceId, this.NEXT_STEP);
                return;
            }
        }
    }

    @Override
    protected String getParameterStr() {
        return new StringBuffer().append("deviceId: ").append(this.mDeviceId).append(", direction = ").append(Helper.getDirectionStr(this.mDirection)).toString();
    }

    @Override
    protected String getStepStr(int n) {
        switch (n) {
            case 0: {
                return "SEEK";
            }
            case 1: {
                return "ABORT_SEEK";
            }
        }
        return "UNKNOWN";
    }
}

