/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework;

import de.vw.mib.cio.app.framework.CioIntentDefinition;
import java.util.Map;
import java.util.Properties;

public interface AppDefinition {
    default public String getAppAdapterClass() {
    }

    default public String getAppName() {
    }

    default public int getAppInstanceId() {
    }

    default public String getAppInstanceName() {
    }

    default public String getAppType() {
    }

    default public CioIntentDefinition[] getCioIntents() {
    }

    default public AppDefinition[] getHostApps() {
    }

    default public AppDefinition[] getHostedApps() {
    }

    default public String[] getNeededBusinessComponents() {
    }

    default public Properties getParameters() {
    }

    default public String[] getProvidedScreenAreas() {
    }

    default public int getUniqueId() {
    }

    default public Map getUsedScreenAreas() {
    }

    default public boolean isMandatory() {
    }
}

