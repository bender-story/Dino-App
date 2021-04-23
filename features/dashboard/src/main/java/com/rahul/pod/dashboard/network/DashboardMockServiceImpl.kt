package com.rahul.pod.dashboard.network

import com.google.gson.Gson
import com.rahul.pod.dashboard.data.AllCategoriesDataResponse
import io.reactivex.Observable
import retrofit2.mock.BehaviorDelegate

class DashboardMockServiceImpl(private val delegate: BehaviorDelegate<DashboardServiceInterface>) : DashboardServiceInterface {

    override fun getDashboardData(): Observable<AllCategoriesDataResponse> {
        var json: String = getDashBoardMockData()

        val mockResponse = Gson().fromJson(json, AllCategoriesDataResponse::class.java)
        return delegate.returningResponse(mockResponse).getDashboardData()
    }

    private fun getDashBoardMockData(): String {
        return "{\n" +
                "  \"categories\": [\n" +
                "    {\n" +
                "      \"title\": \"Stories\",\n" +
                "      \"values\": [\n" +
                "        {\n" +
                "          \"value\": \"All\",\n" +
                "          \"imageURL\": \"https://i.dlpng.com/static/png/6285729-dinosaur-cartoon-png-triceratops-dinosaur-clipart-download-920-dinosaur-clipart-png-900_1020_preview.png\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"value\": \"Kids\",\n" +
                "          \"imageURL\": \"https://library.kissclipart.com/20181215/uqq/kissclipart-cute-cartoon-dinosaur-clipart-royalty-free-65715e2de95c1fb6.png\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Videos\",\n" +
                "      \"values\": [\n" +
                "        {\n" +
                "          \"value\": \"All\",\n" +
                "          \"imageURL\": \"https://i.dlpng.com/static/png/6285729-dinosaur-cartoon-png-triceratops-dinosaur-clipart-download-920-dinosaur-clipart-png-900_1020_preview.png\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"value\": \"Kids\",\n" +
                "          \"imageURL\": \"https://library.kissclipart.com/20181215/uqq/kissclipart-cute-cartoon-dinosaur-clipart-royalty-free-65715e2de95c1fb6.png\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Market\",\n" +
                "      \"values\": [\n" +
                "        {\n" +
                "          \"value\": \"All\",\n" +
                "          \"imageURL\": \"https://i.dlpng.com/static/png/6285729-dinosaur-cartoon-png-triceratops-dinosaur-clipart-download-920-dinosaur-clipart-png-900_1020_preview.png\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"value\": \"Kids\",\n" +
                "          \"imageURL\": \"https://library.kissclipart.com/20181215/uqq/kissclipart-cute-cartoon-dinosaur-clipart-royalty-free-65715e2de95c1fb6.png\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"value\": \"Coupons\",\n" +
                "          \"imageURL\": \"https://www.pinclipart.com/picdir/big/35-354448_dinosaurs-clipart-lime-green-cartoon-dinosaur-transparent-background.png\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}"
    }

}