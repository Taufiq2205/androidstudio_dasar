package com.Fiqo.helloworld;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView lsmhs;
    private ArrayAdapter<CharSequence> adapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListViewFragment newInstance(String param1, String param2) {
        ListViewFragment fragment = new ListViewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ListViewFragment() {
        // Required empty public constructor
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
        View view = inflater.inflate(R.layout.fragment_list_view, container, false);

        // Inisialisasi ListView
        lsmhs = view.findViewById(R.id.listview);

        // Inisialisasi adapter dengan daftar mahasiswa dari resources
        adapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.daftar_mhs,  // Array dari res/values/strings.xml
                android.R.layout.simple_spinner_dropdown_item);  // Layout untuk item ListView

        // Set adapter ke ListView
        lsmhs.setAdapter(adapter);

        // Set OnItemClickListener ke ListView
        lsmhs.setOnItemClickListener(this);

        return view;
    }

        @Override
        public void onItemClick (AdapterView < ? > adapterView, View view,int position, long id){
            Toast.makeText(requireContext(), adapter.getItem(position), Toast.LENGTH_SHORT).show();
        }
}