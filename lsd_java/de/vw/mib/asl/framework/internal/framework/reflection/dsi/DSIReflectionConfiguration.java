/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.reflection.dsi;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.reflection.ReflectionException;
import de.vw.mib.asl.framework.internal.framework.reflection.util.Constants;

public class DSIReflectionConfiguration {
    private String compiledConstantsClassName;
    private boolean init = false;
    private String factoryMcaoClassName;
    private int[] servicesProxyIds = new int[Constants.SERVICE_C];
    private int[] servicesMmaoIds = new int[Constants.SERVICE_C];
    private int[] listenersProxyIds = new int[Constants.LISTENER_C];
    private int[] listenersMmaoIds = new int[Constants.LISTENER_C];
    private int syncCmpAnalyzersMcaoId;

    public DSIReflectionConfiguration(String string) {
        this.compiledConstantsClassName = string;
    }

    public String getFactoryMcaoClassName() {
        this.initCheck();
        return this.factoryMcaoClassName;
    }

    public int[] getServicesProxyIds() {
        this.initCheck();
        return this.servicesProxyIds;
    }

    public int[] getServicesMmaoIds() {
        this.initCheck();
        return this.servicesMmaoIds;
    }

    public int[] getListenersProxyIds() {
        this.initCheck();
        return this.listenersProxyIds;
    }

    public int[] getListenersMmaoIds() {
        this.initCheck();
        return this.listenersMmaoIds;
    }

    public int getSyncCmpAnalyzersMcaoId() {
        this.initCheck();
        return this.syncCmpAnalyzersMcaoId;
    }

    private void initCheck() {
        if (!this.init) {
            this.init();
        }
    }

    private void init() {
        try {
            Class clazz = Class.forName(this.compiledConstantsClassName);
            Object[] objectArray = (Object[])clazz.getField("CFG").get(null);
            this.factoryMcaoClassName = (String)objectArray[0];
            this.servicesProxyIds = (int[])objectArray[1];
            this.servicesMmaoIds = (int[])objectArray[2];
            this.listenersProxyIds = (int[])objectArray[3];
            this.listenersMmaoIds = (int[])objectArray[4];
            this.syncCmpAnalyzersMcaoId = (Integer)objectArray[5];
            this.init = true;
        }
        catch (Throwable throwable) {
            if (ServiceManager.loggerDSIProxy != null) {
                ServiceManager.loggerDSIProxy.error().append("Could not retrieve dsi reflection configuration. ").append(throwable.getMessage()).log();
            }
            throw new ReflectionException(throwable);
        }
    }
}

