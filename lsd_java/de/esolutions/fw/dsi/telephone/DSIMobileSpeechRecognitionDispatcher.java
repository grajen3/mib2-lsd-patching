/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.telephone;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.telephone.DSIMobileSpeechRecognitionReply;
import de.esolutions.fw.comm.dsi.telephone.impl.DSIMobileSpeechRecognitionReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.telephone.DSIMobileSpeechRecognitionListener;

public class DSIMobileSpeechRecognitionDispatcher
extends AbstractDispatcher
implements DSIMobileSpeechRecognitionReply {
    private DSIMobileSpeechRecognitionReplyService service = new DSIMobileSpeechRecognitionReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$telephone$DSIMobileSpeechRecognitionListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIMobileSpeechRecognitionDispatcher(int n) {
        super(n, (class$org$dsi$ifc$telephone$DSIMobileSpeechRecognitionListener == null ? (class$org$dsi$ifc$telephone$DSIMobileSpeechRecognitionListener = DSIMobileSpeechRecognitionDispatcher.class$("org.dsi.ifc.telephone.DSIMobileSpeechRecognitionListener")) : class$org$dsi$ifc$telephone$DSIMobileSpeechRecognitionListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateSpeechRecognitionAvailable(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIMobileSpeechRecognitionListener dSIMobileSpeechRecognitionListener = (DSIMobileSpeechRecognitionListener)iterator.next();
                    this.confirmNotificationListener(1, dSIMobileSpeechRecognitionListener);
                    dSIMobileSpeechRecognitionListener.updateSpeechRecognitionAvailable(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIMobileSpeechRecognitionListener dSIMobileSpeechRecognitionListener = (DSIMobileSpeechRecognitionListener)iterator.next();
                    dSIMobileSpeechRecognitionListener.updateSpeechRecognitionAvailable(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSpeechRecognitionActive(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIMobileSpeechRecognitionListener dSIMobileSpeechRecognitionListener = (DSIMobileSpeechRecognitionListener)iterator.next();
                    this.confirmNotificationListener(2, dSIMobileSpeechRecognitionListener);
                    dSIMobileSpeechRecognitionListener.updateSpeechRecognitionActive(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIMobileSpeechRecognitionListener dSIMobileSpeechRecognitionListener = (DSIMobileSpeechRecognitionListener)iterator.next();
                    dSIMobileSpeechRecognitionListener.updateSpeechRecognitionActive(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSpeechRecognitionType(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIMobileSpeechRecognitionListener dSIMobileSpeechRecognitionListener = (DSIMobileSpeechRecognitionListener)iterator.next();
                    this.confirmNotificationListener(3, dSIMobileSpeechRecognitionListener);
                    dSIMobileSpeechRecognitionListener.updateSpeechRecognitionType(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIMobileSpeechRecognitionListener dSIMobileSpeechRecognitionListener = (DSIMobileSpeechRecognitionListener)iterator.next();
                    dSIMobileSpeechRecognitionListener.updateSpeechRecognitionType(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseStartSpeechRecognition(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMobileSpeechRecognitionListener dSIMobileSpeechRecognitionListener = (DSIMobileSpeechRecognitionListener)objectArray[i2];
                    dSIMobileSpeechRecognitionListener.responseStartSpeechRecognition(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseStopSpeechRecognition(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMobileSpeechRecognitionListener dSIMobileSpeechRecognitionListener = (DSIMobileSpeechRecognitionListener)objectArray[i2];
                    dSIMobileSpeechRecognitionListener.responseStopSpeechRecognition(n);
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
                    DSIMobileSpeechRecognitionListener dSIMobileSpeechRecognitionListener = (DSIMobileSpeechRecognitionListener)objectArray[i2];
                    dSIMobileSpeechRecognitionListener.asyncException(n, string, n2);
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
                    DSIMobileSpeechRecognitionListener dSIMobileSpeechRecognitionListener = (DSIMobileSpeechRecognitionListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIMobileSpeechRecognitionDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIMobileSpeechRecognitionDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIMobileSpeechRecognitionListener, new Object[]{string, string2});
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

