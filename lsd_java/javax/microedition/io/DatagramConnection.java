/*
 * Decompiled with CFR 0.152.
 */
package javax.microedition.io;

import javax.microedition.io.Connection;
import javax.microedition.io.Datagram;

public interface DatagramConnection
extends Connection {
    default public int getMaximumLength() {
    }

    default public int getNominalLength() {
    }

    default public Datagram newDatagram(byte[] byArray, int n) {
    }

    default public Datagram newDatagram(byte[] byArray, int n, String string) {
    }

    default public Datagram newDatagram(int n) {
    }

    default public Datagram newDatagram(int n, String string) {
    }

    default public void receive(Datagram datagram) {
    }

    default public void send(Datagram datagram) {
    }
}

