/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.api.impl.speech;

import de.vw.mib.asl.api.speechengine.messenger.dialog.DialogStateConsumer;
import de.vw.mib.asl.internal.radio.RadioServiceManager;

final class RadioSpeechDialogStateConsumer
implements DialogStateConsumer {
    RadioSpeechDialogStateConsumer() {
    }

    @Override
    public void onDialogStateChanged(int n) {
        if (2 == n) {
            RadioServiceManager.getServiceManager().getRadioAmFMTarget().fireModelStopScanOrSeekEvent();
        }
    }
}

