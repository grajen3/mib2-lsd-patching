/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.datapool.internal;

import de.vw.mib.datapool.internal.DatapoolWatchdogHandler;
import de.vw.mib.datapool.internal.DatapoolWatchdogImpl;
import de.vw.mib.log4mib.LogMessage;
import java.lang.reflect.Array;

final class DatapoolWatchdogImpl$DefaultDatapoolWatchdogHandler
implements DatapoolWatchdogHandler {
    private final /* synthetic */ DatapoolWatchdogImpl this$0;

    DatapoolWatchdogImpl$DefaultDatapoolWatchdogHandler(DatapoolWatchdogImpl datapoolWatchdogImpl) {
        this.this$0 = datapoolWatchdogImpl;
    }

    @Override
    public void onPropertyObjectHasChanged(int n, Object object) {
        LogMessage logMessage = DatapoolWatchdogImpl.logger.error(32).append("the object of datapool property '").append(n).append("' has be changed without updating the datapool! (");
        this.appendObject(logMessage, object);
        logMessage.append("')").attachThrowable((Exception)this.this$0.objectSetterStacktraces.get(n)).log();
    }

    @Override
    public void onSetPropertyWithSameObject(int n, Object object) {
        LogMessage logMessage = DatapoolWatchdogImpl.logger.error(32).append("setValue on datapool property '").append(n).append("' with the same but changed object! (");
        this.appendObject(logMessage, object);
        logMessage.append("')").attachThrowable(new IllegalArgumentException(new StringBuffer().append("setValue on datapool property '").append(n).append("' with the same but changed object!").toString())).log();
    }

    private LogMessage appendArray(LogMessage logMessage, Object object) {
        Class clazz = object.getClass().getComponentType();
        logMessage.append(clazz);
        logMessage.append("[]: ");
        int n = Array.getLength(object);
        if (n == 0) {
            return logMessage.append("[]");
        }
        logMessage.append('[').append(Array.get(object, 0));
        for (int i2 = 1; i2 < n; ++i2) {
            logMessage.append(", ").append(Array.get(object, i2));
        }
        logMessage.append(']');
        return logMessage;
    }

    private LogMessage appendObject(LogMessage logMessage, Object object) {
        if (object.getClass().isArray()) {
            return this.appendArray(logMessage, object);
        }
        logMessage.append(object.getClass());
        logMessage.append(": '");
        logMessage.append(object);
        return logMessage;
    }
}

