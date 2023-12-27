/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.impl;

import de.vw.mib.asi.ASIProperties;
import de.vw.mib.asi.ASIService;
import de.vw.mib.asi.ASIServiceProvider;
import de.vw.mib.asi.impl.ASIInstanceHandler;
import de.vw.mib.asi.instance.ASIInstanceResponse;
import de.vw.mib.log4mib.ClassifiedLogger;

public class PrivateServiceInstanceHandler
implements ASIInstanceHandler {
    private final ClassifiedLogger clogger;
    private final Class serviceClass;

    PrivateServiceInstanceHandler(ClassifiedLogger classifiedLogger, Class clazz) {
        this.clogger = classifiedLogger;
        this.serviceClass = clazz;
    }

    @Override
    public void registerService(int n, String string, ASIService aSIService, ASIProperties aSIProperties) {
    }

    @Override
    public void requestInstanceId(String string, ASIInstanceResponse aSIInstanceResponse) {
    }

    @Override
    public void setServiceProvider(ASIServiceProvider aSIServiceProvider) {
    }

    @Override
    public void unregisterService(int n) {
    }
}

