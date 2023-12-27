/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.slots;

public interface SlotDefinition
extends de.vw.mib.asl.api.speechengine.slotdef.SlotDefinition {
    @Override
    default public boolean isDeprecated() {
    }

    @Override
    default public String getSlotName() {
    }

    @Override
    default public int getSlotId() {
    }

    @Override
    default public int getType() {
    }

    @Override
    default public boolean isNBest() {
    }

    @Override
    default public boolean isSpellable() {
    }

    @Override
    default public String getDescription() {
    }

    @Override
    default public boolean isNeedUpdateGrammarState() {
    }

    @Override
    default public int getRecognitionResultIDType() {
    }

    @Override
    default public Integer getInstanceId() {
    }

    @Override
    default public String getViewType() {
    }

    @Override
    default public Integer getViewTypeNum() {
    }
}

