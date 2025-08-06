package org.woxtube.woxtube.fragments.list.kiosk;

import android.os.Bundle;

import org.woxtube.woxtube.error.ErrorInfo;
import org.woxtube.woxtube.error.UserAction;
import org.woxtube.woxtube.extractor.WoxTube;
import org.woxtube.woxtube.extractor.exceptions.ExtractionException;
import org.woxtube.woxtube.extractor.kiosk.KioskList;
import org.woxtube.woxtube.util.KioskTranslator;
import org.woxtube.woxtube.util.ServiceHelper;

public class DefaultKioskFragment extends KioskFragment {

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (serviceId < 0) {
            updateSelectedDefaultKiosk();
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        if (serviceId != ServiceHelper.getSelectedServiceId(requireContext())) {
            if (currentWorker != null) {
                currentWorker.dispose();
            }
            updateSelectedDefaultKiosk();
            reloadContent();
        }
    }

    private void updateSelectedDefaultKiosk() {
        try {
            serviceId = ServiceHelper.getSelectedServiceId(requireContext());

            final KioskList kioskList = WoxTube.getService(serviceId).getKioskList();
            kioskId = kioskList.getDefaultKioskId();
            url = kioskList.getListLinkHandlerFactoryByType(kioskId).fromId(kioskId).getUrl();

            kioskTranslatedName = KioskTranslator.getTranslatedKioskName(kioskId, requireContext());
            name = kioskTranslatedName;

            currentInfo = null;
            currentNextPage = null;
        } catch (final ExtractionException e) {
            showError(new ErrorInfo(e, UserAction.REQUESTED_KIOSK,
                    "Loading default kiosk for selected service"));
        }
    }
}
