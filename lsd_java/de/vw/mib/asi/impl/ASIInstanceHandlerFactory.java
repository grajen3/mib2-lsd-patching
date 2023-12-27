/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.impl;

import de.vw.mib.asi.impl.ASIInstanceHandler;
import de.vw.mib.asi.impl.ASIServiceFactory;
import de.vw.mib.asi.impl.ASIServiceInstanceHandler;
import de.vw.mib.asi.impl.PrivateServiceInstanceHandler;
import de.vw.mib.log4mib.ClassifiedLogger;
import org.osgi.framework.BundleContext;

class ASIInstanceHandlerFactory {
    private final BundleContext context;
    private final ClassifiedLogger clogger;
    private final ASIServiceFactory factory;

    ASIInstanceHandlerFactory(BundleContext bundleContext, ClassifiedLogger classifiedLogger, ASIServiceFactory aSIServiceFactory) {
        this.context = bundleContext;
        this.clogger = classifiedLogger;
        this.factory = aSIServiceFactory;
    }

    ASIInstanceHandler createPrivateHandler(Class clazz) {
        return new PrivateServiceInstanceHandler(this.clogger, clazz);
    }

    ASIInstanceHandler createASIHandler(Class clazz, String string) {
        return new ASIServiceInstanceHandler(this.context, this.clogger, this.factory, clazz, string);
    }
}

