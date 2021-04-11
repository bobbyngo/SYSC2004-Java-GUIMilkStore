package stores;
// GABRIEL BENNI KELLEY EVENSEN
// 101119814
// Ngo Huu Gia Bao
// 101163137
/**
 * A class representing a shopping cart
 *
 * @author Gabriel Benni Kelley Evensen, 101119814
 * @author Ngo Huu Gia Bao, 101163137
 * @version 2.0
 */

import java.util.HashMap;

public class ShoppingCart implements ProductStockContainer{

    private int cartID;
    private HashMap<Integer, Integer> customerCart = new HashMap<>(); //id quantity

    /**
     * The constructor of the stores.ShoppingCart class
     *
     * @param cartID int, the cartID of the stores.ShoppingCart class
     */
    public ShoppingCart(int cartID) {

        this.cartID = cartID;
        this.customerCart.put(0, 0);
        this.customerCart.put(1, 0);
        this.customerCart.put(2, 0);
        this.customerCart.put(3, 0);
        this.customerCart.put(4, 0);

    }

    /**
     * The addCustomerProduct will check if the input quantity is smaller or equal to the quantity in the idQuantity HashMap (stores.Inventory class)
     * and the input id is contained on the stores.Inventory class or not. If yes, the method will add the input id
     * and quantity to the customerCart HashMap.
     *
     * @param id     int, the id of the product
     * @param amount int, the amount or the quantity that the customer wants to add
     */
    public void addProductQuantity(int id, int amount) {
        //if (amount <= storeManager.getQuantity().get(id) && storeManager.getQuantity().containsKey(id)) {
        //Add product id with the amount to the customer's cart
        customerCart.put(id, customerCart.get(id) + amount);
        //}
    }

    /**
     * The removeCustomerProduct will check if the input quantity is smaller or equal to the quantity in the customerCart HashMap
     * and the input id is contained on the HashMap or not. If yes, the method will remove the input id
     * and quantity from customerCart HashMap.
     *
     * @param id     int, the id of the product
     * @param amount int, the amount or the quantity that the customer wants to remove
     */
    public void removeProductQuantity(int id, int amount) {
        //if (amount <= customerCart.get(id) && customerCart.containsKey(id)) {
        //Remove product with id from the amount to the customer's cart
        customerCart.put(id, customerCart.get(id) - amount);

    }

    /**
     * The getter method for the cartID attribute
     *
     * @return cartID, the cart ID of the customer, each customer has unique ID
     */
    public int getCartID() {
        return cartID;
    }

    /**
     * The getter method for the HashMap customerCart
     *
     * @return customerCart, HashMap storing the id and the amount of the product of the customer's cart
     */
    public HashMap<Integer, Integer> getCustomerCart() {
        return customerCart;
    }


    /**
     *                                         MILESTONE 5
     */


    /**
     * The implemented method which will return the quantity of product inside the ShoppingCart
     * that associates with the given Product
     * @param product Product
     * @return int, the quantity of product inside the ShoppingCart
     */
    @Override
    public int getProductQuantity(Product product) {
        return customerCart.get(product.getId());
    }

    /**
     * The implemented method which will add the quantity of product to the ShoppingCart
     * that associates with the given Product
     * @param product Product
     * @param amount the quantity the ShoppingCart that wants to add
     */
    @Override
    public void addProductQuantity(Product product, int amount) {
        addProductQuantity(product.getId(), amount);
    }

    /**
     * The implemented method which will remove the quantity of product from the ShoppingCart
     * that associates with the given Product
     * @param product Product
     * @param amount the quantity the ShoppingCart that wants to remove
     */
    @Override
    public void removeProductQuantity(Product product, int amount) {
        removeProductQuantity(product.getId(), amount);
    }

    /**
     * The implemented method will return the number of product that is available inside
     * the ShoppingCart
     * @return int, the number of available products inside the ShoppingCart
     */
    @Override
    public int getNumOfProducts() {
        return customerCart.size();
    }
}
