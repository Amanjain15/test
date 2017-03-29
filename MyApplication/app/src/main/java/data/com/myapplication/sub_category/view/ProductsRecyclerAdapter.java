package data.com.myapplication.sub_category.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import data.com.myapplication.Home.Home;
import data.com.myapplication.R;
import data.com.myapplication.SharedPrefs;
import data.com.myapplication.sub_category.model.data.ProductListDetails;

/**
 * Created by aman on 28/3/17.
 */

public class ProductsRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<ProductListDetails> productListDetailsList = new ArrayList<>();
    private ProductListDetails productListDetails;
    private int subcategoryId;
    private ProductsListFragment productsListFragment;
    private SharedPrefs sharedPrefs;
//    private ImageLoader imageLoader;
ProductsRecyclerAdapter(Context context,  ProductsListFragment productsListFragment) {

    this.   context = context;
    layoutInflater = LayoutInflater.from(context);
    this.productsListFragment = productsListFragment;
    sharedPrefs = new SharedPrefs(context);
//    imageLoader = new GlideImageLoader(context);
}

    public void setData(List<ProductListDetails> productListDetails, int subcategoryId) {
        this.productListDetailsList = productListDetails;
        this.subcategoryId=subcategoryId;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view1 = layoutInflater.inflate(R.layout.product_item_new, parent, false);
        return new ProductViewHolder(view1);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        productListDetails = productListDetailsList.get(position);
        final ProductViewHolder productViewHolder = (ProductViewHolder) holder;
        productViewHolder.name.setText(productListDetails.getName());
        productViewHolder.email.setText(productListDetails.getCollege());
        productViewHolder.place.setText(productListDetails.getSpeciality());
        productViewHolder.unit.setText(productListDetails.getId());
        productViewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ProductDescFragment fragment = ProductDescFragment.newInstance(subcategoryId,
//                                            productListDetails.getName());
//                ((Home)context).setFragment(new ProductDescFragment(),productListDetails.getName());

            }
        });

//        imageLoader.loadImage(productListDetails.getImage(), productViewHolder.productImage,
//                productViewHolder.imageProgressBar);
    }

    @Override
    public int getItemCount() {
        return productListDetailsList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        ProgressBar progressBar;
        TextView name;
        TextView unit;
        TextView email;
        TextView place;
        RelativeLayout relativeLayout;

        public ProductViewHolder(View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.name);
            unit = (TextView)itemView.findViewById(R.id.unit);
            email = (TextView)itemView.findViewById(R.id.place);
            place = (TextView)itemView.findViewById(R.id.email);
            imageView = (ImageView)itemView.findViewById(R.id.productImage);
            progressBar = (ProgressBar)itemView.findViewById(R.id.imageProgressBar);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.product_layout);
        }
    }

}
