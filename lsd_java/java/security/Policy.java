/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import com.ibm.oti.util.DefaultPolicy;
import com.ibm.oti.util.PriviAction;
import java.security.AccessController;
import java.security.CodeSource;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.ProtectionDomain;
import java.security.SecurityPermission;

public abstract class Policy {
    static Policy policy;

    public static Policy getPolicy() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(SecurityPermission.permissionToGetPolicy);
        }
        return Policy.getPolicyImpl();
    }

    static Policy getPolicyImpl() {
        if (policy == null) {
            String string = (String)AccessController.doPrivileged(PriviAction.getSecurityProperty("policy.provider"));
            try {
                if (string != null) {
                    policy = (Policy)Class.forName(string).newInstance();
                }
            }
            catch (Exception exception) {}
            if (policy == null) {
                policy = new DefaultPolicy();
            }
        }
        return policy;
    }

    public static void setPolicy(Policy policy) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(SecurityPermission.permissionToSetPolicy);
        }
        Policy.policy = policy;
    }

    public abstract PermissionCollection getPermissions(CodeSource codeSource) {
    }

    public abstract void refresh() {
    }

    public PermissionCollection getPermissions(ProtectionDomain protectionDomain) {
        return this.getPermissions(protectionDomain.getCodeSource());
    }

    public boolean implies(ProtectionDomain protectionDomain, Permission permission) {
        return this.getPermissions(protectionDomain).implies(permission);
    }
}

