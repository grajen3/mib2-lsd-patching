/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiClient;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.app.appadapter.proxy.ModelApiProxyFactory;
import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.app.framework.internal.AppAdapterController;
import de.vw.mib.app.framework.internal.AppContext;
import de.vw.mib.app.framework.internal.Services$AppFrameworkServices;
import de.vw.mib.app.framework.internal.Services$CommonFrameworkServices;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.modelapi.appadapter.ModelApiDownEventHandler;
import de.vw.mib.modelapi.appadapter.ModelApiUpEventService;
import java.lang.reflect.Constructor;

final class AppAdapterManager {
    private static final Class[] CONSTRUCTOR_PARAMS = new Class[]{class$de$vw$mib$app$appadapter$AppAdapterSystemServices == null ? (class$de$vw$mib$app$appadapter$AppAdapterSystemServices = AppAdapterManager.class$("de.vw.mib.app.appadapter.AppAdapterSystemServices")) : class$de$vw$mib$app$appadapter$AppAdapterSystemServices};
    private final Logger logger;
    private final ModelApiProxyFactory modelApiProxyFactory;
    static /* synthetic */ Class class$de$vw$mib$app$appadapter$AppAdapterSystemServices;

    AppAdapterManager(Services$AppFrameworkServices services$AppFrameworkServices, Services$CommonFrameworkServices services$CommonFrameworkServices) {
        this.logger = services$CommonFrameworkServices.getLogger();
        this.modelApiProxyFactory = services$AppFrameworkServices.getModelApiProxyFactory();
    }

    AbstractAppAdapter createAppAdapter(AppContext appContext) {
        String string;
        AppAdapterController appAdapterController = appContext.getAppAdapterController();
        AppDefinition appDefinition = appContext.getAppDefinition();
        String string2 = appDefinition.getAppName();
        Constructor constructor = this.findAppAdapterConstructor(string2, string = appDefinition.getAppAdapterClass());
        if (constructor == null) {
            return null;
        }
        return this.instantiateAppAdapter(string2, appAdapterController, constructor);
    }

    ModelApiClient createModelApiClientProxy(AppDefinition appDefinition, Class clazz, ModelApiUpEventService modelApiUpEventService) {
        if (this.modelApiProxyFactory == null) {
            return null;
        }
        return this.modelApiProxyFactory.createModelApiClientProxy(appDefinition, clazz, modelApiUpEventService);
    }

    ModelApiDownEventHandler createModelApiServiceProxy(AppDefinition appDefinition, ModelApiService[] modelApiServiceArray) {
        if (this.modelApiProxyFactory == null) {
            return null;
        }
        return this.modelApiProxyFactory.createModelApiServiceProxy(appDefinition, modelApiServiceArray);
    }

    private Constructor findAppAdapterConstructor(String string, String string2) {
        Class clazz;
        if (string2 == null) {
            if (this.logger.isTraceEnabled(128)) {
                this.logger.warn(128).append("no app adapter specified for app ").append(string).log();
            }
            return null;
        }
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append("load app adapter class for app ").append(string).append(" - app adapter class: ").append(string2).log();
        }
        try {
            clazz = Class.forName(string2);
        }
        catch (ClassNotFoundException classNotFoundException) {
            this.logger.error(128).append("couldn't load class ").append(string2).log();
            return null;
        }
        try {
            return clazz.getConstructor(CONSTRUCTOR_PARAMS);
        }
        catch (Throwable throwable) {
            this.logger.error(128).append("couldn't find the required constructor").attachThrowable(throwable).log();
            return null;
        }
    }

    private AbstractAppAdapter instantiateAppAdapter(String string, AppAdapterSystemServices appAdapterSystemServices, Constructor constructor) {
        try {
            return (AbstractAppAdapter)constructor.newInstance(new Object[]{appAdapterSystemServices});
        }
        catch (Throwable throwable) {
            this.logger.error(128).append("couldn't create app adapter for app ").append(string).attachThrowable(throwable).log();
            return null;
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

