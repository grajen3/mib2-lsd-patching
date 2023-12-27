/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.tts;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.tts.DSITTSReply;
import de.esolutions.fw.comm.dsi.tts.impl.DSITTSReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.tts.DSITTSListener;
import org.dsi.ifc.tts.LanguageVoiceInfo;

public class DSITTSDispatcher
extends AbstractDispatcher
implements DSITTSReply {
    private DSITTSReplyService service = new DSITTSReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$tts$DSITTSListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSITTSDispatcher(int n) {
        super(n, (class$org$dsi$ifc$tts$DSITTSListener == null ? (class$org$dsi$ifc$tts$DSITTSListener = DSITTSDispatcher.class$("org.dsi.ifc.tts.DSITTSListener")) : class$org$dsi$ifc$tts$DSITTSListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateLanguage(String string, int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSITTSListener dSITTSListener = (DSITTSListener)iterator.next();
                    this.confirmNotificationListener(2, dSITTSListener);
                    dSITTSListener.updateLanguage(string, n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSITTSListener dSITTSListener = (DSITTSListener)iterator.next();
                    dSITTSListener.updateLanguage(string, n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAvailableLanguages(LanguageVoiceInfo[] languageVoiceInfoArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSITTSListener dSITTSListener = (DSITTSListener)iterator.next();
                    this.confirmNotificationListener(7, dSITTSListener);
                    dSITTSListener.updateAvailableLanguages(languageVoiceInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSITTSListener dSITTSListener = (DSITTSListener)iterator.next();
                    dSITTSListener.updateAvailableLanguages(languageVoiceInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMarkerPassed(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSITTSListener dSITTSListener = (DSITTSListener)iterator.next();
                    this.confirmNotificationListener(10, dSITTSListener);
                    dSITTSListener.updateMarkerPassed(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSITTSListener dSITTSListener = (DSITTSListener)iterator.next();
                    dSITTSListener.updateMarkerPassed(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetLanguage(short s, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITTSListener dSITTSListener = (DSITTSListener)objectArray[i2];
                    dSITTSListener.responseSetLanguage(s, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseInit(short s, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITTSListener dSITTSListener = (DSITTSListener)objectArray[i2];
                    dSITTSListener.responseInit(s, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseAudioTrigger(short s, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITTSListener dSITTSListener = (DSITTSListener)objectArray[i2];
                    dSITTSListener.responseAudioTrigger(s, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAudioRequest(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSITTSListener dSITTSListener = (DSITTSListener)iterator.next();
                    this.confirmNotificationListener(9, dSITTSListener);
                    dSITTSListener.updateAudioRequest(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSITTSListener dSITTSListener = (DSITTSListener)iterator.next();
                    dSITTSListener.updateAudioRequest(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responsePlayTone(short s, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITTSListener dSITTSListener = (DSITTSListener)objectArray[i2];
                    dSITTSListener.responsePlayTone(s, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSpeakPrompt(short s, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITTSListener dSITTSListener = (DSITTSListener)objectArray[i2];
                    dSITTSListener.responseSpeakPrompt(s, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSkipSpeaking(short s, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITTSListener dSITTSListener = (DSITTSListener)objectArray[i2];
                    dSITTSListener.responseSkipSpeaking(s, n);
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
                    DSITTSListener dSITTSListener = (DSITTSListener)objectArray[i2];
                    dSITTSListener.asyncException(n, string, n2);
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
                    DSITTSListener dSITTSListener = (DSITTSListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSITTSDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSITTSDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSITTSListener, new Object[]{string, string2});
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

