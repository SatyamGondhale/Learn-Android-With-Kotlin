package Adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.learn.learnandroidwithkotlin.TabFragmentOne
import com.learn.learnandroidwithkotlin.TabFragmentTwo

class TabLayoutAdapter(private val context:Context, fm:FragmentManager, var totalTabs:Int):FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        when(position){
            0->{
                return TabFragmentOne()
            }
            1->{
                return TabFragmentTwo()
            }
        }
        throw IllegalStateException("position $position is invalid for this viewpager")
    }

    override fun getCount(): Int {
        return totalTabs
    }
}