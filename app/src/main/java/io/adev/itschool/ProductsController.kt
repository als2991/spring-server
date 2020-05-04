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
        val imageUrl: String
)

typealias Money = Double

private val categotyListByAutor = mapOf(
        "suvorov" to listOf(
                Category(
                        id = "1",
                        tag = "engin",
                        name = "Машиностроение",
                        imageUrl ="https://share.ascon.ru/s/kZzYFW4o7yynkMN"
                ),
                Category(
                        id = "2",
                        tag = "build",
                        name = "Строительство",
                        imageUrl = "https://share.ascon.ru/s/M9PbpHqncTJHSGq"
                )
        )
)

private val productListsByAuthor = mapOf(
    "default" to listOf(
        Product(
            id = "1",
            tag = "",
            name = "Mrkvkv",
            price = 123.5,
            discountPercent = 15,
            description = "Морковка немытая",
            imageUrl = "https://i.pinimg.com/originals/3e/50/d3/3e50d3c1231de7f7105e017a2ee85874.jpg",
            attributes = listOf(
                Product.Attribute(
                    name = "Качество",
                    value = "Наивысшее"
                ),
                Product.Attribute(
                    name = "Производитель",
                    value = "The Grandma Inc."
                )
            )
        ),
        Product(
            id = "1",
            tag = "",
            name = "Kotoshkv",
            price = 312.7,
            discountPercent = 25,
            description = "Картошка белая",
            imageUrl = "https://memepedia.ru/wp-content/uploads/2019/07/chilipizdrik-14-360x270.jpg",
            attributes = listOf(
                Product.Attribute(
                    name = "Качество",
                    value = "Наивысшайшее"
                ),
                Product.Attribute(
                    name = "Производитель",
                    value = "The Grandma Inc."
                )
            )
        )
    ),
        "suvorov" to listOf(
                Product(
                        id = "1",
                        tag = "ingin",
                        name = "КОМПАС 3D",
                        price = 60000.0,
                        imageUrl = "https://3dtoday.ru/upload/main/095/095bcb543fafbe53813bb2b200370810.png",
                        description = "КОМПАС 3D",
                        discountPercent = 0,
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
                                                "стандартных изделий;\n" +
                                                "* развитый функционал трехмерного твердотельного, поверхностного и " +
                                                "прямого моделирования;\n" +
                                                "инструменты для работы с исполнениями и конфигурациями " +
                                                "(в том числе зеркальными) деталей и сборочных единиц;\n" +
                                                "* инструменты моделирования деталей из листового материала с " +
                                                "последующим автоматическим получением чертежа развертки;\n" +
                                                "* специальные возможности, облегчающие построение литейных форм: " +
                                                "литейные уклоны, линии разъема, полости по форме детали " +
                                                "(в том числе с заданием усадки);\n" +
                                                "инструменты создания пользовательских библиотек типовых элементов;\n" +
                                                "* возможность получения технической документации в соответствии " +
                                                "с ГОСТ, ISO, DIN или стандартами предприятия: чертежи, простые и " +
                                                "групповые спецификации, отчеты, схемы, таблицы, текстовые документы;\n" +
                                                "* средства для передачи данных в различные CAD/CAM/CAE-системы;\n" +
                                                "* возможность быстрого перехода от проектирования к изготовлению " +
                                                "деталей с использованием CAM-систем и станков с ЧПУ;\n" +
                                                "* возможность простановки размеров, обозначений и технических " +
                                                "требований в трехмерных моделях (поддержка стандарта ГОСТ " +
                                                "2.052-2006 «ЕСКД. Электронная модель изделия»).System.lineSeparator()"
                                )

                        )

                ),
                Product(
                        id = "2",
                        tag = "ingin",
                        name = "САПР ТП ВЕРТИКАЛЬ",
                        price = 82000.0,
                        imageUrl = "https://3dtoday.ru/upload/main/095/095bcb543fafbe53813bb2b200370810.png",
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