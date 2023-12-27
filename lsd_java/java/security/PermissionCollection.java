/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import com.ibm.oti.util.PriviAction;
import java.io.Serializable;
import java.security.AccessController;
import java.security.Permission;
import java.util.Enumeration;

public abstract class PermissionCollection
implements Serializable {
    private boolean readOnly = false;

    public abstract void add(Permission permission) {
    }

    public abstract Enumeration elements() {
    }

    public abstract boolean implies(Permission permission) {
    }

    public boolean isReadOnly() {
        return this.readOnly;
    }

    public void setReadOnly() {
        this.readOnly = true;
    }

    public String toString() {
        String string = (String)AccessController.doPrivileged(new PriviAction("line.separator", "\n"));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.toString());
        stringBuffer.append(" (");
        Enumeration enumeration = this.elements();
        while (enumeration.hasMoreElements()) {
            Permission permission = (Permission)enumeration.nextElement();
            stringBuffer.append(string);
            stringBuffer.append("    ");
            stringBuffer.append(permission);
        }
        stringBuffer.append(string);
        stringBuffer.append(")");
        return stringBuffer.toString();
    }
}

