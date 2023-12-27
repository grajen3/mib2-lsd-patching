/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;

public final class StackTraceElement
implements Serializable {
    private static final long serialVersionUID;
    String declaringClass;
    String methodName;
    String fileName;
    int lineNumber;
    private static final String[] digits;

    static {
        digits = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    }

    private StackTraceElement() {
    }

    public boolean equals(Object object) {
        if (!(object instanceof StackTraceElement)) {
            return false;
        }
        StackTraceElement stackTraceElement = (StackTraceElement)object;
        if (this.methodName == null || stackTraceElement.methodName == null) {
            return false;
        }
        if (!this.getMethodName().equals(stackTraceElement.getMethodName())) {
            return false;
        }
        if (!this.getClassName().equals(stackTraceElement.getClassName())) {
            return false;
        }
        String string = this.getFileName();
        if (string == null ? stackTraceElement.getFileName() != null : !string.equals(stackTraceElement.getFileName())) {
            return false;
        }
        return this.getLineNumber() == stackTraceElement.getLineNumber();
    }

    public String getClassName() {
        return this.declaringClass == null ? "<unknown class>" : this.declaringClass;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public String getMethodName() {
        return this.methodName == null ? "<unknown method>" : this.methodName;
    }

    public int hashCode() {
        if (this.methodName == null) {
            return 0;
        }
        return this.methodName.hashCode() ^ this.declaringClass.hashCode();
    }

    public boolean isNativeMethod() {
        return this.lineNumber == -2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(80);
        this.appendTo(stringBuffer);
        return stringBuffer.toString();
    }

    void appendTo(Object object) {
        StackTraceElement.appendTo(object, this.getClassName());
        StackTraceElement.appendTo(object, ".");
        StackTraceElement.appendTo(object, this.getMethodName());
        if (this.isNativeMethod()) {
            StackTraceElement.appendTo(object, "(Native Method)");
        } else {
            String string = this.getFileName();
            if (string == null) {
                StackTraceElement.appendTo(object, "(Unknown Source)");
            } else {
                int n = this.getLineNumber();
                StackTraceElement.appendTo(object, "(");
                StackTraceElement.appendTo(object, string);
                if (n >= 0) {
                    StackTraceElement.appendTo(object, ":");
                    StackTraceElement.appendTo(object, n);
                }
                StackTraceElement.appendTo(object, ")");
            }
        }
    }

    static void appendTo(Object object, String string) {
        if (object instanceof StringBuffer) {
            ((StringBuffer)object).append(string);
        } else if (object instanceof PrintStream) {
            ((PrintStream)object).print(string);
        } else if (object instanceof PrintWriter) {
            ((PrintWriter)object).print(string);
        }
    }

    static void appendTo(Object object, int n) {
        int n2 = 1;
        int n3 = n;
        while (n3 >= 10) {
            n2 *= 10;
            n3 /= 10;
        }
        StackTraceElement.appendTo(object, digits[n3]);
        while (n2 >= 10) {
            n3 = (n -= n2 * n3) / (n2 /= 10);
            StackTraceElement.appendTo(object, digits[n3]);
        }
    }
}

