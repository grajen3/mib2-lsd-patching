/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.ObjectInputStream;
import java.io.ObjectInputStream$GetField;
import java.io.ObjectOutputStream;
import java.io.ObjectOutputStream$PutField;
import java.io.ObjectStreamField;
import java.security.Permission;
import java.security.PermissionCollection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.PropertyPermission;

class PropertyPermissionCollection
extends PermissionCollection {
    private static final long serialVersionUID;
    Hashtable permissions = new Hashtable(30);
    private static final ObjectStreamField[] serialPersistentFields;
    static /* synthetic */ Class class$0;

    static {
        ObjectStreamField[] objectStreamFieldArray = new ObjectStreamField[2];
        Class clazz = class$0;
        if (clazz == null) {
            try {
                clazz = class$0 = Class.forName("java.util.Hashtable");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        objectStreamFieldArray[0] = new ObjectStreamField("permissions", clazz);
        objectStreamFieldArray[1] = new ObjectStreamField("all_allowed", Boolean.TYPE);
        serialPersistentFields = objectStreamFieldArray;
    }

    PropertyPermissionCollection() {
    }

    @Override
    public void add(Permission permission) {
        if (!this.isReadOnly()) {
            Permission permission2 = (Permission)this.permissions.put(permission.getName(), permission);
            if (permission2 != null && !permission2.getActions().equals(permission.getActions())) {
                this.permissions.put(permission.getName(), new PropertyPermission(permission.getName(), "read,write"));
            }
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public Enumeration elements() {
        return this.permissions.elements();
    }

    @Override
    public boolean implies(Permission permission) {
        Enumeration enumeration = this.elements();
        while (enumeration.hasMoreElements()) {
            if (!((Permission)enumeration.nextElement()).implies(permission)) continue;
            return true;
        }
        return permission.getActions().equals("read,write") && this.implies(new PropertyPermission(permission.getName(), "read")) && this.implies(new PropertyPermission(permission.getName(), "write"));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        ObjectOutputStream$PutField objectOutputStream$PutField = objectOutputStream.putFields();
        objectOutputStream$PutField.put("permissions", this.permissions);
        objectOutputStream$PutField.put("all_allowed", false);
        objectOutputStream.writeFields();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        ObjectInputStream$GetField objectInputStream$GetField = objectInputStream.readFields();
        this.permissions = (Hashtable)objectInputStream$GetField.get("permissions", null);
    }
}

