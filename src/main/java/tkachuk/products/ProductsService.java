package tkachuk.products;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface ProductsService
{
    // the thing to request the data from the internet
    @GET("/products")
    Single<ProductsResponse> getProducts();

}
