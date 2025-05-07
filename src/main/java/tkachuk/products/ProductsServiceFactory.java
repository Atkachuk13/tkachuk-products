package tkachuk.products;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductsServiceFactory
{
    // design patterns :
    // - often needed -> an object that creates other objects
    // keyword for that is : factory

    public ProductsService create()
    {
        // configure Retrofit for the dummy json website
        // retrofit objects allows us to crate these services
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dummyjson.com/")
                // Configure Retrofit to use Gson to turn the Json into Objects
                .addConverterFactory(GsonConverterFactory.create())
                // Configure Retrofit to use Rx
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        ProductsService service = retrofit.create(ProductsService.class);
        return service;
    }
}
