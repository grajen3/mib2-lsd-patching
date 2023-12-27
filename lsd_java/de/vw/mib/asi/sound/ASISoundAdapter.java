/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.sound;

import de.vw.mib.asi.sound.ASISound;
import de.vw.mib.asi.sound.ASISoundListener;
import de.vw.mib.asi.sound.ASISoundResponse;

public class ASISoundAdapter
implements ASISound {
    protected ASISoundListener listener;

    @Override
    public ASISoundListener getASISoundListener() {
        return this.listener;
    }

    @Override
    public void setASISoundListener(ASISoundListener aSISoundListener) {
        this.listener = aSISoundListener;
    }

    @Override
    public void setBassValue(int n, ASISoundResponse aSISoundResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void setTrebleValue(int n, ASISoundResponse aSISoundResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void setBalanceValue(int n, ASISoundResponse aSISoundResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void setFaderValue(int n, ASISoundResponse aSISoundResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void setSubwooferValue(int n, ASISoundResponse aSISoundResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void setSurroundValue(int n, ASISoundResponse aSISoundResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void setNoiseCompensationValue(int n, ASISoundResponse aSISoundResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void setPresetPosition(int n, ASISoundResponse aSISoundResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }
}

