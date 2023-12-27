/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.networking;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.networking.DiscoveredNetwork;
import org.dsi.ifc.networking.Node;
import org.dsi.ifc.networking.Profile;

public interface DSIWLANListener
extends DSIListener {
    default public void updateRole(int n, int n2) {
    }

    default public void updateRFActive(int n, int n2) {
    }

    default public void updateNodeList(Node[] nodeArray, int n) {
    }

    default public void updateProfile(Profile profile, int n) {
    }

    default public void updateWlanEnabled(boolean bl, int n) {
    }

    default public void updateStartupState(int n, int n2) {
    }

    default public void updateTrustedNetworks(String[] stringArray, String[] stringArray2, int[] nArray, int n) {
    }

    default public void updateDiscoveredNetwork(DiscoveredNetwork discoveredNetwork, int n) {
    }

    default public void updateConnectedNetwork(String string, String string2, int n, int n2) {
    }

    default public void responseFactoryReset(int n) {
    }

    default public void responseSetRole(int n) {
    }

    default public void responseSetRFActive(int n) {
    }

    default public void responseSetProfile(int n) {
    }

    default public void responseNetworkSearch(int n, int n2) {
    }

    default public void responseAbortSearch(int n) {
    }

    default public void responseConnectNetwork(String string, String string2, int n) {
    }

    default public void responseDisconnectNetwork(String string, String string2, int n) {
    }

    default public void responseDeleteTrustedNetwork(String string, String string2, int n) {
    }

    default public void responseActivateWps(int n) {
    }

    default public void updateWPSRunning(int n, int n2) {
    }

    default public void updateWPSStoppedAndConnecting(String string, String string2, int n) {
    }
}

