/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.error;

import de.esolutions.fw.util.commons.error.IFatalErrorHandler;

public class ErrorHandlingRunnable
implements Runnable {
    private final IFatalErrorHandler errorHandler;
    private final Runnable run;

    public ErrorHandlingRunnable(IFatalErrorHandler iFatalErrorHandler, Runnable runnable) {
        this.errorHandler = iFatalErrorHandler;
        this.run = runnable;
    }

    @Override
    public void run() {
        try {
            this.run.run();
        }
        catch (Throwable throwable) {
            if (this.errorHandler != null) {
                this.errorHandler.handleFatalError(throwable, null);
            }
            System.out.println("-----> JavaCOMM ERROR DEFAULT HANDLER <-----");
            System.out.print("thread: ");
            System.out.println(Thread.currentThread().getName());
            System.out.print("error: ");
            throwable.printStackTrace();
        }
    }
}

