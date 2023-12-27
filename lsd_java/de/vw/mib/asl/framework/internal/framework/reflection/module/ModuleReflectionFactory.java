/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.reflection.module;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.DSIProxyException;
import de.vw.mib.asl.framework.internal.framework.reflection.ReflectionException;
import de.vw.mib.asl.framework.internal.framework.reflection.module.ModuleReflectionConfiguration;
import de.vw.mib.asl.framework.internal.framework.reflection.util.Constants;
import de.vw.mib.reflection.MethodAccessibleObject;
import de.vw.mib.reflection.MultipleConstructorAccessibleObject;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ModuleReflectionFactory {
    private boolean preloaded;
    private final ModuleReflectionConfiguration configuration;
    private MultipleConstructorAccessibleObject factoryMCAO;
    private MultipleMethodAccessibleObject targetsMMAO;
    private MultipleMethodAccessibleObject hsmStatesMMAO;
    private MethodAccessibleObject[] generalMAOs;

    public ModuleReflectionFactory(ModuleReflectionConfiguration moduleReflectionConfiguration) {
        this.configuration = moduleReflectionConfiguration;
    }

    public void preload() {
        if (!this.preloaded) {
            this.getTargetsMmao();
            this.getHsmStatesMmao();
            for (int i2 = 0; i2 < this.configuration.getMaosIds().length; ++i2) {
                this.getMao(this.configuration.getMaosIds()[i2]);
            }
            this.preloaded = true;
        }
    }

    public ModuleReflectionConfiguration getConfiguration() {
        return this.configuration;
    }

    public boolean supportTarget(String string) {
        return Arrays.binarySearch(this.configuration.getSupportedTargetsClassesNames(), string) >= 0;
    }

    public boolean supportHsmState(String string) {
        return Arrays.binarySearch(this.configuration.getSupportedHsmStatesClassesNames(), string) >= 0;
    }

    public boolean isSupportingMAOClass(String string) {
        return 0 <= this.getMethodAccessibleIdx(string);
    }

    public MultipleMethodAccessibleObject getTargetsMmao() {
        try {
            if (this.targetsMMAO == null) {
                this.targetsMMAO = (MultipleMethodAccessibleObject)this.getFactoryMcao().newInstance(this.configuration.getTargetsMmaoId(), Constants.Z_ARGS);
            }
            return this.targetsMMAO;
        }
        catch (InvocationTargetException invocationTargetException) {
            if (ServiceManager.loggerDSIProxy != null) {
                ServiceManager.loggerDSIProxy.error().append("Could not instance asl targets mmao. ").append(invocationTargetException.getTargetException().getMessage()).log();
            }
            throw new DSIProxyException(invocationTargetException.getTargetException());
        }
    }

    public MultipleMethodAccessibleObject getHsmStatesMmao() {
        try {
            if (this.hsmStatesMMAO == null) {
                this.hsmStatesMMAO = (MultipleMethodAccessibleObject)this.getFactoryMcao().newInstance(this.configuration.getHsmStatesMmaoId(), Constants.Z_ARGS);
            }
            return this.hsmStatesMMAO;
        }
        catch (InvocationTargetException invocationTargetException) {
            if (ServiceManager.loggerDSIProxy != null) {
                ServiceManager.loggerDSIProxy.error().append("Could not instance asl hsm states mmao. ").append(invocationTargetException.getTargetException().getMessage()).log();
            }
            throw new DSIProxyException(invocationTargetException.getTargetException());
        }
    }

    public MethodAccessibleObject getMAO(String string) {
        int n = this.getMethodAccessibleIdx(string);
        return this.getMao(n);
    }

    public int getMethodAccessibleIdx(String string) {
        return Arrays.binarySearch(this.configuration.getSupportedMethodAccessibleClassesNames(), string);
    }

    public MethodAccessibleObject getMao(int n) {
        try {
            if (this.generalMAOs == null) {
                this.generalMAOs = new MethodAccessibleObject[this.configuration.getMaosIds().length];
            }
            if (this.generalMAOs[n] == null) {
                this.generalMAOs[n] = (MethodAccessibleObject)this.getFactoryMcao().newInstance(this.configuration.getMaosIds()[n], Constants.Z_ARGS);
            }
            return this.generalMAOs[n];
        }
        catch (InvocationTargetException invocationTargetException) {
            if (ServiceManager.loggerDSIProxy != null) {
                ServiceManager.loggerDSIProxy.error().append("Could not instance mao. ").append(invocationTargetException.getTargetException().getMessage()).log();
            }
            throw new DSIProxyException(invocationTargetException.getTargetException());
        }
    }

    private MultipleConstructorAccessibleObject getFactoryMcao() {
        if (this.factoryMCAO == null) {
            try {
                Class clazz = Class.forName(this.configuration.getFactoryMcaoClassName());
                this.factoryMCAO = (MultipleConstructorAccessibleObject)clazz.newInstance();
            }
            catch (Throwable throwable) {
                if (ServiceManager.loggerDSIProxy != null) {
                    ServiceManager.loggerDSIProxy.error().append("Could not initialize module reflection factory. ").append(throwable.getMessage()).log();
                }
                throw new ReflectionException(throwable);
            }
        }
        return this.factoryMCAO;
    }
}

