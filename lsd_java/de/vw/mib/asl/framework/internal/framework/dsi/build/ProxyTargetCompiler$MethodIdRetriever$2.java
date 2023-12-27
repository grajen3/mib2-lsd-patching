/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.dsi.build;

import de.vw.mib.asl.framework.internal.framework.dsi.build.ProxyTargetCompiler$MethodIdRetriever;
import de.vw.mib.asl.framework.internal.framework.reflection.dsi.DSIReflectionFactory;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;

final class ProxyTargetCompiler$MethodIdRetriever$2
extends ProxyTargetCompiler$MethodIdRetriever {
    private final /* synthetic */ DSIReflectionFactory val$factory;

    ProxyTargetCompiler$MethodIdRetriever$2(String[] stringArray, DSIReflectionFactory dSIReflectionFactory) {
        this.val$factory = dSIReflectionFactory;
        super(stringArray);
    }

    @Override
    protected MultipleMethodAccessibleObject getMMAO(int n) {
        return this.val$factory.getServicesMmao(n);
    }
}

