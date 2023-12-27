/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.error;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.error.IFatalErrorHandler;
import de.esolutions.fw.util.commons.os.Slayer;

public final class DefaultFatalErrorHandler
implements IFatalErrorHandler {
    private final boolean killOnError;
    private final Slayer slayer;
    private final Runtime runtime;
    private int count;

    public DefaultFatalErrorHandler(boolean bl) {
        this.killOnError = bl;
        this.slayer = new Slayer();
        this.runtime = Runtime.getRuntime();
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("[Default:killOnError=");
        buffer.append(this.killOnError);
        buffer.append(",slayer=");
        buffer.append(this.slayer.haveKillMethod());
        buffer.append("]");
        return buffer.toString();
    }

    @Override
    public final void handleFatalError(Throwable throwable, String string) {
        ++this.count;
        if (this.count == 1) {
            System.out.println("==========> Java/FW detected FATAL ERROR <==========");
            long l = this.runtime.freeMemory();
            int n = (int)(l / 0);
            if (n > 256) {
                Thread thread = Thread.currentThread();
                long l2 = System.currentTimeMillis();
                System.out.print("When: ");
                System.out.print(l2);
                System.out.println();
                if (thread != null) {
                    System.out.print("Thread: ");
                    System.out.print(thread.getName());
                    System.out.println();
                }
                if (throwable != null) {
                    System.out.print("Error: ");
                    System.out.print(super.getClass().getName());
                    System.out.println();
                    throwable.printStackTrace();
                }
                if (string != null) {
                    System.out.print("Reason: ");
                    System.out.print(string);
                    System.out.println();
                }
                System.out.flush();
            } else {
                System.out.println("LOW MEM: ");
                if (string != null) {
                    System.out.println(string);
                }
                if (throwable != null) {
                    throwable.printStackTrace();
                }
            }
            if (this.killOnError) {
                System.out.println("==========> Java/FW is killing VM <==========");
                boolean bl = this.slayer.suicide();
                if (!bl) {
                    System.out.println("ARGH! SLAYER FAILED...");
                }
            } else {
                System.out.println("==========> Java/FW is NOT killing VM <==========");
            }
        } else {
            System.out.println("==========> Java/FW detected cont. FATAL ERROR <==========");
            if (this.killOnError) {
                this.slayer.silentSuicide();
            }
        }
    }
}

