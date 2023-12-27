/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.spellerx.handler;

import de.vw.mib.asl.api.navigation.locationinput.ISpellerContext;
import de.vw.mib.asl.api.navigation.locationinput.SpellerHandler;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;

public class SldeInputHandler
implements SpellerHandler {
    @Override
    public void onActivated(ISpellerContext iSpellerContext) {
        ServiceManager.logger.info(16384).append(super.getClass().getName()).append("onActivated(").append(iSpellerContext).append(");").log();
    }

    @Override
    public void onLocationSaved(ISpellerContext iSpellerContext) {
        ServiceManager.logger.info(16384).append(super.getClass().getName()).append("onLocationSaved(").append(iSpellerContext).append(");").log();
    }

    @Override
    public void onLocationDiscarded(ISpellerContext iSpellerContext) {
        ServiceManager.logger.info(16384).append(super.getClass().getName()).append("onLocationDiscarded(").append(iSpellerContext).append(");").log();
    }

    @Override
    public void onContext(ISpellerContext iSpellerContext) {
        ServiceManager.logger.info(16384).append(super.getClass().getName()).append("onContext(").append(iSpellerContext).append(");").log();
    }
}

