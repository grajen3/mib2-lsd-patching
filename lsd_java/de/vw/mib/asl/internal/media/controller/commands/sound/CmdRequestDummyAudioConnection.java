/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands.sound;

import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;
import de.vw.mib.asl.internal.media.sound.MediaAudioManager;

public class CmdRequestDummyAudioConnection
extends AbstractCommand {
    private static int TIMEOUT = 15000;
    private final MediaAudioManager sound;

    public CmdRequestDummyAudioConnection(MediaAudioManager mediaAudioManager) {
        super(4, 1, 1, TIMEOUT);
        this.sound = mediaAudioManager;
    }

    @Override
    protected void execute(int n) {
        switch (n) {
            case 1: {
                this.sound.rqDummyAudioConnection(this.NEXT_STEP);
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

