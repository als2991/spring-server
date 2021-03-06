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

val productListsByAuthor = mapOf(
        "suvorov" to listOf(
                Product(
                        id = "1",
                        tag = "engin",
                        name = "КОМПАС 3D",
                        price = 60000.0,
                        imageUrl = "http://chelzakazy.myjino.ru/android/kompas.png",
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
                                                "*инструменты для работы с исполнениями и конфигурациями " +
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
                        imageUrl = "http://chelzakazy.myjino.ru/android/vertical.png",
                        description = "САПР ТР ВЕРТИКАЛЬ",
                        discountPercent = 0,
                        attributes = listOf(
                                Product.Attribute(
                                        name = "Описание",
                                        value = "ВЕРТИКАЛЬ — система автоматизированного проектирования " +
                                                "технологических процессов, которая решает большинство задач в рамках " +
                                                "технологической подготовки производства и позволяет упростить " +
                                                "формирование и сопровождение техпроцессов, повысить качество " +
                                                "технологической документации и добиться оптимальных показателей " +
                                                "использования имеющихся ресурсов предприятия."
                                ),
                                Product.Attribute(
                                        name = "Возможности",
                                        value = "* Проектирование технологических процессов\n\n" +
                                                "* Формирование заказов на проектирование СТО и создание управляющих " +
                                                "программ для оборудования с ЧПУ\n\n" +
                                                "* Технологические расчеты (Производятся с помощью расчетных приложений," +
                                                " которые поставляются отдельно)\n\n" +
                                                "* Формирование технологической документации в соответствии с " +
                                                "требованиями ГОСТ РФ и стандартами, используемыми на предприятии\n\n" +
                                                "* Поддержка единого информационного пространства для управления " +
                                                "жизненным циклом изделия"
                                )
                        )
                ),
                Product(
                        id = "3",
                        tag = "engin",
                        name = "ЛОЦМАН:PLM",
                        price = 112000.0,
                        imageUrl = "http://chelzakazy.myjino.ru/android/lodsman.png",
                        description = "ЛОЦМАН:PLM",
                        discountPercent = 15,
                        attributes = listOf(
                                Product.Attribute(
                                        name = "Описание",
                                        value = "ЛОЦМАН:PLM поможет вам оптимизировать рабочие процессы и уделять " +
                                                "больше времени инженерному творчеству и созданию инновационных " +
                                                "продуктов. Управляйте данными и процессами, работайте над совместными " +
                                                "проектами и быстро находите нужную информацию."
                                ),
                                Product.Attribute(
                                        name = "Возможности",
                                        value = "* Управление хранением данных и документов\n\n" +
                                                "* Управление структурой и конфигурациями изделия\n\n" +
                                                "* Управление коммуникациями и обмен сообщениями\n\n" +
                                                "* Интеграция с САПР и другими программами-инструментами\n\n" +
                                                "* Календарное планирование и управление проектами\n\n" +
                                                "* Управление процессами (WorkFlow)\n\n" +
                                                "* Формирование отчетов"
                                )
                        )
                ),
                Product(
                        id = "4",
                        tag = "engin",
                        name = "ПОЛИНОМ:MDM",
                        price = 72000.0,
                        imageUrl = "http://chelzakazy.myjino.ru/android/polinom.png",
                        description = "ПОЛИНОМ:MDM",
                        discountPercent = 0,
                        attributes = listOf(
                                Product.Attribute(
                                        name = "Описание",
                                        value = "ПОЛИНОМ:MDM — это решение, которое позволяет управлять " +
                                                "нормативно-справочной информацией промышленного предприятия, " +
                                                "применяя единые инструменты, подходы и методы для работы с данными."
                                ),
                                Product.Attribute(
                                        name = "Возможности",
                                        value = "* Управление широким спектром нормативно-справочной информации в рамках " +
                                                "единой программной платформы\n\n" +
                                                "* Универсальная модель данных\n\n" +
                                                "* Контекстное представление объектов НСИ\n\n" +
                                                "* Умная и быстрая поисковая система\n\n" +
                                                "* Контроль качества данных\n\n" +
                                                "* Управление правами доступа\n\n" +
                                                "* Импорт данных"
                                )
                        )
                ),
                Product(
                        id = "5",
                        tag = "build",
                        name = "Renga Architecture",
                        price = 52500.0,
                        imageUrl = "http://chelzakazy.myjino.ru/android/renga.png",
                        description = "Renga Architecture",
                        discountPercent = 0,
                        attributes = listOf(
                                Product.Attribute(
                                        name = "Описание",
                                        value = "Renga Architecture — это первая отечественная BIM-система для " +
                                                "архитектурно-строительного проектирования. Программа принципиально " +
                                                "отличается от многих других инженерных программ для промышленного и " +
                                                "гражданского строительства тем, что она изначально ориентирована на " +
                                                "трехмерное проектирование и позволяет архитекторам, дизайнерам и " +
                                                "проектировщикам создавать 3D-информационные модели зданий и сооружений " +
                                                "с последующим получением чертежей марки АР и АС."
                                ),
                                Product.Attribute(
                                        name = "Возможности",
                                        value = "На начальном этапе проектирования, архитектору нужен инструмент, " +
                                                "который позволит быстро и просто смоделировать облик будущего " +
                                                "здания.\n\n" +
                                                "Работа в BIM-системе Renga основана на 2-х основных " +
                                                "принципах — проектирование в 3D-пространстве (для быстрой и наглядной " +
                                                "работы) и простой контекстно-ориентированный интерфейс (для удобного " +
                                                "и простого взаимодействия с 3D-моделью).\n\n" +
                                                "Архитектор начинает создавать своё здание на 3D-Виде, используя для " +
                                                "моделирования объектные инструменты (стены, балки, окна и т.д.). " +
                                                "В любой момент можно переключиться на план и там продолжить создавать " +
                                                "3D-модель.\n\n" +
                                                "Многие профессионалы оценили такой подход к проектированию и " +
                                                "признали, что скорость работы в Renga Architecture выше по сравнению " +
                                                "с другими программами."
                                )
                        )
                ),

                Product(
                        id = "6",
                        tag = "build",
                        name = "Renga Structure",
                        price = 57500.0,
                        imageUrl = "http://chelzakazy.myjino.ru/android/renga.png",
                        description = "Renga Structure",
                        discountPercent = 0,
                        attributes = listOf(
                                Product.Attribute(
                                        name = "Описание",
                                        value = "Renga Structure — это первая отечественная BIM-система для " +
                                                "конструкторов и инженеров-проектировщиков по созданию информационной " +
                                                "модели здания или сооружения и получению чертежей марок КЖ/КЖИ/КМ/АС."
                                ),
                                Product.Attribute(
                                        name = "Возможности",
                                        value = "* Автоматическое армирование\n" +
                                                "\n" +
                                                "* Проектирование металлоконструкций\n" +
                                                "\n" +
                                                "* Эффективное взаимодействие конструкторов с другими участниками проекта\n" +
                                                "\n" +
                                                "* Автоматическое получение спецификаций\n" +
                                                "\n" +
                                                "* Автоматическое получение чертежей\n" +
                                                "\n" +
                                                "* Использование ранее созданных 2D-чертежей при оформлении документации " +
                                                "и проектировании 3D-моделей зданий\n" +
                                                "\n" +
                                                "* Быстрая корректировка проекта. Взаимосвязь 3D-модели с чертежами\n" +
                                                "\n" +
                                                "* Наглядность 3D\n" +
                                                "\n" +
                                                "* 3D-проектирование вместо 2D-черчения\n" +
                                                "\n" +
                                                "* Быстрая подготовка данных для расчетных комплексов\n" +
                                                "\n" +
                                                "* Формирование документации в соответствии с российскими и зарубежными " +
                                                "стандартами\n" +
                                                "\n"
                                )

                        )

                ),
                Product(
                        id = "7",
                        tag = "build",
                        name = "PILOT-ICE",
                        price = 30000.0,
                        imageUrl = "http://chelzakazy.myjino.ru/android/pilotIce.png",
                        description = "PILOT-ICE",
                        discountPercent = 10,
                        attributes = listOf(
                                Product.Attribute(
                                        name = "Описание",
                                        value = "PILOT-ICE - это система класса ECM для управления проектной " +
                                                "организацией. Подходит для небольших и средних проектных организаций, " +
                                                "архитектурных мастерских, проектных бюро и проектно-конструкторских " +
                                                "отделов."
                                ),
                                Product.Attribute(
                                        name = "Возможности",
                                        value = "* Организация коллективной работы при создании проектно-сметной " +
                                                "документации (ПСД);\n" +
                                                "\n" +
                                                "* Совместимость с любыми САПР, расчетными и сметными системами, " +
                                                "пояснительными текстовыми записками и с любыми файлами (изображениями," +
                                                " аудио-, видео-);\n" +
                                                "\n" +
                                                "* Управление исполнительской дисциплиной;\n" +
                                                "\n" +
                                                "* Управление корпоративным контентом проектной организации;\n" +
                                                "\n" +
                                                "* Планирование и управление проектами;\n" +
                                                "\n" +
                                                "* Отчеты по выполнению проектов, работе подразделений, сотрудников;\n" +
                                                "\n" +
                                                "* Взаимодействие с подрядчиками и заказчиками;\n" +
                                                "\n" +
                                                "* Анализ данных."
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