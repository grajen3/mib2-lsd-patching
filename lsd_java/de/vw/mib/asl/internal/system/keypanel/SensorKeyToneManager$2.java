/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.keypanel;

import de.vw.mib.asl.api.system.KeyAdapter;
import de.vw.mib.asl.internal.system.keypanel.SensorKeyToneManager;
import de.vw.mib.timer.Timer;

class SensorKeyToneManager$2
extends KeyAdapter {
    private final /* synthetic */ Timer val$volumeKeyTimer;
    private final /* synthetic */ SensorKeyToneManager this$0;

    SensorKeyToneManager$2(SensorKeyToneManager sensorKeyToneManager, Timer timer) {
        this.this$0 = sensorKeyToneManager;
        this.val$volumeKeyTimer = timer;
    }

    @Override
    public void onRotationRight(int n) {
        this.onRotation();
    }

    @Override
    public void onRotationLeft(int n) {
        this.onRotation();
    }

    private void onRotation() {
        if (!this.val$volumeKeyTimer.isRunning()) {
            this.val$volumeKeyTimer.start();
            this.this$0.sendBeep();
        }
    }
}

