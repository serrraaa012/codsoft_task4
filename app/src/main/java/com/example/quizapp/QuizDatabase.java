package com.example.quizapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuizDatabase {
    private static QuizDatabase instance;
    private Map<String, QuizModel> quizzes;

    private QuizDatabase() {
        initializeQuizzes();
    }

    public static QuizDatabase getInstance() {
        if (instance == null) {
            instance = new QuizDatabase();
        }
        return instance;
    }

    private void initializeQuizzes() {
        quizzes = new HashMap<>();

        // ============================================
        // QUIZ 1: LUXURY & SUPERCARS (10 Questions)
        // ============================================
        List<QuestionModel> luxuryCarQuestions = new ArrayList<>();

        luxuryCarQuestions.add(new QuestionModel(
                "Which car brand uses a prancing horse logo?",
                Arrays.asList("Lamborghini", "Ferrari", "Porsche", "Maserati"),
                1
        ));

        luxuryCarQuestions.add(new QuestionModel(
                "What is the most expensive car ever sold at auction?",
                Arrays.asList("Bugatti La Voiture Noire", "Ferrari 250 GTO", "Rolls-Royce Boat Tail", "Lamborghini Veneno"),
                1
        ));

        luxuryCarQuestions.add(new QuestionModel(
                "Which car is known as the 'Fastest production car' with 300+ mph?",
                Arrays.asList("Bugatti Chiron", "Koenigsegg Jesko", "Hennessey Venom GT", "SSC Tuatara"),
                0
        ));

        luxuryCarQuestions.add(new QuestionModel(
                "Which country produces the most luxury sports cars?",
                Arrays.asList("Germany", "Italy", "USA", "UK"),
                0
        ));

        luxuryCarQuestions.add(new QuestionModel(
                "What is the top speed of the Bugatti Chiron Super Sport?",
                Arrays.asList("250 mph", "273 mph", "304 mph", "330 mph"),
                2
        ));

        luxuryCarQuestions.add(new QuestionModel(
                "Which luxury car brand is known for the 'Spirit of Ecstasy' hood ornament?",
                Arrays.asList("Bentley", "Rolls-Royce", "Aston Martin", "Jaguar"),
                1
        ));

        luxuryCarQuestions.add(new QuestionModel(
                "What did Lamborghini originally manufacture before cars?",
                Arrays.asList("Sports cars", "Tractors", "Motorcycles", "Aircraft engines"),
                1
        ));

        luxuryCarQuestions.add(new QuestionModel(
                "Which car is considered the first supercar?",
                Arrays.asList("Ferrari 250 GTO", "Lamborghini Miura", "Porsche 911", "Ford GT40"),
                1
        ));

        luxuryCarQuestions.add(new QuestionModel(
                "What is the 0-60 mph time of the Tesla Model S Plaid?",
                Arrays.asList("1.99 seconds", "2.5 seconds", "3.2 seconds", "4.0 seconds"),
                0
        ));

        luxuryCarQuestions.add(new QuestionModel(
                "Which brand owns Bugatti, Lamborghini, and Porsche?",
                Arrays.asList("Volkswagen Group", "Stellantis", "Geely", "Toyota Group"),
                0
        ));

        quizzes.put("luxury_cars", new QuizModel("luxury_cars", "Luxury & Supercars", luxuryCarQuestions));

        // ============================================
        // QUIZ 2: FORMULA 1 RACING (10 Questions)
        // ============================================
        List<QuestionModel> f1Questions = new ArrayList<>();

        f1Questions.add(new QuestionModel(
                "Who is the most successful F1 driver with 7 World Championships?",
                Arrays.asList("Ayrton Senna", "Lewis Hamilton", "Michael Schumacher", "Max Verstappen"),
                1
        ));

        f1Questions.add(new QuestionModel(
                "Which F1 team has won the most Constructors' Championships?",
                Arrays.asList("McLaren", "Ferrari", "Mercedes", "Red Bull"),
                1
        ));

        f1Questions.add(new QuestionModel(
                "What does 'DRS' stand for in F1 racing?",
                Arrays.asList("Drag Reduction System", "Dynamic Racing System", "Direct Racing Speed", "Digital Racing System"),
                0
        ));

        f1Questions.add(new QuestionModel(
                "Where is the famous Monaco Grand Prix held?",
                Arrays.asList("Monte Carlo", "Paris", "Nice", "Cannes"),
                0
        ));

        f1Questions.add(new QuestionModel(
                "What is the maximum speed of an F1 car approximately?",
                Arrays.asList("200 mph", "220 mph", "250 mph", "280 mph"),
                1
        ));

        f1Questions.add(new QuestionModel(
                "Who is the youngest F1 World Champion?",
                Arrays.asList("Max Verstappen", "Lewis Hamilton", "Sebastian Vettel", "Fernando Alonso"),
                2
        ));

        f1Questions.add(new QuestionModel(
                "What does 'Pit Stop' mean in F1?",
                Arrays.asList("Stopping for fuel and tires", "Stopping the race", "Parking the car", "Engine repair"),
                0
        ));

        f1Questions.add(new QuestionModel(
                "Which country has the most F1 Grand Prix wins?",
                Arrays.asList("Germany", "Great Britain", "Italy", "Brazil"),
                1
        ));

        f1Questions.add(new QuestionModel(
                "How many tires does an F1 car typically use in a race?",
                Arrays.asList("4", "8", "12", "16"),
                2
        ));

        f1Questions.add(new QuestionModel(
                "What is the 'Monza' circuit known for?",
                Arrays.asList("High-speed track in Italy", "Street circuit in Monaco", "Rainy races in Belgium", "Night race in Singapore"),
                0
        ));

        quizzes.put("f1_racing", new QuizModel("f1_racing", "Formula 1 Racing", f1Questions));

        // ============================================
        // QUIZ 3: CAR BRANDS & LOGOS (5 Questions)
        // ============================================
        List<QuestionModel> logoQuestions = new ArrayList<>();

        logoQuestions.add(new QuestionModel(
                "Which car brand has a three-pointed star logo?",
                Arrays.asList("BMW", "Mercedes-Benz", "Audi", "Porsche"),
                1
        ));

        logoQuestions.add(new QuestionModel(
                "Which brand uses a raging bull logo?",
                Arrays.asList("Ferrari", "Lamborghini", "Maserati", "Dodge"),
                1
        ));

        logoQuestions.add(new QuestionModel(
                "Which brand features four interlocking rings as its logo?",
                Arrays.asList("Mercedes-Benz", "Audi", "BMW", "Volkswagen"),
                1
        ));

        logoQuestions.add(new QuestionModel(
                "Which brand has a shield with a horse logo?",
                Arrays.asList("Ferrari", "Porsche", "Mustang", "Lamborghini"),
                1
        ));

        logoQuestions.add(new QuestionModel(
                "Which car brand uses a 'Roundel' (blue and white propeller) logo?",
                Arrays.asList("Mercedes-Benz", "BMW", "Audi", "Volkswagen"),
                1
        ));

        quizzes.put("car_logos", new QuizModel("car_logos", "Car Brands & Logos", logoQuestions));


    }

    public List<QuizModel> getAllQuizzes() {
        return new ArrayList<>(quizzes.values());
    }

    public QuizModel getQuizById(String quizId) {
        return quizzes.get(quizId);
    }
}