-- data.sql

-- Insert data into 'language' table
	INSERT INTO language (id, name) VALUES (1, 'English');
	INSERT INTO language (id, name) VALUES (2, 'हिंदी');

-- Insert data into 'countries' table
	INSERT INTO countries (id, name, fk_language_id) VALUES (1, 'India', 1);
	INSERT INTO countries (id, name, fk_language_id) VALUES (2, 'भारत', 2);
	INSERT INTO countries (id, name, fk_language_id) VALUES (3, 'United States', 1);
	INSERT INTO countries (id, name, fk_language_id) VALUES (4, 'यूनाइटेड स्टेट्स', 2);

-- Insert data into 'states' table
	INSERT INTO states (id, name, fk_country_id, fk_language_id) VALUES (1, 'Gujarat', 1, 1);
	INSERT INTO states (id, name, fk_country_id, fk_language_id) VALUES (2, 'गुजरात', 2, 2);
	INSERT INTO states (id, name, fk_country_id, fk_language_id) VALUES (3, 'Florida', 3, 1);
	INSERT INTO states (id, name, fk_country_id, fk_language_id) VALUES (4, 'फ्लोरिडा', 4, 2);
	INSERT INTO states (id, name, fk_country_id, fk_language_id) VALUES (5, 'Ahmedabad', 1, 1);
	INSERT INTO states (id, name, fk_country_id, fk_language_id) VALUES (6, 'अहमदाबाद', 2, 2);

-- Insert data into 'cities' table
	INSERT INTO cities (id, name, fk_state_id, fk_language_id) VALUES (1, 'Valsad', 1, 1);
	INSERT INTO cities (id, name, fk_state_id, fk_language_id) VALUES (2, 'वलसाड', 2, 2);
	INSERT INTO cities (id, name, fk_state_id, fk_language_id) VALUES (3, 'Hollywood', 3, 1);
	INSERT INTO cities (id, name, fk_state_id, fk_language_id) VALUES (4, 'हॉलीवुड', 4, 2);
	INSERT INTO cities (id, name, fk_state_id, fk_language_id) VALUES (5, 'Vapi', 1, 1);
	INSERT INTO cities (id, name, fk_state_id, fk_language_id) VALUES (6, 'वापी', 2, 2);

-- Insert data into 'person' table
	INSERT INTO person (id, name, fk_language_fid, fk_city_fid, fk_country_fid, fk_state_fid) VALUES (1, 'Ashutosh', 1, 1, 1, 1);
	INSERT INTO person (id, name, fk_language_fid, fk_city_fid, fk_country_fid, fk_state_fid) VALUES (2, 'Patel', 2, 2, 2, 2);
