/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.appadapter.proxy.impl;

import de.vw.mib.app.appadapter.modelapi.ModelApiClient;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.app.appadapter.proxy.ModelApiProxyFactory;
import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.modelapi.appadapter.ModelApiDownEventHandler;
import de.vw.mib.modelapi.appadapter.ModelApiUpEventService;
import generated.de.vw.mib.appadapter.proxy.impl.AppAdapterProxyFactory$1NullInvocationHandler;
import generated.de.vw.mib.appadapter.proxy.impl.ProxyManifest;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class AppAdapterProxyFactory
implements ModelApiProxyFactory {
    private static final int LOG_CLASSIFIER;
    private static final int SUB_CLASSIFIER;
    private static final String MANIFEST_MODEL_API_SERVICE_PROXY;
    private static final String MANIFEST_MODEL_API_CLIENT_PROXY;
    private static final String UNKNOWN_CLIENT_PROXY_CLASS_NAME;
    private final Map manifests = new HashMap();
    private final Logger logger;
    static /* synthetic */ Class array$Lde$vw$mib$app$appadapter$modelapi$ModelApiService;
    static /* synthetic */ Class class$de$vw$mib$app$framework$AppDefinition;
    static /* synthetic */ Class class$de$vw$mib$log4mib$Logger;
    static /* synthetic */ Class class$de$vw$mib$modelapi$appadapter$ModelApiUpEventService;
    static /* synthetic */ Class class$de$vw$mib$app$appadapter$modelapi$ModelApiClient;

    public AppAdapterProxyFactory(LoggerFactory loggerFactory) {
        this.logger = loggerFactory.getLogger(128);
        this.logger.trace(4, "App adapter proxy factory started.");
    }

    @Override
    public ModelApiDownEventHandler createModelApiServiceProxy(AppDefinition appDefinition, ModelApiService[] modelApiServiceArray) {
        String string = appDefinition.getAppName();
        String string2 = appDefinition.getAppInstanceName();
        String string3 = this.getModelApiServiceProxyClassName(string, string2);
        Class[] classArray = new Class[]{array$Lde$vw$mib$app$appadapter$modelapi$ModelApiService == null ? (array$Lde$vw$mib$app$appadapter$modelapi$ModelApiService = AppAdapterProxyFactory.class$("[Lde.vw.mib.app.appadapter.modelapi.ModelApiService;")) : array$Lde$vw$mib$app$appadapter$modelapi$ModelApiService, class$de$vw$mib$app$framework$AppDefinition == null ? (class$de$vw$mib$app$framework$AppDefinition = AppAdapterProxyFactory.class$("de.vw.mib.app.framework.AppDefinition")) : class$de$vw$mib$app$framework$AppDefinition, class$de$vw$mib$log4mib$Logger == null ? (class$de$vw$mib$log4mib$Logger = AppAdapterProxyFactory.class$("de.vw.mib.log4mib.Logger")) : class$de$vw$mib$log4mib$Logger};
        Object[] objectArray = new Object[]{modelApiServiceArray, appDefinition, this.logger};
        ModelApiDownEventHandler modelApiDownEventHandler = (ModelApiDownEventHandler)this.newInstance(string, string2, string3, classArray, objectArray);
        if (this.logger.isTraceEnabled(4)) {
            this.logger.trace(4).append("App {").append(string).append("} adapter proxy - service proxy '").append(this.simpleNameOf(string3)).append("' instantiated.").log();
        }
        return modelApiDownEventHandler;
    }

    @Override
    public ModelApiClient createModelApiClientProxy(AppDefinition appDefinition, Class clazz, ModelApiUpEventService modelApiUpEventService) {
        String string = appDefinition.getAppName();
        String string2 = appDefinition.getAppInstanceName();
        String string3 = this.getModelApiClientProxyClassName(string, string2, this.simpleNameOf(clazz.getName()));
        ModelApiClient modelApiClient = this.createClientProxy(appDefinition, clazz, modelApiUpEventService, string3);
        if (this.logger.isTraceEnabled(4)) {
            this.logger.trace(4).append("App {").append(string).append("} adapter proxy - client proxy '").append(this.simpleNameOf(string3)).append("' instantiated.").log();
        }
        return modelApiClient;
    }

    private ModelApiClient createClientProxy(AppDefinition appDefinition, Class clazz, ModelApiUpEventService modelApiUpEventService, String string) {
        if (string != UNKNOWN_CLIENT_PROXY_CLASS_NAME) {
            return this.createRealClientProxy(appDefinition, modelApiUpEventService, string);
        }
        return this.createEmptyClientProxy(appDefinition, clazz);
    }

    private ModelApiClient createRealClientProxy(AppDefinition appDefinition, ModelApiUpEventService modelApiUpEventService, String string) {
        String string2 = appDefinition.getAppName();
        String string3 = appDefinition.getAppInstanceName();
        Class[] classArray = new Class[]{class$de$vw$mib$modelapi$appadapter$ModelApiUpEventService == null ? (class$de$vw$mib$modelapi$appadapter$ModelApiUpEventService = AppAdapterProxyFactory.class$("de.vw.mib.modelapi.appadapter.ModelApiUpEventService")) : class$de$vw$mib$modelapi$appadapter$ModelApiUpEventService, class$de$vw$mib$app$framework$AppDefinition == null ? (class$de$vw$mib$app$framework$AppDefinition = AppAdapterProxyFactory.class$("de.vw.mib.app.framework.AppDefinition")) : class$de$vw$mib$app$framework$AppDefinition, class$de$vw$mib$log4mib$Logger == null ? (class$de$vw$mib$log4mib$Logger = AppAdapterProxyFactory.class$("de.vw.mib.log4mib.Logger")) : class$de$vw$mib$log4mib$Logger};
        Object[] objectArray = new Object[]{modelApiUpEventService, appDefinition, this.logger};
        Object object = this.newInstance(string2, string3, string, classArray, objectArray);
        return (ModelApiClient)object;
    }

    private ModelApiClient createEmptyClientProxy(AppDefinition appDefinition, Class clazz) {
        String string = appDefinition.getAppName();
        String string2 = appDefinition.getAppInstanceName();
        if (!(class$de$vw$mib$app$appadapter$modelapi$ModelApiClient == null ? (class$de$vw$mib$app$appadapter$modelapi$ModelApiClient = AppAdapterProxyFactory.class$("de.vw.mib.app.appadapter.modelapi.ModelApiClient")) : class$de$vw$mib$app$appadapter$modelapi$ModelApiClient).isAssignableFrom(clazz)) {
            throw this.instantiationFailed(string, string2, clazz.getName(), "not a model API client", null);
        }
        if (clazz.isInterface()) {
            return AppAdapterProxyFactory.newInterfaceInstance(clazz);
        }
        Object object = this.newInstance(string, string2, clazz.getName(), null, null);
        return (ModelApiClient)object;
    }

    private String getModelApiServiceProxyClassName(String string, String string2) {
        String string3 = this.getProxyClassName(string, string2, "ModelApiServiceProxy");
        if (string3 == null) {
            this.logger.error(4).append("App {").append(string).append("} adapter service proxy - class not specified. Missing manifest attribute '").append("ModelApiServiceProxy").append("'.").log();
            throw new IllegalArgumentException("App adapter service proxy class not specified with attribute 'ModelApiServiceProxy'.");
        }
        return string3;
    }

    private String getModelApiClientProxyClassName(String string, String string2, String string3) {
        String string4 = this.getProxyClassName(string, string2, new StringBuffer().append("ModelApiClientProxy-").append(string3).toString());
        if (string4 == null) {
            this.logger.info(4).append("App {").append(string).append("} adapter service proxy - class not specified. Missing manifest attribute '").append("ModelApiServiceProxy").append("'.").log();
            return UNKNOWN_CLIENT_PROXY_CLASS_NAME;
        }
        return string4;
    }

    private String getProxyClassName(String string, String string2, String string3) {
        ProxyManifest proxyManifest = this.getManifest(string, string2);
        String string4 = proxyManifest.getAttribute(string3);
        return string4;
    }

    private ProxyManifest getManifest(String string, String string2) {
        ProxyManifest proxyManifest = (ProxyManifest)this.manifests.get(string2);
        if (proxyManifest == null) {
            proxyManifest = this.loadManifest(string, string2);
            this.manifests.put(string2, proxyManifest);
        }
        return proxyManifest;
    }

    private ProxyManifest loadManifest(String string, String string2) {
        String string3 = new StringBuffer().append("META-INF/APP-PROXY.").append(string2).append(".MF").toString();
        URL uRL = ClassLoader.getSystemResource(string3);
        if (uRL == null) {
            this.logger.error(4).append("App {").append(string).append("} adapter proxy - manifest '").append(string3).append("' not found.").log();
            return ProxyManifest.empty();
        }
        try {
            return ProxyManifest.load(uRL);
        }
        catch (IOException iOException) {
            this.logger.error(4).append("App {").append(string).append("} adapter proxy - manifest '").append(string3).append("' is invalid: ").append(iOException.getMessage()).log();
            return ProxyManifest.empty();
        }
    }

    private static ModelApiClient newInterfaceInstance(Class clazz) {
        Object object = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new AppAdapterProxyFactory$1NullInvocationHandler());
        return (ModelApiClient)object;
    }

    private Object newInstance(String string, String string2, String string3, Class[] classArray, Object[] objectArray) {
        try {
            Class clazz = Class.forName(string3);
            Constructor constructor = clazz.getConstructor(classArray);
            Object object = constructor.newInstance(objectArray);
            return object;
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw this.instantiationFailed(string, string2, string3, "not found", null);
        }
        catch (InvocationTargetException invocationTargetException) {
            throw this.instantiationFailed(string, string2, string3, "not instantiable", invocationTargetException.getTargetException());
        }
        catch (Exception exception) {
            throw this.instantiationFailed(string, string2, string3, "not valid", exception);
        }
    }

    private IllegalArgumentException instantiationFailed(String string, String string2, String string3, String string4, Throwable throwable) {
        this.logger.error(4).append("App {").append(string).append(".").append(string2).append("} adapter proxy - proxy class '").append(string3).append("' ").append(string4).append(".").attachThrowable(throwable).log();
        return new IllegalArgumentException(new StringBuffer().append("App adapter proxy class '").append(string3).append("' ").append(string4).append(".").toString());
    }

    private String simpleNameOf(String string) {
        return string.substring(string.lastIndexOf(46) + 1);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        UNKNOWN_CLIENT_PROXY_CLASS_NAME = null;
    }
}

