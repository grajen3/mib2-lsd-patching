/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

import java.security.BasicPermission;

public final class RuntimePermission
extends BasicPermission {
    private static final long serialVersionUID;
    static final RuntimePermission permissionToSetSecurityManager;
    static final RuntimePermission permissionToCreateSecurityManager;
    static final RuntimePermission permissionToGetProtectionDomain;
    static final RuntimePermission permissionToGetClassLoader;
    static final RuntimePermission permissionToCreateClassLoader;
    static final RuntimePermission permissionToModifyThread;
    static final RuntimePermission permissionToModifyThreadGroup;
    static final RuntimePermission permissionToExitVM;
    static final RuntimePermission permissionToReadFileDescriptor;
    static final RuntimePermission permissionToWriteFileDescriptor;
    static final RuntimePermission permissionToQueuePrintJob;
    static final RuntimePermission permissionToSetFactory;
    static final RuntimePermission permissionToSetIO;
    static final RuntimePermission permissionToStopThread;
    static final RuntimePermission permissionToSetContextClassLoader;

    static {
        permissionToSetSecurityManager = new RuntimePermission("setSecurityManager");
        permissionToCreateSecurityManager = new RuntimePermission("createSecurityManager");
        permissionToGetProtectionDomain = new RuntimePermission("getProtectionDomain");
        permissionToGetClassLoader = new RuntimePermission("getClassLoader");
        permissionToCreateClassLoader = new RuntimePermission("createClassLoader");
        permissionToModifyThread = new RuntimePermission("modifyThread");
        permissionToModifyThreadGroup = new RuntimePermission("modifyThreadGroup");
        permissionToExitVM = new RuntimePermission("exitVM");
        permissionToReadFileDescriptor = new RuntimePermission("readFileDescriptor");
        permissionToWriteFileDescriptor = new RuntimePermission("writeFileDescriptor");
        permissionToQueuePrintJob = new RuntimePermission("queuePrintJob");
        permissionToSetFactory = new RuntimePermission("setFactory");
        permissionToSetIO = new RuntimePermission("setIO");
        permissionToStopThread = new RuntimePermission("stopThread");
        permissionToSetContextClassLoader = new RuntimePermission("setContextClassLoader");
    }

    public RuntimePermission(String string) {
        super(string);
    }

    public RuntimePermission(String string, String string2) {
        super(string, string2);
    }
}

