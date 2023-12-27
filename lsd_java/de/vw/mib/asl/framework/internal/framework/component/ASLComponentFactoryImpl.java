/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.component;

import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.framework.api.framework.component.ASLComponent;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentFactory;
import de.vw.mib.log4mib.ClassifiedLogger;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;

public class ASLComponentFactoryImpl
implements ASLComponentFactory {
    private final Services services;
    private final LoggerFactory loggerFactory;
    private final ClassifiedLogger fwLogger;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$framework$component$ASLComponent;

    public ASLComponentFactoryImpl(Services services, LoggerFactory loggerFactory, ClassifiedLogger classifiedLogger) {
        this.services = services;
        this.loggerFactory = loggerFactory;
        this.fwLogger = classifiedLogger;
    }

    @Override
    public ASLComponent createComponent(Class clazz, int n) {
        ASLComponent aSLComponent;
        block5: {
            if (null == clazz) {
                throw new NullPointerException("implClass");
            }
            LogMessage logMessage = this.fwLogger.trace();
            if (null != logMessage) {
                logMessage.append("createComponent: class=").append(clazz.getName()).log();
            }
            if (!clazz.isInstance(class$de$vw$mib$asl$framework$api$framework$component$ASLComponent == null ? (class$de$vw$mib$asl$framework$api$framework$component$ASLComponent = ASLComponentFactoryImpl.class$("de.vw.mib.asl.framework.api.framework.component.ASLComponent")) : class$de$vw$mib$asl$framework$api$framework$component$ASLComponent)) {
                throw new IllegalArgumentException(new StringBuffer().append("Not in implementation of ASLComponent: ").append(clazz.getName()).toString());
            }
            try {
                aSLComponent = (ASLComponent)clazz.newInstance();
                Logger logger = this.loggerFactory.getLogger(n);
                aSLComponent.init(logger, this.services);
            }
            catch (Exception exception) {
                aSLComponent = null;
                logMessage = this.fwLogger.error();
                if (null == logMessage) break block5;
                logMessage.append("Could not create ASLComponent: class=").append(clazz.getName()).attachThrowable(exception).log();
            }
        }
        return aSLComponent;
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

