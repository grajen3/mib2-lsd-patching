/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.asl;

import de.vw.mib.asl.framework.api.framework.reflection.MethodAccessible;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.asl.AbstractReflectionContext;
import de.vw.mib.asl.framework.internal.framework.asl.AbstractReflectionHsmTarget;
import de.vw.mib.asl.framework.internal.framework.asl.AbstractReflectionSubject;
import de.vw.mib.asl.framework.internal.framework.asl.EventNameResolver;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.reflection.MethodAccessibleObject;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class AbstractReflectionState
extends AbstractHsmState
implements MethodAccessible {
    public final MethodAccessibleObject mao;
    public final AbstractReflectionHsmTarget myTarget;
    private ArrayList subjects = new ArrayList();

    public void addSubject(AbstractReflectionSubject abstractReflectionSubject) {
        this.subjects.add(abstractReflectionSubject);
    }

    public AbstractReflectionState(AbstractReflectionHsmTarget abstractReflectionHsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mao = ServiceManager.reflectionFactory.getMao(super.getClass().getName());
        this.myTarget = abstractReflectionHsmTarget;
        Method[] methodArray = super.getClass().getMethods();
        for (int i2 = 0; i2 < methodArray.length; ++i2) {
            String string2 = methodArray[i2].getName();
            if (!string2.startsWith("evtASL")) continue;
            try {
                int n = EventNameResolver.resolveEventId(string2.substring(3));
                this.myTarget.regEvt(n);
                continue;
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    @Override
    public final HsmState handle(EventGeneric eventGeneric) {
        String string;
        Object[] objectArray;
        Class[] classArray;
        Object object;
        HsmState hsmState = this.getParent();
        if (eventGeneric.getParamCount() < 3) {
            object = this.myTarget.getCurrentContext();
            classArray = new Class[]{super.getClass()};
            objectArray = new Object[]{object};
            string = EventNameResolver.resolveEventName(eventGeneric.getReceiverEventId());
            eventGeneric.setObject(eventGeneric.getParamCount(), classArray);
            eventGeneric.setObject(eventGeneric.getParamCount(), objectArray);
            eventGeneric.setObject(eventGeneric.getParamCount(), string);
        } else {
            classArray = (Class[])eventGeneric.getObject(eventGeneric.getParamCount() - 3);
            objectArray = (Object[])eventGeneric.getObject(eventGeneric.getParamCount() - 2);
            string = (String)eventGeneric.getObject(eventGeneric.getParamCount() - 1);
        }
        ((AbstractReflectionContext)objectArray[0]).put("state", this);
        if (!((AbstractReflectionContext)objectArray[0]).containsKey("target")) {
            ((AbstractReflectionContext)objectArray[0]).put("target", this.myTarget);
        }
        object = new StringBuffer().append("evt").append(string).toString();
        try {
            int n;
            boolean bl = true;
            for (n = 0; n < this.subjects.size(); ++n) {
                bl &= ((AbstractReflectionSubject)this.subjects.get(n)).handleBefore(string, classArray, objectArray);
            }
            if (bl) {
                int n2;
                n = this.mao.getIndex((String)object);
                if (this.myTarget.traceFuntionNames && this.myTarget.isTraceEnabled()) {
                    LogMessage logMessage = ServiceManager.logger.trace(16384).append("ENTER ").append(super.getClass().getName()).append(".").append((String)object).append("(");
                    for (n2 = 0; n2 < objectArray.length; ++n2) {
                        if (n2 > 0) {
                            logMessage = logMessage.append(", ");
                        }
                        logMessage = logMessage.append(objectArray[n2]);
                    }
                    logMessage.append(" )").log();
                }
                for (int i2 = 0; i2 < this.subjects.size(); ++i2) {
                    ((AbstractReflectionSubject)this.subjects.get(i2)).handleNormal(string, classArray, objectArray);
                }
                if (n != -1) {
                    this.mao.invoke(n, this, objectArray);
                }
                if (this.myTarget.traceFuntionNames && this.myTarget.isTraceEnabled()) {
                    LogMessage logMessage = ServiceManager.logger.trace(16384).append("LEAVE ").append(super.getClass().getName()).append(".").append((String)object).append("(");
                    for (n2 = 0; n2 < objectArray.length; ++n2) {
                        if (n2 > 0) {
                            logMessage = logMessage.append(", ");
                        }
                        logMessage = logMessage.append(objectArray[n2]);
                    }
                    logMessage.append(" )").log();
                }
                for (int i3 = 0; i3 < this.subjects.size(); ++i3) {
                    ((AbstractReflectionSubject)this.subjects.get(i3)).handleAfter(string, classArray, objectArray);
                }
            }
        }
        catch (Throwable throwable) {
            ServiceManager.errorHandler.handleError(throwable);
            ServiceManager.logger.error(16384).append(eventGeneric).log();
            hsmState = this.getParent();
        }
        return hsmState == null ? null : this.getParent();
    }
}

