CREATE TABLE IF NOT EXISTS shortened_url (
    id SERIAL PRIMARY KEY,
    original_url TEXT NOT NULL,
    shortened_code TEXT,
    creation_date timestamptz NOT NULL
);