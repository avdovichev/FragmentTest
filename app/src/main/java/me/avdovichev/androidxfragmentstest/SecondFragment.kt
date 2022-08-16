package me.avdovichev.androidxfragmentstest

import android.content.res.Configuration
import androidx.fragment.app.Fragment

class SecondFragment : Fragment(R.layout.second_fragment) {

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        android.util.Log.d(TAG, "SecondFragment.onConfigurationChanged")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        android.util.Log.d(TAG, "SecondFragment.onDestroyView")
    }
}
