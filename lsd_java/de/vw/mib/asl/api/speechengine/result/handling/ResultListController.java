/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.result.handling;

public interface ResultListController {
    default public int getListIdTopLevel() {
    }

    default public int getListIdSelectedItem() {
    }

    default public void onRequestItems() {
    }

    default public void onSelectItem(int n) {
    }

    default public void onRecognizeRowNumber() {
    }

    default public void notifyItemsRequested() {
    }

    default public void notifyItemSelected() {
    }

    default public void notifyRowNumberRecognized(int n) {
    }
}

