/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.ObjectInputStream;
import java.io.ObjectInputStream$GetField;
import java.io.ObjectOutputStream;
import java.io.ObjectOutputStream$PutField;
import java.io.ObjectStreamField;
import java.security.BasicPermission;
import java.security.Permission;
import java.security.PermissionCollection;
import java.util.PropertyPermissionCollection;
import java.util.StringTokenizer;

public final class PropertyPermission
extends BasicPermission {
    private static final long serialVersionUID;
    private transient boolean read;
    private transient boolean write;
    private static final ObjectStreamField[] serialPersistentFields;
    static /* synthetic */ Class class$0;

    static {
        ObjectStreamField[] objectStreamFieldArray = new ObjectStreamField[1];
        Class clazz = class$0;
        if (clazz == null) {
            try {
                clazz = class$0 = Class.forName("java.lang.String");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        objectStreamFieldArray[0] = new ObjectStreamField("actions", clazz);
        serialPersistentFields = objectStreamFieldArray;
    }

    public PropertyPermission(String string, String string2) {
        super(string);
        this.decodeActions(string2);
    }

    private void decodeActions(String string) {
        StringTokenizer stringTokenizer = new StringTokenizer(string.toLowerCase(), " \t\n\r,");
        while (stringTokenizer.hasMoreTokens()) {
            String string2 = stringTokenizer.nextToken();
            if (string2.equals("read")) {
                this.read = true;
                continue;
            }
            if (string2.equals("write")) {
                this.write = true;
                continue;
            }
            throw new IllegalArgumentException();
        }
        if (!this.read && !this.write) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object)) {
            PropertyPermission propertyPermission = (PropertyPermission)object;
            return this.read == propertyPermission.read && this.write == propertyPermission.write;
        }
        return false;
    }

    @Override
    public String getActions() {
        return this.read ? (this.write ? "read,write" : "read") : "write";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean implies(Permission permission) {
        if (super.implies(permission)) {
            PropertyPermission propertyPermission = (PropertyPermission)permission;
            return !(!this.read && propertyPermission.read || !this.write && propertyPermission.write);
        }
        return false;
    }

    @Override
    public PermissionCollection newPermissionCollection() {
        return new PropertyPermissionCollection();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        ObjectOutputStream$PutField objectOutputStream$PutField = objectOutputStream.putFields();
        objectOutputStream$PutField.put("actions", this.getActions());
        objectOutputStream.writeFields();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        ObjectInputStream$GetField objectInputStream$GetField = objectInputStream.readFields();
        String string = (String)objectInputStream$GetField.get("actions", "");
        this.decodeActions(string);
    }
}

