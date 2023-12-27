/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.sui.controller;

import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.sui.controller.SUIMainControllerBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.sui.service.SUICheckerService;

public class SUIMainNavigateContactController
extends SUIMainControllerBase {
    public static final int CMD_NAVIGATE_CONTACT_SUI;

    public SUIMainNavigateContactController(SUICheckerService sUICheckerService) {
        super(sUICheckerService);
    }

    @Override
    public void onActionNotAvailable() {
        Framework.fireUIEvent(-603442176);
    }
}

