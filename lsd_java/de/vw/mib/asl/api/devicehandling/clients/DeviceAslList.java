/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.devicehandling.clients;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.api.devicehandling.clients.AbstractDeviceList;
import de.vw.mib.asl.api.devicehandling.clients.DeviceFilter;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import generated.de.vw.mib.asl.internal.ListManager;

public class DeviceAslList
extends AbstractDeviceList {
    private final GenericASLList genericASLList;

    public DeviceAslList(GenericASLList genericASLList, DeviceFilter deviceFilter) {
        super(deviceFilter);
        this.genericASLList = genericASLList;
        this.updateList(new Device[0], false);
    }

    public DeviceAslList(int n, DeviceFilter deviceFilter) {
        this(ListManager.getGenericASLList(n), deviceFilter);
    }

    public String toString() {
        return new StringBuffer().append(super.toString()).append(" List: ").append(this.genericASLList.getName()).toString();
    }

    @Override
    protected void updateList(Device[] deviceArray, boolean bl) {
        this.genericASLList.updateList(deviceArray);
    }
}

