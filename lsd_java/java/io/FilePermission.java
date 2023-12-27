/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import com.ibm.oti.util.Msg;
import java.io.File;
import java.io.FilePermission$1;
import java.io.FilePermissionCollection;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.AccessController;
import java.security.Permission;
import java.security.PermissionCollection;

public final class FilePermission
extends Permission
implements Serializable {
    private static final long serialVersionUID;
    private transient String canonPath;
    private static final String[] actionList;
    private String actions;
    transient int mask = -1;
    private transient boolean includeAll = false;
    private transient boolean allDir = false;
    private transient boolean allSubdir = false;

    static {
        actionList = new String[]{"read", "write", "execute", "delete"};
    }

    public FilePermission(String string, String string2) {
        super(string);
        this.init(string, string2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void init(String string, String string2) {
        if (string2 == null || string2 == "") throw new IllegalArgumentException(Msg.getString("K006d"));
        if (string == null) throw new NullPointerException(Msg.getString("K006e"));
        if (string.equals("<<ALL FILES>>")) {
            this.includeAll = true;
        } else {
            this.canonPath = (String)AccessController.doPrivileged(new FilePermission$1(this, string));
            if (string.equals("*") || string.endsWith(new StringBuffer(String.valueOf(File.separator)).append("*").toString())) {
                this.allDir = true;
            }
            if (string.equals("-") || string.endsWith(new StringBuffer(String.valueOf(File.separator)).append("-").toString())) {
                this.allSubdir = true;
            }
        }
        this.actions = this.toCanonicalActionString(string2);
    }

    private String toCanonicalActionString(String string) {
        this.actions = string.trim().toLowerCase();
        this.mask = this.getMask(this.actions);
        int n = actionList.length;
        int n2 = 1 << n - 1;
        StringBuffer stringBuffer = new StringBuffer();
        boolean bl = false;
        int n3 = 0;
        while (n3 < n) {
            if ((n2 & this.mask) != 0) {
                if (bl) {
                    stringBuffer.append(",");
                }
                stringBuffer.append(actionList[n3]);
                bl = true;
            }
            n2 >>= 1;
            ++n3;
        }
        return stringBuffer.toString();
    }

    private int getMask(String string) {
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        do {
            String string2;
            String string3 = string2 = (n3 = string.indexOf(",", n2)) > 0 ? string.substring(n2, n3).trim() : string.substring(n2).trim();
            if (string2.equals("read")) {
                n |= 8;
            } else if (string2.equals("write")) {
                n |= 4;
            } else if (string2.equals("execute")) {
                n |= 2;
            } else if (string2.equals("delete")) {
                n |= 1;
            } else {
                throw new IllegalArgumentException(Msg.getString("K006f", string2));
            }
            n2 = n3 + 1;
        } while (n3 > 0);
        return n;
    }

    @Override
    public String getActions() {
        return this.actions;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof FilePermission) {
            FilePermission filePermission = (FilePermission)object;
            if (!(filePermission.actions == this.actions || filePermission.actions != null && filePermission.actions.equals(this.actions))) {
                return false;
            }
            if (filePermission.includeAll || this.includeAll) {
                return filePermission.includeAll == this.includeAll;
            }
            return filePermission.canonPath.equals(this.canonPath);
        }
        return false;
    }

    @Override
    public boolean implies(Permission permission) {
        int n = this.impliesMask(permission);
        return n != 0 && n == ((FilePermission)permission).mask;
    }

    int impliesMask(Permission permission) {
        if (!(permission instanceof FilePermission)) {
            return 0;
        }
        FilePermission filePermission = (FilePermission)permission;
        int n = this.mask & filePermission.mask;
        if (n == 0) {
            return 0;
        }
        if (this.includeAll) {
            return n;
        }
        if (filePermission.includeAll) {
            return 0;
        }
        int n2 = this.canonPath.length();
        if (this.allSubdir && n2 == 2 && !filePermission.canonPath.equals(File.separator)) {
            return n;
        }
        if (filePermission.allSubdir && !this.allSubdir) {
            return 0;
        }
        if (filePermission.allDir && !this.allSubdir && !this.allDir) {
            return 0;
        }
        boolean bl = false;
        int n3 = filePermission.canonPath.length();
        if (this.allDir || this.allSubdir) {
            --n2;
        }
        if (filePermission.allDir || filePermission.allSubdir) {
            --n3;
        }
        int n4 = 0;
        while (n4 < n3) {
            char c2 = filePermission.canonPath.charAt(n4);
            if (n4 >= n2) {
                if (n4 == n2) {
                    if (this.allSubdir) {
                        return n;
                    }
                    if (this.allDir) {
                        bl = true;
                    }
                }
                if (!bl) {
                    return 0;
                }
                if (c2 == File.separatorChar) {
                    return 0;
                }
            } else if (this.canonPath.charAt(n4) != c2) {
                return 0;
            }
            ++n4;
        }
        if (n3 == n2) {
            if (this.allSubdir) {
                return filePermission.allSubdir || filePermission.allDir ? n : 0;
            }
            return this.allDir == filePermission.allDir ? n : 0;
        }
        return bl ? n : 0;
    }

    @Override
    public PermissionCollection newPermissionCollection() {
        return new FilePermissionCollection();
    }

    @Override
    public int hashCode() {
        return (this.canonPath == null ? this.getName().hashCode() : this.canonPath.hashCode()) + this.mask;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.init(this.getName(), this.actions);
    }
}

