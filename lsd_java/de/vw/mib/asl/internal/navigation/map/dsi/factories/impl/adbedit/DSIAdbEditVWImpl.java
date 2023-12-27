/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.adbedit;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.dsi.DSIAdbEditVW;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.DSIAdbEdit;

public class DSIAdbEditVWImpl
implements DSIAdbEditVW {
    private DSIAdbEdit dsiAdbEdit;
    private boolean facadeEnabled;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[DSIAdbEditVWImpl]");

    @Override
    public void changeEntry(AdbEntry adbEntry, int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("changeEntry( AdbEntry entry, int profileIndex )").log();
        }
        if (!this.facadeEnabled) {
            this.logger.warn("The MobilityHorizon facade is currently disabled, the call 'changeEntry( AdbEntry entry, int profileIndex )' will be ignored");
            return;
        }
        this.dsiAdbEdit.changeEntry(adbEntry, n);
    }

    @Override
    public void copyEntry(long l) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("copyEntry( entryId=").append(l).append(" )").log();
        }
        if (!this.facadeEnabled) {
            this.logger.warn("The MobilityHorizon facade is currently disabled, the call 'copyEntry( long entryId )' will be ignored");
            return;
        }
        this.dsiAdbEdit.copyEntry(l);
    }

    @Override
    public void deleteEntries(long[] lArray, int n, int n2) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("deleteEntries( long[] entryIdList, int viewType, int listMode )").log();
        }
        if (!this.facadeEnabled) {
            this.logger.warn("The MobilityHorizon facade is currently disabled, the call 'deleteEntries( long[] entryIdList, int viewType, int listMode )' will be ignored");
            return;
        }
        this.dsiAdbEdit.deleteEntries(lArray, n, n2);
    }

    @Override
    public void deleteSpeedDial(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("deleteSpeedDial( speedDialKey = ").append(n).append(" )").log();
        }
        if (!this.facadeEnabled) {
            this.logger.warn("The MobilityHorizon facade is currently disabled, the call 'deleteSpeedDial( int speedDialKey )' will be ignored");
            return;
        }
        this.dsiAdbEdit.deleteSpeedDial(n);
    }

    public DSIAdbEdit getDsiAdbEdit() {
        return this.dsiAdbEdit;
    }

    @Override
    public void getEntries(long[] lArray, int n, int n2) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("getEntries( long[] entryIdList, int viewType, int listMode )").log();
        }
        if (!this.facadeEnabled) {
            this.logger.warn("The MobilityHorizon facade is currently disabled, the call 'getEntries( long[] entryIdList, int viewType, int listMode )' will be ignored");
            return;
        }
        this.dsiAdbEdit.getEntries(lArray, n, n2);
    }

    @Override
    public void getEntryByReferenceId(String string) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("getEntryByReferenceId( ReferenceId = ").append(string).append(")").log();
        }
        if (!this.facadeEnabled) {
            this.logger.warn("The MobilityHorizon facade is currently disabled, the call 'getEntryByReferenceId( String referenceId )' will be ignored");
            return;
        }
        this.dsiAdbEdit.getEntryByReferenceId(string);
    }

    @Override
    public void getEntryDataSets(long[] lArray, int n, int n2) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("getEntryDataSets( long[] entryIdList, int viewType, int listMode )").log();
        }
        if (!this.facadeEnabled) {
            this.logger.warn("The MobilityHorizon facade is currently disabled, the call 'getEntryDataSets( long[] entryIdList, int viewType, int listMode )' will be ignored");
            return;
        }
        this.dsiAdbEdit.getEntryDataSets(lArray, n, n2);
    }

    @Override
    public void insertEntry(AdbEntry adbEntry, int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("insertEntry( AdbEntry entry, int profileIndex )").log();
        }
        if (!this.facadeEnabled) {
            this.logger.warn("The MobilityHorizon facade is currently disabled, the call 'insertEntry( AdbEntry entry, int profileIndex )' will be ignored");
            return;
        }
        this.dsiAdbEdit.insertEntry(adbEntry, n);
    }

    public boolean isFacadeEnabled() {
        return this.facadeEnabled;
    }

    public void setDsiAdbEdit(DSIAdbEdit dSIAdbEdit) {
        this.dsiAdbEdit = dSIAdbEdit;
    }

    public void setFacadeEnabled(boolean bl) {
        this.facadeEnabled = bl;
    }

    @Override
    public void setSpeedDial(AdbEntry adbEntry) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setSpeedDial( AdbEntry speedDialEntry )").log();
        }
        if (!this.facadeEnabled) {
            this.logger.warn("The MobilityHorizon facade is currently disabled, the call 'setSpeedDial( AdbEntry speedDialEntry )' will be ignored");
            return;
        }
        this.dsiAdbEdit.setSpeedDial(adbEntry);
    }
}

