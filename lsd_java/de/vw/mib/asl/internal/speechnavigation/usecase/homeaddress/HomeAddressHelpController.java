/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.homeaddress;

import de.vw.mib.asl.internal.speechnavigation.usecase.common.HelpControllerBase;

public class HomeAddressHelpController
extends HelpControllerBase {
    public static final int CMD_HOME_HELP;

    public HomeAddressHelpController() {
        super(1776366400);
    }

    @Override
    protected void onHelp() {
        this.fireEvent(-1878510592);
    }
}

