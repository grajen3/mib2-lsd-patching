/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.master;

import de.vw.mib.asl.api.speechengine.features.master.FeatureParamMasterKeys;
import de.vw.mib.asl.api.speechengine.features.model.OrderedPrompts;
import de.vw.mib.asl.internal.speechengine.features.AbstractGenericFeature;
import de.vw.mib.asl.internal.speechengine.features.master.TimeoutMasterFeature;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;

public class TimeoutFeatureImpl
extends AbstractGenericFeature
implements TimeoutMasterFeature,
FeatureParamMasterKeys {
    private OrderedPrompts timeoutPrompts;

    public TimeoutFeatureImpl(AbstractClassifiedLogger abstractClassifiedLogger) {
        super(abstractClassifiedLogger);
    }

    private void setTimeoutPrompts(OrderedPrompts orderedPrompts) {
        this.timeoutPrompts = orderedPrompts;
    }

    @Override
    public boolean isTimeoutPromptsValid() {
        return this.timeoutPrompts != null;
    }

    @Override
    public OrderedPrompts getTimeoutPrompts() {
        return this.timeoutPrompts;
    }

    @Override
    public int getFeatureType() {
        return 110;
    }

    @Override
    public void setOrderedPrompts(int n, OrderedPrompts orderedPrompts) {
        switch (n) {
            case 1090: {
                this.setTimeoutPrompts(orderedPrompts);
                break;
            }
            default: {
                super.setOrderedPrompts(n, orderedPrompts);
            }
        }
    }
}

