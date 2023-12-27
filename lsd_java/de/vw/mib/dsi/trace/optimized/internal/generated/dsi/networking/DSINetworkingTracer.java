/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.networking;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.networking.ApplicationErrorStruct;
import org.dsi.ifc.networking.CDataProfile;
import org.dsi.ifc.networking.CPacketCounter;
import org.dsi.ifc.networking.ConnectionStateInformationStruct;
import org.dsi.ifc.networking.DataConnectionStateStruct;
import org.dsi.ifc.networking.DiscoveredNetwork;
import org.dsi.ifc.networking.Network;
import org.dsi.ifc.networking.Node;
import org.dsi.ifc.networking.Profile;

public final class DSINetworkingTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_APPLICATIONERRORSTRUCT;
    private static final int ID_CDATAPROFILE;
    private static final int ID_CPACKETCOUNTER;
    private static final int ID_CONNECTIONSTATEINFORMATIONSTRUCT;
    private static final int ID_DATACONNECTIONSTATESTRUCT;
    private static final int ID_DISCOVEREDNETWORK;
    private static final int ID_NETWORK;
    private static final int ID_NODE;
    private static final int ID_PROFILE;
    static /* synthetic */ Class class$org$dsi$ifc$networking$ApplicationErrorStruct;
    static /* synthetic */ Class class$org$dsi$ifc$networking$CDataProfile;
    static /* synthetic */ Class class$org$dsi$ifc$networking$CPacketCounter;
    static /* synthetic */ Class class$org$dsi$ifc$networking$ConnectionStateInformationStruct;
    static /* synthetic */ Class class$org$dsi$ifc$networking$DataConnectionStateStruct;
    static /* synthetic */ Class class$org$dsi$ifc$networking$DiscoveredNetwork;
    static /* synthetic */ Class class$org$dsi$ifc$networking$Network;
    static /* synthetic */ Class class$org$dsi$ifc$networking$Node;
    static /* synthetic */ Class class$org$dsi$ifc$networking$Profile;

    public DSINetworkingTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$networking$ApplicationErrorStruct == null ? (class$org$dsi$ifc$networking$ApplicationErrorStruct = DSINetworkingTracer.class$("org.dsi.ifc.networking.ApplicationErrorStruct")) : class$org$dsi$ifc$networking$ApplicationErrorStruct, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$networking$CDataProfile == null ? (class$org$dsi$ifc$networking$CDataProfile = DSINetworkingTracer.class$("org.dsi.ifc.networking.CDataProfile")) : class$org$dsi$ifc$networking$CDataProfile, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$networking$CPacketCounter == null ? (class$org$dsi$ifc$networking$CPacketCounter = DSINetworkingTracer.class$("org.dsi.ifc.networking.CPacketCounter")) : class$org$dsi$ifc$networking$CPacketCounter, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$networking$ConnectionStateInformationStruct == null ? (class$org$dsi$ifc$networking$ConnectionStateInformationStruct = DSINetworkingTracer.class$("org.dsi.ifc.networking.ConnectionStateInformationStruct")) : class$org$dsi$ifc$networking$ConnectionStateInformationStruct, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$networking$DataConnectionStateStruct == null ? (class$org$dsi$ifc$networking$DataConnectionStateStruct = DSINetworkingTracer.class$("org.dsi.ifc.networking.DataConnectionStateStruct")) : class$org$dsi$ifc$networking$DataConnectionStateStruct, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$networking$DiscoveredNetwork == null ? (class$org$dsi$ifc$networking$DiscoveredNetwork = DSINetworkingTracer.class$("org.dsi.ifc.networking.DiscoveredNetwork")) : class$org$dsi$ifc$networking$DiscoveredNetwork, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$networking$Network == null ? (class$org$dsi$ifc$networking$Network = DSINetworkingTracer.class$("org.dsi.ifc.networking.Network")) : class$org$dsi$ifc$networking$Network, 7);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$networking$Node == null ? (class$org$dsi$ifc$networking$Node = DSINetworkingTracer.class$("org.dsi.ifc.networking.Node")) : class$org$dsi$ifc$networking$Node, 8);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$networking$Profile == null ? (class$org$dsi$ifc$networking$Profile = DSINetworkingTracer.class$("org.dsi.ifc.networking.Profile")) : class$org$dsi$ifc$networking$Profile, 9);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceApplicationErrorStruct(printWriter, (ApplicationErrorStruct)object);
                break;
            }
            case 2: {
                this.traceCDataProfile(printWriter, (CDataProfile)object);
                break;
            }
            case 3: {
                this.traceCPacketCounter(printWriter, (CPacketCounter)object);
                break;
            }
            case 4: {
                this.traceConnectionStateInformationStruct(printWriter, (ConnectionStateInformationStruct)object);
                break;
            }
            case 5: {
                this.traceDataConnectionStateStruct(printWriter, (DataConnectionStateStruct)object);
                break;
            }
            case 6: {
                this.traceDiscoveredNetwork(printWriter, (DiscoveredNetwork)object);
                break;
            }
            case 7: {
                this.traceNetwork(printWriter, (Network)object);
                break;
            }
            case 8: {
                this.traceNode(printWriter, (Node)object);
                break;
            }
            case 9: {
                this.traceProfile(printWriter, (Profile)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceApplicationErrorStruct(PrintWriter printWriter, ApplicationErrorStruct applicationErrorStruct) {
        if (applicationErrorStruct == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(applicationErrorStruct.applicationID);
        printWriter.print(applicationErrorStruct.result);
    }

    private void traceCDataProfile(PrintWriter printWriter, CDataProfile cDataProfile) {
        if (cDataProfile == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(cDataProfile.profileID);
        printWriter.print(cDataProfile.dataProfileName);
        printWriter.print(cDataProfile.dataAPN);
        printWriter.print(cDataProfile.dataUserName);
        printWriter.print(cDataProfile.dataPassword);
        printWriter.print(cDataProfile.dataAuthentication);
        printWriter.print(cDataProfile.provider);
        printWriter.print(cDataProfile.isAPNvisible);
        printWriter.print(cDataProfile.dataAPN2);
        printWriter.print(cDataProfile.dataUserName2);
        printWriter.print(cDataProfile.dataPassword2);
        printWriter.print(cDataProfile.isAPN2visible);
    }

    private void traceCPacketCounter(PrintWriter printWriter, CPacketCounter cPacketCounter) {
        if (cPacketCounter == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(cPacketCounter.connectionDuration);
        printWriter.print(cPacketCounter.rxBytes);
        printWriter.print(cPacketCounter.rxBytesSinceReset);
        printWriter.print(cPacketCounter.txBytes);
        printWriter.print(cPacketCounter.txBytesSinceReset);
        this.trace(printWriter, cPacketCounter.lastResetDate);
    }

    private void traceConnectionStateInformationStruct(PrintWriter printWriter, ConnectionStateInformationStruct connectionStateInformationStruct) {
        if (connectionStateInformationStruct == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(connectionStateInformationStruct.connectionState);
        printWriter.print(connectionStateInformationStruct.applicationID);
    }

    private void traceDataConnectionStateStruct(PrintWriter printWriter, DataConnectionStateStruct dataConnectionStateStruct) {
        if (dataConnectionStateStruct == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(dataConnectionStateStruct.contextState);
        printWriter.print(dataConnectionStateStruct.operationMode);
    }

    private void traceDiscoveredNetwork(PrintWriter printWriter, DiscoveredNetwork discoveredNetwork) {
        if (discoveredNetwork == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(discoveredNetwork.networkName);
        printWriter.print(discoveredNetwork.bssidAddress);
        printWriter.print(discoveredNetwork.signalStrength);
        printWriter.print(discoveredNetwork.encryptionType);
        printWriter.print(discoveredNetwork.wpsAvailable);
    }

    private void traceNetwork(PrintWriter printWriter, Network network) {
        if (network == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(network.macAccessPoint);
        printWriter.print(network.channel);
        printWriter.print(network.sSID);
    }

    private void traceNode(PrintWriter printWriter, Node node) {
        if (node == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(node.macAddress);
    }

    private void traceProfile(PrintWriter printWriter, Profile profile) {
        if (profile == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(profile.identifier);
        printWriter.print(profile.name);
        if (profile.keys == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = profile.keys.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(profile.keys[i2]);
            }
        }
        printWriter.print(profile.keyNumber);
        printWriter.print(profile.sSIDBroadcast);
        printWriter.print(profile.sSID);
        printWriter.print(profile.cryptoModel);
        printWriter.print(profile.authenticationModel);
        printWriter.print(profile.active);
        printWriter.print(profile.channel);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

