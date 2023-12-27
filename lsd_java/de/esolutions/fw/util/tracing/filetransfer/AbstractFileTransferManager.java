/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.filetransfer;

import de.esolutions.fw.util.tracing.filetransfer.IFileTransferListener;
import de.esolutions.fw.util.tracing.filetransfer.IFileTransferReceiver;
import de.esolutions.fw.util.tracing.filetransfer.IFileTransferSender;
import de.esolutions.fw.util.tracing.filetransfer.file.IFile;
import de.esolutions.fw.util.tracing.filetransfer.file.IFileFactory;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class AbstractFileTransferManager
implements IFileTransferReceiver {
    protected int blockSize;
    protected byte hashType;
    protected String downloadDirectory;
    protected IFileTransferSender fileTransferSender = null;
    protected IFileFactory fileFactory = null;
    protected ArrayList listeners = new ArrayList();

    @Override
    public String getDownloadDirectory() {
        return this.downloadDirectory;
    }

    @Override
    public void registerListener(IFileTransferListener iFileTransferListener) {
        if (!this.listeners.contains(iFileTransferListener)) {
            this.listeners.add(iFileTransferListener);
        }
    }

    @Override
    public void unregisterListener(IFileTransferListener iFileTransferListener) {
        if (this.listeners.contains(iFileTransferListener)) {
            this.listeners.remove(iFileTransferListener);
        }
    }

    protected void notifyListenerFileTransferBegin(IFile iFile) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ((IFileTransferListener)iterator.next()).fileTransferBegin(iFile);
        }
    }

    protected void notifyListenerFileTransferComplete(IFile iFile) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ((IFileTransferListener)iterator.next()).fileTransferComplete(iFile);
        }
    }

    protected void notifyListenerFileTransferError(IFile iFile) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ((IFileTransferListener)iterator.next()).fileTransferError(iFile);
        }
    }

    protected void notifyListenerFileTransferStatus(IFile iFile) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ((IFileTransferListener)iterator.next()).fileTransferStatus(iFile);
        }
    }

    protected void notifyListenerFileTransferProgress(IFile iFile) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ((IFileTransferListener)iterator.next()).fileTransferProgress(iFile);
        }
    }

    protected boolean confirmFileTransfer(IFile iFile) {
        boolean bl = false;
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            IFileTransferListener iFileTransferListener = (IFileTransferListener)iterator.next();
            if (iFileTransferListener == null || !iFileTransferListener.confirmFileTransfer(iFile)) continue;
            bl = true;
        }
        return bl;
    }

    @Override
    public void setFileTransferSender(IFileTransferSender iFileTransferSender) {
        this.fileTransferSender = iFileTransferSender;
    }

    @Override
    public void setFileFactory(IFileFactory iFileFactory) {
        this.fileFactory = iFileFactory;
    }

    @Override
    public abstract boolean uploadFile(IFile iFile) {
    }

    @Override
    public abstract boolean requestFileStatus(String string, IFile iFile) {
    }

    @Override
    public abstract boolean requestFileDownload(String string, IFile iFile) {
    }

    @Override
    public abstract boolean handleFileRequestMessage(int n, String string, byte by) {
    }

    @Override
    public abstract boolean handleFileStatusMessage(int n, String string, byte by, long l, long l2, byte by2, byte[] byArray) {
    }

    @Override
    public abstract boolean handleFileTransferMessage(int n, int n2, byte by, int n3, byte[] byArray) {
    }
}

