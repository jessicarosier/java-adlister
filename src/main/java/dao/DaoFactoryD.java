package dao;

public class DaoFactoryD {

    private static ProductsDao productsDao;

    public static ProductsDao getProductsDao() {
        //if there are not ProductsDaos that exists
        if (productsDao == null) {
            //make one
            productsDao = new ListProducts();
        }
        //otherwise give me the one that exists
        return productsDao;
    }


}
