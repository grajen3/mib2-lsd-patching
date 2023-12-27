/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.features;

import de.vw.mib.asl.api.speechengine.features.GenericTargetFeature;
import de.vw.mib.asl.api.speechengine.features.complex.ComplexCommandFeature;
import de.vw.mib.asl.api.speechengine.features.complex.ComplexHelpPromptsFeature;
import de.vw.mib.asl.api.speechengine.features.complex.ComplexInitialPromptsFeature;
import de.vw.mib.asl.api.speechengine.features.complex.ComplexTeleprompterDataFeature;
import de.vw.mib.asl.api.speechengine.features.model.Command;
import de.vw.mib.asl.api.speechengine.features.model.DynamicString;
import de.vw.mib.asl.api.speechengine.features.model.Event;
import de.vw.mib.asl.api.speechengine.features.model.OrderedPrompts;
import de.vw.mib.asl.api.speechengine.features.model.Prompt;
import de.vw.mib.asl.api.speechengine.features.model.PromptReference;

public interface FeatureFactory {
    default public GenericTargetFeature createFeature(int n) {
    }

    default public ComplexCommandFeature createCommandFeature() {
    }

    default public ComplexInitialPromptsFeature createInitialPromptsFeature() {
    }

    default public ComplexHelpPromptsFeature createHelpPromptsFeature() {
    }

    default public ComplexTeleprompterDataFeature createTeleprompterDataFeature() {
    }

    default public Command createCommand(int n, int n2, int n3, int n4, boolean bl, boolean bl2) {
    }

    default public Command createCommand(int n, int n2, int n3, int n4, boolean bl, boolean bl2, boolean bl3) {
    }

    default public Event createEvent(int n) {
    }

    default public OrderedPrompts createOrderedPrompts(int[] nArray, int n) {
    }

    default public Prompt createPrompt(int n, int n2, String[] stringArray) {
    }

    default public Prompt createDynamicPrompt(int n, int n2, PromptReference[] promptReferenceArray) {
    }

    default public Prompt createPrompt(int n, PromptReference[] promptReferenceArray) {
    }

    default public PromptReference createPromptReference(String string, String string2, String string3) {
    }

    default public DynamicString createDynamicString(String string, boolean bl) {
    }
}

