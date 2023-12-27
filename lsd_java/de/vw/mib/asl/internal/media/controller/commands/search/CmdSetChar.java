/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands.search;

import de.vw.mib.asl.internal.media.browser.headunit.MediaMainBrowser;
import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;

public class CmdSetChar
extends AbstractCommand {
    private static int TIMEOUT = 6000;
    private static final int STEP_1_ADD_CHAR;
    private final MediaMainBrowser mMainBrowser;
    private final String mAddedCharacters;
    private final int mSelectionStart;
    private final int mSelectionEnd;
    private final int mCursorPosition;

    public CmdSetChar(MediaMainBrowser mediaMainBrowser, String string, int n, int n2, int n3) {
        super(32, 0, 0, TIMEOUT);
        this.mMainBrowser = mediaMainBrowser;
        this.mAddedCharacters = string;
        this.mSelectionStart = n;
        this.mSelectionEnd = n2;
        this.mCursorPosition = n3;
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 0: {
                this.mMainBrowser.rqAddChar(this.mAddedCharacters, this.mSelectionStart, this.mSelectionEnd, this.mCursorPosition, this.NEXT_STEP);
                break;
            }
        }
    }

    @Override
    protected String getStepStr(int n) {
        switch (n) {
            case 0: {
                return "ADD_CHAR";
            }
        }
        return null;
    }

    @Override
    protected String getParameterStr() {
        return new StringBuffer().append("char: ").append(this.mAddedCharacters).append(", selection: ").append(this.mSelectionStart).append("-").append(this.mSelectionEnd).append(", cursorPosition: ").append(this.mCursorPosition).toString();
    }
}

