/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.SpellerController;

public interface AsiaSpellerController
extends SpellerController {
    public static final String IN_HWRERRORCONFIRMED_NAME;
    public static final String OUT_HWRDISABLED_NAME;
    public static final String OUT_HWRENABLED_NAME;
    public static final String OUT_HWRERROROCCURRED_NAME;
    public static final String OUT_SYLLABLESAVAILABLE_NAME;
    public static final String OUT_WORDSEGMENTATIONAVAILABLE_NAME;

    default public void fire_hwrErrorConfirmed() {
    }

    default public void fire_hwrDisabled() {
    }

    default public void fire_hwrEnabled() {
    }

    default public void fire_hwrErrorOccurred() {
    }

    default public void fire_syllablesAvailable() {
    }

    default public void fire_wordSegmentationAvailable() {
    }

    default public void onCandidateSelected(String string, int n) {
    }

    default public void onCharactersFiltered(String[] stringArray, String[] stringArray2, boolean bl) {
    }

    default public void onHwrCharactersRecognized(String[] stringArray) {
    }

    default public void onPredictionSelected(String string, int n) {
    }

    default public void onPreviewLineCollapsed() {
    }

    default public void onPreviewLineExpanded() {
    }

    default public void onNextValidCharacterSelected(String string, int n) {
    }

    default public void onRecognizedCharacterSelected(String string, int n) {
    }
}

