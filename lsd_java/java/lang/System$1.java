/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

import com.ibm.oti.util.Msg;
import java.security.AllPermission;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;

final class System$1
implements PrivilegedAction {
    private final /* synthetic */ SecurityManager val$currentSecurity;
    private final /* synthetic */ SecurityManager val$s;

    System$1(SecurityManager securityManager, SecurityManager securityManager2) {
        this.val$currentSecurity = securityManager;
        this.val$s = securityManager2;
    }

    @Override
    public Object run() {
        ProtectionDomain protectionDomain;
        ProtectionDomain protectionDomain2 = null;
        if (this.val$currentSecurity != null) {
            protectionDomain2 = super.getClass().getPDImpl();
        }
        if ((protectionDomain = super.getClass().getPDImpl()) != null && protectionDomain != protectionDomain2) {
            Msg.getString("K002c");
            protectionDomain.implies(new AllPermission());
        }
        return null;
    }
}

