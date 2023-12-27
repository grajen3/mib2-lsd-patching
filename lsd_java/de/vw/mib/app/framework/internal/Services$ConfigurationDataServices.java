/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.framework.assembly.AppDefinitionDataProvider;
import de.vw.mib.app.framework.internal.Assembly;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.configuration.EsamDefinitionDataService;

final class Services$ConfigurationDataServices {
    private final Assembly assembly;
    private final ConfigurationManager configurationManager;
    private final EsamDefinitionDataService esamDefinitionDataService;

    Services$ConfigurationDataServices(AppDefinitionDataProvider appDefinitionDataProvider, ConfigurationManager configurationManager, EsamDefinitionDataService esamDefinitionDataService) {
        this.assembly = new Assembly(appDefinitionDataProvider);
        this.configurationManager = configurationManager;
        this.esamDefinitionDataService = esamDefinitionDataService;
    }

    Assembly getAssembly() {
        return this.assembly;
    }

    ConfigurationManager getConfigurationManager() {
        return this.configurationManager;
    }

    EsamDefinitionDataService getEsamDefinitionDataService() {
        return this.esamDefinitionDataService;
    }
}

