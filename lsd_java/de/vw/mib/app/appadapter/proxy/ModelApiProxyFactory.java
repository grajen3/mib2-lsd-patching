/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.appadapter.proxy;

import de.vw.mib.app.appadapter.modelapi.ModelApiClient;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.modelapi.appadapter.ModelApiDownEventHandler;
import de.vw.mib.modelapi.appadapter.ModelApiUpEventService;

public interface ModelApiProxyFactory {
    default public ModelApiDownEventHandler createModelApiServiceProxy(AppDefinition appDefinition, ModelApiService[] modelApiServiceArray) {
    }

    default public ModelApiClient createModelApiClientProxy(AppDefinition appDefinition, Class clazz, ModelApiUpEventService modelApiUpEventService) {
    }
}

