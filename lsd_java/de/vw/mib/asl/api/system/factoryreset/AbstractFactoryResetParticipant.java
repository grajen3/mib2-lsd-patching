/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.system.factoryreset;

import de.vw.mib.asl.api.system.factoryreset.FactoryResetParticipant;

public abstract class AbstractFactoryResetParticipant
implements FactoryResetParticipant {
    @Override
    public long getTimeout() {
        return 0;
    }
}

