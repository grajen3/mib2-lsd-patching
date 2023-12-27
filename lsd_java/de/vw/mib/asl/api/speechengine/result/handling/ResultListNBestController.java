/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.result.handling;

import de.vw.mib.asl.api.speechengine.result.handling.ResultListController;

public interface ResultListNBestController
extends ResultListController {
    default public int getListIdDetailLevel() {
    }

    default public void onSelectItem() {
    }

    default public void onSelectSubItem(int n) {
    }

    default public void notifyAmbiguousItemsRequested() {
    }

    default public void notifyGroupExpanded(int n) {
    }

    default public void notifyGroupCollapsed(int n) {
    }
}

