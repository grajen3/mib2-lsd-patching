/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.contacts.controller;

import de.vw.mib.asl.internal.speechnavigation.usecase.common.HelpControllerBase;

public class NavigateContactHelpController
extends HelpControllerBase {
    public static final int CMD_NAVIGATE_CONTACT_HELP;

    public NavigateContactHelpController() {
        super(1809920832);
    }

    @Override
    protected void onHelp() {
        this.fireEvent(-1811401728);
    }
}

