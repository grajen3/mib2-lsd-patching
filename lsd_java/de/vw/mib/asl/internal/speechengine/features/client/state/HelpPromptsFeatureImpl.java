/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.client.state;

import de.vw.mib.asl.api.speechengine.features.client.state.FeatureParamStateKeys;
import de.vw.mib.asl.api.speechengine.features.complex.ComplexHelpPromptsFeature;
import de.vw.mib.asl.api.speechengine.features.model.OrderedPrompts;
import de.vw.mib.asl.internal.speechengine.features.AbstractGenericFeature;
import de.vw.mib.asl.internal.speechengine.features.client.state.HelpPromptsStateFeature;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;

public class HelpPromptsFeatureImpl
extends AbstractGenericFeature
implements HelpPromptsStateFeature,
ComplexHelpPromptsFeature,
FeatureParamStateKeys {
    private OrderedPrompts[] helpPrompts;

    public HelpPromptsFeatureImpl(AbstractClassifiedLogger abstractClassifiedLogger) {
        super(abstractClassifiedLogger);
    }

    @Override
    public void setHelpPrompts(OrderedPrompts[] orderedPromptsArray) {
        this.helpPrompts = orderedPromptsArray;
    }

    @Override
    public boolean isHelpPromptsValid() {
        return this.helpPrompts != null;
    }

    @Override
    public OrderedPrompts[] getHelpPrompts() {
        return this.helpPrompts;
    }

    @Override
    public int getFeatureType() {
        return 303;
    }
}

