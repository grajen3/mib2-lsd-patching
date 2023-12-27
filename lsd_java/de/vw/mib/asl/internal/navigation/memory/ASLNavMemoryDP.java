/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.memory;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.organizer.AdbEntry;

public class ASLNavMemoryDP {
    private static final ASLNavMemoryDP INSTANCE = new ASLNavMemoryDP();
    private AdbEntry myMemorySelectedAdbEntry;
    private boolean memoryStatusRequestReceived;
    private String myMemorySelectedAdbEntryName;

    public static ASLNavMemoryDP getInstance() {
        return INSTANCE;
    }

    public AdbEntry getMemorySelectedAdbEntry() {
        return this.myMemorySelectedAdbEntry;
    }

    public boolean isMemoryStatusRequestReceived() {
        return this.memoryStatusRequestReceived;
    }

    public void setMemorySelectedAdbEntry(AdbEntry adbEntry) {
        this.myMemorySelectedAdbEntry = adbEntry;
        this.setMemorySelectedAdbEntryName(adbEntry != null ? adbEntry.getCombinedName() : "");
    }

    public void setMemoryStatusRequestReceived(boolean bl) {
        this.memoryStatusRequestReceived = bl;
    }

    void setCurrentlySelectedAddressName(NavLocation navLocation) {
        if (navLocation != null && this.getMemorySelectedAdbEntry() != null) {
            boolean bl = this.getMemorySelectedAdbEntry().getEntryType() == 4;
            String string = this.getMemorySelectedAdbEntry().getCombinedName();
            if (bl && string != null) {
                ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
                iLocationWrapper.setMmiInternalDataValue(1, string);
            }
        }
    }

    public String getMemorySelectedAdbEntryName() {
        return this.myMemorySelectedAdbEntryName != null ? this.myMemorySelectedAdbEntryName : "";
    }

    public void setMemorySelectedAdbEntryName(String string) {
        this.myMemorySelectedAdbEntryName = string;
    }
}

