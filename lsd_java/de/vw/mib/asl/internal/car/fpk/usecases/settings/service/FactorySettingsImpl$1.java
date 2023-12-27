/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk.usecases.settings.service;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.internal.car.fpk.usecases.settings.service.FactorySettingsImpl;

class FactorySettingsImpl$1
extends AbstractFactoryResetParticipant {
    private final /* synthetic */ FactorySettingsImpl this$0;

    FactorySettingsImpl$1(FactorySettingsImpl factorySettingsImpl) {
        this.this$0 = factorySettingsImpl;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        this.this$0.reset();
        factoryResetCallback.notifyResetDone();
    }
}

