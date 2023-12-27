/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.util;

import de.vw.mib.asl.internal.system.util.Preconditions;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.util.StringBuilder;

public class SystemLogger {
    private final int classifier;
    private final Logger logger;
    private final String prefix;

    public SystemLogger(Logger logger, Class clazz) {
        Preconditions.checkArgumentNotNull(logger, new StringBuffer().append(this.getSimpleName(super.getClass())).append("Logger must not be null.").toString());
        Preconditions.checkArgumentNotNull(clazz, new StringBuffer().append(this.getSimpleName(super.getClass())).append("Target class must not be null.").toString());
        this.logger = logger;
        this.prefix = this.getSimpleName(clazz);
        this.classifier = 2048;
    }

    public SystemLogger(Logger logger, int n, Class clazz) {
        Preconditions.checkArgumentNotNull(logger, new StringBuffer().append(this.getSimpleName(super.getClass())).append("Logger must not be null!").toString());
        Preconditions.checkArgument(n != 0, "No classifier given for logging!");
        Preconditions.checkArgumentNotNull(clazz, new StringBuffer().append(this.getSimpleName(super.getClass())).append("Target class must not be null!").toString());
        this.logger = logger;
        this.prefix = this.getSimpleName(clazz);
        this.classifier = n;
    }

    public void error(String string) {
        this.logger.error(this.classifier, new StringBuffer().append(this.prefix).append(string).toString());
    }

    public void error(String string, Throwable throwable) {
        this.logger.error(this.classifier, new StringBuffer().append(this.prefix).append(string).toString(), throwable);
    }

    public void info(String string) {
        this.logger.info(this.classifier, new StringBuffer().append(this.prefix).append(string).toString());
    }

    public boolean isTraceEnabled() {
        return this.logger.isTraceEnabled(this.classifier);
    }

    public void normal(Object[] objectArray) {
        String string = this.createStringMessage(objectArray);
        this.logger.normal(this.classifier, string);
    }

    public void normal(String string) {
        this.logger.normal(this.classifier, new StringBuffer().append(this.prefix).append(string).toString());
    }

    public void trace(Object[] objectArray) {
        if (this.isTraceEnabled()) {
            String string = this.createStringMessage(objectArray);
            this.logger.trace(this.classifier, string);
        }
    }

    public void trace(String string) {
        if (this.isTraceEnabled()) {
            this.logger.trace(this.classifier, new StringBuffer().append(this.prefix).append(string).toString());
        }
    }

    public void warn(String string) {
        this.logger.warn(this.classifier, new StringBuffer().append(this.prefix).append(string).toString());
    }

    private void concatenateObjects(StringBuilder stringBuilder, Object[] objectArray) {
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            Object object = objectArray[i2];
            stringBuilder.append(object == null ? "null" : object.toString());
        }
    }

    private String createStringMessage(Object[] objectArray) {
        if (objectArray != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.prefix);
            this.concatenateObjects(stringBuilder, objectArray);
            return stringBuilder.toString();
        }
        return "Incoming object array is null!";
    }

    private String getSimpleName(Class clazz) {
        String string = clazz.getName();
        return new StringBuffer().append("[").append(string.substring(string.lastIndexOf(".") + 1)).append("] ").toString();
    }
}

