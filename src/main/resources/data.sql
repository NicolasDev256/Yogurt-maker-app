INSERT INTO recipes (id, name, description, difficulty, active, 
                     heating_temperature, heating_duration, incubation_temperature, 
                     inoculation_temperature, min_incubation_time, max_incubation_time, 
                     refrigeration_time, default_milk_volume, default_starter_amount) 
VALUES
(1, 'Classic Yogurt', 'Traditional yogurt recipe', 'BEGINNER', true,
    42, 10, 42, 40, 480, 600, 120, 1000, 100),
(2, 'Greek Yogurt', 'Thick and creamy yogurt', 'INTERMEDIATE', true,
    43, 15, 43, 41, 600, 720, 120, 1200, 120),
(3, 'Mild Yogurt', 'Smooth and gentle flavor', 'BEGINNER', true,
    40, 8, 40, 38, 360, 480, 120, 900, 80);
