package code.name.monkey.retromusic.ui.fragments.base;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.kabouzeid.appthemehelper.ThemeStore;
import com.kabouzeid.appthemehelper.util.ColorUtil;

import code.name.monkey.retromusic.R;
import code.name.monkey.retromusic.ui.activities.MainActivity;

/**
 * @author Karim Abou Zeid (kabouzeid)
 */
public abstract class AbsMainActivityFragment extends AbsMusicServiceFragment {

    public MainActivity getMainActivity() {
        return (MainActivity) getActivity();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    // WORKAROUND
    public void setStatusbarColor(View view, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            final View statusBar = view.findViewById(R.id.status_bar);
            if (statusBar != null) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getMainActivity().setLightStatusbarAuto(color);
                    statusBar.setBackgroundColor(ColorUtil.darkenColor(color));
                } else {
                    statusBar.setBackgroundColor(color);
                }
            }
        }
    }

    public void setStatusbarColorAuto(View view) {
        // we don't want to use statusbar color because we are doing the color darkening on our own to support KitKat
        setStatusbarColor(view, ThemeStore.primaryColor(getContext()));
    }
}
