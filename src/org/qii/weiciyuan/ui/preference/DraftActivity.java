package org.qii.weiciyuan.ui.preference;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import org.qii.weiciyuan.R;
import org.qii.weiciyuan.ui.Abstract.AbstractAppActivity;

/**
 * User: qii
 * Date: 12-10-22
 */
public class DraftActivity extends AbstractAppActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setTitle(getString(R.string.draft));


        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new DraftFragment())
                .commit();

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case android.R.id.home:
                intent = new Intent(this, SettingActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                return true;
        }
        return false;
    }

}
