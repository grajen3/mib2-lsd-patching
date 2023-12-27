/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.result.model;

import de.vw.mib.asl.api.speechengine.result.model.ResultItemIdentifier;

public interface ResultItem {
    default public String getText() {
    }

    default public String getTag() {
    }

    default public int getSize() {
    }

    default public boolean isGroup() {
    }

    default public int getGroupIndex() {
    }

    default public int getItemIndex() {
    }

    default public int getGroupId() {
    }

    default public boolean hasGroup() {
    }

    default public ResultItemIdentifier getIdentifier() {
    }

    default public ResultItemIdentifier getIdentifier(int n) {
    }
}

