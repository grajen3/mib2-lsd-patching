/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.master;

import de.vw.mib.asl.api.speechengine.features.master.FeatureParamMasterKeys;
import de.vw.mib.asl.api.speechengine.features.model.OrderedPrompts;
import de.vw.mib.asl.internal.speechengine.features.AbstractGenericFeature;
import de.vw.mib.asl.internal.speechengine.features.master.PleaseWaitMasterFeature;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;

public class PleaseWaitFeatureImpl
extends AbstractGenericFeature
implements PleaseWaitMasterFeature,
FeatureParamMasterKeys {
    private OrderedPrompts pleaseWaitPrompts;

    public PleaseWaitFeatureImpl(AbstractClassifiedLogger abstractClassifiedLogger) {
        super(abstractClassifiedLogger);
    }

    private void setPleaseWaitPrompts(OrderedPrompts orderedPrompts) {
        this.pleaseWaitPrompts = orderedPrompts;
    }

    @Override
    public boolean isPleaseWaitPromptsValid() {
        return this.pleaseWaitPrompts != null;
    }

    @Override
    public OrderedPrompts getPleaseWaitPrompts() {
        return this.pleaseWaitPrompts;
    }

    @Override
    public int getFeatureType() {
        return 108;
    }

    @Override
    public void setOrderedPrompts(int n, OrderedPrompts orderedPrompts) {
        switch (n) {
            case 1070: {
                this.setPleaseWaitPrompts(orderedPrompts);
                break;
            }
            default: {
                super.setOrderedPrompts(n, orderedPrompts);
            }
        }
    }
}

