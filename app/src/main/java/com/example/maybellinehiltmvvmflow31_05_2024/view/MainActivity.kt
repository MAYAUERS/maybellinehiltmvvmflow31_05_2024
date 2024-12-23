package com.example.maybellinehiltmvvmflow31_05_2024.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.maybellinehiltmvvmflow31_05_2024.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myblineFragment : Fragment = MyblineFragment()
        val fragment : Fragment? = supportFragmentManager.findFragmentByTag(MyblineFragment::class.java.simpleName)

        if (fragment !is MyblineFragment){
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container,
                    myblineFragment,MyblineFragment::class.java.simpleName)
                .commit()
        }
    }

  /*  lateinit var myblineItemAdapter: MyblineItemAdapter
     val myblineViewModel : MyblineViewModel by viewModels()

   // private val myblineViewModel by viewModels<MyblineViewModel>()

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)

        myblineViewModel.getMybline()

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
            myblineViewModel.myblineStateFlow.collect { it ->
                when (it) {
                    is ApiState.Loading -> {
                        recyclerView.visibility = View.GONE

                    }

                    is ApiState.Failure -> {
                        recyclerView.visibility = View.GONE
                        Log.d("main", "onCreate: ${it.msg}")
                    }

                    is ApiState.Success -> {
                        recyclerView.visibility = View.VISIBLE

                        myblineItemAdapter = MyblineItemAdapter(it.data as ArrayList<MyblineData>)
                        recyclerView.adapter = myblineItemAdapter
                        myblineItemAdapter.notifyDataSetChanged()
                    }

                    is ApiState.Empty -> {

                    }
                }
            }
            }
        }

    }*/
}