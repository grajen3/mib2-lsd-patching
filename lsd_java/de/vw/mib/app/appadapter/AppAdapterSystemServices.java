/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.appadapter;

import de.vw.mib.app.appadapter.modelapi.ModelApiClient;
import de.vw.mib.app.esam.EsamService;
import de.vw.mib.asl.clientapi.ASLClientAPIRegistry;
import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.cio.CioFactory;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.list.HMIListDataFactory;
import de.vw.mib.list.HMIListRegistry;
import de.vw.mib.log4mib.Logger;

public interface AppAdapterSystemServices {
    default public Logger createLogger(int n) {
    }

    default public ModelApiClient createModelApiClient(Class clazz) {
    }

    default public String getAppName() {
    }

    default public int getAppInstanceId() {
    }

    default public String getAppInstanceName() {
    }

    default public ASLClientAPIRegistry getASLClientAPIRegistry() {
    }

    default public CioDictionary getCioDictionary() {
    }

    default public CioDispatcher getCioDispatcher() {
    }

    default public CioFactory getCioFactory() {
    }

    default public ConfigurationManager getConfigurationManager() {
    }

    default public EsamService getEsamService() {
    }

    default public HMIListDataFactory getHMIListDataFactory() {
    }

    default public HMIListRegistry getHMIListRegistry() {
    }

    default public Logger getLogger(int n) {
    }

    default public ModelApiClient getModelApiClient(Class clazz) {
    }
}

