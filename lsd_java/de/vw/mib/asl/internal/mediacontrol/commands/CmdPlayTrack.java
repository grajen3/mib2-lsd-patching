/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.commands;

import de.vw.mib.asl.internal.mediacontrol.common.commands.AbstractCommand;
import de.vw.mib.asl.internal.mediacontrol.components.browser.Browser;
import de.vw.mib.asl.internal.mediacontrol.components.player.Player;
import org.dsi.ifc.upnp.ListEntry;

public final class CmdPlayTrack
extends AbstractCommand {
    private static int TIMEOUT = 10000;
    private static final int STEP_0_PLAY_TRACK;
    private final Player mPlayer;
    private final Browser mBrowser;
    private final String[] mDeviceId;
    private final String mEntryId;

    public CmdPlayTrack(Player player, Browser browser, String[] stringArray, String string) {
        super(1, 1, 1, TIMEOUT);
        this.mPlayer = player;
        this.mBrowser = browser;
        this.mDeviceId = stringArray;
        this.mEntryId = string;
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1: {
                ListEntry[] listEntryArray = this.mBrowser.getState().getFolderPath();
                this.mPlayer.rqPlayEntry(this.mDeviceId, listEntryArray, this.mEntryId, this.NEXT_STEP);
                return;
            }
        }
    }

    @Override
    protected String getStepStr(int n) {
        switch (n) {
            case 1: {
                return "PLAY_TRACK";
            }
        }
        return "UNKNOWN";
    }

    @Override
    protected String getParameterStr() {
        return new StringBuffer().append("deviceId: ").append(this.mDeviceId).append(" entryId: ").append(this.mEntryId).toString();
    }
}

