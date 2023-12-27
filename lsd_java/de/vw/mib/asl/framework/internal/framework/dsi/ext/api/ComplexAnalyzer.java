/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.dsi.ext.api;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.util.Utils;

public abstract class ComplexAnalyzer {
    protected boolean finished;
    protected int analyzedServiceMethodId;

    public boolean isFinished() {
        return this.finished;
    }

    public void setPrecondition(int n) {
        this.analyzedServiceMethodId = n;
        this.finished = false;
    }

    protected int getServiceMethodId(Class clazz, String string) {
        Utils.checkDSIServiceType(clazz);
        int n = Utils.getTypeIndex(clazz);
        return ServiceManager.reflectionFactory.getServicesMmao(n).getIndex(clazz.getName(), string);
    }

    protected int getServiceMethodId(Class clazz, String string, Class[] classArray) {
        Utils.checkDSIServiceType(clazz);
        int n = Utils.getTypeIndex(clazz);
        return ServiceManager.reflectionFactory.getServicesMmao(n).getIndex(clazz.getName(), string, classArray);
    }
}

