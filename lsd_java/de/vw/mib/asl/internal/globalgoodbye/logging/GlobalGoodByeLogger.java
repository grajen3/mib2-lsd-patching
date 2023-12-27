/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.globalgoodbye.logging;

import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.util.StringBuilder;

public class GlobalGoodByeLogger {
    private final Logger logger;
    private final String prefix;

    public GlobalGoodByeLogger(Logger logger, Class clazz) {
        Preconditions.checkNotNull(logger, new StringBuffer().append(this.getSimpleName(super.getClass())).append("Logger must not be null!").toString());
        Preconditions.checkNotNull(clazz, new StringBuffer().append(this.getSimpleName(super.getClass())).append("Target class must not be null!").toString());
        this.logger = logger;
        this.prefix = this.getSimpleName(clazz);
    }

    public void error(String string) {
        this.logger.error(2048, new StringBuffer().append(this.prefix).append(string).toString());
    }

    public void info(String string) {
        this.logger.info(2048, new StringBuffer().append(this.prefix).append(string).toString());
    }

    public boolean isTraceEnabled() {
        return this.logger.isTraceEnabled(2048);
    }

    public void trace(String string) {
        if (this.isTraceEnabled()) {
            this.logger.trace(2048, new StringBuffer().append(this.prefix).append(string).toString());
        }
    }

    public void trace(Object[] objectArray) {
        if (this.isTraceEnabled()) {
            String string = this.createTraceMessage(objectArray);
            this.logger.trace(2048, new StringBuffer().append(this.prefix).append(string).toString());
        }
    }

    public void warn(String string) {
        this.logger.warn(2048, new StringBuffer().append(this.prefix).append(string).toString());
    }

    private String getSimpleName(Class clazz) {
        String string = clazz.getName();
        return new StringBuffer().append("[").append(string.substring(string.lastIndexOf(".") + 1)).append("] ").toString();
    }

    private void concatenateObjects(StringBuilder stringBuilder, Object[] objectArray) {
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            Object object = objectArray[i2];
            stringBuilder.append(object == null ? "null" : object.toString());
        }
    }

    private String createTraceMessage(Object[] objectArray) {
        if (objectArray != null) {
            StringBuilder stringBuilder = new StringBuilder();
            this.concatenateObjects(stringBuilder, objectArray);
            return stringBuilder.toString();
        }
        return "Incoming object array is null!";
    }
}

