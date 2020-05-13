package io.adev.itschool

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

data class Product(
    val id: String,
    val tag: String,
    val name: String,
    val price: Money,
    val discountPercent: Int,
    val description: String,
    val imageUrl: String,
    val attributes: List<Attribute>
) {
    data class Attribute(
            val name: String,
            val value: String
    )
}


data class Category(
        val id: String,
        val tag: String,
        val name: String,
        val description: String,
        val imageUrl: String
)

typealias Money = Double

private val categotyListByAutor = mapOf(
        "suvorov" to listOf(
                Category(
                        id = "1",
                        tag = "engin",
                        name = "Машиностроение",
                        description = "Машиностроение",
                        imageUrl ="http://chelzakazy.myjino.ru/android/mash.jpg"
                ),
                Category(
                        id = "2",
                        tag = "build",
                        name = "Строительство",
                        description = "Строительство",
                        imageUrl = "http://chelzakazy.myjino.ru/android/stroit.jpg"
                )
        )
)

private val productListsByAuthor = mapOf(
        "suvorov" to listOf(
                Product(
                        id = "1",
                        tag = "engin",
                        name = "КОМПАС 3D",
                        price = 60000.0,
                        imageUrl = "http://3dtoday.ru/upload/main/095/095bcb543fafbe53813bb2b200370810.png",
                        description = "КОМПАС 3D",
                        discountPercent = 10,
                        attributes = listOf(
                                Product.Attribute(
                                        name = "Описание",
                                        value = "КОМПАС-3D — мощная и универсальная система трёхмерного " +
                                                "проектирования, ставшая стандартом для тысяч предприятий, " +
                                                "благодаря простоте освоения и широким возможностям твердотельного, " +
                                                "поверхностного и прямого моделирования."
                                ),
                                Product.Attribute(
                                        name = "Возможности",
                                        value = "* инструменты для коллективной работы, в том числе над проектами, " +
                                                "содержащими несколько десятков тысяч уникальных компонентов и " +
                                                "стандартных изделий;\n\n" +
                                                "* развитый функционал трехмерного твердотельного, поверхностного и " +
                                                "прямого моделирования;\n\n" +
                                                "инструменты для работы с исполнениями и конфигурациями " +
                                                "(в том числе зеркальными) деталей и сборочных единиц;\n\n" +
                                                "* инструменты моделирования деталей из листового материала с " +
                                                "последующим автоматическим получением чертежа развертки;\n\n" +
                                                "* специальные возможности, облегчающие построение литейных форм: " +
                                                "литейные уклоны, линии разъема, полости по форме детали " +
                                                "(в том числе с заданием усадки);\n\n" +
                                                "*инструменты создания пользовательских библиотек типовых элементов;\n\n" +
                                                "* возможность получения технической документации в соответствии " +
                                                "с ГОСТ, ISO, DIN или стандартами предприятия: чертежи, простые и " +
                                                "групповые спецификации, отчеты, схемы, таблицы, текстовые документы;\n\n" +
                                                "* средства для передачи данных в различные CAD/CAM/CAE-системы;\n\n" +
                                                "* возможность быстрого перехода от проектирования к изготовлению " +
                                                "деталей с использованием CAM-систем и станков с ЧПУ;\n\n" +
                                                "* возможность простановки размеров, обозначений и технических " +
                                                "требований в трехмерных моделях (поддержка стандарта ГОСТ " +
                                                "2.052-2006 «ЕСКД. Электронная модель изделия»)."
                                )

                        )

                ),
                Product(
                        id = "2",
                        tag = "engin",
                        name = "САПР ТП ВЕРТИКАЛЬ",
                        price = 82000.0,
                        imageUrl = "http://3dtoday.ru/upload/main/095/095bcb543fafbe53813bb2b200370810.png",
                        description = "САПР ТР ВЕРТИКАЛЬ",
                        discountPercent = 0,
                        attributes = listOf(
                                Product.Attribute(
                                        name = "Описание",
                                        value = ""
                                ),
                                Product.Attribute(
                                        name = "Возможности",
                                        value = ""
                                )

                        )

                ),
                Product(
                        id = "3",
                        tag = "build",
                        name = "РЕНГА",
                        price = 52500.0,
                        imageUrl = "",
                        description = "РЕНГА",
                        discountPercent = 0,
                        attributes = listOf(
                                Product.Attribute(
                                        name = "Описание",
                                        value = ""
                                ),
                                Product.Attribute(
                                        name = "Возможности",
                                        value = ""
                                )

                        )

                ),
                Product(
                        id = "4",
                        tag = "build",
                        name = "PILOT-ICE",
                        price = 30000.0,
                        imageUrl = "",
                        description = "PILOT-ICE",
                        discountPercent = 0,
                        attributes = listOf(
                                Product.Attribute(
                                        name = "Описание",
                                        value = ""
                                ),
                                Product.Attribute(
                                        name = "Возможности",
                                        value = ""
                                )

                        )

                )
        )
)

@RestController
class ProductsController {

    @GetMapping("products/{author}")
    fun all(@PathVariable author: String): List<Product> {
        return productListsByAuthor[author] ?: throw NoAuthorException(author)
    }
    @GetMapping("categories/{author}")
    fun category(@PathVariable author: String): List<Category>{
        return categotyListByAutor[author] ?: throw NoAuthorException(author)

    }

    @ExceptionHandler(NoAuthorException::class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    fun handleException(e: NoAuthorException): NoAuthorException.Response {
        return e.toResponse()
    }
}

class NoAuthorException(
    private val name: String
) : RuntimeException("no author with name=$name") {

    data class Response(
        val name: String,
        val message: String
    )

    fun toResponse() = Response(name, message!!)
}