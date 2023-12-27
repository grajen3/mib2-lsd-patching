/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.master;

import de.vw.mib.asl.api.speechengine.features.master.FeatureParamMasterKeys;
import de.vw.mib.asl.api.speechengine.features.model.OrderedPrompts;
import de.vw.mib.asl.internal.speechengine.features.AbstractGenericFeature;
import de.vw.mib.asl.internal.speechengine.features.master.RepeatMasterFeature;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;

public class RepeatFeatureImpl
extends AbstractGenericFeature
implements RepeatMasterFeature,
FeatureParamMasterKeys {
    private int repeatCommand;
    private OrderedPrompts repeatFallbackPrompts;
    private boolean repeatCommandValid = false;

    public RepeatFeatureImpl(AbstractClassifiedLogger abstractClassifiedLogger) {
        super(abstractClassifiedLogger);
    }

    private void setRepeatCommand(int n) {
        this.repeatCommand = n;
        this.repeatCommandValid = true;
    }

    private void setRepeatFallbackPrompts(OrderedPrompts orderedPrompts) {
        this.repeatFallbackPrompts = orderedPrompts;
    }

    @Override
    public boolean isRepeatCommandValid() {
        return this.repeatCommandValid;
    }

    @Override
    public boolean isRepeatFallbackPromptsValid() {
        return this.repeatFallbackPrompts != null;
    }

    @Override
    public int getRepeatCommand() {
        return this.repeatCommand;
    }

    @Override
    public OrderedPrompts getRepeatFallbackPrompts() {
        return this.repeatFallbackPrompts;
    }

    @Override
    public int getFeatureType() {
        return 109;
    }

    @Override
    public void setInt(int n, int n2) {
        switch (n) {
            case 1080: {
                this.setRepeatCommand(n2);
                break;
            }
            default: {
                super.setInt(n, n2);
            }
        }
    }

    @Override
    public void setOrderedPrompts(int n, OrderedPrompts orderedPrompts) {
        switch (n) {
            case 1081: {
                this.setRepeatFallbackPrompts(orderedPrompts);
                break;
            }
            default: {
                super.setOrderedPrompts(n, orderedPrompts);
            }
        }
    }
}

