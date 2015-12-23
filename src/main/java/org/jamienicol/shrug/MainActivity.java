package org.jamienicol.shrug;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity
    extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        shrug();

        finish();
    }

    private void shrug() {
        // Copy to clipboard
        final ClipboardManager clipboard =
            (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
        final ClipData clip =
            ClipData.newPlainText(getString(R.string.clipboard_label),
                                  getString(R.string.clipboard_text));
        clipboard.setPrimaryClip(clip);

        // Show a toast to notify the user
        final Toast toast = Toast.makeText(this,
                                           getString(R.string.toast_text),
                                           Toast.LENGTH_SHORT);
        toast.show();
    }
}
