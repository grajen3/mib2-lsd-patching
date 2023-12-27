/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.master;

import de.vw.mib.asl.api.speechengine.features.master.FeatureParamMasterKeys;
import de.vw.mib.asl.api.speechengine.features.model.OrderedPrompts;
import de.vw.mib.asl.internal.speechengine.features.AbstractGenericFeature;
import de.vw.mib.asl.internal.speechengine.features.master.PardonMasterFeature;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;

public class PardonFeatureImpl
extends AbstractGenericFeature
implements PardonMasterFeature,
FeatureParamMasterKeys {
    private OrderedPrompts pardonPrompts;

    public PardonFeatureImpl(AbstractClassifiedLogger abstractClassifiedLogger) {
        super(abstractClassifiedLogger);
    }

    private void setPardonPrompts(OrderedPrompts orderedPrompts) {
        this.pardonPrompts = orderedPrompts;
    }

    @Override
    public boolean isPardonPromptsValid() {
        return this.pardonPrompts != null;
    }

    @Override
    public OrderedPrompts getPardonPrompts() {
        return this.pardonPrompts;
    }

    @Override
    public int getFeatureType() {
        return 106;
    }

    @Override
    public void setOrderedPrompts(int n, OrderedPrompts orderedPrompts) {
        switch (n) {
            case 1050: {
                this.setPardonPrompts(orderedPrompts);
                break;
            }
            default: {
                super.setOrderedPrompts(n, orderedPrompts);
            }
        }
    }
}

