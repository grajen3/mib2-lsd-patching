/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.controller;

import de.vw.mib.asl.internal.speechnavigation.usecase.common.HelpControllerBase;

public class OnboardPOIHelpController
extends HelpControllerBase {
    public static final int CMD_POI_SEARCH_HELP;

    public OnboardPOIHelpController() {
        super(1826698048);
    }

    @Override
    protected void onHelp() {
        this.fireEvent(-1794624512);
    }
}

