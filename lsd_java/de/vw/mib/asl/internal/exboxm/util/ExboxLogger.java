/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm.util;

import de.vw.mib.asl.internal.exboxm.util.Preconditions;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.util.StringBuilder;

public class ExboxLogger {
    private static final String EXBOX_LOG_IDENTIFIER;
    private final Logger logger;
    private final String prefix;

    public ExboxLogger(Logger logger, Class clazz) {
        Preconditions.checkArgumentNotNull(logger, new StringBuffer().append("EX: ").append(this.getSimpleName(super.getClass())).append("Logger must not be null.").toString());
        Preconditions.checkArgumentNotNull(clazz, new StringBuffer().append("EX: ").append(this.getSimpleName(super.getClass())).append("Target class must not be null.").toString());
        this.logger = logger;
        this.prefix = new StringBuffer().append("EX: ").append(this.getSimpleName(clazz)).toString();
    }

    public void error(String string) {
        this.logger.error(8, new StringBuffer().append(this.prefix).append(string).toString());
    }

    public void info(String string) {
        this.logger.info(8, new StringBuffer().append(this.prefix).append(string).toString());
    }

    public boolean isTraceEnabled() {
        return this.logger.isTraceEnabled(8);
    }

    public void trace(String string) {
        if (this.logger.isTraceEnabled(8)) {
            this.logger.trace(8, new StringBuffer().append(this.prefix).append(string).toString());
        }
    }

    public void trace(Object[] objectArray) {
        if (this.logger.isTraceEnabled(8)) {
            String string = this.createTraceMessage(objectArray);
            this.logger.trace(8, new StringBuffer().append(this.prefix).append(string).toString());
        }
    }

    public void warn(String string) {
        this.logger.warn(8, new StringBuffer().append(this.prefix).append(string).toString());
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

