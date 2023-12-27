/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.features.complex;

import de.vw.mib.asl.api.speechengine.features.GenericTargetFeature;
import de.vw.mib.asl.api.speechengine.features.model.Prompt;

public interface ComplexInitialPromptsFeature
extends GenericTargetFeature {
    default public void setInitialPrompts(Prompt[] promptArray) {
    }
}

