package io.adev.itschool

import org.springframework.web.bind.annotation.*
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.CopyOnWriteArrayList

data class Order(
        val organization: String,
        val fio: String,
        val userPhone: String,
        val userEmail: String,
        val totalPrice: String,
        val items: List<Item>
) {
    /**
     * @return [items] mapped to List<[FullOrder.Item]> with [Product]s returned by
     * passing [Item.productId] to [findProductById].
     * If [findProductById] returned null for [Item] from [items] than this item will not be presented in result list.
     */
    inline fun toFullOrder(findProductById: (String) -> Product?): FullOrder {
        val fullOrderItems = items.mapNotNull { item ->
            item.toFullOrderItem(findProductById)
        }
        return FullOrder(
                organization,
                fio,
                userPhone,
                userEmail,
                totalPrice,
                fullOrderItems
        )
    }

    data class Item(
            val productId: String
            //val count: Int
    ) {
        /**
         * @return [FullOrder.Item] with [Product] returned by [findProductById]
         * if this [Product] is not null and null otherwise.
         */
        inline fun toFullOrderItem(findProductById: (String) -> Product?): FullOrder.Item? {
            val product = findProductById(productId)
            return if (product != null)
                FullOrder.Item(product)
            else
                null
        }
    }

}

data class FullOrder(
        val organization: String,
        val fio: String,
        val userPhone: String,
        val userEmail: String,
        val totalPrice: String,
        val items: List<Item>
) {
    data class Item(
            val product: Product
    )
}

private val ordersByAuthor = ConcurrentHashMap<String, CopyOnWriteArrayList<Order>>()

@RestController
class OrdersController {

    @PostMapping("orders/new/{author}")
    fun create(@PathVariable author: String, @RequestBody order: Order) {
        if (ordersByAuthor.containsKey(author)) {
            ordersByAuthor[author]!!.add(order)
        } else {
            ordersByAuthor[author] = CopyOnWriteArrayList()
        }
    }

    @GetMapping("orders/all/{author}/")
    fun all(@PathVariable author: String): List<FullOrder> {
        val products: List<Product> = productListsByAuthor[author] ?: emptyList()
        val orders: List<Order> = ordersByAuthor[author] ?: emptyList()
        return orders.map { order ->
            order.toFullOrder(
                    findProductById = { productId ->
                        val product = products.find { product ->
                            product.id == productId
                        }
                        product
                    }
            )
        }
    }

    @GetMapping("orders/test/{author}/")
    fun test(@PathVariable author: String): List<Order> {
        return ordersByAuthor[author] ?: emptyList()
    }
}