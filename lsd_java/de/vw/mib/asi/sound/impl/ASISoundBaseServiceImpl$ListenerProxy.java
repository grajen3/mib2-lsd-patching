/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.sound.impl;

import de.esolutions.fw.comm.asi.hmisync.sound.SoundRange;
import de.esolutions.fw.comm.core.method.MethodException;
import de.vw.mib.asi.sound.ASISoundListener;
import de.vw.mib.asi.sound.impl.ASISoundBaseServiceImpl;

class ASISoundBaseServiceImpl$ListenerProxy
implements ASISoundListener {
    private final /* synthetic */ ASISoundBaseServiceImpl this$0;

    ASISoundBaseServiceImpl$ListenerProxy(ASISoundBaseServiceImpl aSISoundBaseServiceImpl) {
        this.this$0 = aSISoundBaseServiceImpl;
    }

    @Override
    public void updateAmplifier(int n, boolean bl) {
        try {
            this.this$0.updateAmplifier(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateBalanceRange(SoundRange soundRange, boolean bl) {
        try {
            this.this$0.updateBalanceRange(soundRange, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateBalanceValue(int n, boolean bl) {
        try {
            this.this$0.updateBalanceValue(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateBassRange(SoundRange soundRange, boolean bl) {
        try {
            this.this$0.updateBassRange(soundRange, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateBassValue(int n, boolean bl) {
        try {
            this.this$0.updateBassValue(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateFaderRange(SoundRange soundRange, boolean bl) {
        try {
            this.this$0.updateFaderRange(soundRange, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateFaderValue(int n, boolean bl) {
        try {
            this.this$0.updateFaderValue(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateNoiseCompensationRange(SoundRange soundRange, boolean bl) {
        try {
            this.this$0.updateNoiseCompensationRange(soundRange, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateNoiseCompensationValue(int n, boolean bl) {
        try {
            this.this$0.updateNoiseCompensationValue(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updatePresetPosition(int n, boolean bl) {
        try {
            this.this$0.updatePresetPosition(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updatePresetPositionList(int n, boolean bl) {
        try {
            this.this$0.updatePresetPositionList(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateSoundState(int n, boolean bl) {
        try {
            this.this$0.updateSoundState(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateSubwooferRange(SoundRange soundRange, boolean bl) {
        try {
            this.this$0.updateSubwooferRange(soundRange, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateSubwooferValue(int n, boolean bl) {
        try {
            this.this$0.updateSubwooferValue(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateSurroundRange(SoundRange soundRange, boolean bl) {
        try {
            this.this$0.updateSurroundRange(soundRange, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateSurroundValue(int n, boolean bl) {
        try {
            this.this$0.updateSurroundValue(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateTrebleRange(SoundRange soundRange, boolean bl) {
        try {
            this.this$0.updateTrebleRange(soundRange, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateTrebleValue(int n, boolean bl) {
        try {
            this.this$0.updateTrebleValue(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }
}

