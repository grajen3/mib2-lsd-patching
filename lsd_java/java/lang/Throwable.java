/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;

public class Throwable
implements Serializable {
    private static final long serialVersionUID;
    private String detailMessage;
    private transient Object walkback;
    private Throwable cause = this;
    private StackTraceElement[] stackTrace = null;

    public Throwable() {
        this.fillInStackTrace();
    }

    public Throwable(String string) {
        this();
        this.detailMessage = string;
    }

    public Throwable(String string, Throwable throwable) {
        this();
        this.detailMessage = string;
        this.cause = throwable;
    }

    public Throwable(Throwable throwable) {
        this();
        this.detailMessage = throwable == null ? null : throwable.toString();
        this.cause = throwable;
    }

    public native Throwable fillInStackTrace() {
    }

    public String getMessage() {
        return this.detailMessage;
    }

    public String getLocalizedMessage() {
        return this.getMessage();
    }

    public StackTraceElement[] getStackTrace() {
        return (StackTraceElement[])this.getInternalStackTrace().clone();
    }

    public void setStackTrace(StackTraceElement[] stackTraceElementArray) {
        StackTraceElement[] stackTraceElementArray2 = (StackTraceElement[])stackTraceElementArray.clone();
        int n = 0;
        while (n < stackTraceElementArray2.length) {
            if (stackTraceElementArray2[n] == null) {
                throw new NullPointerException();
            }
            ++n;
        }
        this.stackTrace = stackTraceElementArray2;
    }

    public void printStackTrace() {
        this.printStackTrace(System.err);
    }

    private static int countDuplicates(StackTraceElement[] stackTraceElementArray, StackTraceElement[] stackTraceElementArray2) {
        int n = 0;
        int n2 = stackTraceElementArray2.length;
        int n3 = stackTraceElementArray.length;
        while (--n3 >= 0 && --n2 >= 0) {
            StackTraceElement stackTraceElement = stackTraceElementArray2[n2];
            if (!stackTraceElement.equals(stackTraceElementArray[n3])) break;
            ++n;
        }
        return n;
    }

    private StackTraceElement[] getInternalStackTrace() {
        if (this.stackTrace == null) {
            this.stackTrace = J9VMInternals.getStackTrace(this, true);
        }
        return this.stackTrace;
    }

    public void printStackTrace(PrintStream printStream) {
        StackTraceElement[] stackTraceElementArray = this.printStackTrace(printStream, null);
        Throwable throwable = this.getCause();
        while (throwable != null && stackTraceElementArray != null) {
            stackTraceElementArray = throwable.printStackTrace(printStream, stackTraceElementArray);
            throwable = throwable.getCause();
        }
    }

    public void printStackTrace(PrintWriter printWriter) {
        StackTraceElement[] stackTraceElementArray = this.printStackTrace(printWriter, null);
        Throwable throwable = this.getCause();
        while (throwable != null && stackTraceElementArray != null) {
            stackTraceElementArray = throwable.printStackTrace(printWriter, stackTraceElementArray);
            throwable = throwable.getCause();
        }
    }

    public String toString() {
        String string = this.getLocalizedMessage();
        String string2 = super.getClass().getName();
        if (string == null) {
            return string2;
        }
        return new StringBuffer(string2.length() + 2 + string.length()).append(string2).append(": ").append(string).toString();
    }

    public synchronized Throwable initCause(Throwable throwable) {
        if (this.cause == this) {
            if (throwable != this) {
                this.cause = throwable;
                return this;
            }
            throw new IllegalArgumentException("Cause cannot be the receiver");
        }
        throw new IllegalStateException("Cause already initialized");
    }

    public Throwable getCause() {
        if (this.cause == this) {
            return null;
        }
        return this.cause;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        this.getInternalStackTrace();
        objectOutputStream.defaultWriteObject();
    }

    static void appendTo(Object object, String string) {
        StackTraceElement.appendTo(object, string);
    }

    static void appendTo(Object object, int n) {
        StackTraceElement.appendTo(object, n);
    }

    static void appendLnTo(Object object) {
        if (object instanceof PrintStream) {
            ((PrintStream)object).println();
        } else if (object instanceof PrintWriter) {
            ((PrintWriter)object).println();
        } else {
            Throwable.appendTo(object, "\n");
        }
    }

    private StackTraceElement[] printStackTrace(Object object, StackTraceElement[] stackTraceElementArray) {
        StackTraceElement[] stackTraceElementArray2;
        if (object == null) {
            throw new NullPointerException();
        }
        boolean bl = this instanceof OutOfMemoryError;
        if (stackTraceElementArray != null) {
            Throwable.appendTo(object, "Caused by: ");
        }
        if (!bl) {
            try {
                Throwable.appendTo(object, this.toString());
            }
            catch (OutOfMemoryError outOfMemoryError) {
                bl = true;
            }
        }
        if (bl) {
            try {
                Throwable.appendTo(object, super.getClass().getName());
            }
            catch (OutOfMemoryError outOfMemoryError) {
                bl = true;
                Throwable.appendTo(object, "java.lang.OutOfMemoryError(?)");
            }
            try {
                String string = this.getLocalizedMessage();
                if (string != null) {
                    Throwable.appendTo(object, ": ");
                    Throwable.appendTo(object, string);
                }
            }
            catch (OutOfMemoryError outOfMemoryError) {
                bl = true;
            }
        }
        Throwable.appendLnTo(object);
        int n = 0;
        try {
            stackTraceElementArray2 = this.getInternalStackTrace();
            if (stackTraceElementArray != null) {
                n = Throwable.countDuplicates(stackTraceElementArray2, stackTraceElementArray);
            }
        }
        catch (OutOfMemoryError outOfMemoryError) {
            Throwable.appendTo(object, "\tat ?");
            Throwable.appendLnTo(object);
            return null;
        }
        int n2 = 0;
        while (n2 < stackTraceElementArray2.length - n) {
            if (!bl) {
                try {
                    Throwable.appendTo(object, new StringBuffer("\tat ").append(stackTraceElementArray2[n2]).toString());
                }
                catch (OutOfMemoryError outOfMemoryError) {
                    bl = true;
                }
            }
            if (bl) {
                Throwable.appendTo(object, "\tat ");
                stackTraceElementArray2[n2].appendTo(object);
            }
            Throwable.appendLnTo(object);
            ++n2;
        }
        if (n > 0) {
            if (!bl) {
                try {
                    Throwable.appendTo(object, new StringBuffer("\t... ").append(n).append(" more").toString());
                }
                catch (OutOfMemoryError outOfMemoryError) {
                    bl = true;
                }
            }
            if (bl) {
                Throwable.appendTo(object, "\t... ");
                Throwable.appendTo(object, n);
                Throwable.appendTo(object, " more");
            }
            Throwable.appendLnTo(object);
        }
        return stackTraceElementArray2;
    }
}

