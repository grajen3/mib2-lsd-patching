/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.factoryreset.participant;

import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponent;
import de.vw.mib.asl.internal.impl.system.factoryreset.participant.AbstractLegacyFactoryResetParticipant;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.util.Preconditions;

public class DefaultLegacyFactoryResetParticipant
extends AbstractLegacyFactoryResetParticipant {
    private final FactoryResetComponent component;

    public DefaultLegacyFactoryResetParticipant(SystemServices systemServices, int n, FactoryResetComponent factoryResetComponent) {
        super(systemServices, n);
        Preconditions.checkArgumentNotNull(factoryResetComponent, "Component is muissing.");
        this.component = factoryResetComponent;
    }

    @Override
    public long getCallbackTimeout() {
        return 0;
    }

    @Override
    public String getComponentName() {
        return this.component.getName();
    }
}

