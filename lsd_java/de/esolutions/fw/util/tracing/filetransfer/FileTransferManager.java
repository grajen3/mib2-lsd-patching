/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.filetransfer;

import de.esolutions.fw.util.tracing.filetransfer.AbstractFileTransferManager;
import de.esolutions.fw.util.tracing.filetransfer.FileTransferError;
import de.esolutions.fw.util.tracing.filetransfer.FileTransferManager$FileTransferObject;
import de.esolutions.fw.util.tracing.filetransfer.file.IExtendedFile;
import de.esolutions.fw.util.tracing.filetransfer.file.IFile;
import de.esolutions.fw.util.tracing.filetransfer.file.IFileFactory;
import de.esolutions.fw.util.tracing.filetransfer.util.FileTransferConstants;
import de.esolutions.fw.util.tracing.filetransfer.util.FileTransferUtils;
import de.esolutions.fw.util.tracing.filetransfer.util.FileTransferUtils$RequestIdPool;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class FileTransferManager
extends AbstractFileTransferManager {
    private HashMap fileTransferRequestObjects = new HashMap();
    private HashMap fileTransferUploadObjects = new HashMap();
    private final Object mapSynchronisation = new Object();
    private final FileTransferUtils$RequestIdPool requestIdPool = new FileTransferUtils$RequestIdPool();

    private boolean isIgnored(FileTransferManager$FileTransferObject fileTransferManager$FileTransferObject) {
        return FileTransferManager$FileTransferObject.access$000(fileTransferManager$FileTransferObject);
    }

    private void ignoreFile(FileTransferManager$FileTransferObject fileTransferManager$FileTransferObject) {
        FileTransferManager$FileTransferObject.access$002(fileTransferManager$FileTransferObject, true);
    }

    public FileTransferManager(int n, byte by, String string) {
        this.blockSize = n;
        this.hashType = by;
        this.downloadDirectory = string;
        this.printStartUp();
    }

    public FileTransferManager(int n, byte by, String string, IFileFactory iFileFactory) {
        this.blockSize = n;
        this.hashType = by;
        this.downloadDirectory = string;
        this.fileFactory = iFileFactory;
        this.printStartUp();
    }

    private void printStartUp() {
        System.out.println("FileTransferManager started ");
        System.out.println(new StringBuffer().append("using: blockSize         = ").append(this.blockSize).toString());
        System.out.println(new StringBuffer().append("       hashType          = ").append(this.hashType).toString());
        System.out.println(new StringBuffer().append("       downloadDirectory = ").append(this.downloadDirectory).toString());
    }

    @Override
    public boolean uploadFile(IFile iFile) {
        int n = this.requestIdPool.getId(FileTransferConstants.OPERATION_UPLOAD);
        try {
            boolean bl = iFile.open(false);
            if (bl) {
                byte by = (byte)(FileTransferConstants.FLAG_FILE_UPLOAD | FileTransferConstants.FLAG_STATUS_AVAILABLE | FileTransferConstants.FLAG_STATUS_IS_FILE | FileTransferConstants.FLAG_STATUS_READABLE);
                ((IExtendedFile)iFile).setFlag(by);
                this.fileTransferSender.sendFileStatus(n, iFile.getLocalPath(), by, iFile.getSize(), iFile.getTimestamp(), this.hashType, new byte[0]);
                this.notifyListenerFileTransferBegin(iFile);
                this.sendFileTransferMessages(n, iFile, FileTransferConstants.FLAG_FILE_UPLOAD);
                iFile.close();
                iFile.open(false);
                byte[] byArray = FileTransferUtils.calculateHash(this.hashType, iFile);
                iFile.close();
                this.fileTransferSender.sendFileStatus(n, iFile.getLocalPath(), by, iFile.getSize(), iFile.getTimestamp(), this.hashType, byArray);
                this.notifyListenerFileTransferComplete(iFile);
                this.requestIdPool.releaseId(n);
                return true;
            }
            ((IExtendedFile)iFile).setError(new FileTransferError(10));
            this.notifyListenerFileTransferError(iFile);
            return false;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            IExtendedFile iExtendedFile = (IExtendedFile)iFile;
            iExtendedFile.setError(new FileTransferError(30, exception));
            this.notifyListenerFileTransferError(iFile);
            this.requestIdPool.releaseId(n);
            return false;
        }
    }

    @Override
    public boolean requestFileStatus(String string, IFile iFile) {
        if (iFile == null) {
            String string2 = FileTransferUtils.findTempUniqueFileName(this.downloadDirectory);
            iFile = this.fileFactory.createFile(string2);
        }
        ((IExtendedFile)iFile).setPath(string);
        return this.sendRequest(string, iFile, FileTransferConstants.OPERATION_STATUS);
    }

    @Override
    public boolean requestFileDownload(String string, IFile iFile) {
        if (iFile == null) {
            String string2 = FileTransferUtils.findTempUniqueFileName(this.downloadDirectory);
            iFile = this.fileFactory.createFile(string2);
        }
        ((IExtendedFile)iFile).setPath(string);
        return this.sendRequest(string, iFile, FileTransferConstants.OPERATION_DOWNLOAD);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean sendRequest(String string, IFile iFile, byte by) {
        if (this.fileTransferSender == null) {
            return false;
        }
        int n = this.requestIdPool.getId(by);
        try {
            this.fileTransferSender.sendFileRequest(n, string, by);
            Object object = this.mapSynchronisation;
            synchronized (object) {
                FileTransferManager$FileTransferObject fileTransferManager$FileTransferObject = new FileTransferManager$FileTransferObject((IExtendedFile)iFile);
                FileTransferManager$FileTransferObject.access$102(fileTransferManager$FileTransferObject, by);
                this.fileTransferRequestObjects.put(new Integer(n), fileTransferManager$FileTransferObject);
            }
            return true;
        }
        catch (Exception exception) {
            ((IExtendedFile)iFile).setError(new FileTransferError(30, exception));
            this.notifyListenerFileTransferError(iFile);
            this.requestIdPool.releaseId(n);
            return false;
        }
    }

    @Override
    public boolean handleFileRequestMessage(int n, String string, byte by) {
        IFile iFile = this.fileFactory.createFile(string);
        boolean bl = iFile.open(false);
        try {
            if (bl) {
                if (FileTransferConstants.OPERATION_DOWNLOAD == by) {
                    this.fileDownloadRequest(n, iFile);
                } else if (FileTransferConstants.OPERATION_STATUS == by) {
                    this.fileStatusRequest(n, iFile);
                }
                iFile.close();
            } else {
                ((IExtendedFile)iFile).setError(new FileTransferError(10));
                this.fileStatusRequest(n, iFile);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean handleInitExitMessage() {
        this.cleanTransferObjects();
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void cleanTransferObjects() {
        Object object = this.mapSynchronisation;
        synchronized (object) {
            this.cleanAllTransferObjects(this.fileTransferRequestObjects.values());
            this.cleanAllTransferObjects(this.fileTransferUploadObjects.values());
            this.fileTransferRequestObjects = null;
            this.fileTransferUploadObjects = null;
            this.fileTransferRequestObjects = new HashMap();
            this.fileTransferUploadObjects = new HashMap();
        }
    }

    private void cleanAllTransferObjects(Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            FileTransferManager$FileTransferObject fileTransferManager$FileTransferObject = (FileTransferManager$FileTransferObject)iterator.next();
            FileTransferManager$FileTransferObject.access$200(fileTransferManager$FileTransferObject).setError(new FileTransferError(60));
            this.notifyListenerFileTransferError(FileTransferManager$FileTransferObject.access$200(fileTransferManager$FileTransferObject));
        }
    }

    private boolean fileDownloadRequest(int n, IFile iFile) {
        this.sendFileTransferStatus(n, iFile, FileTransferConstants.FLAG_NOTHING_SET, false);
        this.sendFileTransferMessages(n, iFile, FileTransferConstants.FLAG_NOTHING_SET);
        this.sendFileTransferStatus(n, iFile, FileTransferConstants.FLAG_NOTHING_SET, true);
        return true;
    }

    private boolean fileStatusRequest(int n, IFile iFile) {
        this.sendFileTransferStatus(n, iFile, FileTransferConstants.FLAG_NOTHING_SET, true);
        return true;
    }

    private boolean firstFileTransferStatusMessageReceived(int n, String string, byte by, long l, long l2, byte by2, byte[] byArray, FileTransferManager$FileTransferObject fileTransferManager$FileTransferObject) {
        IExtendedFile iExtendedFile = FileTransferManager$FileTransferObject.access$200(fileTransferManager$FileTransferObject);
        this.setFileStatus(n, string, by, l, l2, by2, byArray, iExtendedFile);
        if (!this.confirmFileTransfer(iExtendedFile)) {
            this.ignoreFile(fileTransferManager$FileTransferObject);
            FileTransferManager$FileTransferObject.access$302(fileTransferManager$FileTransferObject, true);
            return true;
        }
        this.notifyListenerFileTransferBegin(iExtendedFile);
        iExtendedFile.open(true);
        FileTransferManager$FileTransferObject.access$302(fileTransferManager$FileTransferObject, true);
        return true;
    }

    private boolean lastFileTransferStatusMessageReceived(int n, String string, byte by, long l, long l2, byte by2, byte[] byArray, FileTransferManager$FileTransferObject fileTransferManager$FileTransferObject, HashMap hashMap) {
        boolean bl = true;
        try {
            IExtendedFile iExtendedFile = FileTransferManager$FileTransferObject.access$200(fileTransferManager$FileTransferObject);
            if (this.isIgnored(fileTransferManager$FileTransferObject)) {
                return true;
            }
            this.setFileStatus(n, string, by, l, l2, by2, byArray, iExtendedFile);
            if (!iExtendedFile.hasError()) {
                iExtendedFile.open(false);
                byte[] byArray2 = FileTransferUtils.calculateHash(by2, iExtendedFile);
                boolean bl2 = Arrays.equals(byArray2, byArray);
                iExtendedFile.setValidHash(bl2);
                iExtendedFile.close();
                this.notifyListenerFileTransferComplete(iExtendedFile);
                this.removeTransferId(hashMap, n);
            } else {
                iExtendedFile.setError(new FileTransferError(10));
                this.notifyListenerFileTransferError(iExtendedFile);
                bl = false;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            IExtendedFile iExtendedFile = FileTransferManager$FileTransferObject.access$200(fileTransferManager$FileTransferObject);
            iExtendedFile.setError(new FileTransferError(10));
            this.notifyListenerFileTransferError(iExtendedFile);
            bl = false;
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean fileStatusMessageReceived(int n, String string, byte by, long l, long l2, byte by2, byte[] byArray, FileTransferManager$FileTransferObject fileTransferManager$FileTransferObject, HashMap hashMap) {
        boolean bl = true;
        IExtendedFile iExtendedFile = FileTransferManager$FileTransferObject.access$200(fileTransferManager$FileTransferObject);
        try {
            iExtendedFile.open(true);
            this.setFileStatus(n, string, by, l, l2, by2, byArray, iExtendedFile);
            iExtendedFile.close();
            if (!iExtendedFile.hasError()) {
                this.notifyListenerFileTransferStatus(iExtendedFile);
            }
        }
        catch (Exception exception) {
            iExtendedFile.setError(new FileTransferError(exception));
        }
        finally {
            if (iExtendedFile.hasError()) {
                iExtendedFile.setError(new FileTransferError(10));
                this.notifyListenerFileTransferError(iExtendedFile);
                bl = false;
            }
        }
        this.removeTransferId(hashMap, n);
        return bl;
    }

    private void setFileStatus(int n, String string, byte by, long l, long l2, byte by2, byte[] byArray, IExtendedFile iExtendedFile) {
        if (string != null && string.trim().length() > 0) {
            iExtendedFile.setPath(string);
        }
        iExtendedFile.setFlag(by);
        iExtendedFile.setTimestamp(l2);
        iExtendedFile.setHashType(by2);
        iExtendedFile.setHash(byArray);
        iExtendedFile.setSize(0L);
        iExtendedFile.setCompleteSize(l);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private FileTransferManager$FileTransferObject findFileTransferObject(int n, byte by) {
        FileTransferManager$FileTransferObject fileTransferManager$FileTransferObject = null;
        Object object = this.mapSynchronisation;
        synchronized (object) {
            if (this.isUpload(by)) {
                boolean bl = !this.fileTransferUploadObjects.containsKey(new Integer(n));
                fileTransferManager$FileTransferObject = this.findFileObject(n, this.fileTransferUploadObjects);
                FileTransferManager$FileTransferObject.access$302(fileTransferManager$FileTransferObject, !bl);
            } else {
                fileTransferManager$FileTransferObject = this.findFileObject(n, this.fileTransferRequestObjects);
            }
        }
        return fileTransferManager$FileTransferObject;
    }

    @Override
    public boolean handleFileStatusMessage(int n, String string, byte by, long l, long l2, byte by2, byte[] byArray) {
        boolean bl = this.isUpload(by);
        boolean bl2 = true;
        HashMap hashMap = this.findFileTransferMap(by);
        FileTransferManager$FileTransferObject fileTransferManager$FileTransferObject = this.findFileTransferObject(n, by);
        if (this.fileTransferSender == null && !bl) {
            FileTransferManager$FileTransferObject.access$102(fileTransferManager$FileTransferObject, FileTransferConstants.OPERATION_DOWNLOAD);
        }
        if (FileTransferManager$FileTransferObject.access$100(fileTransferManager$FileTransferObject) == FileTransferConstants.OPERATION_STATUS) {
            return this.fileStatusMessageReceived(n, string, by, l, l2, by2, byArray, fileTransferManager$FileTransferObject, hashMap);
        }
        if (FileTransferManager$FileTransferObject.access$200(fileTransferManager$FileTransferObject).hasError() || this.hasFlag(by, FileTransferConstants.FLAG_STATUS_ERROR)) {
            if (this.hasFlag(by, FileTransferConstants.FLAG_STATUS_ERROR)) {
                this.setFileStatus(n, string, by, l, l2, by2, byArray, FileTransferManager$FileTransferObject.access$200(fileTransferManager$FileTransferObject));
                FileTransferManager$FileTransferObject.access$200(fileTransferManager$FileTransferObject).setError(new FileTransferError(10));
                this.notifyListenerFileTransferError(FileTransferManager$FileTransferObject.access$200(fileTransferManager$FileTransferObject));
            }
            this.removeTransferId(hashMap, n);
            return false;
        }
        if (FileTransferManager$FileTransferObject.access$100(fileTransferManager$FileTransferObject) == FileTransferConstants.OPERATION_DOWNLOAD || bl) {
            if (!FileTransferManager$FileTransferObject.access$300(fileTransferManager$FileTransferObject)) {
                bl2 = this.firstFileTransferStatusMessageReceived(n, string, by, l, l2, by2, byArray, fileTransferManager$FileTransferObject);
            } else {
                FileTransferManager$FileTransferObject.access$200(fileTransferManager$FileTransferObject).close();
                bl2 = this.lastFileTransferStatusMessageReceived(n, string, by, l, l2, by2, byArray, fileTransferManager$FileTransferObject, hashMap);
            }
        }
        return bl2;
    }

    @Override
    public boolean handleFileTransferMessage(int n, int n2, byte by, int n3, byte[] byArray) {
        HashMap hashMap = this.findFileTransferMap(by);
        FileTransferManager$FileTransferObject fileTransferManager$FileTransferObject = this.findFileObject(n, hashMap);
        if (this.isIgnored(fileTransferManager$FileTransferObject)) {
            return true;
        }
        IExtendedFile iExtendedFile = FileTransferManager$FileTransferObject.access$200(fileTransferManager$FileTransferObject);
        if (iExtendedFile.hasError()) {
            return false;
        }
        if (!this.isFirstBlock(by) && n2 == 0 || this.isFirstBlock(by) && n2 != 0) {
            iExtendedFile.setError(new FileTransferError(40, "first block and blocknumber mismatch "));
            this.notifyListenerFileTransferError(iExtendedFile);
            iExtendedFile.close();
            return false;
        }
        if (FileTransferManager$FileTransferObject.access$400(fileTransferManager$FileTransferObject) != n2 - 1) {
            iExtendedFile.setError(new FileTransferError(40, "wrong block number received"));
            this.notifyListenerFileTransferError(iExtendedFile);
            iExtendedFile.close();
            return false;
        }
        if (FileTransferManager$FileTransferObject.access$500(fileTransferManager$FileTransferObject)) {
            iExtendedFile.setError(new FileTransferError(40, " previously last block received"));
            this.notifyListenerFileTransferError(iExtendedFile);
            iExtendedFile.close();
            return false;
        }
        if (this.isFirstBlock(by) && !FileTransferManager$FileTransferObject.access$300(fileTransferManager$FileTransferObject)) {
            iExtendedFile.setError(new FileTransferError(10));
            this.notifyListenerFileTransferError(iExtendedFile);
            iExtendedFile.close();
            return false;
        }
        if (this.isLastBlock(by)) {
            FileTransferManager$FileTransferObject.access$502(fileTransferManager$FileTransferObject, true);
        }
        FileTransferManager$FileTransferObject.access$402(fileTransferManager$FileTransferObject, n2);
        iExtendedFile.write(byArray);
        this.notifyListenerFileTransferProgress(iExtendedFile);
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private FileTransferManager$FileTransferObject findFileObject(int n, HashMap hashMap) {
        Object object = this.mapSynchronisation;
        synchronized (object) {
            FileTransferManager$FileTransferObject fileTransferManager$FileTransferObject = null;
            if (hashMap.containsKey(new Integer(n))) {
                fileTransferManager$FileTransferObject = (FileTransferManager$FileTransferObject)hashMap.get(new Integer(n));
            } else {
                String string = FileTransferUtils.findTempUniqueFileName(this.downloadDirectory);
                IFile iFile = this.fileFactory.createFile(string);
                fileTransferManager$FileTransferObject = new FileTransferManager$FileTransferObject((IExtendedFile)iFile);
                hashMap.put(new Integer(n), fileTransferManager$FileTransferObject);
            }
            return fileTransferManager$FileTransferObject;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private HashMap findFileTransferMap(byte by) {
        Object object = this.mapSynchronisation;
        synchronized (object) {
            HashMap hashMap = this.fileTransferRequestObjects;
            if (this.isUpload(by)) {
                hashMap = this.fileTransferUploadObjects;
            }
            return hashMap;
        }
    }

    private boolean sendFileTransferStatus(int n, IFile iFile, byte by, boolean bl) {
        if (iFile.hasError()) {
            by = (byte)(by | FileTransferConstants.FLAG_STATUS_ERROR);
            this.fileTransferSender.sendFileStatus(n, iFile.getLocalPath(), by, 0L, 0L, this.hashType, new byte[0]);
        } else {
            if (iFile.isAvailable()) {
                by = (byte)(by | FileTransferConstants.FLAG_STATUS_AVAILABLE);
            }
            if (iFile.isFile()) {
                by = (byte)(by | FileTransferConstants.FLAG_STATUS_IS_FILE);
            }
            if (iFile.isReadable()) {
                by = (byte)(by | FileTransferConstants.FLAG_STATUS_READABLE);
            }
            long l = iFile.getSize();
            long l2 = iFile.getTimestamp();
            byte[] byArray = new byte[]{};
            if (!bl) {
                byArray = FileTransferUtils.calculateHash(this.hashType, iFile);
            }
            this.fileTransferSender.sendFileStatus(n, iFile.getLocalPath(), by, l, l2, this.hashType, byArray);
        }
        return true;
    }

    private boolean sendFileTransferMessages(int n, IFile iFile, byte by) {
        int n2 = 0;
        byte[] byArray = null;
        do {
            byte by2 = by;
            if (n2 == 0) {
                by2 = (byte)(by2 | FileTransferConstants.FLAG_TRANSFER_FIRST_BLOCK);
            }
            if ((byArray = iFile.read(this.blockSize)) != null) {
                if (iFile.getOffset() == iFile.getSize()) {
                    by2 = (byte)(by2 | FileTransferConstants.FLAG_TRANSFER_LAST_BLOCK);
                }
            } else {
                return false;
            }
            this.notifyListenerFileTransferProgress(iFile);
            this.fileTransferSender.sendFileTransfer(n, n2, by2, byArray.length, byArray);
            ++n2;
        } while (iFile.getOffset() < iFile.getSize());
        return true;
    }

    private void removeTransferId(HashMap hashMap, int n) {
        this.requestIdPool.releaseId(n);
        hashMap.remove(new Integer(n));
    }

    private boolean isLastBlock(byte by) {
        return this.hasFlag(by, FileTransferConstants.FLAG_TRANSFER_LAST_BLOCK);
    }

    private boolean isFirstBlock(byte by) {
        return this.hasFlag(by, FileTransferConstants.FLAG_TRANSFER_FIRST_BLOCK);
    }

    private boolean isUpload(byte by) {
        return this.hasFlag(by, FileTransferConstants.FLAG_FILE_UPLOAD);
    }

    private boolean hasFlag(byte by, byte by2) {
        return (by & by2) == by2;
    }

    @Override
    public boolean reset(String string) {
        this.cleanTransferObjects();
        this.downloadDirectory = string;
        return true;
    }
}

