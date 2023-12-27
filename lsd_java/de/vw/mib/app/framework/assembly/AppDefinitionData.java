/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.assembly;

import de.vw.mib.app.framework.assembly.CioIntentData;
import java.util.Map;
import java.util.Properties;

public interface AppDefinitionData {
    public static final String APP_TYPE_DEFAULT;
    public static final String APP_TYPE_DESKTOP;
    public static final String APP_TYPE_GLOBAL;
    public static final String APP_TYPE_HOMESCREEN;

    default public String getAppAdapterClassName() {
    }

    default public int getAppInstanceId() {
    }

    default public String getAppInstanceName() {
    }

    default public String getAppName() {
    }

    default public String getAppType() {
    }

    default public CioIntentData[] getCioIntents() {
    }

    default public AppDefinitionData[] getMandatoryHostedApps() {
    }

    default public AppDefinitionData[] getOptionalHostedApps() {
    }

    default public AppDefinitionData[] getLazyStartingHostedApps() {
    }

    default public String[] getNeededBusinessComponents() {
    }

    default public Properties getParameters() {
    }

    default public Map getProvidedContent() {
    }

    default public String[] getProvidedScreenAreas() {
    }

    default public int getUniqueId() {
    }

    default public Map getUsedScreenAreas() {
    }
}

