/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.kombifastlist;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.kombifastlist.ArrayHeader;
import org.dsi.ifc.kombifastlist.DataAddress;
import org.dsi.ifc.kombifastlist.DataCombinedNumbers;
import org.dsi.ifc.kombifastlist.DataCommonList;
import org.dsi.ifc.kombifastlist.DataFavoriteList;
import org.dsi.ifc.kombifastlist.DataInitials;
import org.dsi.ifc.kombifastlist.DataMediaBrowser;
import org.dsi.ifc.kombifastlist.DataPhonebook;
import org.dsi.ifc.kombifastlist.DataReceptionList;

public final class DSIKombifastlistTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_ARRAYHEADER;
    private static final int ID_DATAADDRESS;
    private static final int ID_DATACOMBINEDNUMBERS;
    private static final int ID_DATACOMMONLIST;
    private static final int ID_DATAFAVORITELIST;
    private static final int ID_DATAINITIALS;
    private static final int ID_DATAMEDIABROWSER;
    private static final int ID_DATAPHONEBOOK;
    private static final int ID_DATARECEPTIONLIST;
    static /* synthetic */ Class class$org$dsi$ifc$kombifastlist$ArrayHeader;
    static /* synthetic */ Class class$org$dsi$ifc$kombifastlist$DataAddress;
    static /* synthetic */ Class class$org$dsi$ifc$kombifastlist$DataCombinedNumbers;
    static /* synthetic */ Class class$org$dsi$ifc$kombifastlist$DataCommonList;
    static /* synthetic */ Class class$org$dsi$ifc$kombifastlist$DataFavoriteList;
    static /* synthetic */ Class class$org$dsi$ifc$kombifastlist$DataInitials;
    static /* synthetic */ Class class$org$dsi$ifc$kombifastlist$DataMediaBrowser;
    static /* synthetic */ Class class$org$dsi$ifc$kombifastlist$DataPhonebook;
    static /* synthetic */ Class class$org$dsi$ifc$kombifastlist$DataReceptionList;

    public DSIKombifastlistTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$kombifastlist$ArrayHeader == null ? (class$org$dsi$ifc$kombifastlist$ArrayHeader = DSIKombifastlistTracer.class$("org.dsi.ifc.kombifastlist.ArrayHeader")) : class$org$dsi$ifc$kombifastlist$ArrayHeader, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$kombifastlist$DataAddress == null ? (class$org$dsi$ifc$kombifastlist$DataAddress = DSIKombifastlistTracer.class$("org.dsi.ifc.kombifastlist.DataAddress")) : class$org$dsi$ifc$kombifastlist$DataAddress, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$kombifastlist$DataCombinedNumbers == null ? (class$org$dsi$ifc$kombifastlist$DataCombinedNumbers = DSIKombifastlistTracer.class$("org.dsi.ifc.kombifastlist.DataCombinedNumbers")) : class$org$dsi$ifc$kombifastlist$DataCombinedNumbers, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$kombifastlist$DataCommonList == null ? (class$org$dsi$ifc$kombifastlist$DataCommonList = DSIKombifastlistTracer.class$("org.dsi.ifc.kombifastlist.DataCommonList")) : class$org$dsi$ifc$kombifastlist$DataCommonList, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$kombifastlist$DataFavoriteList == null ? (class$org$dsi$ifc$kombifastlist$DataFavoriteList = DSIKombifastlistTracer.class$("org.dsi.ifc.kombifastlist.DataFavoriteList")) : class$org$dsi$ifc$kombifastlist$DataFavoriteList, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$kombifastlist$DataInitials == null ? (class$org$dsi$ifc$kombifastlist$DataInitials = DSIKombifastlistTracer.class$("org.dsi.ifc.kombifastlist.DataInitials")) : class$org$dsi$ifc$kombifastlist$DataInitials, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$kombifastlist$DataMediaBrowser == null ? (class$org$dsi$ifc$kombifastlist$DataMediaBrowser = DSIKombifastlistTracer.class$("org.dsi.ifc.kombifastlist.DataMediaBrowser")) : class$org$dsi$ifc$kombifastlist$DataMediaBrowser, 7);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$kombifastlist$DataPhonebook == null ? (class$org$dsi$ifc$kombifastlist$DataPhonebook = DSIKombifastlistTracer.class$("org.dsi.ifc.kombifastlist.DataPhonebook")) : class$org$dsi$ifc$kombifastlist$DataPhonebook, 8);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$kombifastlist$DataReceptionList == null ? (class$org$dsi$ifc$kombifastlist$DataReceptionList = DSIKombifastlistTracer.class$("org.dsi.ifc.kombifastlist.DataReceptionList")) : class$org$dsi$ifc$kombifastlist$DataReceptionList, 9);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceArrayHeader(printWriter, (ArrayHeader)object);
                break;
            }
            case 2: {
                this.traceDataAddress(printWriter, (DataAddress)object);
                break;
            }
            case 3: {
                this.traceDataCombinedNumbers(printWriter, (DataCombinedNumbers)object);
                break;
            }
            case 4: {
                this.traceDataCommonList(printWriter, (DataCommonList)object);
                break;
            }
            case 5: {
                this.traceDataFavoriteList(printWriter, (DataFavoriteList)object);
                break;
            }
            case 6: {
                this.traceDataInitials(printWriter, (DataInitials)object);
                break;
            }
            case 7: {
                this.traceDataMediaBrowser(printWriter, (DataMediaBrowser)object);
                break;
            }
            case 8: {
                this.traceDataPhonebook(printWriter, (DataPhonebook)object);
                break;
            }
            case 9: {
                this.traceDataReceptionList(printWriter, (DataReceptionList)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceArrayHeader(PrintWriter printWriter, ArrayHeader arrayHeader) {
        if (arrayHeader == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(arrayHeader.mode);
        printWriter.print(arrayHeader.recordAddress);
        printWriter.print(arrayHeader.start);
        printWriter.print(arrayHeader.relativeJump);
        printWriter.print(arrayHeader.elements);
        printWriter.print(arrayHeader.absoluteListPos);
        printWriter.print(arrayHeader.jobModification);
        printWriter.print(arrayHeader.jobID);
        printWriter.print(arrayHeader.jobPriority);
    }

    private void traceDataAddress(PrintWriter printWriter, DataAddress dataAddress) {
        if (dataAddress == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(dataAddress.pos);
        printWriter.print(dataAddress.lastName);
        printWriter.print(dataAddress.firstName);
        printWriter.print(dataAddress.street);
        printWriter.print(dataAddress.city);
        printWriter.print(dataAddress.region);
        printWriter.print(dataAddress.postalCode);
        printWriter.print(dataAddress.country);
        printWriter.print(dataAddress.coordinates);
        printWriter.print(dataAddress.poiDescription);
        printWriter.print(dataAddress.poiType);
        printWriter.print(dataAddress.addressType);
    }

    private void traceDataCombinedNumbers(PrintWriter printWriter, DataCombinedNumbers dataCombinedNumbers) {
        if (dataCombinedNumbers == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(dataCombinedNumbers.pos);
        printWriter.print(dataCombinedNumbers.pbName);
        printWriter.print(dataCombinedNumbers.numberType);
        printWriter.print(dataCombinedNumbers.callMode);
        printWriter.print(dataCombinedNumbers.telNumber);
        printWriter.print(dataCombinedNumbers.day);
        printWriter.print(dataCombinedNumbers.month);
        printWriter.print(dataCombinedNumbers.year);
        printWriter.print(dataCombinedNumbers.hour);
        printWriter.print(dataCombinedNumbers.minute);
        printWriter.print(dataCombinedNumbers.second);
    }

    private void traceDataCommonList(PrintWriter printWriter, DataCommonList dataCommonList) {
        if (dataCommonList == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(dataCommonList.pos);
        printWriter.print(dataCommonList.sourceType);
        printWriter.print(dataCommonList.attributes);
        printWriter.print(dataCommonList.presetID);
        printWriter.print(dataCommonList.category);
        printWriter.print(dataCommonList.name);
        printWriter.print(dataCommonList.frequency);
    }

    private void traceDataFavoriteList(PrintWriter printWriter, DataFavoriteList dataFavoriteList) {
        if (dataFavoriteList == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(dataFavoriteList.pos);
        printWriter.print(dataFavoriteList.pbName);
        printWriter.print(dataFavoriteList.numberType);
        printWriter.print(dataFavoriteList.telNumber);
    }

    private void traceDataInitials(PrintWriter printWriter, DataInitials dataInitials) {
        if (dataInitials == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(dataInitials.initial);
        printWriter.print(dataInitials.occuranceCounter);
    }

    private void traceDataMediaBrowser(PrintWriter printWriter, DataMediaBrowser dataMediaBrowser) {
        if (dataMediaBrowser == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(dataMediaBrowser.pos);
        printWriter.print(dataMediaBrowser.fileType);
        printWriter.print(dataMediaBrowser.fileState);
        printWriter.print(dataMediaBrowser.fileName);
    }

    private void traceDataPhonebook(PrintWriter printWriter, DataPhonebook dataPhonebook) {
        if (dataPhonebook == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(dataPhonebook.pos);
        printWriter.print(dataPhonebook.pbName);
        printWriter.print(dataPhonebook.storagePb);
        printWriter.print(dataPhonebook.anyVoiceTag);
        printWriter.print(dataPhonebook.telNumberQuantity);
        printWriter.print(dataPhonebook.telNumber01);
        printWriter.print(dataPhonebook.telNumber02);
        printWriter.print(dataPhonebook.telNumber03);
        printWriter.print(dataPhonebook.telNumber04);
        printWriter.print(dataPhonebook.telNumber05);
        printWriter.print(dataPhonebook.telNumber06);
        printWriter.print(dataPhonebook.telNumber07);
        printWriter.print(dataPhonebook.telNumber08);
        printWriter.print(dataPhonebook.telNumber09);
        printWriter.print(dataPhonebook.telNumber10);
        printWriter.print(dataPhonebook.voiceTag01);
        printWriter.print(dataPhonebook.voiceTag02);
        printWriter.print(dataPhonebook.voiceTag03);
        printWriter.print(dataPhonebook.voiceTag04);
        printWriter.print(dataPhonebook.voiceTag05);
        printWriter.print(dataPhonebook.voiceTag06);
        printWriter.print(dataPhonebook.voiceTag07);
        printWriter.print(dataPhonebook.voiceTag08);
        printWriter.print(dataPhonebook.voiceTag09);
        printWriter.print(dataPhonebook.voiceTag10);
        printWriter.print(dataPhonebook.reserve01);
        printWriter.print(dataPhonebook.reserve02);
        printWriter.print(dataPhonebook.reserve03);
        printWriter.print(dataPhonebook.reserve04);
        printWriter.print(dataPhonebook.reserve05);
        printWriter.print(dataPhonebook.reserve06);
        printWriter.print(dataPhonebook.reserve07);
        printWriter.print(dataPhonebook.reserve08);
        printWriter.print(dataPhonebook.reserve09);
        printWriter.print(dataPhonebook.reserve10);
        printWriter.print(dataPhonebook.numberType01);
        printWriter.print(dataPhonebook.numberType02);
        printWriter.print(dataPhonebook.numberType03);
        printWriter.print(dataPhonebook.numberType04);
        printWriter.print(dataPhonebook.numberType05);
        printWriter.print(dataPhonebook.numberType06);
        printWriter.print(dataPhonebook.numberType07);
        printWriter.print(dataPhonebook.numberType08);
        printWriter.print(dataPhonebook.numberType09);
        printWriter.print(dataPhonebook.numberType10);
        printWriter.print(dataPhonebook.adressIndication);
    }

    private void traceDataReceptionList(PrintWriter printWriter, DataReceptionList dataReceptionList) {
        if (dataReceptionList == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(dataReceptionList.pos);
        printWriter.print(dataReceptionList.elementType);
        printWriter.print(dataReceptionList.type);
        printWriter.print(dataReceptionList.attributes);
        printWriter.print(dataReceptionList.presetID);
        printWriter.print(dataReceptionList.fmREGCode);
        printWriter.print(dataReceptionList.category);
        printWriter.print(dataReceptionList.nameReceptionList);
        printWriter.print(dataReceptionList.frequency);
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

