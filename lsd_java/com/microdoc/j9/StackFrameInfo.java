/*
 * Decompiled with CFR 0.152.
 */
package com.microdoc.j9;

public class StackFrameInfo {
    String fClassName = null;
    String fMethodName = null;
    String fMethodSignature = null;

    public StackFrameInfo(String string, String string2, String string3) {
        this.fClassName = string;
        this.fMethodName = string2;
        this.fMethodSignature = string3;
    }

    public StackFrameInfo() {
    }

    public String getClassName() {
        return this.fClassName;
    }

    public void setClassName(String string) {
        this.fClassName = string;
    }

    public String getMethodName() {
        return this.fMethodName;
    }

    public void setMethodName(String string) {
        this.fMethodName = string;
    }

    public String getMethodSignature() {
        return this.fMethodSignature;
    }

    public void setMethodSignature(String string) {
        this.fMethodSignature = string;
    }
}

