/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm.factoryreset;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.internal.exboxm.persistence.PersistableExBoxOptions;
import org.dsi.ifc.exboxm.DSIExBoxM;

public class SystemFactoryResetParticipant
extends AbstractFactoryResetParticipant {
    private final DSIExBoxM dsiExBoxM;
    private final PersistableExBoxOptions persistableExboxOptions;

    public SystemFactoryResetParticipant(DSIExBoxM dSIExBoxM, PersistableExBoxOptions persistableExBoxOptions) {
        this.dsiExBoxM = dSIExBoxM;
        this.persistableExboxOptions = persistableExBoxOptions;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        this.dsiExBoxM.resetToFactory();
        this.persistableExboxOptions.factoryReset();
        factoryResetCallback.notifyResetDone();
    }
}

