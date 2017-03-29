package data.com.myapplication.sub_category.view;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

import java.util.List;

import data.com.myapplication.R;
import data.com.myapplication.SharedPrefs;
import data.com.myapplication.sub_category.model.MockProductListProvider;
import data.com.myapplication.sub_category.model.RetrofitProductListDetailsProvider;
import data.com.myapplication.sub_category.model.data.ProductListDetails;
import data.com.myapplication.sub_category.presenter.ProductListPresenterImplementation;
import data.com.myapplication.sub_category.presenter.ProductsListPresenter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProductsListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProductsListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductsListFragment extends Fragment implements ProductListView{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    private static final String SUB_CATEGORY_ID = "subCategoryId";
    private static final String QUERRY = "querry";
    // TODO: Rename and change types of parameters
    private int subCategoryId;
    private String querry="$";
    private ProductsRecyclerAdapter productsRecyclerAdapter;

    private ProductsListPresenter productsListPresenter;
    private SharedPrefs sharedPrefs;

    private RecyclerView recyclerView;
    private ProgressBar progressBar;;
    private Toolbar toolbar;
    private LinearLayout layout_not_available;
    private SearchView searchView;

    private OnFragmentInteractionListener mListener;

    public ProductsListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment ProductsListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductsListFragment newInstance(int subCategoryId,String querry) {
        ProductsListFragment fragment = new ProductsListFragment();
        Bundle args = new Bundle();
        args.putInt(SUB_CATEGORY_ID, subCategoryId);
        args.putString(QUERRY, querry);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            subCategoryId = getArguments().getInt(SUB_CATEGORY_ID,0);
            querry = getArguments().getString(QUERRY,"");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_products_list, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.productRecycler);
        progressBar = (ProgressBar)view.findViewById(R.id.progressBar);
//        toolbar = (Toolbar)view.findViewById(R.id.toolbar);
        layout_not_available = (LinearLayout)view.findViewById(R.id.layout_not_available);
//        toolbar.setVisibility(View.GONE);
        initialize();
        Log.d("subquer",""+querry+subCategoryId);

        if(!querry.equals(""))
        productsListPresenter.requestProductList(querry, sharedPrefs.getAccessToken(), subCategoryId);



        return  view;
    }

    private void initialize() {
//        productsListPresenter = new ProductListPresenterImplementation(this, new RetrofitProductListDetailsProvider());
        productsListPresenter = new ProductListPresenterImplementation(this, new MockProductListProvider());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        //recyclerView.setHasFixedSize(true);
        productsRecyclerAdapter = new ProductsRecyclerAdapter(getContext(),this);
        recyclerView.setAdapter(productsRecyclerAdapter);
        sharedPrefs = new SharedPrefs(getContext());
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
        onDestroy();
    }

    @Override
    public void showMessage(String message) {

        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgressbar(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            progressBar.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void setProductData(List<ProductListDetails> productListDetails)
    {

        if(productListDetails.size()==0){
            layout_not_available.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.INVISIBLE);
            //    return;
        }else{
            layout_not_available.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);

        }

        productsRecyclerAdapter.setData(productListDetails,subCategoryId);
        productsRecyclerAdapter.notifyDataSetChanged();
    }

//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        // TODO Add your menu entries here
//
//        super.onCreateOptionsMenu(menu, inflater);
//        toolbar.inflateMenu(R.menu.search_menu);
//
//        final MenuItem myActionMenuItem = toolbar.getMenu().findItem(R.id.action_search);
//        // Associate searchable configuration with the SearchView
//        SearchManager searchManager =
//                (SearchManager) getContext().getSystemService(Context.SEARCH_SERVICE);
//        searchView = (SearchView) myActionMenuItem.getActionView();
//        searchView.setSearchableInfo(
//                searchManager.getSearchableInfo(getActivity().getComponentName()));
//        searchView.setIconifiedByDefault(false);
//        // searchView.requestFocus();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//
//
//                productsListPresenter.requestProductList(s, sharedPrefs.getAccessToken(), -1);
//                return false;
//            }
//
//
//        });
//
//
//    }
//
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_search:
//                return true;
//            default:
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }


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

    public void updateData(String query)
    {
        querry = query;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
