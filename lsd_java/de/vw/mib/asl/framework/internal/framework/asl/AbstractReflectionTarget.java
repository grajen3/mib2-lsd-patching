/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.asl;

import de.vw.mib.asl.framework.api.framework.reflection.MethodAccessible;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.asl.AbstractReflectionContext;
import de.vw.mib.asl.framework.internal.framework.asl.AbstractReflectionSubject;
import de.vw.mib.asl.framework.internal.framework.asl.ApiHandler;
import de.vw.mib.asl.framework.internal.framework.asl.EventNameResolver;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.reflection.MethodAccessibleObject;
import java.util.ArrayList;

public class AbstractReflectionTarget
extends AbstractTarget
implements ApiHandler,
MethodAccessible {
    IntOptHashSet regEvents = new IntOptHashSet();
    public boolean traceFuntionNames = true;
    final MethodAccessibleObject mao;
    private ArrayList subjects = new ArrayList();
    static /* synthetic */ Class class$de$vw$mib$asl$framework$internal$framework$asl$AbstractReflectionContext;

    @Override
    public void regEvt(int n) {
        this.regEvents.add(n);
    }

    @Override
    public boolean isFuntionNameTracing() {
        return this.traceFuntionNames && this.isTraceEnabled();
    }

    private void registerForEvents() {
        IntIterator intIterator = this.regEvents.iterator();
        while (intIterator.hasNext()) {
            int n = intIterator.next();
            this.addObserver(n);
        }
    }

    public String getMyShortName() {
        String string = super.getClass().getName();
        int n = string.lastIndexOf(46);
        if (n != -1) {
            string = string.substring(n + 1);
        }
        if (string == null || string.length() == 0) {
            string = "hsm";
        }
        return string;
    }

    AbstractReflectionTarget(GenericEvents genericEvents) {
        super(genericEvents);
        this.mao = ServiceManager.reflectionFactory.getMao(super.getClass().getName());
    }

    public void addSubject(AbstractReflectionSubject abstractReflectionSubject) {
        this.subjects.add(abstractReflectionSubject);
    }

    @Override
    public final void gotEvent(EventGeneric eventGeneric) {
        if (eventGeneric.getReceiverEventId() == 106) {
            this.registerForEvents();
        }
        try {
            int n;
            String string = EventNameResolver.resolveEventName(eventGeneric.getReceiverEventId());
            Object[] objectArray = new Object[eventGeneric.getParamCount() + 1];
            Class[] classArray = new Class[eventGeneric.getParamCount() + 1];
            for (n = 0; n < objectArray.length - 1; ++n) {
                Object object;
                objectArray[n + 1] = object = eventGeneric.getPrimitiveObject(n);
                classArray[n + 1] = object.getClass();
            }
            objectArray[0] = new AbstractReflectionContext();
            classArray[0] = class$de$vw$mib$asl$framework$internal$framework$asl$AbstractReflectionContext == null ? (class$de$vw$mib$asl$framework$internal$framework$asl$AbstractReflectionContext = AbstractReflectionTarget.class$("de.vw.mib.asl.framework.internal.framework.asl.AbstractReflectionContext")) : class$de$vw$mib$asl$framework$internal$framework$asl$AbstractReflectionContext;
            n = 1;
            for (int i2 = 0; i2 < this.subjects.size(); ++i2) {
                n &= ((AbstractReflectionSubject)this.subjects.get(i2)).handleBefore(string, classArray, objectArray);
            }
            if (n != 0) {
                int n2;
                if (this.traceFuntionNames && this.isTraceEnabled()) {
                    LogMessage logMessage = ServiceManager.logger.trace(16384).append("ENTER ").append(super.getClass().getName()).append(".").append(string).append("(");
                    for (n2 = 0; n2 < objectArray.length; ++n2) {
                        if (n2 > 0) {
                            logMessage = logMessage.append(", ");
                        }
                        logMessage = logMessage.append(objectArray[n2]);
                    }
                    logMessage.append(" )").log();
                }
                for (int i3 = 0; i3 < this.subjects.size(); ++i3) {
                    ((AbstractReflectionSubject)this.subjects.get(i3)).handleNormal(string, classArray, objectArray);
                }
                this.mao.invoke(new StringBuffer().append("evt").append(string).toString(), classArray, this, objectArray);
                if (this.traceFuntionNames && this.isTraceEnabled()) {
                    LogMessage logMessage = ServiceManager.logger.trace(16384).append("LEAVE ").append(super.getClass().getName()).append(".").append(string).append("(");
                    for (n2 = 0; n2 < objectArray.length; ++n2) {
                        if (n2 > 0) {
                            logMessage = logMessage.append(", ");
                        }
                        logMessage = logMessage.append(objectArray[n2]);
                    }
                    logMessage.append(" )").log();
                }
                for (int i4 = 0; i4 < this.subjects.size(); ++i4) {
                    ((AbstractReflectionSubject)this.subjects.get(i4)).handleAfter(string, classArray, objectArray);
                }
            }
        }
        catch (Throwable throwable) {
            ServiceManager.errorHandler.handleError(throwable);
        }
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

