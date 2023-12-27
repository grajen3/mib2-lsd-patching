/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.common.api.radio.asl;

import org.dsi.ifc.global.ResourceLocator;

public interface RadioStationArtService {
    default public ResourceLocator getCurrentFmStationArt() {
    }

    default public boolean isCurrentFmStationArtValid() {
    }

    default public ResourceLocator getCurrentAmStationArt() {
    }

    default public boolean isCurrentAmStationArtValid() {
    }

    default public ResourceLocator getCurrentDabStationArt() {
    }

    default public boolean isCurrentDabStationArtValid() {
    }

    default public ResourceLocator getCurrentSdarsStationArt() {
    }

    default public boolean isCurrentSdarsStationArtValid() {
    }

    default public int getCurrentlyActiveRadioPresetIndex() {
    }
}

