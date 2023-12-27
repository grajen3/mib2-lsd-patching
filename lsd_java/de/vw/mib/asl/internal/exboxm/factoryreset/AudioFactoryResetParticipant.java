/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm.factoryreset;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.internal.exboxm.ExBoxMVolume;
import org.dsi.ifc.audio.DSISound;

public class AudioFactoryResetParticipant
extends AbstractFactoryResetParticipant {
    private final DSISound dsiSound;
    private final ExBoxMVolume exboxVolume;

    public AudioFactoryResetParticipant(DSISound dSISound, ExBoxMVolume exBoxMVolume) {
        this.dsiSound = dSISound;
        this.exboxVolume = exBoxMVolume;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        this.exboxVolume.requestVolumeRanges(this.dsiSound);
        factoryResetCallback.notifyResetDone();
    }
}

