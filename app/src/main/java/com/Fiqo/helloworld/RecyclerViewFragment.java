package com.Fiqo.helloworld;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecyclerViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecyclerViewFragment extends Fragment {

    //inisialisasi variabel
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecyclerViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecyclerViewFragment newInstance(String param1, String param2) {
        RecyclerViewFragment fragment = new RecyclerViewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        // Inisialisasi RecyclerView
        recyclerView = view.findViewById(R.id.recycler);

        // Mengatur agar ukuran RecyclerView tetap tetap
        recyclerView.setHasFixedSize(true);

        // Menggunakan LinearLayoutManager untuk RecyclerView(mengatur tata letak)
        layoutManager = new LinearLayoutManager(requireContext());
        recyclerView.setLayoutManager(layoutManager);

        // Mendapatkan data dari resources
        String[] daftarmhs = getResources().getStringArray(R.array.daftar_mhs);
        String[] alamat = getResources().getStringArray(R.array.Alamat);
        String[] email = getResources().getStringArray(R.array.email);
        int[] image = {
                R.mipmap.man,
                R.mipmap.man,
                R.mipmap.man,
                R.mipmap.man,
                R.mipmap.man,
                R.mipmap.man,
                R.mipmap.man,
                R.mipmap.man,
                R.mipmap.man,
                R.mipmap.man,
                R.mipmap.man,
                R.mipmap.man,
                R.mipmap.man,
                R.mipmap.man,
                R.mipmap.man,
                R.mipmap.man
        };

        // Inisialisasi adapter dan set ke RecyclerView
        adapter = new MyAdapter(daftarmhs, alamat, email, image);
        recyclerView.setAdapter(adapter);

        return view;
    }
}