/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.dsi.build;

import de.vw.mib.asl.framework.internal.framework.dsi.build.ProxyTargetCompiler$MethodIdRetriever$1;
import de.vw.mib.asl.framework.internal.framework.dsi.build.ProxyTargetCompiler$MethodIdRetriever$2;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.framework.internal.framework.reflection.dsi.DSIReflectionFactory;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;

abstract class ProxyTargetCompiler$MethodIdRetriever {
    private final String[] classNames;

    static ProxyTargetCompiler$MethodIdRetriever createListenersIdsRetriever(DSIReflectionFactory dSIReflectionFactory) {
        return new ProxyTargetCompiler$MethodIdRetriever$1(RuntimeGeneratedConstants.LISTENER_TS_NS, dSIReflectionFactory);
    }

    static ProxyTargetCompiler$MethodIdRetriever createServicesIdsRetriever(DSIReflectionFactory dSIReflectionFactory) {
        return new ProxyTargetCompiler$MethodIdRetriever$2(RuntimeGeneratedConstants.SERVICE_TS_NS, dSIReflectionFactory);
    }

    protected ProxyTargetCompiler$MethodIdRetriever(String[] stringArray) {
        this.classNames = stringArray;
    }

    int get(int n, String string) {
        return this.getMMAO(n).getIndex(this.classNames[n], string);
    }

    protected abstract MultipleMethodAccessibleObject getMMAO(int n) {
    }
}

