package me.avdovichev.androidxfragmentstest

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class SectionFragment : Fragment(R.layout.section_fragment) {

    private var number: Int = -1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        number = requireArguments().getInt(KEY_NUMBER)
        val textView = view.findViewById<TextView>(R.id.label)
        textView.text = getString(R.string.section_title, number)
        android.util.Log.d(TAG, "SectionFragment.onViewCreated ($number)")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        android.util.Log.d(TAG, "SectionFragment.onConfigurationChanged ($number), isAdded: ${isAdded}")
        // It is expected that onConfigurationChanged is invoked for alive fragment only
        android.util.Log.d(TAG, "${requireView().id}")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        android.util.Log.d(TAG, "SectionFragment.onDestroyView ($number)")
    }

    companion object {
        const val KEY_NUMBER = "number"
        fun newInstance(number: Int): SectionFragment {
            val args = Bundle()
            args.putInt(KEY_NUMBER, number)
            val fragment = SectionFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
