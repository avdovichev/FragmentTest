package me.avdovichev.androidxfragmentstest

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle)
: FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun createFragment(position: Int): Fragment {
        return SectionFragment.newInstance(position)
    }

    override fun getItemCount(): Int {
        return 3
    }
}
