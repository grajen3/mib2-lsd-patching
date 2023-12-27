/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.commands;

import de.vw.mib.asl.internal.mediacontrol.common.commands.AbstractCommand;
import de.vw.mib.asl.internal.mediacontrol.components.player.Player;

public final class CmdSkip
extends AbstractCommand {
    private static int TIMEOUT = 10000;
    private static final int STEP_0_SKIP;
    private final Player mPlayer;
    private final String mDeviceId;
    private final int mOffset;
    private final boolean mConsiderTimePos;

    public CmdSkip(Player player, String string, int n, boolean bl) {
        super(1, 1, 1, TIMEOUT);
        this.mPlayer = player;
        this.mDeviceId = string;
        this.mOffset = n;
        this.mConsiderTimePos = bl;
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1: {
                this.mPlayer.rqSkip(this.mDeviceId, this.mOffset, this.mConsiderTimePos, this.NEXT_STEP);
                return;
            }
        }
    }

    @Override
    protected String getStepStr(int n) {
        switch (n) {
            case 1: {
                return "PAUSE";
            }
        }
        return "UNKNOWN";
    }

    @Override
    protected String getParameterStr() {
        return new StringBuffer().append("deviceId:").append(this.mDeviceId).append(", offset:").append(this.mOffset).append(", considerTimePos:").append(this.mConsiderTimePos).toString();
    }
}

