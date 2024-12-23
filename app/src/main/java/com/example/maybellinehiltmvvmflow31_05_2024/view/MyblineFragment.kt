package com.example.maybellinehiltmvvmflow31_05_2024.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.maybellinehiltmvvmflow31_05_2024.R
import com.example.maybellinehiltmvvmflow31_05_2024.model.MyblineData
import com.example.maybellinehiltmvvmflow31_05_2024.utils.ApiState
import com.example.maybellinehiltmvvmflow31_05_2024.viewmodel.MyblineViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.util.ArrayList

@AndroidEntryPoint
class MyblineFragment : Fragment() {

    lateinit var myblineItemAdapter: MyblineItemAdapter
    private lateinit var userRecyclerView: RecyclerView
    private val myblineViewModel:MyblineViewModel by viewModels()
    @SuppressLint("UnsafeRepeatOnLifecycleDetector")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userRecyclerView = view.findViewById(R.id.recyclerView_list)
        userRecyclerView.layoutManager = LinearLayoutManager(context)


        myblineViewModel.getMybline()
        lifecycleScope.launch {

            repeatOnLifecycle(Lifecycle.State.STARTED) {
                myblineViewModel.myblineStateFlow.collect {
                    Log.d("Data", "myblineViewModel:=  ${it}")
                    when (it) {
                        is ApiState.Loading -> {
                            userRecyclerView.isVisible = false
                        }

                        is ApiState.Failure -> {
                            userRecyclerView.isVisible = false
                            Log.d("Error", "onCreate: ${it.msg}")
                        }

                        is ApiState.Success -> {
                          //  textView_name.text = it.data.toString()
                            userRecyclerView.isVisible = true
                            myblineItemAdapter = MyblineItemAdapter(it.data as ArrayList<MyblineData>)
                            userRecyclerView.adapter = myblineItemAdapter
                        }

                        is ApiState.Empty ->{
                            Log.d("Error in Empty", "onCreate: ${it.toString()}")
                        }

                    }
                }
            }

        }
/*    myblineViewModel.getMyblineData()
        myblineViewModel.mybline.observe(viewLifecycleOwner, Observer {
            if (it!= null){
            myblineItemAdapter = MyblineItemAdapter(it as ArrayList<MyblineData>)
            userRecyclerView.adapter = myblineItemAdapter
            }
        })*/

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mybline, container, false)
    }


}