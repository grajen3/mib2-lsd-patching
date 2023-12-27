/*
 * Decompiled with CFR 0.152.
 */
package org.json.simple.parser;

public class ParseException
extends Exception {
    private static final long serialVersionUID;
    public static final int ERROR_UNEXPECTED_CHAR;
    public static final int ERROR_UNEXPECTED_TOKEN;
    public static final int ERROR_UNEXPECTED_EXCEPTION;
    private int errorType;
    private Object unexpectedObject;
    private int position;

    public ParseException(int n) {
        this(-1, n, null);
    }

    public ParseException(int n, Object object) {
        this(-1, n, object);
    }

    public ParseException(int n, int n2, Object object) {
        this.errorType = n2;
        this.unexpectedObject = object;
    }

    public int getErrorType() {
        return this.errorType;
    }

    public void setErrorType(int n) {
        this.errorType = n;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int n) {
        this.position = n;
    }

    public Object getUnexpectedObject() {
        return this.unexpectedObject;
    }

    public void setUnexpectedObject(Object object) {
        this.unexpectedObject = object;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        switch (this.errorType) {
            case 0: {
                stringBuffer.append("Unexpected character (").append(this.unexpectedObject).append(") at position ").append(this.position).append(".");
                break;
            }
            case 1: {
                stringBuffer.append("Unexpected token ").append(this.unexpectedObject).append(" at position ").append(this.position).append(".");
                break;
            }
            case 2: {
                stringBuffer.append("Unexpected exception at position ").append(this.position).append(": ").append(this.unexpectedObject);
                break;
            }
            default: {
                stringBuffer.append("Unkown error at position ").append(this.position).append(".");
            }
        }
        return stringBuffer.toString();
    }
}

