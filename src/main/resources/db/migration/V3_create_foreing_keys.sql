ALTER TABLE comments
ADD FOREIGN KEY (post_id) REFERENCES posts (id);

ALTER TABLE posts
ADD FOREIGN KEY (image_id) REFERENCES images (id),
ADD FOREIGN KEY (garden_id) REFERENCES gardens (id),
ADD FOREIGN KEY (plantation_id) REFERENCES plantations (id),
ADD FOREIGN KEY (tag_id) REFERENCES tags (id),
ADD FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE users
ADD FOREIGN KEY (image_id) REFERENCES images (id),
ADD FOREIGN KEY (state_id) REFERENCES states (id);


ALTER TABLE gardens
ADD FOREIGN KEY (residence_id) REFERENCES residences (id),
ADD FOREIGN KEY (producer_id) REFERENCES producers (id);

ALTER TABLE plantations
ADD FOREIGN KEY (cropType_id) REFERENCES crop_types (id),
ADD FOREIGN KEY (harvest_id) REFERENCES harvests (id),
ADD FOREIGN KEY (cropVariety_id) REFERENCES crop_varieties (id),
ADD FOREIGN KEY (plantationState_id) REFERENCES plantation_states (id),
ADD FOREIGN KEY (garden_id) REFERENCES gardens (id);

ALTER TABLE sowings
ADD FOREIGN KEY (plantation_id) REFERENCES plantations (id);

ALTER TABLE sowing_harvests
ADD FOREIGN KEY (sowing_id) REFERENCES sowings (id);

ALTER TABLE harvests
ADD FOREIGN KEY (crop_type_id) REFERENCES crop_types (id);

ALTER TABLE crop_varieties
ADD FOREIGN KEY (harvest_id) REFERENCES harvests (id);

ALTER TABLE residences
ADD FOREIGN KEY (country_id) REFERENCES countries (id),
ADD FOREIGN KEY (province_id) REFERENCES provinces (id),
ADD FOREIGN KEY (city_id) REFERENCES cities (id);

ALTER TABLE producers
ADD FOREIGN KEY (user_id) REFERENCES users (id),
ADD FOREIGN KEY (residence_id) REFERENCES residences (id);

ALTER TABLE kg_prices
ADD FOREIGN KEY (plantation_id) REFERENCES plantations (id);