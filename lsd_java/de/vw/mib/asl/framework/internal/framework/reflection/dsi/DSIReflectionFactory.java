/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.reflection.dsi;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.framework.internal.framework.reflection.ReflectionException;
import de.vw.mib.asl.framework.internal.framework.reflection.dsi.DSIReflectionConfiguration;
import de.vw.mib.asl.framework.internal.framework.reflection.util.Constants;
import de.vw.mib.reflection.InvocationHandler;
import de.vw.mib.reflection.MultipleConstructorAccessibleObject;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.pool.ObjArrayPool;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;

public class DSIReflectionFactory {
    private boolean preloaded = false;
    private DSIReflectionConfiguration configuration;
    private MultipleConstructorAccessibleObject factoryMcao;
    private MultipleMethodAccessibleObject[] servicesMmaos = new MultipleMethodAccessibleObject[Constants.SERVICE_C];
    private MultipleMethodAccessibleObject[] listenersMmaos = new MultipleMethodAccessibleObject[Constants.LISTENER_C];
    private MultipleConstructorAccessibleObject syncCmpAnalyzersMcao;
    private static final Class[] PROXY_CONSTRUCTOR_PARAMS = new Class[]{class$de$vw$mib$reflection$pool$ObjArrayPool == null ? (class$de$vw$mib$reflection$pool$ObjArrayPool = DSIReflectionFactory.class$("de.vw.mib.reflection.pool.ObjArrayPool")) : class$de$vw$mib$reflection$pool$ObjArrayPool, class$de$vw$mib$reflection$InvocationHandler == null ? (class$de$vw$mib$reflection$InvocationHandler = DSIReflectionFactory.class$("de.vw.mib.reflection.InvocationHandler")) : class$de$vw$mib$reflection$InvocationHandler};
    private static Object[] CONSTRUCTOR_ARGS_POOL;
    static /* synthetic */ Class class$de$vw$mib$reflection$pool$ObjArrayPool;
    static /* synthetic */ Class class$de$vw$mib$reflection$InvocationHandler;

    public DSIReflectionFactory(DSIReflectionConfiguration dSIReflectionConfiguration) {
        this.configuration = dSIReflectionConfiguration;
    }

    public void preload() {
        if (!this.preloaded) {
            int n;
            for (n = 0; n < RuntimeGeneratedConstants.SERVICE_TS_NS.length; ++n) {
                this.newServicesProxy(n, null, null);
                this.getServicesMmao(n);
            }
            for (n = 0; n < RuntimeGeneratedConstants.LISTENER_TS_NS.length; ++n) {
                this.newListenersProxy(n, null, null);
                this.getListenersMmao(n);
            }
            this.getSyncCmpAnalyzersMcao();
            this.preloaded = true;
        }
    }

    public DSIBase newServicesProxy(int n, ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        Object[] objectArray = DSIReflectionFactory.createProxyConstructorArgs(objArrayPool, invocationHandler);
        try {
            int n2 = n >> 1;
            DSIBase dSIBase = (DSIBase)this.getFactoryMcao().newInstance(this.configuration.getServicesProxyIds()[n2], objectArray);
            return dSIBase;
        }
        catch (InvocationTargetException invocationTargetException) {
            if (ServiceManager.loggerDSIProxy != null) {
                ServiceManager.loggerDSIProxy.error().append("Could not instantiate dsi services proxy. ").append(invocationTargetException.getTargetException().getMessage()).log();
            }
            throw new ReflectionException(invocationTargetException.getTargetException());
        }
        finally {
            DSIReflectionFactory.releaseProxyConstructorArgs(objectArray);
        }
    }

    public MultipleMethodAccessibleObject getServicesMmao(int n) {
        try {
            int n2 = n >> 1;
            MultipleMethodAccessibleObject multipleMethodAccessibleObject = this.servicesMmaos[n2];
            if (multipleMethodAccessibleObject == null) {
                this.servicesMmaos[n2] = multipleMethodAccessibleObject = (MultipleMethodAccessibleObject)this.getFactoryMcao().newInstance(this.configuration.getServicesMmaoIds()[n2], Constants.Z_ARGS);
            }
            return multipleMethodAccessibleObject;
        }
        catch (InvocationTargetException invocationTargetException) {
            if (ServiceManager.loggerDSIProxy != null) {
                ServiceManager.loggerDSIProxy.error().append("Could not instantiate dsi services mmao. ").append(invocationTargetException.getTargetException().getMessage()).log();
            }
            throw new ReflectionException(invocationTargetException.getTargetException());
        }
    }

    public DSIListener newListenersProxy(int n, ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        Object[] objectArray = DSIReflectionFactory.createProxyConstructorArgs(objArrayPool, invocationHandler);
        try {
            int n2 = n >> 1;
            DSIListener dSIListener = (DSIListener)this.getFactoryMcao().newInstance(this.configuration.getListenersProxyIds()[n2], objectArray);
            return dSIListener;
        }
        catch (InvocationTargetException invocationTargetException) {
            if (ServiceManager.loggerDSIProxy != null) {
                ServiceManager.loggerDSIProxy.error().append("Could not instantiate dsi listeners proxy. ").append(invocationTargetException.getTargetException().getMessage()).log();
            }
            throw new ReflectionException(invocationTargetException.getTargetException());
        }
        finally {
            DSIReflectionFactory.releaseProxyConstructorArgs(objectArray);
        }
    }

    private static synchronized Object[] createProxyConstructorArgs(ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        Object[] objectArray;
        if (null != CONSTRUCTOR_ARGS_POOL) {
            objectArray = CONSTRUCTOR_ARGS_POOL;
            CONSTRUCTOR_ARGS_POOL = (Object[])objectArray[0];
        } else {
            objectArray = new Object[PROXY_CONSTRUCTOR_PARAMS.length];
        }
        objectArray[0] = objArrayPool;
        objectArray[1] = invocationHandler;
        return objectArray;
    }

    private static synchronized void releaseProxyConstructorArgs(Object[] objectArray) {
        objectArray[0] = CONSTRUCTOR_ARGS_POOL;
        objectArray[1] = null;
        CONSTRUCTOR_ARGS_POOL = objectArray;
    }

    public MultipleMethodAccessibleObject getListenersMmao(int n) {
        try {
            int n2 = n >> 1;
            MultipleMethodAccessibleObject multipleMethodAccessibleObject = this.listenersMmaos[n2];
            if (multipleMethodAccessibleObject == null) {
                this.listenersMmaos[n2] = multipleMethodAccessibleObject = (MultipleMethodAccessibleObject)this.getFactoryMcao().newInstance(this.configuration.getListenersMmaoIds()[n2], Constants.Z_ARGS);
            }
            return multipleMethodAccessibleObject;
        }
        catch (InvocationTargetException invocationTargetException) {
            if (ServiceManager.loggerDSIProxy != null) {
                ServiceManager.loggerDSIProxy.error().append("Could not instantiate dsi services mmao. ").append(invocationTargetException.getTargetException().getMessage()).log();
            }
            throw new ReflectionException(invocationTargetException.getTargetException());
        }
    }

    public MultipleConstructorAccessibleObject getSyncCmpAnalyzersMcao() {
        try {
            if (this.syncCmpAnalyzersMcao == null) {
                this.syncCmpAnalyzersMcao = (MultipleConstructorAccessibleObject)this.getFactoryMcao().newInstance(this.configuration.getSyncCmpAnalyzersMcaoId(), Constants.Z_ARGS);
            }
            return this.syncCmpAnalyzersMcao;
        }
        catch (InvocationTargetException invocationTargetException) {
            if (ServiceManager.loggerDSIProxy != null) {
                ServiceManager.loggerDSIProxy.error().append("Could not instantiate dsi complex analyzers mcao. ").append(invocationTargetException.getTargetException().getMessage()).log();
            }
            throw new ReflectionException(invocationTargetException.getTargetException());
        }
    }

    private MultipleConstructorAccessibleObject getFactoryMcao() {
        if (this.factoryMcao == null) {
            try {
                Class clazz = Class.forName(this.configuration.getFactoryMcaoClassName());
                this.factoryMcao = (MultipleConstructorAccessibleObject)clazz.newInstance();
            }
            catch (Throwable throwable) {
                if (ServiceManager.loggerDSIProxy != null) {
                    ServiceManager.loggerDSIProxy.error().append("Could not initialize dsi reflection factory. ").append(throwable.getMessage()).log();
                }
                throw new ReflectionException(throwable);
            }
        }
        return this.factoryMcao;
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

