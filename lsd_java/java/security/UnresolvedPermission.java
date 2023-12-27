/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.UnresolvedPermissionCollection;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Hashtable;

public final class UnresolvedPermission
extends Permission
implements Serializable {
    private static final long serialVersionUID;
    private transient Certificate[] certificates;
    private String type;
    private String actions;
    private String name;
    static Class[] constructorArgs;
    static /* synthetic */ Class class$0;

    static {
        Class clazz = class$0;
        if (clazz == null) {
            try {
                clazz = class$0 = Class.forName("java.lang.String");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        Class clazz2 = clazz;
        constructorArgs = new Class[]{clazz2, clazz2};
    }

    public UnresolvedPermission(String string, String string2, String string3, Certificate[] certificateArray) {
        super(string);
        this.name = string2;
        this.certificates = certificateArray;
        this.type = string;
        this.actions = string3;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof UnresolvedPermission)) {
            return false;
        }
        UnresolvedPermission unresolvedPermission = (UnresolvedPermission)object;
        if (!(this.type.equals(unresolvedPermission.type) && this.name.equals(unresolvedPermission.name) && this.actions.equals(unresolvedPermission.actions))) {
            return false;
        }
        if (this.certificates == null && unresolvedPermission.certificates == null) {
            return true;
        }
        if (this.certificates.length != unresolvedPermission.certificates.length) {
            return false;
        }
        Hashtable hashtable = new Hashtable();
        int n = 0;
        while (n < this.certificates.length) {
            hashtable.put(this.certificates[n], this.certificates[n]);
            ++n;
        }
        n = 0;
        while (n < unresolvedPermission.certificates.length) {
            if (hashtable.get(unresolvedPermission.certificates[n]) == null) {
                return false;
            }
            ++n;
        }
        return true;
    }

    @Override
    public boolean implies(Permission permission) {
        return false;
    }

    @Override
    public PermissionCollection newPermissionCollection() {
        return new UnresolvedPermissionCollection();
    }

    @Override
    public String getActions() {
        return "";
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public String toString() {
        return new StringBuffer("(unresolved ").append(this.type).append(" ").append(this.name).append(" ").append(this.actions).append(")").toString();
    }

    Permission resolve(ClassLoader classLoader) {
        try {
            Object object;
            Class clazz = Class.forName(this.type, true, classLoader);
            boolean bl = true;
            Hashtable hashtable = null;
            if (clazz.getSigners() != null) {
                object = (Certificate[])clazz.getSigners();
                hashtable = new Hashtable(((Certificate[])object).length * 3 / 2);
                int n = 0;
                while (n < ((Certificate[])object).length) {
                    if (object[n] != null) {
                        hashtable.put(object[n], object[n]);
                    }
                    ++n;
                }
                if (hashtable.size() == 0) {
                    hashtable = null;
                }
            }
            if (this.certificates != null) {
                if (hashtable == null) {
                    int n = 0;
                    while (n < this.certificates.length) {
                        if (this.certificates[n] != null) {
                            bl = false;
                            break;
                        }
                        ++n;
                    }
                } else {
                    int n = 0;
                    while (n < this.certificates.length) {
                        if (this.certificates[n] != null && !hashtable.containsKey(this.certificates[n])) {
                            bl = false;
                            break;
                        }
                        ++n;
                    }
                }
            }
            if (bl) {
                object = clazz.getConstructor(constructorArgs);
                return (Permission)((Constructor)object).newInstance(new Object[]{this.name, this.actions});
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
        }
        catch (NoSuchMethodException noSuchMethodException) {
        }
        catch (InstantiationException instantiationException) {
        }
        catch (InvocationTargetException invocationTargetException) {
        }
        catch (IllegalAccessException illegalAccessException) {}
        return null;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        int n = 0;
        if (this.certificates != null) {
            n = this.certificates.length;
        }
        objectOutputStream.writeInt(n);
        int n2 = 0;
        while (n2 < n) {
            objectOutputStream.writeUTF(this.certificates[n2].getType());
            try {
                byte[] byArray = this.certificates[n2].getEncoded();
                objectOutputStream.writeInt(byArray.length);
                objectOutputStream.write(byArray);
            }
            catch (CertificateEncodingException certificateEncodingException) {
                objectOutputStream.writeInt(0);
            }
            ++n2;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int n = objectInputStream.readInt();
        if (n > 0) {
            this.certificates = new Certificate[n];
            int n2 = 0;
            while (n2 < n) {
                String string = objectInputStream.readUTF();
                int n3 = objectInputStream.readInt();
                if (n3 > 0) {
                    byte[] byArray = new byte[n3];
                    objectInputStream.readFully(byArray);
                    try {
                        CertificateFactory certificateFactory = CertificateFactory.getInstance(string);
                        this.certificates[n2] = certificateFactory.generateCertificate(new ByteArrayInputStream(byArray));
                    }
                    catch (CertificateException certificateException) {}
                }
                ++n2;
            }
        }
    }
}

