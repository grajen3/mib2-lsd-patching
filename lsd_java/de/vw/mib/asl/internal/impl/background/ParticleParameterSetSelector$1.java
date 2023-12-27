/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.background;

import de.vw.mib.asl.internal.impl.background.ParticleParameterSetSelector;
import de.vw.mib.desktop.DesktopInformationReceiver;
import java.util.List;

class ParticleParameterSetSelector$1
implements DesktopInformationReceiver {
    private final /* synthetic */ ParticleParameterSetSelector this$0;

    ParticleParameterSetSelector$1(ParticleParameterSetSelector particleParameterSetSelector) {
        this.this$0 = particleParameterSetSelector;
    }

    @Override
    public void receiveViewNameList(List list) {
        this.this$0.updateParticleParameters(list);
    }
}

