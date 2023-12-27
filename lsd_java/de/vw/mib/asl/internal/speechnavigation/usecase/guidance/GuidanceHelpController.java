/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.guidance;

import de.vw.mib.asl.internal.speechnavigation.usecase.common.HelpControllerBase;

public class GuidanceHelpController
extends HelpControllerBase {
    public static final int CMD_ROUTE_HELP;

    public GuidanceHelpController() {
        super(1860252480);
    }

    @Override
    protected void onHelp() {
        this.fireEvent(-1844956160);
    }
}

