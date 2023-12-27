/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.controller.contact;

import de.vw.mib.asl.internal.speechphone.controller.contact.LocTypeIndexHandler;
import de.vw.mib.asl.internal.speechphone.controller.contact.SelectedNumberHandler;
import de.vw.mib.asl.internal.speechphone.data.internal.ContactNameModel;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;
import de.vw.mib.asl.internal.speechphone.utils.SpeechPhoneLogger2;

public abstract class AbstractSelectedContactHandler {
    private final SpeechPhoneLogger2 logger;
    private final LocTypeIndexHandler locTypeIndexHandler;
    private final SelectedNumberHandler selectedNumberHandler;
    protected final ServiceFunctions serviceFunctions;
    private static final int LOCTYPE_NOT_SET;
    private static final int LOCTYPE_OTHER;
    private static final int LOCTYPE_NOT_MATCH;
    private static final int LOCTYPE_SINGLE_MATCH;
    private static final int CONTACT_HAS_NO_PHONENUMBER;
    private static final int CONTACT_HAS_ONE_PHONENUMBER;
    private static final int INDEX_NOT_SET;
    private static final int INDEX_NOT_MATCH;
    private static final int INDEX_MATCH;

    public AbstractSelectedContactHandler(ServiceFunctions serviceFunctions, LocTypeIndexHandler locTypeIndexHandler, SelectedNumberHandler selectedNumberHandler) {
        this.serviceFunctions = serviceFunctions;
        this.locTypeIndexHandler = locTypeIndexHandler;
        this.selectedNumberHandler = selectedNumberHandler;
        this.logger = serviceFunctions.createLogger("AbstractSelectedContactHandler");
    }

    protected void handleOneShotResult(ContactNameModel contactNameModel) {
        block0 : switch (contactNameModel.getCountOfNumbers()) {
            case 0: {
                this.handleNoNumber(-1079428352);
                break;
            }
            case 1: {
                this.updateGetters(contactNameModel);
                this.selectedNumberHandler.selectFirstNumber(contactNameModel);
                switch (contactNameModel.getCountOfLocTypes(this.locTypeIndexHandler)) {
                    case -1: {
                        this.notifyModel(contactNameModel, -1431749888);
                        break block0;
                    }
                    case 1: {
                        this.notifyModel(contactNameModel, -1414972672);
                        break block0;
                    }
                    case 0: {
                        this.notifyModel(contactNameModel, -1398195456);
                        break block0;
                    }
                }
                break;
            }
            default: {
                this.updateGetters(contactNameModel);
                switch (contactNameModel.getCountOfLocTypes(this.locTypeIndexHandler)) {
                    case -1: {
                        this.notifyModel(contactNameModel, -1247200512);
                        break block0;
                    }
                    case 0: {
                        this.notifyModel(contactNameModel, -1263977728);
                        break block0;
                    }
                    case 1: {
                        switch (contactNameModel.getIndexMatch(this.locTypeIndexHandler)) {
                            case -1: {
                                this.selectedNumberHandler.selectNumberByLocType_First(contactNameModel, this.locTypeIndexHandler);
                                this.notifyModel(contactNameModel, -1381418240);
                                break block0;
                            }
                            case 0: {
                                this.selectedNumberHandler.selectNumberByLocType_First(contactNameModel, this.locTypeIndexHandler);
                                this.notifyModel(contactNameModel, -1364641024);
                                break block0;
                            }
                        }
                        this.selectedNumberHandler.selectNumberByLocType_Index(contactNameModel, this.locTypeIndexHandler);
                        this.notifyModel(contactNameModel, -1347863808);
                        break block0;
                    }
                }
                switch (contactNameModel.getIndexMatch(this.locTypeIndexHandler)) {
                    case 1: {
                        this.selectedNumberHandler.selectNumberByLocType_Index(contactNameModel, this.locTypeIndexHandler);
                        this.notifyModel(contactNameModel, -1347863808);
                        break block0;
                    }
                }
                this.notifyModel(contactNameModel, -1230423296);
            }
        }
    }

    protected void handleNBestResult(ContactNameModel contactNameModel) {
        block0 : switch (contactNameModel.getCountOfNumbers()) {
            case 0: {
                this.handleNoNumber(-1096205568);
                break;
            }
            case 1: {
                this.updateGetters(contactNameModel);
                this.selectedNumberHandler.selectFirstNumber(contactNameModel);
                switch (contactNameModel.getCountOfLocTypes(this.locTypeIndexHandler)) {
                    case 0: {
                        this.notifyModel(contactNameModel, -1398195456);
                        break block0;
                    }
                }
                this.serviceFunctions.sendHMIEvent(-659997952);
                break;
            }
            default: {
                this.handleContactHasMultipleNumbers(contactNameModel);
            }
        }
    }

    protected void handleContactHasMultipleNumbers(ContactNameModel contactNameModel) {
        this.updateGetters(contactNameModel);
        block0 : switch (contactNameModel.getCountOfLocTypes(this.locTypeIndexHandler)) {
            case -1: {
                this.notifyModel(contactNameModel, -1247200512);
                break;
            }
            case 0: {
                this.notifyModel(contactNameModel, -1263977728);
                break;
            }
            case 1: {
                switch (contactNameModel.getIndexMatch(this.locTypeIndexHandler)) {
                    case 1: {
                        this.selectedNumberHandler.selectNumberByLocType_Index(contactNameModel, this.locTypeIndexHandler);
                        this.triggerPromptDialLocTypeIndex();
                        break block0;
                    }
                }
                this.selectedNumberHandler.selectNumberByLocType_First(contactNameModel, this.locTypeIndexHandler);
                this.triggerPromptDialLocType();
                break;
            }
            default: {
                switch (contactNameModel.getIndexMatch(this.locTypeIndexHandler)) {
                    case 1: {
                        this.selectedNumberHandler.selectNumberByLocType_Index(contactNameModel, this.locTypeIndexHandler);
                        this.triggerPromptDialLocTypeIndex();
                        break block0;
                    }
                }
                this.notifyModel(contactNameModel, -1230423296);
            }
        }
    }

    private void updateGetters(ContactNameModel contactNameModel) {
        this.serviceFunctions.writeIntegerToDatapool(-1834403072, this.locTypeIndexHandler.getIndex());
        this.serviceFunctions.writeIntegerToDatapool(-1767294208, this.locTypeIndexHandler.getLoctype());
        this.serviceFunctions.writeBooleanToDatapool(-1800848640, contactNameModel.getCountOfNumbers() != contactNameModel.getCountOfLocTypes(0));
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("index, loctype and the info if contact has not only other numbers is proposed to the model");
        }
    }

    private void handleNoNumber(int n) {
        this.serviceFunctions.sendHMIEvent(n);
        this.reset();
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("selected contact has no number");
        }
    }

    protected abstract void triggerPromptDialLocType() {
    }

    protected abstract void triggerPromptDialLocTypeIndex() {
    }

    protected abstract void notifyModel(ContactNameModel contactNameModel, int n) {
    }

    public void reset() {
        this.locTypeIndexHandler.reset();
        this.selectedNumberHandler.reset();
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("resetting number to call");
        }
    }

    public LocTypeIndexHandler getLocTypeIndexHandler() {
        return this.locTypeIndexHandler;
    }

    public SelectedNumberHandler getSelectedNumberHandler() {
        return this.selectedNumberHandler;
    }
}

