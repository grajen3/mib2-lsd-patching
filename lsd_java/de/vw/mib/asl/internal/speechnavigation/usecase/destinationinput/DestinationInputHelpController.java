/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput;

import de.vw.mib.asl.internal.speechnavigation.usecase.common.HelpControllerBase;

public class DestinationInputHelpController
extends HelpControllerBase {
    public static final int CMD_DESTINATION_INPUT_HELP;

    public DestinationInputHelpController(int n) {
        super(n);
    }

    public DestinationInputHelpController() {
        super(1877029696);
    }

    @Override
    protected void onHelp() {
        this.fireEvent(-1761070080);
    }
}

