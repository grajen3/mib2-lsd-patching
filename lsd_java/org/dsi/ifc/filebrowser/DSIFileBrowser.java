/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.filebrowser;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.filebrowser.BrowsedFile;
import org.dsi.ifc.filebrowser.BrowsedFileSet;
import org.dsi.ifc.filebrowser.Path;
import org.dsi.ifc.global.ResourceLocator;

public interface DSIFileBrowser
extends DSIBase {
    public static final String VERSION;
    public static final int FILETYPE_UNKNOWNFILE;
    public static final int FILETYPE_FOLDER;
    public static final int FILETYPE_AUDIO;
    public static final int FILETYPE_VIDEO;
    public static final int FILETYPE_IMAGE;
    public static final int FILETYPE_VCARD;
    public static final int FILETYPE_PLAYLIST;
    public static final int SELECTIONTYPE_ALL;
    public static final int SELECTIONTYPE_NONE;
    public static final int SELECTIONTYPE_INVERT;
    public static final int RESULTTYPE_OK;
    public static final int RESULTTYPE_ERROR;
    public static final int RESULTTYPE_ERROR_TOO_MANY_SELECTED_FILES;
    public static final int FILETYPEFILTER_ALLFILES;
    public static final int FILETYPEFILTER_FOLDER;
    public static final int FILETYPEFILTER_AUDIO;
    public static final int FILETYPEFILTER_VIDEO;
    public static final int FILETYPEFILTER_IMAGE;
    public static final int FILETYPEFILTER_VCARD;
    public static final int FILETYPEFILTER_PLAYLIST;
    public static final int RT_START;
    public static final int RT_STOP;
    public static final int RT_GETVIEWWINDOW;
    public static final int RT_GETSELECTEDFILES;
    public static final int RT_SETSELECTIONSINGLE;
    public static final int RT_SETSELECTION;
    public static final int RT_CHANGEFOLDER;
    public static final int RT_SETFILEEXTENSIONFILTER;
    public static final int RT_SETFILETYPEFILTER;
    public static final int RT_SETLANGUAGE;
    public static final int RT_ADDSPELLERCHARS;
    public static final int RT_STARTSPELLER;
    public static final int RT_REMOVESPELLERCHAR;
    public static final int RT_STOPSPELLER;
    public static final int RT_GETRESOURCELOCATORS;
    public static final int RT_GETFILECOUNT;
    public static final int RT_GETRESOURCELOCATORWINDOW;
    public static final int RT_SETFILETYPEACTIVE;
    public static final int RT_GETVIEWWINDOWFROMFILE;
    public static final int RT_GETFILECOUNTWITHFILETYPEFILTER;
    public static final int RT_VALIDATESPELLERCHARS;
    public static final int RT_GETVIEWWINDOWWITHPREVIEWS;
    public static final int RT_DELETEALLPREVIEWFILES;
    public static final int RT_CREATEPREVIEWIMAGE;
    public static final int RT_CANCELPREVIEWCREATION;
    public static final int RP_STARTRESULT;
    public static final int RP_GETVIEWWINDOWRESULT;
    public static final int RP_GETSELECTEDFILESRESULT;
    public static final int RP_CHANGEFOLDERRESULT;
    public static final int RP_SPELLERRESULT;
    public static final int RP_GETRESOURCELOCATORSRESULT;
    public static final int RP_GETFILECOUNTRESULT;
    public static final int RP_SETFILEEXTENSIONFILTERRESULT;
    public static final int RP_SETFILETYPEFILTERRESULT;
    public static final int RP_GETRESOURCELOCATORWINDOWRESULT;
    public static final int RP_SETLANGUAGERESULT;
    public static final int RP_SETFILETYPEACTIVERESULT;
    public static final int RP_GETFILECOUNTWITHFILETYPEFILTERRESULT;
    public static final int RP_VALIDATESPELLERCHARSRESULT;
    public static final int RP_GETVIEWWINDOWWITHPREVIEWSRESULT;
    public static final int RP_CREATEPREVIEWIMAGERESULT;
    public static final int RP_CANCELPREVIEWCREATIONRESULT;
    public static final int IN_INDICATESELECTIONRESULT;

    default public void start(Path path) {
    }

    default public void setFileExtensionFilter(int n, String[] stringArray) {
    }

    default public void setFileTypeFilter(int n, int n2) {
    }

    default public void stop(int n) {
    }

    default public void getViewWindow(int n, int n2, int n3) {
    }

    default public void getViewWindowWithPreviews(int n, int n2, int n3) {
    }

    default public void getViewWindowFromFile(int n, int n2, BrowsedFile browsedFile, int n3) {
    }

    default public void getResourceLocatorWindow(int n, int n2, int n3) {
    }

    default public void getSelectedFiles(int n) {
    }

    default public void getResourceLocators(int n, BrowsedFileSet browsedFileSet) {
    }

    default public void getFileCount(int n) {
    }

    default public void getFileCountWithFileTypeFilter(int n, int n2) {
    }

    default public void setSelectionSingle(int n, BrowsedFile browsedFile, boolean bl) {
    }

    default public void setSelection(int n, int n2) {
    }

    default public void changeFolder(int n, Path path) {
    }

    default public void setLanguage(String string) {
    }

    default public void startSpeller(int n, int n2) {
    }

    default public void addSpellerChars(int n, String string) {
    }

    default public void removeSpellerChar(int n) {
    }

    default public void stopSpeller(int n) {
    }

    default public void setFileTypeActive(boolean bl) {
    }

    default public void validateSpellerChars(int n, String string) {
    }

    default public void deleteAllPreviewFiles() {
    }

    default public void createPreviewImage(ResourceLocator resourceLocator, int n, int n2) {
    }

    default public void cancelPreviewCreation() {
    }
}

