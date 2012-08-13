package org.qii.weiciyuan.ui.send;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.os.Bundle;

/**
 * User: qii
 * Date: 12-8-13
 * Time: 下午11:26
 */
public class SendProgressFragment extends DialogFragment {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            ProgressDialog dialog = new ProgressDialog(getActivity());
            dialog.setMessage("发送中");
            dialog.setIndeterminate(false);
            dialog.setCancelable(true);
            return dialog;
        }
    }
