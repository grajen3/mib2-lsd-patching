/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.sound;

import de.vw.mib.asi.ASIService;
import de.vw.mib.asi.sound.ASISoundListener;
import de.vw.mib.asi.sound.ASISoundResponse;

public interface ASISound
extends ASIService {
    default public ASISoundListener getASISoundListener() {
    }

    default public void setASISoundListener(ASISoundListener aSISoundListener) {
    }

    default public void setBassValue(int n, ASISoundResponse aSISoundResponse) {
    }

    default public void setTrebleValue(int n, ASISoundResponse aSISoundResponse) {
    }

    default public void setBalanceValue(int n, ASISoundResponse aSISoundResponse) {
    }

    default public void setFaderValue(int n, ASISoundResponse aSISoundResponse) {
    }

    default public void setSubwooferValue(int n, ASISoundResponse aSISoundResponse) {
    }

    default public void setSurroundValue(int n, ASISoundResponse aSISoundResponse) {
    }

    default public void setNoiseCompensationValue(int n, ASISoundResponse aSISoundResponse) {
    }

    default public void setPresetPosition(int n, ASISoundResponse aSISoundResponse) {
    }
}

