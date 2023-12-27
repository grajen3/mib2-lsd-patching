/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.speechrec;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.speechrec.DSISpeechRecReply;
import de.esolutions.fw.comm.dsi.speechrec.impl.DSISpeechRecReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.speechrec.DSISpeechRecListener;
import org.dsi.ifc.speechrec.GrammarInfo;
import org.dsi.ifc.speechrec.GrammarStateInfo;
import org.dsi.ifc.speechrec.NBestList;
import org.dsi.ifc.speechrec.VDECapabilities;

public class DSISpeechRecDispatcher
extends AbstractDispatcher
implements DSISpeechRecReply {
    private DSISpeechRecReplyService service = new DSISpeechRecReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$speechrec$DSISpeechRecListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSISpeechRecDispatcher(int n) {
        super(n, (class$org$dsi$ifc$speechrec$DSISpeechRecListener == null ? (class$org$dsi$ifc$speechrec$DSISpeechRecListener = DSISpeechRecDispatcher.class$("org.dsi.ifc.speechrec.DSISpeechRecListener")) : class$org$dsi$ifc$speechrec$DSISpeechRecListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void responseAbort(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseAbort(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseDeleteProfile(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseDeleteProfile(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseDeleteVoiceTag(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseDeleteVoiceTag(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseEnableContinuousUpdate(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseEnableContinuousUpdate(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseGetVersion(String string) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseGetVersion(string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseInit(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseInit(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseInitVoiceTag(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseInitVoiceTag(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseLoadGrammar(int n, GrammarInfo[] grammarInfoArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseLoadGrammar(n, grammarInfoArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseLoadProfile(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseLoadProfile(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responsePreloadGrammar(int n, GrammarInfo[] grammarInfoArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responsePreloadGrammar(n, grammarInfoArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseRecordVoiceTag(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseRecordVoiceTag(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetLanguage(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseSetLanguage(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseShutdown(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseShutdown(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseStartRecognition(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseStartRecognition(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseUnloadGrammar(int n, GrammarInfo[] grammarInfoArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseUnloadGrammar(n, grammarInfoArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseUnloadProfile(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseUnloadProfile(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseUnpreloadGrammar(int n, GrammarInfo[] grammarInfoArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseUnpreloadGrammar(n, grammarInfoArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseWaitForResults(int n, NBestList nBestList) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseWaitForResults(n, nBestList);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAborted(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    this.confirmNotificationListener(3, dSISpeechRecListener);
                    dSISpeechRecListener.updateAborted(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    dSISpeechRecListener.updateAborted(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAvailableLanguages(String[] stringArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    this.confirmNotificationListener(2, dSISpeechRecListener);
                    dSISpeechRecListener.updateAvailableLanguages(stringArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    dSISpeechRecListener.updateAvailableLanguages(stringArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAvailableProfiles(int[] nArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    this.confirmNotificationListener(19, dSISpeechRecListener);
                    dSISpeechRecListener.updateAvailableProfiles(nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    dSISpeechRecListener.updateAvailableProfiles(nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateFailure(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    this.confirmNotificationListener(4, dSISpeechRecListener);
                    dSISpeechRecListener.updateFailure(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    dSISpeechRecListener.updateFailure(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateLanguage(String string, int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    this.confirmNotificationListener(1, dSISpeechRecListener);
                    dSISpeechRecListener.updateLanguage(string, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    dSISpeechRecListener.updateLanguage(string, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRecognizerState(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    this.confirmNotificationListener(5, dSISpeechRecListener);
                    dSISpeechRecListener.updateRecognizerState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    dSISpeechRecListener.updateRecognizerState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAbsoluteConfidenceThreshold(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    this.confirmNotificationListener(6, dSISpeechRecListener);
                    dSISpeechRecListener.updateAbsoluteConfidenceThreshold(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    dSISpeechRecListener.updateAbsoluteConfidenceThreshold(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetMaxCommandNBestListSize(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseSetMaxCommandNBestListSize(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMaxCommandNBestListSize(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    this.confirmNotificationListener(8, dSISpeechRecListener);
                    dSISpeechRecListener.updateMaxCommandNBestListSize(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    dSISpeechRecListener.updateMaxCommandNBestListSize(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetMaxSlotNBestListSize(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseSetMaxSlotNBestListSize(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMaxSlotNBestListSize(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    this.confirmNotificationListener(9, dSISpeechRecListener);
                    dSISpeechRecListener.updateMaxSlotNBestListSize(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    dSISpeechRecListener.updateMaxSlotNBestListSize(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetConfidenceRejectThreshold(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseSetConfidenceRejectThreshold(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateConfidenceRejectThreshold(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    this.confirmNotificationListener(10, dSISpeechRecListener);
                    dSISpeechRecListener.updateConfidenceRejectThreshold(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    dSISpeechRecListener.updateConfidenceRejectThreshold(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetUtteranceStartTimeout(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseSetUtteranceStartTimeout(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateUtteranceStartTimeout(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    this.confirmNotificationListener(11, dSISpeechRecListener);
                    dSISpeechRecListener.updateUtteranceStartTimeout(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    dSISpeechRecListener.updateUtteranceStartTimeout(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetRecognitionTimeout(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseSetRecognitionTimeout(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRecognitionTimeout(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    this.confirmNotificationListener(12, dSISpeechRecListener);
                    dSISpeechRecListener.updateRecognitionTimeout(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    dSISpeechRecListener.updateRecognitionTimeout(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetUnambiguousResultThreshold(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseSetUnambiguousResultThreshold(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateUnambiguousResultThreshold(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    this.confirmNotificationListener(13, dSISpeechRecListener);
                    dSISpeechRecListener.updateUnambiguousResultThreshold(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    dSISpeechRecListener.updateUnambiguousResultThreshold(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetUnambiguousResultRange(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseSetUnambiguousResultRange(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateUnambiguousResultRange(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    this.confirmNotificationListener(14, dSISpeechRecListener);
                    dSISpeechRecListener.updateUnambiguousResultRange(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    dSISpeechRecListener.updateUnambiguousResultRange(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetFirstLevelSize(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseSetFirstLevelSize(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateFirstLevelSize(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    this.confirmNotificationListener(15, dSISpeechRecListener);
                    dSISpeechRecListener.updateFirstLevelSize(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    dSISpeechRecListener.updateFirstLevelSize(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseStartPostTraining(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseStartPostTraining(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseStopPostTraining(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseStopPostTraining(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseRequestSDSAvailability(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseRequestSDSAvailability(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSDSAvailability(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    this.confirmNotificationListener(16, dSISpeechRecListener);
                    dSISpeechRecListener.updateSDSAvailability(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    dSISpeechRecListener.updateSDSAvailability(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetSpellingMode(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseSetSpellingMode(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseDeleteLastSpellingBlock(int n, NBestList nBestList) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseDeleteLastSpellingBlock(n, nBestList);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseStartDialogue(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseStartDialogue(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseStopDialogue(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseStopDialogue(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateGrammarStatus(int n, boolean bl, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    this.confirmNotificationListener(20, dSISpeechRecListener);
                    dSISpeechRecListener.updateGrammarStatus(n, bl, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    dSISpeechRecListener.updateGrammarStatus(n, bl, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateGrammarState(GrammarStateInfo grammarStateInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    this.confirmNotificationListener(21, dSISpeechRecListener);
                    dSISpeechRecListener.updateGrammarState(grammarStateInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    dSISpeechRecListener.updateGrammarState(grammarStateInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTemporaryG2PLanguageChangeActive(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    this.confirmNotificationListener(18, dSISpeechRecListener);
                    dSISpeechRecListener.updateTemporaryG2PLanguageChangeActive(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    dSISpeechRecListener.updateTemporaryG2PLanguageChangeActive(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseCheckDbPartition(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseCheckDbPartition(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseRequestGraphemicGroupAsNBestList(int n, NBestList nBestList) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseRequestGraphemicGroupAsNBestList(n, nBestList);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseRequestVDECapabilities(int n, VDECapabilities vDECapabilities) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseRequestVDECapabilities(n, vDECapabilities);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseRestoreFactorySettings(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseRestoreFactorySettings(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetDictionary(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseSetDictionary(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateNBestList(NBestList nBestList, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    this.confirmNotificationListener(22, dSISpeechRecListener);
                    dSISpeechRecListener.updateNBestList(nBestList, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    dSISpeechRecListener.updateNBestList(nBestList, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetASRParameterConfiguration(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseSetASRParameterConfiguration(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateASRParameterConfiguration(int[] nArray, int[] nArray2, int[] nArray3, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(23);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    this.confirmNotificationListener(23, dSISpeechRecListener);
                    dSISpeechRecListener.updateASRParameterConfiguration(nArray, nArray2, nArray3, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(23);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    dSISpeechRecListener.updateASRParameterConfiguration(nArray, nArray2, nArray3, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseDeleteLastFlexVDEPart(int n, NBestList nBestList) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseDeleteLastFlexVDEPart(n, nBestList);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseClearFlexVDEHistory(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.responseClearFlexVDEHistory(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateVDEMediumState(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    this.confirmNotificationListener(24, dSISpeechRecListener);
                    dSISpeechRecListener.updateVDEMediumState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    dSISpeechRecListener.updateVDEMediumState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAvailableSLMLanguages(String[] stringArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(25);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    this.confirmNotificationListener(25, dSISpeechRecListener);
                    dSISpeechRecListener.updateAvailableSLMLanguages(stringArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(25);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    dSISpeechRecListener.updateAvailableSLMLanguages(stringArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateOnlineCapabilities(String[] stringArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(26);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    this.confirmNotificationListener(26, dSISpeechRecListener);
                    dSISpeechRecListener.updateOnlineCapabilities(stringArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(26);
            while (iterator.hasNext()) {
                try {
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)iterator.next();
                    dSISpeechRecListener.updateOnlineCapabilities(stringArray, n);
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
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    dSISpeechRecListener.asyncException(n, string, n2);
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
                    DSISpeechRecListener dSISpeechRecListener = (DSISpeechRecListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSISpeechRecDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSISpeechRecDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSISpeechRecListener, new Object[]{string, string2});
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

