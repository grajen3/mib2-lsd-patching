/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal.treebuilder;

import de.vw.mib.view.internal.CloneData;

public interface WidgetTreeBuilder {
    default public CloneData createFullWidgetTree(int n, short[][] sArray) {
    }

    default public CloneData cloneSubWidgetTree(int n, CloneData cloneData, short[][] sArray) {
    }

    default public void destroyWidgetTree(int n, CloneData cloneData, short[][] sArray) {
    }

    default public void createViewSignalisation() {
    }
}

