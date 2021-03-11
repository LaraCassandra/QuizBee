package com.example.quizme

object Constants {

    // LAND QUESTIONS ARRAY
    fun getLandQuestions(): ArrayList<Question> {

        val landQuestionsList = ArrayList<Question>()

        val landQue1 = Question(
            1,
            "What is the largest land predator?",
            "African Lion",
            "Bengal Tiger",
            "Brown Bear",
            "Polar Bear"
        )

        val landQue2 = Question(
            2,
            "What dog is known as the 'barkless dog'?",
            "Samoyed",
            "Basset Hound",
            "Chihuahua",
            "Basenji"
        )

        val landQue3 = Question(
            3,
            "How long do sloths live in the wild?",
            "50 years",
            "100 years",
            "20 years",
            "It is not known"
        )

        // ADD QUESTIONS TO LAND QUESTION LIST
        landQuestionsList.add(landQue1)
        landQuestionsList.add(landQue2)
        landQuestionsList.add(landQue3)

        return landQuestionsList

    }


    // SEA QUESTIONS ARRAY
    fun getSeaQuestions(): ArrayList<Question> {

        val seaQuestionsList = ArrayList<Question>()

        val seaQue1 = Question(
            1,
            "What does shark skin feel like?",
            "Smooth and slimy",
            "Soft and furry",
            "Smooth and cold like ice",
            "Rough like sandpaper"
        )

        val seaQue2 = Question(
            2,
            "Where is a shrimps heart located?",
            "Butt",
            "Stomach",
            "Chest",
            "Head"
        )

        val seaQue3 = Question(
            3,
            "How many brains does an octopus have?",
            "Eight",
            "Two",
            "One",
            "Nine"
        )

        seaQuestionsList.add(seaQue1)
        seaQuestionsList.add(seaQue2)
        seaQuestionsList.add(seaQue3)

        return seaQuestionsList

    }

    // SKY QUESTIONS ARRAY
    fun getSkyQuestions(): ArrayList<Question> {

        val skyQuestionsList = ArrayList<Question>()

        val skyQue1 = Question(
            1,
            "What is a baby bat called?",
            "Batling",
            "Puppy",
            "Kid",
            "Pup"
        )

        val skyQue2 = Question(
            2,
            "How many sounds can a Mockingbird make?",
            "50-100",
            "100-250",
            "300-450",
            "250-300"
        )

        val skyQue3 = Question(
            3,
            "What bird makes the largest non-communal nest?",
            "Bush Turkey",
            "Social Weaver",
            "Black Vulture",
            "Bald Eagle"
        )

        skyQuestionsList.add(skyQue1)
        skyQuestionsList.add(skyQue2)
        skyQuestionsList.add(skyQue3)

        return skyQuestionsList

    }

    // GENERAL QUESTIONS ARRAY
    fun getGeneralQuestions(): ArrayList<Question> {

        val generalQuestionsList = ArrayList<Question>()

        val genQue1 = Question(
            1,
            "What animal hums in F note?",
            "Cricket",
            "Bumblebee",
            "Bee",
            "Housefly"
        )

        val genQue2 = Question(
            2,
            "What animal has the thickest fur in the world?",
            "Cow",
            "Arctic Fox",
            "Snow Leopard",
            "Sea Otter"
        )

        val genQue3 = Question(
            3,
            "What animals sleeps the longest?",
            "Brown bat",
            "Python",
            "Squirrel",
            "Koala"
        )

        generalQuestionsList.add(genQue1)
        generalQuestionsList.add(genQue2)
        generalQuestionsList.add(genQue3)

        return generalQuestionsList

    }

}