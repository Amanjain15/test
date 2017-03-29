package data.com.myapplication.sub_category.view;

import android.app.SearchManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import data.com.myapplication.Home.Home;
import data.com.myapplication.R;
import data.com.myapplication.SharedPrefs;
import data.com.myapplication.sub_category.model.RetrofitSubCategoryDetailsProvider;
import data.com.myapplication.sub_category.model.data.SubCategoryData;
import data.com.myapplication.sub_category.model.data.SubCategoryDetails;
import data.com.myapplication.sub_category.presenter.ProductsListPresenter;
import data.com.myapplication.sub_category.presenter.SubCategoryPresenter;
import data.com.myapplication.sub_category.presenter.SubCategoryPresenterImpl;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SubCategoryFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SubCategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SubCategoryFragment extends Fragment implements SubCategoryView{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ViewPager viewPager;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private  ProgressBar progressBar;
    private OnFragmentInteractionListener mListener;
    private CoordinatorLayout coordinatorLayout;
    private LinearLayout layout_not_available;
    private SearchView searchView;
    private ProductsListPresenter productsListPresenter;
    private String querry="aman";
    private SharedPrefs sharedPrefs;
    private ViewPagerAdapter viewPagerAdapter;
    private SubCategoryPresenter subCategoryPresenter;
    private List<String> list = new ArrayList<>();
    private SubCategoryData subCategoryDataLocal;
    List<String> titleList = new ArrayList<>();


    public SubCategoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SubCategoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SubCategoryFragment newInstance(String param1, String param2) {
        SubCategoryFragment fragment = new SubCategoryFragment();
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
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_sub_category, container, false);
        viewPager= (ViewPager)view.findViewById(R.id.viewPager);
        toolbar = (Toolbar)view.findViewById(R.id.toolbar);
        Log.d("sub","1");
        tabLayout=(TabLayout)view.findViewById(R.id.tabLayout);
        progressBar=(ProgressBar)view.findViewById(R.id.progressBar);
        coordinatorLayout=(CoordinatorLayout)view.findViewById(R.id.coordinate_subcategory);
        Log.d("sub","2");
        layout_not_available= (LinearLayout)view.findViewById(R.id.layout_not_available);



        sharedPrefs = new SharedPrefs(getContext());

        if (getActivity() instanceof Home) {

            ((Home) getContext()).getSupportActionBar().hide();
        }
        subCategoryPresenter = new SubCategoryPresenterImpl(this, new RetrofitSubCategoryDetailsProvider());
//        subCategoryPresenter = new SubCategoryPresenterImpl(this, new MockSubcategoryProvider());
        //        productsListPresenter = new ProductListPresenterImplementation(this, new RetrofitProductListDetailsProvider());

        Log.d("Sub","ReachedPresenterInitialisation");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        Log.d("sub","3");
        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        subCategoryPresenter.requestSubCategoryDetails(sharedPrefs.getAccessToken());

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        onDestroy();////
    }

    @Override
    public void showProgressBar(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
            tabLayout.setVisibility(View.GONE);
            viewPager.setVisibility(View.GONE);
        } else {
            progressBar.setVisibility(View.GONE);
            tabLayout.setVisibility(View.VISIBLE);
            viewPager.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void setTabs(SubCategoryData subCategoryData) {
//        subCategoryDataLocal=new SubCategoryData(subCategoryData.getMessage(),
//                subCategoryData.isSuccess(),subCategoryData.getSub_category_list());

        List<SubCategoryDetails> subCategoryDetailses = new ArrayList<>(subCategoryData.getSub_category_list());
        if (subCategoryData.isSuccess()) {
            if (subCategoryDetailses.size() == 0
                    ) {
                layout_not_available.setVisibility(View.VISIBLE);
                tabLayout.setVisibility(View.GONE);
                viewPager.setVisibility(View.GONE);

            } else {
                Log.d("sub","12");
                layout_not_available.setVisibility(View.GONE);
                tabLayout.setVisibility(View.VISIBLE);
                viewPager.setVisibility(View.VISIBLE);
            }

        }

        List<SubCategoryDetails> subCategoryDetailsList = new ArrayList<>(subCategoryData.getSub_category_list());
        List<Fragment> fragmentList = new ArrayList<>();


        for (int i = 0; i < subCategoryDetailsList.size(); i++)
        {
//            ProductsListFragment fragment = ProductsListFragment.newInstance(subCategoryDetailsList.get(i).getId(),
//                                            querry);
//            fragmentList.add(fragment);
            titleList.add(subCategoryDetailsList.get(i).getName());
        }
        viewPagerAdapter.setTabData(querry,titleList);
        viewPagerAdapter.notifyDataSetChanged();

    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // TODO Add your menu entries here
        Log.d("sub","200");
        super.onCreateOptionsMenu(menu, inflater);
        toolbar.inflateMenu(R.menu.search_menu);
        final MenuItem myActionMenuItem = toolbar.getMenu().findItem(R.id.action_search);
        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getContext().getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) myActionMenuItem.getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getActivity().getComponentName()));
        searchView.setIconifiedByDefault(false);
        // searchView.requestFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                querry=s;
                viewPagerAdapter.setTabData(querry,titleList);
                viewPagerAdapter.notifyDataSetChanged();
                return false;
            }


        });


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
