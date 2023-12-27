/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.factoryreset.participant;

import de.vw.mib.asl.api.car.pso.PersonalizationService;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.internal.impl.system.factoryreset.participant.AbstractLegacyFactoryResetParticipant;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.timer.Timer;

public class PersonalizationFactoryResetParticipant
extends AbstractLegacyFactoryResetParticipant {
    private final PersonalizationService personalizationService;

    public PersonalizationFactoryResetParticipant(SystemServices systemServices) {
        super(systemServices, -56868608);
        this.personalizationService = systemServices.getPersonalizationService();
    }

    @Override
    public long getCallbackTimeout() {
        return 0;
    }

    @Override
    public String getComponentName() {
        return "Personalization";
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        this.resetPersonalization();
        Timer timer = this.createTimer(this.getComponentName(), this.getCallbackTimeout(), this.createDefaultCallbackRunnable(factoryResetCallback));
        timer.start();
    }

    private void resetPersonalization() {
        boolean bl;
        int n = this.personalizationService.getResetState();
        boolean bl2 = bl = n == 3;
        if (bl) {
            this.triggerObserver();
        } else {
            this.logWarn(new StringBuffer().append("Unable to reset personalization! Personalization reset state was:").append(n).toString());
        }
    }
}

