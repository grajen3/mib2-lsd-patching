/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.uota.lists;

import de.vw.mib.asl.internal.online.common.uota.OnlineUotAPackage;

public interface PacketList {
    default public OnlineUotAPackage[] getPacketList() {
    }

    default public OnlineUotAPackage getPacketWithIndex(int n) {
    }

    default public int getPacketListSize() {
    }

    default public boolean checkIfPacketInList(OnlineUotAPackage onlineUotAPackage) {
    }

    default public void updatePacketList(OnlineUotAPackage[] onlineUotAPackageArray) {
    }

    default public void updatePacketState(int n, int n2) {
    }

    default public void addPacket(OnlineUotAPackage onlineUotAPackage) {
    }

    default public boolean removePacket(OnlineUotAPackage onlineUotAPackage) {
    }

    default public void clearPacketList() {
    }
}

