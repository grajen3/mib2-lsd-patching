/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.spi.messages.internal;

import de.vw.mib.debug.spi.messages.DebugSPI_Message;
import de.vw.mib.debug.spi.messages.internal.AbstractMessageIO;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;

class AbstractMessageIO$2
implements Runnable {
    private final /* synthetic */ AbstractMessageIO this$0;

    AbstractMessageIO$2(AbstractMessageIO abstractMessageIO) {
        this.this$0 = abstractMessageIO;
    }

    @Override
    public void run() {
        while (!this.this$0.stopped) {
            try {
                DebugSPI_Message debugSPI_Message = (DebugSPI_Message)this.this$0.writeBuffer.poll(0, TimeUnit.MILLISECONDS);
                if (debugSPI_Message == null) continue;
                this.this$0.write(debugSPI_Message.getModule(), debugSPI_Message.getType(), debugSPI_Message.getContent(), debugSPI_Message.getLength());
            }
            catch (InterruptedException interruptedException) {}
        }
    }
}

