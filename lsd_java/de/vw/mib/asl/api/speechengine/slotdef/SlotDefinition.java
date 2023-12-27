/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.slotdef;

public interface SlotDefinition {
    default public boolean isDeprecated() {
    }

    default public String getSlotName() {
    }

    default public int getSlotId() {
    }

    default public int getType() {
    }

    default public boolean isNBest() {
    }

    default public boolean isSpellable() {
    }

    default public String getDescription() {
    }

    default public boolean isNeedUpdateGrammarState() {
    }

    default public int getRecognitionResultIDType() {
    }

    default public Integer getInstanceId() {
    }

    default public String getViewType() {
    }

    default public Integer getViewTypeNum() {
    }
}

