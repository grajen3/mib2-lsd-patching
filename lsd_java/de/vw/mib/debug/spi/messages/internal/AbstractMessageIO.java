/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.spi.messages.internal;

import de.vw.mib.codec.ByteArrayReader;
import de.vw.mib.codec.ByteArrayWriter;
import de.vw.mib.debug.spi.messages.DebugSPI_Message;
import de.vw.mib.debug.spi.messages.DebugSPI_MessageConsumer;
import de.vw.mib.debug.spi.messages.DebugSPI_MessageIO;
import de.vw.mib.debug.spi.messages.internal.AbstractMessageIO$1;
import de.vw.mib.debug.spi.messages.internal.AbstractMessageIO$2;
import edu.emory.mathcs.backport.java.util.concurrent.LinkedBlockingQueue;

public abstract class AbstractMessageIO
implements DebugSPI_MessageIO {
    protected final DebugSPI_MessageConsumer consumer;
    final ByteArrayReader bar = new ByteArrayReader();
    final ByteArrayWriter messageComposer = new ByteArrayWriter(2048);
    final LinkedBlockingQueue readBuffer = new LinkedBlockingQueue(5000);
    final LinkedBlockingQueue writeBuffer = new LinkedBlockingQueue(5000);
    protected boolean recomposing = false;
    boolean stopped;

    protected AbstractMessageIO(DebugSPI_MessageConsumer debugSPI_MessageConsumer) {
        this.consumer = debugSPI_MessageConsumer;
    }

    @Override
    public void writeMessage(int n, short s, byte[] byArray) {
        this.writeMessage(n, s, byArray, byArray.length);
    }

    @Override
    public void writeMessage(int n, short s, byte[] byArray, int n2) {
        this.writeBuffer.offer(new DebugSPI_Message(n, s, byArray, n2));
    }

    public void close() {
        if (!this.stopped) {
            this.stopped = true;
        }
    }

    protected void processReaderBuffer(String string) {
        Thread thread = new Thread(new AbstractMessageIO$1(this));
        thread.setName(string);
        thread.start();
    }

    protected void processWriterBuffer(String string) {
        Thread thread = new Thread(new AbstractMessageIO$2(this));
        thread.setName(string);
        thread.start();
    }

    protected void receive(int n, short s, byte[] byArray) {
        this.readBuffer.offer(new DebugSPI_Message(n, s, byArray, byArray.length));
    }

    protected abstract void write(int n, short s, byte[] byArray, int n2) {
    }

    void updateListener(int n, short s, byte[] byArray) {
        if (this.consumer != null) {
            this.consumer.consumeMessage(n, s, byArray);
        }
    }
}

