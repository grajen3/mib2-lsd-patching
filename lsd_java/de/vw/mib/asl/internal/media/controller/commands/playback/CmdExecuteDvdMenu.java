/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands.playback;

import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlaybackResume;
import de.vw.mib.asl.internal.media.playback.MediaVideoPlayer;
import de.vw.mib.asl.internal.media.sound.MediaAudioManager;

public class CmdExecuteDvdMenu
extends AbstractCommand {
    private static int TIMEOUT = 8000;
    private static final int STEP_0_EXECUTE_MENU_CMD;
    private static final int STEP_1_RESUME;
    private final MediaVideoPlayer mPlayer;
    private final MediaAudioManager mSound;
    private final int mMenuCmd;

    public CmdExecuteDvdMenu(MediaVideoPlayer mediaVideoPlayer, MediaAudioManager mediaAudioManager, int n) {
        super(6, 0, 1, TIMEOUT);
        this.mPlayer = mediaVideoPlayer;
        this.mSound = mediaAudioManager;
        this.mMenuCmd = n;
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 0: {
                boolean bl = this.mSound.isMediaOnTop();
                this.mPlayer.rqExecuteMenuCmd(this.mMenuCmd, bl, this.NEXT_STEP);
                return;
            }
            case 1: {
                this.rqExecuteCmd(new CmdPlaybackResume(this.mPlayer, this.mSound), this.NEXT_STEP);
                return;
            }
        }
    }

    @Override
    protected String getStepStr(int n) {
        switch (n) {
            case 0: {
                return "EXECUTE_MENU_CMD";
            }
            case 1: {
                return "RESUME";
            }
        }
        return null;
    }

    @Override
    protected String getParameterStr() {
        return new StringBuffer().append("menuCmd: ").append(this.getMenuCommandStr(this.mMenuCmd)).toString();
    }

    private String getMenuCommandStr(int n) {
        switch (n) {
            case 0: {
                return "TITLE";
            }
            case 1: {
                return "ROOT";
            }
            case 2: {
                return "ENTER";
            }
            case 3: {
                return "UP";
            }
            case 4: {
                return "DOWN";
            }
            case 5: {
                return "RIGHT";
            }
            case 6: {
                return "LEFT";
            }
            case 7: {
                return "BACK";
            }
            case 8: {
                return "NEXTCHAPTER";
            }
            case 9: {
                return "PREVIOUSCHAPTER";
            }
        }
        return "UNKNOWN_MENU_COMMAND";
    }
}

