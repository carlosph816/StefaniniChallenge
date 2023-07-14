package com.caperezh.stefaninichallenge.common

import com.caperezh.stefaninichallenge.R
import com.caperezh.stefaninichallenge.data.model.GridModel

class ItemsProvider {

    companion object {
        const val timeResponse: Long = 3000
        const val code: Int = 200

        internal fun getStatusCodeRandom(): BaseError {
            val position = (statusCode.indices).random()
            return statusCode[position]
        }

        private val statusCode = listOf(
            BaseError(
                code = 200
            ),
            BaseError(
                code = 200
            )
        )

        val itemsResponseJson = "[\n" +
                "  {\n" +
                "    \"name\": \"App 1\",\n" +
                "    \"category\": \"Category 1\",\n" +
                "    \"image\": \"app1\",\n" +
                "    \"price\": 5.0,\n" +
                "    \"rating\": 2,\n" +
                "    \"developer\": \"Desarrollador 1\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 2\",\n" +
                "    \"category\": \"Category 2\",\n" +
                "    \"image\": \"app2\",\n" +
                "    \"price\": 1.0,\n" +
                "    \"rating\": 1,\n" +
                "    \"developer\": \"Desarrollador 2\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 3\",\n" +
                "    \"category\": \"Category 3\",\n" +
                "    \"image\": \"app3\",\n" +
                "    \"price\": 2.0,\n" +
                "    \"rating\": 0,\n" +
                "    \"developer\": \"Desarrollador 3\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 4\",\n" +
                "    \"category\": \"Category 1\",\n" +
                "    \"image\": \"app4\",\n" +
                "    \"price\": 3.0,\n" +
                "    \"rating\": 3,\n" +
                "    \"developer\": \"Desarrollador 4\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 5\",\n" +
                "    \"category\": \"Category 2\",\n" +
                "    \"image\": \"app5\",\n" +
                "    \"price\": 1.0,\n" +
                "    \"rating\": 1,\n" +
                "    \"developer\": \"Desarrollador 5\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 6\",\n" +
                "    \"category\": \"Category 3\",\n" +
                "    \"image\": \"app6\",\n" +
                "    \"price\": 5.0,\n" +
                "    \"rating\": 2,\n" +
                "    \"developer\": \"Desarrollador 6\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 7\",\n" +
                "    \"category\": \"Category 1\",\n" +
                "    \"image\": \"app7\",\n" +
                "    \"price\": 5.0,\n" +
                "    \"rating\": 3,\n" +
                "    \"developer\": \"Desarrollador 7\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 8\",\n" +
                "    \"category\": \"Category 2\",\n" +
                "    \"image\": \"app8\",\n" +
                "    \"price\": 5.0,\n" +
                "    \"rating\": 1,\n" +
                "    \"developer\": \"Desarrollador 8\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 9\",\n" +
                "    \"category\": \"Category 3\",\n" +
                "    \"image\": \"app9\",\n" +
                "    \"price\": 0.0,\n" +
                "    \"rating\": 2,\n" +
                "    \"developer\": \"Desarrollador 9\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 10\",\n" +
                "    \"category\": \"Category 1\",\n" +
                "    \"image\": \"app10\",\n" +
                "    \"price\": 0.4,\n" +
                "    \"rating\": 3,\n" +
                "    \"developer\": \"Desarrollador 10\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 11\",\n" +
                "    \"category\": \"Category 2\",\n" +
                "    \"image\": \"app11\",\n" +
                "    \"price\": 0.4,\n" +
                "    \"rating\": 1,\n" +
                "    \"developer\": \"Desarrollador 11\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 12\",\n" +
                "    \"category\": \"Category 3\",\n" +
                "    \"image\": \"app12\",\n" +
                "    \"price\": 0.4,\n" +
                "    \"rating\": 2,\n" +
                "    \"developer\": \"Desarrollador 12\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 13\",\n" +
                "    \"category\": \"Category 1\",\n" +
                "    \"image\": \"app13\",\n" +
                "    \"price\": 0.4,\n" +
                "    \"rating\": 3,\n" +
                "    \"developer\": \"Desarrollador 13\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 14\",\n" +
                "    \"category\": \"Category 2\",\n" +
                "    \"image\": \"app14\",\n" +
                "    \"price\": 0.4,\n" +
                "    \"rating\": 1,\n" +
                "    \"developer\": \"Desarrollador 14\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 15\",\n" +
                "    \"category\": \"Category 3\",\n" +
                "    \"image\": \"app15\",\n" +
                "    \"price\": 3.0,\n" +
                "    \"rating\": 2,\n" +
                "    \"developer\": \"Desarrollador 15\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 16\",\n" +
                "    \"category\": \"Category 1\",\n" +
                "    \"image\": \"app16\",\n" +
                "    \"price\": 5.0,\n" +
                "    \"rating\": 3,\n" +
                "    \"developer\": \"Desarrollador 16\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 17\",\n" +
                "    \"category\": \"Category 2\",\n" +
                "    \"image\": \"app17\",\n" +
                "    \"price\": 4.0,\n" +
                "    \"rating\": 1,\n" +
                "    \"developer\": \"Desarrollador 17\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 18\",\n" +
                "    \"category\": \"Category 3\",\n" +
                "    \"image\": \"app18\",\n" +
                "    \"price\": 5.0,\n" +
                "    \"rating\": 2,\n" +
                "    \"developer\": \"Desarrollador 18\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 19\",\n" +
                "    \"category\": \"Category 1\",\n" +
                "    \"image\": \"app19\",\n" +
                "    \"price\": 3.0,\n" +
                "    \"rating\": 3,\n" +
                "    \"developer\": \"Desarrollador 19\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 20\",\n" +
                "    \"category\": \"Category 2\",\n" +
                "    \"image\": \"app20\",\n" +
                "    \"price\": 5.0,\n" +
                "    \"rating\": 1,\n" +
                "    \"developer\": \"Desarrollador 20\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 21\",\n" +
                "    \"category\": \"Category 3\",\n" +
                "    \"image\": \"app21\",\n" +
                "    \"price\": 0.2,\n" +
                "    \"rating\": 2,\n" +
                "    \"developer\": \"Desarrollador 21\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 22\",\n" +
                "    \"category\": \"Category 1\",\n" +
                "    \"image\": \"app22\",\n" +
                "    \"price\": 5.0,\n" +
                "    \"rating\": 3,\n" +
                "    \"developer\": \"Desarrollador 22\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 23\",\n" +
                "    \"category\": \"Category 2\",\n" +
                "    \"image\": \"app23\",\n" +
                "    \"price\": 1.4,\n" +
                "    \"rating\": 1,\n" +
                "    \"developer\": \"Desarrollador 23\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 24\",\n" +
                "    \"category\": \"Category 3\",\n" +
                "    \"image\": \"app24\",\n" +
                "    \"price\": 0.4,\n" +
                "    \"rating\": 2,\n" +
                "    \"developer\": \"Desarrollador 24\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 25\",\n" +
                "    \"category\": \"Category 1\",\n" +
                "    \"image\": \"app25\",\n" +
                "    \"price\": 5.0,\n" +
                "    \"rating\": 3,\n" +
                "    \"developer\": \"Desarrollador 25\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 26\",\n" +
                "    \"category\": \"Category 2\",\n" +
                "    \"image\": \"app26\",\n" +
                "    \"price\": 0.2,\n" +
                "    \"rating\": 1,\n" +
                "    \"developer\": \"Desarrollador 26\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 27\",\n" +
                "    \"category\": \"Category 3\",\n" +
                "    \"image\": \"app27\",\n" +
                "    \"price\": 0.2,\n" +
                "    \"rating\": 2,\n" +
                "    \"developer\": \"Desarrollador 27\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 28\",\n" +
                "    \"category\": \"Category 1\",\n" +
                "    \"image\": \"app28\",\n" +
                "    \"price\": 5.0,\n" +
                "    \"rating\": 3,\n" +
                "    \"developer\": \"Desarrollador 28\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 29\",\n" +
                "    \"category\": \"Category 2\",\n" +
                "    \"image\": \"app29\",\n" +
                "    \"price\": 2.0,\n" +
                "    \"rating\": 1,\n" +
                "    \"developer\": \"Desarrollador 29\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 30\",\n" +
                "    \"category\": \"Category 3\",\n" +
                "    \"image\": \"app30\",\n" +
                "    \"price\": 1.0,\n" +
                "    \"rating\": 2,\n" +
                "    \"developer\": \"Desarrollador 30\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 31\",\n" +
                "    \"category\": \"Category 1\",\n" +
                "    \"image\": \"app31\",\n" +
                "    \"price\": 0.2,\n" +
                "    \"rating\": 3,\n" +
                "    \"developer\": \"Desarrollador 31\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 32\",\n" +
                "    \"category\": \"Category 2\",\n" +
                "    \"image\": \"app32\",\n" +
                "    \"price\": 5.0,\n" +
                "    \"rating\": 2,\n" +
                "    \"developer\": \"Desarrollador 32\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 33\",\n" +
                "    \"category\": \"Category 3\",\n" +
                "    \"image\": \"app33\",\n" +
                "    \"price\": 0.0,\n" +
                "    \"rating\": 5,\n" +
                "    \"developer\": \"Desarrollador 33\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 34\",\n" +
                "    \"category\": \"Category 1\",\n" +
                "    \"image\": \"app34\",\n" +
                "    \"price\": 5.0,\n" +
                "    \"rating\": 2,\n" +
                "    \"developer\": \"Desarrollador 34\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 35\",\n" +
                "    \"category\": \"Category 2\",\n" +
                "    \"image\": \"app35\",\n" +
                "    \"price\": 1.0,\n" +
                "    \"rating\": 4,\n" +
                "    \"developer\": \"Desarrollador 35\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 36\",\n" +
                "    \"category\": \"Category 3\",\n" +
                "    \"image\": \"app36\",\n" +
                "    \"price\": 5.0,\n" +
                "    \"rating\": 2,\n" +
                "    \"developer\": \"Desarrollador 36\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 37\",\n" +
                "    \"category\": \"Category 4\",\n" +
                "    \"image\": \"app37\",\n" +
                "    \"price\": 7.0,\n" +
                "    \"rating\": 3,\n" +
                "    \"developer\": \"Desarrollador 37\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 38\",\n" +
                "    \"category\": \"Category 1\",\n" +
                "    \"image\": \"app38\",\n" +
                "    \"price\": 1.0,\n" +
                "    \"rating\": 3,\n" +
                "    \"developer\": \"Desarrollador 38\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 41\",\n" +
                "    \"category\": \"Category 1\",\n" +
                "    \"image\": \"app41\",\n" +
                "    \"price\": 5.0,\n" +
                "    \"rating\": 2,\n" +
                "    \"developer\": \"Desarrollador 41\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 42\",\n" +
                "    \"category\": \"Category 2\",\n" +
                "    \"image\": \"app42\",\n" +
                "    \"price\": 0.2,\n" +
                "    \"rating\": 4,\n" +
                "    \"developer\": \"Desarrollador 42\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 43\",\n" +
                "    \"category\": \"Category 3\",\n" +
                "    \"image\": \"app43\",\n" +
                "    \"price\": 5.0,\n" +
                "    \"rating\": 2,\n" +
                "    \"developer\": \"Desarrollador 43\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 44\",\n" +
                "    \"category\": \"Category 1\",\n" +
                "    \"image\": \"app44\",\n" +
                "    \"price\": 0.2,\n" +
                "    \"rating\": 1,\n" +
                "    \"developer\": \"Desarrollador 44\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 45\",\n" +
                "    \"category\": \"Category 2\",\n" +
                "    \"image\": \"app45\",\n" +
                "    \"price\": 9.0,\n" +
                "    \"rating\": 2,\n" +
                "    \"developer\": \"Desarrollador 45\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 46\",\n" +
                "    \"category\": \"Category 3\",\n" +
                "    \"image\": \"app46\",\n" +
                "    \"price\": 0.2,\n" +
                "    \"rating\": 3,\n" +
                "    \"developer\": \"Desarrollador 46\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 47\",\n" +
                "    \"category\": \"Category 1\",\n" +
                "    \"image\": \"app47\",\n" +
                "    \"price\": 6.0,\n" +
                "    \"rating\": 3,\n" +
                "    \"developer\": \"Desarrollador 47\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 48\",\n" +
                "    \"category\": \"Category 2\",\n" +
                "    \"image\": \"app48\",\n" +
                "    \"price\": 0.2,\n" +
                "    \"rating\": 2,\n" +
                "    \"developer\": \"Desarrollador 48\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 49\",\n" +
                "    \"category\": \"Category 3\",\n" +
                "    \"image\": \"app49\",\n" +
                "    \"price\": 3.0,\n" +
                "    \"rating\": 1,\n" +
                "    \"developer\": \"Desarrollador 49\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"App 50\",\n" +
                "    \"category\": \"Category 3\",\n" +
                "    \"image\": \"app50\",\n" +
                "    \"price\": 5.0,\n" +
                "    \"rating\": 3,\n" +
                "    \"developer\": \"Desarrollador 50\"\n" +
                "  }\n" +
                "]\n"

    }
}

enum class Category(val categoryName: String) {
    ALL("All"),
    CATEGORY_1("Category 1"),
    CATEGORY_2("Category 2"),
    CATEGORY_3("Category 3"),
}
