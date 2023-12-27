/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.client.state;

import de.vw.mib.asl.api.speechengine.features.complex.ComplexInitialPromptsFeature;
import de.vw.mib.asl.api.speechengine.features.model.Prompt;
import de.vw.mib.asl.internal.speechengine.features.AbstractGenericFeature;
import de.vw.mib.asl.internal.speechengine.features.client.state.InitialPromptsStateFeature;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;

public class InitialPromptsFeatureImpl
extends AbstractGenericFeature
implements InitialPromptsStateFeature,
ComplexInitialPromptsFeature {
    private Prompt[] initialPrompts;

    public InitialPromptsFeatureImpl(AbstractClassifiedLogger abstractClassifiedLogger) {
        super(abstractClassifiedLogger);
    }

    @Override
    public void setInitialPrompts(Prompt[] promptArray) {
        this.initialPrompts = promptArray;
    }

    @Override
    public boolean isInitialPromptsValid() {
        return this.initialPrompts != null && this.initialPrompts.length != 0;
    }

    @Override
    public Prompt[] getInitialPrompts() {
        return this.initialPrompts;
    }

    @Override
    public int getFeatureType() {
        return 304;
    }
}

