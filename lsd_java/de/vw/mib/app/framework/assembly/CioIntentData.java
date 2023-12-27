/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.assembly;

import de.vw.mib.app.framework.assembly.AppDefinitionData;
import de.vw.mib.app.framework.assembly.CioIntentClassData;
import de.vw.mib.app.framework.assembly.CioVisualizationData;

public interface CioIntentData {
    default public AppDefinitionData getApp() {
    }

    default public int getActionId() {
    }

    default public String getCioName() {
    }

    default public CioIntentClassData getCioIntentClass() {
    }

    default public CioVisualizationData[] getCioVisualizations() {
    }

    default public String getIntentName() {
    }

    default public int getFeatureFlagId() {
    }

    default public int getRank() {
    }

    default public String getUsage() {
    }

    default public boolean isForwardingCioIntent() {
    }

    default public String getForwardedCioIntentClassName() {
    }

    default public String getForwardedUsageName() {
    }
}

