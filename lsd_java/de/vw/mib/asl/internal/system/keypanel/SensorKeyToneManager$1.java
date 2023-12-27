/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.keypanel;

import de.vw.mib.asl.api.system.KeyAdapter;
import de.vw.mib.asl.internal.system.keypanel.SensorKeyToneManager;

class SensorKeyToneManager$1
extends KeyAdapter {
    private final /* synthetic */ SensorKeyToneManager this$0;

    SensorKeyToneManager$1(SensorKeyToneManager sensorKeyToneManager) {
        this.this$0 = sensorKeyToneManager;
    }

    @Override
    public void onPressed(int n) {
        this.this$0.sendBeep();
    }
}

