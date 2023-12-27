/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.filebrowser;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.filebrowser.sessions.Session;

final class ModelSessions {
    private static final Session INVALID_FILEBROWSER_SESSION = null;
    private final Session[] MODEL_FILEBROWSER_SESSIONS = new Session[]{INVALID_FILEBROWSER_SESSION, INVALID_FILEBROWSER_SESSION, INVALID_FILEBROWSER_SESSION, INVALID_FILEBROWSER_SESSION, INVALID_FILEBROWSER_SESSION, INVALID_FILEBROWSER_SESSION, INVALID_FILEBROWSER_SESSION, INVALID_FILEBROWSER_SESSION, INVALID_FILEBROWSER_SESSION};
    private int currentFilebrowserContext = -1;
    static final String[][] CONTENT_FILTERS = new String[][]{new String[0], {"jpg", "jpeg", "png", "bmp", "gif"}, {"jpg", "jpeg"}, {"vcard", "vcf"}, {"wav", "mp3"}, {"gpx"}};
    private static final int INVALID_FILEBROWSER_CONTEXT;

    ModelSessions() {
    }

    void setSessionForCurrentModelContext(Session session) {
        if (this.currentFilebrowserContext != -1) {
            this.MODEL_FILEBROWSER_SESSIONS[this.currentFilebrowserContext] = session;
            if (this.isRadioPresetSession(session)) {
                ServiceManager.aslPropertyManager.valueChangedBoolean(3479, true);
            }
        }
    }

    boolean isValid() {
        return this.currentFilebrowserContext != -1 && this.MODEL_FILEBROWSER_SESSIONS[this.currentFilebrowserContext] != INVALID_FILEBROWSER_SESSION;
    }

    static String[] getImageExtensionFilter() {
        return CONTENT_FILTERS[1];
    }

    String[] getExtensionFilter() {
        String[] stringArray;
        switch (this.currentFilebrowserContext) {
            case 0: {
                stringArray = CONTENT_FILTERS[0];
                break;
            }
            case 1: {
                stringArray = CONTENT_FILTERS[4];
                break;
            }
            case 2: 
            case 3: {
                stringArray = CONTENT_FILTERS[1];
                break;
            }
            case 4: {
                stringArray = CONTENT_FILTERS[0];
                break;
            }
            case 5: {
                stringArray = CONTENT_FILTERS[0];
                break;
            }
            case 6: {
                stringArray = CONTENT_FILTERS[2];
                break;
            }
            case 7: {
                stringArray = CONTENT_FILTERS[3];
                break;
            }
            case 8: {
                stringArray = CONTENT_FILTERS[5];
                break;
            }
            default: {
                stringArray = CONTENT_FILTERS[0];
            }
        }
        return stringArray;
    }

    Session getSessionByContextFilter(int n) {
        if (0 <= n && n < this.MODEL_FILEBROWSER_SESSIONS.length) {
            return this.MODEL_FILEBROWSER_SESSIONS[n];
        }
        return INVALID_FILEBROWSER_SESSION;
    }

    int invalidateModelFilebrowserSession(Session session) {
        for (int i2 = this.MODEL_FILEBROWSER_SESSIONS.length - 1; i2 >= 0; --i2) {
            if (this.MODEL_FILEBROWSER_SESSIONS[i2] != session) continue;
            this.MODEL_FILEBROWSER_SESSIONS[i2] = INVALID_FILEBROWSER_SESSION;
            if (i2 == 2) {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(477);
                ServiceManager.aslPropertyManager.valueChangedBoolean(3479, false);
            }
            return i2;
        }
        return -1;
    }

    boolean isRadioPresetSession(Session session) {
        for (int i2 = this.MODEL_FILEBROWSER_SESSIONS.length - 1; i2 >= 0; --i2) {
            if (this.MODEL_FILEBROWSER_SESSIONS[i2] != session || i2 != 2) continue;
            return true;
        }
        return false;
    }

    Session getCurrentModelFilebrowserSession() {
        if (this.currentFilebrowserContext != -1) {
            return this.MODEL_FILEBROWSER_SESSIONS[this.currentFilebrowserContext];
        }
        return INVALID_FILEBROWSER_SESSION;
    }

    void resetCurrentModelFilebrowserSession() {
        if (this.currentFilebrowserContext != -1) {
            this.MODEL_FILEBROWSER_SESSIONS[this.currentFilebrowserContext] = INVALID_FILEBROWSER_SESSION;
        }
    }

    void setCurrentModelContext(int n) {
        this.currentFilebrowserContext = n;
    }

    int getCurrentModelContext() {
        return this.currentFilebrowserContext;
    }
}

