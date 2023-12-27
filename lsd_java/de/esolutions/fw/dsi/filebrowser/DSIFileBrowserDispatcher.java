/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.filebrowser;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.filebrowser.DSIFileBrowserReply;
import de.esolutions.fw.comm.dsi.filebrowser.impl.DSIFileBrowserReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import org.dsi.ifc.filebrowser.BrowsedFileSet;
import org.dsi.ifc.filebrowser.DSIFileBrowserListener;
import org.dsi.ifc.filebrowser.Path;
import org.dsi.ifc.filebrowser.PreviewInfo;
import org.dsi.ifc.global.ResourceLocator;

public class DSIFileBrowserDispatcher
extends AbstractDispatcher
implements DSIFileBrowserReply {
    private DSIFileBrowserReplyService service = new DSIFileBrowserReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$filebrowser$DSIFileBrowserListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIFileBrowserDispatcher(int n) {
        super(n, (class$org$dsi$ifc$filebrowser$DSIFileBrowserListener == null ? (class$org$dsi$ifc$filebrowser$DSIFileBrowserListener = DSIFileBrowserDispatcher.class$("org.dsi.ifc.filebrowser.DSIFileBrowserListener")) : class$org$dsi$ifc$filebrowser$DSIFileBrowserListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void startResult(int n, int n2, Path path) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIFileBrowserListener dSIFileBrowserListener = (DSIFileBrowserListener)objectArray[i2];
                    dSIFileBrowserListener.startResult(n, n2, path);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setFileExtensionFilterResult(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIFileBrowserListener dSIFileBrowserListener = (DSIFileBrowserListener)objectArray[i2];
                    dSIFileBrowserListener.setFileExtensionFilterResult(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setFileTypeFilterResult(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIFileBrowserListener dSIFileBrowserListener = (DSIFileBrowserListener)objectArray[i2];
                    dSIFileBrowserListener.setFileTypeFilterResult(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getViewWindowResult(int n, int n2, int n3, BrowsedFileSet browsedFileSet, int n4) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIFileBrowserListener dSIFileBrowserListener = (DSIFileBrowserListener)objectArray[i2];
                    dSIFileBrowserListener.getViewWindowResult(n, n2, n3, browsedFileSet, n4);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getViewWindowWithPreviewsResult(int n, int n2, int n3, BrowsedFileSet browsedFileSet, PreviewInfo[] previewInfoArray, int n4) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIFileBrowserListener dSIFileBrowserListener = (DSIFileBrowserListener)objectArray[i2];
                    dSIFileBrowserListener.getViewWindowWithPreviewsResult(n, n2, n3, browsedFileSet, previewInfoArray, n4);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getResourceLocatorWindowResult(int n, int n2, int n3, ResourceLocator[] resourceLocatorArray, int n4) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIFileBrowserListener dSIFileBrowserListener = (DSIFileBrowserListener)objectArray[i2];
                    dSIFileBrowserListener.getResourceLocatorWindowResult(n, n2, n3, resourceLocatorArray, n4);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void indicateSelectionResult(int n, int n2, int n3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIFileBrowserListener dSIFileBrowserListener = (DSIFileBrowserListener)objectArray[i2];
                    dSIFileBrowserListener.indicateSelectionResult(n, n2, n3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void changeFolderResult(int n, int n2, Path path) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIFileBrowserListener dSIFileBrowserListener = (DSIFileBrowserListener)objectArray[i2];
                    dSIFileBrowserListener.changeFolderResult(n, n2, path);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getSelectedFilesResult(int n, int n2, int n3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIFileBrowserListener dSIFileBrowserListener = (DSIFileBrowserListener)objectArray[i2];
                    dSIFileBrowserListener.getSelectedFilesResult(n, n2, n3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getResourceLocatorsResult(int n, int n2, ResourceLocator[] resourceLocatorArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIFileBrowserListener dSIFileBrowserListener = (DSIFileBrowserListener)objectArray[i2];
                    dSIFileBrowserListener.getResourceLocatorsResult(n, n2, resourceLocatorArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getFileCountResult(int n, int n2, int n3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIFileBrowserListener dSIFileBrowserListener = (DSIFileBrowserListener)objectArray[i2];
                    dSIFileBrowserListener.getFileCountResult(n, n2, n3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getFileCountWithFileTypeFilterResult(int n, int n2, int n3, int n4) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIFileBrowserListener dSIFileBrowserListener = (DSIFileBrowserListener)objectArray[i2];
                    dSIFileBrowserListener.getFileCountWithFileTypeFilterResult(n, n2, n3, n4);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void spellerResult(int n, int n2, String string, String string2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIFileBrowserListener dSIFileBrowserListener = (DSIFileBrowserListener)objectArray[i2];
                    dSIFileBrowserListener.spellerResult(n, n2, string, string2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setLanguageResult(int n, String string) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIFileBrowserListener dSIFileBrowserListener = (DSIFileBrowserListener)objectArray[i2];
                    dSIFileBrowserListener.setLanguageResult(n, string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setFileTypeActiveResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIFileBrowserListener dSIFileBrowserListener = (DSIFileBrowserListener)objectArray[i2];
                    dSIFileBrowserListener.setFileTypeActiveResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void validateSpellerCharsResult(int n, int n2, String string, String string2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIFileBrowserListener dSIFileBrowserListener = (DSIFileBrowserListener)objectArray[i2];
                    dSIFileBrowserListener.validateSpellerCharsResult(n, n2, string, string2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void createPreviewImageResult(ResourceLocator resourceLocator, ResourceLocator resourceLocator2, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIFileBrowserListener dSIFileBrowserListener = (DSIFileBrowserListener)objectArray[i2];
                    dSIFileBrowserListener.createPreviewImageResult(resourceLocator, resourceLocator2, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void cancelPreviewCreationResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIFileBrowserListener dSIFileBrowserListener = (DSIFileBrowserListener)objectArray[i2];
                    dSIFileBrowserListener.cancelPreviewCreationResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIFileBrowserListener dSIFileBrowserListener = (DSIFileBrowserListener)objectArray[i2];
                    dSIFileBrowserListener.asyncException(n, string, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void yyIndication(String string, String string2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIFileBrowserListener dSIFileBrowserListener = (DSIFileBrowserListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIFileBrowserDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIFileBrowserDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIFileBrowserListener, new Object[]{string, string2});
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
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

