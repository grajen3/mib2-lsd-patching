/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.keypanel;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.internal.system.keypanel.SensorKeyToneManager;

class SensorKeyToneManager$5
extends AbstractFactoryResetParticipant {
    private final /* synthetic */ SensorKeyToneManager this$0;

    SensorKeyToneManager$5(SensorKeyToneManager sensorKeyToneManager) {
        this.this$0 = sensorKeyToneManager;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        this.this$0.performFactoryReset();
        factoryResetCallback.notifyResetDone();
    }
}

