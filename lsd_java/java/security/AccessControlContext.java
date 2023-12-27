/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import com.ibm.oti.util.Msg;
import com.ibm.oti.util.PriviAction;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.DomainCombiner;
import java.security.Permission;
import java.security.ProtectionDomain;
import java.security.SecurityPermission;

public final class AccessControlContext {
    static int debugSetting = -1;
    DomainCombiner domainCombiner;
    ProtectionDomain[] domainsArray;
    private static final SecurityPermission createAccessControlContext = new SecurityPermission("createAccessControlContext");
    private static final SecurityPermission getDomainCombiner = new SecurityPermission("getDomainCombiner");
    static final int DEBUG_ACCESS;
    static final int DEBUG_ACCESS_STACK;
    static final int DEBUG_ACCESS_DOMAIN;
    static final int DEBUG_ACCESS_FAILURE;
    static final int DEBUG_ACCESS_THREAD;
    static final int DEBUG_ALL;

    static int debugSetting() {
        if (debugSetting != -1) {
            return debugSetting;
        }
        debugSetting = 0;
        boolean bl = false;
        String string = (String)AccessController.doPrivileged(new PriviAction("java.security.debug"));
        if (string == null) {
            return debugSetting;
        }
        int n = 0;
        int n2 = string.length();
        while (n < n2) {
            String string2;
            int n3 = string.indexOf(44, n);
            if (n3 == -1) {
                n3 = n2;
            }
            if ((string2 = string.substring(n, n3)).equals("all")) {
                debugSetting = 255;
                return debugSetting;
            }
            if (string2.startsWith("access")) {
                debugSetting |= 1;
                if (n + 6 < n2 && string.charAt(n + 6) == ':') {
                    n3 = n + 6;
                    bl = true;
                }
            } else if (bl && string2.equals("stack")) {
                debugSetting |= 2;
            } else if (bl && string2.equals("domain")) {
                debugSetting |= 4;
            } else if (bl && string2.equals("failure")) {
                debugSetting |= 8;
            } else if (bl && string2.equals("thread")) {
                debugSetting |= 0x10;
            } else {
                bl = false;
            }
            n = n3 + 1;
        }
        return debugSetting;
    }

    static void debugPrintAccess() {
        System.err.print("access: ");
        if ((AccessControlContext.debugSetting() & 0x10) == 16) {
            System.err.print(new StringBuffer("(").append(Thread.currentThread()).append(")").toString());
        }
    }

    public AccessControlContext(ProtectionDomain[] protectionDomainArray) {
        int n = protectionDomainArray.length;
        int n2 = 0;
        this.domainsArray = new ProtectionDomain[n];
        int n3 = 0;
        while (n3 < n) {
            block4: {
                ProtectionDomain protectionDomain = protectionDomainArray[n3];
                int n4 = 0;
                while (n4 < n3) {
                    if (protectionDomain != this.domainsArray[n4]) {
                        ++n4;
                        continue;
                    }
                    break block4;
                }
                this.domainsArray[n2++] = protectionDomain;
            }
            ++n3;
        }
        if (n2 != n) {
            ProtectionDomain[] protectionDomainArray2 = new ProtectionDomain[n2];
            System.arraycopy((Object)this.domainsArray, 0, (Object)protectionDomainArray2, 0, n2);
            this.domainsArray = protectionDomainArray2;
        }
    }

    AccessControlContext(ProtectionDomain[] protectionDomainArray, boolean bl) {
        this.domainsArray = protectionDomainArray;
    }

    public AccessControlContext(AccessControlContext accessControlContext, DomainCombiner domainCombiner) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(createAccessControlContext);
        }
        this.domainsArray = accessControlContext.domainsArray;
        this.domainCombiner = domainCombiner;
    }

    public void checkPermission(Permission permission) {
        int n;
        if (permission == null) {
            throw new NullPointerException();
        }
        if ((AccessControlContext.debugSetting() & 4) != 0) {
            AccessControlContext.debugPrintAccess();
            if (this.domainsArray.length == 0) {
                System.err.println("domain (context is null)");
            } else {
                n = 0;
                while (n < this.domainsArray.length) {
                    System.err.println(new StringBuffer("domain ").append(n).append(" ").append(this.domainsArray[n]).toString());
                    ++n;
                }
            }
        }
        n = this.domainsArray.length;
        while (--n >= 0 && this.domainsArray[n].implies(permission)) {
        }
        if (n >= 0) {
            if ((AccessControlContext.debugSetting() & 1) != 0) {
                AccessControlContext.debugPrintAccess();
                System.err.println(new StringBuffer("access denied ").append(permission).toString());
            }
            if ((AccessControlContext.debugSetting() & 8) != 0) {
                new Exception("Stack trace").printStackTrace();
                System.err.println(new StringBuffer("domain that failed ").append(this.domainsArray[n]).toString());
            }
            throw new AccessControlException(Msg.getString("K002c", permission), permission);
        }
        if ((AccessControlContext.debugSetting() & 1) != 0) {
            AccessControlContext.debugPrintAccess();
            System.err.println(new StringBuffer("access allowed ").append(permission).toString());
        }
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || super.getClass() != object.getClass()) {
            return false;
        }
        AccessControlContext accessControlContext = (AccessControlContext)object;
        int n = this.domainsArray.length;
        ProtectionDomain[] protectionDomainArray = accessControlContext.domainsArray;
        if (n != protectionDomainArray.length) {
            return false;
        }
        int n2 = 0;
        while (n2 < n) {
            block6: {
                ProtectionDomain protectionDomain = this.domainsArray[n2];
                int n3 = 0;
                while (n3 < n) {
                    if (protectionDomain != protectionDomainArray[n3]) {
                        ++n3;
                        continue;
                    }
                    break block6;
                }
                return false;
            }
            ++n2;
        }
        return true;
    }

    public int hashCode() {
        int n = 0;
        int n2 = this.domainsArray.length;
        while (--n2 >= 0) {
            n ^= this.domainsArray[n2].hashCode();
        }
        return n;
    }

    public DomainCombiner getDomainCombiner() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(getDomainCombiner);
        }
        return this.domainCombiner;
    }
}

