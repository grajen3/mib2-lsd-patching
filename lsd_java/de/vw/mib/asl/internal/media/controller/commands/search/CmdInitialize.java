/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands.search;

import de.vw.mib.asl.internal.media.browser.headunit.MediaMainBrowser;
import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;

public class CmdInitialize
extends AbstractCommand {
    private static int TIMEOUT = 6000;
    private static final int STEP_1_INIT_SPELLER;
    private final MediaMainBrowser mMainBrowser;

    public CmdInitialize(MediaMainBrowser mediaMainBrowser) {
        super(32, 0, 0, TIMEOUT);
        this.mMainBrowser = mediaMainBrowser;
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 0: {
                this.mMainBrowser.rqActivateSearchSpeller(this.NEXT_STEP);
                return;
            }
        }
    }

    @Override
    protected String getStepStr(int n) {
        switch (n) {
            case 0: {
                return "INIT_SPELLER";
            }
        }
        return null;
    }

    @Override
    protected String getParameterStr() {
        return null;
    }
}

