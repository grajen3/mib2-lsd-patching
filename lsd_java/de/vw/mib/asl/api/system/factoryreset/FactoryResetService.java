/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.system.factoryreset;

import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponent;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetListener;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetParticipant;

public interface FactoryResetService {
    public static final int STATE_NOT_RUNNING;
    public static final int STATE_RUNNING;

    default public void addGlobalParticipant(FactoryResetParticipant factoryResetParticipant) {
    }

    default public void addListener(FactoryResetListener factoryResetListener) {
    }

    default public void addParticipant(FactoryResetParticipant factoryResetParticipant, FactoryResetComponent factoryResetComponent) {
    }

    default public int getFactoryResetState() {
    }

    default public void removeListener(FactoryResetListener factoryResetListener) {
    }

    default public void removeGlobalParticipant(FactoryResetParticipant factoryResetParticipant) {
    }

    default public void removeParticipant(FactoryResetParticipant factoryResetParticipant, FactoryResetComponent factoryResetComponent) {
    }

    default public void reset(FactoryResetComponent factoryResetComponent, int n) {
    }
}

