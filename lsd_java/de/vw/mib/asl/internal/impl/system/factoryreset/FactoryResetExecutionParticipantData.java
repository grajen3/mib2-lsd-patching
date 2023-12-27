/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.factoryreset;

import de.vw.mib.asl.api.system.factoryreset.FactoryResetParticipant;
import de.vw.mib.asl.internal.system.util.Preconditions;

class FactoryResetExecutionParticipantData {
    private final String componentName;
    private final FactoryResetParticipant[] participants;
    private final int trigger;

    FactoryResetExecutionParticipantData(int n, String string, FactoryResetParticipant[] factoryResetParticipantArray) {
        this.checkTrigger(n);
        Preconditions.checkNotNullOrEmpty(string, "Component name must be set.");
        Preconditions.checkArgumentNotNull(factoryResetParticipantArray, "Participants must be set.");
        Preconditions.checkArgument(factoryResetParticipantArray.length > 0, "Participants must not be empty.");
        this.trigger = n;
        this.componentName = string;
        this.participants = factoryResetParticipantArray;
    }

    String getComponentName() {
        return this.componentName;
    }

    FactoryResetParticipant[] getParticipants() {
        return this.participants;
    }

    int getTrigger() {
        return this.trigger;
    }

    private void checkTrigger(int n) {
        if (n != 0 && n != 1) {
            throw new IllegalArgumentException(new StringBuffer().append("Unknown trigger >").append(n).append("<.").toString());
        }
    }
}

