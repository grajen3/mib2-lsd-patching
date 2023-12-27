/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import com.ibm.oti.util.PriviAction;
import java.security.AccessController;
import java.security.CodeSource;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.Policy;
import java.security.Principal;

public class ProtectionDomain {
    private CodeSource cs;
    private PermissionCollection pc;
    private ClassLoader classLoader;
    private Principal[] principals;
    private boolean dynamicPermissionChecking = false;

    public ProtectionDomain(CodeSource codeSource, PermissionCollection permissionCollection) {
        this.cs = codeSource;
        this.pc = permissionCollection;
        if (this.pc != null) {
            this.pc.setReadOnly();
        }
    }

    public ProtectionDomain(CodeSource codeSource, PermissionCollection permissionCollection, ClassLoader classLoader, Principal[] principalArray) {
        this.cs = codeSource;
        this.pc = permissionCollection;
        if (this.pc != null) {
            this.pc.setReadOnly();
        }
        this.dynamicPermissionChecking = true;
        this.classLoader = classLoader;
        this.principals = principalArray;
    }

    public final CodeSource getCodeSource() {
        return this.cs;
    }

    public final PermissionCollection getPermissions() {
        return this.pc;
    }

    public final Principal[] getPrincipals() {
        if (this.principals == null) {
            return new Principal[0];
        }
        Principal[] principalArray = new Principal[this.principals.length];
        System.arraycopy((Object)this.principals, 0, (Object)principalArray, 0, this.principals.length);
        return principalArray;
    }

    public final ClassLoader getClassLoader() {
        return this.classLoader;
    }

    public boolean implies(Permission permission) {
        if (this.dynamicPermissionChecking) {
            PermissionCollection permissionCollection = Policy.getPolicyImpl().getPermissions(this);
            return this.pc != null && this.pc.implies(permission) || permissionCollection != null && permissionCollection.implies(permission);
        }
        return this.pc != null && this.pc.implies(permission);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("ProtectionDomain ");
        if (this.cs == null) {
            stringBuffer.append("null");
        } else {
            stringBuffer.append(this.cs.toString());
        }
        String string = (String)AccessController.doPrivileged(new PriviAction("line.separator"));
        stringBuffer.append(string);
        if (this.pc == null) {
            stringBuffer.append("null");
        } else {
            stringBuffer.append(this.pc.toString());
        }
        return stringBuffer.toString();
    }
}

