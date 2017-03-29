package data.com.myapplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aman on 5/3/17.
 */

public class MockProvider implements Provider {


    @Override
    public void requestAddCustomer(AddCustomerCallback addCustomerCallback) {
        addCustomerCallback.onSuccess(getMockAddCustomerDetails());
    }

    private DsmData getMockAddCustomerDetails()
    {

//        List<ApplicationListDetails> applicationListDetailsList= new ArrayList<>();
//        List<DistrictListDetails> districtListDetailsList= new ArrayList<>();
//        List<TownListDetails> townListDetailsList= new ArrayList<>();
//        List<FinancierListDetails> financierListDetailsList= new ArrayList<>();
//        List<ModelListDetails> modelListDetailsList= new ArrayList<>();
//        List<VehicleListDetails> vehicleListDetailsList= new ArrayList<>();
        List<DsmListDetails> dsmListDetailsList= new ArrayList<>();


        for(int i=0;i<5;i++)
        {

            DsmListDetails dsmListDetails = new DsmListDetails(i+ "","Jim Priestin");


        }

        DsmData dsmData = new DsmData("List Received",true,dsmListDetailsList);


        return dsmData;
    }
}
