/*
 * Decompiled with CFR 0.152.
 */
package javax.microedition.io;

import java.io.DataInput;
import java.io.DataOutput;

public interface Datagram
extends DataInput,
DataOutput {
    default public String getAddress() {
    }

    default public byte[] getData() {
    }

    default public int getLength() {
    }

    default public int getOffset() {
    }

    default public void reset() {
    }

    default public void setAddress(Datagram datagram) {
    }

    default public void setAddress(String string) {
    }

    default public void setData(byte[] byArray, int n, int n2) {
    }

    default public void setLength(int n) {
    }
}

