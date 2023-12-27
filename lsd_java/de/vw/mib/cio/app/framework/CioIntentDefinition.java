/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio.app.framework;

public interface CioIntentDefinition {
    public static final int UNSPECIFIED;

    default public int getActionId() {
    }

    default public String getAppInstanceName() {
    }

    default public String getAppName() {
    }

    default public String getCioIntentClassName() {
    }

    default public String getCioName() {
    }

    default public String[] getCioVisualizationNames() {
    }

    default public int getFeatureFlagId() {
    }

    default public String getForwardedCioIntentClassName() {
    }

    default public String getForwardedUsageName() {
    }

    default public String getIntentName() {
    }

    default public int getRank() {
    }

    default public String getUsage() {
    }

    default public boolean isForwardingCioIntent() {
    }
}

