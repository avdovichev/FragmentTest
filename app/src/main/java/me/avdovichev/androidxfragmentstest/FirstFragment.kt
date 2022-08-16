package me.avdovichev.androidxfragmentstest

import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class FirstFragment : Fragment(R.layout.first_fragment) {

    private var mTabMediator: TabLayoutMediator? = null
    private var mPager: ViewPager2? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = SectionAdapter(childFragmentManager, lifecycle)
        mPager = view.findViewById<ViewPager2>(R.id.pager).also { pager ->
            pager.adapter = adapter
            val slidingTabs = view.findViewById<TabLayout>(R.id.sliding_tabs)
            mTabMediator = TabLayoutMediator(
                slidingTabs,
                pager
            ) { tab, position ->
                tab.text = "Section $position"
            }.also { tabLayoutMediator ->
                tabLayoutMediator.attach()
            }
        }

        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.first, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when(menuItem.itemId) {
                    R.id.go_next -> {
                        (requireActivity() as MainActivity).goNextFragment()
                        true
                    }
                    else -> false
                }
            }

        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        android.util.Log.d(TAG, "FirstFragment.onViewCreated")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        android.util.Log.d(TAG, "First fragment onConfigurationChanged")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mTabMediator?.detach()
        mTabMediator = null
        mPager?.adapter = null
        mPager = null
        android.util.Log.d(TAG, "First fragment onDestroyView")
    }
}
