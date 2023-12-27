/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.error;

import de.esolutions.fw.util.commons.error.ErrorHandlingRunnable;
import de.esolutions.fw.util.commons.error.IFatalErrorHandler;
import de.esolutions.fw.util.commons.error.IRunnableWrapper;

public class ErrorHandlingRunnableWrapper
implements IRunnableWrapper {
    private final IFatalErrorHandler handler;

    public ErrorHandlingRunnableWrapper(IFatalErrorHandler iFatalErrorHandler) {
        this.handler = iFatalErrorHandler;
    }

    @Override
    public Runnable wrap(Runnable runnable) {
        return new ErrorHandlingRunnable(this.handler, runnable);
    }
}

