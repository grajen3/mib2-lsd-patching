/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.keypanel;

import de.vw.mib.asl.framework.api.persistence2.AbstractProfileChangeHandler;
import de.vw.mib.asl.internal.system.keypanel.SensorKeyToneManager;

class SensorKeyToneManager$4
extends AbstractProfileChangeHandler {
    private final /* synthetic */ SensorKeyToneManager this$0;

    SensorKeyToneManager$4(SensorKeyToneManager sensorKeyToneManager) {
        this.this$0 = sensorKeyToneManager;
    }

    @Override
    protected void prepareForProfileChange() {
        this.notifyReadyForProfileSwitch();
    }

    @Override
    protected void changeProfile() {
        this.this$0.loadPersistenceData();
        this.notifyProfileChanged(true);
    }
}

