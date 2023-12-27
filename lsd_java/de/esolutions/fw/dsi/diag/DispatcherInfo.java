/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.diag;

import de.esolutions.fw.comm.agent.diag.AbstractInfoBase;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.dsi.base.IDispatcher;
import java.lang.reflect.Field;

public class DispatcherInfo
extends AbstractInfoBase {
    public final int instance;
    public final String listenerClassName;
    public final String dispatcherClassName;
    public final String errorMessage;
    public final ServiceInstanceID serviceInstanceId;
    public String errorTimeStamp;
    private static final int DEFAULT_INSTANCE;

    @Override
    protected Object fieldValueToObject(Field field) {
        if (field == null) {
            return null;
        }
        String string = field.getName();
        if (string.equals("instance") && this.instance == 0) {
            return null;
        }
        return super.fieldValueToObject(field);
    }

    public DispatcherInfo(int n, IDispatcher iDispatcher, int n2, String string, String string2) {
        super(n);
        this.dispatcherClassName = iDispatcher != null ? super.getClass().getName() : "unknown";
        this.instance = n2;
        this.listenerClassName = string;
        this.serviceInstanceId = iDispatcher != null && iDispatcher.getService() != null ? iDispatcher.getService().getInstanceID() : null;
        this.errorMessage = string2;
        if (string2 != null) {
            this.errorTimeStamp = super.getTimeStampString();
        }
    }

    @Override
    public ServiceInstanceID getServiceInstanceID() {
        return this.serviceInstanceId;
    }
}

