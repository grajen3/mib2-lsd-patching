/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.filetransfer;

public class FileTransferError {
    public static final byte ERROR_IN_OPERATION;
    public static final byte ERROR_SENDING_OPERATION_DOWNLOAD;
    public static final byte ERROR_SENDING_OPERATION_STATUS;
    public static final byte ERROR_SEND_REQUEST_FAILED;
    public static final byte ERROR_RECEIVED_INVALID_DATA;
    public static final byte ERROR_SESSION_END_DETECTED;
    private Exception exception = null;
    private byte errorCode = (byte)-1;
    private String errorMessage = null;

    private String getErrorMessage(byte by) {
        switch (by) {
            case 10: {
                return "Error in operation";
            }
            case 20: {
                return "Error in sending operation download";
            }
            case 21: {
                return "Error in sending operation status";
            }
            case 30: {
                return "send request failed";
            }
            case 40: {
                return "received unexpected or invalid data";
            }
            case 60: {
                return "Exit or Init Message received, Transfer canceled ";
            }
        }
        return new StringBuffer().append("no error message found for errorcode : ").append(by).toString();
    }

    public FileTransferError(byte by) {
        this.errorCode = by;
        this.errorMessage = this.getErrorMessage(this.errorCode);
    }

    public FileTransferError(byte by, Exception exception) {
        this.errorCode = by;
        this.exception = exception;
        this.errorMessage = exception.getMessage();
    }

    public FileTransferError(byte by, String string) {
        this.errorCode = by;
        this.errorMessage = string;
    }

    public FileTransferError(Exception exception) {
        this.exception = exception;
        this.errorMessage = exception.getMessage();
    }

    public Exception getException() {
        return this.exception;
    }

    public byte getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String toString() {
        String string = "FileTransferError: ";
        if (this.exception != null) {
            string = new StringBuffer().append(string).append("Exception: ").append(super.getClass()).append(", ").append(this.exception.getMessage()).toString();
        }
        if (this.errorCode != -1) {
            string = new StringBuffer().append(string).append("ErrorCode: ").append(this.errorCode).append(" ").toString();
        }
        if (this.errorMessage != null) {
            string = new StringBuffer().append(string).append("ErrorMessage: ").append(this.errorMessage).toString();
        }
        return string;
    }
}

