/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.factory;

import de.esolutions.fw.util.transport.ITransport;
import de.esolutions.fw.util.transport.factory.BaseTransportFactory;
import de.esolutions.fw.util.transport.factory.ISpawnTransportFactory;
import de.esolutions.fw.util.transport.factory.ISpawnedTransportListener;
import de.esolutions.fw.util.transport.packet.PacketTransport;
import de.esolutions.fw.util.transport.socket.TSTransport;
import java.io.File;
import java.io.IOException;

public class TSSpawnTransportFactory
extends BaseTransportFactory
implements ISpawnTransportFactory,
Runnable {
    protected ISpawnedTransportListener listener;
    protected ITransport transport = null;
    protected Thread thread;
    protected boolean stopNow;
    protected boolean isEnabled;
    protected String path;
    protected String mountPoint;
    protected String fileName;

    public TSSpawnTransportFactory(String string, String string2) {
        this.mountPoint = string;
        this.fileName = string2;
        this.path = new StringBuffer().append(string).append("/spawn/").append(string2).toString();
    }

    @Override
    public void enableSpawning() {
        if (this.isEnabled) {
            return;
        }
        File file = new File(this.mountPoint);
        if (!file.exists()) {
            throw new IOException();
        }
        this.thread = new Thread(this, "TSSpawnTransportFactory");
        this.thread.start();
        this.isEnabled = true;
    }

    @Override
    public void disableSpawning() {
        if (!this.isEnabled) {
            return;
        }
        if (this.transport == null) {
            return;
        }
        this.stopNow = true;
        try {
            this.transport.close(false);
            this.thread.interrupt();
            this.thread.join();
            this.isEnabled = false;
        }
        catch (InterruptedException interruptedException) {
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }

    @Override
    public void setListener(ISpawnedTransportListener iSpawnedTransportListener) {
        this.listener = iSpawnedTransportListener;
    }

    @Override
    public void run() {
        while (!this.stopNow) {
            try {
                TSTransport tSTransport = new TSTransport(this.path);
                this.transport = new PacketTransport(tSTransport);
                this.transport = this.enrichTransport(this.transport);
                this.transport.open();
                if (this.listener != null) {
                    this.listener.spawnedTransport(this.transport);
                    continue;
                }
                System.out.println("TSSpawnTransportFactory: spawned transport but no listener!");
            }
            catch (IOException iOException) {}
        }
    }

    @Override
    public String getDescription() {
        return new StringBuffer().append("[TSP:listen=").append(this.path).append("]").toString();
    }
}

