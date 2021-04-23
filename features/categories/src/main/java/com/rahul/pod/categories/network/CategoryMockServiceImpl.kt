package com.rahul.pod.categories.network

import com.google.gson.Gson
import com.rahul.pod.categories.data.CategoryDataResponse
import io.reactivex.Observable
import retrofit2.mock.BehaviorDelegate

class CategoryMockServiceImpl(private val delegate: BehaviorDelegate<CategoryServiceInterface>):CategoryServiceInterface {
    override fun getCategoryData(
        parentCategory: String,
        category: String
    ): Observable<CategoryDataResponse> {
        var json: String = getCategoryMockData()

        val mockResponse = Gson().fromJson(json, CategoryDataResponse::class.java)
        return delegate.returningResponse(mockResponse).getCategoryData("stories","all")
    }

    private fun getCategoryMockData(): String {
    return "{\n" +
            "  \"results\": [\n" +
            "    {\n" +
            "      \"id\": 19401,\n" +
            "      \"overview\": \"Great might be an understatement. One of the world’s largest building-construction projects, the Great Wall of China is widely thought to be about 5,500 miles (8,850 km) long; a disputed Chinese study, however, claims the length is 13,170 miles (21,200 km). Work began in the 7th century BCE and continued for two millennia. Although called a wall, the structure actually features two parallel walls for lengthy stretches. In addition, watchtowers and barracks dot the bulwark. One not-so-great thing about the wall, however, was its effectiveness. Although it was built to prevent invasions and raids, the wall largely failed to provide actual security. Instead, scholars have noted that it served more as political propaganda.\",\n" +
            "      \"poster_path\": \"https://cdn.britannica.com/s:800x1000/82/94382-050-20CF23DB/Great-Wall-of-China-Beijing.jpg\",\n" +
            "      \"link\": \"\",\n" +
            "      \"title\": \"Great Wall of China\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 19402,\n" +
            "      \"overview\": \"The ancient city of Petra, Jordan, is located in a remote valley, nestled among sandstone mountains and cliffs. It was purported to be one of the places where Moses struck a rock and water gushed forth. Later the Nabataeans, an Arab tribe, made it their capital, and during this time it flourished, becoming an important trade center, especially for spices. Noted carvers, the Nabataeans chiseled dwellings, temples, and tombs into the sandstone, which changed color with the shifting sun. In addition, they constructed a water system that allowed for lush gardens and farming. At its height, Petra reportedly had a population of 30,000. The city began to decline, however, as trade routes shifted. A major earthquake in 363 CE caused more difficulty, and after another tremor hit in 551, Petra was gradually abandoned. Although rediscovered in 1912, it was largely ignored by archaeologists until the late 20th century, and many questions remain about the city.\",\n" +
            "      \"poster_path\": \"https://cdn.britannica.com/s:800x1000/25/153525-050-FC43840D/Khaznah-Petra-Jordan.jpg\",\n" +
            "      \"link\": \"\",\n" +
            "      \"title\": \"Petra\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 19403,\n" +
            "      \"overview\": \"This Incan site near Cuzco, Peru, was “discovered” in 1911 by Hiram Bingham, who believed it was Vilcabamba, a secret Incan stronghold used during the 16th-century rebellion against Spanish rule. Although that claim was later disproved, the purpose of Machu Picchu has confounded scholars. Bingham believed it was home to the “Virgins of the Sun,” women who lived in convents under a vow of chastity. Others think that it was likely a pilgrimage site, while some believe it was a royal retreat. (One thing it apparently should not be is the site of a beer commercial. In 2000 a crane being used for such an ad fell and cracked a monument.) What is known is that Machu Picchu is one of the few major pre-Columbian ruins found nearly intact. Despite its relative isolation high in the Andes Mountains, it features agricultural terraces, plazas, residential areas, and temples.\",\n" +
            "      \"poster_path\": \"https://cdn.britannica.com/s:800x1000/30/94530-050-99493FEA/Machu-Picchu.jpg\",\n" +
            "      \"link\": \"\",\n" +
            "      \"title\": \"Machu Picchu\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 19404,\n" +
            "      \"overview\": \"This mausoleum complex in Agra, India, is regarded as one of the world’s most iconic monuments and is perhaps the finest example of Mughal architecture. It was built by Emperor Shah Jahān (reigned 1628–58) to honor his wife Mumtāz Maḥal (“Chosen One of the Palace”), who died in 1631 giving birth to their 14th child. It took about 22 years and 20,000 workers to construct the complex, which includes an immense garden with a reflecting pool. The mausoleum is made of white marble that features semiprecious stones in geometric and floral patterns. Its majestic central dome is surrounded by four smaller domes. According to some reports, Shah Jahān wished to have his own mausoleum made out of black marble. However, he was deposed by one of his sons before any work began.\",\n" +
            "      \"poster_path\": \"https://cdn.britannica.com/s:800x1000/86/170586-050-AB7FEFAE/Taj-Mahal-Agra-India.jpg\",\n" +
            "      \"link\": \"\",\n" +
            "      \"title\": \"Taj Mahal\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 19405,\n" +
            "      \"overview\": \"The Colosseum in Rome was built in the first century by order of the Emperor Vespasian. A feat of engineering, the amphitheater measures 620 by 513 feet (189 by 156 meters) and features a complex system of vaults. It was capable of holding 50,000 spectators, who watched a variety of events. Perhaps most notable were gladiator fights, though men battling animals was also common. In addition, water was sometimes pumped into the Colosseum for mock naval engagements. However, the belief that Christians were martyred there—namely, by being thrown to lions—is debated. According to some estimates, about 500,000 people died in the Colosseum. Additionally, so many animals were captured and then killed there that certain species reportedly became extinct.\",\n" +
            "      \"poster_path\": \"https://cdn.britannica.com/s:800x1000/36/162636-050-932C5D49/Colosseum-Rome-Italy.jpg\",\n" +
            "      \"link\": \"\",\n" +
            "      \"title\": \"Colosseum\"\n" +
            "    }\n" +
            "  ]\n" +
            "}"
    }
}