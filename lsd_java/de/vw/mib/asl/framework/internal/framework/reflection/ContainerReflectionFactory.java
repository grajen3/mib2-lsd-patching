/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.reflection;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.reflection.ReflectionException;
import de.vw.mib.asl.framework.internal.framework.reflection.dsi.DSIReflectionFactory;
import de.vw.mib.asl.framework.internal.framework.reflection.module.ModuleReflectionConfiguration;
import de.vw.mib.asl.framework.internal.framework.reflection.module.ModuleReflectionFactory;
import de.vw.mib.reflection.InvocationHandler;
import de.vw.mib.reflection.MethodAccessibleObject;
import de.vw.mib.reflection.MultipleConstructorAccessibleObject;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.pool.ObjArrayPool;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;

public class ContainerReflectionFactory {
    private final DSIReflectionFactory dsiReflectionFactory;
    private final Map hsmStateFactories = new HashMap();
    private final Map maoFactories = new HashMap();
    private final Map targetFactories = new HashMap();
    private final Set failedClassNames = new HashSet();
    private final List moduleReflectionPackages = new LinkedList();

    public ContainerReflectionFactory(DSIReflectionFactory dSIReflectionFactory) {
        this.dsiReflectionFactory = dSIReflectionFactory;
    }

    private ModuleReflectionFactory createModuleReflectionFactory(String string) {
        ModuleReflectionFactory moduleReflectionFactory;
        block3: {
            if (ServiceManager.loggerDSIProxy != null && ServiceManager.loggerDSIProxy.isTraceEnabled()) {
                ServiceManager.loggerDSIProxy.trace().append("Loading module reflection for package ").append(string).log();
            }
            try {
                Class clazz = ModuleReflectionConfiguration.loadConfigurationClass(string);
                ModuleReflectionConfiguration moduleReflectionConfiguration = ModuleReflectionConfiguration.create(clazz);
                moduleReflectionFactory = new ModuleReflectionFactory(moduleReflectionConfiguration);
                this.register(moduleReflectionFactory);
            }
            catch (ReflectionException reflectionException) {
                moduleReflectionFactory = null;
                if (ServiceManager.loggerDSIProxy == null) break block3;
                ServiceManager.loggerDSIProxy.error().append(reflectionException.getMessage()).log();
            }
        }
        return moduleReflectionFactory;
    }

    private static void storeAll(Map map, Object[] objectArray, Object object) {
        int n;
        if (null != objectArray && 0 < (n = objectArray.length)) {
            for (int i2 = 0; i2 < n; ++i2) {
                map.put(objectArray[i2], object);
            }
        }
    }

    private void register(ModuleReflectionFactory moduleReflectionFactory) {
        ModuleReflectionConfiguration moduleReflectionConfiguration = moduleReflectionFactory.getConfiguration();
        ContainerReflectionFactory.storeAll(this.hsmStateFactories, moduleReflectionConfiguration.getSupportedHsmStatesClassesNames(), moduleReflectionFactory);
        ContainerReflectionFactory.storeAll(this.maoFactories, moduleReflectionConfiguration.getSupportedMethodAccessibleClassesNames(), moduleReflectionFactory);
        ContainerReflectionFactory.storeAll(this.targetFactories, moduleReflectionConfiguration.getSupportedTargetsClassesNames(), moduleReflectionFactory);
    }

    public void registerModuleReflectionPackage(String string) {
        this.moduleReflectionPackages.add(string);
        this.failedClassNames.clear();
    }

    public DSIBase newServicesProxy(int n, ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        if (this.dsiReflectionFactory != null) {
            return this.dsiReflectionFactory.newServicesProxy(n, objArrayPool, invocationHandler);
        }
        throw new ReflectionException("Could not instantiate dsi services proxy. The dsi reflection factory is null.");
    }

    public MultipleMethodAccessibleObject getServicesMmao(int n) {
        if (this.dsiReflectionFactory != null) {
            return this.dsiReflectionFactory.getServicesMmao(n);
        }
        throw new ReflectionException("Could not instantiate dsi services mmao. The dsi reflection factory is null.");
    }

    public DSIListener newListenersProxy(int n, ObjArrayPool objArrayPool, InvocationHandler invocationHandler) {
        if (this.dsiReflectionFactory != null) {
            return this.dsiReflectionFactory.newListenersProxy(n, objArrayPool, invocationHandler);
        }
        throw new ReflectionException("Could not instantiate dsi listeners proxy. The dsi reflection factory is null.");
    }

    public MultipleMethodAccessibleObject getListenersMmao(int n) {
        if (this.dsiReflectionFactory != null) {
            return this.dsiReflectionFactory.getListenersMmao(n);
        }
        throw new ReflectionException("Could not instantiate dsi services mmao. The dsi reflection factory is null.");
    }

    public MultipleConstructorAccessibleObject getSyncCmpAnalyzersMcao() {
        if (this.dsiReflectionFactory != null) {
            return this.dsiReflectionFactory.getSyncCmpAnalyzersMcao();
        }
        throw new ReflectionException("Could not instantiate dsi complex analyzers mcao. The dsi reflection factory is null.");
    }

    public MultipleMethodAccessibleObject getTargetsMmao(String string) {
        ModuleReflectionFactory moduleReflectionFactory = (ModuleReflectionFactory)this.targetFactories.get(string);
        if (null == moduleReflectionFactory) {
            Iterator iterator = this.moduleReflectionPackages.iterator();
            while (null == moduleReflectionFactory && iterator.hasNext()) {
                String string2 = (String)iterator.next();
                iterator.remove();
                ModuleReflectionFactory moduleReflectionFactory2 = this.createModuleReflectionFactory(string2);
                if (null == moduleReflectionFactory2 || !moduleReflectionFactory2.supportTarget(string)) continue;
                moduleReflectionFactory = moduleReflectionFactory2;
            }
        }
        if (null == moduleReflectionFactory) {
            throw new ReflectionException(new StringBuffer().append("Cannot instantiate MMAO for target class ").append(string).toString());
        }
        return moduleReflectionFactory.getTargetsMmao();
    }

    public MultipleMethodAccessibleObject getHsmStatesMmao(String string) {
        ModuleReflectionFactory moduleReflectionFactory;
        if (this.failedClassNames.contains(string)) {
            moduleReflectionFactory = null;
        } else {
            moduleReflectionFactory = (ModuleReflectionFactory)this.hsmStateFactories.get(string);
            if (null == moduleReflectionFactory) {
                Iterator iterator = this.moduleReflectionPackages.iterator();
                while (null == moduleReflectionFactory && iterator.hasNext()) {
                    String string2 = (String)iterator.next();
                    iterator.remove();
                    ModuleReflectionFactory moduleReflectionFactory2 = this.createModuleReflectionFactory(string2);
                    if (null == moduleReflectionFactory2 || !moduleReflectionFactory2.supportHsmState(string)) continue;
                    moduleReflectionFactory = moduleReflectionFactory2;
                }
                if (null == moduleReflectionFactory) {
                    this.failedClassNames.add(string);
                    if (null != ServiceManager.loggerDSIProxy) {
                        ServiceManager.loggerDSIProxy.error().append("Cannot instantiate MMAO for HSM state class ").append(string).log();
                    }
                }
            }
        }
        return null != moduleReflectionFactory ? moduleReflectionFactory.getHsmStatesMmao() : (MultipleMethodAccessibleObject)null;
    }

    public MethodAccessibleObject getMao(String string) {
        ModuleReflectionFactory moduleReflectionFactory = (ModuleReflectionFactory)this.maoFactories.get(string);
        if (null == moduleReflectionFactory) {
            Iterator iterator = this.moduleReflectionPackages.iterator();
            while (null == moduleReflectionFactory && iterator.hasNext()) {
                String string2 = (String)iterator.next();
                iterator.remove();
                ModuleReflectionFactory moduleReflectionFactory2 = this.createModuleReflectionFactory(string2);
                if (null == moduleReflectionFactory2 || !moduleReflectionFactory2.isSupportingMAOClass(string)) continue;
                moduleReflectionFactory = moduleReflectionFactory2;
            }
        }
        if (null == moduleReflectionFactory) {
            throw new ReflectionException(new StringBuffer().append("Cannot instantiate MAO for class ").append(string).toString());
        }
        return moduleReflectionFactory.getMAO(string);
    }
}

