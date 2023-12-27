/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

public interface Externalizable
extends Serializable {
    default public void readExternal(ObjectInput objectInput) {
    }

    default public void writeExternal(ObjectOutput objectOutput) {
    }
}

