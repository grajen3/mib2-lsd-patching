/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands.search;

import de.vw.mib.asl.internal.media.browser.headunit.MediaMainBrowser;
import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;

public class CmdSetCursorPos
extends AbstractCommand {
    private static int TIMEOUT = 6000;
    private static final int STEP_1_SET_CURSOR_POSITION;
    private final MediaMainBrowser mMainBrowser;
    private final int mCursorPosition;

    public CmdSetCursorPos(MediaMainBrowser mediaMainBrowser, int n) {
        super(32, 0, 0, TIMEOUT);
        this.mMainBrowser = mediaMainBrowser;
        this.mCursorPosition = n;
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 0: {
                this.mMainBrowser.setCursorPosition(this.mCursorPosition);
                this.nextStep();
                break;
            }
        }
    }

    @Override
    protected String getStepStr(int n) {
        switch (n) {
            case 0: {
                return "SET_CURSOR_POSITION";
            }
        }
        return null;
    }

    @Override
    protected String getParameterStr() {
        return new StringBuffer().append("cursorPosition: ").append(this.mCursorPosition).toString();
    }
}

