/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.filetransfer;

import de.esolutions.fw.util.tracing.filetransfer.AbstractFileTransferListener;
import de.esolutions.fw.util.tracing.filetransfer.IFileTransferListener;
import de.esolutions.fw.util.tracing.filetransfer.file.IFile;

public class DefaultFileTransferListener
extends AbstractFileTransferListener
implements IFileTransferListener {
    @Override
    public void fileTransferBegin(IFile iFile) {
        System.out.println("FileTransfer Begin");
        System.out.println(new StringBuffer().append("  Object:          ").append(iFile).toString());
        System.out.println(new StringBuffer().append("  Class:           ").append(super.getClass().getName()).toString());
        System.out.println(new StringBuffer().append("  RemotePath:      ").append(iFile.getRemotePath()).toString());
        System.out.println(new StringBuffer().append("  LocalPath:       ").append(iFile.getLocalPath()).toString());
    }

    @Override
    public void fileTransferStatus(IFile iFile) {
        System.out.println("FileStatus");
        System.out.println(new StringBuffer().append("  Object:          ").append(iFile).toString());
        System.out.println(new StringBuffer().append("  Class:           ").append(super.getClass().getName()).toString());
        System.out.println(new StringBuffer().append("  RemotePath:      ").append(iFile.getRemotePath()).toString());
        System.out.println(new StringBuffer().append("  LocalPath:       ").append(iFile.getLocalPath()).toString());
        System.out.println(new StringBuffer().append("  Size:            ").append(iFile.getSize()).toString());
        System.out.println(new StringBuffer().append("  Timestamp:       ").append(iFile.getTimestamp()).toString());
        System.out.println(new StringBuffer().append("  HashValid:       ").append(iFile.isHashValid()).toString());
        System.out.println(new StringBuffer().append("  isAvailable:     ").append(iFile.isAvailable()).toString());
        System.out.println(new StringBuffer().append("  isFile:          ").append(iFile.isFile()).toString());
        System.out.println(new StringBuffer().append("  isReadable:      ").append(iFile.isReadable()).toString());
        System.out.println(new StringBuffer().append("  isUpload:        ").append(iFile.isUpload()).toString());
        System.out.println(new StringBuffer().append("  hasError:        ").append(iFile.hasError()).toString());
        if (iFile.hasError() && iFile.getError() != null) {
            System.out.println("####### ERROR #######");
            System.out.println(new StringBuffer().append("  errorMessage:    ").append(iFile.getError().getErrorMessage()).toString());
            System.out.println(new StringBuffer().append("  errorCode:       ").append(iFile.getError().getErrorCode()).toString());
            System.out.println(new StringBuffer().append("  Exception:       ").append(iFile.getError().getException()).toString());
        }
    }

    @Override
    public void fileTransferComplete(IFile iFile) {
        System.out.println("FileTransfer is complete");
        System.out.println(new StringBuffer().append("  Object:          ").append(iFile).toString());
        System.out.println(new StringBuffer().append("  Class:           ").append(super.getClass().getName()).toString());
        System.out.println(new StringBuffer().append("  RemotePath:      ").append(iFile.getRemotePath()).toString());
        System.out.println(new StringBuffer().append("  LocalPath:       ").append(iFile.getLocalPath()).toString());
        System.out.println(new StringBuffer().append("  Size:            ").append(iFile.getSize()).toString());
        System.out.println(new StringBuffer().append("  Timestamp:       ").append(iFile.getTimestamp()).toString());
        System.out.println(new StringBuffer().append("  HashValid:       ").append(iFile.isHashValid()).toString());
        System.out.println(new StringBuffer().append("  isAvailable:     ").append(iFile.isAvailable()).toString());
        System.out.println(new StringBuffer().append("  isFile:          ").append(iFile.isFile()).toString());
        System.out.println(new StringBuffer().append("  isReadable:      ").append(iFile.isReadable()).toString());
        System.out.println(new StringBuffer().append("  isUpload:        ").append(iFile.isUpload()).toString());
        System.out.println(new StringBuffer().append("  hasError:        ").append(iFile.hasError()).toString());
        if (iFile.hasError() && iFile.getError() != null) {
            System.out.println("####### ERROR #######");
            System.out.println(new StringBuffer().append("  errorMessage:    ").append(iFile.getError().getErrorMessage()).toString());
            System.out.println(new StringBuffer().append("  errorCode:       ").append(iFile.getError().getErrorCode()).toString());
            System.out.println(new StringBuffer().append("  Exception:       ").append(iFile.getError().getException()).toString());
            iFile.getError().getException().printStackTrace();
        }
    }

    @Override
    public void fileTransferProgress(IFile iFile) {
        System.out.println(new StringBuffer().append("FileTransfer Progress: ").append(iFile.getLocalPath()).append(": ").append(iFile.getSize()).append(", ").append(iFile.getOffset()).toString());
    }

    @Override
    public void fileTransferError(IFile iFile) {
        if (iFile != null) {
            System.out.println("FileTransfer Error ");
            System.out.println(new StringBuffer().append("  Object:          ").append(iFile).toString());
            System.out.println(new StringBuffer().append("  RemotePath:      ").append(iFile.getRemotePath()).toString());
            System.out.println(new StringBuffer().append("  LocalPath:       ").append(iFile.getLocalPath()).toString());
            System.out.println(new StringBuffer().append("  hasError:        ").append(iFile.hasError()).toString());
            System.out.println(new StringBuffer().append("  errorMessage:    ").append(iFile.getError().getErrorMessage()).toString());
            System.out.println(new StringBuffer().append("  errorCode:       ").append(iFile.getError().getErrorCode()).toString());
            System.out.println(new StringBuffer().append("  Exception:       ").append(iFile.getError().getException()).toString());
            System.out.println(new StringBuffer().append("  HashValid:       ").append(iFile.isHashValid()).toString());
            System.out.println(new StringBuffer().append("  isAvailable:     ").append(iFile.isAvailable()).toString());
            System.out.println(new StringBuffer().append("  isFile:          ").append(iFile.isFile()).toString());
            System.out.println(new StringBuffer().append("  isReadable:      ").append(iFile.isReadable()).toString());
        }
    }

    public void fileUploadComplete(IFile iFile) {
        System.out.println("FileTransfer Upload complete ");
        System.out.println(new StringBuffer().append("  Object:          ").append(iFile).toString());
        System.out.println(new StringBuffer().append("  path:            ").append(iFile.getLocalPath()).toString());
    }
}

