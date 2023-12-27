/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.browser;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.browser.Bookmark;
import org.dsi.ifc.browser.HistoryEntry;
import org.dsi.ifc.browser.ImportReport;
import org.dsi.ifc.browser.KeyboardInfo;
import org.dsi.ifc.browser.Medium;
import org.dsi.ifc.browser.PathInfo;
import org.dsi.ifc.browser.SearchHit;
import org.dsi.ifc.browser.SelectionEntry;
import org.dsi.ifc.browser.TimePeriod;

public final class DSIBrowserTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_BOOKMARK;
    private static final int ID_HISTORYENTRY;
    private static final int ID_IMPORTREPORT;
    private static final int ID_KEYBOARDINFO;
    private static final int ID_MEDIUM;
    private static final int ID_PATHINFO;
    private static final int ID_SEARCHHIT;
    private static final int ID_SELECTIONENTRY;
    private static final int ID_TIMEPERIOD;
    static /* synthetic */ Class class$org$dsi$ifc$browser$Bookmark;
    static /* synthetic */ Class class$org$dsi$ifc$browser$HistoryEntry;
    static /* synthetic */ Class class$org$dsi$ifc$browser$ImportReport;
    static /* synthetic */ Class class$org$dsi$ifc$browser$KeyboardInfo;
    static /* synthetic */ Class class$org$dsi$ifc$browser$Medium;
    static /* synthetic */ Class class$org$dsi$ifc$browser$PathInfo;
    static /* synthetic */ Class class$org$dsi$ifc$browser$SearchHit;
    static /* synthetic */ Class class$org$dsi$ifc$browser$SelectionEntry;
    static /* synthetic */ Class class$org$dsi$ifc$browser$TimePeriod;

    public DSIBrowserTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$browser$Bookmark == null ? (class$org$dsi$ifc$browser$Bookmark = DSIBrowserTracer.class$("org.dsi.ifc.browser.Bookmark")) : class$org$dsi$ifc$browser$Bookmark, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$browser$HistoryEntry == null ? (class$org$dsi$ifc$browser$HistoryEntry = DSIBrowserTracer.class$("org.dsi.ifc.browser.HistoryEntry")) : class$org$dsi$ifc$browser$HistoryEntry, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$browser$ImportReport == null ? (class$org$dsi$ifc$browser$ImportReport = DSIBrowserTracer.class$("org.dsi.ifc.browser.ImportReport")) : class$org$dsi$ifc$browser$ImportReport, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$browser$KeyboardInfo == null ? (class$org$dsi$ifc$browser$KeyboardInfo = DSIBrowserTracer.class$("org.dsi.ifc.browser.KeyboardInfo")) : class$org$dsi$ifc$browser$KeyboardInfo, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$browser$Medium == null ? (class$org$dsi$ifc$browser$Medium = DSIBrowserTracer.class$("org.dsi.ifc.browser.Medium")) : class$org$dsi$ifc$browser$Medium, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$browser$PathInfo == null ? (class$org$dsi$ifc$browser$PathInfo = DSIBrowserTracer.class$("org.dsi.ifc.browser.PathInfo")) : class$org$dsi$ifc$browser$PathInfo, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$browser$SearchHit == null ? (class$org$dsi$ifc$browser$SearchHit = DSIBrowserTracer.class$("org.dsi.ifc.browser.SearchHit")) : class$org$dsi$ifc$browser$SearchHit, 7);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$browser$SelectionEntry == null ? (class$org$dsi$ifc$browser$SelectionEntry = DSIBrowserTracer.class$("org.dsi.ifc.browser.SelectionEntry")) : class$org$dsi$ifc$browser$SelectionEntry, 8);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$browser$TimePeriod == null ? (class$org$dsi$ifc$browser$TimePeriod = DSIBrowserTracer.class$("org.dsi.ifc.browser.TimePeriod")) : class$org$dsi$ifc$browser$TimePeriod, 9);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceBookmark(printWriter, (Bookmark)object);
                break;
            }
            case 2: {
                this.traceHistoryEntry(printWriter, (HistoryEntry)object);
                break;
            }
            case 3: {
                this.traceImportReport(printWriter, (ImportReport)object);
                break;
            }
            case 4: {
                this.traceKeyboardInfo(printWriter, (KeyboardInfo)object);
                break;
            }
            case 5: {
                this.traceMedium(printWriter, (Medium)object);
                break;
            }
            case 6: {
                this.tracePathInfo(printWriter, (PathInfo)object);
                break;
            }
            case 7: {
                this.traceSearchHit(printWriter, (SearchHit)object);
                break;
            }
            case 8: {
                this.traceSelectionEntry(printWriter, (SelectionEntry)object);
                break;
            }
            case 9: {
                this.traceTimePeriod(printWriter, (TimePeriod)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceBookmark(PrintWriter printWriter, Bookmark bookmark) {
        if (bookmark == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(bookmark.bookmarkType);
        printWriter.print(bookmark.folder);
        printWriter.print(bookmark.title);
        printWriter.print(bookmark.url);
        printWriter.print(bookmark.nonerasable);
    }

    private void traceHistoryEntry(PrintWriter printWriter, HistoryEntry historyEntry) {
        if (historyEntry == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, historyEntry.time);
        printWriter.print(historyEntry.url);
    }

    private void traceImportReport(PrintWriter printWriter, ImportReport importReport) {
        if (importReport == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(importReport.inserted);
        printWriter.print(importReport.skippedOther);
        printWriter.print(importReport.skippedBecauseTooLong);
        printWriter.print(importReport.skippedBecauseNonEraseable);
        printWriter.print(importReport.convError);
        printWriter.print(importReport.parseError);
        printWriter.print(importReport.overQuota);
        printWriter.print(importReport.success);
    }

    private void traceKeyboardInfo(PrintWriter printWriter, KeyboardInfo keyboardInfo) {
        if (keyboardInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(keyboardInfo.type);
        printWriter.print(keyboardInfo.title);
        printWriter.print(keyboardInfo.initialText);
        printWriter.print(keyboardInfo.sensitive);
    }

    private void traceMedium(PrintWriter printWriter, Medium medium) {
        if (medium == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(medium.id);
        printWriter.print(medium.mediumType);
        printWriter.print(medium.name);
        printWriter.print(medium.updateMedium);
        printWriter.print(medium.mediumState);
    }

    private void tracePathInfo(PrintWriter printWriter, PathInfo pathInfo) {
        if (pathInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(pathInfo.format);
        printWriter.print(pathInfo.path);
    }

    private void traceSearchHit(PrintWriter printWriter, SearchHit searchHit) {
        if (searchHit == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(searchHit.title);
        printWriter.print(searchHit.snippet);
        printWriter.print(searchHit.file);
    }

    private void traceSelectionEntry(PrintWriter printWriter, SelectionEntry selectionEntry) {
        if (selectionEntry == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(selectionEntry.entryIdentifier);
        printWriter.print(selectionEntry.text);
        printWriter.print(selectionEntry.value);
        printWriter.print(selectionEntry.selected);
    }

    private void traceTimePeriod(PrintWriter printWriter, TimePeriod timePeriod) {
        if (timePeriod == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, timePeriod.from);
        this.trace(printWriter, timePeriod.to);
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

