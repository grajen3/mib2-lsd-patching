/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.asl;

import de.vw.mib.asl.framework.api.framework.reflection.MethodAccessible;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.asl.AbstractReflectionContext;
import de.vw.mib.asl.framework.internal.framework.asl.AbstractReflectionState;
import de.vw.mib.asl.framework.internal.framework.asl.ApiHandler;
import de.vw.mib.asl.framework.internal.framework.asl.EventNameResolver;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.Hsm;

public abstract class AbstractReflectionHsmTarget
extends AbstractTarget
implements ApiHandler,
MethodAccessible {
    protected Hsm hsm;
    public boolean traceFuntionNames = true;
    IntOptHashSet regEvents = new IntOptHashSet();

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

    public AbstractReflectionHsmTarget(GenericEvents genericEvents) {
        super(genericEvents);
    }

    public AbstractReflectionHsmTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents);
        this.hsm = new Hsm(this.getMyShortName(), this.getDefaultWorkState());
        this.setEventContext(genericEvents);
        this.register(this.getMainObject(), n, string);
    }

    public AbstractReflectionContext getCurrentContext() {
        return new AbstractReflectionContext();
    }

    @Override
    public final void gotEvent(EventGeneric eventGeneric) {
        if (eventGeneric.getReceiverEventId() == 106) {
            this.registerForEvents();
            this.hsm.init(this.getMyShortName(), this.getDefaultWorkState());
            this.hsm.verbose = true;
            this.hsm.onStart();
        }
        try {
            String string = EventNameResolver.resolveEventName(eventGeneric.getReceiverEventId());
            Object[] objectArray = new Object[eventGeneric.getParamCount() + 1];
            Class[] classArray = new Class[eventGeneric.getParamCount() + 1];
            EventNameResolver.convertEventData(eventGeneric, classArray, objectArray, 1);
            AbstractReflectionContext abstractReflectionContext = this.getCurrentContext();
            objectArray[0] = abstractReflectionContext;
            classArray[0] = super.getClass();
            abstractReflectionContext.put("target", this);
            eventGeneric.setObject(eventGeneric.getParamCount(), classArray);
            eventGeneric.setObject(eventGeneric.getParamCount(), objectArray);
            eventGeneric.setObject(eventGeneric.getParamCount(), string);
            this.hsm.onEvent(eventGeneric);
        }
        catch (Throwable throwable) {
            ServiceManager.errorHandler.handleError(throwable);
        }
    }

    public abstract AbstractReflectionState getDefaultWorkState() {
    }
}

