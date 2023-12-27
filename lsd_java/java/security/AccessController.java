/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import com.ibm.oti.util.Msg;
import java.security.AccessControlContext;
import java.security.AccessControlException;
import java.security.Permission;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.security.ProtectionDomain;

public final class AccessController {
    static {
        AccessController.initializeInternal();
    }

    private static native void initializeInternal() {
    }

    private AccessController() {
    }

    private static native Object[] getProtectionDomains(int n) {
    }

    public static void checkPermission(Permission permission) {
        if (permission == null) {
            throw new NullPointerException();
        }
        if ((AccessControlContext.debugSetting() & 2) != 0) {
            new Exception("Stack trace").printStackTrace();
        }
        Object[] objectArray = AccessController.getProtectionDomains(1);
        AccessControlContext accessControlContext = (AccessControlContext)objectArray[0];
        ProtectionDomain[] protectionDomainArray = null;
        if (accessControlContext != null && accessControlContext.domainCombiner != null) {
            if ((AccessControlContext.debugSetting() & 1) != 0) {
                AccessControlContext.debugPrintAccess();
                System.err.println("AccessController invoking the Combiner");
            }
            protectionDomainArray = accessControlContext.domainCombiner.combine(AccessController.toArrayOfProtectionDomains(objectArray, null), accessControlContext.domainsArray);
        } else {
            protectionDomainArray = AccessController.toArrayOfProtectionDomains(objectArray, accessControlContext);
        }
        if ((AccessControlContext.debugSetting() & 4) != 0) {
            AccessControlContext.debugPrintAccess();
            if (protectionDomainArray.length == 0) {
                System.err.println("domain (context is null)");
            }
        }
        int n = 0;
        int n2 = protectionDomainArray.length;
        while (n < n2) {
            if (!protectionDomainArray[n].implies(permission)) {
                if ((AccessControlContext.debugSetting() & 1) != 0) {
                    AccessControlContext.debugPrintAccess();
                    System.err.println(new StringBuffer("access denied ").append(permission).toString());
                }
                if ((AccessControlContext.debugSetting() & 8) != 0) {
                    new Exception("Stack trace").printStackTrace();
                    System.err.println(new StringBuffer("domain that failed ").append(protectionDomainArray[n]).toString());
                }
                throw new AccessControlException(Msg.getString("K002c", permission), permission);
            }
            ++n;
        }
        if ((AccessControlContext.debugSetting() & 1) != 0) {
            AccessControlContext.debugPrintAccess();
            System.err.println(new StringBuffer("access allowed ").append(permission).toString());
        }
    }

    private static void keepalive(AccessControlContext accessControlContext) {
    }

    public static AccessControlContext getContext() {
        Object[] objectArray = AccessController.getProtectionDomains(1);
        AccessControlContext accessControlContext = (AccessControlContext)objectArray[0];
        ProtectionDomain[] protectionDomainArray = null;
        if (accessControlContext != null && accessControlContext.domainCombiner != null) {
            protectionDomainArray = accessControlContext.domainCombiner.combine(AccessController.toArrayOfProtectionDomains(objectArray, null), accessControlContext.domainsArray);
            AccessControlContext accessControlContext2 = new AccessControlContext(protectionDomainArray, false);
            accessControlContext2.domainCombiner = accessControlContext.domainCombiner;
            return accessControlContext2;
        }
        return new AccessControlContext(AccessController.toArrayOfProtectionDomains(objectArray, accessControlContext), false);
    }

    private static ProtectionDomain[] toArrayOfProtectionDomains(Object[] objectArray, AccessControlContext accessControlContext) {
        int n = 0;
        int n2 = objectArray.length - 1;
        int n3 = accessControlContext == null ? 0 : accessControlContext.domainsArray.length;
        ProtectionDomain[] protectionDomainArray = new ProtectionDomain[n2 + n3];
        int n4 = 1;
        while (n4 <= n2) {
            boolean bl = false;
            protectionDomainArray[n] = (ProtectionDomain)objectArray[n4];
            if (protectionDomainArray[n] == null) break;
            if (accessControlContext != null) {
                int n5 = 0;
                while (n5 < accessControlContext.domainsArray.length) {
                    if (protectionDomainArray[n] == accessControlContext.domainsArray[n5]) {
                        bl = true;
                        break;
                    }
                    ++n5;
                }
            }
            if (!bl) {
                ++n;
            }
            ++n4;
        }
        if (n == 0 && accessControlContext != null) {
            return accessControlContext.domainsArray;
        }
        if (n < n2) {
            ProtectionDomain[] protectionDomainArray2 = new ProtectionDomain[n + n3];
            System.arraycopy((Object)protectionDomainArray, 0, (Object)protectionDomainArray2, 0, n);
            protectionDomainArray = protectionDomainArray2;
        }
        if (accessControlContext != null) {
            System.arraycopy((Object)accessControlContext.domainsArray, 0, (Object)protectionDomainArray, n, accessControlContext.domainsArray.length);
        }
        return protectionDomainArray;
    }

    public static Object doPrivileged(PrivilegedAction privilegedAction) {
        return privilegedAction.run();
    }

    public static Object doPrivileged(PrivilegedAction privilegedAction, AccessControlContext accessControlContext) {
        Object object = privilegedAction.run();
        AccessController.keepalive(accessControlContext);
        return object;
    }

    public static Object doPrivileged(PrivilegedExceptionAction privilegedExceptionAction) {
        try {
            return privilegedExceptionAction.run();
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Exception exception) {
            throw new PrivilegedActionException(exception);
        }
    }

    public static Object doPrivileged(PrivilegedExceptionAction privilegedExceptionAction, AccessControlContext accessControlContext) {
        try {
            Object object = privilegedExceptionAction.run();
            AccessController.keepalive(accessControlContext);
            return object;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Exception exception) {
            throw new PrivilegedActionException(exception);
        }
    }
}

