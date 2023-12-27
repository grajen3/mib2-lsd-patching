/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.selection;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.selection.NetworkProviderListCollector;
import de.vw.mib.asl.internal.phone.util.TripleMobileEquipment;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.telephoneng.DSIMobileEquipmentListener;
import org.dsi.ifc.telephoneng.NetworkProvider;

public class TargetASLPhoneSelection
extends TripleMobileEquipment {
    private boolean isNetworkSearchRunning = false;
    int selectedNetworkIndex = -1;
    private boolean alreadyRegistered = false;
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener;

    public TargetASLPhoneSelection(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return 5256;
    }

    @Override
    protected void powerOn() {
        if (!this.alreadyRegistered) {
            this.addObserver(-603783104);
            this.addObserver(-587005888);
            this.addObserver(-564390592);
            this.addObserver(-620560320);
        }
        this.alreadyRegistered = true;
    }

    @Override
    public void handleEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 1073742811: {
                this.selectedNetworkIndex = eventGeneric.getInt(0);
                NetworkProviderListCollector networkProviderListCollector = (NetworkProviderListCollector)ListManager.getGenericASLList(1197).getRowItem(this.selectedNetworkIndex);
                networkProviderListCollector.isLoading = true;
                this.getPrimary().requestNetworkRegistration(networkProviderListCollector.networkProvider.telNumProviderName, 0);
                break;
            }
            case 1073742812: {
                if (!eventGeneric.getBoolean(0)) break;
                if (this.isNetworkSearchRunning) {
                    this.getPrimary().requestAbortNetworkSearch();
                }
                this.selectedNetworkIndex = -1;
                this.getPrimary().requestNetworkRegistration("", 1);
                break;
            }
            case 1073742813: {
                ListManager.getGenericASLList(1197).updateList(new NetworkProviderListCollector[0]);
                TargetASLPhoneSelection.writeIntegerToDatapool(1195, 1);
                if (this.isNetworkSearchRunning) break;
                this.getPrimary().requestNetworkSearch();
                this.isNetworkSearchRunning = true;
                break;
            }
            case 1075141854: {
                this.getPrimary().requestAbortNetworkSearch();
                break;
            }
        }
    }

    public void dsiMobileEquipmentResponseNetworkSearch(NetworkProvider[] networkProviderArray, int n) {
        this.isNetworkSearchRunning = false;
        TargetASLPhoneSelection.writeIntegerToDatapool(1195, 0);
        this.sendHMIEvent(175);
        Object[] objectArray = new NetworkProviderListCollector[networkProviderArray.length];
        for (int i2 = 0; i2 < networkProviderArray.length; ++i2) {
            objectArray[i2] = new NetworkProviderListCollector();
            ((NetworkProviderListCollector)objectArray[i2]).networkProvider = networkProviderArray[i2];
        }
        ListManager.getGenericASLList(1197).updateList(objectArray);
    }

    public void dsiMobileEquipmentResponseNetworkRegistration(int n) {
        Object[] objectArray = (NetworkProviderListCollector[])ListManager.getGenericASLList(1197).getDSIObjects();
        if (n == 0) {
            this.sendHMIEvent(173);
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                if (objectArray[i2].networkProvider.getTelProviderState() == 1) {
                    ((NetworkProviderListCollector)objectArray[i2]).networkProvider.telProviderState = 3;
                }
                if (!((NetworkProviderListCollector)objectArray[i2]).isLoading) continue;
                ((NetworkProviderListCollector)objectArray[i2]).isLoading = false;
                ((NetworkProviderListCollector)objectArray[i2]).networkProvider.telProviderState = 1;
            }
        } else {
            for (int i3 = 0; i3 < objectArray.length; ++i3) {
                if (objectArray[i3].networkProvider.getTelProviderState() == 1) {
                    ((NetworkProviderListCollector)objectArray[i3]).networkProvider.telProviderState = 3;
                }
                if (!((NetworkProviderListCollector)objectArray[i3]).isLoading) continue;
                ((NetworkProviderListCollector)objectArray[i3]).isLoading = false;
            }
            if (n == 12) {
                this.sendHMIEvent(521);
            } else {
                this.sendHMIEvent(174);
            }
        }
        ListManager.getGenericASLList(1197).updateList(objectArray);
    }

    public void dsiMobileEquipmentAsyncException(int n, String string, int n2) {
        if (n2 == 1008) {
            this.error("Network registration took too long and timed out, therefore RESULT_ERROR_NO_NW_REPLY was sent internally!");
            this.dsiMobileEquipmentResponseNetworkRegistration(12);
        }
    }

    @Override
    protected DSIMobileEquipmentListener createPrimaryListener() {
        return (DSIMobileEquipmentListener)DSIProxyFactory.getDSIProxyAPI().getDSIProxy().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener == null ? (class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener = TargetASLPhoneSelection.class$("org.dsi.ifc.telephoneng.DSIMobileEquipmentListener")) : class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener);
    }

    @Override
    protected int[] getMobileEquipmentNotification() {
        return ASLPhoneData.EMPTY_NOTIFICATION;
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

