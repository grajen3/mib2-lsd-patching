/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.master;

import de.vw.mib.asl.api.speechengine.features.master.FeatureParamMasterKeys;
import de.vw.mib.asl.api.speechengine.features.model.OrderedPrompts;
import de.vw.mib.asl.internal.speechengine.features.AbstractGenericFeature;
import de.vw.mib.asl.internal.speechengine.features.master.ErrorsMasterFeature;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;

public class ErrorsFeatureImpl
extends AbstractGenericFeature
implements ErrorsMasterFeature,
FeatureParamMasterKeys {
    private OrderedPrompts hardwareOfPoorQualityPrompts;
    private OrderedPrompts unknownErrorPrompts;
    private OrderedPrompts speechLevelTooLoudPrompts;
    private OrderedPrompts speechLevelTooWeakPrompts;
    private OrderedPrompts signalNoiseRatioTooLowPrompts;

    public ErrorsFeatureImpl(AbstractClassifiedLogger abstractClassifiedLogger) {
        super(abstractClassifiedLogger);
    }

    public void setHardwareOfPoorQualityPrompts(OrderedPrompts orderedPrompts) {
        this.hardwareOfPoorQualityPrompts = orderedPrompts;
    }

    public void setUnknownErrorPrompts(OrderedPrompts orderedPrompts) {
        this.unknownErrorPrompts = orderedPrompts;
    }

    public void setSpeechLevelTooLoudPrompts(OrderedPrompts orderedPrompts) {
        this.speechLevelTooLoudPrompts = orderedPrompts;
    }

    public void setSpeechLevelTooWeakPrompts(OrderedPrompts orderedPrompts) {
        this.speechLevelTooWeakPrompts = orderedPrompts;
    }

    public void setSignalNoiseRatioTooLowPrompts(OrderedPrompts orderedPrompts) {
        this.signalNoiseRatioTooLowPrompts = orderedPrompts;
    }

    @Override
    public boolean isHardwareOfPoorQualityPromptsValid() {
        return this.hardwareOfPoorQualityPrompts != null;
    }

    @Override
    public boolean isUnknownErrorPromptsValid() {
        return this.unknownErrorPrompts != null;
    }

    @Override
    public boolean isSpeechLevelTooLoudPromptsValid() {
        return this.speechLevelTooLoudPrompts != null;
    }

    @Override
    public boolean isSpeechLevelTooWeakPromptsValid() {
        return this.speechLevelTooWeakPrompts != null;
    }

    @Override
    public boolean isSignalNoiseRatioTooLowPromptsValid() {
        return this.signalNoiseRatioTooLowPrompts != null;
    }

    @Override
    public OrderedPrompts getHardwareOfPoorQualityPrompts() {
        return this.hardwareOfPoorQualityPrompts;
    }

    @Override
    public OrderedPrompts getUnknownErrorPrompts() {
        return this.unknownErrorPrompts;
    }

    @Override
    public OrderedPrompts getSpeechLevelTooLoudPrompts() {
        return this.speechLevelTooLoudPrompts;
    }

    @Override
    public OrderedPrompts getSpeechLevelTooWeakPrompts() {
        return this.speechLevelTooWeakPrompts;
    }

    @Override
    public OrderedPrompts getSignalNoiseRatioTooLowPrompts() {
        return this.signalNoiseRatioTooLowPrompts;
    }

    @Override
    public int getFeatureType() {
        return 103;
    }

    @Override
    public void setOrderedPrompts(int n, OrderedPrompts orderedPrompts) {
        switch (n) {
            case 1020: {
                this.setHardwareOfPoorQualityPrompts(orderedPrompts);
                break;
            }
            case 1021: {
                this.setUnknownErrorPrompts(orderedPrompts);
                break;
            }
            case 1022: {
                this.setSpeechLevelTooLoudPrompts(orderedPrompts);
                break;
            }
            case 1023: {
                this.setSpeechLevelTooWeakPrompts(orderedPrompts);
                break;
            }
            case 1024: {
                this.setSignalNoiseRatioTooLowPrompts(orderedPrompts);
                break;
            }
            default: {
                super.setOrderedPrompts(n, orderedPrompts);
            }
        }
    }
}

